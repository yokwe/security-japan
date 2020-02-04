package yokwe.security.japan.xbrl.inline;

import java.util.Set;
import java.util.TreeSet;

import yokwe.UnexpectedException;
import yokwe.security.japan.xbrl.XBRL;
import yokwe.util.XMLUtil.QValue;
import yokwe.util.XMLUtil.XMLAttribute;
import yokwe.util.XMLUtil.XMLElement;

public class BooleanValue extends InlineXBRL {
	public static Set<QValue> validAttributeSet = new TreeSet<>();
	static {
		validAttributeSet.add(new QValue("", "contextRef"));
		validAttributeSet.add(new QValue("", "name"));
		validAttributeSet.add(new QValue("", "format"));
		//
		validAttributeSet.add(new QValue("", "escape"));
	}
	public final String  escape;
	public final Boolean booleanValue;
	
	public BooleanValue(XMLElement xmlElement) {
		super(Kind.BOOLEAN, xmlElement);
		
		this.escape = xmlElement.getAttributeOrNull("escape");
		
		if (isNull) {
			this.booleanValue = null;
		} else {
			if (this.qFormat.equals(XBRL.IXT_BOOLEAN_FALSE)) {
				this.booleanValue = false;
			} else if (qFormat.equals(XBRL.IXT_BOOLEAN_TRUE)) {
				this.booleanValue = true;
			} else {
				logger.error("Unexpected format");
				logger.error("  xmlElement  {}", xmlElement);
				logger.error("  qFormat {}", qFormat);
				throw new UnexpectedException("Unexpected format");
			}
		}
		
		// Sanity check
		for(XMLAttribute xmlAttribute: xmlElement.attributeList) {
			QValue value = new QValue(xmlAttribute);
			if (validAttributeSet.contains(value)) continue;
			logger.error("Unexpected attribute {}!", value);
			logger.error("xmlAttribute {}!", xmlAttribute.name);
			logger.error("xmlElement {}!", xmlElement);
			throw new UnexpectedException("Unexpected attribute");
		}
	}
	@Override
	public String toString() {
		if (isNull) {
			return String.format("{BOOLEAN %s %s %s *NULL*}", name, contextSet, escape);
		} else {
			return String.format("{BOOLEAN %s %s %s %s}", name, contextSet, escape, booleanValue);
		}
	}
}