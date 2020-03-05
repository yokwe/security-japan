package yokwe.security.japan.edinet;

import java.time.LocalDate;

import javax.json.JsonObject;

import org.slf4j.LoggerFactory;

import yokwe.util.HttpUtil;
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
	
	enum Type {
		METADATA("1"),
		DATA("2");
		
		final String value;
		
		Type(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
	
	//v1/documents.json?date=2019-04-01
	public static String getURL(Version version, LocalDate date, Type type) {
		return String.format("%s/%s/documents.json?date=%s&type=%s", URL_BASE, version.value, date.toString(), type.value);
	}
	public static String getURL(LocalDate date, Type type) {
		return getURL(Version.V1, date, type);
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
	
	public static void main(String[] args) {
		logger.info("START");
		
		String url = API.getURL(LocalDate.now(), Type.DATA);
		logger.info("url {}", url);
		
		HttpUtil.Result httpResult = HttpUtil.getInstance().download(url);
		logger.info("httpResult {}", httpResult.result);
		
		Response response = JSONBase.getObject(url, Response.class);
		logger.info("response {}", response);
		
		logger.info("STOP");
	}
			
}
