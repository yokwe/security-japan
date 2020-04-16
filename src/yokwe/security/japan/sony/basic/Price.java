package yokwe.security.japan.sony.basic;

import javax.xml.bind.annotation.XmlAttribute;

import yokwe.util.StringUtil;

public class Price {
//    <Price
//      KIJYUN_YMD="2020年04月15日"
//      KIJYUNKAGAKU="14,722"
//      TICK="1"
//      DAYCHANGE="300"
//      DAYCHANGE_RATIO="2.08"
//      JYUNSHISAN="147,851"/>

	@XmlAttribute(name="KIJYUN_YMD")      public String kijunYMD;
	@XmlAttribute(name="KIJYUNKAGAKU")    public String kijunkagaku;
	@XmlAttribute(name="TICK")            public String tick;
	@XmlAttribute(name="DAYCHANGE")       public String daychange;
	@XmlAttribute(name="DAYCHANGE_RATIO") public String daychangeRatio;
	@XmlAttribute(name="JYUNSHISAN")      public String jynshisan;
	
	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
