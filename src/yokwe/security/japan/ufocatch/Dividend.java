package yokwe.security.japan.ufocatch;

import java.math.BigDecimal;

import yokwe.security.japan.xbrl.DividendBriefReport;

public class Dividend implements Comparable<Dividend> {
	public String     code;
	public String     yearEnd;
	public Integer    quarter;
	public String     date;
	public BigDecimal value;
	
	public String     file; // file name of data source
	
	Dividend(DividendBriefReport data, String file) {
		this.code     = data.securitiesCode;
		this.yearEnd  = data.fiscalYearEnd;
		this.quarter  = data.quarterlyPeriod;
		this.date     = data.dividendPayableDateAsPlanned;
		this.value    = data.dividendPerShare;
		this.file     = file;
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
					this.code.equals(that.code) &&
					this.yearEnd.equals(that.yearEnd) &&
					this.quarter.equals(that.quarter) &&
					this.date.equals(that.date) &&
					this.value.equals(that.value);
			} else {
				return false;
			}
		}
	}
	@Override
	public String toString() {
		return String.format("{%s %s %s %s %s %s}", code, yearEnd, quarter, date, value, file);
	}
	@Override
	public int compareTo(Dividend that) {
		int ret = this.code.compareTo(that.code);
		if (ret == 0) ret = this.yearEnd.compareTo(that.yearEnd);
		if (ret == 0) ret = this.quarter.compareTo(that.quarter);
		return ret;
	}
}