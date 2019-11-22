package yokwe.security.japan.jpx;

import java.io.File;
import java.util.ArrayList;
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
	
	private static class StockA {
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
		static final StringUtil.MatcherFunction<StockA> OP = (m -> new StockA(m.group("code"), m.group("isin")));
		static StockA getInstance(String string) {
			List<StockA> list = StringUtil.find(string, PAT, OP).collect(Collectors.toList());
			if (list.size() != 1) {
				logger.error("list.size() != 1  {}", list.size());
				throw new UnexpectedException("list.size() != 1");
			}
			return list.get(0);
		}
		
		final String stockCode;
		final String isinCode;
		
		StockA(String stockCode, String isinCode) {
			this.stockCode = stockCode;
			this.isinCode  = isinCode;
		}
		
		@Override
		public String toString() {
			return String.format("%s %s", stockCode, isinCode);
		}
	}

	private static class StockB {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>発行済株式数</font></td>\\s+" +
			"<td .+?><font .+?>(?<numberOfIssued>[0-9,]+)<br></font></td>\\s+"
		);
		private static final StringUtil.MatcherFunction<StockB> OP = (m -> new StockB(m.group("numberOfIssued")));
		static StockB getInstance(String string) {
			List<StockB> list = StringUtil.find(string, PAT, OP).collect(Collectors.toList());
			if (list.size() != 1) {
				logger.error("list.size() != 1  {}", list.size());
				throw new UnexpectedException("list.size() != 1");
			}
			return list.get(0);
		}
		
		final String numberOfIssued;
		
		StockB(String numberOfIssued) {
			// remove comma
			this.numberOfIssued = numberOfIssued.replace(",", "");
		}
		
		@Override
		public String toString() {
			return String.format("%s", numberOfIssued);
		}
	}
	
	private static class StockC {
		private static final Pattern PAT = Pattern.compile(
			"<td .+?><font .+?>売買単位</font></td>\\s+" +
			"<td .+?><font .+?>(?<tradeUnit>[0-9,]+)株<br></font></td>\\s+"
		);
		private static final StringUtil.MatcherFunction<StockC> OP = (m -> new StockC(m.group("tradeUnit")));
		static StockC getInstance(String string) {
			List<StockC> list = StringUtil.find(string, PAT, OP).collect(Collectors.toList());
			if (list.size() != 1) {
				logger.error("list.size() != 1  {}", list.size());
				throw new UnexpectedException("list.size() != 1");
			}
			return list.get(0);
		}
		
		final String tradeUnit;
		
		StockC(String tradeUnit) {
			// remove comma
			this.tradeUnit = tradeUnit.replace(",", "");
		}
		
		@Override
		public String toString() {
			return String.format("%s", tradeUnit);
		}
	}

	private static class StockD {
		private static final Pattern PAT = Pattern.compile(
			"(?<yyyy>20[0-9][0-9])/(?<mm>[01][0-9])/(?<dd>[012][0-9])," +
			"(?<open>[0-9]+\\.[0-9])," +
			"(?<high>[0-9]+\\.[0-9])," +
			"(?<low>[0-9]+\\.[0-9])," +
			"(?<close>[0-9]+\\.[0-9])," +
			"(?<volume>[0-9]+)," +
			"([0-9]+)?" +
			"[\\r\\n]+"
		);
		private static final StringUtil.MatcherFunction<StockD> OP =
			(m -> new StockD(m.group("yyyy"), m.group("mm"), m.group("dd"), m.group("open"), m.group("high"), m.group("low"), m.group("close"), m.group("volume")));
		static List<StockD> getInstance(String string) {
			List<StockD> ret = StringUtil.find(string, PAT, OP).collect(Collectors.toList());
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
		
		StockD(String yyyy, String mm, String dd, String open, String high, String low, String close, String volume) {
			this.yyyy = yyyy;
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
		StockA stockA = StockA.getInstance(page);
		logger.info("stockA {}", stockA);
		
		StockB stockB = StockB.getInstance(page);
		logger.info("stockB {}", stockB);
	
		StockC stockC = StockC.getInstance(page);
		logger.info("stockC {}", stockC);
		
		if (stockCode.compareTo(stockA.stockCode) != 0) {
			logger.error("Unexpected stockCode  {}  {}!", stockCode, stockA.stockCode);
			throw new UnexpectedException("Unexpected stockCode");
		}
		String isinCode       = stockA.isinCode;
		int    tradeUnit      = Integer.parseInt(stockC.tradeUnit);
		long   numberOfIssued = Long.parseLong(stockB.numberOfIssued);

		return new Stock(stockCode, isinCode, tradeUnit, numberOfIssued);
	}
	private static Map<String, Price> getPriceMap(String stockCode, String page) {
		List<StockD> stockDList = StockD.getInstance(page);
		
		Map<String, Price> map = new TreeMap<>();
		for(StockD stockD: stockDList) {
			String date   = String.format("%s-%s-%s", stockD.yyyy, stockD.mm, stockD.dd);
			double open   = Double.parseDouble(stockD.open);
			double low    = Double.parseDouble(stockD.low);
			double high   = Double.parseDouble(stockD.high);
			double close  = Double.parseDouble(stockD.close);
			long   volume = Long.parseLong(stockD.volume);
			
			Price price = new Price(date, stockCode, open, low, high, close, volume);
			if (map.containsKey(date)) {
				logger.error("duplicate date {}!", date);
				logger.error("old {}", map.get(date));
				logger.error("new {}", price);
				throw new UnexpectedException("duplicate date");
			} else {
				map.put(date, price);
			}
		}
		return map;
	}
	public static void main(String[] args) {
		logger.info("START");
		
		List<ListedIssue> list = ListedIssue.load();
		logger.info("list {}", list.size());
		
		Map<String, Stock> oldStockMap = Stock.getStockMap();
		if (oldStockMap == null) oldStockMap = new TreeMap<>();
		
		logger.info("oldStockMap {}", oldStockMap.size());
		
		// Build newStockMap
		Map<String, Stock> newStockMap = new TreeMap<>();
		
		int countTotal = list.size();
		int count = 0;
		int countNotExist = 0;
		for(ListedIssue listedIssue: list) {
			String stockCode = listedIssue.stockCode;
			logger.info("stockCode {}", stockCode);
			logger.info("{}", String.format("%4d / %4d  %s", count, countTotal, stockCode));
			count++;
			
			String path = String.format("tmp/download/page/%s", stockCode);
			String page;
			
			File file = new File(path);
			if (file.canRead()) {
				page = FileUtil.read().file(file);
			} else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					String exceptionName = e.getClass().getSimpleName();
					logger.error("{} {}", exceptionName, e);
					throw new UnexpectedException(exceptionName, e);
				}
				page = getPage(stockCode);
				FileUtil.write().file(file, page);
			}
			
			if (page.contains("指定された銘柄が見つかりません")) {
				countNotExist++;
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
						logger.error("not equal price {}!", key);
						logger.error("old {}", value);
						logger.error("new {}", newPrice);
						throw new UnexpectedException("not equal price");
					}
				} else {
					newPriceMap.put(key, value);
				}
			}
			List<Price> newPriceList = new ArrayList<>(newPriceMap.values());
			Price.save(newPriceList);
		}

		logger.info("countTotal    {}", countTotal);
		logger.info("countNotExist {}", countNotExist);

		logger.info("STOP");
	}
}
