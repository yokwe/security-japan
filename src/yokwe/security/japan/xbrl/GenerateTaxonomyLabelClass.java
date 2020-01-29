package yokwe.security.japan.xbrl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.IndentPrintWriter;
import yokwe.util.StringUtil;

public class GenerateTaxonomyLabelClass {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GenerateTaxonomyLabelClass.class);
	
	private static final String PATH_DIR = "src/yokwe/security/japan/xbrl/taxonomy";
	
	private static Map<String, String> classNameMap = new TreeMap<>();
	//                 namespace
	//                         class name
	static {
		classNameMap.put(XBRL.NS_TSE_ED_T, "TSE_ED_T");
//		classNameMap.put(XBRL.NS_TSE_AT_T, "TSE_AT_T");
		classNameMap.put(XBRL.NS_TSE_RE_T, "TSE_RE_T");
		
		classNameMap.put(XBRL.NS_TSE_T_CG, "TSE_T_CG");
	}
	
	private static void generateClass(String namespace, String className, Map<String, Entry> entryMap) {
		if (entryMap.isEmpty()) {
			logger.warn("entryMap is empty  {}", className);
			return;
		}
		String path = String.format("%s/%s.java", PATH_DIR, className);
		logger.info("generate {} {}", entryMap.size(), path);
		try (IndentPrintWriter out = new IndentPrintWriter(new PrintWriter(path))) {
			out.indent().println("package yokwe.security.japan.xbrl.taxonomy;");
			out.indent().println();
			out.indent().println("import java.util.Map;");
			out.indent().println("import java.util.TreeMap;");
			out.indent().println();
			out.indent().println("import yokwe.UnexpectedException;");
			out.indent().println("import yokwe.util.XMLUtil.QValue;");
			out.indent().println();
			
			out.indent().format("public enum %s {", className).println();
			out.nest();
			
			List<Entry> entryList = new ArrayList<>(entryMap.values());
			int entryListSize = entryList.size();
			for(int i = 0; i < entryListSize; i++) {
				Entry entry = entryList.get(i);
				
				String name      = entry.name;
				String constName = entry.constName;
				String en        = entry.en;
				String ja        = entry.ja;
				
				String nameValue = String.format("\"%s\"", name);
				String enValue = (en == null) ? "null" : String.format("\"%s\"", en);
				String jaValue = (ja == null) ? "null" : String.format("\"%s\"", ja);
				String comma   = (i == (entryListSize - 1)) ? ";" : ",";
				
				out.indent().format("%s(", constName).println();
				out.nest();
				
				out.indent().format("%s,",  nameValue).println();
				out.indent().format("%s,",  enValue).println();
				out.indent().format("%s)%s", jaValue, comma).println();
				out.unnest();
				
				out.indent().println();
			}

			out.indent().println();
			out.indent().format("public static final String NAMESPACE = \"%s\";", namespace).println();
			out.indent().println();
			
			out.indent().println("public final QValue qName;");
			out.indent().println("public final String en;");
			out.indent().println("public final String ja;");
			out.indent().println();
			
			out.indent().format("%s (String name, String en, String ja) {", className).println();
			out.nest();
			
			out.indent().println("this.qName = new QValue(NAMESPACE, name);");
			out.indent().println("this.en = en;");
			out.indent().println("this.ja = ja;");

			out.unnest();
			out.indent().println("}");
			out.indent().println();

			out.indent().format("private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(%s.class);", className).println();
			out.indent().println();

			out.indent().println("private static final Map<QValue, TSE_T_CG_LABEL> all = new TreeMap<>();");
			out.indent().println("static {");
			out.nest();

			out.indent().println("for(TSE_T_CG_LABEL e: TSE_T_CG_LABEL.class.getEnumConstants()) {");
			out.nest();

			out.indent().println("QValue key = e.qName;");
			out.indent().println("if (all.containsKey(key)) {");
			out.nest();
			out.indent().println("logger.error(\"Unknow key {}\", key);");
			out.indent().println("throw new UnexpectedException(\"Duplicate key\");");
			out.unnest();
			out.indent().println("} else {");
			out.nest();
			out.indent().println("all.put(key, e);");
			out.unnest();
			out.indent().println("}");
			
			out.unnest();
			out.indent().println("}");

			out.unnest();
			out.indent().println("}");
			out.indent().println();

			out.indent().println("public static TSE_T_CG_LABEL get(QValue qName) {");
			out.nest();
			out.indent().println("if (all.containsKey(qName)) {");
			out.nest();
			out.indent().println("return  all.get(qName);");
			out.unnest();
			out.indent().println("} else {");
			out.nest();
			out.indent().println("logger.error(\"Unknow key {}\", qName);");
			out.indent().println("throw new UnexpectedException(\"Unknow key\");");
			out.unnest();
			out.indent().println("}");
			out.unnest();
			out.indent().println("}");
			out.indent().println();

			
			out.unnest();
			out.indent().println("}");
		} catch (FileNotFoundException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
	}
	
	private static class Entry {
		String name;
		String constName;
		String en;
		String ja;
		Entry(String name) {
			this.name      = name;
			this.constName = StringUtil.toJavaConstName(name);
			this.en        = null;
			this.ja        = null;
		}
	}
	
	public static void main(String[] args) {
		logger.info("START");
		
		List<Label> labelList = Label.load();
		
		Map<String, Map<String, Entry>> namespaceLabelMap = new TreeMap<>();
		//  namespace   label
		for(Label e: labelList) {
			final String namespace = e.namespace;
			final String label     = e.label;
			final String role      = e.role;
			final String lang      = e.lang;
			final String value     = e.value;
			
			// Filter
			if (!role.equals(XBRL.ROLE_LABLE)) continue;
			
			if (!namespaceLabelMap.containsKey(namespace)) {
				namespaceLabelMap.put(namespace, new TreeMap<>());
			}
			Map<String, Entry> entryMap = namespaceLabelMap.get(namespace);
			
			if (!entryMap.containsKey(label)) {
				entryMap.put(label, new Entry(label));
			}
			Entry entry = entryMap.get(label);
			
			switch(lang) {
			case "ja":
				if (entry.ja == null) {
					entry.ja = value;
				} else {
					logger.error("Duplcate lang ja {}cons", e);
					throw new UnexpectedException("Duplcate lang");
				}
				break;
			case "en":
				if (entry.en == null) {
					entry.en = value;
				} else {
					logger.error("Duplcate lang en {}", e);
					throw new UnexpectedException("Duplcate lang");
				}
				break;
			default:
				logger.error("Unexpected lang {}", lang);
				throw new UnexpectedException("Unexpected lang");
			}
		}
		
		for(Map.Entry<String, Map<String, Entry>> entry: namespaceLabelMap.entrySet()) {
			final String             namespace = entry.getKey();
			final Map<String, Entry> entryMap  = entry.getValue();
			
			if (!classNameMap.containsKey(namespace)) continue;
			
			final String className = classNameMap.get(namespace) + "_LABEL";
			
			generateClass(namespace, className, entryMap);
		}
		
		logger.info("STOP");
	}
}
