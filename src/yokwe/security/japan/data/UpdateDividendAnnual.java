package yokwe.security.japan.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.jpx.tdnet.Category;
import yokwe.security.japan.jpx.tdnet.Consolidate;
import yokwe.security.japan.jpx.tdnet.Detail;
import yokwe.security.japan.jpx.tdnet.Period;
import yokwe.security.japan.jpx.tdnet.SummaryFilename;
import yokwe.security.japan.xbrl.report.REITReport;
import yokwe.security.japan.xbrl.report.StockReport;

public class UpdateDividendAnnual {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateDividendAnnual.class);
	
	public static void main(String[] args) {
		logger.info("START");
		
		Map<String, List<DividendAnnual>> stockCodeMap = new TreeMap<>();
		// key is stockCode
		
		// From StcokReport
		{
			Map<SummaryFilename, StockReport> reportMap = StockReport.getMap();
			logger.info("StockReport reportMap {}", reportMap.size());
			
			int count = 0;
			for(Map.Entry<SummaryFilename, StockReport> entry: reportMap.entrySet()) {
				SummaryFilename key    = entry.getKey();
				StockReport     value = entry.getValue();
				if ((count % 1000) == 0) {
					logger.info("{} {}", String.format("%5d / %5d", count, reportMap.size()), key);
				}
				count++;
				
				// Skip no dividend record
				if (value.dividendPayableDateAsPlanned.isEmpty()) continue;
				
				final String  stockCode = value.stockCode;
				final Double  dividend  = value.annualDividendPerShare.doubleValue();
				final int     divcount  = 0; // FIXME
				
				final String  yearEnd   = value.yearEnd;
				final Integer quarter   = value.quarterlyPeriod;
				
				final SummaryFilename filename = value.filename;

				String         mapKey    = stockCode;
				DividendAnnual mapValue = new DividendAnnual(stockCode, dividend, divcount, yearEnd, quarter, filename);

				// Sanity check
				{
					if (stockCode.isEmpty()) {
						logger.warn("stockCode is null {}", mapValue);
						continue;
					}
					if (yearEnd.isEmpty()) {
						logger.warn("yearEnd is null {}", mapValue);
						continue;
					}
				}
				
				final List<DividendAnnual> oldValue;
				if (stockCodeMap.containsKey(mapKey)) {
					oldValue = stockCodeMap.get(mapKey);
				} else {
					oldValue = new ArrayList<>();
					stockCodeMap.put(mapKey, oldValue);
				}
				oldValue.add(mapValue);
			}
		}
		
		// From StcokREIT
		{
			Map<SummaryFilename, REITReport> reportMap = REITReport.getMap();
			logger.info("REITReport  reportMap {}", reportMap.size());
			
			int count = 0;
			for(Map.Entry<SummaryFilename, REITReport> entry: reportMap.entrySet()) {
				SummaryFilename key    = entry.getKey();
				REITReport     value = entry.getValue();
				if ((count % 1000) == 0) {
					logger.info("{} {}", String.format("%5d / %5d", count, reportMap.size()), key);
				}
				count++;
				
				// Skip no dividend record
				if (value.distributionsDate.isEmpty()) continue;
				
				final String  stockCode = value.stockCode;
				final Double  dividend  = value.distributionsPerUnit.doubleValue() + value.distributionsInExcessOfProfitPerUnit.doubleValue();
				final int     divCount  = 0; // FIXME
				final String  yearEnd   = value.yearEnd;
				final Integer quarter   = 4;
				
				final SummaryFilename filename = value.filename;

				String         mapKey    = stockCode;
				DividendAnnual mapValue = new DividendAnnual(stockCode, dividend, divCount, yearEnd, quarter, filename);

				// Sanity check
				{
					if (stockCode.isEmpty()) {
						logger.warn("stockCode is null {}", mapValue);
						continue;
					}
					if (yearEnd.isEmpty()) {
						logger.warn("yearEnd is null {}", mapValue);
						continue;
					}
				}
				
				final List<DividendAnnual> oldValue;
				if (stockCodeMap.containsKey(mapKey)) {
					oldValue = stockCodeMap.get(mapKey);
				} else {
					oldValue = new ArrayList<>();
					stockCodeMap.put(mapKey, oldValue);
				}
				oldValue.add(mapValue);
			}
		}
		
		// From DividendETF
		{
			Map<String, List<DividendETF>> map = DividendETF.getMap();
			logger.info("DividendETF  map {}", map.size());
			for(List<DividendETF> list: map.values()) {
				Collections.sort(list);
				DividendETF last = list.get(list.size() - 1);
				LocalDate lastDate = LocalDate.parse(last.date);
				LocalDate firstDate = lastDate.minusYears(1);
				
				if (!last.currency.equals("JPY")) continue;
				
				double annualDividend = 0;
				for(DividendETF e: list) {
					LocalDate date = LocalDate.parse(e.date);
					
					if (date.isAfter(firstDate) && (date.isBefore(lastDate) || date.isEqual(lastDate))) {
						annualDividend += (e.dividend / e.unit);
					}
				}
				
				final String  stockCode = last.stockCode;
				final String  tednetCode = String.format("%s0", stockCode);
				final Double  dividend  = annualDividend;
				final int     divCount  = 0; // FIXME
				final String  yearEnd   = lastDate.toString();
				final Integer quarter   = 4;
				
				//   tse-qcedjpsm-71770-20170725371770-ixbrl.htm

				String id = String.format("%s3%s", last.record, tednetCode);
				final SummaryFilename filename = new SummaryFilename(Period.ANNUAL.value, Consolidate.NOT_CONSOLIDATE.value, Category.EFJP.value, Detail.SUMMARY.value, tednetCode, id);

				String               mapKey   = stockCode;
				List<DividendAnnual> mapValue = new ArrayList<>();
				mapValue.add(new DividendAnnual(last.stockCode, dividend, divCount, yearEnd, quarter, filename));

				if (stockCodeMap.containsKey(mapKey)) {
					// duplicate
					logger.error("Duplicate stockCode");
					logger.error("  old {}", stockCodeMap.get(mapKey));
					logger.error("  new {}", mapValue);
					throw new UnexpectedException("Duplicate stockCode");
				} else {
					stockCodeMap.put(mapKey, mapValue);
				}
			}
		}		

		logger.info("stockCodeMap {}", stockCodeMap.size());
		{
			List<DividendAnnual> dividendList = new ArrayList<>();
			for(List<DividendAnnual> list: stockCodeMap.values()) {
				Collections.sort(list);
				DividendAnnual last = list.get(list.size() - 1);
				dividendList.add(last);
			}
			logger.info("save {}  {}", DividendAnnual.PATH_FILE, dividendList.size());
			DividendAnnual.save(dividendList);
			logger.info("dividendList {}", dividendList.size());
		}

		logger.info("STOP");
	}
}
