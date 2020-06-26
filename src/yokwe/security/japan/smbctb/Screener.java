package yokwe.security.japan.smbctb;

import java.net.URISyntaxException;

import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.StringUtil;

//See below for parameters of query
//  https://asialt.morningstar.com/quikr/smbctb/configurations/fund-screener/config.json

public class Screener {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(Screener.class);

	public static final String URL_SCREENER = "https://lt.morningstar.com/api/rest.svc/smbctbfund/security/screener";
	public static final String URL;
	static {
		try {
			URL = new URIBuilder(URL_SCREENER).
					addParameter("page",               "1").
					addParameter("pageSize",           "1000").
					addParameter("outputType",         "json").
					addParameter("languageId",         "ja-JP").
					addParameter("securityDataPoints", "secId|isin|customInstitutionSecurityId|customFundName").
					build().toASCIIString();
		} catch (URISyntaxException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
	}
	
	public static class Row {
		public String secId;
		public String isin;
		public String customInstitutionSecurityId;
		public String customFundName;
		
		@Override
		public String toString() {
			return StringUtil.toString(this);
		}
	}
	
	public int total;
	public int page;
	public int pageSize;
	
	public Row[] rows;
	
	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
