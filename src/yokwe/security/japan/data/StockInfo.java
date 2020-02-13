package yokwe.security.japan.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.CSVUtil;

public class StockInfo implements Comparable<StockInfo> {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(StockInfo.class);

	public static final String PATH_DATA = "tmp/data/stock-info.csv";

	public static List<StockInfo> load() {
		return CSVUtil.read(StockInfo.class).file(PATH_DATA);
	}
	public static void save(Collection<StockInfo> collection) {
		save(new ArrayList<>(collection));
	}
	public static void save(List<StockInfo> list) {
		// Sort before save
		Collections.sort(list);
		CSVUtil.write(StockInfo.class).file(PATH_DATA, list);
	}
	public static Map<String, StockInfo> getStockMap() {
		List<StockInfo> stockList = load();
		if (stockList == null) return null;
		
		// key is stockCode
		Map<String, StockInfo> ret = new TreeMap<>();
		for(StockInfo stock: stockList) {
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
	
	public StockInfo(String stockCode, String isinCode, int tradeUnit, long numberOfIssued) {
		this.stockCode      = stockCode;
		this.isinCode       = isinCode;
		this.tradeUnit      = tradeUnit;
		this.numberOfIssued = numberOfIssued;
	}
	public StockInfo() {
		this(null, null, 0, 0);
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %d %d", stockCode, isinCode, tradeUnit, numberOfIssued);
	}
	
	@Override
	public int compareTo(StockInfo that) {
		int ret = this.stockCode.compareTo(that.stockCode);
		return ret;
	}
}
