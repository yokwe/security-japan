package yokwe.security.japan.jpx;

import java.io.File;
import java.util.regex.Pattern;

import org.slf4j.LoggerFactory;

import yokwe.util.FileUtil;
import yokwe.util.ScrapeUtil;

public class StockPage {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(StockPage.class);
	
	// 会社基本情報  コード ISINコード 業種 所属部
	public static class CompanyInfo {
		public static final Pattern PAT = Pattern.compile(
				"<tr>\\s+" +
				"<td .+?><font .+?>コード</font></td>\\s+" +
				"<td .+?><font .+?>ISINコード</font></td>\\s+" +
				"<td .+?><font .+?>業種</font></td>\\s+" +
				"<td .+?><font .+?>所属部</font></td>\\s+" +
				"</tr>\\s+" +
				"<tr>\\s+" +
				"<td .+?><p><font .+?>(?<code>.+?)<br></font></p></td>\\s+" +
				"<td .+?><font .+?>(?<isin>[A-Z0-9]+)<br></font></td>\\s+" +
				"<td .+?><font .+?>(?<industry>.+?)<br></font></td>\\s+" +
				"<td .+?><font .+?>(?<category>.+?)<br></font></td>\\s+" +
				"</tr>"
		);
		
		public final String code;
		public final String isin;
		public final String industry;
		public final String category;
		
		public CompanyInfo(String code, String isin, String industry, String category) {
			this.code     = code;
			this.isin     = isin;
			this.industry = industry;
			this.category = category.replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s %s %s %s}", code, isin, industry, category);
		}
	}

	// 現在値
	public static class PriceValueTime {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><b>現在値 \\(時刻\\)</b></td>\\s*" +
			"<td .+?><b>(?<value>[0-9,.]*) \\((?<time>.+?)\\)</b></td>\\s*"
		);
		
		public final String value;
		public final String time;
		
		public PriceValueTime(String value, String time) {
			// remove comma
			this.value = value.replace(",", "");
			// remove &nbsp;&nbsp;
			this.time  = time.equals("&nbsp;&nbsp;") ? "" : time;
		}
		
		@Override
		public String toString() {
			return String.format("{%s,%s}", value, time);
		}
	}

	// 売り気配値
	public static class SellValueTime {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売り気配値 \\(時刻\\)</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.+?) \\((?<time>.+?)\\)</font></td>\\s*"
		);
		public final String value;
		public final String time;
		
		public SellValueTime(String value, String time) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
			// remove &nbsp;&nbsp;
			this.time  = time.equals("&nbsp;&nbsp;") ? "" : time;
		}
		
		@Override
		public String toString() {
			return String.format("{%s,%s}", value, time);
		}
	}

	// 買い気配値
	public static class BuyValueTime {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>買い気配値 \\(時刻\\)</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.+?) \\((?<time>.+?)\\)</font></td>\\s*"
		);
		
		public final String value;
		public final String time;
		
		public BuyValueTime(String value, String time) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
			// remove &nbsp;&nbsp;
			this.time  = time.equals("&nbsp;&nbsp;") ? "" : time;
		}
		
		@Override
		public String toString() {
			return String.format("{%s,%s}", value, time);
		}
	}
	
	// 始値
	public static class OpenValue {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>始値</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		
		public final String value;
		
		public OpenValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 高値
	public static class HighValue {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>高値</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		
		public final String value;
		
		public HighValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}
	
	// 安値
	public static class LowValue {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>安値</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		
		public final String value;
		
		public LowValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 売買高
	public static class VolumeValue {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売買高</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)株<br></font></td>\\s*"
		);
		
		public final String value;
		
		public VolumeValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 売買代金
	public static class TradeValue {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売買代金</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		
		public final String value;
		
		public TradeValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 発行済株式数
	public static class IssuedValue {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>発行済株式数</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		
		public final String value;
		
		public IssuedValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	public static void main(String[] args) {
		logger.info("START");
		
		{
			for(File file: FileUtil.listFile(DownloadStockPage.PATH_DIR_DATA)) {
				String string = FileUtil.read().file(file);

				logger.info("file  {}", file.getName());
				logger.info("  companyInfo    {}", ScrapeUtil.getInstance(CompanyInfo.class,    string));
				logger.info("  priceValueTime {}", ScrapeUtil.getInstance(PriceValueTime.class, string));
				logger.info("  sellValueTime  {}", ScrapeUtil.getInstance(SellValueTime.class,  string));
				logger.info("  buyValueTime   {}", ScrapeUtil.getInstance(BuyValueTime.class,   string));
				logger.info("  openValue      {}", ScrapeUtil.getInstance(OpenValue.class,      string));
				logger.info("  highValue      {}", ScrapeUtil.getInstance(HighValue.class,      string));
				logger.info("  logValue       {}", ScrapeUtil.getInstance(LowValue.class,       string));
				logger.info("  tradeValue     {}", ScrapeUtil.getInstance(TradeValue.class,     string));
				logger.info("  issuedValue    {}", ScrapeUtil.getInstance(IssuedValue.class,    string));
			}

		}
		logger.info("STOP");
	}
}
