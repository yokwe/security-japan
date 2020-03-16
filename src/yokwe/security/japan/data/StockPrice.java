package yokwe.security.japan.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import yokwe.util.CSVUtil;

public class StockPrice implements Comparable<StockPrice> {
	public static final String PATH_FILE = "tmp/data/stock-price.csv";

	public static List<StockPrice> getList() {
		List<StockPrice> ret = CSVUtil.read(StockPrice.class).file(PATH_FILE);
		if (ret == null) {
			ret = new ArrayList<>();
		}
		return ret;
	}
	public static void save(Collection<StockPrice> collection) {
		save(new ArrayList<>(collection));
	}
	public static void save(List<StockPrice> list) {
		// Sort before save
		Collections.sort(list);
		CSVUtil.write(StockPrice.class).file(PATH_FILE, list);
	}
	

	public String time;      // HH:mm -- taken from file modified time
	public String stockCode; // 5 digits
	
	public String price;
	public String priceTime; // HH:mm or empty
	
	public String sell;
	public String sellTime;  // HH:mm or empty
	
	public String buy;
	public String buyTime;   // HH:mm or empty
	
	public String open;
	public String high;
	public String low;

	public String volume;
	public String trade;
	
	public StockPrice(
			String time,
			String stockCode,
			
			String price,
			String priceTime,
			
			String sell,
			String sellTime,
			
			String buy,
			String buyTime,
			
			String open,
			String high,
			String low,
			
			String volume,
			String trade
		) {
		this.time = time;
		this.stockCode = stockCode;
		
		this.price = price;
		this.priceTime = priceTime;
		
		this.sell = sell;
		this.sellTime = sellTime;
		
		this.buy = buy;
		this.buyTime = buyTime;
		
		this.open = open;
		this.high = high;
		this.low = low;
		
		this.volume = volume;
		this.trade = trade;
	}
	public StockPrice() {
		this(null, null, null, null, null, null, null, null, null, null, null, null, null);
	}
	
	@Override
	public int compareTo(StockPrice that) {
		int ret = this.time.compareTo(that.time);
		if (ret == 0) ret = this.stockCode.compareTo(that.stockCode);
		return ret;
	}
}
