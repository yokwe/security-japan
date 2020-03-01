package yokwe.security.japan.ufocatch;

import java.io.File;
import java.util.Map;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.tdnet.SummaryFilename;
import yokwe.security.japan.tdnet.TDNET;
import yokwe.security.japan.ufocatch.atom.Entry;
import yokwe.security.japan.ufocatch.atom.Feed;
import yokwe.security.japan.ufocatch.atom.Link;
import yokwe.util.FileUtil;
import yokwe.util.HttpUtil;

public class DownloadUFOCatch {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadUFOCatch.class);
	
	//
	// Download atom feed of ufocatch
	//
	
	public static void main(String[] args) {
		logger.info("START");
		
		boolean stopAtSkip = Boolean.getBoolean("stopAtSkip");
		logger.info("stopAtSkip {}", stopAtSkip);

		Map<SummaryFilename, File> fileMap = TDNET.getFileMap();
		logger.info("fileMap {}", fileMap.size());

		Feed rootFeed = Atom.getFeed(Kind.TDNETX);
		
		HttpUtil httpUtil = HttpUtil.getInstance();
				
		int countSave = 0;
		int countSkip = 0;
		int countPass = 0;
				
		Feed feed = rootFeed;
		{
			Link first = feed.linkMap.get(Link.Relation.FIRST);
			Link last  = feed.linkMap.get(Link.Relation.LAST);

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
				Link self = feed.linkMap.get(Link.Relation.SELF);
				Link last = feed.linkMap.get(Link.Relation.LAST);

				selfString = self.href.substring(self.href.lastIndexOf("/") + 1);
				lastString = last.href.substring(last.href.lastIndexOf("/") + 1);
			}
			logger.info("{}", String.format("%3s / %3s", selfString, lastString));

			int lastCountSave = countSave;
			for(Entry entry: feed.entryList) {
				count++;
				for(Link link: entry.linkList) {
					SummaryFilename filename = SummaryFilename.getInstance(link.href);
					if (filename == null) {
						countPass++;
					} else {
						if (fileMap.containsKey(filename)) {
							countSkip++;
						} else {
							countSave++;
							logger.info("{}  Save file {}", String.format("%3s / %3s - %3d / %3d",selfString, lastString, count, entryListSize), filename);
							HttpUtil.Result result = httpUtil.download(link.href);
							if (result.result == null) {
								logger.error("Unable to download {}", link.href);
								throw new UnexpectedException("Unable to download");
							} else {
								FileUtil.write().file(TDNET.getPath(filename), result.result);
							}
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
			
			if (feed.linkMap.containsKey(Link.Relation.NEXT)) {
				Link next = feed.linkMap.get(Link.Relation.NEXT);
				feed = Atom.getFeed(next.href);
				continue;
			}
			
			break;
		}
		logger.info("countSave {}", countSave);
		logger.info("countSkip {}", countSkip);
		logger.info("countPass {}", countPass);
		
		// touch tmp/data/tdnet.touch
		if (0 < countSave) {
			TDNET.touch();
		}
		logger.info("STOP");
	}
}
