package yokwe.security.japan.sony.price;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import yokwe.util.StringUtil;

public class Month {
//	<month
//	  value="01">
	
	@XmlAttribute(name="value") public String value;
	
	@XmlElement(name = "day")   public List<Day> dayList;
	
	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
