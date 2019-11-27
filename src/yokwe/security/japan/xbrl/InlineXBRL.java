package yokwe.security.japan.xbrl;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.XMLUtil.XMLElement;

public abstract class InlineXBRL {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(InlineXBRL.class);

	public enum Kind {
		STRING, BOOLEAN, NUMBER
	}
	
	private interface Builder {
		public InlineXBRL getInstance(XMLElement xmlElement);
	}
	
	private static class NonNumericBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			String format = xmlElement.getAttributeValueOrNull("format");
			if (format == null) {
				return new StringValue(xmlElement);
			} else {
				switch(format) {
				case "ixt:booleanfalse":
					return new BooleanValue(xmlElement, false);
				case "ixt:booleantrue":
					return new BooleanValue(xmlElement, true);
				case "ixt:dateyearmonthdaycjk":
					return new StringValue(xmlElement);
				default:
					logger.error("Unexpected format {}", format);
					throw new UnexpectedException("Unexpected format");
				}
			}
		}
	}
	private static class NonFractionBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			String format = xmlElement.getAttributeValueOrNull("format");
			if (format == null) {
				return new NumberValue(xmlElement);
			} else {
				switch(format) {
				case "ixt:numdotdecimal":
					return new NumberValue(xmlElement);
				default:
					logger.error("Unexpected format {}", format);
					throw new UnexpectedException("Unexpected format");
				}
			}
		}
	}
	
	private static Map<String, Builder> map = new TreeMap<>();
	static {
		map.put("ix:nonNumeric",  new NonNumericBuilder());
		map.put("ix:nonFraction", new NonFractionBuilder());
	}
	private static Builder getBuilder(XMLElement xmlElement) {
		String qName = xmlElement.qName;
		if (map.containsKey(qName)) {
			return map.get(qName);
		} else {
			logger.error("Unpexpected qName {}!", qName);
			throw new UnexpectedException("Unpexpected qName");
		}
	}
	
	public static boolean canGetInstance(XMLElement xmlElement) {
		String qName = xmlElement.qName;
		
		return map.containsKey(qName);
	}
	public static InlineXBRL getInstance(XMLElement xmlElement) {
		if (canGetInstance(xmlElement)) {
			Builder builder = getBuilder(xmlElement);
			return builder.getInstance(xmlElement);
		} else {
			logger.error("Unpexpected qName {}!", xmlElement.qName);
			throw new UnexpectedException("Unpexpected qName");
		}
	}
	
	
	public final Kind       kind;
	public final XMLElement xmlElement;
	
	public final String  contextRef;
	public final String  name;
	public final String  format;
	public final String  value;
	public final boolean isNull;

	private InlineXBRL(Kind kind, XMLElement xmlElement) {
		this.kind         = kind;
		this.xmlElement   = xmlElement;
		
		this.contextRef   = xmlElement.getAttributeValue("contextRef");
		this.name         = xmlElement.getAttributeValue("name");
		this.format       = xmlElement.getAttributeValueOrNull("format");
		this.value        = xmlElement.content;
		
		String nilValue = xmlElement.getAttributeValueOrNull("xsi:nil");
		if (nilValue == null) {
			isNull = false;
		} else {
			switch(nilValue) {
			case "true":
				isNull = true;
				break;
			case "false":
				isNull = false;
				break;
			default:
				logger.error("Unpexpected nilValue {}!", nilValue);
				throw new UnexpectedException("Unpexpected nilValue");
			}
		}
	}
	
	public static class StringValue extends InlineXBRL {
		public static Set<String> validAttributeSet = new TreeSet<>();
		static {
			validAttributeSet.add("contextRef");
			validAttributeSet.add("name");
			validAttributeSet.add("format");
			validAttributeSet.add("xsi:nil");
			//
			validAttributeSet.add("escape");
		}
		
		public final String escape;
		public final String stringValue;
		
		public StringValue(XMLElement xmlElement) {
			super(Kind.STRING, xmlElement);
			this.escape = xmlElement.getAttributeValueOrNull("escape");
			this.stringValue = xmlElement.content;
			
			// Sanity check
			for(String attribute: xmlElement.attributeMap.keySet()) {
				if (validAttributeSet.contains(attribute)) continue;
				logger.error("Unpexpected attribute {}!", attribute);
				logger.error("xmlElement {}!", xmlElement);
				throw new UnexpectedException("Unpexpected attribute");
			}
		}
		
		@Override
		public String toString() {
			if (isNull) {
				if (format == null) {
					return String.format("{STRING %s %s *NULL*}", name, contextRef);
				} else {
					return String.format("{STRING %s %s %s %s *NULL*}", name, contextRef, format, escape);
				}
			} else {
				if (format == null) {
					return String.format("{STRING %s %s %s}", name, contextRef, stringValue);
				} else {
					return String.format("{STRING %s %s %s %s %s}", name, contextRef, format, escape, stringValue);
				}
			}
		}
	}
	public static class BooleanValue extends InlineXBRL {
		public static Set<String> validAttributeSet = new TreeSet<>();
		static {
			validAttributeSet.add("contextRef");
			validAttributeSet.add("name");
			validAttributeSet.add("format");
			//
			validAttributeSet.add("escape");
		}

		public final boolean booleanValue;
		
		public BooleanValue(XMLElement xmlElement, boolean booleanValue) {
			super(Kind.BOOLEAN, xmlElement);
			this.booleanValue = booleanValue;
			
			// Sanity check
			for(String attribute: xmlElement.attributeMap.keySet()) {
				if (validAttributeSet.contains(attribute)) continue;
				logger.error("Unpexpected attribute {}!", attribute);
				logger.error("xmlElement {}!", xmlElement);
				throw new UnexpectedException("Unpexpected attribute");
			}
		}
		@Override
		public String toString() {
			if (isNull) {
				return String.format("{BOOLEAN %s %s %s %s *NULL* %s}", name, contextRef, value, format);
			} else {
				return String.format("{BOOLEAN %s %s %s %s}", name, contextRef, booleanValue, format);
			}
		}
	}
	public static class NumberValue extends InlineXBRL {
		public static Set<String> validAttributeSet = new TreeSet<>();
		static {
			validAttributeSet.add("contextRef");
			validAttributeSet.add("name");
			validAttributeSet.add("format");
			validAttributeSet.add("unitRef");
			validAttributeSet.add("decimals");
			validAttributeSet.add("scale");
			//
			validAttributeSet.add("sign");
			validAttributeSet.add("xsi:nil");
		}

		// ixt:numdotdecimal は 999,000.00
		public final String     unitRef;
		public final String     decimals; // 値の精度情報　3 => 0.001刻み  0 => 1刻み  -3 => 1,000刻み
		public final String     scale;    // 値の意味　6 => 1の値は1,000,000を意味する, -2 => 1の値は0.01を意味する
		public final String     sign;
		public final boolean    isMinus;
		public final BigDecimal numericValue;
		
		public NumberValue(XMLElement xmlElement) {
			super(Kind.NUMBER, xmlElement);
			this.unitRef  = xmlElement.getAttributeValue("unitRef");
			this.decimals = xmlElement.getAttributeValueOrNull("decimals");
			this.scale    = xmlElement.getAttributeValueOrNull("scale");
			this.sign     = xmlElement.getAttributeValueOrNull("sign");
			this.isMinus  = sign != null && sign.equals("-");
			
			// unitRef "Pure" means number has no unit
			// unitRef "JPY" means number is Japanese Yen
			// unitRef "JPYPerShares" means number is Japanese Yen price per one share.
			
			// TODO calculate numericValue from value, scale and sign
			this.numericValue = null;
			
			// Sanity check
			for(String attribute: xmlElement.attributeMap.keySet()) {
				if (validAttributeSet.contains(attribute)) continue;
				logger.error("Unpexpected attribute {}!", attribute);
				logger.error("xmlElement {}!", xmlElement);
				throw new UnexpectedException("Unpexpected attribute");
			}
		}
		@Override
		public String toString() {
			if (isNull) {
				return String.format("{NUMBER %s %s %s *NULL*}", name, contextRef, unitRef);
			} else {
				return String.format("{NUMBER %s %s %s %s %s %s %s %s}", name, contextRef, unitRef, value, format, decimals, scale, sign);
			}
		}
	}
}
