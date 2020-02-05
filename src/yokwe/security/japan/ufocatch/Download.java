package yokwe.security.japan.ufocatch;

import java.io.File;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.xml.bind.JAXB;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.jpx.FinancialSummary;
import yokwe.security.japan.ufocatch.atom.Entry;
import yokwe.security.japan.ufocatch.atom.Feed;
import yokwe.security.japan.ufocatch.atom.Link;
import yokwe.util.FileUtil;
import yokwe.util.HttpUtil;

public class Download {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(Download.class);
	
	//
	// Download atom feed of ufocatch
	//
	
	private static String getFilename(String href) {
		try {
			URL url = new URL(href);
			Path path = Paths.get(url.getPath());
			return path.getFileName().toString();
		} catch (MalformedURLException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
	}
	public static void main(String[] args) {
		logger.info("START");
		
		boolean stopAtSkip = Boolean.getBoolean("stopAtSkip");
		logger.info("stopAtSkip {}", stopAtSkip);

		Map<FinancialSummary, File> fileMap = Atom.getFileMap();
		logger.info("fileMap {}", fileMap.size());

		String rootPage = Atom.query(Atom.Kind.TDNETX, "");
		Feed rootFeed = JAXB.unmarshal(new StringReader(rootPage), Feed.class);
		
		HttpUtil httpUtil = HttpUtil.getInstance();
				
		int countSave = 0;
		int countSkip = 0;
		int countPass = 0;
				
		Feed feed = rootFeed;
		{
			Map<Link.Relation, Link> linkMap = Atom.getLinkMap(feed.linkList);
			Link first = linkMap.get(Link.Relation.FIRST);
			Link last  = linkMap.get(Link.Relation.LAST);

			logger.info("FIRST {}", first.href);
			logger.info("LAST  {}", last.href);
		}
		
main_loop:
		for(;;) {
			int count = 0;
			int entryListSize = feed.entryList.size();
			
			String selfString;
			String lastString;
			{
				Map<Link.Relation, Link> linkMap = Atom.getLinkMap(feed.linkList);
				Link self = linkMap.get(Link.Relation.SELF);
				Link last = linkMap.get(Link.Relation.LAST);

				selfString = self.href.substring(self.href.lastIndexOf("/") + 1);
				lastString = last.href.substring(last.href.lastIndexOf("/") + 1);
			}
			logger.info("{}", String.format("%3s / %3s", selfString, lastString));

			int lastCountSave = countSave;
			for(Entry entry: feed.entryList) {
				count++;
				for(Link link: entry.linkList) {
					String filename = getFilename(link.href);
					FinancialSummary financialSummary = FinancialSummary.getInstance(filename);
					if (financialSummary != null) {
						if (fileMap.containsKey(financialSummary)) {
							countSkip++;
						} else {
							countSave++;
							logger.info("{}  Save file {}", String.format("%3s / %3s - %3d / %3d",selfString, lastString, count, entryListSize), filename);
							HttpUtil.Result result = httpUtil.download(link.href);
							if (result.result == null) {
								logger.error("Unable to download {}", link.href);
								throw new UnexpectedException("Unable to download");
							} else {
								FileUtil.write().file(Atom.getPath(filename), result.result);
							}
						}
					} else {
						countPass++;
						if (filename.startsWith("tse-") && filename.endsWith("-ixbrl.htm")) {
							logger.error("Unexpected filename pattern {}", filename);
							throw new UnexpectedException("Unexpected filename pattern");
						}
					}
				}
			}
			if (lastCountSave == countSave) {
				if (stopAtSkip) {
					logger.info("stop at skip");
					break main_loop;
				}
			}
			
			{
				Map<Link.Relation, Link> linkMap = Atom.getLinkMap(feed.linkList);			
				if (linkMap.containsKey(Link.Relation.NEXT)) {
					Link next = linkMap.get(Link.Relation.NEXT);
					HttpUtil.Result result = httpUtil.download(next.href);
					feed = JAXB.unmarshal(new StringReader(result.result), Feed.class);
					continue;
				}
			}
			
			break;
		}
		logger.info("countSave {}", countSave);
		logger.info("countSkip {}", countSkip);
		logger.info("countPass {}", countPass);
		logger.info("STOP");
	}
}
