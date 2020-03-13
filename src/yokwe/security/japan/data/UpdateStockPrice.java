package yokwe.security.japan.data;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.jpx.DownloadStockPage;
import yokwe.util.FileUtil;
import yokwe.util.StringUtil;

public class UpdateStockPrice {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateStockPrice.class);

	private static class PriceValueTime {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><b>現在値 \\(時刻\\)</b></td>\\s*" +
			"<td .+?><b>(?<value>[0-9,.]*) \\((?<time>.+?)\\)</b></td>\\s*"
		);
		public static PriceValueTime getInstance(String string) {
			String[] group = StringUtil.getGroup(PAT, string);
			return new PriceValueTime(group[0], group[1]);
		}
		
		final String value;
		final String time;
		
		PriceValueTime(String value, String time) {
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

//	<td align=middle width="24%" bgcolor=#ffddb7><font size=2>売り気配値 (時刻)</font></td>
//  <td align=right width="26%" bgcolor=#cccccc><font size="2">220 (08:04)</font></td>
	
//	<td align=middle width="24%" bgcolor=#ffddb7><font size=2>売り気配値 (時刻)</font></td>
//  <td align=right width="26%" bgcolor=#cccccc><font size="2">&nbsp; (&nbsp;&nbsp;)</font></td>

	private static class SellValueTime {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売り気配値 \\(時刻\\)</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.+?) \\((?<time>.+?)\\)</font></td>\\s*"
		);
		public static SellValueTime getInstance(String string) {
			String[] group = StringUtil.getGroup(PAT, string);
			return new SellValueTime(group[0], group[1]);
		}
		
		final String value;
		final String time;
		
		SellValueTime(String value, String time) {
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

//	<td align=middle width="27%" bgcolor=#ffddb7><font size=2>買い気配値 (時刻)</font></td>
//  <td align=right width="23%" bgcolor=#cccccc><font size="2">&nbsp; (&nbsp;&nbsp;)</font></td>

	private static class BuyValueTime {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>買い気配値 \\(時刻\\)</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.+?) \\((?<time>.+?)\\)</font></td>\\s*"
		);
		public static BuyValueTime getInstance(String string) {
			String[] group = StringUtil.getGroup(PAT, string);
			return new BuyValueTime(group[0], group[1]);
		}
		
		final String value;
		final String time;
		
		BuyValueTime(String value, String time) {
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
	
//	<td align=middle width="24%" bgcolor=#ffddb7><font size=2>始値</font></td>
//  <td align=right width="26%"><font size="2">2,255<br></font></td>
	private static class OpenValue {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>始値</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		public static OpenValue getInstance(String string) {
			String[] group = StringUtil.getGroup(PAT, string);
			return new OpenValue(group[0]);
		}
		
		final String value;
		
		OpenValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

//	<td align=middle width="24%" bgcolor=#ffddb7><font size=2>高値</font></td>
//	<td align=right width="26%" bgcolor=#cccccc><font size="2">2,326<br></font></td>
	private static class HighValue {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>高値</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		public static HighValue getInstance(String string) {
			String[] group = StringUtil.getGroup(PAT, string);
			return new HighValue(group[0]);
		}
		
		final String value;
		
		HighValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}
	
//	<td align=middle width="27%" bgcolor=#ffddb7><font size=2>安値</font></td>
//	<td align=right width="23%" bgcolor=#cccccc><font size="2">2,202<br></font></td>
	private static class LowValue {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>安値</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		public static LowValue getInstance(String string) {
			String[] group = StringUtil.getGroup(PAT, string);
			return new LowValue(group[0]);
		}
		
		final String value;
		
		LowValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

//	<td align=middle width="24%" bgcolor=#ffddb7><font size=2>売買高</font></td>
//	<td align=right width="26%" bgcolor=#cccccc><font size="2">96,800株<br></font></td>
	
//	<td align=middle width="24%" bgcolor=#ffddb7><font size=2>売買高</font></td>
//	<td align=right width="26%" bgcolor=#cccccc><font size="2">&nbsp;株<br></font></td>
	private static class VolumeValue {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売買高</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)株<br></font></td>\\s*"
		);
		public static VolumeValue getInstance(String string) {
			String[] group = StringUtil.getGroup(PAT, string);
			return new VolumeValue(group[0]);
		}
		
		final String value;
		
		VolumeValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

//	<td align=middle width="27%" bgcolor=#ffddb7><font size=2>売買代金</font></td>
//	<td align=right width="23%" bgcolor=#cccccc><font size="2">&nbsp;<br></font></td>
	private static class TradeValue {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売買代金</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		public static TradeValue getInstance(String string) {
			String[] group = StringUtil.getGroup(PAT, string);
			return new TradeValue(group[0]);
		}
		
		final String value;
		
		TradeValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

//	<td align=middle width="27%" bgcolor=#ffddb7><font size=2>発行済株式数</font></td>
//	<td align=right width="23%"><font size="2">10,928,283<br></font></td>
	private static class IssuedValue {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>発行済株式数</font></td>\\s*" +
			"<td .+?><font .+?>(?<value>.*?)<br></font></td>\\s*"
		);
		public static IssuedValue getInstance(String string) {
			String[] group = StringUtil.getGroup(PAT, string);
			return new IssuedValue(group[0]);
		}
		
		final String value;
		
		IssuedValue(String value) {
			// remove comma
			this.value = value.replace(",", "").replace("&nbsp;", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	
	DateTimeFormatter FORMATTETR = DateTimeFormatter.ofPattern("YYYY-mm-dd HH:mm:ss");
	public static void main(String[] args) {
		logger.info("START");
		
		List<File> list = FileUtil.listFile(DownloadStockPage.PATH_DIR_DATA);
		for(File e: list) {
			LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(e.lastModified()), TimeZone.getDefault().toZoneId());  
			logger.info("{}  {}", e.getName(), dateTime);
			
			String page = FileUtil.read().file(e);
			
			if (page.contains("指定された銘柄が見つかりません")) continue;
			
			PriceValueTime priceValueTime = PriceValueTime.getInstance(page);
			SellValueTime  sellValueTime  = SellValueTime.getInstance(page);
			BuyValueTime   buyValueTime   = BuyValueTime.getInstance(page);
			OpenValue      openValue      = OpenValue.getInstance(page);
			HighValue      highValue      = HighValue.getInstance(page);
			LowValue       lowValue       = LowValue.getInstance(page);
			VolumeValue    volumeValue    = VolumeValue.getInstance(page);
			TradeValue     tradeValue     = TradeValue.getInstance(page);
			IssuedValue    issuedValue    = IssuedValue.getInstance(page);
			
			logger.info("   priceValueTime {}", priceValueTime);
			logger.info("   sellValueTime  {}", sellValueTime);
			logger.info("   buyValueTime   {}", buyValueTime);
			logger.info("   openValue      {}", openValue);
			logger.info("   highValue      {}", highValue);
			logger.info("   lowValue       {}", lowValue);
			logger.info("   volumeValue    {}", volumeValue);
			logger.info("   tradeValue     {}", tradeValue);
			logger.info("   issuedValue    {}", issuedValue);
		}
		logger.info("STOP");
	}
}
