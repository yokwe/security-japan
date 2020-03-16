package yokwe.security.japan.data;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.jpx.StockPage;
import yokwe.security.japan.jpx.StockPage.BuyPriceTime;
import yokwe.security.japan.jpx.StockPage.CurrentPriceTime;
import yokwe.security.japan.jpx.StockPage.HighPrice;
import yokwe.security.japan.jpx.StockPage.LowPrice;
import yokwe.security.japan.jpx.StockPage.OpenPrice;
import yokwe.security.japan.jpx.StockPage.SellPriceTime;
import yokwe.security.japan.jpx.StockPage.TradeValue;
import yokwe.security.japan.jpx.StockPage.TradeVolume;
import yokwe.util.FileUtil;

public class UpdateStockPrice {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateStockPrice.class);

	private static final DateTimeFormatter FORMAT_HHMM = DateTimeFormatter.ofPattern("HH:mm");
	
	private static void updateStockPrice() {
		// Load old data
		List<StockPrice> list = StockPrice.getList();
		logger.info("load old data {}", list.size());
		
		// Append new data
		logger.info("append new data");
		for(File file: FileUtil.listFile(StockPage.PATH_DIR_DATA)) {
			String        stockCode = file.getName();
			LocalDateTime dateTime  = LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), TimeZone.getDefault().toZoneId());  
//			logger.info("{}  {}", stockCode, dateTime);
			
			String page = FileUtil.read().file(file);
			
			if (page.contains("指定された銘柄が見つかりません")) continue;
			
			CurrentPriceTime currentPriceTime = CurrentPriceTime.getInstance(page);
			BuyPriceTime     buyPriceTime     = BuyPriceTime.getInstance(page);
			SellPriceTime    sellPriceTime    = SellPriceTime.getInstance(page);
			OpenPrice        openPrice        = OpenPrice.getInstance(page);
			HighPrice        highPrice        = HighPrice.getInstance(page);
			LowPrice         lowPrice         = LowPrice.getInstance(page);
			TradeVolume      tradeVolume      = TradeVolume.getInstance(page);
			TradeValue       tradeValue       = TradeValue.getInstance(page);
			
//			String stockCode;
			String date = dateTime.toLocalDate().toString();
			String time = dateTime.toLocalTime().format(FORMAT_HHMM);
			
			String price     = currentPriceTime.price.orElse("");
			String priceTime = currentPriceTime.time.orElse("");
			
			String sell      = sellPriceTime.price.orElse("");
			String sellTime  = sellPriceTime.time.orElse("");
			
			String buy      = buyPriceTime.price.orElse("");
			String buyTime  = buyPriceTime.time.orElse("");
			
			String open  = openPrice.value.orElse("");
			String high  = highPrice.value.orElse("");
			String low   = lowPrice.value.orElse("");
			String volume = tradeVolume.value.orElse("");
			String trade = tradeValue.value.orElse("");
			
			StockPrice stockPrice = new StockPrice(
					date,
					time,
					stockCode,
					
					price,
					priceTime,
					
					sell,
					sellTime,
					
					buy,
					buyTime,
					
					open,
					high,
					low,
					
					volume,
					trade
				);
			list.add(stockPrice);
		}
		
		// Remove duplicate record
		logger.info("remove duplicate data");
		{
			Map<String, StockPrice> map = new TreeMap<>();
			for(StockPrice e: list) {
				String key = String.format("%s %s %s", e.date, e.time, e.stockCode);
				map.put(key, e);
			}
			list.clear();
			list.addAll(map.values());
		}
		
		// Save data
		logger.info("save {}", list.size());
		StockPrice.save(list);
	}
	
	private static void updatePrice() {
		// build list contains oldest time StockPrice record for each stockCode
		List<StockPrice> list;
		{
			Map<String, StockPrice> map = new TreeMap<>();
			for(StockPrice e: StockPrice.getList()) {
				String stockCode = e.stockCode;
				if (map.containsKey(stockCode)) {
					StockPrice oldData = map.get(stockCode);
					String oldTime = oldData.time;
					String newTime = e.time;
					if (oldTime.compareTo(newTime) < 0) {
						map.put(stockCode, e);
					}
				} else {
					map.put(stockCode, e);
				}
			}
			list = new ArrayList<>(map.values());
		}
		
		// update price file
		int count       = 0;
		int countUpdate = 0;
		int countSkip   = 0;
		int countZero   = 0;
		int countTotal  = list.size();
		for(StockPrice e: list) {
			String date      = e.date;
			String stockCode = e.stockCode;
			
			if ((count % 100) == 0) {
				logger.info("{}", String.format("%4d / %4d  %s", count, countTotal, stockCode));
			}
			count++;
			
			TreeMap<String, Price> priceMap = new TreeMap<>();
			//  date
			for(Price price: Price.getList(stockCode)) {
				priceMap.put(price.date, price);
			}
			
			double open;
			double high;
			double low;
			double close;
			long   volume; //  = Long.parseLong(e.volume)
			if (e.volume.isEmpty()) {
				// Cannot get lastPrice, skip to this entry
				if (priceMap.isEmpty()) {
					countSkip++;
					continue;
				}
				
				Price lastPrice = priceMap.lastEntry().getValue();
				open   = lastPrice.open;
				high   = lastPrice.high;
				low    = lastPrice.low;
				close  = lastPrice.close;
				volume = 0;
				countZero++;
			} else {
				open   = Double.parseDouble(e.open);
				high   = Double.parseDouble(e.high);
				low    = Double.parseDouble(e.low);
				close  = Double.parseDouble(e.price);
				volume = Long.parseLong(e.volume);
				countUpdate++;
			}

			Price price = new Price(date, stockCode, open, low, high, close, volume);
			// Over write old entry or add new entry
			priceMap.put(date, price);
			
			Price.save(priceMap.values());
		}
		
		logger.info("countTotal  {}", String.format("%4d", countTotal));
		logger.info("countSkip   {}", String.format("%4d", countSkip));
		logger.info("countZero   {}", String.format("%4d", countZero));
		logger.info("countUpdate {}", String.format("%4d", countUpdate));
	}
	
	public static void main(String[] args) {
		logger.info("START");
		
		updateStockPrice();
		updatePrice();
		logger.info("STOP");
	}
}
