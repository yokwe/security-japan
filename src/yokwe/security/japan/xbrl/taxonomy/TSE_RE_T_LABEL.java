package yokwe.security.japan.xbrl.taxonomy;

import java.util.Set;
import java.util.TreeSet;

public class TSE_RE_T_LABEL extends LabelData {
    public static final String NAMESPACE = "http://www.xbrl.tdnet.info/taxonomy/jp/tse/tdnet/re/t/2014-01-12";
    
    public static final TSE_RE_T_LABEL AMOUNT_CHANGE_NET_INCOME = new TSE_RE_T_LABEL(
        "AmountChangeNetIncome", 
        "Amount change", 
        "増減額");
    public static final TSE_RE_T_LABEL AMOUNT_CHANGE_OPERATING_INCOME = new TSE_RE_T_LABEL(
        "AmountChangeOperatingIncome", 
        "Amount change", 
        "増減額");
    public static final TSE_RE_T_LABEL AMOUNT_CHANGE_OPERATING_REVENUES_REIT = new TSE_RE_T_LABEL(
        "AmountChangeOperatingRevenuesREIT", 
        "Amount change", 
        "増減額");
    public static final TSE_RE_T_LABEL AMOUNT_CHANGE_ORDINARY_INCOME = new TSE_RE_T_LABEL(
        "AmountChangeOrdinaryIncome", 
        "Amount change", 
        "増減額");
    public static final TSE_RE_T_LABEL ASSET_MANAGER_REIT = new TSE_RE_T_LABEL(
        "AssetManagerREIT", 
        "Asset manager", 
        "資産運用会社名");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_CASH_FLOWS_REITHEADING = new TSE_RE_T_LABEL(
        "BusinessResultsCashFlowsREITHeading", 
        "Cash flows", 
        "キャッシュ・フローの状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_CASH_FLOWS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "BusinessResultsCashFlowsREITLineItems", 
        "Cash flows", 
        "キャッシュ・フローの状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_CASH_FLOWS_REITTABLE = new TSE_RE_T_LABEL(
        "BusinessResultsCashFlowsREITTable", 
        "Cash flows", 
        "キャッシュ・フローの状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_DISTRIBUTIONS_REITHEADING = new TSE_RE_T_LABEL(
        "BusinessResultsDistributionsREITHeading", 
        "Distributions", 
        "分配状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_DISTRIBUTIONS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "BusinessResultsDistributionsREITLineItems", 
        "Distributions", 
        "分配状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_DISTRIBUTIONS_REITTABLE = new TSE_RE_T_LABEL(
        "BusinessResultsDistributionsREITTable", 
        "Distributions", 
        "分配状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_FINANCIAL_POSITIONS_REITHEADING = new TSE_RE_T_LABEL(
        "BusinessResultsFinancialPositionsREITHeading", 
        "Financial positions", 
        "財政状態");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_FINANCIAL_POSITIONS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "BusinessResultsFinancialPositionsREITLineItems", 
        "Financial positions", 
        "財政状態");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_FINANCIAL_POSITIONS_REITTABLE = new TSE_RE_T_LABEL(
        "BusinessResultsFinancialPositionsREITTable", 
        "Financial positions", 
        "財政状態");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_INTERIM_CASH_FLOWS_REITHEADING = new TSE_RE_T_LABEL(
        "BusinessResultsInterimCashFlowsREITHeading", 
        "Interim cash flows", 
        "中間期キャッシュ・フローの状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_INTERIM_CASH_FLOWS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "BusinessResultsInterimCashFlowsREITLineItems", 
        "Interim cash flows", 
        "中間期キャッシュ・フローの状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_INTERIM_CASH_FLOWS_REITTABLE = new TSE_RE_T_LABEL(
        "BusinessResultsInterimCashFlowsREITTable", 
        "Interim cash flows", 
        "中間期キャッシュ・フローの状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_INTERIM_FINANCIAL_POSITIONS_REITHEADING = new TSE_RE_T_LABEL(
        "BusinessResultsInterimFinancialPositionsREITHeading", 
        "Interim financial positions", 
        "中間期財政状態");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_INTERIM_FINANCIAL_POSITIONS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "BusinessResultsInterimFinancialPositionsREITLineItems", 
        "Interim financial positions", 
        "中間期財政状態");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_INTERIM_FINANCIAL_POSITIONS_REITTABLE = new TSE_RE_T_LABEL(
        "BusinessResultsInterimFinancialPositionsREITTable", 
        "Interim financial positions", 
        "中間期財政状態");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_INTERIM_OPERATING_RESULTS_REITHEADING = new TSE_RE_T_LABEL(
        "BusinessResultsInterimOperatingResultsREITHeading", 
        "Interim operating results", 
        "中間期運用状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_INTERIM_OPERATING_RESULTS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "BusinessResultsInterimOperatingResultsREITLineItems", 
        "Interim operating results", 
        "中間期運用状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_INTERIM_OPERATING_RESULTS_REITTABLE = new TSE_RE_T_LABEL(
        "BusinessResultsInterimOperatingResultsREITTable", 
        "Interim operating results", 
        "中間期運用状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_OPERATING_RESULTS_REITHEADING = new TSE_RE_T_LABEL(
        "BusinessResultsOperatingResultsREITHeading", 
        "Operating results", 
        "運用状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_OPERATING_RESULTS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "BusinessResultsOperatingResultsREITLineItems", 
        "Operating results", 
        "運用状況");
    public static final TSE_RE_T_LABEL BUSINESS_RESULTS_OPERATING_RESULTS_REITTABLE = new TSE_RE_T_LABEL(
        "BusinessResultsOperatingResultsREITTable", 
        "Operating results", 
        "運用状況");
    public static final TSE_RE_T_LABEL CAPITAL_ADEQUACY_RATIO = new TSE_RE_T_LABEL(
        "CapitalAdequacyRatio", 
        "Capital adequacy ratio", 
        "自己資本比率");
    public static final TSE_RE_T_LABEL CASH_AND_EQUIVALENTS_END_OF_PERIOD = new TSE_RE_T_LABEL(
        "CashAndEquivalentsEndOfPeriod", 
        "Cash and equivalents, end of period", 
        "現金及び現金同等物期末残高");
    public static final TSE_RE_T_LABEL CASH_DISTRIBUTIONS_REITABSTRACT = new TSE_RE_T_LABEL(
        "CashDistributionsREITAbstract", 
        "Cash distributions", 
        "現金分配");
    public static final TSE_RE_T_LABEL CASH_FLOWS_ABSTRACT = new TSE_RE_T_LABEL(
        "CashFlowsAbstract", 
        "Cash flows", 
        "キャッシュ・フローの状況");
    public static final TSE_RE_T_LABEL CASH_FLOWS_FROM_FINANCING_ACTIVITIES = new TSE_RE_T_LABEL(
        "CashFlowsFromFinancingActivities", 
        "Cash flows from financing activities", 
        "財務活動によるキャッシュ・フロー");
    public static final TSE_RE_T_LABEL CASH_FLOWS_FROM_INVESTING_ACTIVITIES = new TSE_RE_T_LABEL(
        "CashFlowsFromInvestingActivities", 
        "Cash flows from investing activities", 
        "投資活動によるキャッシュ・フロー");
    public static final TSE_RE_T_LABEL CASH_FLOWS_FROM_OPERATING_ACTIVITIES = new TSE_RE_T_LABEL(
        "CashFlowsFromOperatingActivities", 
        "Cash flows from operating activities", 
        "営業活動によるキャッシュ・フロー");
    public static final TSE_RE_T_LABEL CHANGE_IN_NET_INCOME = new TSE_RE_T_LABEL(
        "ChangeInNetIncome", 
        "% change", 
        "増減率");
    public static final TSE_RE_T_LABEL CHANGE_IN_OPERATING_INCOME = new TSE_RE_T_LABEL(
        "ChangeInOperatingIncome", 
        "% change", 
        "増減率");
    public static final TSE_RE_T_LABEL CHANGE_IN_OPERATING_REVENUES_REIT = new TSE_RE_T_LABEL(
        "ChangeInOperatingRevenuesREIT", 
        "% change", 
        "増減率");
    public static final TSE_RE_T_LABEL CHANGE_IN_ORDINARY_INCOME = new TSE_RE_T_LABEL(
        "ChangeInOrdinaryIncome", 
        "% change", 
        "増減率");
    public static final TSE_RE_T_LABEL CHANGES_BASED_ON_REVISIONS_OF_ACCOUNTING_STANDARD = new TSE_RE_T_LABEL(
        "ChangesBasedOnRevisionsOfAccountingStandard", 
        "Changes in accounting policies based on revisions of accounting standard", 
        "会計基準等の改正に伴う会計方針の変更");
    public static final TSE_RE_T_LABEL CHANGES_IN_ACCOUNTING_ESTIMATES = new TSE_RE_T_LABEL(
        "ChangesInAccountingEstimates", 
        "Changes in accounting estimates", 
        "会計上の見積りの変更");
    public static final TSE_RE_T_LABEL CHANGES_IN_ACCOUNTING_POLICIES_AND_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_ABSTRACT = new TSE_RE_T_LABEL(
        "ChangesInAccountingPoliciesAndAccountingEstimatesRetrospectiveRestatementAbstract", 
        "Changes in accounting policies and accounting estimates, retrospective restatement", 
        "会計方針の変更・会計上の見積りの変更・修正再表示");
    public static final TSE_RE_T_LABEL CHANGES_OTHER_THAN_ONES_BASED_ON_REVISIONS_OF_ACCOUNTING_STANDARD = new TSE_RE_T_LABEL(
        "ChangesOtherThanOnesBasedOnRevisionsOfAccountingStandard", 
        "Changes in accounting policies other than ones based on revisions of accounting standard", 
        "会計基準等の改正に伴う変更以外の会計方針の変更");
    public static final TSE_RE_T_LABEL CONSOLIDATED_NONCONSOLIDATED_AXIS = new TSE_RE_T_LABEL(
        "ConsolidatedNonconsolidatedAxis", 
        "Consolidated or nonconsolidated", 
        "連結・個別又は非連結");
    public static final TSE_RE_T_LABEL CONVENING_BRIEFING_OF_INTERIM_RESULTS_REIT = new TSE_RE_T_LABEL(
        "ConveningBriefingOfInterimResultsREIT", 
        "Convening briefing of interim results", 
        "中間決算説明会開催の有無");
    public static final TSE_RE_T_LABEL CONVENING_BRIEFING_OF_RESULTS_REIT = new TSE_RE_T_LABEL(
        "ConveningBriefingOfResultsREIT", 
        "Convening briefing of results", 
        "決算説明会開催の有無");
    public static final TSE_RE_T_LABEL CORRECTION_DETAIL_REITABSTRACT = new TSE_RE_T_LABEL(
        "CorrectionDetailREITAbstract", 
        "Correction detail", 
        "修正の内容");
    public static final TSE_RE_T_LABEL CURRENT_MEMBER = new TSE_RE_T_LABEL(
        "CurrentMember", 
        "Current", 
        "今回");
    public static final TSE_RE_T_LABEL DISTRIBUTION_FORECAST_CORRECTION_REITABSTRACT = new TSE_RE_T_LABEL(
        "DistributionForecastCorrectionREITAbstract", 
        "Distribution forecast correction", 
        "分配予想の修正について");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_PER_UNIT_FORECAST_REITABSTRACT = new TSE_RE_T_LABEL(
        "DistributionsInExcessOfProfitPerUnitForecastREITAbstract", 
        "Distributions in excess of profit per unit", 
        "1口当たり利益超過分配金");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_PER_UNIT_REIT = new TSE_RE_T_LABEL(
        "DistributionsInExcessOfProfitPerUnitREIT", 
        "Distributions in excess of profit per unit", 
        "1口当たり利益超過分配金");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_PER_UNIT_REITABSTRACT = new TSE_RE_T_LABEL(
        "DistributionsInExcessOfProfitPerUnitREITAbstract", 
        "Distributions in excess of profit per unit", 
        "1口当たり利益超過分配金");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_PAYABLE_DATE_AS_PLANNED_REIT = new TSE_RE_T_LABEL(
        "DistributionsPayableDateAsPlannedREIT", 
        "Distributions payable date (as planned)", 
        "分配金支払開始予定日");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_PER_UNIT_EXCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_FORECAST_REITABSTRACT = new TSE_RE_T_LABEL(
        "DistributionsPerUnitExcludingDistributionsInExcessOfProfitForecastREITAbstract", 
        "Distributions per unit (excluding distributions in excess of profit)", 
        "1口当たり分配金（利益超過分配金は含まない）");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_PER_UNIT_EXCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT = new TSE_RE_T_LABEL(
        "DistributionsPerUnitExcludingDistributionsInExcessOfProfitREIT", 
        "Distributions per unit (excluding distributions in excess of profit)", 
        "1口当たり分配金（利益超過分配金は含まない）");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_PER_UNIT_EXCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REITABSTRACT = new TSE_RE_T_LABEL(
        "DistributionsPerUnitExcludingDistributionsInExcessOfProfitREITAbstract", 
        "Distributions per unit (excluding distributions in excess of profit)", 
        "1口当たり分配金（利益超過分配金は含まない）");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_PER_UNIT_INCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_FORECAST_REITABSTRACT = new TSE_RE_T_LABEL(
        "DistributionsPerUnitIncludingDistributionsInExcessOfProfitForecastREITAbstract", 
        "Distributions per unit (including distributions in excess of profit)", 
        "1口当たり分配金（利益超過分配金を含む）");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_PER_UNIT_INCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT = new TSE_RE_T_LABEL(
        "DistributionsPerUnitIncludingDistributionsInExcessOfProfitREIT", 
        "Distributions per unit (including distributions in excess of profit)", 
        "1口当たり分配金（利益超過分配金を含む）");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_PER_UNIT_INCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REITABSTRACT = new TSE_RE_T_LABEL(
        "DistributionsPerUnitIncludingDistributionsInExcessOfProfitREITAbstract", 
        "Distributions per unit (including distributions in excess of profit)", 
        "1口当たり分配金（利益超過分配金を含む）");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_PER_UNIT_REITABSTRACT = new TSE_RE_T_LABEL(
        "DistributionsPerUnitREITAbstract", 
        "Distributions per unit", 
        "分配金");
    public static final TSE_RE_T_LABEL DISTRIBUTIONS_REITABSTRACT = new TSE_RE_T_LABEL(
        "DistributionsREITAbstract", 
        "Distributions", 
        "分配状況");
    public static final TSE_RE_T_LABEL DOCUMENT_ENTITY_INFORMATION_REITHEADING = new TSE_RE_T_LABEL(
        "DocumentEntityInformationREITHeading", 
        "Submitter information", 
        "提出者情報");
    public static final TSE_RE_T_LABEL DOCUMENT_ENTITY_INFORMATION_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "DocumentEntityInformationREITLineItems", 
        "Submitter information", 
        "提出者情報");
    public static final TSE_RE_T_LABEL DOCUMENT_ENTITY_INFORMATION_REITTABLE = new TSE_RE_T_LABEL(
        "DocumentEntityInformationREITTable", 
        "Submitter information", 
        "提出者情報");
    public static final TSE_RE_T_LABEL DOCUMENT_NAME = new TSE_RE_T_LABEL(
        "DocumentName", 
        "Document name", 
        "文書名");
    public static final TSE_RE_T_LABEL EXPRESSION_OF_IMPLEMENTATION_STATUS_OF_AUDIT_PROCEDURES = new TSE_RE_T_LABEL(
        "ExpressionOfImplementationStatusOfAuditProcedures", 
        "Expression of implementation status of audit procedures", 
        "監査手続の実施状況に関する表示");
    public static final TSE_RE_T_LABEL EXPRESSION_OF_IMPLEMENTATION_STATUS_OF_INTERIM_AUDIT_PROCEDURES = new TSE_RE_T_LABEL(
        "ExpressionOfImplementationStatusOfInterimAuditProcedures", 
        "Expression of implementation status of interim audit procedures", 
        "中間監査手続の実施状況に関する表示");
    public static final TSE_RE_T_LABEL FILING_DATE = new TSE_RE_T_LABEL(
        "FilingDate", 
        "Filing date", 
        "提出日");
    public static final TSE_RE_T_LABEL FINANCIAL_POSITIONS_ABSTRACT = new TSE_RE_T_LABEL(
        "FinancialPositionsAbstract", 
        "Financial positions", 
        "財政状態");
    public static final TSE_RE_T_LABEL FISCAL_YEAR_END = new TSE_RE_T_LABEL(
        "FiscalYearEnd", 
        "Fiscal Year End", 
        "決算期");
    public static final TSE_RE_T_LABEL FORECAST_CORRECTION_OF_OPERATING_RESULTS_INTERIM_REITHEADING = new TSE_RE_T_LABEL(
        "ForecastCorrectionOfOperatingResultsInterimREITHeading", 
        "Forecast correction", 
        "中間期運用状況の予想数値の修正");
    public static final TSE_RE_T_LABEL FORECAST_CORRECTION_OF_OPERATING_RESULTS_INTERIM_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "ForecastCorrectionOfOperatingResultsInterimREITLineItems", 
        "Forecast correction", 
        "中間期運用状況の予想数値の修正");
    public static final TSE_RE_T_LABEL FORECAST_CORRECTION_OF_OPERATING_RESULTS_INTERIM_REITTABLE = new TSE_RE_T_LABEL(
        "ForecastCorrectionOfOperatingResultsInterimREITTable", 
        "Forecast correction", 
        "中間期運用状況の予想数値の修正");
    public static final TSE_RE_T_LABEL FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITABSTRACT = new TSE_RE_T_LABEL(
        "ForecastCorrectionOfOperatingResultsREITAbstract", 
        "Forecast correction", 
        "運用状況の予想の修正について");
    public static final TSE_RE_T_LABEL FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITHEADING = new TSE_RE_T_LABEL(
        "ForecastCorrectionOfOperatingResultsREITHeading", 
        "Forecast correction", 
        "運用状況の予想数値の修正");
    public static final TSE_RE_T_LABEL FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "ForecastCorrectionOfOperatingResultsREITLineItems", 
        "Forecast correction", 
        "運用状況の予想数値の修正");
    public static final TSE_RE_T_LABEL FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITTABLE = new TSE_RE_T_LABEL(
        "ForecastCorrectionOfOperatingResultsREITTable", 
        "Forecast correction", 
        "運用状況の予想数値の修正");
    public static final TSE_RE_T_LABEL FORECAST_MEMBER = new TSE_RE_T_LABEL(
        "ForecastMember", 
        "Forecast", 
        "予想");
    public static final TSE_RE_T_LABEL FORECASTS_REITHEADING = new TSE_RE_T_LABEL(
        "ForecastsREITHeading", 
        "Forecasts", 
        "運用状況の予想");
    public static final TSE_RE_T_LABEL FORECASTS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "ForecastsREITLineItems", 
        "Forecasts", 
        "運用状況の予想");
    public static final TSE_RE_T_LABEL FORECASTS_REITTABLE = new TSE_RE_T_LABEL(
        "ForecastsREITTable", 
        "Forecasts", 
        "運用状況の予想");
    public static final TSE_RE_T_LABEL FUKUOKA_STOCK_EXCHANGE = new TSE_RE_T_LABEL(
        "FukuokaStockExchange", 
        "Fukuoka", 
        "福");
    public static final TSE_RE_T_LABEL FUKUOKA_STOCK_EXCHANGE_ESTABLISHED = new TSE_RE_T_LABEL(
        "FukuokaStockExchangeEstablished", 
        "Fukuoka", 
        "既存市場");
    public static final TSE_RE_T_LABEL FUKUOKA_STOCK_EXCHANGE_OTHERS = new TSE_RE_T_LABEL(
        "FukuokaStockExchangeOthers", 
        "Fukuoka Others", 
        "その他");
    public static final TSE_RE_T_LABEL FUKUOKA_STOCK_EXCHANGE_QBOARD = new TSE_RE_T_LABEL(
        "FukuokaStockExchangeQBoard", 
        "Fukuoka Q-Board", 
        "Q-Board");
    public static final TSE_RE_T_LABEL INCOME_STATEMENTS_INFORMATION_ABSTRACT = new TSE_RE_T_LABEL(
        "IncomeStatementsInformationAbstract", 
        "Income statements information", 
        "損益計算書情報");
    public static final TSE_RE_T_LABEL INQUIRIES_ABSTRACT = new TSE_RE_T_LABEL(
        "InquiriesAbstract", 
        "Inquiries", 
        "問合せ先責任者");
    public static final TSE_RE_T_LABEL INTERIM_FORECASTS_REITHEADING = new TSE_RE_T_LABEL(
        "InterimForecastsREITHeading", 
        "Interim forecasts", 
        "中間期運用状況の予想");
    public static final TSE_RE_T_LABEL INTERIM_FORECASTS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "InterimForecastsREITLineItems", 
        "Interim forecasts", 
        "中間期運用状況の予想");
    public static final TSE_RE_T_LABEL INTERIM_FORECASTS_REITTABLE = new TSE_RE_T_LABEL(
        "InterimForecastsREITTable", 
        "Interim forecasts", 
        "中間期運用状況の予想");
    public static final TSE_RE_T_LABEL INTERIM_REPORT_FILING_DATE_AS_PLANNED_REIT = new TSE_RE_T_LABEL(
        "InterimReportFilingDateAsPlannedREIT", 
        "Interim report filing date (as planned)", 
        "半期報告書提出予定日");
    public static final TSE_RE_T_LABEL ISSUER_NAME_REIT = new TSE_RE_T_LABEL(
        "IssuerNameREIT", 
        "Issuer name", 
        "不動産投資信託証券発行者名");
    public static final TSE_RE_T_LABEL JAPAN_SECURITIES_DEALERS_ASSOCIATION = new TSE_RE_T_LABEL(
        "JapanSecuritiesDealersAssociation", 
        "Green Sheet", 
        "GR");
    public static final TSE_RE_T_LABEL JAPAN_SECURITIES_DEALERS_ASSOCIATION_GREEN_SHEET = new TSE_RE_T_LABEL(
        "JapanSecuritiesDealersAssociationGreenSheet", 
        "Japan Securities Dealers Association", 
        "グリーンシート等");
    public static final TSE_RE_T_LABEL LOWER_MEMBER = new TSE_RE_T_LABEL(
        "LowerMember", 
        "Lower", 
        "下限");
    public static final TSE_RE_T_LABEL MAIN_TABLE_OF_FORECASTS_OF_OPERATING_RESULTS_INTERIM_REITABSTRACT = new TSE_RE_T_LABEL(
        "MainTableOfForecastsOfOperatingResultsInterimREITAbstract", 
        "Main table of forecasts", 
        "中間期運用状況予想本表");
    public static final TSE_RE_T_LABEL MAIN_TABLE_OF_FORECASTS_OF_OPERATING_RESULTS_REITABSTRACT = new TSE_RE_T_LABEL(
        "MainTableOfForecastsOfOperatingResultsREITAbstract", 
        "Main table of forecasts", 
        "当期運用状況予想本表");
    public static final TSE_RE_T_LABEL MAIN_TABLE_OF_FORECASTS_REITABSTRACT = new TSE_RE_T_LABEL(
        "MainTableOfForecastsREITAbstract", 
        "Main table of forecasts", 
        "運用状況の予想本表");
    public static final TSE_RE_T_LABEL MAIN_TABLE_OF_NEXT_FORECASTS_OF_OPERATING_RESULTS_REITABSTRACT = new TSE_RE_T_LABEL(
        "MainTableOfNextForecastsOfOperatingResultsREITAbstract", 
        "Main table of forecasts", 
        "次期運用状況予想本表");
    public static final TSE_RE_T_LABEL NAGOYA_STOCK_EXCHANGE = new TSE_RE_T_LABEL(
        "NagoyaStockExchange", 
        "Nagoya", 
        "名");
    public static final TSE_RE_T_LABEL NAGOYA_STOCK_EXCHANGE_1ST_SECTION = new TSE_RE_T_LABEL(
        "NagoyaStockExchange1stSection", 
        "Nagoya 1st section", 
        "第一部");
    public static final TSE_RE_T_LABEL NAGOYA_STOCK_EXCHANGE_2ND_SECTION = new TSE_RE_T_LABEL(
        "NagoyaStockExchange2ndSection", 
        "Nagoya 2nd section", 
        "第二部");
    public static final TSE_RE_T_LABEL NAGOYA_STOCK_EXCHANGE_CENTREX = new TSE_RE_T_LABEL(
        "NagoyaStockExchangeCentrex", 
        "Nagoya Centrex", 
        "セントレックス");
    public static final TSE_RE_T_LABEL NAGOYA_STOCK_EXCHANGE_OTHERS = new TSE_RE_T_LABEL(
        "NagoyaStockExchangeOthers", 
        "Nagoya Others", 
        "その他");
    public static final TSE_RE_T_LABEL NAME_ASSET_MANAGER_REIT = new TSE_RE_T_LABEL(
        "NameAssetManagerREIT", 
        "Name", 
        "氏名");
    public static final TSE_RE_T_LABEL NAME_INQUIRIES = new TSE_RE_T_LABEL(
        "NameInquiries", 
        "Name", 
        "氏名");
    public static final TSE_RE_T_LABEL NAME_REPRESENTATIVE = new TSE_RE_T_LABEL(
        "NameRepresentative", 
        "Name", 
        "氏名");
    public static final TSE_RE_T_LABEL NET_ASSETS = new TSE_RE_T_LABEL(
        "NetAssets", 
        "Net assets", 
        "純資産");
    public static final TSE_RE_T_LABEL NET_ASSETS_PER_UNIT_REIT = new TSE_RE_T_LABEL(
        "NetAssetsPerUnitREIT", 
        "Net assets per unit", 
        "1口当たり純資産");
    public static final TSE_RE_T_LABEL NET_INCOME = new TSE_RE_T_LABEL(
        "NetIncome", 
        "Profit", 
        "当期純利益");
    public static final TSE_RE_T_LABEL NET_INCOME_ABSTRACT = new TSE_RE_T_LABEL(
        "NetIncomeAbstract", 
        "Profit", 
        "当期純利益");
    public static final TSE_RE_T_LABEL NET_INCOME_CORRECTION_ABSTRACT = new TSE_RE_T_LABEL(
        "NetIncomeCorrectionAbstract", 
        "Profit", 
        "当期純利益");
    public static final TSE_RE_T_LABEL NET_INCOME_FORECAST_ABSTRACT = new TSE_RE_T_LABEL(
        "NetIncomeForecastAbstract", 
        "Profit", 
        "当期純利益");
    public static final TSE_RE_T_LABEL NET_INCOME_PER_UNIT_CORRECTION_REITABSTRACT = new TSE_RE_T_LABEL(
        "NetIncomePerUnitCorrectionREITAbstract", 
        "Basic earnings per unit", 
        "1口当たり当期純利益");
    public static final TSE_RE_T_LABEL NET_INCOME_PER_UNIT_REIT = new TSE_RE_T_LABEL(
        "NetIncomePerUnitREIT", 
        "Basic earnings per unit", 
        "1口当たり当期純利益");
    public static final TSE_RE_T_LABEL NET_INCOME_TO_UNITHOLDERS_EQUITY_RATIO_REIT = new TSE_RE_T_LABEL(
        "NetIncomeToUnitholdersEquityRatioREIT", 
        "Rate of return on equity", 
        "自己資本当期純利益率");
    public static final TSE_RE_T_LABEL NEXT_FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITHEADING = new TSE_RE_T_LABEL(
        "NextForecastCorrectionOfOperatingResultsREITHeading", 
        "Forecast correction", 
        "次期運用状況の予想数値の修正");
    public static final TSE_RE_T_LABEL NEXT_FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "NextForecastCorrectionOfOperatingResultsREITLineItems", 
        "Forecast correction", 
        "次期運用状況の予想数値の修正");
    public static final TSE_RE_T_LABEL NEXT_FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITTABLE = new TSE_RE_T_LABEL(
        "NextForecastCorrectionOfOperatingResultsREITTable", 
        "Forecast correction", 
        "次期運用状況の予想数値の修正");
    public static final TSE_RE_T_LABEL NEXT_REVISED_DISTRIBUTION_FORECAST_REITHEADING = new TSE_RE_T_LABEL(
        "NextRevisedDistributionForecastREITHeading", 
        "Revised distribution forecast", 
        "次期分配予想の修正について");
    public static final TSE_RE_T_LABEL NEXT_REVISED_DISTRIBUTION_FORECAST_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "NextRevisedDistributionForecastREITLineItems", 
        "Revised distribution forecast", 
        "次期分配予想の修正について");
    public static final TSE_RE_T_LABEL NEXT_REVISED_DISTRIBUTION_FORECAST_REITTABLE = new TSE_RE_T_LABEL(
        "NextRevisedDistributionForecastREITTable", 
        "Revised distribution forecast", 
        "次期分配予想の修正について");
    public static final TSE_RE_T_LABEL NON_CONSOLIDATED_MEMBER = new TSE_RE_T_LABEL(
        "NonConsolidatedMember", 
        "NonConsolidated", 
        "個別又は非連結");
    public static final TSE_RE_T_LABEL NOTE_AND_REASON_FOR_CORRECTION_REITABSTRACT = new TSE_RE_T_LABEL(
        "NoteAndReasonForCorrectionREITAbstract", 
        "Note and reason for correction", 
        "運用状況の予想の修正に関する注記");
    public static final TSE_RE_T_LABEL NOTE_AND_REASON_FOR_CORRECTION_REITHEADING = new TSE_RE_T_LABEL(
        "NoteAndReasonForCorrectionREITHeading", 
        "Note and reason for correction", 
        "運用状況の予想の修正に関する注記");
    public static final TSE_RE_T_LABEL NOTE_AND_REASON_FOR_CORRECTION_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "NoteAndReasonForCorrectionREITLineItems", 
        "Note and reason for correction", 
        "運用状況の予想の修正に関する注記");
    public static final TSE_RE_T_LABEL NOTE_AND_REASON_FOR_CORRECTION_REITTABLE = new TSE_RE_T_LABEL(
        "NoteAndReasonForCorrectionREITTable", 
        "Note and reason for correction", 
        "運用状況の予想の修正に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_CASH_FLOWS = new TSE_RE_T_LABEL(
        "NoteToCashFlows", 
        "Note to cash flows", 
        "キャッシュ・フローの状況に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_CASH_FLOWS_ABSTRACT = new TSE_RE_T_LABEL(
        "NoteToCashFlowsAbstract", 
        "Note to cash flows", 
        "キャッシュ・フローの状況に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_CHANGES_IN_ACCOUNTING_POLICIES_AND_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT = new TSE_RE_T_LABEL(
        "NoteToChangesInAccountingPoliciesAndAccountingEstimatesRetrospectiveRestatement", 
        "Note to changes in accounting policies and accounting estimates, retrospective restatement", 
        "会計方針の変更・会計上の見積りの変更・修正再表示に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_CHANGES_IN_ACCOUNTING_POLICIES_AND_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_ABSTRACT = new TSE_RE_T_LABEL(
        "NoteToChangesInAccountingPoliciesAndAccountingEstimatesRetrospectiveRestatementAbstract", 
        "Note to changes in accounting policies and accounting estimates, retrospective restatement", 
        "会計方針の変更・会計上の見積りの変更・修正再表示に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_DISTRIBUTIONS_REIT = new TSE_RE_T_LABEL(
        "NoteToDistributionsREIT", 
        "Note to distributions", 
        "分配状況に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_DISTRIBUTIONS_REITABSTRACT = new TSE_RE_T_LABEL(
        "NoteToDistributionsREITAbstract", 
        "Note to distributions", 
        "分配状況に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_FINANCIAL_POSITIONS = new TSE_RE_T_LABEL(
        "NoteToFinancialPositions", 
        "Note to financial positions", 
        "財政状態に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_FINANCIAL_POSITIONS_ABSTRACT = new TSE_RE_T_LABEL(
        "NoteToFinancialPositionsAbstract", 
        "Note to financial positions", 
        "財政状態に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_FORECAST_CORRECTION_REIT = new TSE_RE_T_LABEL(
        "NoteToForecastCorrectionREIT", 
        "Note to forecast", 
        "運用状況の予想の状況に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_FORECAST_CORRECTION_REITABSTRACT = new TSE_RE_T_LABEL(
        "NoteToForecastCorrectionREITAbstract", 
        "Note to forecast", 
        "運用状況の予想の状況に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_FORECASTS_REIT = new TSE_RE_T_LABEL(
        "NoteToForecastsREIT", 
        "Note to forecasts", 
        "運用状況の予想に関する事項");
    public static final TSE_RE_T_LABEL NOTE_TO_FORECASTS_REITABSTRACT = new TSE_RE_T_LABEL(
        "NoteToForecastsREITAbstract", 
        "Note to forecasts", 
        "運用状況の予想に関する事項");
    public static final TSE_RE_T_LABEL NOTE_TO_FRACTION_PROCESSING_METHOD = new TSE_RE_T_LABEL(
        "NoteToFractionProcessingMethod", 
        "Note to fraction processing method", 
        "端数処理方法に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REIT = new TSE_RE_T_LABEL(
        "NoteToNumberOfInvestmentUnitsIssuedREIT", 
        "Note to number of investment units issued", 
        "発行済投資口の総口数に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITABSTRACT = new TSE_RE_T_LABEL(
        "NoteToNumberOfInvestmentUnitsIssuedREITAbstract", 
        "Note to number of investment units issued", 
        "発行済投資口の総口数に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_OPERATING_RESULTS_REIT = new TSE_RE_T_LABEL(
        "NoteToOperatingResultsREIT", 
        "Note to operating results", 
        "運用状況に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_OPERATING_RESULTS_REITABSTRACT = new TSE_RE_T_LABEL(
        "NoteToOperatingResultsREITAbstract", 
        "Note to operating results", 
        "運用状況に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_REVISED_DISTRIBUTION_FORECAST_REITHEADING = new TSE_RE_T_LABEL(
        "NoteToRevisedDistributionForecastREITHeading", 
        "Note to revised distribution forecast", 
        "分配予想の修正に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_REVISED_DISTRIBUTION_FORECAST_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "NoteToRevisedDistributionForecastREITLineItems", 
        "Note to revised distribution forecast", 
        "分配予想の修正に関する注記");
    public static final TSE_RE_T_LABEL NOTE_TO_REVISED_DISTRIBUTION_FORECAST_REITTABLE = new TSE_RE_T_LABEL(
        "NoteToRevisedDistributionForecastREITTable", 
        "Note to revised distribution forecast", 
        "分配予想の修正に関する注記");
    public static final TSE_RE_T_LABEL NOTES_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITHEADING = new TSE_RE_T_LABEL(
        "NotesChangesAccountingPoliciesAccountingEstimatesRetrospectiveRestatementREITHeading", 
        "Changes in accounting policies and accounting estimates, retrospective restatement", 
        "会計方針の変更・会計上の見積りの変更・修正再表示");
    public static final TSE_RE_T_LABEL NOTES_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "NotesChangesAccountingPoliciesAccountingEstimatesRetrospectiveRestatementREITLineItems", 
        "Changes in accounting policies and accounting estimates, retrospective restatement", 
        "会計方針の変更・会計上の見積りの変更・修正再表示");
    public static final TSE_RE_T_LABEL NOTES_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITTABLE = new TSE_RE_T_LABEL(
        "NotesChangesAccountingPoliciesAccountingEstimatesRetrospectiveRestatementREITTable", 
        "Changes in accounting policies and accounting estimates, retrospective restatement", 
        "会計方針の変更・会計上の見積りの変更・修正再表示");
    public static final TSE_RE_T_LABEL NOTES_FOR_USING_FORECASTED_INFORMATION_AND_OTHERS_REIT = new TSE_RE_T_LABEL(
        "NotesForUsingForecastedInformationAndOthersREIT", 
        "Notes for using forecasted information and others", 
        "運用状況の予想の適切な利用に関する説明、その他特記事項");
    public static final TSE_RE_T_LABEL NOTES_INTERIM_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITHEADING = new TSE_RE_T_LABEL(
        "NotesInterimChangesAccountingPoliciesAccountingEstimatesRetrospectiveRestatementREITHeading", 
        "Changes in accounting policies, accounting estimates and retrospective restatement", 
        "会計方針の変更・会計上の見積りの変更・修正再表示");
    public static final TSE_RE_T_LABEL NOTES_INTERIM_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "NotesInterimChangesAccountingPoliciesAccountingEstimatesRetrospectiveRestatementREITLineItems", 
        "Changes in accounting policies, accounting estimates and retrospective restatement", 
        "会計方針の変更・会計上の見積りの変更・修正再表示");
    public static final TSE_RE_T_LABEL NOTES_INTERIM_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITTABLE = new TSE_RE_T_LABEL(
        "NotesInterimChangesAccountingPoliciesAccountingEstimatesRetrospectiveRestatementREITTable", 
        "Changes in accounting policies, accounting estimates and retrospective restatement", 
        "会計方針の変更・会計上の見積りの変更・修正再表示");
    public static final TSE_RE_T_LABEL NOTES_INTERIM_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITHEADING = new TSE_RE_T_LABEL(
        "NotesInterimNumberOfInvestmentUnitsIssuedREITHeading", 
        "Number of investment units issued", 
        "発行済投資口の総口数");
    public static final TSE_RE_T_LABEL NOTES_INTERIM_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "NotesInterimNumberOfInvestmentUnitsIssuedREITLineItems", 
        "Number of investment units issued", 
        "発行済投資口の総口数");
    public static final TSE_RE_T_LABEL NOTES_INTERIM_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITTABLE = new TSE_RE_T_LABEL(
        "NotesInterimNumberOfInvestmentUnitsIssuedREITTable", 
        "Number of investment units issued", 
        "発行済投資口の総口数");
    public static final TSE_RE_T_LABEL NOTES_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITHEADING = new TSE_RE_T_LABEL(
        "NotesNumberOfInvestmentUnitsIssuedREITHeading", 
        "Number of investment units issued", 
        "発行済投資口の総口数");
    public static final TSE_RE_T_LABEL NOTES_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "NotesNumberOfInvestmentUnitsIssuedREITLineItems", 
        "Number of investment units issued", 
        "発行済投資口の総口数");
    public static final TSE_RE_T_LABEL NOTES_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITTABLE = new TSE_RE_T_LABEL(
        "NotesNumberOfInvestmentUnitsIssuedREITTable", 
        "Number of investment units issued", 
        "発行済投資口の総口数");
    public static final TSE_RE_T_LABEL NOTICE_OF_FORECAST_CORRECTION = new TSE_RE_T_LABEL(
        "NoticeOfForecastCorrection", 
        "Notice of forecast correction", 
        "予想修正に関するお知らせ");
    public static final TSE_RE_T_LABEL NUMBER_OF_INVESTMENT_UNITS_INCLUDING_TREASURY_INVESTMENT_UNITS_ISSUED_AT_END_OF_PERIOD_REIT = new TSE_RE_T_LABEL(
        "NumberOfInvestmentUnitsIncludingTreasuryInvestmentUnitsIssuedAtEndOfPeriodREIT", 
        "Number of investment units (including treasury investment units) issued at end of period", 
        "期末発行済投資口の総口数（自己投資口を含む）");
    public static final TSE_RE_T_LABEL NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITABSTRACT = new TSE_RE_T_LABEL(
        "NumberOfInvestmentUnitsIssuedREITAbstract", 
        "Number of investment units issued", 
        "発行済投資口の総口数");
    public static final TSE_RE_T_LABEL NUMBER_OF_TREASURY_INVESTMENT_UNITS_ISSUED_AT_END_OF_PERIOD_REIT = new TSE_RE_T_LABEL(
        "NumberOfTreasuryInvestmentUnitsIssuedAtEndOfPeriodREIT", 
        "Number of treasury investment units issued at end of period", 
        "期末自己投資口数");
    public static final TSE_RE_T_LABEL OPERATING_INCOME = new TSE_RE_T_LABEL(
        "OperatingIncome", 
        "Operating profit", 
        "営業利益");
    public static final TSE_RE_T_LABEL OPERATING_INCOME_ABSTRACT = new TSE_RE_T_LABEL(
        "OperatingIncomeAbstract", 
        "Operating profit", 
        "営業利益");
    public static final TSE_RE_T_LABEL OPERATING_INCOME_CORRECTION_ABSTRACT = new TSE_RE_T_LABEL(
        "OperatingIncomeCorrectionAbstract", 
        "Operating profit", 
        "営業利益");
    public static final TSE_RE_T_LABEL OPERATING_INCOME_FORECAST_ABSTRACT = new TSE_RE_T_LABEL(
        "OperatingIncomeForecastAbstract", 
        "Operating profit", 
        "営業利益");
    public static final TSE_RE_T_LABEL OPERATING_RESULTS_REITABSTRACT = new TSE_RE_T_LABEL(
        "OperatingResultsREITAbstract", 
        "Operating results", 
        "運用状況");
    public static final TSE_RE_T_LABEL OPERATING_REVENUES_CORRECTION_REITABSTRACT = new TSE_RE_T_LABEL(
        "OperatingRevenuesCorrectionREITAbstract", 
        "Operating revenues", 
        "営業収益");
    public static final TSE_RE_T_LABEL OPERATING_REVENUES_FORECAST_REITABSTRACT = new TSE_RE_T_LABEL(
        "OperatingRevenuesForecastREITAbstract", 
        "Operating revenues", 
        "営業収益");
    public static final TSE_RE_T_LABEL OPERATING_REVENUES_REIT = new TSE_RE_T_LABEL(
        "OperatingRevenuesREIT", 
        "Operating revenues", 
        "営業収益");
    public static final TSE_RE_T_LABEL OPERATING_REVENUES_REITABSTRACT = new TSE_RE_T_LABEL(
        "OperatingRevenuesREITAbstract", 
        "Operating revenues", 
        "営業収益");
    public static final TSE_RE_T_LABEL ORDINARY_INCOME = new TSE_RE_T_LABEL(
        "OrdinaryIncome", 
        "Ordinary profit", 
        "経常利益");
    public static final TSE_RE_T_LABEL ORDINARY_INCOME_ABSTRACT = new TSE_RE_T_LABEL(
        "OrdinaryIncomeAbstract", 
        "Ordinary profit", 
        "経常利益");
    public static final TSE_RE_T_LABEL ORDINARY_INCOME_CORRECTION_ABSTRACT = new TSE_RE_T_LABEL(
        "OrdinaryIncomeCorrectionAbstract", 
        "Ordinary profit", 
        "経常利益");
    public static final TSE_RE_T_LABEL ORDINARY_INCOME_FORECAST_ABSTRACT = new TSE_RE_T_LABEL(
        "OrdinaryIncomeForecastAbstract", 
        "Ordinary profit", 
        "経常利益");
    public static final TSE_RE_T_LABEL ORDINARY_INCOME_TO_OPERATING_REVENUES_RATIO_REIT = new TSE_RE_T_LABEL(
        "OrdinaryIncomeToOperatingRevenuesRatioREIT", 
        "Ordinary income to operating revenues ratio", 
        "営業収益経常利益率");
    public static final TSE_RE_T_LABEL ORDINARY_INCOME_TO_TOTAL_ASSETS_RATIO = new TSE_RE_T_LABEL(
        "OrdinaryIncomeToTotalAssetsRatio", 
        "Ordinary income to total assets ratio", 
        "総資産経常利益率");
    public static final TSE_RE_T_LABEL OTHER_OPERATING_RESULTS_REITABSTRACT = new TSE_RE_T_LABEL(
        "OtherOperatingResultsREITAbstract", 
        "Other operating results", 
        "その他の運用状況");
    public static final TSE_RE_T_LABEL OTHER_SUBMITTER_INFORMATION_REITABSTRACT = new TSE_RE_T_LABEL(
        "OtherSubmitterInformationREITAbstract", 
        "Other", 
        "その他");
    public static final TSE_RE_T_LABEL OTHERS_REITABSTRACT = new TSE_RE_T_LABEL(
        "OthersREITAbstract", 
        "Others", 
        "その他");
    public static final TSE_RE_T_LABEL PAYOUT_RATIO = new TSE_RE_T_LABEL(
        "PayoutRatio", 
        "Payout ratio", 
        "配当性向");
    public static final TSE_RE_T_LABEL PAYOUT_RATIO_ABSTRACT = new TSE_RE_T_LABEL(
        "PayoutRatioAbstract", 
        "Payout ratio", 
        "配当性向");
    public static final TSE_RE_T_LABEL PREVIOUS_CURRENT_AXIS = new TSE_RE_T_LABEL(
        "PreviousCurrentAxis", 
        "Previous or current", 
        "前回・今回");
    public static final TSE_RE_T_LABEL PREVIOUS_MEMBER = new TSE_RE_T_LABEL(
        "PreviousMember", 
        "Previous", 
        "前回");
    public static final TSE_RE_T_LABEL RATIO_OF_DISTRIBUTIONS_TO_NET_ASSETS_REIT = new TSE_RE_T_LABEL(
        "RatioOfDistributionsToNetAssetsREIT", 
        "Ratio of distributions to net assets", 
        "純資産配当率");
    public static final TSE_RE_T_LABEL RATIO_OF_DISTRIBUTIONS_TO_NET_ASSETS_REITABSTRACT = new TSE_RE_T_LABEL(
        "RatioOfDistributionsToNetAssetsREITAbstract", 
        "Ratio of distributions to net assets", 
        "純資産配当率");
    public static final TSE_RE_T_LABEL REASON_FOR_CORRECTION_DISTRIBUTION_FORECAST_CORRECTION_REITABSTRACT = new TSE_RE_T_LABEL(
        "ReasonForCorrectionDistributionForecastCorrectionREITAbstract", 
        "Reason for correction", 
        "修正の理由");
    public static final TSE_RE_T_LABEL REASON_FOR_DISTRIBUTION_FORECAST_CORRECTION_REIT = new TSE_RE_T_LABEL(
        "ReasonForDistributionForecastCorrectionREIT", 
        "Reason for distribution forecast correction", 
        "分配予想の修正の理由");
    public static final TSE_RE_T_LABEL REASON_FOR_FORECAST_CORRECTION_REIT = new TSE_RE_T_LABEL(
        "ReasonForForecastCorrectionREIT", 
        "Reason for forecast correction", 
        "運用状況の予想の修正の理由");
    public static final TSE_RE_T_LABEL REASON_FOR_FORECAST_CORRECTION_REITABSTRACT = new TSE_RE_T_LABEL(
        "ReasonForForecastCorrectionREITAbstract", 
        "Reason for forecast correction", 
        "修正の理由");
    public static final TSE_RE_T_LABEL REPORTING_DATE_OF_DISTRIBUTION_FORECAST_CORRECTION_REIT = new TSE_RE_T_LABEL(
        "ReportingDateOfDistributionForecastCorrectionREIT", 
        "Reporting date of distribution forecast correction", 
        "分配予想修正報告日");
    public static final TSE_RE_T_LABEL REPORTING_DATE_OF_FINANCIAL_FORECAST_CORRECTION = new TSE_RE_T_LABEL(
        "ReportingDateOfFinancialForecastCorrection", 
        "Reporting date of forecast correction", 
        "予想修正報告日");
    public static final TSE_RE_T_LABEL REPRESENTATIVE_ABSTRACT = new TSE_RE_T_LABEL(
        "RepresentativeAbstract", 
        "Representative", 
        "代表者");
    public static final TSE_RE_T_LABEL REPRESENTATIVE_ASSET_MANAGER_REITABSTRACT = new TSE_RE_T_LABEL(
        "RepresentativeAssetManagerREITAbstract", 
        "Representative", 
        "代表者");
    public static final TSE_RE_T_LABEL RESULT_FORECAST_AXIS = new TSE_RE_T_LABEL(
        "ResultForecastAxis", 
        "Result or forecast", 
        "実績・予想");
    public static final TSE_RE_T_LABEL RESULT_MEMBER = new TSE_RE_T_LABEL(
        "ResultMember", 
        "Result", 
        "実績");
    public static final TSE_RE_T_LABEL RETROSPECTIVE_RESTATEMENT = new TSE_RE_T_LABEL(
        "RetrospectiveRestatement", 
        "Retrospective restatement", 
        "修正再表示");
    public static final TSE_RE_T_LABEL REVISED_DISTRIBUTION_FORECAST_REITHEADING = new TSE_RE_T_LABEL(
        "RevisedDistributionForecastREITHeading", 
        "Revised distribution forecast", 
        "分配予想の修正について");
    public static final TSE_RE_T_LABEL REVISED_DISTRIBUTION_FORECAST_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "RevisedDistributionForecastREITLineItems", 
        "Revised distribution forecast", 
        "分配予想の修正について");
    public static final TSE_RE_T_LABEL REVISED_DISTRIBUTION_FORECAST_REITTABLE = new TSE_RE_T_LABEL(
        "RevisedDistributionForecastREITTable", 
        "Revised distribution forecast", 
        "分配予想の修正について");
    public static final TSE_RE_T_LABEL SAPPORO_STOCK_EXCHANGE = new TSE_RE_T_LABEL(
        "SapporoStockExchange", 
        "Sapporo", 
        "札");
    public static final TSE_RE_T_LABEL SAPPORO_STOCK_EXCHANGE_AMBITIOUS = new TSE_RE_T_LABEL(
        "SapporoStockExchangeAmbitious", 
        "Sapporo Ambitious", 
        "アンビシャス");
    public static final TSE_RE_T_LABEL SAPPORO_STOCK_EXCHANGE_ESTABLISHED = new TSE_RE_T_LABEL(
        "SapporoStockExchangeEstablished", 
        "Sapporo", 
        "既存市場");
    public static final TSE_RE_T_LABEL SAPPORO_STOCK_EXCHANGE_OTHERS = new TSE_RE_T_LABEL(
        "SapporoStockExchangeOthers", 
        "Sapporo Others", 
        "その他");
    public static final TSE_RE_T_LABEL SECURITIES_CODE = new TSE_RE_T_LABEL(
        "SecuritiesCode", 
        "Securities code", 
        "コード番号");
    public static final TSE_RE_T_LABEL SECURITIES_REPORT_FILING_DATE_AS_PLANNED_REIT = new TSE_RE_T_LABEL(
        "SecuritiesReportFilingDateAsPlannedREIT", 
        "Securities report filing date (as planned)", 
        "有価証券報告書提出予定日");
    public static final TSE_RE_T_LABEL SPECIAL_NOTES_INTERIM_EARNING_DIGEST_SUMMARY_REITHEADING = new TSE_RE_T_LABEL(
        "SpecialNotesInterimEarningDigestSummaryREITHeading", 
        "Interim special notes", 
        "中間期サマリー情報に関する注記");
    public static final TSE_RE_T_LABEL SPECIAL_NOTES_INTERIM_EARNING_DIGEST_SUMMARY_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "SpecialNotesInterimEarningDigestSummaryREITLineItems", 
        "Interim special notes", 
        "中間期サマリー情報に関する注記");
    public static final TSE_RE_T_LABEL SPECIAL_NOTES_INTERIM_EARNING_DIGEST_SUMMARY_REITTABLE = new TSE_RE_T_LABEL(
        "SpecialNotesInterimEarningDigestSummaryREITTable", 
        "Interim special notes", 
        "中間期サマリー情報に関する注記");
    public static final TSE_RE_T_LABEL SPECIAL_NOTES_REITHEADING = new TSE_RE_T_LABEL(
        "SpecialNotesREITHeading", 
        "Special notes", 
        "サマリー情報に関する注記");
    public static final TSE_RE_T_LABEL SPECIAL_NOTES_REITLINE_ITEMS = new TSE_RE_T_LABEL(
        "SpecialNotesREITLineItems", 
        "Special notes", 
        "サマリー情報に関する注記");
    public static final TSE_RE_T_LABEL SPECIAL_NOTES_REITTABLE = new TSE_RE_T_LABEL(
        "SpecialNotesREITTable", 
        "Special notes", 
        "サマリー情報に関する注記");
    public static final TSE_RE_T_LABEL STOCK_EXCHANGE_LISTINGS_ABSTRACT = new TSE_RE_T_LABEL(
        "StockExchangeListingsAbstract", 
        "Stock exchange listings", 
        "上場取引所");
    public static final TSE_RE_T_LABEL SUPPLEMENTAL_MATERIAL_OF_INTERIM_RESULTS_REIT = new TSE_RE_T_LABEL(
        "SupplementalMaterialOfInterimResultsREIT", 
        "Supplemental material of interim results", 
        "中間決算補足説明資料作成の有無");
    public static final TSE_RE_T_LABEL SUPPLEMENTAL_MATERIAL_OF_RESULTS_REIT = new TSE_RE_T_LABEL(
        "SupplementalMaterialOfResultsREIT", 
        "Supplemental material of results", 
        "決算補足説明資料作成の有無");
    public static final TSE_RE_T_LABEL TARGET_AUDIENCE_BRIEFING_OF_INTERIM_RESULTS_REIT = new TSE_RE_T_LABEL(
        "TargetAudienceBriefingOfInterimResultsREIT", 
        "Target audience-briefing of interim results", 
        "中間決算説明会の対象者");
    public static final TSE_RE_T_LABEL TARGET_AUDIENCE_BRIEFING_OF_RESULTS_REIT = new TSE_RE_T_LABEL(
        "TargetAudienceBriefingOfResultsREIT", 
        "Target audience", 
        "対象者");
    public static final TSE_RE_T_LABEL TEL = new TSE_RE_T_LABEL(
        "Tel", 
        "Tel", 
        "TEL");
    public static final TSE_RE_T_LABEL TITLE_ASSET_MANAGER_REIT = new TSE_RE_T_LABEL(
        "TitleAssetManagerREIT", 
        "Title", 
        "役職名");
    public static final TSE_RE_T_LABEL TITLE_FOR_FORECASTS_REIT = new TSE_RE_T_LABEL(
        "TitleForForecastsREIT", 
        "Title for forecasts", 
        "運用状況の予想タイトル名称");
    public static final TSE_RE_T_LABEL TITLE_INQUIRIES = new TSE_RE_T_LABEL(
        "TitleInquiries", 
        "Title", 
        "役職名");
    public static final TSE_RE_T_LABEL TITLE_REPRESENTATIVE = new TSE_RE_T_LABEL(
        "TitleRepresentative", 
        "Title", 
        "役職名");
    public static final TSE_RE_T_LABEL TOKYO_STOCK_EXCHANGE = new TSE_RE_T_LABEL(
        "TokyoStockExchange", 
        "Tokyo", 
        "東");
    public static final TSE_RE_T_LABEL TOKYO_STOCK_EXCHANGE_1ST_SECTION = new TSE_RE_T_LABEL(
        "TokyoStockExchange1stSection", 
        "Tokyo 1st section", 
        "第一部");
    public static final TSE_RE_T_LABEL TOKYO_STOCK_EXCHANGE_2ND_SECTION = new TSE_RE_T_LABEL(
        "TokyoStockExchange2ndSection", 
        "Tokyo 2nd section", 
        "第二部");
    public static final TSE_RE_T_LABEL TOKYO_STOCK_EXCHANGE_JASDAQ = new TSE_RE_T_LABEL(
        "TokyoStockExchangeJASDAQ", 
        "Tokyo JASDAQ", 
        "JASDAQ");
    public static final TSE_RE_T_LABEL TOKYO_STOCK_EXCHANGE_MOTHERS = new TSE_RE_T_LABEL(
        "TokyoStockExchangeMothers", 
        "Tokyo Mothers", 
        "マザーズ");
    public static final TSE_RE_T_LABEL TOKYO_STOCK_EXCHANGE_OTHERS = new TSE_RE_T_LABEL(
        "TokyoStockExchangeOthers", 
        "Tokyo Others", 
        "その他");
    public static final TSE_RE_T_LABEL TOKYO_STOCK_EXCHANGE_PROMARKET = new TSE_RE_T_LABEL(
        "TokyoStockExchangePROMarket", 
        "Tokyo PRO Market", 
        "PRO Market");
    public static final TSE_RE_T_LABEL TOTAL_ASSETS = new TSE_RE_T_LABEL(
        "TotalAssets", 
        "Total assets", 
        "総資産");
    public static final TSE_RE_T_LABEL TOTAL_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT = new TSE_RE_T_LABEL(
        "TotalDistributionsInExcessOfProfitREIT", 
        "Total distributions in excess of profit", 
        "利益超過分配金総額");
    public static final TSE_RE_T_LABEL TOTAL_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REITABSTRACT = new TSE_RE_T_LABEL(
        "TotalDistributionsInExcessOfProfitREITAbstract", 
        "Total distributions in excess of profit", 
        "利益超過分配金総額");
    public static final TSE_RE_T_LABEL TOTAL_DISTRIBUTIONS_INCLUDING_TOTAL_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT = new TSE_RE_T_LABEL(
        "TotalDistributionsIncludingTotalDistributionsInExcessOfProfitREIT", 
        "Total distributions (including total distributions in excess of profit)", 
        "分配金総額（利益超過分配金を含む）");
    public static final TSE_RE_T_LABEL TOTAL_DISTRIBUTIONS_INCLUDING_TOTAL_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REITABSTRACT = new TSE_RE_T_LABEL(
        "TotalDistributionsIncludingTotalDistributionsInExcessOfProfitREITAbstract", 
        "Total distributions (including total distributions in excess of profit)", 
        "分配金総額（利益超過分配金を含む）");
    public static final TSE_RE_T_LABEL TOTAL_DISTRIBUTIONS_REIT = new TSE_RE_T_LABEL(
        "TotalDistributionsREIT", 
        "Total Distributions (excluding total distributions in excess of profit)", 
        "分配金総額（利益超過分配金は含まない）");
    public static final TSE_RE_T_LABEL TOTAL_DISTRIBUTIONS_REITABSTRACT = new TSE_RE_T_LABEL(
        "TotalDistributionsREITAbstract", 
        "Total Distributions (excluding total distributions in excess of profit)", 
        "分配金総額（利益超過分配金は含まない）");
    public static final TSE_RE_T_LABEL URL = new TSE_RE_T_LABEL(
        "URL", 
        "URL", 
        "URL");
    public static final TSE_RE_T_LABEL UPPER_MEMBER = new TSE_RE_T_LABEL(
        "UpperMember", 
        "Upper", 
        "上限");
    public static final TSE_RE_T_LABEL WAY_OF_GETTING_SUPPLEMENTAL_MATERIAL_OF_INTERIM_RESULTS_REIT = new TSE_RE_T_LABEL(
        "WayOfGettingSupplementalMaterialOfInterimResultsREIT", 
        "Way of getting", 
        "入手方法等");
    public static final TSE_RE_T_LABEL WAY_OF_GETTING_SUPPLEMENTAL_MATERIAL_OF_RESULTS_REIT = new TSE_RE_T_LABEL(
        "WayOfGettingSupplementalMaterialOfResultsREIT", 
        "Way of getting", 
        "入手方法等");
    ;
    
    private TSE_RE_T_LABEL(String name, String en, String ja) {
        super(NAMESPACE, name, en, ja);
    }
    
    public static final Set<TSE_RE_T_LABEL> ALL = new TreeSet<>();
    static {
        ALL.add(AMOUNT_CHANGE_NET_INCOME);
        ALL.add(AMOUNT_CHANGE_OPERATING_INCOME);
        ALL.add(AMOUNT_CHANGE_OPERATING_REVENUES_REIT);
        ALL.add(AMOUNT_CHANGE_ORDINARY_INCOME);
        ALL.add(ASSET_MANAGER_REIT);
        ALL.add(BUSINESS_RESULTS_CASH_FLOWS_REITHEADING);
        ALL.add(BUSINESS_RESULTS_CASH_FLOWS_REITLINE_ITEMS);
        ALL.add(BUSINESS_RESULTS_CASH_FLOWS_REITTABLE);
        ALL.add(BUSINESS_RESULTS_DISTRIBUTIONS_REITHEADING);
        ALL.add(BUSINESS_RESULTS_DISTRIBUTIONS_REITLINE_ITEMS);
        ALL.add(BUSINESS_RESULTS_DISTRIBUTIONS_REITTABLE);
        ALL.add(BUSINESS_RESULTS_FINANCIAL_POSITIONS_REITHEADING);
        ALL.add(BUSINESS_RESULTS_FINANCIAL_POSITIONS_REITLINE_ITEMS);
        ALL.add(BUSINESS_RESULTS_FINANCIAL_POSITIONS_REITTABLE);
        ALL.add(BUSINESS_RESULTS_INTERIM_CASH_FLOWS_REITHEADING);
        ALL.add(BUSINESS_RESULTS_INTERIM_CASH_FLOWS_REITLINE_ITEMS);
        ALL.add(BUSINESS_RESULTS_INTERIM_CASH_FLOWS_REITTABLE);
        ALL.add(BUSINESS_RESULTS_INTERIM_FINANCIAL_POSITIONS_REITHEADING);
        ALL.add(BUSINESS_RESULTS_INTERIM_FINANCIAL_POSITIONS_REITLINE_ITEMS);
        ALL.add(BUSINESS_RESULTS_INTERIM_FINANCIAL_POSITIONS_REITTABLE);
        ALL.add(BUSINESS_RESULTS_INTERIM_OPERATING_RESULTS_REITHEADING);
        ALL.add(BUSINESS_RESULTS_INTERIM_OPERATING_RESULTS_REITLINE_ITEMS);
        ALL.add(BUSINESS_RESULTS_INTERIM_OPERATING_RESULTS_REITTABLE);
        ALL.add(BUSINESS_RESULTS_OPERATING_RESULTS_REITHEADING);
        ALL.add(BUSINESS_RESULTS_OPERATING_RESULTS_REITLINE_ITEMS);
        ALL.add(BUSINESS_RESULTS_OPERATING_RESULTS_REITTABLE);
        ALL.add(CAPITAL_ADEQUACY_RATIO);
        ALL.add(CASH_AND_EQUIVALENTS_END_OF_PERIOD);
        ALL.add(CASH_DISTRIBUTIONS_REITABSTRACT);
        ALL.add(CASH_FLOWS_ABSTRACT);
        ALL.add(CASH_FLOWS_FROM_FINANCING_ACTIVITIES);
        ALL.add(CASH_FLOWS_FROM_INVESTING_ACTIVITIES);
        ALL.add(CASH_FLOWS_FROM_OPERATING_ACTIVITIES);
        ALL.add(CHANGE_IN_NET_INCOME);
        ALL.add(CHANGE_IN_OPERATING_INCOME);
        ALL.add(CHANGE_IN_OPERATING_REVENUES_REIT);
        ALL.add(CHANGE_IN_ORDINARY_INCOME);
        ALL.add(CHANGES_BASED_ON_REVISIONS_OF_ACCOUNTING_STANDARD);
        ALL.add(CHANGES_IN_ACCOUNTING_ESTIMATES);
        ALL.add(CHANGES_IN_ACCOUNTING_POLICIES_AND_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_ABSTRACT);
        ALL.add(CHANGES_OTHER_THAN_ONES_BASED_ON_REVISIONS_OF_ACCOUNTING_STANDARD);
        ALL.add(CONSOLIDATED_NONCONSOLIDATED_AXIS);
        ALL.add(CONVENING_BRIEFING_OF_INTERIM_RESULTS_REIT);
        ALL.add(CONVENING_BRIEFING_OF_RESULTS_REIT);
        ALL.add(CORRECTION_DETAIL_REITABSTRACT);
        ALL.add(CURRENT_MEMBER);
        ALL.add(DISTRIBUTION_FORECAST_CORRECTION_REITABSTRACT);
        ALL.add(DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_PER_UNIT_FORECAST_REITABSTRACT);
        ALL.add(DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_PER_UNIT_REIT);
        ALL.add(DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_PER_UNIT_REITABSTRACT);
        ALL.add(DISTRIBUTIONS_PAYABLE_DATE_AS_PLANNED_REIT);
        ALL.add(DISTRIBUTIONS_PER_UNIT_EXCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_FORECAST_REITABSTRACT);
        ALL.add(DISTRIBUTIONS_PER_UNIT_EXCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT);
        ALL.add(DISTRIBUTIONS_PER_UNIT_EXCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REITABSTRACT);
        ALL.add(DISTRIBUTIONS_PER_UNIT_INCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_FORECAST_REITABSTRACT);
        ALL.add(DISTRIBUTIONS_PER_UNIT_INCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT);
        ALL.add(DISTRIBUTIONS_PER_UNIT_INCLUDING_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REITABSTRACT);
        ALL.add(DISTRIBUTIONS_PER_UNIT_REITABSTRACT);
        ALL.add(DISTRIBUTIONS_REITABSTRACT);
        ALL.add(DOCUMENT_ENTITY_INFORMATION_REITHEADING);
        ALL.add(DOCUMENT_ENTITY_INFORMATION_REITLINE_ITEMS);
        ALL.add(DOCUMENT_ENTITY_INFORMATION_REITTABLE);
        ALL.add(DOCUMENT_NAME);
        ALL.add(EXPRESSION_OF_IMPLEMENTATION_STATUS_OF_AUDIT_PROCEDURES);
        ALL.add(EXPRESSION_OF_IMPLEMENTATION_STATUS_OF_INTERIM_AUDIT_PROCEDURES);
        ALL.add(FILING_DATE);
        ALL.add(FINANCIAL_POSITIONS_ABSTRACT);
        ALL.add(FISCAL_YEAR_END);
        ALL.add(FORECAST_CORRECTION_OF_OPERATING_RESULTS_INTERIM_REITHEADING);
        ALL.add(FORECAST_CORRECTION_OF_OPERATING_RESULTS_INTERIM_REITLINE_ITEMS);
        ALL.add(FORECAST_CORRECTION_OF_OPERATING_RESULTS_INTERIM_REITTABLE);
        ALL.add(FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITABSTRACT);
        ALL.add(FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITHEADING);
        ALL.add(FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITLINE_ITEMS);
        ALL.add(FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITTABLE);
        ALL.add(FORECAST_MEMBER);
        ALL.add(FORECASTS_REITHEADING);
        ALL.add(FORECASTS_REITLINE_ITEMS);
        ALL.add(FORECASTS_REITTABLE);
        ALL.add(FUKUOKA_STOCK_EXCHANGE);
        ALL.add(FUKUOKA_STOCK_EXCHANGE_ESTABLISHED);
        ALL.add(FUKUOKA_STOCK_EXCHANGE_OTHERS);
        ALL.add(FUKUOKA_STOCK_EXCHANGE_QBOARD);
        ALL.add(INCOME_STATEMENTS_INFORMATION_ABSTRACT);
        ALL.add(INQUIRIES_ABSTRACT);
        ALL.add(INTERIM_FORECASTS_REITHEADING);
        ALL.add(INTERIM_FORECASTS_REITLINE_ITEMS);
        ALL.add(INTERIM_FORECASTS_REITTABLE);
        ALL.add(INTERIM_REPORT_FILING_DATE_AS_PLANNED_REIT);
        ALL.add(ISSUER_NAME_REIT);
        ALL.add(JAPAN_SECURITIES_DEALERS_ASSOCIATION);
        ALL.add(JAPAN_SECURITIES_DEALERS_ASSOCIATION_GREEN_SHEET);
        ALL.add(LOWER_MEMBER);
        ALL.add(MAIN_TABLE_OF_FORECASTS_OF_OPERATING_RESULTS_INTERIM_REITABSTRACT);
        ALL.add(MAIN_TABLE_OF_FORECASTS_OF_OPERATING_RESULTS_REITABSTRACT);
        ALL.add(MAIN_TABLE_OF_FORECASTS_REITABSTRACT);
        ALL.add(MAIN_TABLE_OF_NEXT_FORECASTS_OF_OPERATING_RESULTS_REITABSTRACT);
        ALL.add(NAGOYA_STOCK_EXCHANGE);
        ALL.add(NAGOYA_STOCK_EXCHANGE_1ST_SECTION);
        ALL.add(NAGOYA_STOCK_EXCHANGE_2ND_SECTION);
        ALL.add(NAGOYA_STOCK_EXCHANGE_CENTREX);
        ALL.add(NAGOYA_STOCK_EXCHANGE_OTHERS);
        ALL.add(NAME_ASSET_MANAGER_REIT);
        ALL.add(NAME_INQUIRIES);
        ALL.add(NAME_REPRESENTATIVE);
        ALL.add(NET_ASSETS);
        ALL.add(NET_ASSETS_PER_UNIT_REIT);
        ALL.add(NET_INCOME);
        ALL.add(NET_INCOME_ABSTRACT);
        ALL.add(NET_INCOME_CORRECTION_ABSTRACT);
        ALL.add(NET_INCOME_FORECAST_ABSTRACT);
        ALL.add(NET_INCOME_PER_UNIT_CORRECTION_REITABSTRACT);
        ALL.add(NET_INCOME_PER_UNIT_REIT);
        ALL.add(NET_INCOME_TO_UNITHOLDERS_EQUITY_RATIO_REIT);
        ALL.add(NEXT_FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITHEADING);
        ALL.add(NEXT_FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITLINE_ITEMS);
        ALL.add(NEXT_FORECAST_CORRECTION_OF_OPERATING_RESULTS_REITTABLE);
        ALL.add(NEXT_REVISED_DISTRIBUTION_FORECAST_REITHEADING);
        ALL.add(NEXT_REVISED_DISTRIBUTION_FORECAST_REITLINE_ITEMS);
        ALL.add(NEXT_REVISED_DISTRIBUTION_FORECAST_REITTABLE);
        ALL.add(NON_CONSOLIDATED_MEMBER);
        ALL.add(NOTE_AND_REASON_FOR_CORRECTION_REITABSTRACT);
        ALL.add(NOTE_AND_REASON_FOR_CORRECTION_REITHEADING);
        ALL.add(NOTE_AND_REASON_FOR_CORRECTION_REITLINE_ITEMS);
        ALL.add(NOTE_AND_REASON_FOR_CORRECTION_REITTABLE);
        ALL.add(NOTE_TO_CASH_FLOWS);
        ALL.add(NOTE_TO_CASH_FLOWS_ABSTRACT);
        ALL.add(NOTE_TO_CHANGES_IN_ACCOUNTING_POLICIES_AND_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT);
        ALL.add(NOTE_TO_CHANGES_IN_ACCOUNTING_POLICIES_AND_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_ABSTRACT);
        ALL.add(NOTE_TO_DISTRIBUTIONS_REIT);
        ALL.add(NOTE_TO_DISTRIBUTIONS_REITABSTRACT);
        ALL.add(NOTE_TO_FINANCIAL_POSITIONS);
        ALL.add(NOTE_TO_FINANCIAL_POSITIONS_ABSTRACT);
        ALL.add(NOTE_TO_FORECAST_CORRECTION_REIT);
        ALL.add(NOTE_TO_FORECAST_CORRECTION_REITABSTRACT);
        ALL.add(NOTE_TO_FORECASTS_REIT);
        ALL.add(NOTE_TO_FORECASTS_REITABSTRACT);
        ALL.add(NOTE_TO_FRACTION_PROCESSING_METHOD);
        ALL.add(NOTE_TO_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REIT);
        ALL.add(NOTE_TO_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITABSTRACT);
        ALL.add(NOTE_TO_OPERATING_RESULTS_REIT);
        ALL.add(NOTE_TO_OPERATING_RESULTS_REITABSTRACT);
        ALL.add(NOTE_TO_REVISED_DISTRIBUTION_FORECAST_REITHEADING);
        ALL.add(NOTE_TO_REVISED_DISTRIBUTION_FORECAST_REITLINE_ITEMS);
        ALL.add(NOTE_TO_REVISED_DISTRIBUTION_FORECAST_REITTABLE);
        ALL.add(NOTES_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITHEADING);
        ALL.add(NOTES_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITLINE_ITEMS);
        ALL.add(NOTES_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITTABLE);
        ALL.add(NOTES_FOR_USING_FORECASTED_INFORMATION_AND_OTHERS_REIT);
        ALL.add(NOTES_INTERIM_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITHEADING);
        ALL.add(NOTES_INTERIM_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITLINE_ITEMS);
        ALL.add(NOTES_INTERIM_CHANGES_ACCOUNTING_POLICIES_ACCOUNTING_ESTIMATES_RETROSPECTIVE_RESTATEMENT_REITTABLE);
        ALL.add(NOTES_INTERIM_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITHEADING);
        ALL.add(NOTES_INTERIM_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITLINE_ITEMS);
        ALL.add(NOTES_INTERIM_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITTABLE);
        ALL.add(NOTES_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITHEADING);
        ALL.add(NOTES_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITLINE_ITEMS);
        ALL.add(NOTES_NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITTABLE);
        ALL.add(NOTICE_OF_FORECAST_CORRECTION);
        ALL.add(NUMBER_OF_INVESTMENT_UNITS_INCLUDING_TREASURY_INVESTMENT_UNITS_ISSUED_AT_END_OF_PERIOD_REIT);
        ALL.add(NUMBER_OF_INVESTMENT_UNITS_ISSUED_REITABSTRACT);
        ALL.add(NUMBER_OF_TREASURY_INVESTMENT_UNITS_ISSUED_AT_END_OF_PERIOD_REIT);
        ALL.add(OPERATING_INCOME);
        ALL.add(OPERATING_INCOME_ABSTRACT);
        ALL.add(OPERATING_INCOME_CORRECTION_ABSTRACT);
        ALL.add(OPERATING_INCOME_FORECAST_ABSTRACT);
        ALL.add(OPERATING_RESULTS_REITABSTRACT);
        ALL.add(OPERATING_REVENUES_CORRECTION_REITABSTRACT);
        ALL.add(OPERATING_REVENUES_FORECAST_REITABSTRACT);
        ALL.add(OPERATING_REVENUES_REIT);
        ALL.add(OPERATING_REVENUES_REITABSTRACT);
        ALL.add(ORDINARY_INCOME);
        ALL.add(ORDINARY_INCOME_ABSTRACT);
        ALL.add(ORDINARY_INCOME_CORRECTION_ABSTRACT);
        ALL.add(ORDINARY_INCOME_FORECAST_ABSTRACT);
        ALL.add(ORDINARY_INCOME_TO_OPERATING_REVENUES_RATIO_REIT);
        ALL.add(ORDINARY_INCOME_TO_TOTAL_ASSETS_RATIO);
        ALL.add(OTHER_OPERATING_RESULTS_REITABSTRACT);
        ALL.add(OTHER_SUBMITTER_INFORMATION_REITABSTRACT);
        ALL.add(OTHERS_REITABSTRACT);
        ALL.add(PAYOUT_RATIO);
        ALL.add(PAYOUT_RATIO_ABSTRACT);
        ALL.add(PREVIOUS_CURRENT_AXIS);
        ALL.add(PREVIOUS_MEMBER);
        ALL.add(RATIO_OF_DISTRIBUTIONS_TO_NET_ASSETS_REIT);
        ALL.add(RATIO_OF_DISTRIBUTIONS_TO_NET_ASSETS_REITABSTRACT);
        ALL.add(REASON_FOR_CORRECTION_DISTRIBUTION_FORECAST_CORRECTION_REITABSTRACT);
        ALL.add(REASON_FOR_DISTRIBUTION_FORECAST_CORRECTION_REIT);
        ALL.add(REASON_FOR_FORECAST_CORRECTION_REIT);
        ALL.add(REASON_FOR_FORECAST_CORRECTION_REITABSTRACT);
        ALL.add(REPORTING_DATE_OF_DISTRIBUTION_FORECAST_CORRECTION_REIT);
        ALL.add(REPORTING_DATE_OF_FINANCIAL_FORECAST_CORRECTION);
        ALL.add(REPRESENTATIVE_ABSTRACT);
        ALL.add(REPRESENTATIVE_ASSET_MANAGER_REITABSTRACT);
        ALL.add(RESULT_FORECAST_AXIS);
        ALL.add(RESULT_MEMBER);
        ALL.add(RETROSPECTIVE_RESTATEMENT);
        ALL.add(REVISED_DISTRIBUTION_FORECAST_REITHEADING);
        ALL.add(REVISED_DISTRIBUTION_FORECAST_REITLINE_ITEMS);
        ALL.add(REVISED_DISTRIBUTION_FORECAST_REITTABLE);
        ALL.add(SAPPORO_STOCK_EXCHANGE);
        ALL.add(SAPPORO_STOCK_EXCHANGE_AMBITIOUS);
        ALL.add(SAPPORO_STOCK_EXCHANGE_ESTABLISHED);
        ALL.add(SAPPORO_STOCK_EXCHANGE_OTHERS);
        ALL.add(SECURITIES_CODE);
        ALL.add(SECURITIES_REPORT_FILING_DATE_AS_PLANNED_REIT);
        ALL.add(SPECIAL_NOTES_INTERIM_EARNING_DIGEST_SUMMARY_REITHEADING);
        ALL.add(SPECIAL_NOTES_INTERIM_EARNING_DIGEST_SUMMARY_REITLINE_ITEMS);
        ALL.add(SPECIAL_NOTES_INTERIM_EARNING_DIGEST_SUMMARY_REITTABLE);
        ALL.add(SPECIAL_NOTES_REITHEADING);
        ALL.add(SPECIAL_NOTES_REITLINE_ITEMS);
        ALL.add(SPECIAL_NOTES_REITTABLE);
        ALL.add(STOCK_EXCHANGE_LISTINGS_ABSTRACT);
        ALL.add(SUPPLEMENTAL_MATERIAL_OF_INTERIM_RESULTS_REIT);
        ALL.add(SUPPLEMENTAL_MATERIAL_OF_RESULTS_REIT);
        ALL.add(TARGET_AUDIENCE_BRIEFING_OF_INTERIM_RESULTS_REIT);
        ALL.add(TARGET_AUDIENCE_BRIEFING_OF_RESULTS_REIT);
        ALL.add(TEL);
        ALL.add(TITLE_ASSET_MANAGER_REIT);
        ALL.add(TITLE_FOR_FORECASTS_REIT);
        ALL.add(TITLE_INQUIRIES);
        ALL.add(TITLE_REPRESENTATIVE);
        ALL.add(TOKYO_STOCK_EXCHANGE);
        ALL.add(TOKYO_STOCK_EXCHANGE_1ST_SECTION);
        ALL.add(TOKYO_STOCK_EXCHANGE_2ND_SECTION);
        ALL.add(TOKYO_STOCK_EXCHANGE_JASDAQ);
        ALL.add(TOKYO_STOCK_EXCHANGE_MOTHERS);
        ALL.add(TOKYO_STOCK_EXCHANGE_OTHERS);
        ALL.add(TOKYO_STOCK_EXCHANGE_PROMARKET);
        ALL.add(TOTAL_ASSETS);
        ALL.add(TOTAL_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT);
        ALL.add(TOTAL_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REITABSTRACT);
        ALL.add(TOTAL_DISTRIBUTIONS_INCLUDING_TOTAL_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REIT);
        ALL.add(TOTAL_DISTRIBUTIONS_INCLUDING_TOTAL_DISTRIBUTIONS_IN_EXCESS_OF_PROFIT_REITABSTRACT);
        ALL.add(TOTAL_DISTRIBUTIONS_REIT);
        ALL.add(TOTAL_DISTRIBUTIONS_REITABSTRACT);
        ALL.add(URL);
        ALL.add(UPPER_MEMBER);
        ALL.add(WAY_OF_GETTING_SUPPLEMENTAL_MATERIAL_OF_INTERIM_RESULTS_REIT);
        ALL.add(WAY_OF_GETTING_SUPPLEMENTAL_MATERIAL_OF_RESULTS_REIT);
    }
}
