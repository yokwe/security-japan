package yokwe.security.japan.edinet;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.json.JsonObject;

import yokwe.util.json.JSONBase;

public class Metadata extends JSONBase {
	public static class Parameter extends JSONBase {
		public LocalDate date;
		public String type;
		
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
	
	public String        title;
	public Parameter     parameter;
	@JSONName("resultset")
	public ResultSet     resultSet;
	@DateTimeFormat("yyyy-MM-dd HH:mm")
	public LocalDateTime processDateTime;
	public String        status;
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
