package yokwe.security.japan.edinet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.edinet.API.ListDocument;

public class UpdateDocument {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateDocument.class);

	public static void main(String[] args) {
		logger.info("START");
		
		Map<String, Document> map = Document.getMap();
		
		LocalDate today = LocalDate.now();
		LocalDate date = today.minusYears(5).plusDays(1);
		
		int count = 0;
		for(;;) {
			if (date.isAfter(today)) break;
			
			ListDocument.Response response = ListDocument.getInstance(date, ListDocument.Type.DATA);
			logger.info("{}  {}", date, String.format("%4d", response.results.length));
//			logger.info("response {}", response);
			for(ListDocument.Result e: response.results) {
				if (e.edinetCode.isEmpty()) continue;
				
				if (e.docTypeCode == null) {
					logger.error("docTypeCode is null");
					logger.error("  {}", e.toString());
					logger.error("e.edinetCode {}", e.edinetCode);
					throw new UnexpectedException("docTypeCode is null");
				}
				
				String docID = e.docID;
				if (!map.containsKey(docID)) {
					Document document = new Document(
							e.docID,
							e.edinetCode,
							e.stockCode,
							e.fundCode,

							e.docTypeCode,

							e.submitDateTime);
					map.put(docID, document);

					if (++count == 10000) {
						count = 0;
						List<Document> list = new ArrayList<>(map.values());
						logger.info("save {} {}", Document.PATH_FILE, list.size());
						Document.save(list);
					}
				}
			}
			date = date.plusDays(1);
		}
		
		{
			List<Document> list = new ArrayList<>(map.values());
			logger.info("save {} {}", Document.PATH_FILE, list.size());
			Document.save(list);
		}
		
		logger.info("STOP");
	}
}
