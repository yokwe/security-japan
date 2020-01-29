package yokwe.security.japan.xbrl;

import java.io.File;
import java.math.BigDecimal;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL;
import yokwe.security.japan.xbrl.InlineXBRL.Context;
import yokwe.util.XMLUtil;

public class DividendBriefReport extends BriefReport {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DividendBriefReport.class);

	@Value(name = TSE_ED_T_LABEL.DOCUMENT_NAME_NAME)
	public String documentName;
	
	@Value(name = TSE_ED_T_LABEL.FILING_DATE_NAME)
	public String filingDate;
	
	@Value(name = TSE_ED_T_LABEL.COMPANY_NAME_NAME)
	public String companyName;
	
	@Value(name = TSE_ED_T_LABEL.SECURITIES_CODE_NAME)
	public String securitiesCode;

	@Value(name = TSE_ED_T_LABEL.QUARTERLY_STATEMENT_FILING_DATE_AS_PLANNED_NAME)
	public String quarterlyStatementFilingDateAsPlanned;
	
	@Value(name = TSE_ED_T_LABEL.DIVIDEND_PAYABLE_DATE_AS_PLANNED_NAME)
	public String dividendPayableDateAsPlanned;
	
	@Value(name = TSE_ED_T_LABEL.DIVIDEND_PER_SHARE_NAME,
			contextIncludeAll = {Context.CURRENT_YEAR_DURATION, Context.FIRST_QUARTER_MEMBER},
			contextExcludeAny = {Context.LOWER_MEMBER, Context.UPPER_MEMBER},
			acceptNull = true)
	public BigDecimal dividendPerShareQ1; // PriorYearDuration/CurrentYearDuration FirstQuarterMember/SecondQuarterMember/ThirdQuarterMember/YearEndMember/AnnualMember

	@Value(name = TSE_ED_T_LABEL.DIVIDEND_PER_SHARE_NAME,
			contextIncludeAll = {Context.CURRENT_YEAR_DURATION, Context.SECOND_QUARTER_MEMBER},
			contextExcludeAny = {Context.LOWER_MEMBER, Context.UPPER_MEMBER},
			acceptNull = true)
	public BigDecimal dividendPerShareQ2; // PriorYearDuration/CurrentYearDuration FirstQuarterMember/SecondQuarterMember/ThirdQuarterMember/YearEndMember/AnnualMember

	@Value(name = TSE_ED_T_LABEL.DIVIDEND_PER_SHARE_NAME,
			contextIncludeAll = {Context.CURRENT_YEAR_DURATION, Context.THIRD_QUARTER_MEMBER},
			contextExcludeAny = {Context.LOWER_MEMBER, Context.UPPER_MEMBER},
			acceptNull = true)
	public BigDecimal dividendPerShareQ3; // PriorYearDuration/CurrentYearDuration FirstQuarterMember/SecondQuarterMember/ThirdQuarterMember/YearEndMember/AnnualMember

	@Value(name = TSE_ED_T_LABEL.DIVIDEND_PER_SHARE_NAME,
			contextIncludeAll = {Context.CURRENT_YEAR_DURATION, Context.YEAR_END_MEMBER},
			contextExcludeAny = {Context.LOWER_MEMBER, Context.UPPER_MEMBER},
			acceptNull = true)
	public BigDecimal dividendPerShareQ4; // PriorYearDuration/CurrentYearDuration FirstQuarterMember/SecondQuarterMember/ThirdQuarterMember/YearEndMember/AnnualMember

	public static void main(String[] args) {
		logger.info("START");
		
		File file = new File("tmp/TD2019111900049/XBRLData/Summary/tse-scedjpsm-87250-20191010407057-ixbrl.htm");

		InlineXBRL.Document document = InlineXBRL.Document.getInstance(XMLUtil.buildStream(file));
		DividendBriefReport briefReport = new DividendBriefReport();
		briefReport.init(document);
		
		logger.info("STOP");
	}
}
