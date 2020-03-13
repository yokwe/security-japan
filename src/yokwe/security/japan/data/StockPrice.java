package yokwe.security.japan.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import yokwe.util.CSVUtil;

public class StockPrice implements Comparable<StockPrice> {
	public static final String PATH_DIR_DATA = "tmp/data/stock-price";
	public static String getPath(String stockCode) {
		return String.format("%s/%s.csv", PATH_DIR_DATA, stockCode);
	}

	public static void save(Collection<StockPrice> collection) {
		save(new ArrayList<>(collection));
	}
	public static void save(List<StockPrice> list) {
		if (list.isEmpty()) return;
		String stockCode = list.get(0).stockCode;
		String path      = getPath(stockCode);
		
		// Sort before save
		Collections.sort(list);
		CSVUtil.write(StockPrice.class).file(path, list);
	}
	

	public String stockCode; // 5 digits
	public String time;      // HH:mm:ss -- taken from file modified time
	
	public double price;
	public String priceTime; // HH:mm or empty
	
	public double sell;
	public String sellTime;  // HH:mm or empty
	
	public double buy;
	public String buyTime;   // HH:mm or empty
	
	public double open;
	public double high;
	public double low;
	public double close;
	public long   volume;
	public long   tradeM;
	
	
	@Override
	public int compareTo(StockPrice that) {
		int ret = this.stockCode.compareTo(that.stockCode);
		if (ret == 0) ret = this.time.compareTo(that.time);
		return ret;
	}
}
