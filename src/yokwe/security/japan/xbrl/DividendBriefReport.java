package yokwe.security.japan.xbrl;

import static yokwe.security.japan.xbrl.InlineXBRL.Context.CURRENT_YEAR_DURATION;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.FIRST_QUARTER_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.LOWER_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.RESULT_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.SECOND_QUARTER_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.THIRD_QUARTER_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.UPPER_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.YEAR_END_MEMBER;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.COMPANY_NAME;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.COMMEMORATIVE_DIVIDEND;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.DIVIDEND_PAYABLE_DATE_AS_PLANNED;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.DIVIDEND_PER_SHARE;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.DOCUMENT_NAME;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.EXTRA_DIVIDEND;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.FILING_DATE;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.FISCAL_YEAR_END;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.QUARTERLY_PERIOD;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.QUARTERLY_STATEMENT_FILING_DATE_AS_PLANNED;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.SECURITIES_CODE;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.slf4j.LoggerFactory;

public class DividendBriefReport extends BriefReport {
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
	
//	@Value(label = EXTRA_DIVIDEND,
//			contextIncludeAll = {RESULT_MEMBER},
//			acceptNull = true)
//	public BigDecimal extraDividend; // PriorYearDuration/CurrentYearDuration FirstQuarterMember/SecondQuarterMember/ThirdQuarterMember/YearEndMember/AnnualMember
//
//	@Value(label = COMMEMORATIVE_DIVIDEND,
//			contextIncludeAll = {RESULT_MEMBER},
//			acceptNull = true)
//	public BigDecimal commemorativeDividend; // PriorYearDuration/CurrentYearDuration FirstQuarterMember/SecondQuarterMember/ThirdQuarterMember/YearEndMember/AnnualMember

	public BigDecimal getDividendPerShare() {
		final BigDecimal dividendPerShare;
		switch(this.quarterlyPeriod) {
		case 1:
			dividendPerShare = dividendPerShareQ1;
			break;
		case 2:
			dividendPerShare = dividendPerShareQ2;
			break;
		case 3:
			dividendPerShare = dividendPerShareQ3;
			break;
		case 4:
			dividendPerShare = dividendPerShareQ4;
			break;
		default:
			logger.info("Unknown quarterlyPeriod {}", this.quarterlyPeriod);
			dividendPerShare = null;
		}
		
		return dividendPerShare;
	}
	@Override
	public String toString() {
		return String.format("%s %d %s %6s %s", securitiesCode, quarterlyPeriod, dividendPayableDateAsPlanned, getDividendPerShare(), companyName);
	}
}
