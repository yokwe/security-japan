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
				String url  = StockPage.getPageURL(stockCode);
				File   file = StockPage.getPageFile(stockCode);
				targetList.add(new DownloadUtil.Target(url, file));
			}
			Collections.shuffle(targetList);
			
			DownloadUtil.getInstance().withHeader(headers).withTarget(targetList).withMaxThread(maxThread).download();
		}

		logger.info("STOP");
	}

}
