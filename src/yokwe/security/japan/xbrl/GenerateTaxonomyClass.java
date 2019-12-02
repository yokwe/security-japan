package yokwe.security.japan.xbrl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.IndentPrintWriter;
import yokwe.util.StringUtil;

public class GenerateTaxonomyClass {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GenerateTaxonomyClass.class);
	
	private static final String PATH_DIR = "src/yokwe/security/japan/xbrl/taxonomy";
	
	private static Map<String, String> classNameMap = new TreeMap<>();
	//                 namespace
	//                         class name
	static {
		classNameMap.put(XBRL.NS_TSE_ED_T, "TSE_ED_T");
//		classNameMap.put(XBRL.NS_TSE_AT_T, "TSE_AT_T");
//		classNameMap.put(XBRL.NS_TSE_RE_T, "TSE_RE_T");
		
		classNameMap.put(XBRL.NS_TSE_T_CG, "TSE_T_CG");
	}
	
	private static void generateClass(String namespace, String className, Map<String, Entry> entryMap) {
		String path = String.format("%s/%s.java", PATH_DIR, className);
		logger.info("generate {}", path);
		try (IndentPrintWriter out = new IndentPrintWriter(new PrintWriter(path))) {
			out.indent().println("package yokwe.security.japan.xbrl.taxonomy;");
			out.indent().println();
			out.indent().println("import java.util.Map;");
			out.indent().println("import java.util.TreeMap;");
			out.indent().println();

			out.indent().format("public enum %s {", className).println();
			out.nest();
			
			for(Entry entry: entryMap.values()) {
				String name      = entry.name;
				String constName = entry.constName;
				String en        = entry.en;
				String ja        = entry.ja;
				
				if (en == null) {
					logger.error("en is null {} {}", className, name);
					throw new UnexpectedException("en is null");
				}
				if (ja == null) {
					logger.error("ja is null ja {} {}", className, name);
					throw new UnexpectedException("ja is null");
				}
				
				// AmountChangeGrossOperatingRevenues("AmountChangeGrossOperatingRevenues", "増減額", "Amount change"),
				out.indent().format("%s (", constName).println();
				out.nest();
				out.indent().format("\"%s\", ", name).println();
				out.indent().format("\"%s\", ",en).println();
				out.indent().format("\"%s\"), ", ja).println();
				out.unnest();
			}
			out.indent().println(";");
			out.indent().println();
			
			out.indent().println("public final String name;");
			out.indent().println("public final String en;");
			out.indent().println("public final String ja;");
			out.indent().println();

			out.indent().format("private %s(String name, String en, String ja) {", className).println();
			out.nest();
			out.indent().println("this.name = name;");
			out.indent().println("this.en   = en;");
			out.indent().println("this.ja   = ja;");
			out.indent().println();
			out.indent().println("addALL(this);");
			out.unnest();
			out.indent().println("}");
			out.indent().println();
			
			out.indent().format("public static final String NAMESPACE = \"%s\";", namespace).println();
			out.indent().println();
			out.indent().println("public static final Map<String, TSE_ED_T> ALL = new TreeMap<>();");
			out.indent().format("private static void addALL(%s e) {", className).println();
			out.nest();
			out.indent().println("ALL.put(e.name, e);");
			out.unnest();
			out.indent().println("}");

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
					logger.error("Duplcate lang ja {}", e);
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
			
			final String className = classNameMap.get(namespace);
			
			generateClass(namespace, className, entryMap);
		}
		
		logger.info("STOP");
	}
}
