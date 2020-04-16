package yokwe.security.japan.sony.basic;

import javax.xml.bind.annotation.XmlElement;

import yokwe.util.StringUtil;

public class Root {
	@XmlElement(name = "Fund") public Fund fund;
	
	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
