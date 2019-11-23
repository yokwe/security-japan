package yokwe.security.japan.jpx;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.FileUtil;
import yokwe.util.HttpUtil;
import yokwe.util.StringUtil;

public class UpdateStockPrice {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateStockPrice.class);

	private static String getPage(String stockCode) {
		String url = String.format("https://quote.jpx.co.jp/jpx/template/quote.cgi?F=tmp/stock_detail&MKTN=T&QCODE=%s", stockCode);
		
		HttpUtil.Result result = HttpUtil.getInstance().
				withReferer("https://www.jpx.co.jp/").
				download(url);
		if (result.result == null) {
			logger.error("result is null %s", stockCode);
			throw new UnexpectedException("result is null");
		}
		String ret = StringUtil.unescapceHTMLChar(result.result);
		return ret;
	}
	
	private static class BasicInfo {
		private static final Pattern PAT = Pattern.compile(
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
		static final StringUtil.MatcherFunction<BasicInfo> OP = (m -> new BasicInfo(m.group("code"), m.group("isin")));
		static BasicInfo getInstance(String string) {
			List<BasicInfo> list = StringUtil.find(string, PAT, OP).collect(Collectors.toList());
			if (list.size() != 1) {
				logger.error("list.size() != 1  {}", list.size());
				throw new UnexpectedException("list.size() != 1");
			}
			return list.get(0);
		}
		
		final String stockCode;
		final String isinCode;
		
		BasicInfo(String stockCode, String isinCode) {
			this.stockCode = stockCode;
			this.isinCode  = isinCode;
		}
		
		@Override
		public String toString() {
			return String.format("%s %s", stockCode, isinCode);
		}
	}

	private static class NumberOfIssued {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>発行済株式数</font></td>\\s+" +
			"<td .+?><font .+?>(?<numberOfIssued>[0-9,]+)<br></font></td>\\s+"
		);
		private static final StringUtil.MatcherFunction<NumberOfIssued> OP = (m -> new NumberOfIssued(m.group("numberOfIssued")));
		static NumberOfIssued getInstance(String string) {
			List<NumberOfIssued> list = StringUtil.find(string, PAT, OP).collect(Collectors.toList());
			if (list.size() != 1) {
				logger.error("list.size() != 1  {}", list.size());
				throw new UnexpectedException("list.size() != 1");
			}
			return list.get(0);
		}
		
		final String numberOfIssued;
		
		NumberOfIssued(String numberOfIssued) {
			// remove comma
			this.numberOfIssued = numberOfIssued.replace(",", "");
		}
		
		@Override
		public String toString() {
			return String.format("%s", numberOfIssued);
		}
	}
	
	private static class TradeUnit {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売買単位</font></td>\\s+" +
			"<td .+?><font .+?>(?<tradeUnit>[0-9,]+)株<br></font></td>\\s+"
		);
		private static final StringUtil.MatcherFunction<TradeUnit> OP = (m -> new TradeUnit(m.group("tradeUnit")));
		static TradeUnit getInstance(String string) {
			List<TradeUnit> list = StringUtil.find(string, PAT, OP).collect(Collectors.toList());
			if (list.size() != 1) {
				logger.error("list.size() != 1  {}", list.size());
				throw new UnexpectedException("list.size() != 1");
			}
			return list.get(0);
		}
		
		final String tradeUnit;
		
		TradeUnit(String tradeUnit) {
			// remove comma
			this.tradeUnit = tradeUnit.replace(",", "");
		}
		
		@Override
		public String toString() {
			return String.format("%s", tradeUnit);
		}
	}

	private static class PriceVolume {
		private static final Pattern PAT = Pattern.compile(
			"(?<yyyy>20[0-9][0-9])/(?<mm>[01][0-9])/(?<dd>[0123][0-9])," +
			"(?<open>([0-9]+\\.[0-9])?)," +
			"(?<high>([0-9]+\\.[0-9])?)," +
			"(?<low>([0-9]+\\.[0-9])?)," +
			"(?<close>([0-9]+\\.[0-9])?)," +
			"(?<volume>[0-9]+)," +
			"([0-9]+)?" +
			"[\\r\\n]+"
		);
		private static final StringUtil.MatcherFunction<PriceVolume> OP =
			(m -> new PriceVolume(m.group("yyyy"), m.group("mm"), m.group("dd"), m.group("open"), m.group("high"), m.group("low"), m.group("close"), m.group("volume")));
		static List<PriceVolume> getInstance(String string) {
			List<PriceVolume> ret = StringUtil.find(string, PAT, OP).collect(Collectors.toList());
			return ret;
		}
		
		final String yyyy;
		final String mm;
		final String dd;
		final String open;
		final String high;
		final String low;
		final String close;
		final String volume;
		
		PriceVolume(String yyyy, String mm, String dd, String open, String high, String low, String close, String volume) {
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
			return String.format("%s %s %s %s %s %s %s %s", yyyy, mm, dd, open, high, low, close, volume);
		}
	}

	private static Stock getStock(String stockCode, String page) {
		BasicInfo      basicInfo           = BasicInfo.getInstance(page);
		NumberOfIssued numerOfIssuedString = NumberOfIssued.getInstance(page);	
		TradeUnit      tradeUnitString     = TradeUnit.getInstance(page);
		
		if (stockCode.compareTo(basicInfo.stockCode) != 0) {
			logger.error("Unexpected stockCode  {}  {}!", stockCode, basicInfo.stockCode);
			throw new UnexpectedException("Unexpected stockCode");
		}
		
		String isinCode       = basicInfo.isinCode;
		int    tradeUnit      = Integer.parseInt(tradeUnitString.tradeUnit);
		long   numberOfIssued = Long.parseLong(numerOfIssuedString.numberOfIssued);

		return new Stock(stockCode, isinCode, tradeUnit, numberOfIssued);
	}
	private static Map<String, Price> getPriceMap(String stockCode, String page) {
		List<PriceVolume> priceVolumeList = PriceVolume.getInstance(page);
		
		double lastClose = -1;
		Map<String, Price> map = new TreeMap<>();
		for(PriceVolume priveVolume: priceVolumeList) {
			String date   = String.format("%s-%s-%s", priveVolume.yyyy, priveVolume.mm, priveVolume.dd);
			double open;
			double low;
			double high;
			double close;
			long   volume = Long.parseLong(priveVolume.volume);
			if (volume == 0) {
				if (lastClose == -1) {
//					logger.warn("No lastClose {} {}", stockCode, date);
					continue;
				} else {
					open = low = high = close = lastClose;
				}
			} else {
				open   = Double.parseDouble(priveVolume.open);
				low    = Double.parseDouble(priveVolume.low);
				high   = Double.parseDouble(priveVolume.high);
				close  = Double.parseDouble(priveVolume.close);
				lastClose = close;
			}
			
			Price price = new Price(date, stockCode, open, low, high, close, volume);
			if (map.containsKey(date)) {
				logger.error("duplicate date {} {}", stockCode, date);
				logger.error("old {}", map.get(date));
				logger.error("new {}", price);
				throw new UnexpectedException("duplicate date");
			} else {
				map.put(date, price);
			}
		}
		return map;
	}
	
	private static String getPagePath(String stockCode) {
		return String.format("tmp/download/page/%s", stockCode);
	}
	
	private static void downloadPage(List<ListedIssue> list) {
		// Create parent folder if not exists
		{
			String path = getPagePath("0000");
			File file = new File(path);
			File parent = file.getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}
		}

		HashSet<String> stockCodeSet = new HashSet<>(list.stream().map(o -> o.stockCode).collect(Collectors.toList()));
		
		int count = 0;
		int countTotal = stockCodeSet.size();
		for(String stockCode: stockCodeSet) {
			if ((count % 100) == 0) {
				logger.info("{}", String.format("%4d / %4d  %s", count, countTotal, stockCode));
			}
			count++;
			
			String path = getPagePath(stockCode);
			File   file = new File(path);
			
			// Skip if file exists -- for rerun
			if (file.canRead()) continue;
			
			String page = getPage(stockCode);
			FileUtil.write().file(file, page);
		}
	}
	
	private static void processPage(List<ListedIssue> list) {
		Map<String, Stock> oldStockMap = Stock.getStockMap();
		if (oldStockMap == null) oldStockMap = new TreeMap<>();
		
		logger.info("oldStockMap   {}", oldStockMap.size());
		
		// Build newStockMap
		Map<String, Stock> newStockMap = new TreeMap<>();
		
		int countTotal = list.size();
		int count = 0;
		List<String> listNotExist = new ArrayList<>();
		for(ListedIssue listedIssue: list) {
			count++;
			String stockCode = listedIssue.stockCode;
			if ((count % 100) == 0) {
				logger.info("{}", String.format("%4d / %4d  %s", count, countTotal, stockCode));
			}
			
			String path = getPagePath(stockCode);
			String page;
			
			File file = new File(path);
			if (file.canRead()) {
				page = FileUtil.read().file(file);
			} else {
				logger.error("no page file {}", path);
				throw new UnexpectedException("no page file");
			}
			
			if (page.contains("指定された銘柄が見つかりません")) {
				listNotExist.add(stockCode);
				continue;
			}

			Stock stock = getStock(stockCode, page);
			newStockMap.put(stockCode, stock);
			
			// Merge oldPriceMap and newPriceMap
			Map<String, Price> oldPriceMap = Price.getPriceMap(stockCode);
			if (oldPriceMap == null) oldPriceMap = new TreeMap<>();
			
			Map<String, Price> newPriceMap = getPriceMap(stockCode, page);
			
			// Add missing price to newPriceMap
			for(Map.Entry<String, Price> entry: oldPriceMap.entrySet()) {
				String key   = entry.getKey();
				Price  value = entry.getValue();
				if (newPriceMap.containsKey(key)) {
					Price newPrice = newPriceMap.get(key);
					if (newPrice.compareTo(value) == 0) {
						// equal
					} else {
						// not equal
						logger.warn("not equal price {} {}", stockCode, key);
						logger.warn("old {}", value);
						logger.warn("new {}", newPrice);
					}
				} else {
					newPriceMap.put(key, value);
				}
			}
			List<Price> newPriceList = new ArrayList<>(newPriceMap.values());
			Price.save(newPriceList);
		}
		
		Stock.save(new ArrayList<>(newStockMap.values()));

		logger.info("newStockMap   {}", newStockMap.size());
		logger.info("countTotal    {}", countTotal);
		logger.info("countNotExist {}", listNotExist);

	}
	
	public static void main(String[] args) {
		logger.info("START");
		
		List<ListedIssue> list = ListedIssue.load();
		logger.info("list {}", list.size());
		
		// downloadPage
		logger.info("download page");
		downloadPage(list);
		
		logger.info("process page");
		processPage(list);
		
		logger.info("STOP");
		System.exit(0);
	}
}
