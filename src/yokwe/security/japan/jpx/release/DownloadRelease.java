package yokwe.security.japan.jpx.release;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import yokwe.util.FileUtil;

public class DownloadRelease {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadRelease.class);
	
	public static void main(String[] args) {
		logger.info("START");
		
		Map<String, Release> map = Release.getMap();
		logger.info("map {}", map.size());

		LocalDate date = LocalDate.now();
		{
			for(;;) {
				Page page = Page.getInstance(date);
				if (page == null) break;
				logger.info("page {}", page);
				for(Release e: page.entryList) {
//					logger.info("  {}", e);
					
//					{
//						String filename = String.format("%s.pdf", e.id);
//						File file = Release.getDataFile(date, filename);
//
//						if (!file.exists()) {
//							logger.info("file {}", file.getPath());
//							byte[] content  = Release.downloadData(e.pdf);
//							FileUtil.rawWrite().file(file, content);
//						}
//					}
					{
						if (!e.xbrl.isEmpty()) {
							String filename = String.format("%s.zip", e.id);
							File file = Release.getDataFile(date, filename);

							if (!file.exists()) {
								logger.info("file {}", file.getPath());
								byte[] content  = Release.downloadData(e.xbrl);
								FileUtil.rawWrite().file(file, content);
							}
						}
					}

					map.put(e.id, e);
				}
				date = date.minusDays(1);
			}
		}
		
		{
			List<Release> list = new ArrayList<>(map.values());
			logger.info("save {} {}", Release.PATH_FILE, list.size());
			Release.save(list);
		}
		
		logger.info("STOP");
	}
}
