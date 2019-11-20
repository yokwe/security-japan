package yokwe.security.japan.jpx;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;

import yokwe.util.CSVUtil;
import yokwe.util.FileUtil;
import yokwe.util.HttpUtil;
import yokwe.util.libreoffice.Sheet;
import yokwe.util.libreoffice.SpreadSheet;

public class UpdateListedIssue {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateListedIssue.class);

	public static void main(String[] args) throws MalformedURLException {
		logger.info("START");
		
		logger.info("download {}", ListedIssue.URL_DOWNLOAD);
		HttpUtil http = HttpUtil.getInstance().withRawData(true);
		HttpUtil.Result result = http.download(ListedIssue.URL_DOWNLOAD);
		
		logger.info("write {} {}", ListedIssue.PATH_DOWNLOAD, result.rawData.length);
		FileUtil.write().file(ListedIssue.PATH_DOWNLOAD, result.rawData);
		
		String url  = new File(ListedIssue.PATH_DOWNLOAD).toURI().toURL().toString();
		logger.info("open {}", url);
		
		try (SpreadSheet docListedIssue = new SpreadSheet(url, true)) {
			List<ListedIssue> list = Sheet.extractSheet(docListedIssue, ListedIssue.class);
			logger.info("read {}", list.size());
			
			// Trim space
			List<ListedIssue> newList = new ArrayList<>(list.size());
			for(ListedIssue value: list) {
				ListedIssue newValue = new ListedIssue();
				
				newValue.date         = value.date.trim();
				newValue.stockCode    = value.stockCode.trim();
				newValue.name         = value.name.trim();
				newValue.market       = value.market.trim();
				newValue.sector33Code = value.sector33Code.trim();
				newValue.sector33     = value.sector33.trim();
				newValue.sector17Code = value.sector17Code.trim();
				newValue.sector17     = value.sector17.trim();
				newValue.scale        = value.scale.trim();
				newValue.scaleCode    = value.scaleCode.trim();
				
				newList.add(newValue);
			}
			
			// Sort before write
			Collections.sort(newList);
			
			logger.info("write {} {}", ListedIssue.PATH_DATA, list.size());
			CSVUtil.write(ListedIssue.class).file(ListedIssue.PATH_DATA, newList);
		}
		
		logger.info("STOP");
	}
}
