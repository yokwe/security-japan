package yokwe.security.japan.jpx;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.LoggerFactory;

import yokwe.util.FileUtil;
import yokwe.util.ScrapeUtil;

public class StockPage {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(StockPage.class);
	
	public static final String NO_INFORMATION = "指定された銘柄が見つかりません";
	
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
		public static CompanyInfo getInstance(String page) {
			return ScrapeUtil.getInstance(CompanyInfo.class, PAT, page);
		}

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
	public static class CurrentPriceVolume {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><b>現在値 \\(時刻\\)</b></td>\\s*" +
			"<td .+?><b>(?<value>[0-9,.]*) \\((?<time>.+?)\\)</b></td>\\s*"
		);
		public static CurrentPriceVolume getInstance(String page) {
			return ScrapeUtil.getInstance(CurrentPriceVolume.class, PAT, page);
		}

		public final String value;
		public final String time;
		
		public CurrentPriceVolume(String value, String time) {
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
	public static class SellPriceTime {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売り気配値 \\(時刻\\)</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.+?) \\((?<time>.+?)\\)</font></td>\\s*"
		);
		public static SellPriceTime getInstance(String page) {
			return ScrapeUtil.getInstance(SellPriceTime.class, PAT, page);
		}

		public final String value;
		public final String time;
		
		public SellPriceTime(String value, String time) {
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
		public static BuyValueTime getInstance(String page) {
			return ScrapeUtil.getInstance(BuyValueTime.class, PAT, page);
		}

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
	public static class OpenPrice {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>始値</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		public static OpenPrice getInstance(String page) {
			return ScrapeUtil.getInstance(OpenPrice.class, PAT, page);
		}

		public final String value;
		
		public OpenPrice(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 高値
	public static class HighPrice {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>高値</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		public static HighPrice getInstance(String page) {
			return ScrapeUtil.getInstance(HighPrice.class, PAT, page);
		}

		public final String value;
		
		public HighPrice(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}
	
	// 安値
	public static class LowPrice {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>安値</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		public static LowPrice getInstance(String page) {
			return ScrapeUtil.getInstance(LowPrice.class, PAT, page);
		}

		public final String value;
		
		public LowPrice(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 売買高
	public static class TradeVolume {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売買高</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)株<br></font></td>\\s*"
		);
		public static TradeVolume getInstance(String page) {
			return ScrapeUtil.getInstance(TradeVolume.class, PAT, page);
		}
		
		public final String value;
		
		public TradeVolume(String value) {
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
		public static TradeValue getInstance(String page) {
			return ScrapeUtil.getInstance(TradeValue.class, PAT, page);
		}
		
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
	public static class Issued {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>発行済株式数</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		public static Issued getInstance(String page) {
			return ScrapeUtil.getInstance(Issued.class, PAT, page);
		}

		public final String value;
		
		public Issued(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	public static class TradeUnit {
		public static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売買単位</font></td>\\s+" +
			"<td .+?><font .+?>(?<tradeUnit>[0-9,]+)株<br></font></td>\\s+"
		);
		public static TradeUnit getInstance(String page) {
			return ScrapeUtil.getInstance(TradeUnit.class, PAT, page);
		}
		
		public final String tradeUnit;
		
		public TradeUnit(String tradeUnit) {
			// remove comma
			this.tradeUnit = tradeUnit.replace(",", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", tradeUnit);
		}
	}

	public static class PriceVolume {
		public static final Pattern PAT = Pattern.compile(
			"(?<yyyy>20[0-9][0-9])/(?<mm>[01][0-9])/(?<dd>[0123][0-9])," +
			"(?<open>([0-9]+\\.[0-9])?)," +
			"(?<high>([0-9]+\\.[0-9])?)," +
			"(?<low>([0-9]+\\.[0-9])?)," +
			"(?<close>([0-9]+\\.[0-9])?)," +
			"(?<volume>[0-9]+)," +
			"([0-9]+)?" +
			"[\\r\\n]+"
		);
		public static List<PriceVolume> getInstance(String page) {
			return ScrapeUtil.getList(PriceVolume.class, PAT, page);
		}
		
		public final String yyyy;
		public final String mm;
		public final String dd;
		public final String open;
		public final String high;
		public final String low;
		public final String close;
		public final String volume;
		
		public PriceVolume(String yyyy, String mm, String dd, String open, String high, String low, String close, String volume) {
			this.yyyy   = yyyy;
			this.mm     = mm;
			this.dd     = dd;
			this.open   = open;
			this.high   = high;
			this.low    = low;
			this.close  = close;
			this.volume = volume;
		}
		
		@Override
		public String toString() {
			return String.format("{%s %s %s %s %s %s %s %s}", yyyy, mm, dd, open, high, low, close, volume);
		}
	}

	public static void main(String[] args) {
		logger.info("START");
		
		{
			for(File file: FileUtil.listFile(DownloadStockPage.PATH_DIR_DATA)) {
				String string = FileUtil.read().file(file);
				if (string.contains(NO_INFORMATION)) continue;

				logger.info("file  {}", file.getName());
				logger.info("  companyInfo    {}", CompanyInfo.getInstance(string));
				logger.info("  priceVolume    {}", CurrentPriceVolume.getInstance(string));
				logger.info("  sellPrcieTime  {}", SellPriceTime.getInstance(string));
				logger.info("  buyPriceTime   {}", BuyValueTime.getInstance(string));
				logger.info("  openPrice      {}", OpenPrice.getInstance(string));
				logger.info("  highPrice      {}", HighPrice.getInstance(string));
				logger.info("  lowPrice       {}", LowPrice.getInstance(string));
				logger.info("  tradeValue     {}", TradeValue.getInstance(string));
				logger.info("  issued         {}", Issued.getInstance(string));
				logger.info("  tradeVoluem    {}", TradeVolume.getInstance(string));
				logger.info("  tradeUnit      {}", TradeUnit.getInstance(string));
				logger.info("  priceVolume    {}", PriceVolume.getInstance(string).size());

			}

		}
		logger.info("STOP");
	}
}
