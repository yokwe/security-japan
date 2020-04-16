package yokwe.security.japan.sony.basic;

import javax.xml.bind.annotation.XmlAttribute;

import yokwe.util.StringUtil;

public class Base {
//    <Base
//      HYOKA_YMD="2020年03月31日"
//      CATEGORY_NAME="国際株式・グローバル・除く日本（F）"
//      MS_RATING="★★★★"
//      RISKMEASURE="4（やや高い）"
//      F50_FLAG=""/>

	@XmlAttribute(name="HYOKA_YMD")     public String hyokaYMD;
	@XmlAttribute(name="CATEGORY_NAME") public String categoryName;
	@XmlAttribute(name="MS_RATING")     public String msRating;
	@XmlAttribute(name="RISKMEASURE")   public String riskmeasure;
	@XmlAttribute(name="F50_FLAG")      public String f50Flag;
	
	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
