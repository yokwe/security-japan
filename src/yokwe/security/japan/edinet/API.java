package yokwe.security.japan.edinet;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.json.JsonObject;

import org.slf4j.LoggerFactory;

import yokwe.util.json.JSONBase;

public class API {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(API.class);

	public static final String URL_BASE = "https://disclosure.edinet-fsa.go.jp/api";
	
	enum Version {
		V1("v1");
		
		final String value;
		
		Version(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
	
	public static class List {
		enum Type {
			METADATA("1"),
			DATA    ("2");
			
			final String value;
			
			Type(String value) {
				this.value = value;
			}
			
			@Override
			public String toString() {
				return value;
			}
		}

		public static String getURL(Version version, LocalDate date, Type type) {
			return String.format("%s/%s/documents.json?date=%s&type=%s", URL_BASE, version.value, date.toString(), type.value);
		}
		
		public static class Metadata extends JSONBase {
			public static class Parameter extends JSONBase {
				public LocalDate date;
				public API.List.Type    type;
				
				public Parameter() {
					this.date = null;
					this.type = null;
				}
				public Parameter(JsonObject jsonObject) {
					super(jsonObject);
				}
			}
			public static class ResultSet extends JSONBase {
				public int count;
				
				public ResultSet() {
					this.count = 0;
				}
				public ResultSet(JsonObject jsonObject) {
					super(jsonObject);
				}
			}
			
			public static enum Status {
				OK                   ("200"),
				BAD_REQUEST          ("400"),
				NOT_FOUND            ("404"),
				INTERNAL_SERVER_ERROR("500");
				
				public final String value;
				
				Status(String value) {
					this.value = value;
				}
				
				@Override
				public String toString() {
					return value;
				}
			}
			
			public String        title;
			public Parameter     parameter;
			@JSONName("resultset")
			public ResultSet     resultSet;
			@DateTimeFormat("yyyy-MM-dd HH:mm")
			public LocalDateTime processDateTime;
			public Status        status;
			public String        message;
			
			public Metadata() {
				this.title           = null;
				this.parameter       = null;
				this.resultSet       = null;
				this.processDateTime = null;
				this.status          = null;
				this.message         = null;
			}
			public Metadata(JsonObject jsonObject) {
				super(jsonObject);
			}
			
		}

		public static class Result extends JSONBase {
			public int    seqNumber;
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
		    	this.seqNumber            = 0;
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

		public static class Response extends JSONBase {
			public Metadata metadata;
			public Result[] results;
			
			public Response() {
				this.metadata = null;
				this.results  = null;
			}
			public Response(JsonObject jsonObject) {
				super(jsonObject);
			}
		}
		
		public static Response getInstance(Version version, LocalDate date, Type type) {
			String url = getURL(version, date, type);
			Response response = JSONBase.getObject(url, Response.class);
			return response;
		}
		public static Response getInstance(LocalDate date, Type type) {
			return getInstance(Version.V1, date, type);
		}
	}
	
	
	public static void main(String[] args) {
		logger.info("START");
		
		List.Response response = List.getInstance(LocalDate.now(), List.Type.DATA);
		logger.info("response {}", response);
		
		logger.info("STOP");
	}
			
}
