package yokwe.security.japan.xbrl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.CSVUtil;

public class Label implements Comparable<Label> {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Label.class);

	public static final String PATH_DATA_FILE = "tmp/data/label.csv";
		
	public static List<Label> load() {
		return CSVUtil.read(Label.class).file(PATH_DATA_FILE);
	}
	public static void save(Collection<Label> data) {
		CSVUtil.write(Label.class).file(PATH_DATA_FILE, data);
	}
	
	private static final Map<String, Map<String, Map<String, Map<String, String>>>> cacheNamespace = new TreeMap<>();
	//                       namespace
	//                                   label       role        lang    value
	private static void fillCache() {
		List<Label> list = load();
		if (list == null) {
			logger.warn("no data file {}", PATH_DATA_FILE);
			list = new ArrayList<>();
		}
		for(Label e: list) {
			final String namespace = e.namespace;
			final String label     = e.label;
			final String role      = e.role;
			final String lang      = e.lang;
			final String value     = e.value;
			
			if (!cacheNamespace.containsKey(namespace)) {
				cacheNamespace.put(namespace, new TreeMap<>());
			}
			Map<String, Map<String, Map<String, String>>> labelMap = cacheNamespace.get(namespace);
			//  label       role        lang    value
			
			if (!labelMap.containsKey(label)) {
				labelMap.put(label, new TreeMap<>());
			}
			Map<String, Map<String, String>> roleMap = labelMap.get(label);
			if (!roleMap.containsKey(role)) {
				roleMap.put(role, new TreeMap<>());
			}
			Map<String, String> langMap = roleMap.get(role);
			if (langMap.containsKey(lang)) {
				logger.error("Duplicate entry {} {} {} {} \"{}\"", namespace, label, role, lang, value);
				throw new UnexpectedException("Duplicate entry");	
			} else {
				langMap.put(lang, value);
			}
		}
	}

	
	public static String getValueJA(String namespace, String label) {
		return getValueJA(namespace, label, XBRL.ROLE_LABLE);
	}
	public static String getValueJA(String namespace, String label, String role) {
		return getValue(namespace, label, role, XBRL.LANG_JA);
	}
	public static String getValue(String namespace, String label, String role, String lang) {
		if (cacheNamespace == null) fillCache();
		if (cacheNamespace.containsKey(namespace)) {
			Map<String, Map<String, Map<String, String>>> labelMap = cacheNamespace.get(namespace);
			if (labelMap.containsKey(label)) {
				Map<String, Map<String, String>> roleMap = labelMap.get(label);
				if (roleMap.containsKey(role)) {
					Map<String, String> langMap = roleMap.get(lang);
					if (langMap.containsKey(lang)) {
						return langMap.get(lang);
					} else {
						logger.warn("Unknown label {} {} {} {}", namespace, label, role, lang);
					}
				} else {
					logger.warn("Unknown role {} {} {} {}", namespace, label, role, lang);
				}
			} else {
				logger.warn("Unknown label {} {} {} {}", namespace, label, role, lang);
			}
		} else {
			logger.warn("Unknown namespace {} {} {} {}", namespace, label, role, lang);
		}
		return null;
	}
	
	
	public String namespace;
	public String label;
	public String role;
	public String lang;
	public String value;
	
	public Label(String namespace, String label, String role, String lang, String value) {
		this.namespace = namespace;
		this.label = label;
		this.role  = role;
		this.lang  = lang;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.format("{%s %s %s %s \"%s\"}", namespace, label, role, lang, value);
	}

	@Override
	public int compareTo(Label that) {
		int ret = this.namespace.compareTo(that.namespace);
		if (ret == 0) ret = this.label.compareTo(that.label);
		if (ret == 0) ret = this.role.compareTo(that.role);
		if (ret == 0) ret = this.lang.compareTo(that.lang);
		if (ret == 0) ret = this.value.compareTo(that.value);
		return ret;
	}
}
