package yokwe.security.japan.xbrl.inline;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.xbrl.XBRL;
import yokwe.security.japan.xbrl.XML;
import yokwe.util.XMLUtil.QValue;
import yokwe.util.XMLUtil.XMLElement;

public abstract class InlineXBRL {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(InlineXBRL.class);

	public enum Kind {
		STRING, BOOLEAN, DATE, NUMBER
	}
	
	private interface Builder {
		public InlineXBRL getInstance(XMLElement xmlElement);
	}
	
	private static class BooleanBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			return new BooleanValue(xmlElement);
		}
	}
	private static class DateBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			return new DateValue(xmlElement);
		}
	}
	private static class NumberBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			return new NumberValue(xmlElement);
		}
	}
	
	private static Map<QValue, Builder> nonNumericBuilderMap = new TreeMap<>();
	static {
		nonNumericBuilderMap.put(XBRL.IXT_BOOLEAN_TRUE,               new BooleanBuilder());
		nonNumericBuilderMap.put(XBRL.IXT_BOOLEAN_FALSE,              new BooleanBuilder());
		nonNumericBuilderMap.put(XBRL.IXT_DATE_YEAR_MONTH_DAY_CJK,    new DateBuilder());
		nonNumericBuilderMap.put(XBRL.IXT_DATE_ERA_YEAR_MONTH_DAY_JP, new DateBuilder());
	}
	private static class NonNumericBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			QValue qFormat = getQFormat(xmlElement);
			if (qFormat == null) {
				return new StringValue(xmlElement);
			} else {
				if (nonNumericBuilderMap.containsKey(qFormat)) {
					Builder builder = nonNumericBuilderMap.get(qFormat);
					return builder.getInstance(xmlElement);
				} else {
					logger.error("Unexpected xmlElement {}", xmlElement);
					logger.error("  qFormat {}", qFormat);
					throw new UnexpectedException("Unexpected xmlElement");	
				}
			}
		}
	}
	
	private static Map<QValue, Builder> nonFractionalBuilderMap = new TreeMap<>();
	static {
		nonFractionalBuilderMap.put(XBRL.IXT_NUM_DOT_DECIMAL,  new NumberBuilder());
		nonFractionalBuilderMap.put(XBRL.IXT_NUM_UNIT_DECIMAL, new NumberBuilder());
	}
	private static class NonFractionBuilder implements Builder {
		public InlineXBRL getInstance(XMLElement xmlElement) {
			if (isNull(xmlElement)) {
				return new NumberValue(xmlElement);
			} else {
				QValue qFormat = getQFormat(xmlElement);
				if (qFormat == null) {
					return new NumberValue(xmlElement);
				} else {
					if (nonFractionalBuilderMap.containsKey(qFormat)) {
						Builder builder = nonFractionalBuilderMap.get(qFormat);
						return builder.getInstance(xmlElement);
					} else {
						logger.error("Unexpected format");
						logger.error("  qFormat {}", qFormat);
						throw new UnexpectedException("Unexpected format");
					}
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
			logger.error("Unexpected key {}", key);
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
	public static QValue getQName(XMLElement xmlElement) {
		String name  = xmlElement.getAttribute("name");
		QValue qName = xmlElement.expandNamespacePrefix(name);
		return qName;
	}
	public static QValue getQFormat(XMLElement xmlElement) {
		String format = xmlElement.getAttributeOrNull("format");
		return (format == null) ? null : xmlElement.expandNamespacePrefix(format);
	}
	public static boolean isNull(XMLElement xmlElement) {
		String nilValue = xmlElement.getAttributeOrNull(XML.XSI_NIL);
		if (nilValue == null) {
			return false;
		} else {
			switch(nilValue) {
			case "true":
				return true;
//			case "false":
//				this.isNull = false;
//				break;
			default:
				logger.error("Unexpected nilValue {}!", nilValue);
				throw new UnexpectedException("Unexpected nilValue");
			}
		}
	}
	
	public static String normalizeNumberCharacter(String value) {
		// １２３４５６７８９０
		value = value.replace("１", "1");
		value = value.replace("２", "2");
		value = value.replace("３", "3");
		value = value.replace("４", "4");
		value = value.replace("５", "5");
		value = value.replace("６", "6");
		value = value.replace("７", "7");
		value = value.replace("８", "8");
		value = value.replace("９", "9");
		value = value.replace("０", "0");

		// Remove space in value
		value = value.replace(" ", "");
		
		// 0.0<br/>
		value = value.replace("<br/>", "");
		// 0.0<br />
		value = value.replace("<br />", "");
		
		return value;
	}

	public final Kind       kind;
	public final XMLElement xmlElement;
	
	public final Set<String> contextSet;
	
	public final String  name;
	public final String  format;
	public final String  value;
	
	public final QValue  qName;
	public final QValue  qFormat;
	public final boolean isNull;

	protected InlineXBRL(Kind kind, XMLElement xmlElement) {
		this.kind         = kind;
		this.xmlElement   = xmlElement;
		
		{
			String contextRef = xmlElement.getAttribute("contextRef");
			TreeSet<String> set = new TreeSet<>(Arrays.asList(contextRef.split("_")));
			this.contextSet = Collections.unmodifiableSet(set);
		}
		
		this.name   = xmlElement.getAttribute("name");
		this.format = xmlElement.getAttributeOrNull("format");
		this.value  = xmlElement.content;
		
		this.qName   = getQName(xmlElement);
		this.qFormat = getQFormat(xmlElement);
		this.isNull  = isNull(xmlElement);
	}
	
	
	private static class ContextIncludeAllFilter implements Predicate<InlineXBRL>  {
		private final List<String> contextList;
		private ContextIncludeAllFilter(Context... contexts) {
			contextList = Arrays.stream(contexts).map(o -> o.toString()).collect(Collectors.toList());
		}
		
		@Override
		public boolean test(InlineXBRL ix) {
			return ix.contextSet.containsAll(contextList);
		}
	}
	public static Predicate<InlineXBRL> contextIncludeAll(Context... contexts) {
		return new ContextIncludeAllFilter(contexts);
	}
	
	private static class ContextExcludeAnyFilter implements Predicate<InlineXBRL>  {
		private final List<String> contextList;
		private ContextExcludeAnyFilter(Context... contexts) {
			contextList = Arrays.stream(contexts).map(o -> o.toString()).collect(Collectors.toList());
		}
		
		@Override
		public boolean test(InlineXBRL ix) {
			for(String context: contextList) {
				if (ix.contextSet.contains(context)) return false;
			}
			return true;
		}
	}
	public static Predicate<InlineXBRL> contextExcludeAny(Context... contexts) {
		return new ContextExcludeAnyFilter(contexts);
	}
	
	private static class NullFilter implements Predicate<InlineXBRL>  {
		private final boolean acceptNull;
		private NullFilter(boolean acceptNull) {
			this.acceptNull = acceptNull;
		}
		
		@Override
		public boolean test(InlineXBRL ix) {
			if (ix.isNull) {
				return acceptNull;
			} else {
				return true;
			}
		}
	}
	public static Predicate<InlineXBRL> nullFilter(boolean acceptNull) {
		return new NullFilter(acceptNull);
	}
}
