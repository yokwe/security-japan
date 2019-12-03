package yokwe.security.japan.xbrl.taxonomy;

import java.util.Set;
import java.util.TreeSet;

public class TSE_T_CG_LABEL extends LabelData {
    public static final String NAMESPACE = "http://www.xbrl.tdnet.info/jp/br/tdnet/t/cg/2007-06-30";
    
    public static void init() {}
    
    public static final TSE_T_CG_LABEL ACTIVITIES_CONCERNING_RESPECT_FOR_STAKEHOLDERS_ABSTRACT = new TSE_T_CG_LABEL(
        "ActivitiesConcerningRespectForStakeholdersAbstract", 
        "Activities concerning respect for stakeholders", 
        "ステークホルダーの立場の尊重に係る取組み状況");
    public static final TSE_T_CG_LABEL ACTIVITIES_CONCERNING_RESPECT_FOR_STAKEHOLDERS_CHECK = new TSE_T_CG_LABEL(
        "ActivitiesConcerningRespectForStakeholdersCheck", 
        "Activities concerning respect for stakeholders", 
        "ステークホルダーの立場の尊重に係る取組み状況");
    public static final TSE_T_CG_LABEL ADDITIONAL_DUTIES_AS_DIRECTOR = new TSE_T_CG_LABEL(
        "AdditionalDutiesAsDirector", 
        "Additional duties as director", 
        "取締役との兼任の有無");
    public static final TSE_T_CG_LABEL ADDITIONAL_DUTIES_AS_EMPLOYEE = new TSE_T_CG_LABEL(
        "AdditionalDutiesAsEmployee", 
        "Additional duties as employee", 
        "使用人との兼任の有無");
    public static final TSE_T_CG_LABEL ANNUAL_SECURITIES_REPORT = new TSE_T_CG_LABEL(
        "AnnualSecuritiesReport", 
        "Annual securities report", 
        "有価証券報告書");
    public static final TSE_T_CG_LABEL ATTRIBUTION_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "AttributionOutsideCorporateAuditors", 
        "Attribution", 
        "属性");
    public static final TSE_T_CG_LABEL ATTRIBUTION_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "AttributionOutsideDirectors", 
        "Attribution", 
        "属性");
    public static final TSE_T_CG_LABEL AUDIT_COMMITTEE_ABSTRACT = new TSE_T_CG_LABEL(
        "AuditCommitteeAbstract", 
        "Audit committee", 
        "監査委員会");
    public static final TSE_T_CG_LABEL AUDIT_COMMITTEE_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "AuditCommitteeOutsideDirectors", 
        "Audit committee", 
        "監査委員会");
    public static final TSE_T_CG_LABEL AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "AuditEtcCommitteeOutsideDirectors", 
        "Audit etc. committee member", 
        "監査等委員");
    public static final TSE_T_CG_LABEL AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "AuditEtcCommitteeOutsideDirectorsAbstract", 
        "Audit etc. committee", 
        "監査等委員会");
    public static final TSE_T_CG_LABEL AUDITING_STRUCTURE_ABSTRACT = new TSE_T_CG_LABEL(
        "AuditingStructureAbstract", 
        "Auditing structure", 
        "監査体制");
    public static final TSE_T_CG_LABEL AUDITORS_ABSTRACT = new TSE_T_CG_LABEL(
        "AuditorsAbstract", 
        "Auditors", 
        "監査役関係");
    public static final TSE_T_CG_LABEL AUDITORS_OF_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "AuditorsOfParentCompany", 
        "Auditors of parent company", 
        "親会社の監査役");
    public static final TSE_T_CG_LABEL AUDITORS_OF_SUBSIDIARIES = new TSE_T_CG_LABEL(
        "AuditorsOfSubsidiaries", 
        "Auditors of subsidiaries", 
        "子会社の監査役");
    public static final TSE_T_CG_LABEL AVAILABILITY_OF_ENGLISH_TRANSLATION_OF_GENERAL_SHAREHOLDERS_MEETING_NOTICE = new TSE_T_CG_LABEL(
        "AvailabilityOfEnglishTranslationOfGeneralShareholdersMeetingNotice", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL AVAILABILITY_OF_ENGLISH_TRANSLATION_OF_GENERAL_SHAREHOLDERS_MEETING_NOTICE_ABSTRACT = new TSE_T_CG_LABEL(
        "AvailabilityOfEnglishTranslationOfGeneralShareholdersMeetingNoticeAbstract", 
        "Availability of English translation of general shareholders meeting notice", 
        "招集通知（要約）の英文での提供");
    public static final TSE_T_CG_LABEL BASIC_APPROACH_TO_INTERNAL_CONTROL_SYSTEM_AND_ITS_DEVELOPMENT = new TSE_T_CG_LABEL(
        "BasicApproachToInternalControlSystemAndItsDevelopment", 
        "Basic approach to internal control system and its development", 
        "内部統制システムに関する基本的な考え方及びその整備状況");
    public static final TSE_T_CG_LABEL BASIC_APPROACH_TO_INTERNAL_CONTROL_SYSTEM_AND_ITS_DEVELOPMENT_CHECK = new TSE_T_CG_LABEL(
        "BasicApproachToInternalControlSystemAndItsDevelopmentCheck", 
        "Basic approach to internal control system and its development", 
        "内部統制システムに関する基本的な考え方及びその整備状況");
    public static final TSE_T_CG_LABEL BASIC_POLICY = new TSE_T_CG_LABEL(
        "BasicPolicy", 
        "Basic policy", 
        "基本的な考え方");
    public static final TSE_T_CG_LABEL BASIC_POLICY_CHECK = new TSE_T_CG_LABEL(
        "BasicPolicyCheck", 
        "Basic policy", 
        "基本的な考え方");
    public static final TSE_T_CG_LABEL BASIC_POLICY_ON_CORPORATE_GOVERNANCE_AND_CAPITAL_STRUCTURE_BUSINESS_ATTRIBUTES_AND_OTHER_BASIC_INFORMATION_ABSTRACT = new TSE_T_CG_LABEL(
        "BasicPolicyOnCorporateGovernanceAndCapitalStructureBusinessAttributesAndOtherBasicInformationAbstract", 
        "Basic policy on corporate governance and capital structure, business attributes and other basic information", 
        "コーポレート・ガバナンスに関する基本的な考え方及び資本構成、企業属性その他の基本情報");
    public static final TSE_T_CG_LABEL BASIC_POLICY_TO_REJECT_ANTISOCIAL_FORCES_AND_THE_PROGRESS_OF_DEVELOPMENT = new TSE_T_CG_LABEL(
        "BasicPolicyToRejectAntisocialForcesAndTheProgressOfDevelopment", 
        "Basic policy to reject antisocial forces and the progress of development", 
        "反社会的勢力排除に向けた基本的な考え方及びその整備状況");
    public static final TSE_T_CG_LABEL BASIC_POLICY_TO_REJECT_ANTISOCIAL_FORCES_AND_THE_PROGRESS_OF_DEVELOPMENT_CHECK = new TSE_T_CG_LABEL(
        "BasicPolicyToRejectAntisocialForcesAndTheProgressOfDevelopmentCheck", 
        "Basic policy to reject antisocial forces and the progress of development", 
        "反社会的勢力排除に向けた基本的な考え方及びその整備状況");
    public static final TSE_T_CG_LABEL BUSINESS_ATTRIBUTES_ABSTRACT = new TSE_T_CG_LABEL(
        "BusinessAttributesAbstract", 
        "Business attributes", 
        "企業属性");
    public static final TSE_T_CG_LABEL BUSINESS_REPORT = new TSE_T_CG_LABEL(
        "BusinessReport", 
        "Business report", 
        "営業報告書（事業報告）");
    public static final TSE_T_CG_LABEL CAPITAL_STRUCTURE_ABSTRACT = new TSE_T_CG_LABEL(
        "CapitalStructureAbstract", 
        "Capital structure", 
        "資本構成");
    public static final TSE_T_CG_LABEL CHAIR_AUDIT = new TSE_T_CG_LABEL(
        "ChairAudit", 
        "Chair", 
        "委員長（議長）");
    public static final TSE_T_CG_LABEL CHAIR_AUDIT_20150401 = new TSE_T_CG_LABEL(
        "ChairAudit20150401", 
        "Chair", 
        "委員長（議長）");
    public static final TSE_T_CG_LABEL CHAIR_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "ChairAuditEtcCommitteeOutsideDirectors", 
        "Chair", 
        "委員長（議長）");
    public static final TSE_T_CG_LABEL CHAIR_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE = new TSE_T_CG_LABEL(
        "ChairCommitteeCorrespondingToCompensationCommittee", 
        "Chair", 
        "委員長（議長）");
    public static final TSE_T_CG_LABEL CHAIR_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE = new TSE_T_CG_LABEL(
        "ChairCommitteeCorrespondingToNominatingCommittee", 
        "Chair", 
        "委員長（議長）");
    public static final TSE_T_CG_LABEL CHAIR_COMPENSATION = new TSE_T_CG_LABEL(
        "ChairCompensation", 
        "Chair", 
        "委員長（議長）");
    public static final TSE_T_CG_LABEL CHAIR_COMPENSATION_20150401 = new TSE_T_CG_LABEL(
        "ChairCompensation20150401", 
        "Chair", 
        "委員長（議長）");
    public static final TSE_T_CG_LABEL CHAIR_NOMINATION = new TSE_T_CG_LABEL(
        "ChairNomination", 
        "Chair", 
        "委員長（議長）");
    public static final TSE_T_CG_LABEL CHAIR_NOMINATION_20150401 = new TSE_T_CG_LABEL(
        "ChairNomination20150401", 
        "Chair", 
        "委員長（議長）");
    public static final TSE_T_CG_LABEL CHAIRMAN_OF_THE_BOARD_OF_DIRECTORS_COMPANY_WITH_ABOARD_OF_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "ChairmanOfTheBoardOfDirectorsCompanyWithABoardOfCorporateAuditors", 
        "Chairman of the board of directors", 
        "取締役会の議長");
    public static final TSE_T_CG_LABEL CHAIRMAN_OF_THE_BOARD_OF_DIRECTORS_COMPANY_WITH_ABOARD_OF_CORPORATE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "ChairmanOfTheBoardOfDirectorsCompanyWithABoardOfCorporateAuditorsCheck", 
        "Chairman of the board of directors", 
        "取締役会の議長");
    public static final TSE_T_CG_LABEL CHAIRMAN_OF_THE_BOARD_OF_DIRECTORS_COMPANY_WITH_ACOMMITTEE_SYSTEMS = new TSE_T_CG_LABEL(
        "ChairmanOfTheBoardOfDirectorsCompanyWithACommitteeSystems", 
        "Chairman of the board of directors", 
        "取締役会の議長");
    public static final TSE_T_CG_LABEL CHAIRMAN_OF_THE_BOARD_OF_DIRECTORS_COMPANY_WITH_ACOMMITTEE_SYSTEMS_CHECK = new TSE_T_CG_LABEL(
        "ChairmanOfTheBoardOfDirectorsCompanyWithACommitteeSystemsCheck", 
        "Chairman of the board of directors", 
        "取締役会の議長");
    public static final TSE_T_CG_LABEL COMES_FROM_OTHER_AFFILIATE_COMPANY_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "ComesFromOtherAffiliateCompanyOutsideCorporateAuditors", 
        "Comes from other affiliate company", 
        "その他の関係会社出身である");
    public static final TSE_T_CG_LABEL COMES_FROM_OTHER_AFFILIATE_COMPANY_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "ComesFromOtherAffiliateCompanyOutsideDirectors", 
        "Comes from other affiliate company", 
        "他の関係会社出身である");
    public static final TSE_T_CG_LABEL COMES_FROM_PARENT_COMPANY_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "ComesFromParentCompanyOutsideCorporateAuditors", 
        "Comes from parent company", 
        "親会社出身である");
    public static final TSE_T_CG_LABEL COMES_FROM_PARENT_COMPANY_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "ComesFromParentCompanyOutsideDirectors", 
        "Comes from parent company", 
        "親会社出身である");
    public static final TSE_T_CG_LABEL COMMITTEE_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_ABSTRACT = new TSE_T_CG_LABEL(
        "CommitteeCompositionAndAttributesOfChairAbstract", 
        "Committee composition and attributes of chair", 
        "各委員会の委員構成及び議長の属性");
    public static final TSE_T_CG_LABEL COMMITTEE_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_CHECK = new TSE_T_CG_LABEL(
        "CommitteeCompositionAndAttributesOfChairCheck", 
        "Committee composition and attributes of chair", 
        "各委員会の委員構成及び議長の属性");
    public static final TSE_T_CG_LABEL COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE_ABSTRACT = new TSE_T_CG_LABEL(
        "CommitteeCorrespondingToCompensationCommitteeAbstract", 
        "Committee corresponding to compensation committee", 
        "報酬委員会に相当する任意の委員会");
    public static final TSE_T_CG_LABEL COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE_ABSTRACT = new TSE_T_CG_LABEL(
        "CommitteeCorrespondingToNominatingCommitteeAbstract", 
        "Committee corresponding to nominating committee", 
        "指名委員会に相当する任意の委員会");
    public static final TSE_T_CG_LABEL COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE_OR_COMPENSATION_COMMITTEE = new TSE_T_CG_LABEL(
        "CommitteeCorrespondingToNominatingCommitteeOrCompensationCommittee", 
        "Committee corresponding to nominating committee or compensation committee", 
        "指名委員会又は報酬委員会に相当する任意の委員会の有無");
    public static final TSE_T_CG_LABEL COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE_OR_COMPENSATION_COMMITTEE_CHECK = new TSE_T_CG_LABEL(
        "CommitteeCorrespondingToNominatingCommitteeOrCompensationCommitteeCheck", 
        "Committee corresponding to nominating committee or compensation committee", 
        "指名委員会又は報酬委員会に相当する任意の委員会の有無");
    public static final TSE_T_CG_LABEL COMMITTEES_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_ABSTRACT = new TSE_T_CG_LABEL(
        "CommitteesCompositionAndAttributesOfChairAbstract", 
        "Committees composition and attributes of chair", 
        "委員構成及び議長の属性");
    public static final TSE_T_CG_LABEL COMMITTEES_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_CHECK = new TSE_T_CG_LABEL(
        "CommitteesCompositionAndAttributesOfChairCheck", 
        "Committees composition and attributes of chair", 
        "委員構成及び議長の属性");
    public static final TSE_T_CG_LABEL COMMITTEES_VOLUNTARILY_ESTABLISHED_ABSTRACT = new TSE_T_CG_LABEL(
        "CommitteesVoluntarilyEstablishedAbstract", 
        "Committees voluntarily established", 
        "任意の委員会");
    public static final TSE_T_CG_LABEL COMPANY_NAME = new TSE_T_CG_LABEL(
        "CompanyName", 
        "Company name", 
        "会社名");
    public static final TSE_T_CG_LABEL COMPANY_NAME_EN = new TSE_T_CG_LABEL(
        "CompanyNameEn", 
        "Company name (English)", 
        "会社名（英訳名）");
    public static final TSE_T_CG_LABEL COMPENSATION_COMMITTEE_ABSTRACT = new TSE_T_CG_LABEL(
        "CompensationCommitteeAbstract", 
        "Compensation committee", 
        "報酬委員会");
    public static final TSE_T_CG_LABEL COMPENSATION_COMMITTEE_MEMBER = new TSE_T_CG_LABEL(
        "CompensationCommitteeMember", 
        "Compensation committee member", 
        "報酬委員");
    public static final TSE_T_CG_LABEL COMPENSATION_COMMITTEE_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "CompensationCommitteeOutsideDirectors", 
        "Compensation committee", 
        "報酬委員会");
    public static final TSE_T_CG_LABEL CONCURRENTLY_HOLDS_OFFICE_AS_OUTSIDE_DIRECTOR_OR_OUTSIDE_CORPORATE_AUDITOR_OF_ANOTHER_COMPANY_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "ConcurrentlyHoldsOfficeAsOutsideDirectorOrOutsideCorporateAuditorOfAnotherCompanyOutsideCorporateAuditors", 
        "Concurrently holds office as outside director or outside corporate auditor of another company", 
        "他の会社の社外取締役又は社外監査役を兼任している");
    public static final TSE_T_CG_LABEL CONCURRENTLY_HOLDS_OFFICE_AS_OUTSIDE_DIRECTOR_OR_OUTSIDE_CORPORATE_AUDITOR_OF_ANOTHER_COMPANY_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "ConcurrentlyHoldsOfficeAsOutsideDirectorOrOutsideCorporateAuditorOfAnotherCompanyOutsideDirectors", 
        "Concurrently holds office as outside director or outside corporate auditor of another company", 
        "他の会社の社外取締役又は社外監査役を兼任している");
    public static final TSE_T_CG_LABEL CONTACT = new TSE_T_CG_LABEL(
        "Contact", 
        "Contact", 
        "問合せ先");
    public static final TSE_T_CG_LABEL CONTROLLING_SHAREHOLDER = new TSE_T_CG_LABEL(
        "ControllingShareholder", 
        "Controlling shareholder", 
        "支配株主名");
    public static final TSE_T_CG_LABEL CONVENE_PERIODIC_BRIEFING_FOR_ANALYSTS_AND_INSTITUTIONAL_INVESTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "ConvenePeriodicBriefingForAnalystsAndInstitutionalInvestorsAbstract", 
        "Convene periodic briefing for analysts and institutional investors", 
        "アナリスト・機関投資家向けに定期的説明会を開催");
    public static final TSE_T_CG_LABEL CONVENE_PERIODIC_BRIEFING_FOR_FOREIGN_INVESTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "ConvenePeriodicBriefingForForeignInvestorsAbstract", 
        "Convene periodic briefing for foreign investors", 
        "海外投資家向けに定期的説明会を開催");
    public static final TSE_T_CG_LABEL CONVENE_PERIODIC_BRIEFING_FOR_INDIVIDUAL_INVESTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "ConvenePeriodicBriefingForIndividualInvestorsAbstract", 
        "Convene periodic briefing for individual investors", 
        "個人投資家向けに定期的説明会を開催");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_AMONG_CORPORATE_AUDITORS_INDEPENDENT_ACCOUNTANTS_AND_INTERNAL_AUDIT_DIVISION = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsAmongCorporateAuditorsIndependentAccountantsAndInternalAuditDivision", 
        "Cooperative relationships among corporate auditors,  independent accountants and internal audit division", 
        "監査役、会計監査人、内部監査部門の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_AMONG_CORPORATE_AUDITORS_INDEPENDENT_ACCOUNTANTS_AND_INTERNAL_AUDIT_DIVISION_CHECK = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsAmongCorporateAuditorsIndependentAccountantsAndInternalAuditDivisionCheck", 
        "Cooperative relationships among corporate auditors,  independent accountants and internal audit division", 
        "監査役、会計監査人、内部監査部門の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_AMONG_THE_AUDIT_COMMITTEE_INDEPENDENT_AUDITORS_AND_INTERNAL_AUDIT_DIVISION = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsAmongTheAuditCommitteeIndependentAuditorsAndInternalAuditDivision", 
        "Cooperative relationships among the audit committee, independent auditors and internal audit division", 
        "監査委員会、会計監査人、内部監査部門の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_AMONG_THE_AUDIT_COMMITTEE_INDEPENDENT_AUDITORS_AND_INTERNAL_AUDIT_DIVISION_CHECK = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsAmongTheAuditCommitteeIndependentAuditorsAndInternalAuditDivisionCheck", 
        "Cooperative relationships among the audit committee, independent auditors and internal audit division", 
        "監査委員会、会計監査人、内部監査部門の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_AMONG_THE_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS_INDEPENDENT_AUDITORS_AND_INTERNAL_AUDIT_DIVISION = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsAmongTheAuditEtcCommitteeOutsideDirectorsIndependentAuditorsAndInternalAuditDivision", 
        "Cooperative relationships among the audit etc. committee, independent auditors and internal audit division", 
        "監査等委員会、会計監査人、内部監査部門の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_AMONG_THE_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS_INDEPENDENT_AUDITORS_AND_INTERNAL_AUDIT_DIVISION_CHECK = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsAmongTheAuditEtcCommitteeOutsideDirectorsIndependentAuditorsAndInternalAuditDivisionCheck", 
        "Cooperative relationships among the audit etc. committee, independent auditors and internal audit division", 
        "監査等委員会、会計監査人、内部監査部門の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_BETWEEN_CORPORATE_AUDITORS_AND_INDEPENDENT_ACCOUNTANTS = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsBetweenCorporateAuditorsAndIndependentAccountants", 
        "Cooperative relationships between corporate auditors and independent accountants", 
        "監査役と会計監査人の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_BETWEEN_CORPORATE_AUDITORS_AND_INDEPENDENT_ACCOUNTANTS_CHECK = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsBetweenCorporateAuditorsAndIndependentAccountantsCheck", 
        "Cooperative relationships between corporate auditors and independent accountants", 
        "監査役と会計監査人の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_BETWEEN_CORPORATE_AUDITORS_AND_INTERNAL_AUDIT_DIVISION = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsBetweenCorporateAuditorsAndInternalAuditDivision", 
        "Cooperative relationships between corporate auditors and internal audit division", 
        "監査役と内部監査部門の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_BETWEEN_CORPORATE_AUDITORS_AND_INTERNAL_AUDIT_DIVISION_CHECK = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsBetweenCorporateAuditorsAndInternalAuditDivisionCheck", 
        "Cooperative relationships between corporate auditors and internal audit division", 
        "監査役と内部監査部門の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_BETWEEN_THE_AUDIT_COMMITTEE_AND_ACCOUNTING_AUDITORS = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsBetweenTheAuditCommitteeAndAccountingAuditors", 
        "Cooperative relationships between the audit committee and accounting auditors", 
        "監査委員会と会計監査人の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_BETWEEN_THE_AUDIT_COMMITTEE_AND_ACCOUNTING_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsBetweenTheAuditCommitteeAndAccountingAuditorsCheck", 
        "Cooperative relationships between the audit committee and accounting auditors", 
        "監査委員会と会計監査人の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_BETWEEN_THE_AUDIT_COMMITTEE_AND_THE_INTERNAL_AUDIT_DIVISION = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsBetweenTheAuditCommitteeAndTheInternalAuditDivision", 
        "Cooperative relationships between the audit committee and the internal audit division", 
        "監査委員会と内部監査部門の連携状況");
    public static final TSE_T_CG_LABEL COOPERATIVE_RELATIONSHIPS_BETWEEN_THE_AUDIT_COMMITTEE_AND_THE_INTERNAL_AUDIT_DIVISION_CHECK = new TSE_T_CG_LABEL(
        "CooperativeRelationshipsBetweenTheAuditCommitteeAndTheInternalAuditDivisionCheck", 
        "Cooperative relationships between the audit committee and the internal audit division", 
        "監査委員会と内部監査部門の連携状況");
    public static final TSE_T_CG_LABEL CORPORATE_GOVERNANCE_REPORT_ABSTRACT = new TSE_T_CG_LABEL(
        "CorporateGovernanceReportAbstract", 
        "Corporate governance report", 
        "コーポレート・ガバナンスに関する報告書");
    public static final TSE_T_CG_LABEL CORPORATE_GOVERNANCE_SYSTEM_OF_MANAGEMENT_BUSINESS_ORGANIZATION_ETC_FOR_MANAGEMENT_DECISION_MAKING_EXECUTION_OF_DUTIES_AND_MANAGEMENT_AUDIT_ABSTRACT = new TSE_T_CG_LABEL(
        "CorporateGovernanceSystemOfManagementBusinessOrganizationEtcForManagementDecisionMakingExecutionOfDutiesAndManagementAuditAbstract", 
        "Corporate governance system of management business organization, etc. for management decision making, execution of duties and management audit", 
        "経営上の意思決定、執行及び監督に係る経営管理組織その他のコーポレート・ガバナンス体制の状況");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_ANALYSTS_AND_INSTITUTIONAL_INVESTORS = new TSE_T_CG_LABEL(
        "CorrespondenceAnalystsAndInstitutionalInvestors", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_CSR = new TSE_T_CG_LABEL(
        "CorrespondenceCSR", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_CONCENTRATED_DAYS = new TSE_T_CG_LABEL(
        "CorrespondenceConcentratedDays", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_DISCLOSURE_OF_INFORMATION = new TSE_T_CG_LABEL(
        "CorrespondenceDisclosureOfInformation", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_ELECTRONIC_EXECUTION = new TSE_T_CG_LABEL(
        "CorrespondenceElectronicExecution", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_FOREIGN_INVESTORS = new TSE_T_CG_LABEL(
        "CorrespondenceForeignInvestors", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_IRDIVISIONS = new TSE_T_CG_LABEL(
        "CorrespondenceIRDivisions", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_INDIVIDUAL_INVESTORS = new TSE_T_CG_LABEL(
        "CorrespondenceIndividualInvestors", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_INTERNAL_REGULATIONS = new TSE_T_CG_LABEL(
        "CorrespondenceInternalRegulations", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_NOT_ACTED_IR = new TSE_T_CG_LABEL(
        "CorrespondenceNotActedIR", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_NOT_ACTED_STAKEHOLDERS = new TSE_T_CG_LABEL(
        "CorrespondenceNotActedStakeholders", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_NOT_IMPLEMENTED_SHAREHOLDERS_MEETING = new TSE_T_CG_LABEL(
        "CorrespondenceNotImplementedShareholdersMeeting", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_OTHER_IR = new TSE_T_CG_LABEL(
        "CorrespondenceOtherIR", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_OTHER_SHAREHOLDERS_MEETING = new TSE_T_CG_LABEL(
        "CorrespondenceOtherShareholdersMeeting", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_OTHER_STAKEHOLDERS = new TSE_T_CG_LABEL(
        "CorrespondenceOtherStakeholders", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_SHAREHOLDERS_MEETING = new TSE_T_CG_LABEL(
        "CorrespondenceShareholdersMeeting", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL CORRESPONDENCE_WEBSITE = new TSE_T_CG_LABEL(
        "CorrespondenceWebsite", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL DATE_WHEN_FORMER_ROLE_AS_PRESIDENT_OR_CEOENDED_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS = new TSE_T_CG_LABEL(
        "DateWhenFormerRoleAsPresidentOrCEOEndedRetiredPresidentsOrCEOsHoldingAdvisoryPositions", 
        "Date when former role as president/CEO ended", 
        "社長等退任日");
    public static final TSE_T_CG_LABEL DESCRIPTION_OF_CONTROLLING_SHAREHOLDERS_AND_PARENT_COMPANY_ABSTRACT = new TSE_T_CG_LABEL(
        "DescriptionOfControllingShareholdersAndParentCompanyAbstract", 
        "Description of controlling shareholders and parent company", 
        "支配株主並びに親会社の状況");
    public static final TSE_T_CG_LABEL DESCRIPTION_OF_MAJOR_SHAREHOLDERS_ABSTRACT = new TSE_T_CG_LABEL(
        "DescriptionOfMajorShareholdersAbstract", 
        "Description of major shareholders", 
        "大株主の状況");
    public static final TSE_T_CG_LABEL DESCRIPTION_OF_MAJOR_SHAREHOLDERS_CHECK = new TSE_T_CG_LABEL(
        "DescriptionOfMajorShareholdersCheck", 
        "Description of major shareholders", 
        "大株主の状況");
    public static final TSE_T_CG_LABEL DIAGRAM_1 = new TSE_T_CG_LABEL(
        "Diagram1", 
        "diagram1", 
        "模式図1");
    public static final TSE_T_CG_LABEL DIAGRAM_2 = new TSE_T_CG_LABEL(
        "Diagram2", 
        "diagram2", 
        "模式図2");
    public static final TSE_T_CG_LABEL DIAGRAM_3 = new TSE_T_CG_LABEL(
        "Diagram3", 
        "diagram3", 
        "模式図3");
    public static final TSE_T_CG_LABEL DIAGRAM_4 = new TSE_T_CG_LABEL(
        "Diagram4", 
        "diagram4", 
        "模式図4");
    public static final TSE_T_CG_LABEL DIAGRAM_5 = new TSE_T_CG_LABEL(
        "Diagram5", 
        "diagram5", 
        "模式図5");
    public static final TSE_T_CG_LABEL DIAGRAM_ABSTRACT = new TSE_T_CG_LABEL(
        "DiagramAbstract", 
        "diagram", 
        "模式図");
    public static final TSE_T_CG_LABEL DIRECTOR_COMPENSATION_DISCLOSURE_STATUS = new TSE_T_CG_LABEL(
        "DirectorCompensationDisclosureStatus", 
        "Director compensation disclosure status", 
        "取締役報酬の開示状況");
    public static final TSE_T_CG_LABEL DIRECTOR_COMPENSATION_DISCLOSURE_STATUS_CHECK = new TSE_T_CG_LABEL(
        "DirectorCompensationDisclosureStatusCheck", 
        "Director compensation disclosure status", 
        "取締役報酬の開示状況");
    public static final TSE_T_CG_LABEL DIRECTOR_EXECUTIVE_OFFICER_COMPENSATION_ABSTRACT = new TSE_T_CG_LABEL(
        "DirectorExecutiveOfficerCompensationAbstract", 
        "Director/executive officer compensation", 
        "取締役・執行役報酬関係");
    public static final TSE_T_CG_LABEL DIRECTOR_SCOMPENSATION_ABSTRACT = new TSE_T_CG_LABEL(
        "DirectorSCompensationAbstract", 
        "Director's compensation", 
        "取締役報酬関係");
    public static final TSE_T_CG_LABEL DIRECTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "DirectorsAbstract", 
        "Directors", 
        "取締役関係");
    public static final TSE_T_CG_LABEL DIRECTORS_AND_EMPLOYEES_RESPONSIBLE_FOR_ASSISTING_IN_EXECUTION_OF_THE_DUTIES_OF_THE_AUDIT_COMMITTEE = new TSE_T_CG_LABEL(
        "DirectorsAndEmployeesResponsibleForAssistingInExecutionOfTheDutiesOfTheAuditCommittee", 
        "Directors and employees responsible for assisting in execution of the duties of the audit committee", 
        "監査委員会の職務を補助すべき取締役及び使用人の有無");
    public static final TSE_T_CG_LABEL DIRECTORS_AND_EMPLOYEES_RESPONSIBLE_FOR_ASSISTING_IN_EXECUTION_OF_THE_DUTIES_OF_THE_AUDIT_COMMITTEE_CHECK = new TSE_T_CG_LABEL(
        "DirectorsAndEmployeesResponsibleForAssistingInExecutionOfTheDutiesOfTheAuditCommitteeCheck", 
        "Directors and employees responsible for assisting in execution of the duties of the audit committee", 
        "監査委員会の職務を補助すべき取締役及び使用人の有無");
    public static final TSE_T_CG_LABEL DIRECTORS_AND_EMPLOYEES_RESPONSIBLE_FOR_ASSISTING_IN_EXECUTION_OF_THE_DUTIES_OF_THE_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "DirectorsAndEmployeesResponsibleForAssistingInExecutionOfTheDutiesOfTheAuditEtcCommitteeOutsideDirectors", 
        "Directors and employees responsible for assisting in execution of the duties of the audit etc. committee", 
        "監査等委員会の職務を補助すべき取締役及び使用人の有無");
    public static final TSE_T_CG_LABEL DIRECTORS_AND_EMPLOYEES_RESPONSIBLE_FOR_ASSISTING_IN_EXECUTION_OF_THE_DUTIES_OF_THE_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "DirectorsAndEmployeesResponsibleForAssistingInExecutionOfTheDutiesOfTheAuditEtcCommitteeOutsideDirectorsCheck", 
        "Directors and employees responsible for assisting in execution of the duties of the audit etc. committee", 
        "監査等委員会の職務を補助すべき取締役及び使用人の有無");
    public static final TSE_T_CG_LABEL DIRECTORS_EXECUTIVE_OFFICERS_AUDITORS_OF_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "DirectorsExecutiveOfficersAuditorsOfParentCompany", 
        "Directors, executive officers, auditors of parent company", 
        "親会社の取締役、執行役、監査役");
    public static final TSE_T_CG_LABEL DIRECTORS_EXECUTIVE_OFFICERS_AUDITORS_OF_SUBSIDIARIES = new TSE_T_CG_LABEL(
        "DirectorsExecutiveOfficersAuditorsOfSubsidiaries", 
        "Directors, executive officers, auditors of subsidiaries", 
        "子会社の取締役、執行役、監査役");
    public static final TSE_T_CG_LABEL DIRECTORS_OF_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "DirectorsOfParentCompany", 
        "Directors of parent company", 
        "親会社の取締役");
    public static final TSE_T_CG_LABEL DIRECTORS_OF_SUBSIDIARIES = new TSE_T_CG_LABEL(
        "DirectorsOfSubsidiaries", 
        "Directors of subsidiaries", 
        "子会社の取締役");
    public static final TSE_T_CG_LABEL DIRECTORS_TERM_OF_OFFICE_STIPULATED_IN_ARTICLES_OF_INCORPORATION = new TSE_T_CG_LABEL(
        "DirectorsTermOfOfficeStipulatedInArticlesOfIncorporation", 
        "Director's term of office stipulated in articles of incorporation", 
        "定款上の取締役の任期");
    public static final TSE_T_CG_LABEL DIRECTORS_TERM_OF_OFFICE_STIPULATED_IN_ARTICLES_OF_INCORPORATION_CHECK = new TSE_T_CG_LABEL(
        "DirectorsTermOfOfficeStipulatedInArticlesOfIncorporationCheck", 
        "Director's term of office stipulated in articles of incorporation", 
        "定款上の取締役の任期");
    public static final TSE_T_CG_LABEL DISCLOSURE_OF_DIRECTORS_COMPENSATION = new TSE_T_CG_LABEL(
        "DisclosureOfDirectorsCompensation", 
        "Disclosure of directors' compensation", 
        "（個別の取締役報酬の）開示状況");
    public static final TSE_T_CG_LABEL DISCLOSURE_OF_DIRECTORS_COMPENSATION_CHECK = new TSE_T_CG_LABEL(
        "DisclosureOfDirectorsCompensationCheck", 
        "Disclosure of directors' compensation", 
        "（個別の取締役報酬の）開示状況");
    public static final TSE_T_CG_LABEL DISCLOSURE_OF_EXECUTIVE_OFFICERS_COMPENSATION = new TSE_T_CG_LABEL(
        "DisclosureOfExecutiveOfficersCompensation", 
        "Disclosure of executive officers' compensation", 
        "（個別の執行役報酬の）開示状況");
    public static final TSE_T_CG_LABEL DISCLOSURE_OF_EXECUTIVE_OFFICERS_COMPENSATION_CHECK = new TSE_T_CG_LABEL(
        "DisclosureOfExecutiveOfficersCompensationCheck", 
        "Disclosure of executive officers' compensation", 
        "（個別の執行役報酬の）開示状況");
    public static final TSE_T_CG_LABEL DISCLOSURE_OF_IRDOCUMENTS_ON_THE_WEBSITE_ABSTRACT = new TSE_T_CG_LABEL(
        "DisclosureOfIRDocumentsOnTheWebsiteAbstract", 
        "Disclosure of IR documents on the website", 
        "IR資料のホームページ掲載");
    public static final TSE_T_CG_LABEL DISCLOSURE_OF_METHODS_TO_DETERMINE_COMPENSATION_OR_COMPENSATION_POLICIES = new TSE_T_CG_LABEL(
        "DisclosureOfMethodsToDetermineCompensationOrCompensationPolicies", 
        "Disclosure of methods to determine compensation or compensation policies", 
        "報酬の額又はその算定方法の決定方針の開示内容");
    public static final TSE_T_CG_LABEL DISCLOSURE_OF_METHODS_TO_DETERMINE_COMPENSATION_OR_COMPENSATION_POLICIES_CHECK = new TSE_T_CG_LABEL(
        "DisclosureOfMethodsToDetermineCompensationOrCompensationPoliciesCheck", 
        "Disclosure of methods to determine compensation or compensation policies", 
        "報酬の額又はその算定方法の決定方針の開示内容");
    public static final TSE_T_CG_LABEL DISCLOSURE_STATUS = new TSE_T_CG_LABEL(
        "DisclosureStatus", 
        "Disclosure status", 
        "開示状況");
    public static final TSE_T_CG_LABEL DISCLOSURE_STATUS_CHECK = new TSE_T_CG_LABEL(
        "DisclosureStatusCheck", 
        "Disclosure status", 
        "開示状況");
    public static final TSE_T_CG_LABEL DISCLOSURES_REQUIRED_BY_THE_PRINCIPLES_OF_THE_CORPORATE_GOVERNANCE_CODE = new TSE_T_CG_LABEL(
        "DisclosuresRequiredByThePrinciplesOfTheCorporateGovernanceCode", 
        "Disclosures required by the principles of the Corporate Governance Code", 
        "コーポレートガバナンス・コードの各原則に基づく開示");
    public static final TSE_T_CG_LABEL DISCLOSURES_REQUIRED_BY_THE_PRINCIPLES_OF_THE_CORPORATE_GOVERNANCE_CODE_CHECK = new TSE_T_CG_LABEL(
        "DisclosuresRequiredByThePrinciplesOfTheCorporateGovernanceCodeCheck", 
        "Disclosures required by the principles of the Corporate Governance Code", 
        "コーポレートガバナンス・コードの各原則に基づく開示");
    public static final TSE_T_CG_LABEL EARLY_DISPATCH_OF_NOTICE_OF_SHAREHOLDERS_MEETING_ABSTRACT = new TSE_T_CG_LABEL(
        "EarlyDispatchOfNoticeOfShareholdersMeetingAbstract", 
        "Early dispatch of notice of shareholders' meeting", 
        "株主総会招集通知の早期発送");
    public static final TSE_T_CG_LABEL EARNINGS_DIGEST = new TSE_T_CG_LABEL(
        "EarningsDigest", 
        "Earnings Digest", 
        "決算短信");
    public static final TSE_T_CG_LABEL ELECTION_OF_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "ElectionOfOutsideDirectors", 
        "Election of outside directors", 
        "社外取締役の選任状況");
    public static final TSE_T_CG_LABEL ELECTION_OF_OUTSIDE_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "ElectionOfOutsideDirectorsCheck", 
        "Election of outside directors", 
        "社外取締役の選任状況");
    public static final TSE_T_CG_LABEL ELECTION_OR_NON_ELECTION_OF_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "ElectionOrNonElectionOfOutsideCorporateAuditors", 
        "Election or non-election of outside corporate auditors", 
        "社外監査役の選任状況");
    public static final TSE_T_CG_LABEL ELECTION_OR_NON_ELECTION_OF_OUTSIDE_CORPORATE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "ElectionOrNonElectionOfOutsideCorporateAuditorsCheck", 
        "Election or non-election of outside corporate auditors", 
        "社外監査役の選任状況");
    public static final TSE_T_CG_LABEL ELECTRONIC_EXECUTION_OF_VOTING_RIGHTS_ABSTRACT = new TSE_T_CG_LABEL(
        "ElectronicExecutionOfVotingRightsAbstract", 
        "Electronic execution of voting rights", 
        "電磁的方法による議決権の行使");
    public static final TSE_T_CG_LABEL EMPLOYEES = new TSE_T_CG_LABEL(
        "Employees", 
        "Employees", 
        "従業員");
    public static final TSE_T_CG_LABEL EMPLOYEES_OF_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "EmployeesOfParentCompany", 
        "Employees of parent company", 
        "親会社の従業員");
    public static final TSE_T_CG_LABEL EMPLOYEES_OF_SUBSIDIARIES = new TSE_T_CG_LABEL(
        "EmployeesOfSubsidiaries", 
        "Employees of subsidiaries", 
        "子会社の従業員");
    public static final TSE_T_CG_LABEL EMPLOYMENT_TERMS_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS = new TSE_T_CG_LABEL(
        "EmploymentTermsRetiredPresidentsOrCEOsHoldingAdvisoryPositions", 
        "Employment terms (Full/part time, with/without compensation, etc.)", 
        "勤務形態・条件 （常勤・非常勤、報酬有無等）");
    public static final TSE_T_CG_LABEL ESTABLISHMENT_OF_POLICY_CONCERNING_DISCLOSURE_OF_INFORMATION_TO_STAKEHOLDERS_ABSTRACT = new TSE_T_CG_LABEL(
        "EstablishmentOfPolicyConcerningDisclosureOfInformationToStakeholdersAbstract", 
        "Establishment of policy concerning disclosure of information to stakeholders", 
        "ステークホルダーに対する情報提供に係る方針等の策定");
    public static final TSE_T_CG_LABEL ESTABLISHMENT_OR_NON_ESTABLISHMENT_OF_ABOARD_OF_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "EstablishmentOrNonEstablishmentOfABoardOfCorporateAuditors", 
        "Establishment or non-establishment of a board of corporate auditors", 
        "監査役会の設置の有無");
    public static final TSE_T_CG_LABEL ESTABLISHMENT_OR_NONESTABLISHMENT_OF_ABOARD_OF_CORPORATE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "EstablishmentOrNonestablishmentOfABoardOfCorporateAuditorsCheck", 
        "Establishment or non-establishment of a board of corporate auditors", 
        "監査役会の設置の有無");
    public static final TSE_T_CG_LABEL EXECUTIVE_OFFICER_COMPENSATION_DISCLOSURE_STATUS = new TSE_T_CG_LABEL(
        "ExecutiveOfficerCompensationDisclosureStatus", 
        "Executive officer compensation disclosure status", 
        "執行役報酬の開示状況");
    public static final TSE_T_CG_LABEL EXECUTIVE_OFFICER_COMPENSATION_DISCLOSURE_STATUS_CHECK = new TSE_T_CG_LABEL(
        "ExecutiveOfficerCompensationDisclosureStatusCheck", 
        "Executive officer compensation disclosure status", 
        "執行役報酬の開示状況");
    public static final TSE_T_CG_LABEL EXECUTIVE_OFFICERS = new TSE_T_CG_LABEL(
        "ExecutiveOfficers", 
        "Executive officers", 
        "執行役");
    public static final TSE_T_CG_LABEL EXECUTIVE_OFFICERS_ABSTRACT = new TSE_T_CG_LABEL(
        "ExecutiveOfficersAbstract", 
        "Executive officers", 
        "執行役関係");
    public static final TSE_T_CG_LABEL EXECUTIVE_OFFICERS_OF_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "ExecutiveOfficersOfParentCompany", 
        "Executive officers of parent company", 
        "親会社の執行役");
    public static final TSE_T_CG_LABEL EXECUTIVE_OFFICERS_OF_SUBSIDIARIES = new TSE_T_CG_LABEL(
        "ExecutiveOfficersOfSubsidiaries", 
        "Executive officers of subsidiaries", 
        "子会社の執行役");
    public static final TSE_T_CG_LABEL EXISTANCE_OF_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "ExistanceOfParentCompany", 
        "Existance of parent company", 
        "親会社の有無");
    public static final TSE_T_CG_LABEL EXISTANCE_OF_PARENT_COMPANY_CHECK = new TSE_T_CG_LABEL(
        "ExistanceOfParentCompanyCheck", 
        "Existance of parent company", 
        "親会社の有無");
    public static final TSE_T_CG_LABEL EXISTENCE_OF_ACONTROLLING_SHAREHOLDERS = new TSE_T_CG_LABEL(
        "ExistenceOfAControllingShareholders", 
        "Existence of a controlling shareholder(s)", 
        "支配株主（親会社を除く）の有無");
    public static final TSE_T_CG_LABEL EXISTENCE_OF_ACONTROLLING_SHAREHOLDERS_CHECK = new TSE_T_CG_LABEL(
        "ExistenceOfAControllingShareholdersCheck", 
        "Existence of a controlling shareholder(s)", 
        "支配株主（親会社を除く）の有無");
    public static final TSE_T_CG_LABEL EXISTENCE_OF_COMMITTEES_VOLUNTARILY_ESTABLISHED_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_ABSTRACT = new TSE_T_CG_LABEL(
        "ExistenceOfCommitteesVoluntarilyEstablishedCompositionAndAttributesOfChairAbstract", 
        "Existence of committees voluntarily established, composition and attributes of chair", 
        "任意の委員会の設置状況、委員構成、委員長（議長）の属性");
    public static final TSE_T_CG_LABEL EXISTENCE_OF_COMMITTEES_VOLUNTARILY_ESTABLISHED_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_CHECK = new TSE_T_CG_LABEL(
        "ExistenceOfCommitteesVoluntarilyEstablishedCompositionAndAttributesOfChairCheck", 
        "Existence of committees voluntarily established, composition and attributes of chair", 
        "任意の委員会の設置状況、委員構成、委員長（議長）の属性");
    public static final TSE_T_CG_LABEL EXISTENCE_OF_METHODS_TO_DETERMINE_COMPENSATION_OR_COMPENSATION_POLICIES = new TSE_T_CG_LABEL(
        "ExistenceOfMethodsToDetermineCompensationOrCompensationPolicies", 
        "Existence of methods to determine compensation or compensation policies", 
        "報酬の額又はその算定方法の決定方針の有無");
    public static final TSE_T_CG_LABEL EXISTENCE_OF_METHODS_TO_DETERMINE_COMPENSATION_OR_COMPENSATION_POLICIES_CHECK = new TSE_T_CG_LABEL(
        "ExistenceOfMethodsToDetermineCompensationOrCompensationPoliciesCheck", 
        "Existence of methods to determine compensation or compensation policies", 
        "報酬の額又はその算定方法の決定方針の有無");
    public static final TSE_T_CG_LABEL EXPLANATION_BY_REPRESENTATIVE_MEMBERS_OF_THE_BOARD_ANALYSTS_AND_INSTITUTIONAL_INVESTORS = new TSE_T_CG_LABEL(
        "ExplanationByRepresentativeMembersOfTheBoardAnalystsAndInstitutionalInvestors", 
        "Explanation by representative members of the board", 
        "代表者自身による説明の有無");
    public static final TSE_T_CG_LABEL EXPLANATION_BY_REPRESENTATIVE_MEMBERS_OF_THE_BOARD_FOREIGN_INVESTORS = new TSE_T_CG_LABEL(
        "ExplanationByRepresentativeMembersOfTheBoardForeignInvestors", 
        "Explanation by representative members of the board", 
        "代表者自身による説明の有無");
    public static final TSE_T_CG_LABEL EXPLANATION_BY_REPRESENTATIVE_MEMBERS_OF_THE_BOARD_INDIVIDUAL_INVESTORS = new TSE_T_CG_LABEL(
        "ExplanationByRepresentativeMembersOfTheBoardIndividualInvestors", 
        "Explanation by representative members of the board", 
        "代表者自身による説明の有無");
    public static final TSE_T_CG_LABEL EXPLANATION_BY_REPRESENTATIVE_MEMBERS_OF_THE_BOARD_WEBSITE = new TSE_T_CG_LABEL(
        "ExplanationByRepresentativeMembersOfTheBoardWebsite", 
        "Explanation by representative members of the board", 
        "代表者自身による説明の有無");
    public static final TSE_T_CG_LABEL FINAL_UPDATE = new TSE_T_CG_LABEL(
        "FinalUpdate", 
        "Final update", 
        "最終更新日");
    public static final TSE_T_CG_LABEL FISCAL_YEAR_END = new TSE_T_CG_LABEL(
        "FiscalYearEnd", 
        "Fiscal year end", 
        "決算期");
    public static final TSE_T_CG_LABEL FISCAL_YEAR_END_CHECK = new TSE_T_CG_LABEL(
        "FiscalYearEndCheck", 
        "Fiscal year end", 
        "決算期");
    public static final TSE_T_CG_LABEL FUKUOKA = new TSE_T_CG_LABEL(
        "Fukuoka", 
        "Fukuoka", 
        "福岡 既存市場");
    public static final TSE_T_CG_LABEL FUKUOKA_QBOARD = new TSE_T_CG_LABEL(
        "FukuokaQBoard", 
        "Fukuoka Q-Board", 
        "福岡 Q-Board");
    public static final TSE_T_CG_LABEL FUKUOKA_STOCK_EXCHANGE_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "FukuokaStockExchangeParentCompany", 
        "Fukuoka", 
        "福岡");
    public static final TSE_T_CG_LABEL FUKUOKA_TO_BE_LISTED = new TSE_T_CG_LABEL(
        "FukuokaToBeListed", 
        "Fukuoka  (to be listed)", 
        "福岡 （未定）");
    public static final TSE_T_CG_LABEL GRANTEES_OF_STOCK_OPTIONS_ABSTRACT = new TSE_T_CG_LABEL(
        "GranteesOfStockOptionsAbstract", 
        "Grantees of stock options", 
        "ストックオプションの付与対象者");
    public static final TSE_T_CG_LABEL GRANTEES_OF_STOCK_OPTIONS_CHECK = new TSE_T_CG_LABEL(
        "GranteesOfStockOptionsCheck", 
        "Grantees of stock options", 
        "ストックオプションの付与対象者");
    public static final TSE_T_CG_LABEL GUIDELINES_RELATED_TO_PROTECTION_OF_NONCONTROLLING_SHAREHOLDERS_AT_TRADING_WITH_CONTROLLING_SHAREHOLDERS = new TSE_T_CG_LABEL(
        "GuidelinesRelatedToProtectionOfNoncontrollingShareholdersAtTradingWithControllingShareholders", 
        "Guidelines related to protection of noncontrolling shareholders at trading with controlling shareholders", 
        "支配株主との取引等を行う際における少数株主の保護の方策に関する指針");
    public static final TSE_T_CG_LABEL GUIDELINES_RELATED_TO_PROTECTION_OF_NONCONTROLLING_SHAREHOLDERS_AT_TRADING_WITH_CONTROLLING_SHAREHOLDERS_CHECK = new TSE_T_CG_LABEL(
        "GuidelinesRelatedToProtectionOfNoncontrollingShareholdersAtTradingWithControllingShareholdersCheck", 
        "Guidelines related to protection of noncontrolling shareholders at trading with controlling shareholders", 
        "支配株主との取引等を行う際における少数株主の保護の方策に関する指針");
    public static final TSE_T_CG_LABEL HOLDS_OFFICE_AS_MANAGEMENT_DIRECTOR_OR_EXECUTIVE_OFFICER_ETC_OF_ANOTHER_COMPANY_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "HoldsOfficeAsManagementDirectorOrExecutiveOfficerEtcOfAnotherCompanyOutsideCorporateAuditors", 
        "Holds office as management director or executive officer, etc. of another company", 
        "他の会社の業務執行取締役、執行役等である");
    public static final TSE_T_CG_LABEL HOLDS_OFFICE_AS_MANAGEMENT_DIRECTOR_OR_EXECUTIVE_OFFICER_ETC_OF_ANOTHER_COMPANY_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "HoldsOfficeAsManagementDirectorOrExecutiveOfficerEtcOfAnotherCompanyOutsideDirectors", 
        "Holds office as management director or executive officer, etc. of another company", 
        "他の会社の業務執行取締役、執行役等である");
    public static final TSE_T_CG_LABEL IRACTIVITIES_ABSTRACT = new TSE_T_CG_LABEL(
        "IRActivitiesAbstract", 
        "IR activities", 
        "ＩＲに関する活動状況");
    public static final TSE_T_CG_LABEL IRACTIVITIES_CHECK = new TSE_T_CG_LABEL(
        "IRActivitiesCheck", 
        "IR activities", 
        "ＩＲに関する活動状況");
    public static final TSE_T_CG_LABEL IRRELATED_DIVISIONS_PERSONNEL_ABSTRACT = new TSE_T_CG_LABEL(
        "IRRelatedDivisionsPersonnelAbstract", 
        "IR related divisions (personnel)", 
        "IRに関する部署（担当者）の設置");
    public static final TSE_T_CG_LABEL IMPLEMENTATION_OF_MEASURES_FOR_SHAREHOLDERS_AND_OTHER_STAKEHOLDERS_ABSTRACT = new TSE_T_CG_LABEL(
        "ImplementationOfMeasuresForShareholdersAndOtherStakeholdersAbstract", 
        "Implementation of measures for shareholders and other stakeholders", 
        "株主その他の利害関係者に関する施策の実施状況");
    public static final TSE_T_CG_LABEL IMPLEMENTATION_OF_MEASURES_ON_INCENTIVE_ALLOTMENT_TO_DIRECTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "ImplementationOfMeasuresOnIncentiveAllotmentToDirectorsAbstract", 
        "Implementation of measures on incentive allotment to directors", 
        "取締役へのインセンティブ付与に関する施策の実施状況");
    public static final TSE_T_CG_LABEL IMPLEMENTATION_OF_MEASURES_ON_INCENTIVE_ALLOTMENT_TO_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "ImplementationOfMeasuresOnIncentiveAllotmentToDirectorsCheck", 
        "Implementation of measures on incentive allotment to directors", 
        "取締役へのインセンティブ付与に関する施策の実施状況");
    public static final TSE_T_CG_LABEL INCENTIVES_ABSTRACT = new TSE_T_CG_LABEL(
        "IncentivesAbstract", 
        "Incentives", 
        "インセンティブ関係");
    public static final TSE_T_CG_LABEL INDEPENDENCE_OF_SAID_DIRECTORS_AND_EMPLOYEES_FROM_EXECUTIVE_OFFICERS = new TSE_T_CG_LABEL(
        "IndependenceOfSaidDirectorsAndEmployeesFromExecutiveOfficers", 
        "Independence of said directors and employees from executive officers", 
        "当該取締役及び使用人の執行役からの独立性に関する事項");
    public static final TSE_T_CG_LABEL INDEPENDENT_DIRECTORS_AUDITORS_ABSTRACT = new TSE_T_CG_LABEL(
        "IndependentDirectorsAuditorsAbstract", 
        "independent directors / auditors", 
        "独立役員関係");
    public static final TSE_T_CG_LABEL INDEPENDENT_DIRECTORS_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "IndependentDirectorsAuditorsCheck", 
        "Independent directors / auditors", 
        "独立役員");
    public static final TSE_T_CG_LABEL INDEPENDENT_DIRECTORS_AUDITORS_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "IndependentDirectorsAuditorsOutsideCorporateAuditors", 
        "Independent directors / auditors", 
        "独立役員");
    public static final TSE_T_CG_LABEL INDEPENDENT_DIRECTORS_AUDITORS_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "IndependentDirectorsAuditorsOutsideDirectors", 
        "Independent directors / auditors", 
        "独立役員");
    public static final TSE_T_CG_LABEL INDIVIDUAL_COMMITTEES_ABSTRACT = new TSE_T_CG_LABEL(
        "IndividualCommitteesAbstract", 
        "Individual committees", 
        "各種委員会");
    public static final TSE_T_CG_LABEL INFORMATION_ON_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_ABSTRACT = new TSE_T_CG_LABEL(
        "InformationOnRetiredPresidentsOrCEOsHoldingAdvisoryPositionsAbstract", 
        "Information on retired presidents/CEOs holding advisory positions (sodanyaku, komon, etc.)", 
        "元代表取締役社長等である相談役・顧問等の氏名等");
    public static final TSE_T_CG_LABEL INFORMATION_ON_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_CHECK = new TSE_T_CG_LABEL(
        "InformationOnRetiredPresidentsOrCEOsHoldingAdvisoryPositionsCheck", 
        "Information on retired presidents/CEOs holding advisory positions (sodanyaku, komon, etc.)", 
        "元代表取締役社長等である相談役・顧問等の氏名等");
    public static final TSE_T_CG_LABEL INFORMATION_ON_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_INCLUDED_OR_OMITTED = new TSE_T_CG_LABEL(
        "InformationOnRetiredPresidentsOrCEOsHoldingAdvisoryPositionsIncludedOrOmitted", 
        "Information on retired presidents/CEOs holding advisory positions (sodanyaku, komon, etc.)", 
        "代表取締役社長等を退任した者の状況の記載の有無");
    public static final TSE_T_CG_LABEL INSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "InsideDirectors", 
        "Inside directors", 
        "社内取締役");
    public static final TSE_T_CG_LABEL INTERNAL_AUDITORS = new TSE_T_CG_LABEL(
        "InternalAuditors", 
        "Internal auditors", 
        "社内監査役");
    public static final TSE_T_CG_LABEL INTRODUCING_TAKEOVER_DEFENSE_MEASURES = new TSE_T_CG_LABEL(
        "IntroducingTakeoverDefenseMeasures", 
        "Introducing takeover defense measures", 
        "買収防衛策の導入の有無");
    public static final TSE_T_CG_LABEL INTRODUCING_TAKEOVER_DEFENSE_MEASURES_ABSTRACT = new TSE_T_CG_LABEL(
        "IntroducingTakeoverDefenseMeasuresAbstract", 
        "Introducing takeover defense measures", 
        "買収防衛策の導入の有無");
    public static final TSE_T_CG_LABEL INTRODUCING_TAKEOVER_DEFENSE_MEASURES_CHECK = new TSE_T_CG_LABEL(
        "IntroducingTakeoverDefenseMeasuresCheck", 
        "Introducing takeover defense measures", 
        "買収防衛策の導入の有無");
    public static final TSE_T_CG_LABEL JASDAQ = new TSE_T_CG_LABEL(
        "JASDAQ", 
        "JASDAQ", 
        "ジャスダック 既存市場");
    public static final TSE_T_CG_LABEL JASDAQNEO = new TSE_T_CG_LABEL(
        "JASDAQNEO", 
        "JASDAQ NEO", 
        "ジャスダック NEO");
    public static final TSE_T_CG_LABEL JASDAQSTOCK_EXCHANGE_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "JASDAQStockExchangeParentCompany", 
        "JASDAQ", 
        "ジャスダック");
    public static final TSE_T_CG_LABEL JASDAQTO_BE_LISTED = new TSE_T_CG_LABEL(
        "JASDAQToBeListed", 
        "JASDAQ  (to be listed)", 
        "ジャスダック （未定）");
    public static final TSE_T_CG_LABEL JAPAN_SECURITIES_DEALERS_ASSOCIATION = new TSE_T_CG_LABEL(
        "JapanSecuritiesDealersAssociation", 
        "Japan Securities Dealers Association", 
        "グリーンシート等");
    public static final TSE_T_CG_LABEL JAPAN_SECURITIES_DEALERS_ASSOCIATION_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "JapanSecuritiesDealersAssociationParentCompany", 
        "Japan Securities Dealers Association", 
        "グリーンシート等");
    public static final TSE_T_CG_LABEL JOB_TITLE_OR_POSITION_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS = new TSE_T_CG_LABEL(
        "JobTitleOrPositionRetiredPresidentsOrCEOsHoldingAdvisoryPositions", 
        "Job title/position", 
        "役職・地位");
    public static final TSE_T_CG_LABEL LIMITATION_OF_LIABILITY_AGREEMENT_IS_EXECUTED_BETWEEN_THE_SAID_PERSON_AND_THE_COMPANY_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "LimitationOfLiabilityAgreementIsExecutedBetweenTheSaidPersonAndTheCompanyOutsideCorporateAuditors", 
        "Limitation of liability agreement is executed between the said person and the company", 
        "本人と当該会社との間で責任限定契約を締結している");
    public static final TSE_T_CG_LABEL LIMITATION_OF_LIABILITY_AGREEMENT_IS_EXECUTED_BETWEEN_THE_SAID_PERSON_AND_THE_COMPANY_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "LimitationOfLiabilityAgreementIsExecutedBetweenTheSaidPersonAndTheCompanyOutsideDirectors", 
        "Limitation of liability agreement is executed between the said person and the company", 
        "本人と当該会社との間で責任限定契約を締結している");
    public static final TSE_T_CG_LABEL MAJOR_SHAREHOLDER_OF_THE_COMPANY_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "MajorShareholderOfTheCompanyOutsideCorporateAuditors", 
        "Major shareholder of the company", 
        "当該会社の大株主である");
    public static final TSE_T_CG_LABEL MAJOR_SHAREHOLDER_OF_THE_COMPANY_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "MajorShareholderOfTheCompanyOutsideDirectors", 
        "Major shareholder of the company", 
        "当該会社の大株主である");
    public static final TSE_T_CG_LABEL MATTERS_PERTAINING_TO_FUNCTIONS_RELATING_TO_THE_EXECUTION_OF_DUTIES_AUDIT_AND_SUPERVISION_APPOINTMENT_AND_DECISIONS_REGARDING_COMPENSATION_ETC = new TSE_T_CG_LABEL(
        "MattersPertainingToFunctionsRelatingToTheExecutionOfDutiesAuditAndSupervisionAppointmentAndDecisionsRegardingCompensationEtc", 
        "Matters pertaining to functions relating to the execution of duties, audit and supervision, appointment and decisions regarding compensation, etc (overview of the current corporate governance system)", 
        "業務執行、監査・監督、指名、報酬決定等の機能に係る事項（現状のコーポレート・ガバナンス体制の概要）");
    public static final TSE_T_CG_LABEL MATTERS_PERTAINING_TO_FUNCTIONS_RELATING_TO_THE_EXECUTION_OF_DUTIES_AUDIT_AND_SUPERVISION_APPOINTMENT_AND_DECISIONS_REGARDING_COMPENSATION_ETC_CHECK = new TSE_T_CG_LABEL(
        "MattersPertainingToFunctionsRelatingToTheExecutionOfDutiesAuditAndSupervisionAppointmentAndDecisionsRegardingCompensationEtcCheck", 
        "Matters pertaining to functions relating to the execution of duties, audit and supervision, appointment and decisions regarding compensation, etc (overview of the current corporate governance system)", 
        "業務執行、監査・監督、指名、報酬決定等の機能に係る事項（現状のコーポレート・ガバナンス体制の概要）");
    public static final TSE_T_CG_LABEL MATTERS_REGARDING_DEFENSE_AGAINST_ATAKEOVER_BID = new TSE_T_CG_LABEL(
        "MattersRegardingDefenseAgainstATakeoverBid", 
        "Supplementary information", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL MATTERS_REGARDING_DEFENSE_AGAINST_ATAKEOVER_BID_CHECK = new TSE_T_CG_LABEL(
        "MattersRegardingDefenseAgainstATakeoverBidCheck", 
        "Matters regarding defense against a takeover bid", 
        "買収防衛に関する事項");
    public static final TSE_T_CG_LABEL MATTERS_REGARDING_INTERNAL_CONTROL_SYSTEM_ABSTRACT = new TSE_T_CG_LABEL(
        "MattersRegardingInternalControlSystemAbstract", 
        "Matters regarding internal control system", 
        "内部統制システム等に関する事項");
    public static final TSE_T_CG_LABEL MATTERS_REGARDING_OTHER_CORPORATE_GOVERNANCE_SYSTEMS_ETC = new TSE_T_CG_LABEL(
        "MattersRegardingOtherCorporateGovernanceSystemsEtc", 
        "Matters regarding other corporate governance systems, etc", 
        "その他コーポレート・ガバナンス体制等に関する事項");
    public static final TSE_T_CG_LABEL MATTERS_REGARDING_OTHER_CORPORATE_GOVERNANCE_SYSTEMS_ETC_CHECK = new TSE_T_CG_LABEL(
        "MattersRegardingOtherCorporateGovernanceSystemsEtcCheck", 
        "Matters regarding other corporate governance systems, etc", 
        "その他コーポレート・ガバナンス体制等に関する事項");
    public static final TSE_T_CG_LABEL MATTERS_RELATING_TO_OTHER_MAJOR_ACTIVITIES_OF_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "MattersRelatingToOtherMajorActivitiesOfOutsideCorporateAuditors", 
        "Matters relating to other major activities of outside corporate auditors", 
        "その他社外監査役の主な活動に関する事項");
    public static final TSE_T_CG_LABEL MATTERS_RELATING_TO_OTHER_MAJOR_ACTIVITIES_OF_OUTSIDE_CORPORATE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "MattersRelatingToOtherMajorActivitiesOfOutsideCorporateAuditorsCheck", 
        "Matters relating to other major activities of outside corporate auditors", 
        "その他社外監査役の主な活動に関する事項");
    public static final TSE_T_CG_LABEL MATTERS_RELATING_TO_OTHER_MAJOR_ACTIVITIES_OF_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "MattersRelatingToOtherMajorActivitiesOfOutsideDirectors", 
        "Matters relating to other major activities of outside directors", 
        "その他社外取締役の主な活動に関する事項");
    public static final TSE_T_CG_LABEL MATTERS_RELATING_TO_OTHER_MAJOR_ACTIVITIES_OF_OUTSIDE_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "MattersRelatingToOtherMajorActivitiesOfOutsideDirectorsCheck", 
        "Matters relating to other major activities of outside directors", 
        "その他社外取締役の主な活動に関する事項");
    public static final TSE_T_CG_LABEL MEANS_OF_DISCLOSURE_ABSTRACT = new TSE_T_CG_LABEL(
        "MeansOfDisclosureAbstract", 
        "Means of disclosure", 
        "開示手段");
    public static final TSE_T_CG_LABEL MEANS_OF_DISCLOSURE_CHECK = new TSE_T_CG_LABEL(
        "MeansOfDisclosureCheck", 
        "Means of disclosure", 
        "開示手段");
    public static final TSE_T_CG_LABEL MEMBERSHIP_OF_COMMITTEES_OUTSIDE_DIRECTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "MembershipOfCommitteesOutsideDirectorsAbstract", 
        "Membership of committees", 
        "所属委員会");
    public static final TSE_T_CG_LABEL NAGOYA_1ST_SECTION = new TSE_T_CG_LABEL(
        "Nagoya1stSection", 
        "Nagoya 1st section", 
        "名古屋 第一部");
    public static final TSE_T_CG_LABEL NAGOYA_2ND_SECTION = new TSE_T_CG_LABEL(
        "Nagoya2ndSection", 
        "Nagoya 2nd section", 
        "名古屋 第二部");
    public static final TSE_T_CG_LABEL NAGOYA_CENTREX = new TSE_T_CG_LABEL(
        "NagoyaCentrex", 
        "Nagoya Centrex", 
        "名古屋 セントレックス");
    public static final TSE_T_CG_LABEL NAGOYA_STOCK_EXCHANGE_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "NagoyaStockExchangeParentCompany", 
        "Nagoya", 
        "名古屋");
    public static final TSE_T_CG_LABEL NAGOYA_TO_BE_LISTED = new TSE_T_CG_LABEL(
        "NagoyaToBeListed", 
        "Nagoya  (to be listed)", 
        "名古屋 （未定）");
    public static final TSE_T_CG_LABEL NAME_EXECUTIVE_OFFICERS = new TSE_T_CG_LABEL(
        "NameExecutiveOfficers", 
        "Name", 
        "氏名");
    public static final TSE_T_CG_LABEL NAME_OF_COMMITTEE_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE = new TSE_T_CG_LABEL(
        "NameOfCommitteeCommitteeCorrespondingToCompensationCommittee", 
        "Name of committee", 
        "委員会の名称");
    public static final TSE_T_CG_LABEL NAME_OF_COMMITTEE_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE = new TSE_T_CG_LABEL(
        "NameOfCommitteeCommitteeCorrespondingToNominatingCommittee", 
        "Name of committee", 
        "委員会の名称");
    public static final TSE_T_CG_LABEL NAME_OF_SHAREHOLDERS = new TSE_T_CG_LABEL(
        "NameOfShareholders", 
        "Name of shareholders", 
        "氏名又は名称");
    public static final TSE_T_CG_LABEL NAME_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "NameOutsideCorporateAuditors", 
        "Name", 
        "氏名");
    public static final TSE_T_CG_LABEL NAME_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "NameOutsideDirectors", 
        "Name", 
        "氏名");
    public static final TSE_T_CG_LABEL NAME_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS = new TSE_T_CG_LABEL(
        "NameRetiredPresidentsOrCEOsHoldingAdvisoryPositions", 
        "Name", 
        "氏名");
    public static final TSE_T_CG_LABEL NET_SALES_CONSOLIDATED = new TSE_T_CG_LABEL(
        "NetSalesConsolidated", 
        "Net sales (consolidated)", 
        "直前事業年度における（連結）売上高");
    public static final TSE_T_CG_LABEL NET_SALES_CONSOLIDATED_CHECK = new TSE_T_CG_LABEL(
        "NetSalesConsolidatedCheck", 
        "Net sales (consolidated)", 
        "直前事業年度における（連結）売上高");
    public static final TSE_T_CG_LABEL NOMINATION_COMMITTEE_ABSTRACT = new TSE_T_CG_LABEL(
        "NominationCommitteeAbstract", 
        "Nomination committee", 
        "指名委員会");
    public static final TSE_T_CG_LABEL NOMINATION_COMMITTEE_MEMBER = new TSE_T_CG_LABEL(
        "NominationCommitteeMember", 
        "Nomination committee member", 
        "指名委員");
    public static final TSE_T_CG_LABEL NOMINATION_COMMITTEE_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "NominationCommitteeOutsideDirectors", 
        "Nomination committee", 
        "指名委員会");
    public static final TSE_T_CG_LABEL NOT_ACTED_IRABSTRACT = new TSE_T_CG_LABEL(
        "NotActedIRAbstract", 
        "Not acted", 
        "実施していません");
    public static final TSE_T_CG_LABEL NOT_ACTED_STAKEHOLDERS_ABSTRACT = new TSE_T_CG_LABEL(
        "NotActedStakeholdersAbstract", 
        "Not acted", 
        "実施していません");
    public static final TSE_T_CG_LABEL NOT_IMPLEMENTED_SHAREHOLDERS_MEETING_ABSTRACT = new TSE_T_CG_LABEL(
        "NotImplementedShareholdersMeetingAbstract", 
        "Not implemented", 
        "実施していません");
    public static final TSE_T_CG_LABEL NOT_INCENTIVES = new TSE_T_CG_LABEL(
        "NotIncentives", 
        "Not", 
        "実施していない");
    public static final TSE_T_CG_LABEL NUMBER_OF_ALL_MEMBERS_AUDIT = new TSE_T_CG_LABEL(
        "NumberOfAllMembersAudit", 
        "Number of all members", 
        "全委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_ALL_MEMBERS_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "NumberOfAllMembersAuditEtcCommitteeOutsideDirectors", 
        "Number of all members", 
        "全委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_ALL_MEMBERS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfAllMembersCommitteeCorrespondingToCompensationCommittee", 
        "Number of all members", 
        "全委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_ALL_MEMBERS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfAllMembersCommitteeCorrespondingToNominatingCommittee", 
        "Number of all members", 
        "全委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_ALL_MEMBERS_COMPENSATION = new TSE_T_CG_LABEL(
        "NumberOfAllMembersCompensation", 
        "Number of all members", 
        "全委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_ALL_MEMBERS_NOMINATION = new TSE_T_CG_LABEL(
        "NumberOfAllMembersNomination", 
        "Number of all members", 
        "全委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_CONSOLIDATED_SUBSIDIARIES = new TSE_T_CG_LABEL(
        "NumberOfConsolidatedSubsidiaries", 
        "Number of consolidated subsidiaries at the most current end of fiscal year", 
        "直前事業年度末における連結子会社数");
    public static final TSE_T_CG_LABEL NUMBER_OF_CONSOLIDATED_SUBSIDIARIES_CHECK = new TSE_T_CG_LABEL(
        "NumberOfConsolidatedSubsidiariesCheck", 
        "Number of consolidated subsidiaries at the most current end of fiscal year", 
        "直前事業年度末における連結子会社数");
    public static final TSE_T_CG_LABEL NUMBER_OF_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "NumberOfCorporateAuditors", 
        "Number of corporate auditors", 
        "監査役の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_CORPORATE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "NumberOfCorporateAuditorsCheck", 
        "Number of corporate auditors", 
        "監査役の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_DIRECTORS = new TSE_T_CG_LABEL(
        "NumberOfDirectors", 
        "Number of directors", 
        "取締役の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "NumberOfDirectorsCheck", 
        "Number of directors", 
        "取締役の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_DIRECTORS_STIPULATED_IN_ARTICLES_OF_INCORPORATION = new TSE_T_CG_LABEL(
        "NumberOfDirectorsStipulatedInArticlesOfIncorporation", 
        "Number of directors stipulated in articles of incorporation", 
        "定款上の取締役の員数");
    public static final TSE_T_CG_LABEL NUMBER_OF_DIRECTORS_STIPULATED_IN_ARTICLES_OF_INCORPORATION_CHECK = new TSE_T_CG_LABEL(
        "NumberOfDirectorsStipulatedInArticlesOfIncorporationCheck", 
        "Number of directors stipulated in articles of incorporation", 
        "定款上の取締役の員数");
    public static final TSE_T_CG_LABEL NUMBER_OF_EMPLOYEES_CONSOLIDATED = new TSE_T_CG_LABEL(
        "NumberOfEmployeesConsolidated", 
        "Number of employees at the most current end of fiscal year (consolidated)", 
        "直前事業年度末における（連結）従業員数");
    public static final TSE_T_CG_LABEL NUMBER_OF_EMPLOYEES_CONSOLIDATED_CHECK = new TSE_T_CG_LABEL(
        "NumberOfEmployeesConsolidatedCheck", 
        "Number of employees at the most current end of fiscal year (consolidated)", 
        "直前事業年度末における（連結）従業員数");
    public static final TSE_T_CG_LABEL NUMBER_OF_EXECUTIVE_OFFICERS = new TSE_T_CG_LABEL(
        "NumberOfExecutiveOfficers", 
        "Number of executive officers", 
        "執行役の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_EXECUTIVE_OFFICERS_CHECK = new TSE_T_CG_LABEL(
        "NumberOfExecutiveOfficersCheck", 
        "Number of executive officers", 
        "執行役の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_FULL_TIME_MEMBERS_AUDIT = new TSE_T_CG_LABEL(
        "NumberOfFullTimeMembersAudit", 
        "Number of full-time members", 
        "常勤委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_FULL_TIME_MEMBERS_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "NumberOfFullTimeMembersAuditEtcCommitteeOutsideDirectors", 
        "Number of full-time members", 
        "常勤委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_FULL_TIME_MEMBERS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfFullTimeMembersCommitteeCorrespondingToCompensationCommittee", 
        "Number of full-time members", 
        "常勤委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_FULL_TIME_MEMBERS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfFullTimeMembersCommitteeCorrespondingToNominatingCommittee", 
        "Number of full-time members", 
        "常勤委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_FULL_TIME_MEMBERS_COMPENSATION = new TSE_T_CG_LABEL(
        "NumberOfFullTimeMembersCompensation", 
        "Number of full-time members", 
        "常勤委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_FULL_TIME_MEMBERS_NOMINATION = new TSE_T_CG_LABEL(
        "NumberOfFullTimeMembersNomination", 
        "Number of full-time members", 
        "常勤委員（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_INDEPENDENT_AUDITORS_OUT_OF_OUTSIDE_AUDITORS = new TSE_T_CG_LABEL(
        "NumberOfIndependentAuditorsOutOfOutsideAuditors", 
        "Number of independent auditors out of outside auditors", 
        "社外監査役のうち独立役員に指定されている人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_INDEPENDENT_AUDITORS_OUT_OF_OUTSIDE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "NumberOfIndependentAuditorsOutOfOutsideAuditorsCheck", 
        "Number of independent auditors out of outside auditors", 
        "社外監査役のうち独立役員に指定されている人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_INDEPENDENT_DIRECTORS_AUDITORS = new TSE_T_CG_LABEL(
        "NumberOfIndependentDirectorsAuditors", 
        "Number of independent directors / auditors", 
        "独立役員の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_INDEPENDENT_DIRECTORS_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "NumberOfIndependentDirectorsAuditorsCheck", 
        "Number of independent directors / auditors", 
        "独立役員の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_INDEPENDENT_DIRECTORS_OUT_OF_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "NumberOfIndependentDirectorsOutOfOutsideDirectors", 
        "Number of independent directors out of outside directors", 
        "社外取締役のうち独立役員に指定されている人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_INDEPENDENT_DIRECTORS_OUT_OF_OUTSIDE_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "NumberOfIndependentDirectorsOutOfOutsideDirectorsCheck", 
        "Number of independent directors out of outside directors", 
        "社外取締役のうち独立役員に指定されている人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_INSIDE_DIRECTORS_AUDIT = new TSE_T_CG_LABEL(
        "NumberOfInsideDirectorsAudit", 
        "Number of inside directors", 
        "社内取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_INSIDE_DIRECTORS_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "NumberOfInsideDirectorsAuditEtcCommitteeOutsideDirectors", 
        "Number of inside directors", 
        "社内取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_INSIDE_DIRECTORS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfInsideDirectorsCommitteeCorrespondingToCompensationCommittee", 
        "Number of inside directors", 
        "社内取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_INSIDE_DIRECTORS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfInsideDirectorsCommitteeCorrespondingToNominatingCommittee", 
        "Number of inside directors", 
        "社内取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_INSIDE_DIRECTORS_COMPENSATION = new TSE_T_CG_LABEL(
        "NumberOfInsideDirectorsCompensation", 
        "Number of inside directors", 
        "社内取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_INSIDE_DIRECTORS_NOMINATION = new TSE_T_CG_LABEL(
        "NumberOfInsideDirectorsNomination", 
        "Number of inside directors", 
        "社内取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_OTHERS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfOthersCommitteeCorrespondingToCompensationCommittee", 
        "Number of others", 
        "その他（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_OTHERS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfOthersCommitteeCorrespondingToNominatingCommittee", 
        "Number of others", 
        "その他（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "NumberOfOutsideCorporateAuditors", 
        "Number of outside corporate auditors", 
        "社外監査役の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_CORPORATE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "NumberOfOutsideCorporateAuditorsCheck", 
        "Number of outside corporate auditors", 
        "社外監査役の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "NumberOfOutsideDirectors", 
        "Number of outside directors", 
        "社外取締役の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_DIRECTORS_AUDIT = new TSE_T_CG_LABEL(
        "NumberOfOutsideDirectorsAudit", 
        "Number of outside directors", 
        "社外取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_DIRECTORS_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "NumberOfOutsideDirectorsAuditEtcCommitteeOutsideDirectors", 
        "Number of outside directors", 
        "社外取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "NumberOfOutsideDirectorsCheck", 
        "Number of outside directors", 
        "社外取締役の人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_DIRECTORS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfOutsideDirectorsCommitteeCorrespondingToCompensationCommittee", 
        "Number of outside directors", 
        "社外取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_DIRECTORS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfOutsideDirectorsCommitteeCorrespondingToNominatingCommittee", 
        "Number of outside directors", 
        "社外取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_DIRECTORS_COMPENSATION = new TSE_T_CG_LABEL(
        "NumberOfOutsideDirectorsCompensation", 
        "Number of outside directors", 
        "社外取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_DIRECTORS_NOMINATION = new TSE_T_CG_LABEL(
        "NumberOfOutsideDirectorsNomination", 
        "Number of outside directors", 
        "社外取締役（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_INTELLECTUALS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfOutsideIntellectualsCommitteeCorrespondingToCompensationCommittee", 
        "Number of outside intellectuals", 
        "社外有識者（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_OUTSIDE_INTELLECTUALS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE = new TSE_T_CG_LABEL(
        "NumberOfOutsideIntellectualsCommitteeCorrespondingToNominatingCommittee", 
        "Number of outside intellectuals", 
        "社外有識者（名）");
    public static final TSE_T_CG_LABEL NUMBER_OF_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS = new TSE_T_CG_LABEL(
        "NumberOfRetiredPresidentsOrCEOsHoldingAdvisoryPositions", 
        "Number of retired presidents/CEOs holding advisory positions (sodanyaku, komon, etc.)", 
        "元代表取締役社長等である相談役・顧問等の合計人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_CHECK = new TSE_T_CG_LABEL(
        "NumberOfRetiredPresidentsOrCEOsHoldingAdvisoryPositionsCheck", 
        "Number of retired presidents/CEOs holding advisory positions (sodanyaku, komon, etc.)", 
        "元代表取締役社長等である相談役・顧問等の合計人数");
    public static final TSE_T_CG_LABEL NUMBER_OF_SHARES_HELD_SHARES = new TSE_T_CG_LABEL(
        "NumberOfSharesHeldShares", 
        "Number of shares held (shares)", 
        "所有株式数（株）");
    public static final TSE_T_CG_LABEL NUMBER_OF_STATUTORY_AUDITORS_STIPULATED_IN_ARTICLES_OF_INCORPORATION = new TSE_T_CG_LABEL(
        "NumberOfStatutoryAuditorsStipulatedInArticlesOfIncorporation", 
        "Number of statutory auditors stipulated in articles of incorporation", 
        "定款上の監査役の員数");
    public static final TSE_T_CG_LABEL NUMBER_OF_STATUTORY_AUDITORS_STIPULATED_IN_ARTICLES_OF_INCORPORATION_CHECK = new TSE_T_CG_LABEL(
        "NumberOfStatutoryAuditorsStipulatedInArticlesOfIncorporationCheck", 
        "Number of statutory auditors stipulated in articles of incorporation", 
        "定款上の監査役の員数");
    public static final TSE_T_CG_LABEL ORGANIZATION_STRUCTURES_AND_ORGANIZATIONAL_OPERATIONS_ABSTRACT = new TSE_T_CG_LABEL(
        "OrganizationStructuresAndOrganizationalOperationsAbstract", 
        "Organization structures and organizational operations", 
        "機関構成・組織運営等に係る事項");
    public static final TSE_T_CG_LABEL ORGANIZATIONAL_FORM = new TSE_T_CG_LABEL(
        "OrganizationalForm", 
        "Organizational form", 
        "組織形態");
    public static final TSE_T_CG_LABEL ORGANIZATIONAL_FORM_20150401 = new TSE_T_CG_LABEL(
        "OrganizationalForm20150401", 
        "Organizational form", 
        "組織形態");
    public static final TSE_T_CG_LABEL OSAKA_1ST_SECTION = new TSE_T_CG_LABEL(
        "Osaka1stSection", 
        "Osaka 1st section", 
        "大阪 第一部");
    public static final TSE_T_CG_LABEL OSAKA_2ND_SECTION = new TSE_T_CG_LABEL(
        "Osaka2ndSection", 
        "Osaka 2nd section", 
        "大阪 第二部");
    public static final TSE_T_CG_LABEL OSAKA_HERCULES = new TSE_T_CG_LABEL(
        "OsakaHercules", 
        "Osaka JASDAQ", 
        "大阪 JASDAQ");
    public static final TSE_T_CG_LABEL OSAKA_STOCK_EXCHANGE_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "OsakaStockExchangeParentCompany", 
        "Osaka", 
        "大阪");
    public static final TSE_T_CG_LABEL OSAKA_TO_BE_LISTED = new TSE_T_CG_LABEL(
        "OsakaToBeListed", 
        "Osaka (to be listed)", 
        "大阪 （未定）");
    public static final TSE_T_CG_LABEL OTHER_GRANTEES_OF_STOCK_OPTIONS = new TSE_T_CG_LABEL(
        "OtherGranteesOfStockOptions", 
        "Other", 
        "その他");
    public static final TSE_T_CG_LABEL OTHER_IRABSTRACT = new TSE_T_CG_LABEL(
        "OtherIRAbstract", 
        "Other", 
        "その他");
    public static final TSE_T_CG_LABEL OTHER_INCENTIVES = new TSE_T_CG_LABEL(
        "OtherIncentives", 
        "Other", 
        "その他");
    public static final TSE_T_CG_LABEL OTHER_MEANS_OF_DISCLOSURE = new TSE_T_CG_LABEL(
        "OtherMeansOfDisclosure", 
        "Other", 
        "その他");
    public static final TSE_T_CG_LABEL OTHER_NOTES_REGARDING_INDEPENDENT_DIRECTORS_AUDITORS = new TSE_T_CG_LABEL(
        "OtherNotesRegardingIndependentDirectorsAuditors", 
        "Other notes regarding independent directors / auditors", 
        "その他独立役員に関する事項");
    public static final TSE_T_CG_LABEL OTHER_NOTES_REGARDING_INDEPENDENT_DIRECTORS_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "OtherNotesRegardingIndependentDirectorsAuditorsCheck", 
        "Other notes regarding independent directors / auditors", 
        "その他独立役員に関する事項");
    public static final TSE_T_CG_LABEL OTHER_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "OtherOutsideCorporateAuditors", 
        "Other", 
        "その他");
    public static final TSE_T_CG_LABEL OTHER_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "OtherOutsideDirectors", 
        "Other", 
        "その他");
    public static final TSE_T_CG_LABEL OTHER_PARTICULAR_CONDITIONS_THAT_MAY_MATERIALLY_AFFECT_CORPORATE_GOVERNANCE = new TSE_T_CG_LABEL(
        "OtherParticularConditionsThatMayMateriallyAffectCorporateGovernance", 
        "Other particular conditions that may materially affect corporate governance", 
        "その他コーポレート・ガバナンスに重要な影響を与えうる特別な事情");
    public static final TSE_T_CG_LABEL OTHER_PARTICULAR_CONDITIONS_THAT_MAY_MATERIALLY_AFFECT_CORPORATE_GOVERNANCE_CHECK = new TSE_T_CG_LABEL(
        "OtherParticularConditionsThatMayMateriallyAffectCorporateGovernanceCheck", 
        "Other particular conditions that may materially affect corporate governance", 
        "その他コーポレート・ガバナンスに重要な影響を与えうる特別な事情");
    public static final TSE_T_CG_LABEL OTHER_SHAREHOLDERS_MEETING_ABSTRACT = new TSE_T_CG_LABEL(
        "OtherShareholdersMeetingAbstract", 
        "Other", 
        "その他");
    public static final TSE_T_CG_LABEL OTHER_STAKEHOLDERS_ABSTRACT = new TSE_T_CG_LABEL(
        "OtherStakeholdersAbstract", 
        "Other", 
        "その他");
    public static final TSE_T_CG_LABEL OTHERS_ABSTRACT = new TSE_T_CG_LABEL(
        "OthersAbstract", 
        "Others", 
        "その他");
    public static final TSE_T_CG_LABEL OTHERS_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS = new TSE_T_CG_LABEL(
        "OthersRetiredPresidentsOrCEOsHoldingAdvisoryPositions", 
        "Others", 
        "その他の事項");
    public static final TSE_T_CG_LABEL OTHERS_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_CHECK = new TSE_T_CG_LABEL(
        "OthersRetiredPresidentsOrCEOsHoldingAdvisoryPositionsCheck", 
        "Others", 
        "その他の事項");
    public static final TSE_T_CG_LABEL OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "OutsideCorporateAuditors", 
        "Outside corporate auditors", 
        "社外監査役");
    public static final TSE_T_CG_LABEL OUTSIDE_DIRECTOR_SUPPORT_SYSTEM = new TSE_T_CG_LABEL(
        "OutsideDirectorSupportSystem", 
        "Outside director support system", 
        "社外取締役のサポート体制");
    public static final TSE_T_CG_LABEL OUTSIDE_DIRECTOR_SUPPORT_SYSTEM_CHECK = new TSE_T_CG_LABEL(
        "OutsideDirectorSupportSystemCheck", 
        "Outside director support system", 
        "社外取締役のサポート体制");
    public static final TSE_T_CG_LABEL OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "OutsideDirectors", 
        "Outside directors", 
        "社外取締役");
    public static final TSE_T_CG_LABEL OUTSIDE_DIRECTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "OutsideDirectorsAbstract", 
        "Outside directors", 
        "社外取締役に関する事項");
    public static final TSE_T_CG_LABEL OUTSIDE_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "OutsideDirectorsCheck", 
        "Outside directors", 
        "社外取締役に関する事項");
    public static final TSE_T_CG_LABEL OVERSEAS_STOCK_EXCHANGE_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "OverseasStockExchangeParentCompany", 
        "Overseas", 
        "海外");
    public static final TSE_T_CG_LABEL OWNERSHIP_INTEREST = new TSE_T_CG_LABEL(
        "OwnershipInterest", 
        "Ownership interest (%)", 
        "割合（％）");
    public static final TSE_T_CG_LABEL PARENT_COMPANY = new TSE_T_CG_LABEL(
        "ParentCompany", 
        "Parent company", 
        "親会社名");
    public static final TSE_T_CG_LABEL PARTICIPATION_IN_ELECTRONIC_VOTING_PLATFORMS_AND_OTHER_ACTIVITIES_TO_IMPROVE_VOTING_ENVIRONMENT_FOR_INSTITUTIONAL_INVESTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "ParticipationInElectronicVotingPlatformsAndOtherActivitiesToImproveVotingEnvironmentForInstitutionalInvestorsAbstract", 
        "Participation in electronic voting platforms and other activities to improve voting environment for institutional investors", 
        "議決権電子行使プラットフォームへの参加その他機関投資家の議決権行使環境向上に向けた取組み");
    public static final TSE_T_CG_LABEL PARTICIPATION_OF_ELECTRONIC_VOTING_PLATFORM_AND_OTHER_ACTIVITIES_TO_IMPROVE_VOTING_ENVIRONMENT_FOR_INSTITUTIONAL_INVESTORS = new TSE_T_CG_LABEL(
        "ParticipationOfElectronicVotingPlatformAndOtherActivitiesToImproveVotingEnvironmentForInstitutionalInvestors", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL PERCENTAGE_OF_SHARES_HELD_BY_FOREIGN_INVESTORS = new TSE_T_CG_LABEL(
        "PercentageOfSharesHeldByForeignInvestors", 
        "Percentage of shares held by foreign investors", 
        "外国人株式保有比率");
    public static final TSE_T_CG_LABEL PERCENTAGE_OF_SHARES_HELD_BY_FOREIGN_INVESTORS_CHECK = new TSE_T_CG_LABEL(
        "PercentageOfSharesHeldByForeignInvestorsCheck", 
        "Percentage of shares held by foreign investors", 
        "外国人株式保有比率");
    public static final TSE_T_CG_LABEL PERFORMANCE_BASED_COMPENSATION_SYSTEM = new TSE_T_CG_LABEL(
        "PerformanceBasedCompensationSystem", 
        "Performance-based compensation system", 
        "業績連動報酬制度の導入");
    public static final TSE_T_CG_LABEL PROMOTION_OF_ENVIRONMENTAL_PRESERVATION_ACTIVITIES_AND_CSRACTIVITIES_ABSTRACT = new TSE_T_CG_LABEL(
        "PromotionOfEnvironmentalPreservationActivitiesAndCSRActivitiesAbstract", 
        "Promotion of environmental preservation activities and CSR activities", 
        "環境保全活動、ＣＳＲ活動等の実施");
    public static final TSE_T_CG_LABEL PUBLIC_ANNOUNCEMENT_OF_DISCLOSURE_POLICY = new TSE_T_CG_LABEL(
        "PublicAnnouncementOfDisclosurePolicy", 
        "Correspondence", 
        "該当");
    public static final TSE_T_CG_LABEL PUBLIC_ANNOUNCEMENT_OF_DISCLOSURE_POLICY_ABSTRACT = new TSE_T_CG_LABEL(
        "PublicAnnouncementOfDisclosurePolicyAbstract", 
        "Public announcement of disclosure policy", 
        "ディスクロージャーポリシーの作成・公表");
    public static final TSE_T_CG_LABEL REASON_FOR_ADOPTING_THE_CURRENT_CORPORATE_GOVERNANCE_SYSTEM = new TSE_T_CG_LABEL(
        "ReasonForAdoptingTheCurrentCorporateGovernanceSystem", 
        "Reason for adopting the current corporate governance system", 
        "現状のコーポレート・ガバナンス体制を選択している理由");
    public static final TSE_T_CG_LABEL REASON_FOR_ADOPTING_THE_CURRENT_CORPORATE_GOVERNANCE_SYSTEM_CHECK = new TSE_T_CG_LABEL(
        "ReasonForAdoptingTheCurrentCorporateGovernanceSystemCheck", 
        "Reason for adopting the current corporate governance system", 
        "現状のコーポレート・ガバナンス体制を選択している理由");
    public static final TSE_T_CG_LABEL REASON_FOR_ADOPTING_THE_CURRENT_SYSTEM_AUDITING_STRUCTURE = new TSE_T_CG_LABEL(
        "ReasonForAdoptingTheCurrentSystemAuditingStructure", 
        "Reason for adopting the current system", 
        "現在の体制を採用している理由");
    public static final TSE_T_CG_LABEL REASON_FOR_ADOPTING_THE_CURRENT_SYSTEM_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "ReasonForAdoptingTheCurrentSystemOutsideCorporateAuditors", 
        "Reason for adopting the current system", 
        "現状の体制を採用している理由");
    public static final TSE_T_CG_LABEL REASON_FOR_ADOPTING_THE_CURRENT_SYSTEM_OUTSIDE_CORPORATE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "ReasonForAdoptingTheCurrentSystemOutsideCorporateAuditorsCheck", 
        "Reason for adopting the current system", 
        "現状の体制を採用している理由");
    public static final TSE_T_CG_LABEL REASON_FOR_ADOPTING_THE_CURRENT_SYSTEM_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "ReasonForAdoptingTheCurrentSystemOutsideDirectors", 
        "Reason for adopting the current system", 
        "現状の体制を採用している理由");
    public static final TSE_T_CG_LABEL REASON_FOR_ADOPTING_THE_CURRENT_SYSTEM_OUTSIDE_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "ReasonForAdoptingTheCurrentSystemOutsideDirectorsCheck", 
        "Reason for adopting the current system", 
        "現状の体制を採用している理由");
    public static final TSE_T_CG_LABEL REASON_FOR_ELECTION_AS_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "ReasonForElectionAsOutsideCorporateAuditors", 
        "Reasons for appointment", 
        "選任の理由");
    public static final TSE_T_CG_LABEL REASON_FOR_ELECTION_AS_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "ReasonForElectionAsOutsideDirectors", 
        "Reasons for appointment", 
        "選任の理由");
    public static final TSE_T_CG_LABEL REASONS_FOR_IMPLEMENTING_THE_FORMAT_OF_ACOMPANY_WITH_ACOMMITTEES_SYSTEM = new TSE_T_CG_LABEL(
        "ReasonsForImplementingTheFormatOfACompanyWithACommitteesSystem", 
        "Reasons for implementing the format of a company with a committees system", 
        "委員会設置会社形態を採用している理由");
    public static final TSE_T_CG_LABEL REASONS_FOR_IMPLEMENTING_THE_FORMAT_OF_ACOMPANY_WITH_ACOMMITTEES_SYSTEM_CHECK = new TSE_T_CG_LABEL(
        "ReasonsForImplementingTheFormatOfACompanyWithACommitteesSystemCheck", 
        "Reasons for implementing the format of a company with a committees system", 
        "委員会設置会社形態を採用している理由");
    public static final TSE_T_CG_LABEL REASONS_FOR_NON_COMPLIANCE_WITH_THE_PRINCIPLES_OF_THE_CORPORATE_GOVERNANCE_CODE = new TSE_T_CG_LABEL(
        "ReasonsForNon-complianceWithThePrinciplesOfTheCorporateGovernanceCode", 
        "Reasons for non-compliance with the principles of the Corporate Governance Code", 
        "コーポレートガバナンス・コードの各原則を実施しない理由");
    public static final TSE_T_CG_LABEL REASONS_FOR_NON_COMPLIANCE_WITH_THE_PRINCIPLES_OF_THE_CORPORATE_GOVERNANCE_CODE_CHECK = new TSE_T_CG_LABEL(
        "ReasonsForNon-complianceWithThePrinciplesOfTheCorporateGovernanceCodeCheck", 
        "Reasons for non-compliance with the principles of the Corporate Governance Code", 
        "コーポレートガバナンス・コードの各原則を実施しない理由");
    public static final TSE_T_CG_LABEL RECEIVES_COMPENSATION_ETC_OR_OTHER_PROFITS_ON_ASSETS_FROM_THE_PARENT_COMPANY_OF_THE_COMPANY_OR_ASUBSIDIARY_OF_SUCH_PARENT_COMPANY_AS_AN_OFFICER_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "ReceivesCompensationEtcOrOtherProfitsOnAssetsFromTheParentCompanyOfTheCompanyOrASubsidiaryOfSuchParentCompanyAsAnOfficerOutsideCorporateAuditors", 
        "Receives compensation, etc. or other profits on assets from the parent company of the company or a subsidiary of such parent company as an officer", 
        "当該会社の親会社又は当該親会社の子会社から役員としての報酬等その他の財産上の利益を受けている");
    public static final TSE_T_CG_LABEL RECEIVES_COMPENSATION_ETC_OR_OTHER_PROFITS_ON_ASSETS_FROM_THE_PARENT_COMPANY_OF_THE_COMPANY_OR_ASUBSIDIARY_OF_SUCH_PARENT_COMPANY_AS_AN_OFFICER_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "ReceivesCompensationEtcOrOtherProfitsOnAssetsFromTheParentCompanyOfTheCompanyOrASubsidiaryOfSuchParentCompanyAsAnOfficerOutsideDirectors", 
        "Receives compensation, etc. or other profits on assets from the parent company of the company or a subsidiary of such parent company as an officer", 
        "当該会社の親会社又は当該親会社の子会社から役員としての報酬等その他の財産上の利益を受けている");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_10_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany10OutsideCorporateAuditors", 
        "Person who executes business for a client of the company (excluding persons categorized as any of f, g, or h above)", 
        "上場会社の取引先（f、g及びhのいずれにも該当しないもの）の業務執行者（本人のみ）");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_10_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany10OutsideDirectors", 
        "Person who executes business for an entity receiving contributions from the company", 
        "上場会社が寄付を行っている先の業務執行者（本人のみ）");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_11_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany11OutsideCorporateAuditors", 
        "Person who executes business for another company holding cross-directorships/cross-auditorships with the company", 
        "社外役員の相互就任の関係にある先の業務執行者（本人のみ）");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_11_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany11OutsideDirectors", 
        "Others", 
        "その他");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_12_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany12OutsideCorporateAuditors", 
        "Person who executes business for an entity receiving contributions from the company", 
        "上場会社が寄付を行っている先の業務執行者（本人のみ）");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_12_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany12OutsideDirectors", 
        "Relation with the company 12", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_13_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany13OutsideCorporateAuditors", 
        "Others", 
        "その他");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_13_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany13OutsideDirectors", 
        "Relation with the company 13", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_14_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany14OutsideCorporateAuditors", 
        "Relation with the company 14", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_14_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany14OutsideDirectors", 
        "Relation with the company 14", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_15_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany15OutsideCorporateAuditors", 
        "Relation with the company 15", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_15_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany15OutsideDirectors", 
        "Relation with the company 15", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_16_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany16OutsideCorporateAuditors", 
        "Relation with the company 16", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_16_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany16OutsideDirectors", 
        "Relation with the company 16", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_17_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany17OutsideCorporateAuditors", 
        "Relation with the company 17", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_17_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany17OutsideDirectors", 
        "Relation with the company 17", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_18_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany18OutsideCorporateAuditors", 
        "Relation with the company 18", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_18_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany18OutsideDirectors", 
        "Relation with the company 18", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_19_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany19OutsideCorporateAuditors", 
        "Relation with the company 19", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_19_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany19OutsideDirectors", 
        "Relation with the company 19", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_1_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany1OutsideCorporateAuditors", 
        "Person who executes business of the company or a subsidiary", 
        "上場会社又はその子会社の業務執行者");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_1_OUTSIDE_CORPORATE_AUDITORS_20150401_ABSTRACT = new TSE_T_CG_LABEL(
        "RelationWithTheCompany1OutsideCorporateAuditors20150401Abstract", 
        "Relation with the company (1)", 
        "会社との関係(1)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_1_OUTSIDE_CORPORATE_AUDITORS_20150401_CHECK = new TSE_T_CG_LABEL(
        "RelationWithTheCompany1OutsideCorporateAuditors20150401Check", 
        "Relation with the company (1)", 
        "会社との関係(1)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_1_OUTSIDE_CORPORATE_AUDITORS_ABSTRACT = new TSE_T_CG_LABEL(
        "RelationWithTheCompany1OutsideCorporateAuditorsAbstract", 
        "Relation with the company (1)", 
        "会社との関係(1)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_1_OUTSIDE_CORPORATE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "RelationWithTheCompany1OutsideCorporateAuditorsCheck", 
        "Relation with the company (1)", 
        "会社との関係(1)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_1_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany1OutsideDirectors", 
        "Person who executes business of the company or a subsidiary", 
        "上場会社又はその子会社の業務執行者");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_1_OUTSIDE_DIRECTORS_20150401_ABSTRACT = new TSE_T_CG_LABEL(
        "RelationWithTheCompany1OutsideDirectors20150401Abstract", 
        "Relation with the company (1)", 
        "会社との関係(1)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_1_OUTSIDE_DIRECTORS_20150401_CHECK = new TSE_T_CG_LABEL(
        "RelationWithTheCompany1OutsideDirectors20150401Check", 
        "Relation with the company (1)", 
        "会社との関係(1)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_1_OUTSIDE_DIRECTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "RelationWithTheCompany1OutsideDirectorsAbstract", 
        "Relation with the company (1)", 
        "会社との関係(1)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_1_OUTSIDE_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "RelationWithTheCompany1OutsideDirectorsCheck", 
        "Relation with the company (1)", 
        "会社との関係(1)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_20_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany20OutsideCorporateAuditors", 
        "Relation with the company 20", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_20_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany20OutsideDirectors", 
        "Relation with the company 20", 
        "未使用");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_2_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany2OutsideCorporateAuditors", 
        "Non-executive director or an accounting advisor of the company or a subsidiary", 
        "上場会社又はその子会社の非業務執行取締役又は会計参与");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_2_OUTSIDE_CORPORATE_AUDITORS_ABSTRACT = new TSE_T_CG_LABEL(
        "RelationWithTheCompany2OutsideCorporateAuditorsAbstract", 
        "Relation with the company (2)", 
        "会社との関係(2)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_2_OUTSIDE_CORPORATE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "RelationWithTheCompany2OutsideCorporateAuditorsCheck", 
        "Relation with the company (2)", 
        "会社との関係(2)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany2OutsideDirectors", 
        "Person who executes business or a non-executive director of a parent company", 
        "上場会社の親会社の業務執行者又は非業務執行取締役");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "RelationWithTheCompany2OutsideDirectorsAbstract", 
        "Relation with the company (2)", 
        "会社との関係(2)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_CAABSTRACT = new TSE_T_CG_LABEL(
        "RelationWithTheCompany2OutsideDirectorsCAAbstract", 
        "Relation with the company (2)", 
        "会社との関係(2)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_CACHECK = new TSE_T_CG_LABEL(
        "RelationWithTheCompany2OutsideDirectorsCACheck", 
        "Relation with the company (2)", 
        "会社との関係(2)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_CMABSTRACT = new TSE_T_CG_LABEL(
        "RelationWithTheCompany2OutsideDirectorsCMAbstract", 
        "Relation with the company (2)", 
        "会社との関係(2)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_CMCHECK = new TSE_T_CG_LABEL(
        "RelationWithTheCompany2OutsideDirectorsCMCheck", 
        "Relation with the company (2)", 
        "会社との関係(2)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "RelationWithTheCompany2OutsideDirectorsCheck", 
        "Relation with the company (2)", 
        "会社との関係(2)");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_3_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany3OutsideCorporateAuditors", 
        "Person who executes business or a non-executive director of a parent company", 
        "上場会社の親会社の業務執行者又は非業務執行取締役");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_3_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany3OutsideDirectors", 
        "Person who executes business of a fellow subsidiary", 
        "上場会社の兄弟会社の業務執行者");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_4_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany4OutsideCorporateAuditors", 
        "Auditor of a parent company", 
        "上場会社の親会社の監査役");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_4_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany4OutsideDirectors", 
        "Person/entity for which the company is a major client or a person who executes business for such person/entity", 
        "上場会社を主要な取引先とする者又はその業務執行者");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_5_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany5OutsideCorporateAuditors", 
        "Person who executes business of a fellow subsidiary", 
        "上場会社の兄弟会社の業務執行者");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_5_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany5OutsideDirectors", 
        "Major client of the company or a person who executes business for such client", 
        "上場会社の主要な取引先又はその業務執行者");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_6_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany6OutsideCorporateAuditors", 
        "Person/entity for which the company is a major client or a person who executes business for such person/entity", 
        "上場会社を主要な取引先とする者又はその業務執行者");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_6_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany6OutsideDirectors", 
        "Consultant, accounting expert, or legal expert who receives large amounts of cash or other assets in addition to director/auditor compensation from the company", 
        "上場会社から役員報酬以外に多額の金銭その他の財産を得ているコンサルタント、会計専門家、法律専門家");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_7_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany7OutsideCorporateAuditors", 
        "Major client of the company or a person who executes business for such client", 
        "上場会社の主要な取引先又はその業務執行者");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_7_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany7OutsideDirectors", 
        "Major shareholder of the company (in cases where the shareholder is a corporation, a person who executes business of the corporation)", 
        "上場会社の主要株主（当該主要株主が法人である場合には、当該法人の業務執行者）");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_8_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany8OutsideCorporateAuditors", 
        "Consultant, accounting expert, or legal expert who receives large amounts of cash or other assets in addition to director/auditor compensation from the company", 
        "上場会社から役員報酬以外に多額の金銭その他の財産を得ているコンサルタント、会計専門家、法律専門家");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_8_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany8OutsideDirectors", 
        "Person who executes business for a client of the company (excluding persons categorized as any of d, e, or f above)", 
        "上場会社の取引先（d、e及びｆのいずれにも該当しないもの）の業務執行者（本人のみ）");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_9_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany9OutsideCorporateAuditors", 
        "Major shareholder of the company (in cases where the shareholder is a corporation, a person who executes business of the corporation)", 
        "上場会社の主要株主（当該主要株主が法人である場合には、当該法人の業務執行者）");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_9_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "RelationWithTheCompany9OutsideDirectors", 
        "Person who executes business for another company holding cross-directorships/cross-auditorships with the company", 
        "社外役員の相互就任の関係にある先の業務執行者（本人のみ）");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_OUTSIDE_CORPORATE_AUDITORS_ABSTRACT = new TSE_T_CG_LABEL(
        "RelationWithTheCompanyOutsideCorporateAuditorsAbstract", 
        "Relation with the company", 
        "会社との関係");
    public static final TSE_T_CG_LABEL RELATION_WITH_THE_COMPANY_OUTSIDE_DIRECTORS_ABSTRACT = new TSE_T_CG_LABEL(
        "RelationWithTheCompanyOutsideDirectorsAbstract", 
        "Relation with the company", 
        "会社との関係");
    public static final TSE_T_CG_LABEL REPORTING_DATE = new TSE_T_CG_LABEL(
        "ReportingDate", 
        "Reporting date", 
        "報告日");
    public static final TSE_T_CG_LABEL REPRESENTATIVE_AUTHORITY = new TSE_T_CG_LABEL(
        "RepresentativeAuthority", 
        "Representative authority", 
        "代表権の有無");
    public static final TSE_T_CG_LABEL REPRESENTATIVE_STITLE_AND_NAME = new TSE_T_CG_LABEL(
        "RepresentativeSTitleAndName", 
        "Representative's title and name", 
        "代表者役職氏名");
    public static final TSE_T_CG_LABEL RESPONSIBILITIES_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS = new TSE_T_CG_LABEL(
        "ResponsibilitiesRetiredPresidentsOrCEOsHoldingAdvisoryPositions", 
        "Responsibilities", 
        "業務内容");
    public static final TSE_T_CG_LABEL RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_ABSTRACT = new TSE_T_CG_LABEL(
        "RetiredPresidentsOrCEOsHoldingAdvisoryPositionsAbstract", 
        "Retired presidents/CEOs holding advisory positions (sodanyaku, komon, etc.)", 
        "代表取締役社長等を退任した者の状況");
    public static final TSE_T_CG_LABEL SAPPORO = new TSE_T_CG_LABEL(
        "Sapporo", 
        "Sapporo", 
        "札幌 既存市場");
    public static final TSE_T_CG_LABEL SAPPORO_AMBITIOUS = new TSE_T_CG_LABEL(
        "SapporoAmbitious", 
        "Sapporo Ambitious", 
        "札幌 アンビシャス");
    public static final TSE_T_CG_LABEL SAPPORO_STOCK_EXCHANGE_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "SapporoStockExchangeParentCompany", 
        "Sapporo", 
        "札幌");
    public static final TSE_T_CG_LABEL SAPPORO_TO_BE_LISTED = new TSE_T_CG_LABEL(
        "SapporoToBeListed", 
        "Sapporo  (to be listed)", 
        "札幌 （未定）");
    public static final TSE_T_CG_LABEL SCHEDULING_OF_SHAREHOLDERS_MEETING_AWAY_FROM_CONCENTRATED_DAYS_ABSTRACT = new TSE_T_CG_LABEL(
        "SchedulingOfShareholdersMeetingAwayFromConcentratedDaysAbstract", 
        "Scheduling of shareholders' meeting away from 'concentrated days'", 
        "集中日を回避した株主総会の設定");
    public static final TSE_T_CG_LABEL SECTOR = new TSE_T_CG_LABEL(
        "Sector", 
        "Sector", 
        "業種");
    public static final TSE_T_CG_LABEL SECTOR_CHECK = new TSE_T_CG_LABEL(
        "SectorCheck", 
        "Sector", 
        "業種");
    public static final TSE_T_CG_LABEL SECURITIES_CODE = new TSE_T_CG_LABEL(
        "SecuritiesCode", 
        "Securities code", 
        "証券コード");
    public static final TSE_T_CG_LABEL SECURITIES_CODE_OF_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "SecuritiesCodeOfParentCompany", 
        "Securities code", 
        "コード（数字4桁）");
    public static final TSE_T_CG_LABEL SETTING_FORTH_PROVISIONS_IN_THE_INTERNAL_REGULATIONS_CONCERNING_RESPECT_FOR_THE_STAKEHOLDERS_POSITION_ABSTRACT = new TSE_T_CG_LABEL(
        "SettingForthProvisionsInTheInternalRegulationsConcerningRespectForTheStakeholdersPositionAbstract", 
        "Setting forth provisions in the internal regulations concerning respect for the stakeholders' position", 
        "社内規程等によりステークホルダーの立場の尊重について規定");
    public static final TSE_T_CG_LABEL SPECIAL_NOTE_FOR_DESCRIPTION_OF_MAJOR_SHAREHOLDERS = new TSE_T_CG_LABEL(
        "SpecialNoteForDescriptionOfMajorShareholders", 
        "Special note for description of major shareholders", 
        "補足説明");
    public static final TSE_T_CG_LABEL SPECIAL_NOTE_FOR_DESCRIPTION_OF_MAJOR_SHAREHOLDERS_CHECK = new TSE_T_CG_LABEL(
        "SpecialNoteForDescriptionOfMajorShareholdersCheck", 
        "Special note for description of major shareholders", 
        "補足説明");
    public static final TSE_T_CG_LABEL SPOUSE_RELATIVES_WITHIN_THIRD_DEGREE_OF_CONSANGUINITY_OR_AN_EQUIVALENT_PERSON_OF_MANAGEMENT_LEVEL_SUCH_AS_MANAGEMENT_DIRECTOR_OR_EXECUTIVE_OFFICER_ETC_OF_THE_COMPANY_OR_SPECIFIC_AFFILIATES_OF_THE_COMPANY_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "SpouseRelativesWithinThirdDegreeOfConsanguinityOrAnEquivalentPersonOfManagementLevelSuchAsManagementDirectorOrExecutiveOfficerEtcOfTheCompanyOrSpecificAffiliatesOfTheCompanyOutsideCorporateAuditors", 
        "Spouse, relatives within third degree of consanguinity or an equivalent person of management level such as management director or executive officer, etc. of the company or specific affiliates of the company", 
        "当該会社又は当該会社の特定関係事業者の業務執行取締役、執行役等の配偶者、三親等以内の親族その他これに準ずるものである");
    public static final TSE_T_CG_LABEL SPOUSE_RELATIVES_WITHIN_THIRD_DEGREE_OF_CONSANGUINITY_OR_AN_EQUIVALENT_PERSON_OF_MANAGEMENT_LEVEL_SUCH_AS_MANAGEMENT_DIRECTOR_OR_EXECUTIVE_OFFICER_ETC_OF_THE_COMPANY_OR_SPECIFIC_AFFILIATES_OF_THE_COMPANY_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "SpouseRelativesWithinThirdDegreeOfConsanguinityOrAnEquivalentPersonOfManagementLevelSuchAsManagementDirectorOrExecutiveOfficerEtcOfTheCompanyOrSpecificAffiliatesOfTheCompanyOutsideDirectors", 
        "Spouse, relatives within third degree of consanguinity or an equivalent person of management level such as management director or executive officer, etc. of the company or specific affiliates of the company", 
        "当該会社又は当該会社の特定関係事業者の業務執行取締役、執行役等の配偶者、三親等以内の親族その他これに準ずる者である");
    public static final TSE_T_CG_LABEL STATUS_OF_ADDITIONAL_DUTIES_ABSTRACT = new TSE_T_CG_LABEL(
        "StatusOfAdditionalDutiesAbstract", 
        "Status of additional duties", 
        "兼任状況");
    public static final TSE_T_CG_LABEL STATUS_OF_ADDITIONAL_DUTIES_CHECK = new TSE_T_CG_LABEL(
        "StatusOfAdditionalDutiesCheck", 
        "Status of additional duties", 
        "兼任状況");
    public static final TSE_T_CG_LABEL STATUS_OF_IMPLEMENTATION_OF_MEASURES_FOR_REVITALIZATION_OF_THE_SHAREHOLDERS_MEETING_AND_SMOOTHING_OF_THE_EXECUTION_OF_VOTING_RIGHTS_ABSTRACT = new TSE_T_CG_LABEL(
        "StatusOfImplementationOfMeasuresForRevitalizationOfTheShareholdersMeetingAndSmoothingOfTheExecutionOfVotingRightsAbstract", 
        "Status of implementation of measures for revitalization of the shareholders' meeting and smoothing of the execution of voting rights", 
        "株主総会の活性化及び議決権行使の円滑化に向けての取組み状況");
    public static final TSE_T_CG_LABEL STATUS_OF_IMPLEMENTATION_OF_MEASURES_FOR_REVITALIZATION_OF_THE_SHAREHOLDERS_MEETING_AND_SMOOTHING_OF_THE_EXECUTION_OF_VOTING_RIGHTS_CHECK = new TSE_T_CG_LABEL(
        "StatusOfImplementationOfMeasuresForRevitalizationOfTheShareholdersMeetingAndSmoothingOfTheExecutionOfVotingRightsCheck", 
        "Status of implementation of measures for revitalization of the shareholders' meeting and smoothing of the execution of voting rights", 
        "株主総会の活性化及び議決権行使の円滑化に向けての取組み状況");
    public static final TSE_T_CG_LABEL STATUS_OF_THE_IMPLEMENTATION_OF_MEASURES_TO_GIVE_INCENTIVES_TO_DIRECTORS_AND_EXECUTIVE_OFFICERS_ABSTRACT = new TSE_T_CG_LABEL(
        "StatusOfTheImplementationOfMeasuresToGiveIncentivesToDirectorsAndExecutiveOfficersAbstract", 
        "Status of the implementation of measures to give incentives to directors and executive officers", 
        "取締役・執行役へのインセンティブ付与に関する施策の実施状況");
    public static final TSE_T_CG_LABEL STATUS_OF_THE_IMPLEMENTATION_OF_MEASURES_TO_GIVE_INCENTIVES_TO_DIRECTORS_AND_EXECUTIVE_OFFICERS_CHECK = new TSE_T_CG_LABEL(
        "StatusOfTheImplementationOfMeasuresToGiveIncentivesToDirectorsAndExecutiveOfficersCheck", 
        "Status of the implementation of measures to give incentives to directors and executive officers", 
        "取締役・執行役へのインセンティブ付与に関する施策の実施状況");
    public static final TSE_T_CG_LABEL STOCK_OPTION_SYSTEM = new TSE_T_CG_LABEL(
        "StockOptionSystem", 
        "Stock option system", 
        "ストックオプション制度の導入");
    public static final TSE_T_CG_LABEL STOCKEXCHANGE_ABSTRACT = new TSE_T_CG_LABEL(
        "StockexchangeAbstract", 
        "Stock exchange", 
        "取引所");
    public static final TSE_T_CG_LABEL STOCKEXCHANGE_AND_SECTION_CHECK = new TSE_T_CG_LABEL(
        "StockexchangeAndSectionCheck", 
        "Stock exchange and section", 
        "上場取引所及び市場区分");
    public static final TSE_T_CG_LABEL STOCKEXCHANGE_ANDSECTION_ABSTRACT = new TSE_T_CG_LABEL(
        "StockexchangeAndsectionAbstract", 
        "Stock exchange and section", 
        "上場取引所及び市場区分");
    public static final TSE_T_CG_LABEL STOCKEXCHANGE_LISTING = new TSE_T_CG_LABEL(
        "StockexchangeListing", 
        "Stock exchange listing", 
        "上場区分");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_ANALYSTS_AND_INSTITUTIONAL_INVESTORS = new TSE_T_CG_LABEL(
        "SupplementaryInformationAnalystsAndInstitutionalInvestors", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_AVAILABILITY_OF_ENGLISH_TRANSLATION_OF_GENERAL_SHAREHOLDERS_MEETING_NOTICE = new TSE_T_CG_LABEL(
        "SupplementaryInformationAvailabilityOfEnglishTranslationOfGeneralShareholdersMeetingNotice", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_CSR = new TSE_T_CG_LABEL(
        "SupplementaryInformationCSR", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_CONCENTRATED_DAYS = new TSE_T_CG_LABEL(
        "SupplementaryInformationConcentratedDays", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_DEFENSE_AGAINST_ATAKEOVER_BID = new TSE_T_CG_LABEL(
        "SupplementaryInformationDefenseAgainstATakeoverBid", 
        "Supplementary information", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_DEFENSE_AGAINST_ATAKEOVER_BID_CHECK = new TSE_T_CG_LABEL(
        "SupplementaryInformationDefenseAgainstATakeoverBidCheck", 
        "Supplementary information", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_DIRECTORS = new TSE_T_CG_LABEL(
        "SupplementaryInformationDirectors", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_DIRECTORS_CHECK = new TSE_T_CG_LABEL(
        "SupplementaryInformationDirectorsCheck", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_DISCLOSURE_OF_INFORMATION = new TSE_T_CG_LABEL(
        "SupplementaryInformationDisclosureOfInformation", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_DISCLOSURE_STATUS = new TSE_T_CG_LABEL(
        "SupplementaryInformationDisclosureStatus", 
        "Supplementary information", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_DISCLOSURE_STATUS_CHECK = new TSE_T_CG_LABEL(
        "SupplementaryInformationDisclosureStatusCheck", 
        "Supplementary information", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_ELECTRONIC_EXECUTION = new TSE_T_CG_LABEL(
        "SupplementaryInformationElectronicExecution", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_FOREIGN_INVESTORS = new TSE_T_CG_LABEL(
        "SupplementaryInformationForeignInvestors", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_GRANTEES_OF_STOCK_OPTIONS = new TSE_T_CG_LABEL(
        "SupplementaryInformationGranteesOfStockOptions", 
        "Supplementary information", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_GRANTEES_OF_STOCK_OPTIONS_CHECK = new TSE_T_CG_LABEL(
        "SupplementaryInformationGranteesOfStockOptionsCheck", 
        "Supplementary information", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_IRDIVISIONS = new TSE_T_CG_LABEL(
        "SupplementaryInformationIRDivisions", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_INCENTIVES = new TSE_T_CG_LABEL(
        "SupplementaryInformationIncentives", 
        "Supplementary information", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_INCENTIVES_CHECK = new TSE_T_CG_LABEL(
        "SupplementaryInformationIncentivesCheck", 
        "Supplementary information", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_INDIVIDUAL_INVESTORS = new TSE_T_CG_LABEL(
        "SupplementaryInformationIndividualInvestors", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_INTERNAL_REGULATIONS = new TSE_T_CG_LABEL(
        "SupplementaryInformationInternalRegulations", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_OF_THE_ABOVE = new TSE_T_CG_LABEL(
        "SupplementaryInformationOfTheAbove", 
        "Supplementary information of the above", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_OF_THE_ABOVE_CHECK = new TSE_T_CG_LABEL(
        "SupplementaryInformationOfTheAboveCheck", 
        "Supplementary information of the above", 
        "該当項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_OTHER_IR = new TSE_T_CG_LABEL(
        "SupplementaryInformationOtherIR", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_OTHER_SHAREHOLDERS_MEETING = new TSE_T_CG_LABEL(
        "SupplementaryInformationOtherShareholdersMeeting", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_OTHER_STAKEHOLDERS = new TSE_T_CG_LABEL(
        "SupplementaryInformationOtherStakeholders", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "SupplementaryInformationOutsideCorporateAuditors", 
        "Supplementary information", 
        "適合項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_OUTSIDE_DIRECTORS = new TSE_T_CG_LABEL(
        "SupplementaryInformationOutsideDirectors", 
        "Supplementary information", 
        "適合項目に関する補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_PARTICIPATION_IN_ELECTRONIC_VOTING_PLATFORMS_AND_OTHER_ACTIVITIES_TO_IMPROVE_VOTING_ENVIRONMENT_FOR_INSTITUTIONAL_INVESTORS = new TSE_T_CG_LABEL(
        "SupplementaryInformationParticipationInElectronicVotingPlatformsAndOtherActivitiesToImproveVotingEnvironmentForInstitutionalInvestors", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_PUBLIC_ANNOUNCEMENT_OF_DISCLOSURE_POLICY = new TSE_T_CG_LABEL(
        "SupplementaryInformationPublicAnnouncementOfDisclosurePolicy", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_SHAREHOLDERS_MEETING = new TSE_T_CG_LABEL(
        "SupplementaryInformationShareholdersMeeting", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPLEMENTARY_INFORMATION_WEBSITE = new TSE_T_CG_LABEL(
        "SupplementaryInformationWebsite", 
        "Supplementary information", 
        "補足説明");
    public static final TSE_T_CG_LABEL SUPPORT_SYSTEM_FOR_OUTSIDE_DIRECTORS_OUTSIDE_CORPORATE_AUDITORS = new TSE_T_CG_LABEL(
        "SupportSystemForOutsideDirectorsOutsideCorporateAuditors", 
        "Support system for outside directors (outside corporate auditors)", 
        "社外取締役（社外監査役）のサポート体制");
    public static final TSE_T_CG_LABEL SUPPORT_SYSTEM_FOR_OUTSIDE_DIRECTORS_OUTSIDE_CORPORATE_AUDITORS_CHECK = new TSE_T_CG_LABEL(
        "SupportSystemForOutsideDirectorsOutsideCorporateAuditorsCheck", 
        "Support system for outside directors (outside corporate auditors)", 
        "社外取締役（社外監査役）のサポート体制");
    public static final TSE_T_CG_LABEL TERM_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS = new TSE_T_CG_LABEL(
        "TermRetiredPresidentsOrCEOsHoldingAdvisoryPositions", 
        "Term", 
        "任期");
    public static final TSE_T_CG_LABEL TOKYO_1ST_SECTION = new TSE_T_CG_LABEL(
        "Tokyo1stSection", 
        "Tokyo 1st section", 
        "東京 第一部");
    public static final TSE_T_CG_LABEL TOKYO_2ND_SECTION = new TSE_T_CG_LABEL(
        "Tokyo2ndSection", 
        "Tokyo 2nd section", 
        "東京 第二部");
    public static final TSE_T_CG_LABEL TOKYO_JASDAQ = new TSE_T_CG_LABEL(
        "TokyoJASDAQ", 
        "Tokyo JASDAQ", 
        "東京 JASDAQ");
    public static final TSE_T_CG_LABEL TOKYO_MOTHERS = new TSE_T_CG_LABEL(
        "TokyoMothers", 
        "Tokyo Mothers", 
        "東京 マザーズ");
    public static final TSE_T_CG_LABEL TOKYO_STOCK_EXCHANGE_PARENT_COMPANY = new TSE_T_CG_LABEL(
        "TokyoStockExchangeParentCompany", 
        "Tokyo", 
        "東京");
    public static final TSE_T_CG_LABEL TOKYO_TO_BE_LISTED = new TSE_T_CG_LABEL(
        "TokyoToBeListed", 
        "Tokyo (to be listed)", 
        "東京 （未定）");
    public static final TSE_T_CG_LABEL URL = new TSE_T_CG_LABEL(
        "URL", 
        "URL", 
        "URL");
    ;
    
    private TSE_T_CG_LABEL(String name, String en, String ja) {
        super(NAMESPACE, name, en, ja);
    }
    
    public static final Set<TSE_T_CG_LABEL> ALL = new TreeSet<>();
    static {
        ALL.add(ACTIVITIES_CONCERNING_RESPECT_FOR_STAKEHOLDERS_ABSTRACT);
        ALL.add(ACTIVITIES_CONCERNING_RESPECT_FOR_STAKEHOLDERS_CHECK);
        ALL.add(ADDITIONAL_DUTIES_AS_DIRECTOR);
        ALL.add(ADDITIONAL_DUTIES_AS_EMPLOYEE);
        ALL.add(ANNUAL_SECURITIES_REPORT);
        ALL.add(ATTRIBUTION_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(ATTRIBUTION_OUTSIDE_DIRECTORS);
        ALL.add(AUDIT_COMMITTEE_ABSTRACT);
        ALL.add(AUDIT_COMMITTEE_OUTSIDE_DIRECTORS);
        ALL.add(AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS);
        ALL.add(AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS_ABSTRACT);
        ALL.add(AUDITING_STRUCTURE_ABSTRACT);
        ALL.add(AUDITORS_ABSTRACT);
        ALL.add(AUDITORS_OF_PARENT_COMPANY);
        ALL.add(AUDITORS_OF_SUBSIDIARIES);
        ALL.add(AVAILABILITY_OF_ENGLISH_TRANSLATION_OF_GENERAL_SHAREHOLDERS_MEETING_NOTICE);
        ALL.add(AVAILABILITY_OF_ENGLISH_TRANSLATION_OF_GENERAL_SHAREHOLDERS_MEETING_NOTICE_ABSTRACT);
        ALL.add(BASIC_APPROACH_TO_INTERNAL_CONTROL_SYSTEM_AND_ITS_DEVELOPMENT);
        ALL.add(BASIC_APPROACH_TO_INTERNAL_CONTROL_SYSTEM_AND_ITS_DEVELOPMENT_CHECK);
        ALL.add(BASIC_POLICY);
        ALL.add(BASIC_POLICY_CHECK);
        ALL.add(BASIC_POLICY_ON_CORPORATE_GOVERNANCE_AND_CAPITAL_STRUCTURE_BUSINESS_ATTRIBUTES_AND_OTHER_BASIC_INFORMATION_ABSTRACT);
        ALL.add(BASIC_POLICY_TO_REJECT_ANTISOCIAL_FORCES_AND_THE_PROGRESS_OF_DEVELOPMENT);
        ALL.add(BASIC_POLICY_TO_REJECT_ANTISOCIAL_FORCES_AND_THE_PROGRESS_OF_DEVELOPMENT_CHECK);
        ALL.add(BUSINESS_ATTRIBUTES_ABSTRACT);
        ALL.add(BUSINESS_REPORT);
        ALL.add(CAPITAL_STRUCTURE_ABSTRACT);
        ALL.add(CHAIR_AUDIT);
        ALL.add(CHAIR_AUDIT_20150401);
        ALL.add(CHAIR_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS);
        ALL.add(CHAIR_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE);
        ALL.add(CHAIR_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE);
        ALL.add(CHAIR_COMPENSATION);
        ALL.add(CHAIR_COMPENSATION_20150401);
        ALL.add(CHAIR_NOMINATION);
        ALL.add(CHAIR_NOMINATION_20150401);
        ALL.add(CHAIRMAN_OF_THE_BOARD_OF_DIRECTORS_COMPANY_WITH_ABOARD_OF_CORPORATE_AUDITORS);
        ALL.add(CHAIRMAN_OF_THE_BOARD_OF_DIRECTORS_COMPANY_WITH_ABOARD_OF_CORPORATE_AUDITORS_CHECK);
        ALL.add(CHAIRMAN_OF_THE_BOARD_OF_DIRECTORS_COMPANY_WITH_ACOMMITTEE_SYSTEMS);
        ALL.add(CHAIRMAN_OF_THE_BOARD_OF_DIRECTORS_COMPANY_WITH_ACOMMITTEE_SYSTEMS_CHECK);
        ALL.add(COMES_FROM_OTHER_AFFILIATE_COMPANY_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(COMES_FROM_OTHER_AFFILIATE_COMPANY_OUTSIDE_DIRECTORS);
        ALL.add(COMES_FROM_PARENT_COMPANY_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(COMES_FROM_PARENT_COMPANY_OUTSIDE_DIRECTORS);
        ALL.add(COMMITTEE_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_ABSTRACT);
        ALL.add(COMMITTEE_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_CHECK);
        ALL.add(COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE_ABSTRACT);
        ALL.add(COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE_ABSTRACT);
        ALL.add(COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE_OR_COMPENSATION_COMMITTEE);
        ALL.add(COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE_OR_COMPENSATION_COMMITTEE_CHECK);
        ALL.add(COMMITTEES_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_ABSTRACT);
        ALL.add(COMMITTEES_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_CHECK);
        ALL.add(COMMITTEES_VOLUNTARILY_ESTABLISHED_ABSTRACT);
        ALL.add(COMPANY_NAME);
        ALL.add(COMPANY_NAME_EN);
        ALL.add(COMPENSATION_COMMITTEE_ABSTRACT);
        ALL.add(COMPENSATION_COMMITTEE_MEMBER);
        ALL.add(COMPENSATION_COMMITTEE_OUTSIDE_DIRECTORS);
        ALL.add(CONCURRENTLY_HOLDS_OFFICE_AS_OUTSIDE_DIRECTOR_OR_OUTSIDE_CORPORATE_AUDITOR_OF_ANOTHER_COMPANY_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(CONCURRENTLY_HOLDS_OFFICE_AS_OUTSIDE_DIRECTOR_OR_OUTSIDE_CORPORATE_AUDITOR_OF_ANOTHER_COMPANY_OUTSIDE_DIRECTORS);
        ALL.add(CONTACT);
        ALL.add(CONTROLLING_SHAREHOLDER);
        ALL.add(CONVENE_PERIODIC_BRIEFING_FOR_ANALYSTS_AND_INSTITUTIONAL_INVESTORS_ABSTRACT);
        ALL.add(CONVENE_PERIODIC_BRIEFING_FOR_FOREIGN_INVESTORS_ABSTRACT);
        ALL.add(CONVENE_PERIODIC_BRIEFING_FOR_INDIVIDUAL_INVESTORS_ABSTRACT);
        ALL.add(COOPERATIVE_RELATIONSHIPS_AMONG_CORPORATE_AUDITORS_INDEPENDENT_ACCOUNTANTS_AND_INTERNAL_AUDIT_DIVISION);
        ALL.add(COOPERATIVE_RELATIONSHIPS_AMONG_CORPORATE_AUDITORS_INDEPENDENT_ACCOUNTANTS_AND_INTERNAL_AUDIT_DIVISION_CHECK);
        ALL.add(COOPERATIVE_RELATIONSHIPS_AMONG_THE_AUDIT_COMMITTEE_INDEPENDENT_AUDITORS_AND_INTERNAL_AUDIT_DIVISION);
        ALL.add(COOPERATIVE_RELATIONSHIPS_AMONG_THE_AUDIT_COMMITTEE_INDEPENDENT_AUDITORS_AND_INTERNAL_AUDIT_DIVISION_CHECK);
        ALL.add(COOPERATIVE_RELATIONSHIPS_AMONG_THE_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS_INDEPENDENT_AUDITORS_AND_INTERNAL_AUDIT_DIVISION);
        ALL.add(COOPERATIVE_RELATIONSHIPS_AMONG_THE_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS_INDEPENDENT_AUDITORS_AND_INTERNAL_AUDIT_DIVISION_CHECK);
        ALL.add(COOPERATIVE_RELATIONSHIPS_BETWEEN_CORPORATE_AUDITORS_AND_INDEPENDENT_ACCOUNTANTS);
        ALL.add(COOPERATIVE_RELATIONSHIPS_BETWEEN_CORPORATE_AUDITORS_AND_INDEPENDENT_ACCOUNTANTS_CHECK);
        ALL.add(COOPERATIVE_RELATIONSHIPS_BETWEEN_CORPORATE_AUDITORS_AND_INTERNAL_AUDIT_DIVISION);
        ALL.add(COOPERATIVE_RELATIONSHIPS_BETWEEN_CORPORATE_AUDITORS_AND_INTERNAL_AUDIT_DIVISION_CHECK);
        ALL.add(COOPERATIVE_RELATIONSHIPS_BETWEEN_THE_AUDIT_COMMITTEE_AND_ACCOUNTING_AUDITORS);
        ALL.add(COOPERATIVE_RELATIONSHIPS_BETWEEN_THE_AUDIT_COMMITTEE_AND_ACCOUNTING_AUDITORS_CHECK);
        ALL.add(COOPERATIVE_RELATIONSHIPS_BETWEEN_THE_AUDIT_COMMITTEE_AND_THE_INTERNAL_AUDIT_DIVISION);
        ALL.add(COOPERATIVE_RELATIONSHIPS_BETWEEN_THE_AUDIT_COMMITTEE_AND_THE_INTERNAL_AUDIT_DIVISION_CHECK);
        ALL.add(CORPORATE_GOVERNANCE_REPORT_ABSTRACT);
        ALL.add(CORPORATE_GOVERNANCE_SYSTEM_OF_MANAGEMENT_BUSINESS_ORGANIZATION_ETC_FOR_MANAGEMENT_DECISION_MAKING_EXECUTION_OF_DUTIES_AND_MANAGEMENT_AUDIT_ABSTRACT);
        ALL.add(CORRESPONDENCE_ANALYSTS_AND_INSTITUTIONAL_INVESTORS);
        ALL.add(CORRESPONDENCE_CSR);
        ALL.add(CORRESPONDENCE_CONCENTRATED_DAYS);
        ALL.add(CORRESPONDENCE_DISCLOSURE_OF_INFORMATION);
        ALL.add(CORRESPONDENCE_ELECTRONIC_EXECUTION);
        ALL.add(CORRESPONDENCE_FOREIGN_INVESTORS);
        ALL.add(CORRESPONDENCE_IRDIVISIONS);
        ALL.add(CORRESPONDENCE_INDIVIDUAL_INVESTORS);
        ALL.add(CORRESPONDENCE_INTERNAL_REGULATIONS);
        ALL.add(CORRESPONDENCE_NOT_ACTED_IR);
        ALL.add(CORRESPONDENCE_NOT_ACTED_STAKEHOLDERS);
        ALL.add(CORRESPONDENCE_NOT_IMPLEMENTED_SHAREHOLDERS_MEETING);
        ALL.add(CORRESPONDENCE_OTHER_IR);
        ALL.add(CORRESPONDENCE_OTHER_SHAREHOLDERS_MEETING);
        ALL.add(CORRESPONDENCE_OTHER_STAKEHOLDERS);
        ALL.add(CORRESPONDENCE_SHAREHOLDERS_MEETING);
        ALL.add(CORRESPONDENCE_WEBSITE);
        ALL.add(DATE_WHEN_FORMER_ROLE_AS_PRESIDENT_OR_CEOENDED_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS);
        ALL.add(DESCRIPTION_OF_CONTROLLING_SHAREHOLDERS_AND_PARENT_COMPANY_ABSTRACT);
        ALL.add(DESCRIPTION_OF_MAJOR_SHAREHOLDERS_ABSTRACT);
        ALL.add(DESCRIPTION_OF_MAJOR_SHAREHOLDERS_CHECK);
        ALL.add(DIAGRAM_1);
        ALL.add(DIAGRAM_2);
        ALL.add(DIAGRAM_3);
        ALL.add(DIAGRAM_4);
        ALL.add(DIAGRAM_5);
        ALL.add(DIAGRAM_ABSTRACT);
        ALL.add(DIRECTOR_COMPENSATION_DISCLOSURE_STATUS);
        ALL.add(DIRECTOR_COMPENSATION_DISCLOSURE_STATUS_CHECK);
        ALL.add(DIRECTOR_EXECUTIVE_OFFICER_COMPENSATION_ABSTRACT);
        ALL.add(DIRECTOR_SCOMPENSATION_ABSTRACT);
        ALL.add(DIRECTORS_ABSTRACT);
        ALL.add(DIRECTORS_AND_EMPLOYEES_RESPONSIBLE_FOR_ASSISTING_IN_EXECUTION_OF_THE_DUTIES_OF_THE_AUDIT_COMMITTEE);
        ALL.add(DIRECTORS_AND_EMPLOYEES_RESPONSIBLE_FOR_ASSISTING_IN_EXECUTION_OF_THE_DUTIES_OF_THE_AUDIT_COMMITTEE_CHECK);
        ALL.add(DIRECTORS_AND_EMPLOYEES_RESPONSIBLE_FOR_ASSISTING_IN_EXECUTION_OF_THE_DUTIES_OF_THE_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS);
        ALL.add(DIRECTORS_AND_EMPLOYEES_RESPONSIBLE_FOR_ASSISTING_IN_EXECUTION_OF_THE_DUTIES_OF_THE_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS_CHECK);
        ALL.add(DIRECTORS_EXECUTIVE_OFFICERS_AUDITORS_OF_PARENT_COMPANY);
        ALL.add(DIRECTORS_EXECUTIVE_OFFICERS_AUDITORS_OF_SUBSIDIARIES);
        ALL.add(DIRECTORS_OF_PARENT_COMPANY);
        ALL.add(DIRECTORS_OF_SUBSIDIARIES);
        ALL.add(DIRECTORS_TERM_OF_OFFICE_STIPULATED_IN_ARTICLES_OF_INCORPORATION);
        ALL.add(DIRECTORS_TERM_OF_OFFICE_STIPULATED_IN_ARTICLES_OF_INCORPORATION_CHECK);
        ALL.add(DISCLOSURE_OF_DIRECTORS_COMPENSATION);
        ALL.add(DISCLOSURE_OF_DIRECTORS_COMPENSATION_CHECK);
        ALL.add(DISCLOSURE_OF_EXECUTIVE_OFFICERS_COMPENSATION);
        ALL.add(DISCLOSURE_OF_EXECUTIVE_OFFICERS_COMPENSATION_CHECK);
        ALL.add(DISCLOSURE_OF_IRDOCUMENTS_ON_THE_WEBSITE_ABSTRACT);
        ALL.add(DISCLOSURE_OF_METHODS_TO_DETERMINE_COMPENSATION_OR_COMPENSATION_POLICIES);
        ALL.add(DISCLOSURE_OF_METHODS_TO_DETERMINE_COMPENSATION_OR_COMPENSATION_POLICIES_CHECK);
        ALL.add(DISCLOSURE_STATUS);
        ALL.add(DISCLOSURE_STATUS_CHECK);
        ALL.add(DISCLOSURES_REQUIRED_BY_THE_PRINCIPLES_OF_THE_CORPORATE_GOVERNANCE_CODE);
        ALL.add(DISCLOSURES_REQUIRED_BY_THE_PRINCIPLES_OF_THE_CORPORATE_GOVERNANCE_CODE_CHECK);
        ALL.add(EARLY_DISPATCH_OF_NOTICE_OF_SHAREHOLDERS_MEETING_ABSTRACT);
        ALL.add(EARNINGS_DIGEST);
        ALL.add(ELECTION_OF_OUTSIDE_DIRECTORS);
        ALL.add(ELECTION_OF_OUTSIDE_DIRECTORS_CHECK);
        ALL.add(ELECTION_OR_NON_ELECTION_OF_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(ELECTION_OR_NON_ELECTION_OF_OUTSIDE_CORPORATE_AUDITORS_CHECK);
        ALL.add(ELECTRONIC_EXECUTION_OF_VOTING_RIGHTS_ABSTRACT);
        ALL.add(EMPLOYEES);
        ALL.add(EMPLOYEES_OF_PARENT_COMPANY);
        ALL.add(EMPLOYEES_OF_SUBSIDIARIES);
        ALL.add(EMPLOYMENT_TERMS_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS);
        ALL.add(ESTABLISHMENT_OF_POLICY_CONCERNING_DISCLOSURE_OF_INFORMATION_TO_STAKEHOLDERS_ABSTRACT);
        ALL.add(ESTABLISHMENT_OR_NON_ESTABLISHMENT_OF_ABOARD_OF_CORPORATE_AUDITORS);
        ALL.add(ESTABLISHMENT_OR_NONESTABLISHMENT_OF_ABOARD_OF_CORPORATE_AUDITORS_CHECK);
        ALL.add(EXECUTIVE_OFFICER_COMPENSATION_DISCLOSURE_STATUS);
        ALL.add(EXECUTIVE_OFFICER_COMPENSATION_DISCLOSURE_STATUS_CHECK);
        ALL.add(EXECUTIVE_OFFICERS);
        ALL.add(EXECUTIVE_OFFICERS_ABSTRACT);
        ALL.add(EXECUTIVE_OFFICERS_OF_PARENT_COMPANY);
        ALL.add(EXECUTIVE_OFFICERS_OF_SUBSIDIARIES);
        ALL.add(EXISTANCE_OF_PARENT_COMPANY);
        ALL.add(EXISTANCE_OF_PARENT_COMPANY_CHECK);
        ALL.add(EXISTENCE_OF_ACONTROLLING_SHAREHOLDERS);
        ALL.add(EXISTENCE_OF_ACONTROLLING_SHAREHOLDERS_CHECK);
        ALL.add(EXISTENCE_OF_COMMITTEES_VOLUNTARILY_ESTABLISHED_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_ABSTRACT);
        ALL.add(EXISTENCE_OF_COMMITTEES_VOLUNTARILY_ESTABLISHED_COMPOSITION_AND_ATTRIBUTES_OF_CHAIR_CHECK);
        ALL.add(EXISTENCE_OF_METHODS_TO_DETERMINE_COMPENSATION_OR_COMPENSATION_POLICIES);
        ALL.add(EXISTENCE_OF_METHODS_TO_DETERMINE_COMPENSATION_OR_COMPENSATION_POLICIES_CHECK);
        ALL.add(EXPLANATION_BY_REPRESENTATIVE_MEMBERS_OF_THE_BOARD_ANALYSTS_AND_INSTITUTIONAL_INVESTORS);
        ALL.add(EXPLANATION_BY_REPRESENTATIVE_MEMBERS_OF_THE_BOARD_FOREIGN_INVESTORS);
        ALL.add(EXPLANATION_BY_REPRESENTATIVE_MEMBERS_OF_THE_BOARD_INDIVIDUAL_INVESTORS);
        ALL.add(EXPLANATION_BY_REPRESENTATIVE_MEMBERS_OF_THE_BOARD_WEBSITE);
        ALL.add(FINAL_UPDATE);
        ALL.add(FISCAL_YEAR_END);
        ALL.add(FISCAL_YEAR_END_CHECK);
        ALL.add(FUKUOKA);
        ALL.add(FUKUOKA_QBOARD);
        ALL.add(FUKUOKA_STOCK_EXCHANGE_PARENT_COMPANY);
        ALL.add(FUKUOKA_TO_BE_LISTED);
        ALL.add(GRANTEES_OF_STOCK_OPTIONS_ABSTRACT);
        ALL.add(GRANTEES_OF_STOCK_OPTIONS_CHECK);
        ALL.add(GUIDELINES_RELATED_TO_PROTECTION_OF_NONCONTROLLING_SHAREHOLDERS_AT_TRADING_WITH_CONTROLLING_SHAREHOLDERS);
        ALL.add(GUIDELINES_RELATED_TO_PROTECTION_OF_NONCONTROLLING_SHAREHOLDERS_AT_TRADING_WITH_CONTROLLING_SHAREHOLDERS_CHECK);
        ALL.add(HOLDS_OFFICE_AS_MANAGEMENT_DIRECTOR_OR_EXECUTIVE_OFFICER_ETC_OF_ANOTHER_COMPANY_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(HOLDS_OFFICE_AS_MANAGEMENT_DIRECTOR_OR_EXECUTIVE_OFFICER_ETC_OF_ANOTHER_COMPANY_OUTSIDE_DIRECTORS);
        ALL.add(IRACTIVITIES_ABSTRACT);
        ALL.add(IRACTIVITIES_CHECK);
        ALL.add(IRRELATED_DIVISIONS_PERSONNEL_ABSTRACT);
        ALL.add(IMPLEMENTATION_OF_MEASURES_FOR_SHAREHOLDERS_AND_OTHER_STAKEHOLDERS_ABSTRACT);
        ALL.add(IMPLEMENTATION_OF_MEASURES_ON_INCENTIVE_ALLOTMENT_TO_DIRECTORS_ABSTRACT);
        ALL.add(IMPLEMENTATION_OF_MEASURES_ON_INCENTIVE_ALLOTMENT_TO_DIRECTORS_CHECK);
        ALL.add(INCENTIVES_ABSTRACT);
        ALL.add(INDEPENDENCE_OF_SAID_DIRECTORS_AND_EMPLOYEES_FROM_EXECUTIVE_OFFICERS);
        ALL.add(INDEPENDENT_DIRECTORS_AUDITORS_ABSTRACT);
        ALL.add(INDEPENDENT_DIRECTORS_AUDITORS_CHECK);
        ALL.add(INDEPENDENT_DIRECTORS_AUDITORS_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(INDEPENDENT_DIRECTORS_AUDITORS_OUTSIDE_DIRECTORS);
        ALL.add(INDIVIDUAL_COMMITTEES_ABSTRACT);
        ALL.add(INFORMATION_ON_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_ABSTRACT);
        ALL.add(INFORMATION_ON_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_CHECK);
        ALL.add(INFORMATION_ON_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_INCLUDED_OR_OMITTED);
        ALL.add(INSIDE_DIRECTORS);
        ALL.add(INTERNAL_AUDITORS);
        ALL.add(INTRODUCING_TAKEOVER_DEFENSE_MEASURES);
        ALL.add(INTRODUCING_TAKEOVER_DEFENSE_MEASURES_ABSTRACT);
        ALL.add(INTRODUCING_TAKEOVER_DEFENSE_MEASURES_CHECK);
        ALL.add(JASDAQ);
        ALL.add(JASDAQNEO);
        ALL.add(JASDAQSTOCK_EXCHANGE_PARENT_COMPANY);
        ALL.add(JASDAQTO_BE_LISTED);
        ALL.add(JAPAN_SECURITIES_DEALERS_ASSOCIATION);
        ALL.add(JAPAN_SECURITIES_DEALERS_ASSOCIATION_PARENT_COMPANY);
        ALL.add(JOB_TITLE_OR_POSITION_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS);
        ALL.add(LIMITATION_OF_LIABILITY_AGREEMENT_IS_EXECUTED_BETWEEN_THE_SAID_PERSON_AND_THE_COMPANY_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(LIMITATION_OF_LIABILITY_AGREEMENT_IS_EXECUTED_BETWEEN_THE_SAID_PERSON_AND_THE_COMPANY_OUTSIDE_DIRECTORS);
        ALL.add(MAJOR_SHAREHOLDER_OF_THE_COMPANY_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(MAJOR_SHAREHOLDER_OF_THE_COMPANY_OUTSIDE_DIRECTORS);
        ALL.add(MATTERS_PERTAINING_TO_FUNCTIONS_RELATING_TO_THE_EXECUTION_OF_DUTIES_AUDIT_AND_SUPERVISION_APPOINTMENT_AND_DECISIONS_REGARDING_COMPENSATION_ETC);
        ALL.add(MATTERS_PERTAINING_TO_FUNCTIONS_RELATING_TO_THE_EXECUTION_OF_DUTIES_AUDIT_AND_SUPERVISION_APPOINTMENT_AND_DECISIONS_REGARDING_COMPENSATION_ETC_CHECK);
        ALL.add(MATTERS_REGARDING_DEFENSE_AGAINST_ATAKEOVER_BID);
        ALL.add(MATTERS_REGARDING_DEFENSE_AGAINST_ATAKEOVER_BID_CHECK);
        ALL.add(MATTERS_REGARDING_INTERNAL_CONTROL_SYSTEM_ABSTRACT);
        ALL.add(MATTERS_REGARDING_OTHER_CORPORATE_GOVERNANCE_SYSTEMS_ETC);
        ALL.add(MATTERS_REGARDING_OTHER_CORPORATE_GOVERNANCE_SYSTEMS_ETC_CHECK);
        ALL.add(MATTERS_RELATING_TO_OTHER_MAJOR_ACTIVITIES_OF_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(MATTERS_RELATING_TO_OTHER_MAJOR_ACTIVITIES_OF_OUTSIDE_CORPORATE_AUDITORS_CHECK);
        ALL.add(MATTERS_RELATING_TO_OTHER_MAJOR_ACTIVITIES_OF_OUTSIDE_DIRECTORS);
        ALL.add(MATTERS_RELATING_TO_OTHER_MAJOR_ACTIVITIES_OF_OUTSIDE_DIRECTORS_CHECK);
        ALL.add(MEANS_OF_DISCLOSURE_ABSTRACT);
        ALL.add(MEANS_OF_DISCLOSURE_CHECK);
        ALL.add(MEMBERSHIP_OF_COMMITTEES_OUTSIDE_DIRECTORS_ABSTRACT);
        ALL.add(NAGOYA_1ST_SECTION);
        ALL.add(NAGOYA_2ND_SECTION);
        ALL.add(NAGOYA_CENTREX);
        ALL.add(NAGOYA_STOCK_EXCHANGE_PARENT_COMPANY);
        ALL.add(NAGOYA_TO_BE_LISTED);
        ALL.add(NAME_EXECUTIVE_OFFICERS);
        ALL.add(NAME_OF_COMMITTEE_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE);
        ALL.add(NAME_OF_COMMITTEE_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE);
        ALL.add(NAME_OF_SHAREHOLDERS);
        ALL.add(NAME_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(NAME_OUTSIDE_DIRECTORS);
        ALL.add(NAME_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS);
        ALL.add(NET_SALES_CONSOLIDATED);
        ALL.add(NET_SALES_CONSOLIDATED_CHECK);
        ALL.add(NOMINATION_COMMITTEE_ABSTRACT);
        ALL.add(NOMINATION_COMMITTEE_MEMBER);
        ALL.add(NOMINATION_COMMITTEE_OUTSIDE_DIRECTORS);
        ALL.add(NOT_ACTED_IRABSTRACT);
        ALL.add(NOT_ACTED_STAKEHOLDERS_ABSTRACT);
        ALL.add(NOT_IMPLEMENTED_SHAREHOLDERS_MEETING_ABSTRACT);
        ALL.add(NOT_INCENTIVES);
        ALL.add(NUMBER_OF_ALL_MEMBERS_AUDIT);
        ALL.add(NUMBER_OF_ALL_MEMBERS_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS);
        ALL.add(NUMBER_OF_ALL_MEMBERS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE);
        ALL.add(NUMBER_OF_ALL_MEMBERS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE);
        ALL.add(NUMBER_OF_ALL_MEMBERS_COMPENSATION);
        ALL.add(NUMBER_OF_ALL_MEMBERS_NOMINATION);
        ALL.add(NUMBER_OF_CONSOLIDATED_SUBSIDIARIES);
        ALL.add(NUMBER_OF_CONSOLIDATED_SUBSIDIARIES_CHECK);
        ALL.add(NUMBER_OF_CORPORATE_AUDITORS);
        ALL.add(NUMBER_OF_CORPORATE_AUDITORS_CHECK);
        ALL.add(NUMBER_OF_DIRECTORS);
        ALL.add(NUMBER_OF_DIRECTORS_CHECK);
        ALL.add(NUMBER_OF_DIRECTORS_STIPULATED_IN_ARTICLES_OF_INCORPORATION);
        ALL.add(NUMBER_OF_DIRECTORS_STIPULATED_IN_ARTICLES_OF_INCORPORATION_CHECK);
        ALL.add(NUMBER_OF_EMPLOYEES_CONSOLIDATED);
        ALL.add(NUMBER_OF_EMPLOYEES_CONSOLIDATED_CHECK);
        ALL.add(NUMBER_OF_EXECUTIVE_OFFICERS);
        ALL.add(NUMBER_OF_EXECUTIVE_OFFICERS_CHECK);
        ALL.add(NUMBER_OF_FULL_TIME_MEMBERS_AUDIT);
        ALL.add(NUMBER_OF_FULL_TIME_MEMBERS_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS);
        ALL.add(NUMBER_OF_FULL_TIME_MEMBERS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE);
        ALL.add(NUMBER_OF_FULL_TIME_MEMBERS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE);
        ALL.add(NUMBER_OF_FULL_TIME_MEMBERS_COMPENSATION);
        ALL.add(NUMBER_OF_FULL_TIME_MEMBERS_NOMINATION);
        ALL.add(NUMBER_OF_INDEPENDENT_AUDITORS_OUT_OF_OUTSIDE_AUDITORS);
        ALL.add(NUMBER_OF_INDEPENDENT_AUDITORS_OUT_OF_OUTSIDE_AUDITORS_CHECK);
        ALL.add(NUMBER_OF_INDEPENDENT_DIRECTORS_AUDITORS);
        ALL.add(NUMBER_OF_INDEPENDENT_DIRECTORS_AUDITORS_CHECK);
        ALL.add(NUMBER_OF_INDEPENDENT_DIRECTORS_OUT_OF_OUTSIDE_DIRECTORS);
        ALL.add(NUMBER_OF_INDEPENDENT_DIRECTORS_OUT_OF_OUTSIDE_DIRECTORS_CHECK);
        ALL.add(NUMBER_OF_INSIDE_DIRECTORS_AUDIT);
        ALL.add(NUMBER_OF_INSIDE_DIRECTORS_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS);
        ALL.add(NUMBER_OF_INSIDE_DIRECTORS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE);
        ALL.add(NUMBER_OF_INSIDE_DIRECTORS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE);
        ALL.add(NUMBER_OF_INSIDE_DIRECTORS_COMPENSATION);
        ALL.add(NUMBER_OF_INSIDE_DIRECTORS_NOMINATION);
        ALL.add(NUMBER_OF_OTHERS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE);
        ALL.add(NUMBER_OF_OTHERS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE);
        ALL.add(NUMBER_OF_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(NUMBER_OF_OUTSIDE_CORPORATE_AUDITORS_CHECK);
        ALL.add(NUMBER_OF_OUTSIDE_DIRECTORS);
        ALL.add(NUMBER_OF_OUTSIDE_DIRECTORS_AUDIT);
        ALL.add(NUMBER_OF_OUTSIDE_DIRECTORS_AUDIT_ETC_COMMITTEE_OUTSIDE_DIRECTORS);
        ALL.add(NUMBER_OF_OUTSIDE_DIRECTORS_CHECK);
        ALL.add(NUMBER_OF_OUTSIDE_DIRECTORS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE);
        ALL.add(NUMBER_OF_OUTSIDE_DIRECTORS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE);
        ALL.add(NUMBER_OF_OUTSIDE_DIRECTORS_COMPENSATION);
        ALL.add(NUMBER_OF_OUTSIDE_DIRECTORS_NOMINATION);
        ALL.add(NUMBER_OF_OUTSIDE_INTELLECTUALS_COMMITTEE_CORRESPONDING_TO_COMPENSATION_COMMITTEE);
        ALL.add(NUMBER_OF_OUTSIDE_INTELLECTUALS_COMMITTEE_CORRESPONDING_TO_NOMINATING_COMMITTEE);
        ALL.add(NUMBER_OF_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS);
        ALL.add(NUMBER_OF_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_CHECK);
        ALL.add(NUMBER_OF_SHARES_HELD_SHARES);
        ALL.add(NUMBER_OF_STATUTORY_AUDITORS_STIPULATED_IN_ARTICLES_OF_INCORPORATION);
        ALL.add(NUMBER_OF_STATUTORY_AUDITORS_STIPULATED_IN_ARTICLES_OF_INCORPORATION_CHECK);
        ALL.add(ORGANIZATION_STRUCTURES_AND_ORGANIZATIONAL_OPERATIONS_ABSTRACT);
        ALL.add(ORGANIZATIONAL_FORM);
        ALL.add(ORGANIZATIONAL_FORM_20150401);
        ALL.add(OSAKA_1ST_SECTION);
        ALL.add(OSAKA_2ND_SECTION);
        ALL.add(OSAKA_HERCULES);
        ALL.add(OSAKA_STOCK_EXCHANGE_PARENT_COMPANY);
        ALL.add(OSAKA_TO_BE_LISTED);
        ALL.add(OTHER_GRANTEES_OF_STOCK_OPTIONS);
        ALL.add(OTHER_IRABSTRACT);
        ALL.add(OTHER_INCENTIVES);
        ALL.add(OTHER_MEANS_OF_DISCLOSURE);
        ALL.add(OTHER_NOTES_REGARDING_INDEPENDENT_DIRECTORS_AUDITORS);
        ALL.add(OTHER_NOTES_REGARDING_INDEPENDENT_DIRECTORS_AUDITORS_CHECK);
        ALL.add(OTHER_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(OTHER_OUTSIDE_DIRECTORS);
        ALL.add(OTHER_PARTICULAR_CONDITIONS_THAT_MAY_MATERIALLY_AFFECT_CORPORATE_GOVERNANCE);
        ALL.add(OTHER_PARTICULAR_CONDITIONS_THAT_MAY_MATERIALLY_AFFECT_CORPORATE_GOVERNANCE_CHECK);
        ALL.add(OTHER_SHAREHOLDERS_MEETING_ABSTRACT);
        ALL.add(OTHER_STAKEHOLDERS_ABSTRACT);
        ALL.add(OTHERS_ABSTRACT);
        ALL.add(OTHERS_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS);
        ALL.add(OTHERS_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_CHECK);
        ALL.add(OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(OUTSIDE_DIRECTOR_SUPPORT_SYSTEM);
        ALL.add(OUTSIDE_DIRECTOR_SUPPORT_SYSTEM_CHECK);
        ALL.add(OUTSIDE_DIRECTORS);
        ALL.add(OUTSIDE_DIRECTORS_ABSTRACT);
        ALL.add(OUTSIDE_DIRECTORS_CHECK);
        ALL.add(OVERSEAS_STOCK_EXCHANGE_PARENT_COMPANY);
        ALL.add(OWNERSHIP_INTEREST);
        ALL.add(PARENT_COMPANY);
        ALL.add(PARTICIPATION_IN_ELECTRONIC_VOTING_PLATFORMS_AND_OTHER_ACTIVITIES_TO_IMPROVE_VOTING_ENVIRONMENT_FOR_INSTITUTIONAL_INVESTORS_ABSTRACT);
        ALL.add(PARTICIPATION_OF_ELECTRONIC_VOTING_PLATFORM_AND_OTHER_ACTIVITIES_TO_IMPROVE_VOTING_ENVIRONMENT_FOR_INSTITUTIONAL_INVESTORS);
        ALL.add(PERCENTAGE_OF_SHARES_HELD_BY_FOREIGN_INVESTORS);
        ALL.add(PERCENTAGE_OF_SHARES_HELD_BY_FOREIGN_INVESTORS_CHECK);
        ALL.add(PERFORMANCE_BASED_COMPENSATION_SYSTEM);
        ALL.add(PROMOTION_OF_ENVIRONMENTAL_PRESERVATION_ACTIVITIES_AND_CSRACTIVITIES_ABSTRACT);
        ALL.add(PUBLIC_ANNOUNCEMENT_OF_DISCLOSURE_POLICY);
        ALL.add(PUBLIC_ANNOUNCEMENT_OF_DISCLOSURE_POLICY_ABSTRACT);
        ALL.add(REASON_FOR_ADOPTING_THE_CURRENT_CORPORATE_GOVERNANCE_SYSTEM);
        ALL.add(REASON_FOR_ADOPTING_THE_CURRENT_CORPORATE_GOVERNANCE_SYSTEM_CHECK);
        ALL.add(REASON_FOR_ADOPTING_THE_CURRENT_SYSTEM_AUDITING_STRUCTURE);
        ALL.add(REASON_FOR_ADOPTING_THE_CURRENT_SYSTEM_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(REASON_FOR_ADOPTING_THE_CURRENT_SYSTEM_OUTSIDE_CORPORATE_AUDITORS_CHECK);
        ALL.add(REASON_FOR_ADOPTING_THE_CURRENT_SYSTEM_OUTSIDE_DIRECTORS);
        ALL.add(REASON_FOR_ADOPTING_THE_CURRENT_SYSTEM_OUTSIDE_DIRECTORS_CHECK);
        ALL.add(REASON_FOR_ELECTION_AS_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(REASON_FOR_ELECTION_AS_OUTSIDE_DIRECTORS);
        ALL.add(REASONS_FOR_IMPLEMENTING_THE_FORMAT_OF_ACOMPANY_WITH_ACOMMITTEES_SYSTEM);
        ALL.add(REASONS_FOR_IMPLEMENTING_THE_FORMAT_OF_ACOMPANY_WITH_ACOMMITTEES_SYSTEM_CHECK);
        ALL.add(REASONS_FOR_NON_COMPLIANCE_WITH_THE_PRINCIPLES_OF_THE_CORPORATE_GOVERNANCE_CODE);
        ALL.add(REASONS_FOR_NON_COMPLIANCE_WITH_THE_PRINCIPLES_OF_THE_CORPORATE_GOVERNANCE_CODE_CHECK);
        ALL.add(RECEIVES_COMPENSATION_ETC_OR_OTHER_PROFITS_ON_ASSETS_FROM_THE_PARENT_COMPANY_OF_THE_COMPANY_OR_ASUBSIDIARY_OF_SUCH_PARENT_COMPANY_AS_AN_OFFICER_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RECEIVES_COMPENSATION_ETC_OR_OTHER_PROFITS_ON_ASSETS_FROM_THE_PARENT_COMPANY_OF_THE_COMPANY_OR_ASUBSIDIARY_OF_SUCH_PARENT_COMPANY_AS_AN_OFFICER_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_10_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_10_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_11_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_11_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_12_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_12_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_13_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_13_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_14_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_14_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_15_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_15_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_16_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_16_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_17_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_17_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_18_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_18_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_19_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_19_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_1_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_1_OUTSIDE_CORPORATE_AUDITORS_20150401_ABSTRACT);
        ALL.add(RELATION_WITH_THE_COMPANY_1_OUTSIDE_CORPORATE_AUDITORS_20150401_CHECK);
        ALL.add(RELATION_WITH_THE_COMPANY_1_OUTSIDE_CORPORATE_AUDITORS_ABSTRACT);
        ALL.add(RELATION_WITH_THE_COMPANY_1_OUTSIDE_CORPORATE_AUDITORS_CHECK);
        ALL.add(RELATION_WITH_THE_COMPANY_1_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_1_OUTSIDE_DIRECTORS_20150401_ABSTRACT);
        ALL.add(RELATION_WITH_THE_COMPANY_1_OUTSIDE_DIRECTORS_20150401_CHECK);
        ALL.add(RELATION_WITH_THE_COMPANY_1_OUTSIDE_DIRECTORS_ABSTRACT);
        ALL.add(RELATION_WITH_THE_COMPANY_1_OUTSIDE_DIRECTORS_CHECK);
        ALL.add(RELATION_WITH_THE_COMPANY_20_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_20_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_2_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_2_OUTSIDE_CORPORATE_AUDITORS_ABSTRACT);
        ALL.add(RELATION_WITH_THE_COMPANY_2_OUTSIDE_CORPORATE_AUDITORS_CHECK);
        ALL.add(RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_ABSTRACT);
        ALL.add(RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_CAABSTRACT);
        ALL.add(RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_CACHECK);
        ALL.add(RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_CMABSTRACT);
        ALL.add(RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_CMCHECK);
        ALL.add(RELATION_WITH_THE_COMPANY_2_OUTSIDE_DIRECTORS_CHECK);
        ALL.add(RELATION_WITH_THE_COMPANY_3_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_3_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_4_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_4_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_5_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_5_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_6_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_6_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_7_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_7_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_8_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_8_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_9_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(RELATION_WITH_THE_COMPANY_9_OUTSIDE_DIRECTORS);
        ALL.add(RELATION_WITH_THE_COMPANY_OUTSIDE_CORPORATE_AUDITORS_ABSTRACT);
        ALL.add(RELATION_WITH_THE_COMPANY_OUTSIDE_DIRECTORS_ABSTRACT);
        ALL.add(REPORTING_DATE);
        ALL.add(REPRESENTATIVE_AUTHORITY);
        ALL.add(REPRESENTATIVE_STITLE_AND_NAME);
        ALL.add(RESPONSIBILITIES_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS);
        ALL.add(RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS_ABSTRACT);
        ALL.add(SAPPORO);
        ALL.add(SAPPORO_AMBITIOUS);
        ALL.add(SAPPORO_STOCK_EXCHANGE_PARENT_COMPANY);
        ALL.add(SAPPORO_TO_BE_LISTED);
        ALL.add(SCHEDULING_OF_SHAREHOLDERS_MEETING_AWAY_FROM_CONCENTRATED_DAYS_ABSTRACT);
        ALL.add(SECTOR);
        ALL.add(SECTOR_CHECK);
        ALL.add(SECURITIES_CODE);
        ALL.add(SECURITIES_CODE_OF_PARENT_COMPANY);
        ALL.add(SETTING_FORTH_PROVISIONS_IN_THE_INTERNAL_REGULATIONS_CONCERNING_RESPECT_FOR_THE_STAKEHOLDERS_POSITION_ABSTRACT);
        ALL.add(SPECIAL_NOTE_FOR_DESCRIPTION_OF_MAJOR_SHAREHOLDERS);
        ALL.add(SPECIAL_NOTE_FOR_DESCRIPTION_OF_MAJOR_SHAREHOLDERS_CHECK);
        ALL.add(SPOUSE_RELATIVES_WITHIN_THIRD_DEGREE_OF_CONSANGUINITY_OR_AN_EQUIVALENT_PERSON_OF_MANAGEMENT_LEVEL_SUCH_AS_MANAGEMENT_DIRECTOR_OR_EXECUTIVE_OFFICER_ETC_OF_THE_COMPANY_OR_SPECIFIC_AFFILIATES_OF_THE_COMPANY_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(SPOUSE_RELATIVES_WITHIN_THIRD_DEGREE_OF_CONSANGUINITY_OR_AN_EQUIVALENT_PERSON_OF_MANAGEMENT_LEVEL_SUCH_AS_MANAGEMENT_DIRECTOR_OR_EXECUTIVE_OFFICER_ETC_OF_THE_COMPANY_OR_SPECIFIC_AFFILIATES_OF_THE_COMPANY_OUTSIDE_DIRECTORS);
        ALL.add(STATUS_OF_ADDITIONAL_DUTIES_ABSTRACT);
        ALL.add(STATUS_OF_ADDITIONAL_DUTIES_CHECK);
        ALL.add(STATUS_OF_IMPLEMENTATION_OF_MEASURES_FOR_REVITALIZATION_OF_THE_SHAREHOLDERS_MEETING_AND_SMOOTHING_OF_THE_EXECUTION_OF_VOTING_RIGHTS_ABSTRACT);
        ALL.add(STATUS_OF_IMPLEMENTATION_OF_MEASURES_FOR_REVITALIZATION_OF_THE_SHAREHOLDERS_MEETING_AND_SMOOTHING_OF_THE_EXECUTION_OF_VOTING_RIGHTS_CHECK);
        ALL.add(STATUS_OF_THE_IMPLEMENTATION_OF_MEASURES_TO_GIVE_INCENTIVES_TO_DIRECTORS_AND_EXECUTIVE_OFFICERS_ABSTRACT);
        ALL.add(STATUS_OF_THE_IMPLEMENTATION_OF_MEASURES_TO_GIVE_INCENTIVES_TO_DIRECTORS_AND_EXECUTIVE_OFFICERS_CHECK);
        ALL.add(STOCK_OPTION_SYSTEM);
        ALL.add(STOCKEXCHANGE_ABSTRACT);
        ALL.add(STOCKEXCHANGE_AND_SECTION_CHECK);
        ALL.add(STOCKEXCHANGE_ANDSECTION_ABSTRACT);
        ALL.add(STOCKEXCHANGE_LISTING);
        ALL.add(SUPPLEMENTARY_INFORMATION_ANALYSTS_AND_INSTITUTIONAL_INVESTORS);
        ALL.add(SUPPLEMENTARY_INFORMATION_AVAILABILITY_OF_ENGLISH_TRANSLATION_OF_GENERAL_SHAREHOLDERS_MEETING_NOTICE);
        ALL.add(SUPPLEMENTARY_INFORMATION_CSR);
        ALL.add(SUPPLEMENTARY_INFORMATION_CONCENTRATED_DAYS);
        ALL.add(SUPPLEMENTARY_INFORMATION_DEFENSE_AGAINST_ATAKEOVER_BID);
        ALL.add(SUPPLEMENTARY_INFORMATION_DEFENSE_AGAINST_ATAKEOVER_BID_CHECK);
        ALL.add(SUPPLEMENTARY_INFORMATION_DIRECTORS);
        ALL.add(SUPPLEMENTARY_INFORMATION_DIRECTORS_CHECK);
        ALL.add(SUPPLEMENTARY_INFORMATION_DISCLOSURE_OF_INFORMATION);
        ALL.add(SUPPLEMENTARY_INFORMATION_DISCLOSURE_STATUS);
        ALL.add(SUPPLEMENTARY_INFORMATION_DISCLOSURE_STATUS_CHECK);
        ALL.add(SUPPLEMENTARY_INFORMATION_ELECTRONIC_EXECUTION);
        ALL.add(SUPPLEMENTARY_INFORMATION_FOREIGN_INVESTORS);
        ALL.add(SUPPLEMENTARY_INFORMATION_GRANTEES_OF_STOCK_OPTIONS);
        ALL.add(SUPPLEMENTARY_INFORMATION_GRANTEES_OF_STOCK_OPTIONS_CHECK);
        ALL.add(SUPPLEMENTARY_INFORMATION_IRDIVISIONS);
        ALL.add(SUPPLEMENTARY_INFORMATION_INCENTIVES);
        ALL.add(SUPPLEMENTARY_INFORMATION_INCENTIVES_CHECK);
        ALL.add(SUPPLEMENTARY_INFORMATION_INDIVIDUAL_INVESTORS);
        ALL.add(SUPPLEMENTARY_INFORMATION_INTERNAL_REGULATIONS);
        ALL.add(SUPPLEMENTARY_INFORMATION_OF_THE_ABOVE);
        ALL.add(SUPPLEMENTARY_INFORMATION_OF_THE_ABOVE_CHECK);
        ALL.add(SUPPLEMENTARY_INFORMATION_OTHER_IR);
        ALL.add(SUPPLEMENTARY_INFORMATION_OTHER_SHAREHOLDERS_MEETING);
        ALL.add(SUPPLEMENTARY_INFORMATION_OTHER_STAKEHOLDERS);
        ALL.add(SUPPLEMENTARY_INFORMATION_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(SUPPLEMENTARY_INFORMATION_OUTSIDE_DIRECTORS);
        ALL.add(SUPPLEMENTARY_INFORMATION_PARTICIPATION_IN_ELECTRONIC_VOTING_PLATFORMS_AND_OTHER_ACTIVITIES_TO_IMPROVE_VOTING_ENVIRONMENT_FOR_INSTITUTIONAL_INVESTORS);
        ALL.add(SUPPLEMENTARY_INFORMATION_PUBLIC_ANNOUNCEMENT_OF_DISCLOSURE_POLICY);
        ALL.add(SUPPLEMENTARY_INFORMATION_SHAREHOLDERS_MEETING);
        ALL.add(SUPPLEMENTARY_INFORMATION_WEBSITE);
        ALL.add(SUPPORT_SYSTEM_FOR_OUTSIDE_DIRECTORS_OUTSIDE_CORPORATE_AUDITORS);
        ALL.add(SUPPORT_SYSTEM_FOR_OUTSIDE_DIRECTORS_OUTSIDE_CORPORATE_AUDITORS_CHECK);
        ALL.add(TERM_RETIRED_PRESIDENTS_OR_CEOS_HOLDING_ADVISORY_POSITIONS);
        ALL.add(TOKYO_1ST_SECTION);
        ALL.add(TOKYO_2ND_SECTION);
        ALL.add(TOKYO_JASDAQ);
        ALL.add(TOKYO_MOTHERS);
        ALL.add(TOKYO_STOCK_EXCHANGE_PARENT_COMPANY);
        ALL.add(TOKYO_TO_BE_LISTED);
        ALL.add(URL);
    }
}
