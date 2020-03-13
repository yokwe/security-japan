package yokwe.security.japan.jpx;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.slf4j.LoggerFactory;

import yokwe.util.DownloadUtil;


public class DownloadStockPage {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadStockPage.class);
	
	public static final String PATH_DIR_DATA = "tmp/download/page";
	
	private static File getPageFile(String stockCode) {
		return new File(String.format("%s/%s", PATH_DIR_DATA, stockCode));
	}
	private static String getPageURL(String stockCode) {
		String stockCode4 = Stock.toStockCode4(stockCode);
		return String.format("https://quote.jpx.co.jp/jpx/template/quote.cgi?F=tmp/stock_detail&MKTN=T&QCODE=%s", stockCode4);
	}
	
	public static void main(String[] args) {
		logger.info("START");

		{
			int maxThread = 50;
			
			List<Header> headers = new ArrayList<>();
			headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36"));
			headers.add(new BasicHeader("Referer",    "https://www.jpx.co.jp/"));
			headers.add(new BasicHeader("Connection", "keep-alive"));

			LinkedList<DownloadUtil.Target> targetList = new LinkedList<>();
			for(Stock e: Stock.getList()) {
				String stockCode = e.stockCode;
				String url  = getPageURL(stockCode);
				File   file = getPageFile(stockCode);
				targetList.add(new DownloadUtil.Target(url, file));
			}
			Collections.shuffle(targetList);
			
			DownloadUtil.getInstance().withHeader(headers).withTarget(targetList).withMaxThread(maxThread).download();
		}

		logger.info("STOP");
	}

}
