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
import yokwe.security.japan.jpx.TDNET;
import yokwe.security.japan.jpx.TDNET.EarningDigest;
import yokwe.security.japan.ufocatch.atom.Entry;
import yokwe.security.japan.ufocatch.atom.Feed;
import yokwe.security.japan.ufocatch.atom.Link;
import yokwe.util.FileUtil;
import yokwe.util.HttpUtil;

public class DownloadAll {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadAll.class);
	
	//
	// Download atom feed of ufocatch
	//
	
	private static String getFileName(String href) {
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
		
		Map<String, File> existingFileMap = Atom.getExistingFileMap();
		logger.info("existingFileMap {}", existingFileMap.size());

		String rootPage = Atom.query(Atom.Kind.TDNETX, "");
		Feed rootFeed = JAXB.unmarshal(new StringReader(rootPage), Feed.class);
				
		int countEntry = 0;
		int countEDJP  = 0;
		
		boolean stopAtFirstSkip = false;
		
		Feed feed = rootFeed;
		{
			Map<Link.Relation, Link> linkMap = Atom.getLinkMap(feed.linkList);
			Link first = linkMap.get(Link.Relation.FIRST);
			Link last  = linkMap.get(Link.Relation.LAST);
			Link self  = linkMap.get(Link.Relation.SELF);

			logger.info("FIRST {}", first.href);
			logger.info("LAST  {}", last.href);
			logger.info("SELF  {}", self.href);
		}
		for(;;) {
			int count = 0;
			int entryListSize = feed.entryList.size();
			
			for(Entry entry: feed.entryList) {
				count++;
				countEntry++;
				for(Link link: entry.linkList) {
					EarningDigest earningDigest = EarningDigest.getInstance(link.href);
					if (earningDigest != null) {
						if (earningDigest.category == TDNET.Category.EDJP) {
//							logger.info("    link  {} {} {}", link.rel, String.format("%-4s", link.type), link.href);
							countEDJP++;
							
							String fileName = getFileName(link.href);
							if (existingFileMap.containsKey(fileName)) {
								// Skip
								logger.info("{} / {}  Skip file {}", count, entryListSize, fileName);
								stopAtFirstSkip = true;
								logger.info("stop at first skip");
								break;
							} else {
								HttpUtil.Result result = HttpUtil.getInstance().download(link.href);
								if (result.result == null) {
									logger.error("Unable to download {}", link.href);
								} else {
									logger.info("{} / {}  Save file {}", count, entryListSize, fileName);
									FileUtil.write().file(Atom.getPath(fileName), result.result);
								}
							}
						}
					}
				}
				if (stopAtFirstSkip) break;
			}
			if (stopAtFirstSkip) break;
			
			{
				Map<Link.Relation, Link> linkMap = Atom.getLinkMap(feed.linkList);			
				Link self = linkMap.get(Link.Relation.SELF);
				logger.info("SELF  {}", self.href);

				//
				if (linkMap.containsKey(Link.Relation.NEXT)) {
					Link next = linkMap.get(Link.Relation.NEXT);
					HttpUtil.Result result = HttpUtil.getInstance().download(next.href);
					feed = JAXB.unmarshal(new StringReader(result.result), Feed.class);
					continue;
				}
			}
			
			break;
		}
		logger.info("countEntry {}", countEntry);
		logger.info("countEDJP  {}", countEDJP);
		logger.info("STOP");
	}
}
