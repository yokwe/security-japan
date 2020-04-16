package yokwe.security.japan.sony.price;

import javax.xml.bind.annotation.XmlElement;

import yokwe.util.StringUtil;

public class MorningstarXML {
	@XmlElement(name = "fund") public Fund fund;
	
	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
