package yokwe.security.japan.xbrl;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.XMLUtil.QValue;
import yokwe.util.XMLUtil.XMLAttribute;
import yokwe.util.XMLUtil.XMLElement;

public abstract class InlineXBRL {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(InlineXBRL.class);

	public enum Kind {
		STRING, BOOLEAN, NUMBER
	}
	
	private interface Builder {
		public InlineXBRL getInstance(XMLElement xmlElement);
	}
	
	private static class BooleanBuilder implements Builder {
		private final boolean value;
		BooleanBuilder(boolean newValue) {
			value = newValue;
		}
		public InlineXBRL getInstance(XMLElement xmlElement) {
			return new BooleanValue(xmlElement, value);
		}
	}
	private static class StringBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			return new StringValue(xmlElement);
		}
	}
	private static Map<QValue, Builder> nonNumericBuilderMap = new TreeMap<>();
	static {
		nonNumericBuilderMap.put(XBRL.IXT_BOOLEAN_TRUE,            new BooleanBuilder(true));
		nonNumericBuilderMap.put(XBRL.IXT_BOOLEAN_FALSE,           new BooleanBuilder(false));
		nonNumericBuilderMap.put(XBRL.IXT_DATE_YEAR_MONTH_DAY_CJK, new StringBuilder());
	}
	private static class NonNumericBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			String format = xmlElement.getAttributeOrNull("format");
			if (format == null) {
				return new StringValue(xmlElement);
			} else {
				QValue qValue = new QValue(xmlElement, format);
				if (nonNumericBuilderMap.containsKey(qValue)) {
					Builder builder = nonNumericBuilderMap.get(qValue);
					return builder.getInstance(xmlElement);
				} else {
					logger.error("Unexpected xmlElement {}", xmlElement);
					logger.error("  format {}", format);
					logger.error("  qValue {}", qValue);
					throw new UnexpectedException("Unexpected xmlElement");	
				}
			}
		}
	}
	
	private static class NumberBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			return new NumberValue(xmlElement);
		}
	}
	private static Map<QValue, Builder> nonFractionalBuilderMap = new TreeMap<>();
	static {
		nonFractionalBuilderMap.put(XBRL.IXT_NUM_DOT_DECIMAL, new NumberBuilder());
	}
	private static class NonFractionBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			String format = xmlElement.getAttributeOrNull("format");
			if (format == null) {
				return new NumberValue(xmlElement);
			} else {
				QValue qValue = new QValue(xmlElement, format);
				if (nonFractionalBuilderMap.containsKey(qValue)) {
					Builder builder = nonFractionalBuilderMap.get(qValue);
					return builder.getInstance(xmlElement);
				} else {
					logger.error("Unexpected qValue {}", qValue);
					throw new UnexpectedException("Unexpected qValue");	
				}
			}
		}
	}
	
	private static Map<QValue, Builder> elementBuilderMap = new TreeMap<>();
	static {
		elementBuilderMap.put(XBRL.IX_NON_NUMERIC,  new NonNumericBuilder());
		elementBuilderMap.put(XBRL.IX_NON_FRACTION, new NonFractionBuilder());
	}
	private static Builder getBuilder(XMLElement xmlElement) {
		QValue key = new QValue(xmlElement);
		if (elementBuilderMap.containsKey(key)) {
			return elementBuilderMap.get(key);
		} else {
			logger.error("Unexpected key {}!", key);
			throw new UnexpectedException("Unexpected key");
		}
	}
	
	public static boolean canGetInstance(XMLElement xmlElement) {
		QValue key = new QValue(xmlElement);
		return elementBuilderMap.containsKey(key);
	}
	public static InlineXBRL getInstance(XMLElement xmlElement) {
		if (canGetInstance(xmlElement)) {
			Builder builder = getBuilder(xmlElement);
			return builder.getInstance(xmlElement);
		} else {
			logger.error("Unexpected name {}", xmlElement.name);
			throw new UnexpectedException("Unexpected name");
		}
	}
	
	
	public final Kind       kind;
	public final XMLElement xmlElement;
	
	public final String  contextRef;
	public final String  name;
	public final String  format;
	public final String  value;
	
	public final QValue  qName;
	public final String  nameLabel;
	public final boolean isNull;

	private InlineXBRL(Kind kind, XMLElement xmlElement) {
		this.kind         = kind;
		this.xmlElement   = xmlElement;
		
		this.contextRef   = xmlElement.getAttribute("contextRef");
		this.name         = xmlElement.getAttribute("name");
		this.format       = xmlElement.getAttributeOrNull("format");
		this.value        = xmlElement.content;
		
		this.qName        = new QValue(xmlElement, this.name);
		this.nameLabel    = Label.getValueJA(qName);
		
		// check nil
		String nilValue = xmlElement.getAttributeOrNull(XML.XSI_NIL);
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
				logger.error("Unexpected nilValue {}!", nilValue);
				throw new UnexpectedException("Unexpected nilValue");
			}
		}
	}
	
	public static class StringValue extends InlineXBRL {
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
			this.stringValue = xmlElement.content;
			
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
					return String.format("{STRING %s %s *NULL*}", nameLabel, contextRef);
				} else {
					return String.format("{STRING %s %s %s *NULL*}", nameLabel, contextRef, format);
				}
			} else {
				if (format == null) {
					return String.format("{STRING %s %s \"%s\"}", nameLabel, contextRef, stringValue);
				} else {
					return String.format("{STRING %s %s %s \"%s\"", nameLabel, contextRef, format, stringValue);
				}
			}
		}
	}
	public static class BooleanValue extends InlineXBRL {
		public static Set<QValue> validAttributeSet = new TreeSet<>();
		static {
			validAttributeSet.add(new QValue("", "contextRef"));
			validAttributeSet.add(new QValue("", "name"));
			validAttributeSet.add(new QValue("", "format"));
			//
			validAttributeSet.add(new QValue("", "escape"));
		}

		public final boolean booleanValue;
		
		public BooleanValue(XMLElement xmlElement, boolean booleanValue) {
			super(Kind.BOOLEAN, xmlElement);
			this.booleanValue = booleanValue;
			
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
				return String.format("{BOOLEAN %s %s *NULL*}", nameLabel, contextRef);
			} else {
				return String.format("{BOOLEAN %s %s %s}", nameLabel, contextRef, booleanValue);
			}
		}
	}
	public static class NumberValue extends InlineXBRL {
		public static Set<QValue> validAttributeSet = new TreeSet<>();
		static {
			validAttributeSet.add(new QValue("", "contextRef"));
			validAttributeSet.add(new QValue("", "name"));
			validAttributeSet.add(new QValue("", "format"));
			validAttributeSet.add(new QValue("", "unitRef"));
			validAttributeSet.add(new QValue("", "decimals"));
			validAttributeSet.add(new QValue("", "scale"));
			//
			validAttributeSet.add(new QValue("", "sign"));
			validAttributeSet.add(XML.XSI_NIL);
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
			this.unitRef  = xmlElement.getAttribute("unitRef");
			this.decimals = xmlElement.getAttributeOrNull("decimals");
			this.scale    = xmlElement.getAttributeOrNull("scale");
			this.sign     = xmlElement.getAttributeOrNull("sign");
			this.isMinus  = sign != null && sign.equals("-");
			
			// unitRef "Pure" means number has no unit
			// unitRef "JPY" means number is Japanese Yen
			// unitRef "JPYPerShares" means number is Japanese Yen price per one share.
			
			// TODO calculate numericValue from value, scale and sign
			this.numericValue = null;
			
			// Sanity check
			// Sanity check
			for(XMLAttribute xmlAttribute: xmlElement.attributeList) {
				QValue value = new QValue(xmlAttribute);
				if (validAttributeSet.contains(value)) continue;
				logger.error("Unexpected attribute {}!", xmlAttribute);
				logger.error("xmlElement {}!", xmlElement);
				throw new UnexpectedException("Unexpected attribute");
			}
		}
		@Override
		public String toString() {
			if (isNull) {
				return String.format("{NUMBER %s %s %s *NULL*}", nameLabel, contextRef, unitRef);
			} else {
				if (sign == null) {
					if (format == null) {
						return String.format("{NUMBER %s %s %s %s *NULL* %s %s}", nameLabel, contextRef, unitRef, value, decimals, scale);
					} else {
						return String.format("{NUMBER %s %s %s %s %s %s %s}", nameLabel, contextRef, unitRef, value, format, decimals, scale);
					}
				} else {
					if (isMinus) {
						return String.format("{NUMBER %s %s %s %s %s %s %s *MINUS*}", nameLabel, contextRef, unitRef, value, format, decimals, scale);
					} else {
						return String.format("{NUMBER %s %s %s %s %s %s %s}", nameLabel, contextRef, unitRef, value, format, decimals, scale);
					}
				}
			}
		}
	}
}
