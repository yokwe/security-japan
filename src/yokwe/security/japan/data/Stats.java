package yokwe.security.japan.data;

import java.util.List;

import yokwe.util.libreoffice.Sheet;
import yokwe.util.libreoffice.SpreadSheet;
import yokwe.util.CSVUtil;

@Sheet.SheetName("stats")
@Sheet.HeaderRow(0)
@Sheet.DataRow(1)
public class Stats extends Sheet {
	public static final String PATH_STATS        = "tmp/data/stats.csv";

	public static void save(List<Stats> statsList) {
		CSVUtil.write(Stats.class).file(PATH_STATS, statsList);
	}
	
	public static List<Stats> load() {
		return CSVUtil.read(Stats.class).file(PATH_STATS);
	}

	
	//	public String exchange;
	@ColumnName("stockCode")
	@NumberFormat(SpreadSheet.FORMAT_STRING)
	public String stockCode;
	
	@ColumnName("name")
	@NumberFormat(SpreadSheet.FORMAT_STRING)
	public String name;
	
	// last values
	@ColumnName("date")
	@NumberFormat(SpreadSheet.FORMAT_DATE)
	public String date;
	
	@ColumnName("price")
	@NumberFormat(SpreadSheet.FORMAT_NUMBER2)
	public double price;
	
	// price
	@ColumnName("pricec")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public int    pricec;
	
	@ColumnName("sd")
	@NumberFormat("#,##0.0000")
	public double sd;
	
	@ColumnName("hv")
	@NumberFormat("#,##0.0000")
	public double hv;
	
	@ColumnName("rsi")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public double rsi;

	@ColumnName("min")
	@NumberFormat(SpreadSheet.FORMAT_NUMBER2)
	public double min;
	
	@ColumnName("max")
	@NumberFormat(SpreadSheet.FORMAT_NUMBER2)
	public double max;
	
	@ColumnName("minpct")
	@NumberFormat(SpreadSheet.FORMAT_PERCENT)
	public double minpct;
	
	@ColumnName("maxpct")
	@NumberFormat(SpreadSheet.FORMAT_PERCENT)
	public double maxpct;

	// dividend
	@ColumnName("div")
	@NumberFormat("#,##0.0000")
	public double div;
	
	@ColumnName("divc")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public int    divc;
	
	@ColumnName("yield")
	@NumberFormat(SpreadSheet.FORMAT_PERCENT)
	public double yield;
	
	@ColumnName("yieldadj")
	@NumberFormat(SpreadSheet.FORMAT_PERCENT)
	public double yieldadj;
	
	// volume
	@ColumnName("vol")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public long   vol;
	
	@ColumnName("vol5")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public long   vol5;
	
	@ColumnName("vol30")
	@NumberFormat(SpreadSheet.FORMAT_INTEGER)
	public long   vol30;
	
	// price change detection
	@ColumnName("sma5")
	@NumberFormat(SpreadSheet.FORMAT_NUMBER2)
	public double sma5;
	
	@ColumnName("sma20")
	@NumberFormat(SpreadSheet.FORMAT_NUMBER2)
	public double sma20;
	
	@ColumnName("sma50")
	@NumberFormat(SpreadSheet.FORMAT_NUMBER2)
	public double sma50;
	
	@ColumnName("sma200")
	@NumberFormat(SpreadSheet.FORMAT_NUMBER2)
	public double sma200;
	
	@ColumnName("sma5pct")
	@NumberFormat(SpreadSheet.FORMAT_PERCENT)
	public double sma5pct;
	
	@ColumnName("sma20pct")
	@NumberFormat(SpreadSheet.FORMAT_PERCENT)
	public double sma20pct;
	
	@ColumnName("sma50pct")
	@NumberFormat(SpreadSheet.FORMAT_PERCENT)
	public double sma50pct;
	
	@ColumnName("sma200pct")
	@NumberFormat(SpreadSheet.FORMAT_PERCENT)
	public double sma200pct;

	@ColumnName("last")
	@NumberFormat(SpreadSheet.FORMAT_NUMBER2)
	public double last;
	
	@ColumnName("lastpct")
	@NumberFormat(SpreadSheet.FORMAT_PERCENT)
	public double lastpct;
}
