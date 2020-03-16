package yokwe.security.japan.data;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.jpx.DownloadStockPage;
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
	
	public static void main(String[] args) {
		logger.info("START");
		
		List<StockPrice> list = StockPrice.getList();
		
		for(File file: FileUtil.listFile(DownloadStockPage.PATH_DIR_DATA)) {
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
		
		logger.info("save {}", list.size());
		StockPrice.save(list);
		
		logger.info("STOP");
	}
}
