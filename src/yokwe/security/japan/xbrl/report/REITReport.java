package yokwe.security.japan.xbrl.report;

import static yokwe.security.japan.xbrl.inline.Context.CURRENT_YEAR_DURATION;
import static yokwe.security.japan.xbrl.inline.Context.RESULT_MEMBER;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_PER_UNIT_REIT;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.DISTRIBUTIONS_PAYABLE_DATE_AS_PLANNED_REIT;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.DISTRIBUTIONS_PER_UNIT_EXCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.FILING_DATE;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.FISCAL_YEAR_END;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.ISSUER_NAME_REIT;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.PAYOUT_RATIO;
import static yokwe.security.japan.xbrl.taxonomy.TSE_RE_T_LABEL.SECURITIES_CODE;

import java.math.BigDecimal;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.jpx.tdnet.SummaryFilename;
import yokwe.security.japan.xbrl.inline.Document;
import yokwe.util.CSVUtil.ColumnName;

public class REITReport extends AbstractReport implements Comparable<REITReport> {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(REITReport.class);

	@TSE_RE(label = FILING_DATE)
	@ColumnName("提出日")
	public String filingDate;
	
	@TSE_RE(label = ISSUER_NAME_REIT)
	@ColumnName("発行者名")
	public String company;
	
	@TSE_RE(label = SECURITIES_CODE)
	@ColumnName("コード番号")
	public String stockCode;
	
	@TSE_RE(label = FISCAL_YEAR_END)
	@ColumnName("決算期")
	public String yearEnd;
	
	// DIVIDEND
	@TSE_RE(label = DISTRIBUTIONS_PAYABLE_DATE_AS_PLANNED_REIT,
			acceptNullOrEmpty = true)
	@ColumnName("分配金支日")
	public String distributionsDate;
	
	@TSE_RE(label = DISTRIBUTIONS_PER_UNIT_EXCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT,
			contextIncludeAll = {CURRENT_YEAR_DURATION, RESULT_MEMBER},
			acceptNullOrEmpty = true)
	@ColumnName("分配金")
	public BigDecimal distributionsPerUnit;

	@TSE_RE(label = DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_PER_UNIT_REIT,
			contextIncludeAll = {CURRENT_YEAR_DURATION, RESULT_MEMBER},
			acceptNullOrEmpty = true)
	@ColumnName("利益超過分配金")
	public BigDecimal distributionsInExcessOfProfitPerUnit;

	@TSE_RE(label = PAYOUT_RATIO,
			contextIncludeAll = {CURRENT_YEAR_DURATION, RESULT_MEMBER},
			acceptNullOrEmpty = true)
	@ColumnName("配当性向")
	public BigDecimal payoutRatio;
	
	public SummaryFilename summaryFilename;

	
	public static REITReport getInstance(Document document) {
		REITReport ret = AbstractReport.getInstance(REITReport.class, document);
		
		return ret;
	}
	
	@Override
	public String toString() {
		return String.format("{%s %s %s %s %s %s}",  stockCode, yearEnd, filingDate, distributionsDate, distributionsPerUnit, distributionsInExcessOfProfitPerUnit);
	}

	// Define natural ordering of DividendBriefReport
	@Override
	public int compareTo(REITReport that) {
		int ret = this.stockCode.compareTo(that.stockCode);
		if (ret == 0) ret = this.yearEnd.compareTo(that.yearEnd);
		if (ret == 0) ret = this.filingDate.compareTo(that.filingDate);
		return ret;
	}
}
