package yokwe.security.japan.xbrl.inline;

import java.util.Set;
import java.util.TreeSet;

import yokwe.UnexpectedException;
import yokwe.security.japan.xbrl.XML;
import yokwe.util.XMLUtil.QValue;
import yokwe.util.XMLUtil.XMLAttribute;
import yokwe.util.XMLUtil.XMLElement;

public class StringValue extends InlineXBRL {
	public static Set<QValue> validAttributeSet = new TreeSet<>();
	static {
		validAttributeSet.add(new QValue("", "contextRef"));
		validAttributeSet.add(new QValue("", "name"));
		validAttributeSet.add(new QValue("", "format"));
		validAttributeSet.add(XML.XSI_NIL);
		//
		validAttributeSet.add(new QValue("", "escape"));
	}
	
	public final String escape;
	public final String stringValue;
	
	public StringValue(XMLElement xmlElement) {
		super(Kind.STRING, xmlElement);
		this.escape = xmlElement.getAttributeOrNull("escape");
		
		if (isNull) {
			this.stringValue = null;
		} else {
			if (qFormat == null) {
				this.stringValue = xmlElement.content;
			} else {
				logger.error("Unexpected format", value);
				logger.error("  format  {}", format);
				logger.error("  qFormat {}", qFormat);
				throw new UnexpectedException("Unexpected format");
			}
		}
		
		// Sanity check
		for(XMLAttribute xmlAttribute: xmlElement.attributeList) {
			QValue value = new QValue(xmlAttribute);
			if (validAttributeSet.contains(value)) continue;
			logger.error("Unexpected attribute {}", xmlAttribute.name);
			logger.error("xmlElement {}!", xmlElement);
			throw new UnexpectedException("Unexpected attribute");
		}
	}
	
	@Override
	public String toString() {
		if (isNull) {
			if (format == null) {
				return String.format("{STRING %s %s *NULL*}", name, contextSet);
			} else {
				return String.format("{STRING %s %s %s *NULL*}", name, contextSet, format);
			}
		} else {
			if (format == null) {
				return String.format("{STRING %s %s \"%s\"}", name, contextSet, stringValue);
			} else {
				return String.format("{STRING %s %s %s \"%s\"", name, contextSet, format, stringValue);
			}
		}
	}
}