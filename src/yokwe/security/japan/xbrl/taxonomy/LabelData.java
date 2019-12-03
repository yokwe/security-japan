package yokwe.security.japan.xbrl.taxonomy;

import java.util.Map;
import java.util.TreeMap;

import yokwe.UnexpectedException;
import yokwe.util.XMLUtil.QValue;

public abstract class LabelData implements Comparable<LabelData> {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LabelData.class);
    
    private static Map<QValue, LabelData> all = new TreeMap<>();
    private static void add(LabelData data) {
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
    
    public static LabelData get(QValue key) {
    	if (all.containsKey(key)) {
    		return all.get(key);
    	} else {
    		logger.error("No data in all {}  {}", all.size(), key);
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
    
    protected LabelData(String namespace, String name, String en, String ja) {
    	this.qName = new QValue(namespace, name);
    	this.en    = en;
    	this.ja    = ja;
    	
    	add(this);
    }
    
    @Override
    public String toString() {
    	return String.format("{%s %s %s}", qName, en, ja);
    }

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else {
			if (o instanceof LabelData) {
				LabelData that = (LabelData)o;
				return this.qName.equals(that.qName) && this.en.equals(that.en) && this.ja.equals(that.ja);
			} else {
				return false;
			}
		}
	}

	@Override
	public int compareTo(LabelData that) {
		return this.qName.compareTo(that.qName);
	}
}
