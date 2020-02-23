package yokwe.security.japan.data;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.jpx.tdnet.Category;
import yokwe.security.japan.jpx.tdnet.SummaryFilename;
import yokwe.security.japan.ufocatch.Atom;
import yokwe.security.japan.xbrl.inline.Document;
import yokwe.security.japan.xbrl.report.StockReport;

//
//Update reit-report.csv
//

public class UpdateStockReport {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateStockReport.class);
	
	public static void main(String[] args) {
		logger.info("START");
		
		{
			Map<SummaryFilename, StockReport> reportMap = StockReport.getMap();
			logger.info("reportMap {}", reportMap.size());

			Map<SummaryFilename, File> fileMap = Atom.getFileMap();
			logger.info("fileMap   {}", fileMap.size());
			

			List<File> fileList = new ArrayList<>();
			{
				List<SummaryFilename> keyList = fileMap.keySet().stream().filter(o -> o.category == Category.EDJP).collect(Collectors.toList());
				Collections.sort(keyList);
				
				for(SummaryFilename key: keyList) {
					File file = fileMap.get(key);
					fileList.add(file);
				}
				
				logger.info("fileList  {}", fileList.size());
			}
			
			int count = 0;
			int countUpdate = 0;
			List<StockReport> reportList = new ArrayList<>();
			{
				for(File file: fileList) {
					if ((count % 1000) == 0) {
//						logger.info("{} {}", String.format("%5d / %5d", count, fileList.size()), file.getName());
					}
					count++;
					
					final SummaryFilename filename = SummaryFilename.getInstance(file.getName());
					final StockReport report;
					
					if (reportMap.containsKey(filename)) {
						report = reportMap.get(filename);
					} else {
						countUpdate++;
						logger.info("update {}", filename);
						Document document = Document.getInstance(file);
						try {
							report = StockReport.getInstance(document);
							reportList.add(report);
						} catch(UnexpectedException e) {
							logger.error("file {}", file.getName());
							throw e;
						}
					}

					reportList.add(report);
				}
				
			}
			
			logger.info("count {} / {}", countUpdate, count);
			if (0 < countUpdate) {
				logger.info("save {} {}", StockReport.PATH_FILE, reportList.size());
				StockReport.save(reportList);
			}

		}

		logger.info("STOP");
	}
}
