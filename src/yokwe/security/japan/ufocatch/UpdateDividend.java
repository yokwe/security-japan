package yokwe.security.japan.ufocatch;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.xbrl.DividendBriefReport;
import yokwe.security.japan.xbrl.InlineXBRL;
import yokwe.util.CSVUtil;
import yokwe.util.XMLUtil;

//
// Make Dividend for download file from ufocatch 
//

public class UpdateDividend {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateDividend.class);
	
	public static final String PATH_FILE = "tmp/data/dividend.csv";
	
	public static void main(String[] args) {
		logger.info("START");
		
		List<Dividend> list = new ArrayList<>();
		
		{
			List<File> fileList = Atom.getExistingFileList();
			logger.info("fileList {}", fileList.size());
			
			int count = 0;
			for(File file: fileList) {
				if ((count % 1000) == 0) {
					logger.info("{} {}", String.format("%5d / %5d", count, fileList.size()), file.getName());
				}
				count++;

//				logger.info("File {}", file.getPath());
				InlineXBRL.Document document = InlineXBRL.Document.getInstance(XMLUtil.buildStream(file));
				DividendBriefReport briefReport = DividendBriefReport.getInstance(document);
				if (briefReport.dividendPayableDateAsPlanned == null) continue;
				if (briefReport.dividendPerShare == null) continue;
				
				list.add(new Dividend(briefReport, file.getName()));
			}
			Collections.sort(list);
		}
		
		logger.info("list {}", list.size());
		{
			Map<String, Dividend> map = new TreeMap<>();
			
			for(Dividend newValue: list) {
				String key = String.format("%s %s %s", newValue.stockCode, newValue.yearEnd, newValue.quarter);
				if (map.containsKey(key)) {
					Dividend oldValue = map.get(key);
					if (newValue.equals(oldValue)) continue;
					
					logger.warn("====");
					logger.warn("Overwrite existing {}", key);
					logger.warn("  old {}", oldValue);
					logger.warn("  new {}", newValue);
				}
				map.put(key, newValue);
			}
			List<Dividend> dividendList = new ArrayList<>(map.values());
			Collections.sort(dividendList);
			
			logger.info("save {}  {}", PATH_FILE, dividendList.size());
			CSVUtil.write(Dividend.class).file(PATH_FILE, dividendList);
		}

		logger.info("STOP");
	}
}
