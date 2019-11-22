package yokwe.security.japan.jpx;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.CSVUtil;

public class Stock implements Comparable<Stock> {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Stock.class);

	public static final String PATH_DATA = "tmp/data/stock.csv";

	public static List<Stock> load() {
		return CSVUtil.read(Stock.class).file(PATH_DATA);
	}
	public static Map<String, Stock> getStockMap() {
		List<Stock> stockList = load();
		if (stockList == null) return null;
		
		// key is stockCode
		Map<String, Stock> ret = new TreeMap<>();
		for(Stock stock: stockList) {
			String stockCode = stock.stockCode;
			if (ret.containsKey(stockCode)) {
				logger.error("duplicate stockCode {}!", stockCode);
				logger.error("old {}", ret.get(stockCode));
				logger.error("new {}", stock);
				throw new UnexpectedException("duplicate stockCode");
			} else {
				ret.put(stock.stockCode, stock);
			}
		}
		return ret;
	}

	public String stockCode;      // コード 4 or 5 digits
	public String isinCode;       // ISINコード
	public int    tradeUnit;      // 売買単位
	public long   numberOfIssued; // 発行済株式数
	
	public Stock(String stockCode, String isinCode, int tradeUnit, long numberOfIssued) {
		this.stockCode      = stockCode;
		this.isinCode       = isinCode;
		this.tradeUnit      = tradeUnit;
		this.numberOfIssued = numberOfIssued;
	}
	public Stock() {
		this(null, null, 0, 0);
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %d %d", stockCode, isinCode, tradeUnit, numberOfIssued);
	}
	
	@Override
	public int compareTo(Stock that) {
		int ret = this.stockCode.compareTo(that.stockCode);
		return ret;
	}
}
