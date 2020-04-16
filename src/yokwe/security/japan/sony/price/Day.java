package yokwe.security.japan.sony.price;

import javax.xml.bind.annotation.XmlAttribute;

import yokwe.util.StringUtil;

public class Day {
//	<day
//	  value="04"
//	  year="2015"
//	  month="01"
//	  price=""
//	  volume=""
//	  return_value=""
//	  indication="0"/>

//	<day
//	  value="05"
//	  year="2015"
//	  month="01"
//	  price="12607"
//	  volume="6710"
//	  return_value=".98078419"
//	  indication="1"/>
	
	@XmlAttribute(name="value")        public String value;
	@XmlAttribute(name="year")         public String year;
	@XmlAttribute(name="month")        public String month;
	@XmlAttribute(name="price")        public String price;
	@XmlAttribute(name="volume")       public String volume;
	@XmlAttribute(name="return_value") public String returnValue;
	@XmlAttribute(name="indication")   public String indication;

	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
