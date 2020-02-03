package yokwe.security.japan.ufocatch;

import yokwe.security.japan.xbrl.DividendBriefReport;
import yokwe.util.DoubleUtil;

public class Dividend implements Comparable<Dividend> {
	public String stockCode;
	public String yearEnd;
	public int    quarter;
	public String date;
	public double value;
	
	public String     file; // file name of data source
	
	Dividend(DividendBriefReport data, String file) {
		this.stockCode = data.securitiesCode;
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