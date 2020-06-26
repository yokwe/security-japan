package yokwe.security.japan.smbctb;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.smbctb.Screener.Row;
import yokwe.util.CSVUtil;
import yokwe.util.http.HttpUtil;
import yokwe.util.json.JSON;

public class UpdateSMBCTBFund {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateSMBCTBFund.class);
	
	public static final String FILE_PATH = "tmp/data/smbc/fund.csv";

	public static void main(String[] args) {
		logger.info("START");

		logger.info("url {}", Screener.URL);
		
		HttpUtil.Result result = HttpUtil.getInstance().download(Screener.URL);
		logger.info("result {} {} {} {}", result.code, result.reasonPhrase, result.version, result.rawData.length);

		Screener screener = JSON.unmarshal(Screener.class, result.result);

		logger.info("screener {}", screener);
		logger.info("rows     {}", screener.rows.length);

		List<Row> list = new ArrayList<>();
		for (var e : screener.rows) {
			list.add(e);
		}
		logger.info("save {} {}", list.size(), FILE_PATH);
		CSVUtil.write(Row.class).file(FILE_PATH, list);

		logger.info("STOP");
	}

}
