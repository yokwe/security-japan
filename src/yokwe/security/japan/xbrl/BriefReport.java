package yokwe.security.japan.xbrl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public static @interface Value {
		TSE_ED_T_LABEL label();
		Context[]      contextIncludeAll()   default {};
		Context[]      contextExcludeAny()   default {};
		boolean        acceptNull()          default false;
	}
	// type of field can be InlineXBRL, String, Boolean, BigDecimal, boolean, int, long, float, double
	
	
	private static class ClassInfo {
		static Map<String, ClassInfo> cache = new TreeMap<>();
		
		final String                       className;
		final List<FieldInfo>              fieldInfoList;
		
		static ClassInfo get(Class<? extends BriefReport> clazz) {
			String className = clazz.getName();
			if (cache.containsKey(className)) {
				return cache.get(className);
			} else {
				ClassInfo classInfo = new ClassInfo(clazz);
				cache.put(className, classInfo);
				return classInfo;
			}
		}
		
		ClassInfo(Class<? extends BriefReport> clazz) {
			this.className     = clazz.getName();
			this.fieldInfoList = new ArrayList<>();
			
			for(Field field: clazz.getDeclaredFields()) {
				if (field.isAnnotationPresent(Value.class)) {
					Value annotation = field.getDeclaredAnnotation(Value.class);
					FieldInfo fieldInfo = new FieldInfo(field, annotation);
					
					// Sanity check
					{
						String   fieldName = fieldInfo.fieldName;
						Class<?> fieldType = fieldInfo.fieldType;
						int      modifiers = field.getModifiers();
						
						if (Modifier.isStatic(modifiers)) {
							logger.error("Unexpected modifiers static  {} {}", className, fieldName);
							throw new UnexpectedException("Unexpected modifiers static");
						}
						if (Modifier.isFinal(modifiers)) {
							logger.error("Unexpected modifiers final  {} {}", className, fieldName);
							throw new UnexpectedException("Unexpected modifiers final");
						}
						if (!Modifier.isPublic(modifiers)) {
							logger.error("Unexpected modifiers not public  {} {}", className, fieldName);
							throw new UnexpectedException("Unexpected modifiers not public");
						}
						
						if (fieldType.isArray()) {
							logger.error("Unexpected field is array  {} {}", className, fieldName);
							throw new UnexpectedException("Unexpected field is array");
						}
					}

					fieldInfoList.add(fieldInfo);
				}
			}
		}
	}
	
	private static class FieldInfo {
		final Field    field;
		final String   fieldName;
		final Class<?> fieldType;
		final String   fieldTypeName;
		final boolean  fieldIsPrimitive;
		
		final QValue    qName;
		final Context[] contextIncludeAll;
		final Context[] contextExcludeAny;
		final boolean   acceptNull;

		FieldInfo(Field field, Value annotation) {
			this.field            = field;
			this.fieldName        = field.getName();
			this.fieldType        = field.getType();
			this.fieldTypeName    = fieldType.getName();
			this.fieldIsPrimitive = fieldType.isPrimitive();
			
			this.qName             = annotation.label().qName;
			this.contextIncludeAll = annotation.contextIncludeAll();
			this.contextExcludeAny = annotation.contextExcludeAny();
			this.acceptNull        = annotation.acceptNull();
		}
	}
	
	private void assignField(FieldInfo fieldInfo, InlineXBRL.StringValue value) throws IllegalArgumentException, IllegalAccessException {
		final String fieldName = fieldInfo.fieldName;
		final String fieldTypeName = fieldInfo.fieldTypeName;
		
		switch(fieldTypeName) {
		case "java.lang.String":
			fieldInfo.field.set(this, value.stringValue);
			break;
		default:
			logger.error("Unexpected field type");
			logger.error("   fieldName     {}", fieldName);
			logger.error("   fieldTypeName {}", fieldTypeName);
			throw new UnexpectedException("Unexpected field type");
		}
	}
	private void assignField(FieldInfo fieldInfo, InlineXBRL.BooleanValue value) throws IllegalArgumentException, IllegalAccessException {
		final String fieldName = fieldInfo.fieldName;
		final String fieldTypeName = fieldInfo.fieldTypeName;
		
		switch(fieldTypeName) {
		case "boolean":
			fieldInfo.field.setBoolean(this, value.booleanValue);
			break;
		default:
			logger.error("Unexpected field type");
			logger.error("   fieldName     {}", fieldName);
			logger.error("   fieldTypeName {}", fieldTypeName);
			throw new UnexpectedException("Unexpected field type");
		}
	}
	private void assignField(FieldInfo fieldInfo, InlineXBRL.NumberValue value) throws IllegalArgumentException, IllegalAccessException {
		final Field  field         = fieldInfo.field;
		final String fieldName     = fieldInfo.fieldName;
		final String fieldTypeName = fieldInfo.fieldTypeName;

		switch(fieldTypeName) {
		case "yokwe.security.japan.xbrl.InlineXBRL":
			field.set(this, (InlineXBRL)value);
			break;
		case "java.math.BigDecimal":
			field.set(this, value.numberValue);
			break;
		// FLOAT
		case "float":
		case "java.lang.Float":
		{
			float floatValue = value.numberValue.floatValue();
			if (floatValue == Float.POSITIVE_INFINITY || floatValue == Float.POSITIVE_INFINITY) {
				logger.error("Float value is infinity");
				logger.error("   fieldName     {}", fieldName);
				logger.error("   value         {}", value.numberValue);
				throw new UnexpectedException("Unexpected field type");
			}
			if (floatValue == Float.NaN) {
				logger.error("Float value is not a number");
				logger.error("   fieldName     {}", fieldName);
				logger.error("   value         {}", value.numberValue);
				throw new UnexpectedException("Unexpected field type");
			}
			
			if (fieldInfo.fieldIsPrimitive) {
				field.setFloat(this, floatValue);
			} else {
				field.set(this, new Float(floatValue));
			}
		}
			break;
		// DOUBLE
		case "double":
		case "java.lang.Double":
		{
			double doubleValue = value.numberValue.doubleValue();
			if (doubleValue == Double.POSITIVE_INFINITY || doubleValue == Double.POSITIVE_INFINITY) {
				logger.error("Float value overflow");
				logger.error("   fieldName     {}", fieldName);
				logger.error("   value         {}", value.numberValue);
				throw new UnexpectedException("Unexpected field type");
			}
			if (doubleValue == Double.NaN) {
				logger.error("Float value is not a number");
				logger.error("   fieldName     {}", fieldName);
				logger.error("   value         {}", value.numberValue);
				throw new UnexpectedException("Unexpected field type");
			}
			if (fieldInfo.fieldIsPrimitive) {
				field.setDouble(this, doubleValue);
			} else {
				field.set(this, new Double(doubleValue));
			}
		}
			break;
		// INT INTEGER
		case "int":
		{
			int intValue = value.numberValue.intValueExact();
			field.setInt(this, intValue);
		}
			break;
		case "java.lang.Integer":
		{
			int intValue = value.numberValue.intValueExact();
			field.set(this, new Integer(intValue));
		}
			break;

		// LONG
		case "long":
		{
			long longValue = value.numberValue.longValueExact();
			field.setLong(this, longValue);
		}
			break;
		case "java.lang.Long":
		{
			long longValue = value.numberValue.longValueExact();
			field.set(this, new Long(longValue));
		}
			break;

		default:
			logger.error("Unexpected field type");
			logger.error("   fieldName     {}", fieldName);
			logger.error("   fieldTypeName {}", fieldTypeName);
			throw new UnexpectedException("Unexpected field type");
		}
	}
	
	protected void init(InlineXBRL.Document ixDoc) {
		// use reflection to initialize annotated variable in class
		ClassInfo classInfo = ClassInfo.get(this.getClass());
		for(FieldInfo fieldInfo: classInfo.fieldInfoList) {
			final Field    field            = fieldInfo.field;
			final String   fieldName        = fieldInfo.fieldName;
			final boolean  fieldIsPrimitive = fieldInfo.fieldIsPrimitive;
			
			final QValue    qName             = fieldInfo.qName;
			final Context[] contextIncludeAll = fieldInfo.contextIncludeAll;
			final Context[] contextExcludeAny = fieldInfo.contextExcludeAny;
			final boolean   acceptNull        = fieldInfo.acceptNull;
			
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
							logger.info("  {}  value = *NULL*", fieldName);
							
							if (fieldIsPrimitive) {
								logger.error("Field cannot be null {}", fieldName);
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
						logger.info("  {}  value = {} {}", fieldName, ix.kind, ix.value);
						
						switch(ix.kind) {
						case STRING:
							assignField(fieldInfo, (InlineXBRL.StringValue)ix);
							break;
						case BOOLEAN:
							assignField(fieldInfo, (InlineXBRL.BooleanValue)ix);
							break;
						case NUMBER:
							assignField(fieldInfo, (InlineXBRL.NumberValue)ix);
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
