package yokwe.security.japan.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import yokwe.security.japan.xbrl.inline.InlineXBRL;
import yokwe.security.japan.xbrl.report.DistributionReport;
import yokwe.util.CSVUtil;
import yokwe.util.DoubleUtil;

public class DistributionAll implements Comparable<DistributionAll> {
	public static final String PATH_FILE = "tmp/data/distribution-all.csv";

	public static List<DistributionAll> load() {
		return CSVUtil.read(DistributionAll.class).file(PATH_FILE);
	}
	public static void save(Collection<DistributionAll> collection) {
		List<DistributionAll> list = new ArrayList<>(collection);
		save(list);
	}
	public static void save(List<DistributionAll> list) {
		// Sort before save
		Collections.sort(list);
		CSVUtil.write(DistributionAll.class).file(PATH_FILE, list);
	}


	public String stockCode; // Can be four or five digits
	public String yearEnd;   // YYYY-MM-DD
	public String date;      // YYYY-MM-DD
	
	public double distribution;
	public double distributionExcess;
	public double payoutRatio;
	
	public String file; // file name of data source
	
	public DistributionAll() {
		stockCode = null;
		yearEnd   = null;
		date      = null;
		
		distribution       = 0;
		distributionExcess = 0;
		payoutRatio        = 0;
		
		file         = null;
	}
	
	DistributionAll(DistributionReport data, String file) {
		this.stockCode = InlineXBRL.normalizeNumberCharacter(data.stockCode);
		// Trim stockCode to 4 digits if possible.
		if (stockCode.length() == 5 && stockCode.charAt(4) == '0') {
			this.stockCode = this.stockCode.substring(0, 4);
		}
		this.yearEnd = data.yearEnd;
		this.date    = data.distributionsDate;
		
		this.distribution       = data.distributionsPerUnit.doubleValue();
		this.distributionExcess = data.distributionsInExcessOfProfitPerUnit.doubleValue();
		this.payoutRatio        = data.payoutRatio.doubleValue();
		
		this.file    = file;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else {
			if (o instanceof DistributionAll) {
				DistributionAll that = (DistributionAll)o;
				// Don't consider field file.
				return
					this.stockCode.equals(that.stockCode) &&
					this.yearEnd.equals(that.yearEnd) &&
					this.date.equals(that.date) &&
					DoubleUtil.isAlmostEqual(this.distribution, that.distribution) &&
					DoubleUtil.isAlmostEqual(this.distributionExcess, that.distributionExcess) &&
					DoubleUtil.isAlmostEqual(this.payoutRatio, that.payoutRatio);
			} else {
				return false;
			}
		}
	}
	@Override
	public String toString() {
		return String.format("{%s %s %s %.2f %.2f %.2f %s}", stockCode, yearEnd, date, distribution, distributionExcess, payoutRatio, file);
	}
	@Override
	public int compareTo(DistributionAll that) {
		int ret = this.stockCode.compareTo(that.stockCode);
		if (ret == 0) ret = this.yearEnd.compareTo(that.yearEnd);
		if (ret == 0) ret = this.date.compareTo(that.date);
		return ret;
	}
}