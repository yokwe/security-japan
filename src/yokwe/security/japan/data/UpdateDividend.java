package yokwe.security.japan.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.jpx.Stock;

public class UpdateDividend {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateDividend.class);
	
	public static void main(String[] args) {
		logger.info("START");
		
		Set<String> stockCodeSet = Stock.load().stream().map(o -> o.stockCode).collect(Collectors.toSet());
		logger.info("stockCodeSet {}", stockCodeSet.size());
		
		Map<String, List<Dividend>> map = new TreeMap<>();
		{
			List<DividendAll> list = DividendAll.load();
			logger.info("DividendAll {}", list.size());
			for(DividendAll e: list) {
				String stockCode = e.stockCode;
				
				List<Dividend> dividendList;
				if (map.containsKey(stockCode)) {
					dividendList = map.get(stockCode);
				} else {
					dividendList = new ArrayList<>();
					map.put(stockCode, dividendList);
				}
				dividendList.add(new Dividend(e.date, e.stockCode, e.dividend));
			}
		}
		{
			List<DistributionAll> list = DistributionAll.load();
			logger.info("DistributionAll {}", list.size());
			for(DistributionAll e: list) {
				String stockCode = e.stockCode;
				
				List<Dividend> dividendList;
				if (map.containsKey(stockCode)) {
					dividendList = map.get(stockCode);
				} else {
					dividendList = new ArrayList<>();
					map.put(stockCode, dividendList);
				}
				dividendList.add(new Dividend(e.date, e.stockCode, e.distribution + e.distributionExcess));
			}
		}
		
		logger.info("map {}", map.size());
		List<String> delist = new ArrayList<>();
		int countSave  = 0;
		int countDelist = 0;
		for(Map.Entry<String, List<Dividend>> entry: map.entrySet()) {
			String         stockCode = entry.getKey();
			List<Dividend> list      = entry.getValue();
			
			// Save dividend of stockCode that appeared in stockCodeSet
			if (stockCodeSet.contains(stockCode)) {
				Dividend.save(stockCode, list);
				countSave++;
			} else {
				delist.add(stockCode);
				countDelist++;
			}
		}
		logger.info("countSave  {}", countSave);
		logger.info("countDelist {}", countDelist);
		logger.info("delist {} {}", delist.size(), delist);
		
		logger.info("STOP");
	}
}
