package yokwe.security.japan.ufocatch.atom;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

public class Link {
	@XmlEnum
	public enum Relation {
		@XmlEnumValue("alternate")
		ALT,
		@XmlEnumValue("related")
		REL;
	}
	
	@XmlEnum
	public enum Type {
		@XmlEnumValue("text/plain")
		TEXT,
		@XmlEnumValue("text/xml")
		XML,
		@XmlEnumValue("text/html")
		HTML,
		@XmlEnumValue("application/zip")
		ZIP,
	}
	
	@XmlAttribute
	public Relation rel;  // none, alternate or related
	@XmlAttribute
	public Type type; // none or text/html
	@XmlAttribute
	public String href;
	
	@Override
	public String toString() {
		return String.format("{link %s %s %s}", rel, type, href);
	}
}