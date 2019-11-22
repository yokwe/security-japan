package yokwe.security.japan.jpx;

import java.util.List;

import yokwe.util.CSVUtil;

public class ListedIssue implements Comparable<ListedIssue> {	
	public static final String URL_DOWNLOAD  = "https://www.jpx.co.jp/markets/statistics-equities/misc/tvdivq0000001vg2-att/data_j.xls";
	public static final String PATH_DOWNLOAD = "tmp/download/listed-issue.xls";
	public static final String PATH_DATA     = "tmp/data/listed-issue.csv";
	
	public static final String MARKET_ETF    = "ETF・ETN";
	
	public static List<ListedIssue> load() {
		return CSVUtil.read(ListedIssue.class).file(PATH_DATA);
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
	public int compareTo(ListedIssue that) {
		int ret = this.date.compareTo(that.date);
		if (ret == 0) ret = this.stockCode.compareTo(that.stockCode);
		return ret;
	}
}
