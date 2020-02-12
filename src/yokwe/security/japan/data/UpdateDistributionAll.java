package yokwe.security.japan.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.jpx.Category;
import yokwe.security.japan.ufocatch.Atom;
import yokwe.security.japan.xbrl.inline.Document;
import yokwe.security.japan.xbrl.report.DistributionReport;
import yokwe.util.DoubleUtil;
import yokwe.util.XMLUtil;

//
// Make Dividend for download file from ufocatch 
//

public class UpdateDistributionAll {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateDistributionAll.class);
	
	public static void main(String[] args) {
		logger.info("START");
		
		List<DistributionAll> list = new ArrayList<>();
		
		{
			List<File> fileList = Atom.getFileList(Category.REJP);
			logger.info("fileList {}", fileList.size());
			
			int count = 0;
			for(File file: fileList) {
				if ((count % 1000) == 0) {
					logger.info("{} {}", String.format("%5d / %5d", count, fileList.size()), file.getName());
				}
				count++;

//				logger.info("File {}", file.getPath());
				Document document = Document.getInstance(XMLUtil.buildStream(file));
				try {
					DistributionReport report = DistributionReport.getInstance(document);
					
					DistributionAll distributionAll = new DistributionAll(report, file.getName());
					if (distributionAll.date.isEmpty()) continue;
					if (DoubleUtil.isAlmostZero(distributionAll.distribution) && DoubleUtil.isAlmostZero(distributionAll.distributionExcess)) continue;
					
					list.add(distributionAll);
				} catch(UnexpectedException e) {
					logger.error("file {}", file.getName());
					throw e;
				}
			}
		}
		
		logger.info("list {}", list.size());
		{
			Map<String, DistributionAll> map = new TreeMap<>();
			
			for(DistributionAll newValue: list) {
				String key = String.format("%s %s %s", newValue.stockCode, newValue.yearEnd, newValue.date);
				if (map.containsKey(key)) {
					DistributionAll oldValue = map.get(key);
					if (newValue.equals(oldValue)) continue;
					
					logger.warn("====");
					logger.warn("Overwrite existing {}", key);
					logger.warn("  old {}", oldValue);
					logger.warn("  new {}", newValue);
				}
				map.put(key, newValue);
			}
			List<DistributionAll> dividendList = new ArrayList<>(map.values());
			
			logger.info("save {}  {}", DistributionAll.PATH_FILE, dividendList.size());
			DistributionAll.save(dividendList);
		}

		logger.info("STOP");
	}
}
