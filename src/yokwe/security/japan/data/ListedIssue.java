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

public class ListedIssue implements Comparable<ListedIssue> {	
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(ListedIssue.class);

	public static final String URL_DOWNLOAD  = "https://www.jpx.co.jp/markets/statistics-equities/misc/tvdivq0000001vg2-att/data_j.xls";
	public static final String PATH_DOWNLOAD = "tmp/download/listed-issue.xls";
	public static final String PATH_DATA     = "tmp/data/listed-issue.csv";
	
	public static final String MARKET_ETF    = "ETF・ETN";
	public static final String MARKET_REIT   = "REIT・ベンチャーファンド・カントリーファンド・インフラファンド";
	
	private static List<ListedIssue> all = null;
	public static List<ListedIssue> load() {
		if (all == null) {
			all = CSVUtil.read(ListedIssue.class).file(PATH_DATA);
		}
		return all;
	}
	private static Map<String, ListedIssue> map = null;
	public static Map<String, ListedIssue> getMap() {
		if (map == null) {
			List<ListedIssue> list = load();
			
			map = new TreeMap<>();
			for(ListedIssue e: list) {
				String stockCode = e.stockCode;
				if (map.containsKey(stockCode)) {
					logger.error("Duplicate stockCode {}", stockCode);
					throw new UnexpectedException("Duplicate stockCode");
				} else {
					map.put(stockCode, e);
				}
			}
		}
		return map;
	}
	public static void save(Collection<ListedIssue> collection) {
		save(new ArrayList<>(collection));
	}
	public static void save(List<ListedIssue> list) {
		if (list.isEmpty()) return;
		
		// Sort before save
		Collections.sort(list);
		CSVUtil.write(ListedIssue.class).file(PATH_DATA, list);
	}

	@CSVUtil.ColumnName("日付")
	public String date; // YYYY-MM-DD
	
	@CSVUtil.ColumnName("コード")
	public String stockCode; // Can be four or five digits
	
	@CSVUtil.ColumnName("銘柄名")
	public String name;
	
	@CSVUtil.ColumnName("市場・商品区分")
	public String market;
	
	@CSVUtil.ColumnName("33業種コード")
	public String sector33Code;
	
	@CSVUtil.ColumnName("33業種区分")
	public String sector33;
	
	@CSVUtil.ColumnName("17業種コード")
	public String sector17Code;
	
	@CSVUtil.ColumnName("17業種区分")
	public String sector17;
	
	@CSVUtil.ColumnName("規模コード")
	public String scaleCode;
	
	@CSVUtil.ColumnName("規模区分")
	public String scale;
	
	@Override
	public String toString() {
		if (market.compareTo(MARKET_ETF) == 0) {
			return String.format("%s %s %s %s", date, stockCode, name, market);
		} else {
			return String.format("%s %s %s %s %s %s %s %s %s %s", date, stockCode, name, market, sector33Code, sector33, sector17Code, sector17, scale, scaleCode);
		}
	}
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o instanceof ListedIssue) {
			ListedIssue that = (ListedIssue)o;
			return this.date.equals(that.date) &&
					this.stockCode.equals(that.stockCode) &&
					this.name.equals(that.name) &&
					this.market.equals(that.market) &&
					this.sector33.equals(that.sector33) && this.sector33Code.equals(that.sector33Code) &&
					this.sector17.equals(that.sector17) && this.sector17Code.equals(that.sector17Code) &&
					this.scale.equals(that.scale) && this.scaleCode.equals(that.scaleCode);
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(ListedIssue that) {
		int ret = this.date.compareTo(that.date);
		if (ret == 0) ret = this.stockCode.compareTo(that.stockCode);
		return ret;
	}
}
