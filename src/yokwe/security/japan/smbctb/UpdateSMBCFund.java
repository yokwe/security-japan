package yokwe.security.japan.smbctb;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.smbctb.screener.Screener;
import yokwe.security.japan.smbctb.screener.Security;
import yokwe.util.CSVUtil;
import yokwe.util.StringUtil;
import yokwe.util.http.HttpUtil;

public class UpdateSMBCFund {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateSMBCFund.class);
	
	public static final String FILE_PATH = "tmp/data/smbc/fund.csv";

	public static void main(String[] args) {
		logger.info("START");

		{
			HttpUtil.Result result = HttpUtil.getInstance().withRawData(true).download(Screener.URL);
			logger.info("result {} {} {} {}", result.code, result.reasonPhrase, result.version, result.rawData.length);

			Screener screener = JAXB.unmarshal(new ByteArrayInputStream(result.rawData), Screener.class);

			logger.info("screener {}", StringUtil.toString(screener));
			logger.info("securities {}", screener.securites.securityList.size());

			List<Security> list = new ArrayList<>();
			for (Security e : screener.securites.securityList) {
				if (e.isin == null) {
					logger.info("security  {}", e);
					continue;
				}
				list.add(e);
			}
			CSVUtil.write(Security.class).file(FILE_PATH, list);
		}

		logger.info("STOP");
	}

}
