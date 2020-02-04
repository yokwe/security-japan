package yokwe.security.japan.xbrl.report;

import static yokwe.security.japan.xbrl.inline.Context.CURRENT_YEAR_DURATION;
import static yokwe.security.japan.xbrl.inline.Context.FIRST_QUARTER_MEMBER;
import static yokwe.security.japan.xbrl.inline.Context.LOWER_MEMBER;
import static yokwe.security.japan.xbrl.inline.Context.SECOND_QUARTER_MEMBER;
import static yokwe.security.japan.xbrl.inline.Context.THIRD_QUARTER_MEMBER;
import static yokwe.security.japan.xbrl.inline.Context.UPPER_MEMBER;
import static yokwe.security.japan.xbrl.inline.Context.YEAR_END_MEMBER;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.COMPANY_NAME;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.DIVIDEND_PAYABLE_DATE_AS_PLANNED;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.DIVIDEND_PER_SHARE;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.DOCUMENT_NAME;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.FILING_DATE;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.FISCAL_YEAR_END;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.QUARTERLY_PERIOD;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.QUARTERLY_STATEMENT_FILING_DATE_AS_PLANNED;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.SECURITIES_CODE;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.xbrl.inline.Document;

public class DividendBriefReport extends BriefReport implements Comparable<DividendBriefReport> {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DividendBriefReport.class);

	@Value(label = DOCUMENT_NAME)
	public String documentName;
	
	@Value(label = FILING_DATE)
	public LocalDate filingDate;
	
	@Value(label = COMPANY_NAME)
	public String companyName;
	
	@Value(label = SECURITIES_CODE)
	public String securitiesCode;
	
	@Value(label = FISCAL_YEAR_END)
	public String fiscalYearEnd;

	@Value(label = QUARTERLY_STATEMENT_FILING_DATE_AS_PLANNED)
	public String quarterlyStatementFilingDateAsPlanned;
	
	@Value(label = QUARTERLY_PERIOD)
	public Integer quarterlyPeriod;
	
	
	@Value(label = DIVIDEND_PAYABLE_DATE_AS_PLANNED)
	public String dividendPayableDateAsPlanned;
	
	@Value(label = DIVIDEND_PER_SHARE,
			contextIncludeAll = {CURRENT_YEAR_DURATION, FIRST_QUARTER_MEMBER},
			contextExcludeAny = {LOWER_MEMBER, UPPER_MEMBER},
			acceptNull = true)
	public BigDecimal dividendPerShareQ1; // PriorYearDuration/CurrentYearDuration FirstQuarterMember/SecondQuarterMember/ThirdQuarterMember/YearEndMember/AnnualMember

	@Value(label = DIVIDEND_PER_SHARE,
			contextIncludeAll = {CURRENT_YEAR_DURATION, SECOND_QUARTER_MEMBER},
			contextExcludeAny = {LOWER_MEMBER, UPPER_MEMBER},
			acceptNull = true)
	public BigDecimal dividendPerShareQ2; // PriorYearDuration/CurrentYearDuration FirstQuarterMember/SecondQuarterMember/ThirdQuarterMember/YearEndMember/AnnualMember

	@Value(label = DIVIDEND_PER_SHARE,
			contextIncludeAll = {CURRENT_YEAR_DURATION, THIRD_QUARTER_MEMBER},
			contextExcludeAny = {LOWER_MEMBER, UPPER_MEMBER},
			acceptNull = true)
	public BigDecimal dividendPerShareQ3; // PriorYearDuration/CurrentYearDuration FirstQuarterMember/SecondQuarterMember/ThirdQuarterMember/YearEndMember/AnnualMember

	@Value(label = DIVIDEND_PER_SHARE,
			contextIncludeAll = {CURRENT_YEAR_DURATION, YEAR_END_MEMBER},
			contextExcludeAny = {LOWER_MEMBER, UPPER_MEMBER},
			acceptNull = true)
	public BigDecimal dividendPerShareQ4; // PriorYearDuration/CurrentYearDuration FirstQuarterMember/SecondQuarterMember/ThirdQuarterMember/YearEndMember/AnnualMember
	
	public BigDecimal dividendPerShare;
	
	public static DividendBriefReport getInstance(Document document) {
		DividendBriefReport ret = BriefReport.getInstance(DividendBriefReport.class, document);

		if (ret.quarterlyPeriod == null) {
			ret.dividendPerShare = ret.dividendPerShareQ4;
			ret.quarterlyPeriod  = 4;
		} else {
			switch(ret.quarterlyPeriod) {
			case 1:
				ret.dividendPerShare = ret.dividendPerShareQ1;
				break;
			case 2:
				ret.dividendPerShare = ret.dividendPerShareQ2;
				break;
			case 3:
				ret.dividendPerShare = ret.dividendPerShareQ3;
				break;
			default:
				logger.error("Unexpected quarterlyPeriod {}", ret.quarterlyPeriod);
				throw new UnexpectedException("Unexpected quarterlyPeriod");
			}
		}

		return ret;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s %d %s %6s %s", securitiesCode, filingDate, fiscalYearEnd, quarterlyPeriod, dividendPayableDateAsPlanned, dividendPerShare, companyName);
	}

	// Define natural ordering of DividendBriefReport
	@Override
	public int compareTo(DividendBriefReport that) {
		int ret = this.securitiesCode.compareTo(that.securitiesCode);
		if (ret == 0) ret = this.fiscalYearEnd.compareTo(that.fiscalYearEnd);
		if (ret == 0) ret = this.quarterlyPeriod - that.quarterlyPeriod;
		if (ret == 0) ret = this.filingDate.compareTo(that.filingDate);
		return ret;
	}
}
