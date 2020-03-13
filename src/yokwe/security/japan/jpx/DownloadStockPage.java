package yokwe.security.japan.jpx;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.slf4j.LoggerFactory;

import yokwe.security.japan.jpx.DownloadUtil.Target;

public class DownloadStockPage {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadStockPage.class);

//	private static class Target {
//		final String url;
//		final File   file;
//		
//		public Target(String url, File file) {
//			this.url  = url;
//			this.file = file;
//		}
//	}
	
	private static File getPageFile(String stockCode) {
		return new File(String.format("tmp/download/page/%s", stockCode));
	}
	private static String getPageURL(String stockCode) {
		String stockCode4 = Stock.toStockCode4(stockCode);
		return String.format("https://quote.jpx.co.jp/jpx/template/quote.cgi?F=tmp/stock_detail&MKTN=T&QCODE=%s", stockCode4);
	}
	
//	private static CloseableHttpClient getCloseableHttpClient(int maxTotal, int maxPerRoute, Collection<Header> headers) {
//		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
//		connectionManager.setDefaultMaxPerRoute(maxPerRoute);
//		connectionManager.setMaxTotal(maxTotal);
//		
//		HttpClientBuilder httpClientBuilder = HttpClients.custom();
//		httpClientBuilder.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build());
//		httpClientBuilder.setConnectionManager(connectionManager);
//		httpClientBuilder.setDefaultHeaders(headers);
//		
//		return httpClientBuilder.build();
//	}
//
//	public static class ResponseHandlerString implements ResponseHandler<String> {
//		private final Charset charset;
//		public ResponseHandlerString(Charset charset) {
//			this.charset = charset;
//		}
//		public ResponseHandlerString(String name) {
//			this(Charset.forName(name));
//		}
//		public ResponseHandlerString() {
//			this(StandardCharsets.UTF_8);
//		}
//		@Override
//		public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
//			StatusLine statusLine = response.getStatusLine();
//			
//	        switch(statusLine.getStatusCode()) {
//	        case HttpStatus.SC_OK:
//	        {
//	            HttpEntity entity = response.getEntity();
//	            if (entity == null) {
//	            	return null;
//	            } else {
//					return EntityUtils.toString(entity, charset);
//	            }
//	        }
//	        default:
//	        	logger.error("Unexpected status");
//	        	logger.error("  {}", statusLine);
//	        	throw new UnexpectedException("Unexpected status");
//	        }
//		}
//	}
//	
//	public static class ResponseHandlerSave implements ResponseHandler<Void> {
//		private final OutputStream os;
//		public ResponseHandlerSave(OutputStream os) {
//			this.os = os;
//		}
//		public ResponseHandlerSave(File file) {
//			{
//				File parent = file.getParentFile();
//				if (!parent.exists()) {
//					parent.mkdirs();
//				}
//			}
//			try {
//				this.os = new FileOutputStream(file);
//			} catch (FileNotFoundException e) {
//				String exceptionName = e.getClass().getSimpleName();
//				logger.error("{} {}", exceptionName, e);
//				throw new UnexpectedException(exceptionName, e);
//			}
//		}
//		public ResponseHandlerSave(String path) {
//			this(new File(path));
//		}
//		@Override
//		public Void handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
//			StatusLine statusLine = response.getStatusLine();
//			
//	        switch(statusLine.getStatusCode()) {
//	        case HttpStatus.SC_OK:
//	        {
//	            HttpEntity entity = response.getEntity();
//	            if (entity == null) {
//	            	return null;
//	            } else {
//	                InputStream is = entity.getContent();
//	                if (is == null) {
//	                    return null;
//	                }
//	                try {
//	                    byte[] buffer = new byte[4096];
//	                    for(;;) {
//	                    	int len = is.read(buffer);
//	                    	if (len == -1) break;
//	                    	os.write(buffer, 0, len);
//	                    }
//	                    return null;
//	                } finally {
//	                    is.close();
//	                    os.close();
//	                }
//	            }
//	        }
//	        default:
//	        	logger.error("Unexpected status");
//	        	logger.error("  {}", statusLine);
//	        	throw new UnexpectedException("Unexpected status");
//	        }
//		}
//	}
//
//	private static class WorkerThread extends Thread {		
//		private CloseableHttpClient closeableHttpClient;
//		private LinkedList<Target>  list;
//		private int                 listSize;
//		
//		public WorkerThread(String name, CloseableHttpClient closeableHttpClient, LinkedList<Target> list) {
//			super(name);
//			this.closeableHttpClient = closeableHttpClient;
//			this.list                = list;
//			this.listSize            = list.size();
//		}
//		
//		@Override
//		public void run() {
//			for(;;) {
//				Target target;
//				synchronized(list) {
//					if (list.isEmpty()) break;
//					int count = list.size();
//					target = list.poll();
//					
//					if ((count % 100) == 0) {
//						logger.info("{}", String.format("%4d / %4d  %s", count, listSize, target.file.getName()));
//					}
//				}
//				download(target);
//			}
//		}
//		
//		private void download(Target target) {			
//			HttpGet httpGet = new HttpGet(target.url);
//			try {
////				{
////					ResponseHandler<Void> responseHandler = new ResponseHandlerSave(target.file);
////					closeableHttpClient.execute(httpGet, responseHandler);
////				}
//				
//				{
//					ResponseHandler<String> responseHandler = new ResponseHandlerString();
//					String result = closeableHttpClient.execute(httpGet, responseHandler);
//					if (result != null) {
//						String page = StringUtil.unescapceHTMLChar(closeableHttpClient.execute(httpGet, responseHandler));
//						FileUtil.write().file(target.file, page);
//					} else {
//						logger.warn("result == null  {}", target.file.getName());
//					}
//				}
//				
//			} catch (IOException e) {
//				String exceptionName = e.getClass().getSimpleName();
//				logger.error("{} {}", exceptionName, e);
//				throw new UnexpectedException(exceptionName, e);
//			}
//		}
//	}
//	
//	private static class WorkerThreadGroup {
//		final List<Header>       headers;
//		final LinkedList<Target> list;
//		
//		WorkerThread[] workerThreads = null;
//		
//		public WorkerThreadGroup(List<Header> headers, LinkedList<Target> list) {
//			this.headers = headers;
//			this.list    = list;
//		}
//
//		public void start(int maxThread) {
//			logger.info("maxThread {}", maxThread);
//			CloseableHttpClient closeableHttpClient = getCloseableHttpClient(maxThread, maxThread, headers);
//			uworkerThreads = new WorkerThread[maxThread];
//			
//			try {
//				// prepare thread
//				for(int i = 0; i < workerThreads.length; i++) {
//					workerThreads[i] = new WorkerThread(String.format("THREAD-%03d", i), closeableHttpClient, list);
//				}
//				
//				// start thread
//				Thread.sleep(500);
//				for(int i = 0; i < workerThreads.length; i++) {
//					workerThreads[i].start();
//				}
//
//				// wait thread
//				for(int i = 0; i < workerThreads.length; i++) {
//					workerThreads[i].join();
//				}
//			} catch (InterruptedException e) {
//				String exceptionName = e.getClass().getSimpleName();
//				logger.error("{} {}", exceptionName, e);
//				throw new UnexpectedException(exceptionName, e);
//			}
//		}
//	}
	public static void main(String[] args) {
		logger.info("START");

		{
			int maxThread = 50;
			
			List<Header> headers = new ArrayList<>();
			headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36"));
			headers.add(new BasicHeader("Referer",    "https://www.jpx.co.jp/"));
			headers.add(new BasicHeader("Connection", "keep-alive"));

			LinkedList<Target> targetList = new LinkedList<>();
			for(Stock e: Stock.getList()) {
				String stockCode = e.stockCode;
				String url  = getPageURL(stockCode);
				File   file = getPageFile(stockCode);
				targetList.add(new Target(url, file));
			}
			Collections.shuffle(targetList);
			
			DownloadUtil.getInstance().withHeader(headers).withTarget(targetList).withMaxThread(maxThread).download();
		}
		
//		WorkerThreadGroup workThreadGroup = new WorkerThreadGroup(headers, targetList);
//		workThreadGroup.start(maxThread);

		logger.info("STOP");
	}

}
