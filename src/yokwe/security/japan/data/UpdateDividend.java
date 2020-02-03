package yokwe.security.japan.data;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.util.CSVUtil;

public class UpdateDividend {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateDividend.class);
	
	public static void main(String[] args) {
		logger.info("START");
		
		Map<String, List<Dividend>> map = new TreeMap<>();
		{
			List<DividendAll> list = DividendAll.load();
			logger.info("list {}", list.size());
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
		
		logger.info("map {}", map.size());
		for(Map.Entry<String, List<Dividend>> entry: map.entrySet()) {
			String         stockCode = entry.getKey();
			List<Dividend> list      = entry.getValue();
			
			Dividend.save(stockCode, list);
		}
		
		logger.info("STOP");
	}
}
