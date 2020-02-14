package yokwe.security.japan.ufocatch;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.jpx.Stock;
import yokwe.security.japan.ufocatch.atom.Entry;
import yokwe.security.japan.ufocatch.atom.Feed;
import yokwe.security.japan.ufocatch.atom.Link;
import yokwe.util.FileUtil;
import yokwe.util.HashCode;
import yokwe.util.StringUtil;

//
// Download PDF that relate to ETF dividend 
//

public class DownloadETFPDF {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadETFPDF.class);
	
	private static final String DIR_BASE_ETF  = "tmp/ufocatch/pdf/etf";
	
	public static String getPathETF(String tdid) {
		return String.format("%s/%s.pdf", DIR_BASE_ETF, tdid);
	}

	public static void main(String[] args) {
		logger.info("START");
		
		Map<String, Stock> stockMap = Stock.getMap();
		
		Kind kind = Kind.TDNET;
		Feed feed = Atom.getFeed(kind);
		
		// Build md5Set
		Set<String> md5SetETF;
		{
			List<File> fileList = FileUtil.listFile(DIR_BASE_ETF);
			md5SetETF = FileUtil.md5Set(fileList);
			logger.info("md5SetETF {}  {}", md5SetETF.size(), fileList.size());
		}
		
		for(;;) {
			String selfString;
			String lastString;
			{
				Link self = feed.linkMap.get(Link.Relation.SELF);
				Link last = feed.linkMap.get(Link.Relation.LAST);

				selfString = self.href.substring(self.href.lastIndexOf("/") + 1);
				lastString = last.href.substring(last.href.lastIndexOf("/") + 1);
			}
			logger.info("{} {}", kind.url, String.format("%3s / %3s", selfString, lastString));
			
			for(Entry entry: feed.entryList) {
				String title     = entry.title;
				String stockCode = Atom.getStockCodeFromTitle(title);
				
				{
					if (stockMap.containsKey(stockCode)) {
						Stock stock = stockMap.get(stockCode);
						if (stock.isETF()) {
							// 分配金確定のお知らせ
							// 収益分配のお知らせ
							// 分配金に係るお知らせ
							// 投資分配金に関するお知らせ
							if (title.contains("見込"))                    continue;
							if (title.contains("基準日"))                   continue;
							if (title.contains("支払計画のないことのお知らせ")) continue;
							if (title.contains("支払開始日確定のお知らせ"))    continue;
							
							if (title.contains("分配")) {
//								logger.info("TITLE  {}", title);
								for(Link link: entry.linkList) {
//									logger.info("  LINK {}", link);
									String tdid = Atom.getTDIDFromURL(link.href);
									String path = getPathETF(tdid);
									File file = new File(path);
									if (file.exists()) {
										// already download as same filename
										logger.info("{} skip     {}", tdid, title);
									} else {
										logger.info("{} download {}", tdid, title);
										byte[] content = Atom.downloadPDF(tdid);
										String md5 = StringUtil.toHexString(HashCode.getHashCode(content));
										md5SetETF.add(md5);
										FileUtil.rawWrite().file(file, content);
									}
								}
							} else {
								// not interested title
								continue;
							}
						} else {
							// not ETF
							continue;
						}
					} else {
						// Unknown stockCode
						continue;
					}
				}
			}
			if (feed.linkMap.containsKey(Link.Relation.NEXT)) {
				feed = Atom.getFeed(feed.linkMap.get(Link.Relation.NEXT).href);
				continue;
			}
			break;
		}
		
		logger.info("STOP");
	}
}
