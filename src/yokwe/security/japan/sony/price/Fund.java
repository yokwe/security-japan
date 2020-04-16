package yokwe.security.japan.sony.price;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import yokwe.util.StringUtil;

public class Fund {
//	<fund
//	  code="2013121001"
//	  name="ニッセイ 外国株式インデックスファンド"
//	  period_start="20131210"
//	  period_end="0       ">
	
	@XmlAttribute(name="code")         public String code;
	@XmlAttribute(name="name")         public String name;
	@XmlAttribute(name="period_start") public String periodStart;
	@XmlAttribute(name="period_end")   public String periodEnd;

	@XmlElement(name = "year") public Year year;
	
	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
