package yokwe.security.japan.edinet;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.edinet.API.DocumentType;
import yokwe.util.FileUtil;

public class DownloadDocument {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadDocument.class);

	public static void main(String[] args) {
		logger.info("START");
		
		// Existing file map.  key is docID
		Map<String, File> dataFileMap = Document.getDataFileMap();
		logger.info("dataFileMap  {}", dataFileMap.size());
		
		List<Document> documentList = Document.getList().stream().
				filter(o -> (o.docTypeCode == DocumentType.ANNUAL_REPORT || o.docTypeCode == DocumentType.ANNUAL_REPORT || o.docTypeCode == DocumentType.ANNUAL_REPORT)).
				filter(o -> !dataFileMap.containsKey(o.docID)).
				collect(Collectors.toList());
		logger.info("documentList {}", documentList.size());
		Collections.shuffle(documentList);
		
		int count = 0;
		for(Document document: documentList) {
			if ((count % 100) == 0) {
				logger.info("{} {}", String.format("%5d / %5d", count, documentList.size()), document.docID);
			}
			count++;
			
			byte[] data = API.Document.getInstance(document.docID, API.Document.Type.WHOLE);
			if (data == null) {
				logger.info("download failed {}", document.docID);
			} else {
				File file = Document.getDataFile(document.submitDateTime.toLocalDate(), document.docID);
				FileUtil.rawWrite().file(file, data);
			}
		}
	
		logger.info("STOP");
	}
}
