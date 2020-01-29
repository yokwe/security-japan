package yokwe.security.japan.xbrl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.xbrl.InlineXBRL.Context;
import yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL;
import yokwe.util.XMLUtil.QValue;
import yokwe.util.XMLUtil.XMLElement;

public abstract class BriefReport {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(BriefReport.class);

	public static final String NAMESPACE = TSE_ED_T_LABEL.NAMESPACE;
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public static @interface Value {
		TSE_ED_T_LABEL label();
		Context[] contextIncludeAll()   default {};
		Context[] contextExcludeAny()   default {};
		boolean   acceptNull()          default false;
	}
	// type of field can be InlineXBRL, String, Boolean, BigDecimal, boolean, int, long, float, double
	
	
	protected void init(InlineXBRL.Document ixDoc) {
		// TODO implement this
		// use reflection to initialize annotated variable in class
		for(Field field: this.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Value.class)) {
				String   fieldName        = field.getName();
				Class<?> fieldType        = field.getType();
				String   fieldTypeName    = fieldType.getName();
				boolean  fieldIsPrimitive = fieldType.isPrimitive();
				
				logger.info("field {}  {}", fieldName, fieldTypeName);
				{
					// Sanity check
					int modifiers = field.getModifiers();
					if (Modifier.isStatic(modifiers)) {
						logger.error("Unexpected modifiers static  {}", fieldName);
						throw new UnexpectedException("Unexpected modifiers static");
					}
					if (Modifier.isFinal(modifiers)) {
						logger.error("Unexpected modifiers final  {}", fieldName);
						throw new UnexpectedException("Unexpected modifiers final");
					}
					if (!Modifier.isPublic(modifiers)) {
						logger.error("Unexpected modifiers not public  {}", fieldName);
						throw new UnexpectedException("Unexpected modifiers not public");
					}
					
					if (fieldType.isArray()) {
						logger.error("Unexpected field is array  {}", fieldName);
						throw new UnexpectedException("Unexpected field is array");
					}
				}
				
				
				Value annotation = field.getDeclaredAnnotation(Value.class);
				QValue    qName             = annotation.label().qName;
				Context[] contextIncludeAll = annotation.contextIncludeAll();
				Context[] contextExcludeAny = annotation.contextExcludeAny();
				boolean   acceptNull        = annotation.acceptNull();
				
				List<InlineXBRL> list = ixDoc.getStream(qName).filter(InlineXBRL.contextIncludeAll(contextIncludeAll)).filter(InlineXBRL.contextExcludeAny(contextExcludeAny)).collect(Collectors.toList());
				int size = list.size();
				
				try {
					if (size == 0) {
						// doesn't exist
						logger.error("No matching entry");
						logger.error("   namespace         {}", qName.namespace);
						logger.error("   name              {}", qName.value);
						logger.error("   contextIncludeAll {}", Arrays.asList(contextIncludeAll));
						logger.error("   contextExcludeAny {}", Arrays.asList(contextExcludeAny));
						throw new UnexpectedException("No matching entry");
					} else if (list.size() == 1) {
						InlineXBRL ix = list.get(0);
						if (ix.isNull) {
							if (acceptNull) {
								logger.info("  value = *NULL*");
								
								if (fieldIsPrimitive) {
									logger.error("Field cannot be null {}", fieldTypeName);
									logger.error("   namespace         {}", qName.namespace);
									logger.error("   name              {}", qName.value);
									logger.error("   contextIncludeAll {}", Arrays.asList(contextIncludeAll));
									logger.error("   contextExcludeAny {}", Arrays.asList(contextExcludeAny));
									throw new UnexpectedException("Field cannot be null");
								}
								field.set(this, null);
							} else {
								logger.error("Entry is null");
								logger.error("   namespace         {}", qName.namespace);
								logger.error("   name              {}", qName.value);
								logger.error("   contextIncludeAll {}", Arrays.asList(contextIncludeAll));
								logger.error("   contextExcludeAny {}", Arrays.asList(contextExcludeAny));
								throw new UnexpectedException("Entry is null");
							}
						} else {
							// not null
							logger.info("  value = {} {}", ix.kind, ix.value);
							
							switch(ix.kind) {
							case STRING:
							{
								InlineXBRL.StringValue stringValue = (InlineXBRL.StringValue)ix;
								switch(fieldTypeName) {
								case "java.lang.String":
									field.set(this, stringValue.stringValue);
									break;
								default:
									logger.error("Unexpected field type");
									logger.error("   fieldName     {}", fieldName);
									logger.error("   fieldTypeName {}", fieldTypeName);
									throw new UnexpectedException("Unexpected field type");
								}
							}
								break;
							case BOOLEAN:
							{
								InlineXBRL.BooleanValue booleanValue = (InlineXBRL.BooleanValue)ix;
								switch(fieldTypeName) {
								case "boolean":
									field.setBoolean(this, booleanValue.booleanValue);
									break;
								default:
									logger.error("Unexpected field type");
									logger.error("   fieldName     {}", fieldName);
									logger.error("   fieldTypeName {}", fieldTypeName);
									throw new UnexpectedException("Unexpected field type");
								}
							}
								break;
							case NUMBER:
								InlineXBRL.NumberValue numberValue = (InlineXBRL.NumberValue)ix;
								switch(fieldTypeName) {
								case "yokwe.security.japan.xbrl.InlineXBRL":
									field.set(this, ix);
									break;
								case "java.math.BigDecimal":
									field.set(this, numberValue.numberValue);
									break;
								// FLOAT
								case "float":
								{
									float floatValue = numberValue.numberValue.floatValue();
									if (floatValue == Float.POSITIVE_INFINITY | floatValue == Float.POSITIVE_INFINITY) {
										logger.error("Float value overflow");
										logger.error("   fieldName     {}", fieldName);
										logger.error("   value         {}", numberValue.numberValue);
										throw new UnexpectedException("Unexpected field type");
									}
									if (floatValue == Float.NaN) {
										logger.error("Float value is not a number");
										logger.error("   fieldName     {}", fieldName);
										logger.error("   value         {}", numberValue.numberValue);
										throw new UnexpectedException("Unexpected field type");
									}
									field.setFloat(this, floatValue);
								}
									break;
								case "java.lang.Float":
								{
									float floatValue = numberValue.numberValue.floatValue();
									if (floatValue == Float.POSITIVE_INFINITY | floatValue == Float.POSITIVE_INFINITY) {
										logger.error("Float value overflow");
										logger.error("   fieldName     {}", fieldName);
										logger.error("   value         {}", numberValue.numberValue);
										throw new UnexpectedException("Unexpected field type");
									}
									if (floatValue == Float.NaN) {
										logger.error("Float value is not a number");
										logger.error("   fieldName     {}", fieldName);
										logger.error("   value         {}", numberValue.numberValue);
										throw new UnexpectedException("Unexpected field type");
									}
									field.set(this, new Float(floatValue));
								}
									break;
									
								// DOUBLE
								case "double":
								{
									double doubleValue = numberValue.numberValue.doubleValue();
									if (doubleValue == Double.POSITIVE_INFINITY | doubleValue == Double.POSITIVE_INFINITY) {
										logger.error("Float value overflow");
										logger.error("   fieldName     {}", fieldName);
										logger.error("   value         {}", numberValue.numberValue);
										throw new UnexpectedException("Unexpected field type");
									}
									if (doubleValue == Double.NaN) {
										logger.error("Float value is not a number");
										logger.error("   fieldName     {}", fieldName);
										logger.error("   value         {}", numberValue.numberValue);
										throw new UnexpectedException("Unexpected field type");
									}
									field.setDouble(this, doubleValue);
								}
									break;
								case "java.lang.Double":
								{
									double doubleValue = numberValue.numberValue.doubleValue();
									if (doubleValue == Double.POSITIVE_INFINITY | doubleValue == Double.POSITIVE_INFINITY) {
										logger.error("Float value overflow");
										logger.error("   fieldName     {}", fieldName);
										logger.error("   value         {}", numberValue.numberValue);
										throw new UnexpectedException("Unexpected field type");
									}
									if (doubleValue == Double.NaN) {
										logger.error("Float value is not a number");
										logger.error("   fieldName     {}", fieldName);
										logger.error("   value         {}", numberValue.numberValue);
										throw new UnexpectedException("Unexpected field type");
									}
									field.set(this, new Double(doubleValue));
								}
									break;
									
								// INT INTEGER
								case "int":
								{
									int intValue = numberValue.numberValue.intValueExact();
									field.setInt(this, intValue);
								}
									break;
								case "java.lang.Integer":
								{
									int intValue = numberValue.numberValue.intValueExact();
									field.set(this, new Integer(intValue));
								}
									break;

								// LONG
								case "long":
								{
									long longValue = numberValue.numberValue.longValueExact();
									field.setLong(this, longValue);
								}
									break;
								case "java.lang.Long":
								{
									long longValue = numberValue.numberValue.longValueExact();
									field.set(this, new Long(longValue));
								}
									break;

								default:
									logger.error("Unexpected field type");
									logger.error("   fieldName     {}", fieldName);
									logger.error("   fieldTypeName {}", fieldTypeName);
									throw new UnexpectedException("Unexpected field type");
								}
								break;
							default:
								logger.error("Unexpected kind");
								logger.error("   ix {}", ix);
								throw new UnexpectedException("Unexpected kind");
							}
						}
					} else {
						// multiple hit
						logger.error("More than one matching entry");
						logger.error("   namespace         {}", qName.namespace);
						logger.error("   name              {}", qName.value);
						logger.error("   contextIncludeAll {}", Arrays.asList(contextIncludeAll));
						logger.error("   contextExcludeAny {}", Arrays.asList(contextExcludeAny));
						for(int i = 0; i < list.size(); i++) {
							logger.error("  {}  {}", i, list.get(i));
						}
						throw new UnexpectedException("More than one matching entry");
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					String exceptionName = e.getClass().getSimpleName();
					logger.error("{} {}", exceptionName, e);
					throw new UnexpectedException(exceptionName, e);
				}
			}
		}
	}

	public static <E extends BriefReport> E getInstance(Class<E> clazz, InlineXBRL.Document ixDoc) {
		try {
			E ret = clazz.newInstance();
			ret.init(ixDoc);
			return ret;
		} catch (InstantiationException | IllegalAccessException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
	}
	
	public static <E extends BriefReport> E getinstance(Class<E> clazz, Stream<XMLElement> stream) {
		InlineXBRL.Document document = InlineXBRL.Document.getInstance(stream);
		return getInstance(clazz, document);
	}
}
