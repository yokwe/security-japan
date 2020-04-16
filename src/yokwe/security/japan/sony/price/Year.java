package yokwe.security.japan.sony.price;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import yokwe.util.StringUtil;


public class Year {
//	<year
//	  value="2014">
	
	@XmlAttribute(name="value") public String value;

	@XmlElement(name = "month")
	public List<Month> monthList;
	
	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
