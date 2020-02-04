package yokwe.security.japan.ufocatch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.JAXBException;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.jpx.Category;
import yokwe.security.japan.xbrl.InlineXBRL;
import yokwe.util.StringUtil;
import yokwe.util.XMLUtil;

public class GenerateContext {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(GenerateContext.class);
		
	public static void main(String[] args) throws IOException, JAXBException {
		logger.info("START");
		
		Set<String> all = new TreeSet<>();
		
		for(File file : Atom.getFileList(Category.EDJP)) {
			logger.info("File {}", file.getPath());
			InlineXBRL.Document document = InlineXBRL.Document.getInstance(XMLUtil.buildStream(file));
			
			all.addAll(document.getContextSet());
		}
		
		// Output
		List<String> stringValueList = new ArrayList<>(all);
		List<String> javaConstNameList  = new ArrayList<>();
		int maxStringLength = 0;
		int maxJavaConstLength = 0;
		for(String stringValue: stringValueList) {
			String javaConstName = StringUtil.toJavaConstName(stringValue);
			javaConstNameList.add(javaConstName);
			
			maxStringLength    = Math.max(maxStringLength, stringValue.length());
			maxJavaConstLength = Math.max(maxJavaConstLength, javaConstName.length());
		}
		
		// 		YEAR_END_MEMBER                 ("YearEndMember");
		String format = String.format("%%-%ds (\"%%s\"),", maxJavaConstLength);
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		for(int i = 0; i < stringValueList.size(); i++) {
			sb.append(String.format(format, javaConstNameList.get(i), stringValueList.get(i))).append("\n");
		}
		logger.info("");
		logger.info("{}", sb);
		logger.info("");

		logger.info("STOP");
	}
}
