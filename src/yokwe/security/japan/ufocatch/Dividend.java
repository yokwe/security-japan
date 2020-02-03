package yokwe.security.japan.ufocatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import yokwe.security.japan.xbrl.DividendBriefReport;
import yokwe.util.CSVUtil;
import yokwe.util.DoubleUtil;

public class Dividend implements Comparable<Dividend> {
	public static final String PATH_FILE = "tmp/data/dividend.csv";

	public static List<Dividend> load() {
		return CSVUtil.read(Dividend.class).file(PATH_FILE);
	}
	public static void save(Collection<Dividend> collection) {
		List<Dividend> list = new ArrayList<>(collection);
		save(list);
	}
	public static void save(List<Dividend> list) {
		// Sort before save
		Collections.sort(list);
		CSVUtil.write(Dividend.class).file(PATH_FILE, list);
	}


	public String stockCode; // Can be four or five digits
	public String yearEnd;   // YYYY-MM-DD
	public int    quarter;
	public String date;      // YYYY-MM-DD
	public double value;
	
	public String     file; // file name of data source
	
	Dividend(DividendBriefReport data, String file) {
		this.stockCode = data.securitiesCode;
		// Trim stockCode to 4 digits if possible.
		if (stockCode.length() == 5 && stockCode.charAt(4) == '0') {
			this.stockCode = this.stockCode.substring(0, 4);
		}
		this.yearEnd   = data.fiscalYearEnd;
		this.quarter   = data.quarterlyPeriod;
		this.date      = data.dividendPayableDateAsPlanned;
		this.value     = data.dividendPerShare.doubleValue();
		this.file      = file;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else {
			if (o instanceof Dividend) {
				Dividend that = (Dividend)o;
				// Don't consider field file.
				return
					this.stockCode.equals(that.stockCode) &&
					this.yearEnd.equals(that.yearEnd) &&
					this.quarter == that.quarter &&
					this.date.equals(that.date) &&
					DoubleUtil.isAlmostEqual(this.value, that.value);
			} else {
				return false;
			}
		}
	}
	@Override
	public String toString() {
		return String.format("{%s %s %d %s %.2f %s}", stockCode, yearEnd, quarter, date, value, file);
	}
	@Override
	public int compareTo(Dividend that) {
		int ret = this.stockCode.compareTo(that.stockCode);
		if (ret == 0) ret = this.yearEnd.compareTo(that.yearEnd);
		if (ret == 0) ret = this.quarter - that.quarter;
		return ret;
	}
}