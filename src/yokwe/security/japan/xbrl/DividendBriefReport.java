package yokwe.security.japan.xbrl;

import static yokwe.security.japan.xbrl.InlineXBRL.Context.CURRENT_YEAR_DURATION;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.FIRST_QUARTER_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.LOWER_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.SECOND_QUARTER_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.THIRD_QUARTER_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.UPPER_MEMBER;
import static yokwe.security.japan.xbrl.InlineXBRL.Context.YEAR_END_MEMBER;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.COMPANY_NAME;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.DIVIDEND_PAYABLE_DATE_AS_PLANNED;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.DIVIDEND_PER_SHARE;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.DOCUMENT_NAME;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.FILING_DATE;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.QUARTERLY_STATEMENT_FILING_DATE_AS_PLANNED;
import static yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL.SECURITIES_CODE;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.slf4j.LoggerFactory;

import yokwe.util.XMLUtil;

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

	@Value(label = QUARTERLY_STATEMENT_FILING_DATE_AS_PLANNED)
	public String quarterlyStatementFilingDateAsPlanned;
	
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
	
	@Override
	public String toString() {
		return String.format("%s %s %s %s %s %s %s %s", filingDate, securitiesCode, companyName, dividendPayableDateAsPlanned, dividendPerShareQ1, dividendPerShareQ2, dividendPerShareQ3, dividendPerShareQ4);
	}

	public static void main(String[] args) {
		logger.info("START");
		
		File file = new File("tmp/TD2019111900049/XBRLData/Summary/tse-scedjpsm-87250-20191010407057-ixbrl.htm");

		InlineXBRL.Document document = InlineXBRL.Document.getInstance(XMLUtil.buildStream(file));
		
//		DividendBriefReport briefReport = new DividendBriefReport();
//		briefReport.init(document);
		
		DividendBriefReport briefReport = BriefReport.getInstance(DividendBriefReport.class, document);
		
		logger.info("briefReport {}", briefReport);
		logger.info("STOP");
	}
}
