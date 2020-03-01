package yokwe.security.japan.ufocatch;

import java.io.File;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXB;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.jpx.tdnet.SummaryFilename;
import yokwe.security.japan.jpx.tdnet.TDNET;
import yokwe.security.japan.ufocatch.atom.Feed;
import yokwe.util.FileUtil;
import yokwe.util.HttpUtil;

public class Atom {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(Atom.class);

	public static boolean downloadExists(SummaryFilename filename) {
		String path = TDNET.getPath(filename);
		File   file = new File(path);
		return file.exists();
	}
	public static String download(String href, SummaryFilename filename) {
		String path = TDNET.getPath(filename);
		File   file = new File(path);
		if (file.exists()) {
			return FileUtil.read().file(file);
		} else {
			HttpUtil.Result result = HttpUtil.getInstance().download(href);
			if (result.result != null) {
				FileUtil.write().file(file, result.result);
			}
			return result.result;
		}
	}
	
	public static final String URL_BASE   = "https://resource.ufocatch.com/atom";
	
	public static String query(Kind kind) {
		// GET /atom/{種別}
		String url = String.format("%s/%s", URL_BASE, kind.url);
		HttpUtil.Result result = HttpUtil.getInstance().download(url);
		return result.result;
	}
	public static Feed getFeed(Kind kind) {
		// GET /atom/{種別}
		String url = String.format("%s/%s", URL_BASE, kind.url);
		return getFeed(url);
	}
	public static Feed getFeed(String url) {
		HttpUtil.Result result = HttpUtil.getInstance().download(url);
		Feed ret = JAXB.unmarshal(new StringReader(result.result), Feed.class);
		return ret;
	}
	
	public static byte[] downloadPDF(String tdid) {
		String referer = String.format("https://resource.ufocatch.com/pdfpage/%s", tdid);
		String target  = String.format("https://resource.ufocatch.com/pdf/tdnet/%s", tdid);
		
		HttpUtil.Result result = HttpUtil.getInstance().withReferer(referer).withRawData(true).download(target);
		return result.rawData;
	}

	private static final Pattern PAT_TDID = Pattern.compile(".+/(TD[0-9]{13})$");
	public static String getTDIDFromURL(String url) {
		Matcher m = PAT_TDID.matcher(url);
		if (m.matches()) {
			String tdid = m.group(1);
			return tdid;
		} else {
			logger.error("Unexpected url {}", url);
			throw new UnexpectedException("Unexpected url");
		}
	}
	private static final Pattern PAT_STOCK_CODE = Pattern.compile("【([0-9]{5})】.+");
	public static String getStockCodeFromTitle(String title) {
		Matcher m = PAT_STOCK_CODE.matcher(title);
		if (m.matches()) {
			String stockCode = m.group(1);
			if (stockCode.endsWith("0")) {
				stockCode = stockCode.substring(0, stockCode.length() - 1);
			}
			return stockCode;
		} else {
			logger.error("Unexpected title {}", title);
			throw new UnexpectedException("Unexpected title");
		}
	}
	
}
