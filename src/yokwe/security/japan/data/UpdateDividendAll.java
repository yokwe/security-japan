package yokwe.security.japan.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.jpx.tdnet.Category;
import yokwe.security.japan.ufocatch.Atom;
import yokwe.security.japan.xbrl.inline.Document;
import yokwe.security.japan.xbrl.report.DividendReport;

//
// Make Dividend for download file from ufocatch 
//

public class UpdateDividendAll {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateDividendAll.class);
	
	public static void main(String[] args) {
		logger.info("START");
		
		List<DividendAll> list = new ArrayList<>();
		
		{
			List<File> fileList = Atom.getFileList(Category.EDJP);
			logger.info("fileList {}", fileList.size());
			
			int count = 0;
			for(File file: fileList) {
				if ((count % 1000) == 0) {
					logger.info("{} {}", String.format("%5d / %5d", count, fileList.size()), file.getName());
				}
				count++;

//				logger.info("File {}", file.getPath());
				Document document = Document.getInstance(file);
				try {
					DividendReport briefReport = DividendReport.getInstance(document);
					
					DividendAll divideneAll = new DividendAll(briefReport, file.getName());
					if (divideneAll.date.isEmpty()) continue;
					
					list.add(divideneAll);
				} catch(UnexpectedException e) {
					logger.error("file {}", file.getName());
					throw e;
				}
			}
		}
		
		logger.info("list {}", list.size());
		{
			Map<String, DividendAll> map = new TreeMap<>();
			
			for(DividendAll newValue: list) {
				String key = String.format("%s %s %s", newValue.stockCode, newValue.yearEnd, newValue.quarter);
				if (map.containsKey(key)) {
					DividendAll oldValue = map.get(key);
					if (newValue.equals(oldValue)) continue;
					
					logger.warn("====");
					logger.warn("Overwrite existing {}", key);
					logger.warn("  old {}", oldValue);
					logger.warn("  new {}", newValue);
				}
				map.put(key, newValue);
			}
			List<DividendAll> dividendList = new ArrayList<>(map.values());
			
			logger.info("save {}  {}", DividendAll.PATH_FILE, dividendList.size());
			DividendAll.save(dividendList);
		}

		logger.info("STOP");
	}
}
