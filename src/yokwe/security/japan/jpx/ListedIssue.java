package yokwe.security.japan.jpx;

import yokwe.util.CSVUtil;
import yokwe.util.libreoffice.Sheet;
import yokwe.util.libreoffice.SpreadSheet;


@Sheet.SheetName("Sheet1")
@Sheet.HeaderRow(0)
@Sheet.DataRow(1)
public class ListedIssue extends Sheet implements Comparable<ListedIssue> {	
	public static final String URL_DOWNLOAD  = "https://www.jpx.co.jp/markets/statistics-equities/misc/tvdivq0000001vg2-att/data_j.xls";
	public static final String PATH_DOWNLOAD = "tmp/download/ListedIssue.xls";
	public static final String PATH_DATA     = "tmp/data/listedIssue.csv";
	
	public static final String MARKET_ETF    = "ETF・ETN";

	@Sheet.ColumnName("日付")
	@CSVUtil.ColumnName("日付")
	@Sheet.NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public String date;
	
	@Sheet.ColumnName("コード")
	@CSVUtil.ColumnName("コード")
	@Sheet.NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public String stockCode;
	
	@Sheet.ColumnName("銘柄名")
	@CSVUtil.ColumnName("銘柄名")
	public String name;
	
	@Sheet.ColumnName("市場・商品区分")
	@CSVUtil.ColumnName("市場・商品区分")
	public String market;
	
	@Sheet.ColumnName("33業種コード")
	@Sheet.NumberFormat(SpreadSheet.FORMAT_INTEGER)
	@CSVUtil.ColumnName("33業種コード")
	public String sector33Code;
	
	@Sheet.ColumnName("33業種区分")
	@CSVUtil.ColumnName("33業種区分")
	public String sector33;
	
	@Sheet.ColumnName("17業種コード")
	@Sheet.NumberFormat(SpreadSheet.FORMAT_INTEGER)
	@CSVUtil.ColumnName("17業種コード")
	public String sector17Code;
	
	@Sheet.ColumnName("17業種区分")
	@CSVUtil.ColumnName("17業種区分")
	public String sector17;
	
	@Sheet.ColumnName("規模コード")
	@Sheet.NumberFormat(SpreadSheet.FORMAT_INTEGER)
	@CSVUtil.ColumnName("規模コード")
	public String scaleCode;
	
	@Sheet.ColumnName("規模区分")
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
