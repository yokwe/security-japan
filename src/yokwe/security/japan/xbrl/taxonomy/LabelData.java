package yokwe.security.japan.xbrl.taxonomy;

import yokwe.util.XMLUtil.QValue;

public class LabelData {
    public final QValue qName;
    public final String en;
    public final String ja;

    public LabelData(QValue qName, String en, String ja) {
    	this.qName = qName;
    	this.en    = en;
    	this.ja    = ja;
    }
}
