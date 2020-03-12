package yokwe.security.japan.jpx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.FileUtil;
import yokwe.util.StringUtil;

public class DownloadStockPage {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadStockPage.class);

	private static final int MAX_WORKER_THREAD = 50;
	
	private static final String REFERER    = "https://www.jpx.co.jp/";
	private static final String CONNECTION = "keep-alive";
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36";

	private static final List<Header> HEADERS = new ArrayList<>();
	static {
		HEADERS.add(new BasicHeader("User-Agent", USER_AGENT));
		HEADERS.add(new BasicHeader("Referer",    REFERER));
		HEADERS.add(new BasicHeader("Connection", CONNECTION));
	}
	
	private static class Target {
		final String url;
		final File   file;
		
		public Target(String url, File file) {
			this.url  = url;
			this.file = file;
		}
	}
	
	private static File getPageFile(String stockCode) {
		return new File(String.format("tmp/download/page/%s", stockCode));
	}
	private static String getPageURL(String stockCode) {
		String stockCode4 = Stock.toStockCode4(stockCode);
		return String.format("https://quote.jpx.co.jp/jpx/template/quote.cgi?F=tmp/stock_detail&MKTN=T&QCODE=%s", stockCode4);
	}
	
	private static CloseableHttpClient getCloseableHttpClient(int maxTotal, int maxPerRoute, Collection<Header> headers) {
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setDefaultMaxPerRoute(maxPerRoute);
		connectionManager.setMaxTotal(maxTotal);
		
		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		httpClientBuilder.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build());
		httpClientBuilder.setConnectionManager(connectionManager);
		httpClientBuilder.setDefaultHeaders(headers);
		
		return httpClientBuilder.build();
	}

	private static class WorkerThread extends Thread {
		private static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			@Override
			public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				StatusLine statusLine = response.getStatusLine();
				
		        switch(statusLine.getStatusCode()) {
		        case HttpStatus.SC_OK:
		        {
		            HttpEntity entity = response.getEntity();
		            return entity != null ? EntityUtils.toString(entity) : null;
		        }
		        default:
		        	logger.error("Unexpected status");
		        	logger.error("  {}", statusLine);
		        	throw new UnexpectedException("Unexpected status");
		        }
			}
		};
		
		private CloseableHttpClient closeableHttpClient;
		private LinkedList<Target>  list;
		private int                 listSize;
		
		public WorkerThread(String name, CloseableHttpClient closeableHttpClient, LinkedList<Target> list) {
			super(name);
			this.closeableHttpClient = closeableHttpClient;
			this.list                = list;
			this.listSize            = list.size();
		}
		
		@Override
		public void run() {
			for(;;) {
				Target target;
				synchronized(list) {
					if (list.isEmpty()) break;
					int count = list.size();
					target = list.poll();
					
					if ((count % 100) == 0) {
						logger.info("{}", String.format("%4d / %4d  %s", count, listSize, target.file.getName()));
					}
				}
				download(target);
			}
		}
		
		private void download(Target target) {			
			HttpGet httpGet = new HttpGet(target.url);
			try {
				String result = closeableHttpClient.execute(httpGet, responseHandler);
				if (result != null) {
					String page = StringUtil.unescapceHTMLChar(closeableHttpClient.execute(httpGet, responseHandler));
					FileUtil.write().file(target.file, page);
				} else {
					logger.warn("result == null  {}", target.file.getName());
				}
			} catch (IOException e) {
				String exceptionName = e.getClass().getSimpleName();
				logger.error("{} {}", exceptionName, e);
				throw new UnexpectedException(exceptionName, e);
			}
		}
	}
	
	private static class WorkThreadGroup {
		final CloseableHttpClient closeableHttpClient;
		final LinkedList<Target> list;
		
		WorkerThread[] workerThreads = null;
		
		public WorkThreadGroup(CloseableHttpClient closeableHttpClient, LinkedList<Target> list) {
			this.closeableHttpClient = closeableHttpClient;
			this.list = list;
		}

		public void start(int maxThread) {
			logger.info("maxThread {}", maxThread);
			workerThreads = new WorkerThread[maxThread];
			
			try {
				// prepare thread
				for(int i = 0; i < workerThreads.length; i++) {
					workerThreads[i] = new WorkerThread(String.format("THREAD-%03d", i), closeableHttpClient, list);
				}
				
				// start thread
				Thread.sleep(500);
				for(int i = 0; i < workerThreads.length; i++) {
					workerThreads[i].start();
				}

				// wait thread
				for(int i = 0; i < workerThreads.length; i++) {
					workerThreads[i].join();
				}
			} catch (InterruptedException e) {
				String exceptionName = e.getClass().getSimpleName();
				logger.error("{} {}", exceptionName, e);
				throw new UnexpectedException(exceptionName, e);
			}
		}
	}
	public static void main(String[] args) {
		logger.info("START");

		LinkedList<Target> targetList = new LinkedList<>();
		for(Stock e: Stock.getList()) {
			String stockCode = e.stockCode;
			String url  = getPageURL(stockCode);
			File   file = getPageFile(stockCode);
			targetList.add(new Target(url, file));
		}
		Collections.shuffle(targetList);
		
		CloseableHttpClient closeableHttpClient = getCloseableHttpClient(MAX_WORKER_THREAD, MAX_WORKER_THREAD, HEADERS);
		
		WorkThreadGroup workThreadGroup = new WorkThreadGroup(closeableHttpClient, targetList);
		workThreadGroup.start(MAX_WORKER_THREAD);

		logger.info("STOP");
	}

}
