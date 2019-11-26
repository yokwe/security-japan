package yokwe.security.japan.ufocatch;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.HttpUtil;

public class Atom {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Atom.class);

	public static final String URL_BASE   = "https://resource.ufocatch.com/atom";
	
	public static enum Kind {
		EDINET ("edinet"),  // EDINET情報配信サービス
		EDINETX("edinetx"), // EDINET情報配信サービス(XBRL情報があるもの)
		TDNET  ("tdnet"),   // 適時開示情報配信サービス
		TDNETX ("tdnetx"),  // 適時開示情報配信サービス(XBRL情報があるもの)
		CG     ("cg");      // コーポレート・ガバナンス情報配信サービス
		
		public final String url;
		Kind(String url) {
			this.url = url;
		}
	}

	// DividendPerShare
	public static String query(Kind kind, String query) {
		// GET /atom/{種別}/query/{クエリワード}
		try {
			String url = String.format("%s/%s/query/%s", URL_BASE, kind.url, URLEncoder.encode(query, "UTF-8"));
			HttpUtil.Result result = HttpUtil.getInstance().download(url);
			return result.result;
		} catch (UnsupportedEncodingException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
	}
}
