package yokwe.security.japan.ufocatch.atom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

public class Link {
	@XmlEnum
	public enum Relation {
		@XmlEnumValue("self")
		SELF,
		@XmlEnumValue("first")
		FIRST,
		@XmlEnumValue("last")
		LAST,
		@XmlEnumValue("next")
		NEXT,
		//
		@XmlEnumValue("alternate")
		ALT,
		@XmlEnumValue("related")
		REL,
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
		@XmlEnumValue("image/gif")
		GIF,
		@XmlEnumValue("image/png")
		PNG,
		@XmlEnumValue("image/jpeg")
		JPG,
	}
	
	@XmlAttribute
	public Relation rel;  // none, alternate or related
	@XmlAttribute
	public Type type; // none or text/html
	@XmlAttribute
	public String href;
	
	@Override
	public String toString() {
		List<String> list = new ArrayList<>();
		if (rel  != null) list.add(rel.toString());
		if (type != null) list.add(type.toString());
		if (href != null) list.add(href);
		
		return String.format("{link %s}", String.join(" ", list));
	}
}