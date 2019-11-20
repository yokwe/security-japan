package yokwe.security.japan.jpx;

import yokwe.util.libreoffice.Sheet;
import yokwe.util.libreoffice.SpreadSheet;


@Sheet.SheetName("Sheet1")
@Sheet.HeaderRow(0)
@Sheet.DataRow(1)
public class ListedIssue extends Sheet implements Comparable<ListedIssue> {	
	public static final String URL_DOWNLOAD  = "https://www.jpx.co.jp/markets/statistics-equities/misc/tvdivq0000001vg2-att/data_j.xls";
	public static final String PATH_DOWNLOAD = "tmp/download/ListedIssue.xls";
	public static final String PATH_DATA     = "tmp/data/listedIssue.csv";

	@ColumnName("日付")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public String date;
	
	@ColumnName("コード")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public String code;
	
	@ColumnName("銘柄名")
	public String name;
	
	@ColumnName("市場・商品区分")
	public String market;
	
	@ColumnName("33業種コード")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public String sector33Code;
	
	@ColumnName("33業種区分")
	public String sector33;
	
	@ColumnName("17業種コード")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public String sector17Code;
	
	@ColumnName("17業種区分")
	public String sector17;
	
	@ColumnName("規模コード")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public String scaleCode;
	
	@ColumnName("規模区分")
	public String scale;
	
	@Override
	public String toString() {
		if (market.compareTo("ETF・ETN") == 0) {
			return String.format("%s %s %s %s", date, code, name, market);
		} else {
			return String.format("%s %s %s %s %s %s %s %s %s %s", date, code, name, market, sector33Code, sector33, sector17Code, sector17, scale, scaleCode);
		}
	}

	@Override
	public int compareTo(ListedIssue that) {
		int ret = this.date.compareTo(that.date);
		if (ret == 0) ret = this.code.compareTo(that.code);
		return ret;
	}
}
