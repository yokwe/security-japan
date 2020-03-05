package yokwe.security.japan.edinet;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.json.JsonObject;

import yokwe.util.json.JSONBase;

public class Result extends JSONBase {
	public String seqNumber;
	public String docID;
	public String edinetCode;
	public String secCode;
	public String JCN;
	public String filerName;
	public String fundCode;
	public String ordinanceCode;
	public String formCode;
	public String docTypeCode;
	public LocalDate periodStart;
	public LocalDate periodEnd;
	@DateTimeFormat("yyyy-MM-dd HH:mm")
	public LocalDateTime submitDateTime;
	public String docDescription;
	public String issuerEdinetCode;
	public String subjectEdinetCode;
	public String subsidiaryEdinetCode;
	public String currentReportReason;
	public String parentDocID;
	public String opeDateTime;
	public String withdrawalStatus;
	public String docInfoEditStatus;
	public String disclosureStatus;
	public String xbrlFlag;
	public String pdfFlag;
	public String attachDocFlag;
	public String englishDocFlag;
	
	public Result() {
    	this.seqNumber            = null;
    	this.docID                = null;
    	this.edinetCode           = null;
    	this.secCode              = null;
    	this.JCN                  = null;
    	this.filerName            = null;
		this.fundCode             = null;
		this.ordinanceCode        = null;
		this.formCode             = null;
		this.docTypeCode          = null;
		this.periodStart          = null;
		this.periodEnd            = null;
		this.submitDateTime       = null;
		this.docDescription       = null;
		this.issuerEdinetCode     = null;
		this.subjectEdinetCode    = null;
		this.subsidiaryEdinetCode = null;
		this.currentReportReason  = null;
		this.parentDocID          = null;
		this.opeDateTime          = null;
		this.withdrawalStatus     = null;
		this.docInfoEditStatus    = null;
		this.disclosureStatus     = null;
		this.xbrlFlag             = null;
		this.pdfFlag              = null;
		this.attachDocFlag        = null;
		this.englishDocFlag       = null;
	}
	
	public Result(JsonObject jsonObject) {
		super(jsonObject);
	}

}
