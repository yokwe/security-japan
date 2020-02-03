package yokwe.security.japan.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import yokwe.util.CSVUtil;

public class Dividend implements Comparable<Dividend> {
	public static final String PATH_DIR_DATA = "tmp/data/dividend";
	public static String getPath(String stockCode) {
		return String.format("%s/%s.csv", PATH_DIR_DATA, stockCode);
	}

	public static List<Dividend> load(String stockCode) {
		String path = getPath(stockCode);
		return CSVUtil.read(Dividend.class).file(path);
	}
	
	public static void save(String stockCode, Collection<Dividend> collection) {
		save(stockCode, new ArrayList<>(collection));
	}
	public static void save(String stockCode, List<Dividend> list) {
		String path = getPath(stockCode);
		
		// Sort before save
		Collections.sort(list);
		CSVUtil.write(Dividend.class).file(path, list);
	}
	
	
	public String date;
	public String stockCode;
	public double dividend;
	
	public Dividend(String date, String stockCode, double dividend) {
		this.date      = date;
		this.stockCode = stockCode;
		this.dividend  = dividend;
	}
	
	public Dividend() {
		this("", "", 0);
	}
	
	@Override
	public String toString() {
		return String.format("{%s %-9s %8.2f}", date, stockCode, dividend);
	}

	@Override
	public int compareTo(Dividend that) {
		int ret = this.date.compareTo(that.date);
		if (ret == 0) ret = this.stockCode.compareTo(that.stockCode);
		return ret;
	}
}
