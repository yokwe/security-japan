package yokwe.security.japan.xbrl.taxonomy;

import java.util.Map;
import java.util.TreeMap;

import yokwe.UnexpectedException;
import yokwe.util.XMLUtil.QValue;

public class TaxonomyData {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TaxonomyData.class);
    
    private static Map<QValue, TaxonomyData> all = new TreeMap<>();
    private void add(TaxonomyData data) {
    	final QValue key = data.qName;
    	if (all.containsKey(key)) {
    		logger.error("Duplicate data {}", key);
    		logger.error("old  {}", all.get(key));
    		logger.error("new  {}", data);
            throw new UnexpectedException("Duplicate data");
    	} else {
    		all.put(key, data);
    	}
    }
    
    public static TaxonomyData get(QValue key) {
    	if (all.containsKey(key)) {
    		return all.get(key);
    	} else {
    		logger.error("Duplicate data {}", key);
            throw new UnexpectedException("No data");
    	}
    }
    public static String getEN(QValue key) {
    	return get(key).en;
    }
    public static String getJA(QValue key) {
    	return get(key).ja;
    }

	public final QValue qName;
    public final String en;
    public final String ja;
    
    public TaxonomyData(String namespace, String name, String en, String ja) {
    	this.qName = new QValue(namespace, name);
    	this.en    = en;
    	this.ja    = ja;
    	
    	add(this);
    }
    
    @Override
    public String toString() {
    	return String.format("{%s %s %s}", qName, en, ja);
    }
}
