package yokwe.security.japan.jpx;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.CSVUtil;
import yokwe.util.FileUtil;
import yokwe.util.HttpUtil;
import yokwe.util.libreoffice.Sheet;
import yokwe.util.libreoffice.SpreadSheet;

public class UpdateListedIssue {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateListedIssue.class);
	
	@Sheet.SheetName("Sheet1")
	@Sheet.HeaderRow(0)
	@Sheet.DataRow(1)
	public static class RawData extends Sheet {	
		@Sheet.ColumnName("日付")
		@Sheet.NumberFormat(SpreadSheet.FORMAT_INTEGER)
		public String date;
		
		@Sheet.ColumnName("コード")
		@Sheet.NumberFormat(SpreadSheet.FORMAT_INTEGER)
		public String stockCode;
		
		@Sheet.ColumnName("銘柄名")
		public String name;
		
		@Sheet.ColumnName("市場・商品区分")
		public String market;
		
		@Sheet.ColumnName("33業種コード")
		@Sheet.NumberFormat(SpreadSheet.FORMAT_INTEGER)
		public String sector33Code;
		
		@Sheet.ColumnName("33業種区分")
		public String sector33;
		
		@Sheet.ColumnName("17業種コード")
		@Sheet.NumberFormat(SpreadSheet.FORMAT_INTEGER)
		public String sector17Code;
		
		@Sheet.ColumnName("17業種区分")
		public String sector17;
		
		@Sheet.ColumnName("規模コード")
		@Sheet.NumberFormat(SpreadSheet.FORMAT_INTEGER)
		public String scaleCode;
		
		@Sheet.ColumnName("規模区分")
		public String scale;
	}


	public static void main(String[] args) {
		logger.info("START");
		
		logger.info("download {}", ListedIssue.URL_DOWNLOAD);
		HttpUtil http = HttpUtil.getInstance().withRawData(true);
		HttpUtil.Result result = http.download(ListedIssue.URL_DOWNLOAD);
		
		logger.info("write {} {}", ListedIssue.PATH_DOWNLOAD, result.rawData.length);
		FileUtil.write().file(ListedIssue.PATH_DOWNLOAD, result.rawData);
		
		String url;
		try {
			url = new File(ListedIssue.PATH_DOWNLOAD).toURI().toURL().toString();
		} catch (MalformedURLException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
		logger.info("open {}", url);
		
		try (SpreadSheet docListedIssue = new SpreadSheet(url, true)) {
			List<RawData> rawDataList = Sheet.extractSheet(docListedIssue, RawData.class);
			logger.info("read {}", rawDataList.size());
			
			// Trim space
			List<ListedIssue> newList = new ArrayList<>(rawDataList.size());
			for(RawData value: rawDataList) {
				ListedIssue newValue = new ListedIssue();
				
				String date = value.date.trim();
				if (date.length() != 8) {
					logger.error("Unpexpected date value {}!", date);
					throw new UnexpectedException("Unpexpected date value");
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
			
			// Sort before write
			Collections.sort(newList);
			
			logger.info("write {} {}", ListedIssue.PATH_DATA, newList.size());
			CSVUtil.write(ListedIssue.class).file(ListedIssue.PATH_DATA, newList);
		}
		
		logger.info("STOP");
	}
}
