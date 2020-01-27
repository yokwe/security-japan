package yokwe.security.japan.xbrl;

import java.io.File;
import java.math.BigDecimal;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL;
import yokwe.util.XMLUtil;

public class DividendBriefReport extends BriefReport {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DividendBriefReport.class);

	@Context(name = TSE_ED_T_LABEL.DOCUMENT_NAME_NAME)
	String defaultContextRef;
	
	@Value(name = TSE_ED_T_LABEL.DOCUMENT_NAME_NAME)
	String documentName;
	
	@Value(name = TSE_ED_T_LABEL.FILING_DATE_NAME)
	String filingDate;
	
	@Value(name = TSE_ED_T_LABEL.COMPANY_NAME_NAME)
	String companyName;
	
	@Value(name = TSE_ED_T_LABEL.SECURITIES_CODE_NAME)
	String securitiesCode;

	@Value(name = TSE_ED_T_LABEL.QUARTERLY_STATEMENT_FILING_DATE_AS_PLANNED_NAME)
	String quarterlyStatementFilingDateAsPlanned;
	
	@Value(name = TSE_ED_T_LABEL.DIVIDEND_PAYABLE_DATE_AS_PLANNED_NAME)
	String dividendPayableDateAsPlanned;
	
	@Value(name = TSE_ED_T_LABEL.DIVIDEND_PAYABLE_DATE_AS_PLANNED_NAME,
			contexts = {"CurrentYearDuration", "ResultMember", "FirstQuaterMember"},
			acceptNull = true)
	double dividendPerShareQ1; // PriorYearDuration/CurrentYearDuration FirstQuaterMember/SecondQuaterMember/ThirdQuaterMember/YearEndMember/AnnualMember

	@Value(name = TSE_ED_T_LABEL.DIVIDEND_PAYABLE_DATE_AS_PLANNED_NAME,
			contexts = {"CurrentYearDuration", "ResultMember", "SecondQuaterMember"},
			acceptNull = true)
	BigDecimal dividendPerShareQ2; // PriorYearDuration/CurrentYearDuration FirstQuaterMember/SecondQuaterMember/ThirdQuaterMember/YearEndMember/AnnualMember

	@Value(name = TSE_ED_T_LABEL.DIVIDEND_PAYABLE_DATE_AS_PLANNED_NAME,
			contexts = {"CurrentYearDuration", "ResultMember", "ThirdQuaterMember"},
			acceptNull = true)
	BigDecimal dividendPerShareQ3; // PriorYearDuration/CurrentYearDuration FirstQuaterMember/SecondQuaterMember/ThirdQuaterMember/YearEndMember/AnnualMember

	@Value(name = TSE_ED_T_LABEL.DIVIDEND_PAYABLE_DATE_AS_PLANNED_NAME,
			contexts = {"CurrentYearDuration", "ResultMember", "YearEndMember"},
			acceptNull = true)
	BigDecimal dividendPerShareQ4; // PriorYearDuration/CurrentYearDuration FirstQuaterMember/SecondQuaterMember/ThirdQuaterMember/YearEndMember/AnnualMember

	public static void main(String[] args) {
		logger.info("START");
		
		File file = new File("tmp/TD2019111900049/XBRLData/Summary/tse-scedjpsm-87250-20191010407057-ixbrl.htm");

		
		DividendBriefReport briefReport = new DividendBriefReport();
		briefReport.init(XMLUtil.buildStream(file));
		
		logger.info("STOP");
	}
}
