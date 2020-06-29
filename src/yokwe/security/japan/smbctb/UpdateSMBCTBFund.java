package yokwe.security.japan.smbctb;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.smbctb.Screener.Rows;
import yokwe.util.CSVUtil;
import yokwe.util.http.HttpUtil;
import yokwe.util.json.JSON;

public class UpdateSMBCTBFund {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateSMBCTBFund.class);
	
	
	public static final String URL_SCREENER_BASE = "https://lt.morningstar.com/api/rest.svc/smbctbfund/security/screener";
	public static final String URL_SCREENER;
	static {
		try {
			URL_SCREENER = new URIBuilder(URL_SCREENER_BASE).
					addParameter("page",               "1").
					addParameter("pageSize",           "1000").
					addParameter("outputType",         "json").
					addParameter("languageId",         "ja-JP").
					addParameter("securityDataPoints", "secId|isin|customInstitutionSecurityId|customFundName|currencyId").
					build().toASCIIString();
		} catch (URISyntaxException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
	}

	public static final String FILE_PATH = "tmp/data/smbc/fund.csv";

	public static void main(String[] args) {
		logger.info("START");

		logger.info("url {}", URL_SCREENER);
		
		HttpUtil.Result result = HttpUtil.getInstance().download(URL_SCREENER);
		logger.info("result {} {} {} {}", result.code, result.reasonPhrase, result.version, result.rawData.length);

		Screener screener = JSON.unmarshal(Screener.class, result.result);

		logger.info("screener {}", screener);
		logger.info("rows     {}", screener.rows.length);

		List<Rows> list = new ArrayList<>();
		for (var e : screener.rows) {
			list.add(e);
		}
		logger.info("save {} {}", list.size(), FILE_PATH);
		CSVUtil.write(Rows.class).file(FILE_PATH, list);

		logger.info("STOP");
	}

}
