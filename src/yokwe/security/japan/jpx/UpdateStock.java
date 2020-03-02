package yokwe.security.japan.jpx;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.FileUtil;
import yokwe.util.HashCode;
import yokwe.util.HttpUtil;
import yokwe.util.StringUtil;
import yokwe.util.libreoffice.Sheet;
import yokwe.util.libreoffice.SpreadSheet;

public class UpdateStock {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateStock.class);
	
	private static void processRequest() {
		logger.info("download {}", Stock.URL_DOWNLOAD);
		HttpUtil http = HttpUtil.getInstance().withRawData(true);
		HttpUtil.Result result = http.download(Stock.URL_DOWNLOAD);
		
		// Check file and download contents
		{
			boolean needsWrite = true;
			File file = new File(Stock.PATH_DOWNLOAD);
			if (file.exists()) {
				final String hashOfDownload       = StringUtil.toHexString(HashCode.getHashCode(result.rawData));
				final String hashOfDownlaodedFile = StringUtil.toHexString(HashCode.getHashCode(new File(Stock.PATH_DOWNLOAD)));

				if (hashOfDownlaodedFile.equals(hashOfDownload)) {
					logger.info("Download same contents {}", hashOfDownload);
					logger.info("  download  {}  {}", result.rawData.length, hashOfDownload);
					logger.info("  file      {}  {}", file.length(), hashOfDownlaodedFile);
					
					// if file and download has same contents, no needs to write
					needsWrite = false;
				}
			}
			
			if (needsWrite) {
				logger.info("write {} {}", Stock.PATH_DOWNLOAD, result.rawData.length);
				FileUtil.rawWrite().file(Stock.PATH_DOWNLOAD, result.rawData);
			}
		}

		String url;
		try {
			url = new File(Stock.PATH_DOWNLOAD).toURI().toURL().toString();
		} catch (MalformedURLException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
		logger.info("open {}", url);
		
		List<Stock> newList = new ArrayList<>();
		
		// Build newList
		try (SpreadSheet spreadSheet = new SpreadSheet(url, true)) {
			List<Stock> rawDataList = Sheet.extractSheet(spreadSheet, Stock.class);
			logger.info("read {}", rawDataList.size());
			
			// Trim space
			for(Stock value: rawDataList) {
				Stock newValue = new Stock();
				
				String date = value.date.trim();
				if (date.length() != 8) {
					logger.error("Unexpected date value {}!", date);
					throw new UnexpectedException("Unexpected date value");
				}
				String newDate = String.format("%s-%s-%s", date.substring(0, 4), date.substring(4, 6), date.substring(6, 8));
				
				newValue.date         = newDate;
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
			
			// Sanity check
			if (newList.isEmpty()) {
				logger.error("Empty data");
				throw new UnexpectedException("Empty data");
			}
			
			// Save if necessary
			{
				boolean sameData = false;
				String  newDate  = newList.get(0).date;
				
				List<Stock> oldList = Stock.load();
				if (oldList == null) {
					sameData = false;
				} else {
					// check date of first data
					String oldDate = oldList.get(0).date;
					sameData = newDate.equals(oldDate);
				}
				
				if (sameData) {
					logger.warn("same data  {}  {}", newDate, newList.size());
				} else {
					logger.info("write {}  {}  {}", newDate, newList.size(), Stock.PATH_DATA);
					Stock.save(newList);
				}
			}
		}
	}

	public static void main(String[] args) {
		logger.info("START");
		
		processRequest();
		
		logger.info("STOP");
		System.exit(0);
	}
}
