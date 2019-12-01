package yokwe.security.japan.xbrl;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.JAXB;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.xbrl.label.Linkbase;
import yokwe.util.FileUtil;

public class UpdateLabel {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateLabel.class);

	private static class PathInfo {
		final String namespace;
		final String path;
		
		PathInfo(String namespace, String path) {
			this.namespace = namespace;
			this.path      = path;
		}
	}
	private static final List<PathInfo> pathInfolist= new ArrayList<>();
	static {
		pathInfolist.add(new PathInfo(XBRL.NS_TSE_ED_T, "tmp/61_taxonomy/tse-ed-2014-01-12/taxonomy/jp/tse/tdnet/ed/t/2014-01-12/tse-ed-t-2014-01-12-lab.xml"));
		pathInfolist.add(new PathInfo(XBRL.NS_TSE_ED_T, "tmp/61_taxonomy/tse-ed-2014-01-12/taxonomy/jp/tse/tdnet/ed/t/2014-01-12/tse-ed-t-2014-01-12-lab-en.xml"));
	}

	public static void main(String[] args) {
		logger.info("START");
		
		List<Label> labelList = new ArrayList<>();
		
		for(PathInfo pathInfo: pathInfolist) {
			List<Label> list = new ArrayList<>();
			
			String   namespace = pathInfo.namespace;
			String   data = FileUtil.read().file(pathInfo.path);
			Linkbase linkbase = JAXB.unmarshal(new StringReader(data), Linkbase.class);
			
			Map<String, String> labelArcMap = new TreeMap<>();
			//  to      from
			for(yokwe.security.japan.xbrl.label.LabelArc labelArc: linkbase.labelLink.labelArcList) {
				if (labelArcMap.containsKey(labelArc.to)) {
					logger.error("Duplicate tlabelArc.to {}", labelArc);
					throw new UnexpectedException("Duplicate tlabelArc.to");
				} else {
					labelArcMap.put(labelArc.to, labelArc.from);
				}
			}
			Map<String, String> locMap = new TreeMap<>();
			//  label   href
			for(yokwe.security.japan.xbrl.label.Loc loc: linkbase.labelLink.locList) {
				if (locMap.containsKey(loc.label)) {
					logger.error("Duplicate loc.label {}", loc);
					throw new UnexpectedException("Duplicate loc.label");
				} else {
					locMap.put(loc.label, loc.href);
				}
			}
			
			String hrefPrefix = "#tse-ed-t_";
			for(yokwe.security.japan.xbrl.label.Label label: linkbase.labelLink.labelList) {
				String locLabel = labelArcMap.get(label.label);
				String href = locMap.get(locLabel);
				int pos = href.indexOf(hrefPrefix);
				list.add(new Label(namespace, href.substring(pos + hrefPrefix.length()), label.role.value, label.lang.value, label.value));
			}
			logger.info("{} {} {}", pathInfo.namespace, list.size(), pathInfo.path);
			labelList.addAll(list);
		}
		
		// Sort before save
		Collections.sort(labelList);
		
		// Save
		logger.info("Total {}", labelList.size());
		Label.save(labelList);
		
		logger.info("STOP");
	}
}
