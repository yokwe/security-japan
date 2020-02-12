package yokwe.security.japan.xbrl.report;

import static yokwe.security.japan.xbrl.inline.Context.CURRENT_YEAR_DURATION;
import static yokwe.security.japan.xbrl.inline.Context.RESULT_MEMBER;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_PER_UNIT_REIT;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.DISTRIBUTIONS_PAYABLE_DATE_AS_PLANNED_REIT;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.DISTRIBUTIONS_PER_UNIT_EXCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.DOCUMENT_NAME;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.FILING_DATE;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.FISCAL_YEAR_END;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.ISSUER_NAME_REIT;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.PAYOUT_RATIO;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.SECURITIES_CODE;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.xbrl.inline.Document;

public class DistributionReport extends AbstractReport implements Comparable<DistributionReport> {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DistributionReport.class);

	@TSE_RE(label = DOCUMENT_NAME)
	public String documentName;
	
	@TSE_RE(label = FILING_DATE)
	public LocalDate filingDate;
	
	@TSE_RE(label = ISSUER_NAME_REIT)
	public String company;
	
	@TSE_RE(label = SECURITIES_CODE)
	public String stockCode;
	
	@TSE_RE(label = FISCAL_YEAR_END)
	public String yearEnd;
	
	// DIVIDEND
	@TSE_RE(label = DISTRIBUTIONS_PAYABLE_DATE_AS_PLANNED_REIT,
			acceptNullOrEmpty = true)
	public String distributionsDate;
	
	@TSE_RE(label = DISTRIBUTIONS_PER_UNIT_EXCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT,
			contextIncludeAll = {CURRENT_YEAR_DURATION, RESULT_MEMBER},
			acceptNullOrEmpty = true)
	public BigDecimal distributionsPerUnit;

	@TSE_RE(label = DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_PER_UNIT_REIT,
			contextIncludeAll = {CURRENT_YEAR_DURATION, RESULT_MEMBER},
			acceptNullOrEmpty = true)
	public BigDecimal distributionsInExcessOfProfitPerUnit;

	@TSE_RE(label = PAYOUT_RATIO,
			contextIncludeAll = {CURRENT_YEAR_DURATION, RESULT_MEMBER},
			acceptNullOrEmpty = true)
	public BigDecimal payoutRatio;
	
	
	public static DistributionReport getInstance(Document document) {
		DistributionReport ret = AbstractReport.getInstance(DistributionReport.class, document);

		return ret;
	}
	
	@Override
	public String toString() {
		return String.format("{%s %s %s %s %s %s}",  stockCode, yearEnd, filingDate, distributionsDate, distributionsPerUnit, distributionsInExcessOfProfitPerUnit);
	}

	// Define natural ordering of DividendBriefReport
	@Override
	public int compareTo(DistributionReport that) {
		int ret = this.stockCode.compareTo(that.stockCode);
		if (ret == 0) ret = this.yearEnd.compareTo(that.yearEnd);
		if (ret == 0) ret = this.filingDate.compareTo(that.filingDate);
		return ret;
	}
}
