package yokwe.security.japan.data;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.jpx.Stock;
import yokwe.util.DoubleUtil;
import yokwe.util.JapanHoliday;
import yokwe.util.stats.DoubleArray;
import yokwe.util.stats.DoubleStreamUtil;
import yokwe.util.stats.HV;
import yokwe.util.stats.MA;
import yokwe.util.stats.RSI;

public class UpdateStats {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateStats.class);
	
	private static final LocalDate DATE_LAST  = JapanHoliday.getLastTradingDate();

	private static Stats getInstance(Stock stock, List<Price> priceList, List<Dividend> dividendList) {
		
		Stats ret = new Stats();
		
//		this.exchange = stock.exchange;
		ret.stockCode = stock.stockCode;
		
		ret.name      = stock.name;
		if (stock.sector33.equals("-") && stock.sector17.equals("-")) {
			if (stock.isETF()) {
				ret.sector33 = "ETF";
				ret.sector17 = "ETF";
			} else if (stock.isREIT()) {
				ret.sector33 = "REIT";
				ret.sector17 = "REIT";
			} else {
				ret.sector33 = stock.market;
				ret.sector17 = stock.market;
			}
		} else {
			ret.sector33 = stock.sector33;
			ret.sector17 = stock.sector17;
		}
		
		{
			Price lastPrice = priceList.get(priceList.size() - 1);
			ret.date  = lastPrice.date;
			ret.price = DoubleUtil.round(lastPrice.close, 2);
			ret.vol   = lastPrice.volume;
		}

		{
			// Limit to 1 year
			double[] priceArray = priceList.stream().mapToDouble(o -> o.close).toArray();
			ret.pricec = priceArray.length;
			
			{
				double logReturn[] = DoubleArray.logReturn(priceArray);
				DoubleStreamUtil.Stats stats = new DoubleStreamUtil.Stats(logReturn);
				
				double sd = stats.getStandardDeviation();
				ret.sd = Double.isNaN(sd) ? -1 : DoubleUtil.round(sd, 4);
			}
			
			HV hv = new HV(priceArray);
			ret.hv = Double.isNaN(hv.getValue()) ? -1 : DoubleUtil.round(hv.getValue(), 4);
			
			if (RSI.DEFAULT_PERIDO < priceArray.length) {
				RSI rsi = new RSI();
				Arrays.stream(priceArray).forEach(rsi);
				ret.rsi = DoubleUtil.round(rsi.getValue(), 1);
			} else {
				ret.rsi = -1;
			}
			
			{
				double min = priceList.get(0).low;
				double max = priceList.get(0).high;
				for(Price price: priceList) {
					if (price.low < min)  min = price.low;
					if (max < price.high) max = price.high;
				}
				ret.min    = DoubleUtil.round(min, 2);
				ret.max    = DoubleUtil.round(max, 2);
				ret.minpct = DoubleUtil.round((ret.price - ret.min) / ret.price, 3);
				ret.maxpct = DoubleUtil.round((ret.max - ret.price) / ret.price, 3);
			}
			
			
			// price change detection
			ret.last   = (priceArray.length < 2) ? -1 : priceArray[priceArray.length - 2];
			ret.sma5   = DoubleUtil.round(MA.sma(  5, priceArray).getValue(), 2);
			ret.sma20  = DoubleUtil.round(MA.sma( 20, priceArray).getValue(), 2);
			ret.sma50  = DoubleUtil.round(MA.sma( 50, priceArray).getValue(), 2);
			ret.sma200 = DoubleUtil.round(MA.sma(200, priceArray).getValue(), 2);
			
			ret.lastpct   = DoubleUtil.round((ret.price - ret.last)   / ret.last,   3);
			ret.sma5pct   = DoubleUtil.round((ret.price - ret.sma5)   / ret.sma5,   3);
			ret.sma20pct  = DoubleUtil.round((ret.price - ret.sma20)  / ret.sma20,  3);
			ret.sma50pct  = DoubleUtil.round((ret.price - ret.sma50)  / ret.sma50,  3);
			ret.sma200pct = DoubleUtil.round((ret.price - ret.sma200) / ret.sma200, 3);
		}
		
		// dividend
		{
			// Limit to 1 year
			double[] divArray = dividendList.stream().mapToDouble(o -> o.dividend).toArray();
			
			ret.div   = DoubleUtil.round(Arrays.stream(divArray).sum(), 4);
			ret.divc  = divArray.length;
			ret.yield = DoubleUtil.round(ret.div / ret.price, 3);
			
			double divLast  = (divArray.length == 0) ? 0 : divArray[divArray.length - 1];
			double divAdj;
			switch(ret.divc) {
			case 13:
				divAdj = divLast * 12; // remove irregular dividend
				break;
			case 12:
				divAdj = divLast * 12;
				break;
			case 4:
				divAdj = divLast * 4;
				break;
			case 2:
				divAdj = divLast * 2;
				break;
			case 1:
				divAdj = divLast;
				break;
			default:
				divAdj = 0;
				break;
			}
			ret.yieldadj = DoubleUtil.round(divAdj / ret.price, 3);
		}
		
		// volume
		{
			double[] volArray = priceList.stream().mapToDouble(o -> o.volume).toArray();

			MA vol5 = MA.sma(5, volArray);
			ret.vol5 = (long)vol5.getValue();

			MA vol30 = MA.sma(30, volArray);
			ret.vol30 = (long)vol30.getValue();
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		logger.info("START");
		
		final LocalDate firstPriceDate;
		{
			LocalDate date = DATE_LAST.minusYears(1).plusDays(1);
			for(;;) {
				if (JapanHoliday.isClosed(date)) {
					date = date.plusDays(1);
					continue;
				}
				break;
			}
			firstPriceDate = date;
		}
		final Set<LocalDate> priceListDateSet = new TreeSet<>();
		{
			LocalDate date = firstPriceDate;
			for(;;) {
				if (date.isAfter(DATE_LAST)) break;
				
				if (JapanHoliday.isClosed(date)) {
					//
				} else {
					priceListDateSet.add(date);
				}
				date = date.plusDays(1);
			}
		}
		final int priceListCount = priceListDateSet.size();

		logger.info("date {} - {}  {}", firstPriceDate, DATE_LAST, priceListCount);

		List<Stats> statsList = new ArrayList<>();
		
		Collection<Stock> stockList = Stock.load();
		
//		Collection<Stock> stockCollection = new ArrayList<>();
//		stockCollection.add(StockUtil.get("IBM"));
//		stockCollection.add(StockUtil.get("NYT"));
//		stockCollection.add(StockUtil.get("PEP"));
		
		int total = stockList.size();
		int count = 0;
		
		int showInterval = 1000;
		boolean showOutput;
		int lastOutputCount = -1;
		for(Stock stock: stockList) {
			String stockCode = stock.stockCode;

			int outputCount = count / showInterval;
			if (outputCount != lastOutputCount) {
				showOutput = true;
				lastOutputCount = outputCount;
			} else {
				showOutput = false;
			}

			count++;
			if (showOutput) logger.info("{}  update {}", String.format("%4d / %4d",  count, total), stockCode);
			
			File priceFile    = new File(Price.getPath(stockCode));
			File dividendFile = new File(Dividend.getPath(stockCode));
			
			List<Price> priceList;
			if (priceFile.exists()) {
				priceList = new ArrayList<>();
				
				List<Price> list = Price.load(stockCode);
				Collections.sort(list);
				
				for(Price e: list) {
					if (0 < e.open && 0 < e.high && 0 < e.low && 0 < e.close) {
						LocalDate date = LocalDate.parse(e.date);
						if (date.isEqual(firstPriceDate) || date.isAfter(firstPriceDate)) {
							priceList.add(e);
						}
					}
				}
				Collections.sort(list);
				
				{
					if (priceList.size() != priceListCount) {
						{
							Set<LocalDate> set = new TreeSet<>(priceListDateSet);
							priceList.stream().forEach(o -> set.remove(LocalDate.parse(o.date)));
							if (set.isEmpty()) {
								//
							} else {
								List<LocalDate> dateList = priceList.stream().map(o -> LocalDate.parse(o.date)).collect(Collectors.toList());
								Collections.sort(dateList);
								if (dateList.size() == 1) {
									logger.warn("{}  small  {}", String.format("%4d / %4d",  count, total), String.format("%5s %4d  %3d[%s]", stockCode, priceListCount, dateList.size(), dateList.get(0)));
								} else {
									logger.warn("{}  small  {}", String.format("%4d / %4d",  count, total), String.format("%5s %4d  %3d[%s .. %s]", stockCode, priceListCount, dateList.size(), dateList.get(0), dateList.get(dateList.size() - 1)));
								}
							}
						}
						{
							Set<LocalDate> set = priceList.stream().map(o -> LocalDate.parse(o.date)).collect(Collectors.toSet());
							priceListDateSet.stream().forEach(o -> set.remove(o));
							if (set.isEmpty()) {
								//
							} else {
								List<LocalDate> dateList = priceList.stream().map(o -> LocalDate.parse(o.date)).collect(Collectors.toList());
								Collections.sort(dateList);
								if (dateList.size() == 1) {
									logger.warn("{}  SMALL  {}", String.format("%4d / %4d",  count, total), String.format("%5s %4d  %3d[%s]", stockCode, priceListCount, dateList.size()), dateList.get(0));
								} else {
									logger.warn("{}  SMALL  {}", String.format("%4d / %4d",  count, total), String.format("%5s %4d  %3d[%s .. %s]", stockCode, priceListCount, dateList.size()), dateList.get(0), dateList.get(dateList.size() - 1));
								}
							}
						}
					}
				}
			} else {
				continue;
			}
			
			List<Dividend> dividendList;
			if (dividendFile.exists()) {
				// Filter data for last one year
				dividendList = new ArrayList<>();
				
				List<Dividend> list = Dividend.load(stockCode);
				Collections.sort(list);
				
				// range of dividend to process that is not equal to 
				LocalDate lastDividendDate = LocalDate.parse(list.get(list.size() - 1).date);
				LocalDate firstDividendDate = lastDividendDate.minusYears(1);
				
				for(Dividend e: list) {
					LocalDate date = LocalDate.parse(e.date);
					if (date.isAfter(firstDividendDate)) {
						dividendList.add(e);
					}
				}
			} else {
				dividendList = new ArrayList<>();
			}
			
			Stats stats = getInstance(stock, priceList, dividendList);
			if (stats != null) statsList.add(stats);
		}
		Stats.save(statsList);
		logger.info("stats  {}", String.format("%4d", statsList.size()));
		logger.info("STOP");
	}
}
