package yokwe.security.japan.jpx;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.data.Price;
import yokwe.util.DownloadUtil;
import yokwe.util.FileUtil;


public class DownloadStockPage {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadStockPage.class);
	
	private static void delist() {
		List<Stock> list = Stock.getList();
		Set<String> stockCodeSet = list.stream().map(o -> o.stockCode).collect(Collectors.toSet());
		
		List<File> fileList = FileUtil.listFile(new File(Price.PATH_DIR_DATA));
		
		File dirDeslist = new File(Price.PATH_DIR_DATA_DELIST);
		if (!dirDeslist.exists()) {
			dirDeslist.mkdirs();
		}
		
		String suffix;
		{
			LocalDateTime localDateTime = LocalDateTime.now();
			suffix = String.format("%4d%02d%02d-%02d%02d%02d",
					localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(),
					localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond());
		}
		
		try {
			for(File file: fileList) {
				String stockCode = file.getName().replace(".csv", "");
				if (!stockCodeSet.contains(stockCode)) {
					// move file to delist
					File newFile = new File(dirDeslist, String.format("%s.csv-%s", stockCode, suffix));
					
					logger.info("delist {} -> {}",file.getPath(), newFile.getPath());
					Files.move(file.toPath(), newFile.toPath());
				}
			}
		} catch (IOException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
	}
	
	public static void main(String[] args) {
		logger.info("START");

		// delist obsolete price file
		delist();

		// download
		{
			int maxThread = 50;
			
			List<Header> headers = new ArrayList<>();
			headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36"));
			headers.add(new BasicHeader("Referer",    "https://www.jpx.co.jp/"));
			headers.add(new BasicHeader("Connection", "keep-alive"));
			
			Consumer<DownloadUtil.FileTarget> nullFileAction  = o -> {};

			List<DownloadUtil.Target> targetList = new ArrayList<>();
			for(Stock e: Stock.getList()) {
				String stockCode = e.stockCode;
				String url  = StockPage.getPageURL(stockCode);
				targetList.add(new DownloadUtil.TextFileTarget(url, nullFileAction, StockPage.getPageFile(stockCode)));
			}
			Collections.shuffle(targetList);
			
//			// Test code
//			{
//				Consumer<DownloadUtil.FileTarget>      textFileAction  = o -> {logger.info("textFile   {}", String.format("%5d %s", o.getFile().length(), o.getURL()));};
//				Consumer<DownloadUtil.FileTarget>      binaryileAction = o -> {logger.info("binaryFile {}", String.format("%5d %s", o.getFile().length(), o.getURL()));};
//				Consumer<DownloadUtil.StringTarget>    stringAction    = o -> {logger.info("string     {}", String.format("%5d %s", o.getString().length(), o.getURL()));};
////				Consumer<DownloadUtil.StringTarget>    stringAction    = o -> {logger.info("string     {}", String.format("%5d %s", o.getString().getBytes(StandardCharsets.UTF_8).length, o.getURL()));};
//				Consumer<DownloadUtil.ByteArrayTarget> byteArrayAction = o -> {logger.info("byteArray  {}", String.format("%5d %s", o.getByteArray().length, o.getURL()));};
//
//				targetList.clear();
//				
//				String url = "https://mxp1.monex.co.jp/mst/servlet/ITS/ucu/UsSymbolSearchGST";
//				targetList.add(new DownloadUtil.TextFileTarget(url, textFileAction, new File("tmp/a")));
//				targetList.add(new DownloadUtil.BinaryFileTarget(url, binaryileAction, new File("tmp/a")));
//				targetList.add(new DownloadUtil.StringTarget(url, stringAction));
//				targetList.add(new DownloadUtil.ByteArrayTarget(url, byteArrayAction));
//			}
			
			DownloadUtil.getInstance().withHeader(headers).withTarget(targetList).withMaxThread(maxThread).download();
		}

		logger.info("STOP");
	}

}
