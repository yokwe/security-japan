package yokwe.security.japan.xbrl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.xbrl.taxonomy.TSE_ED_T_LABEL;
import yokwe.util.XMLUtil.QValue;
import yokwe.util.XMLUtil.XMLElement;

public abstract class BriefReport {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(BriefReport.class);

	public static final String NAMESPACE = TSE_ED_T_LABEL.NAMESPACE;
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public static @interface Value {
		String   namespace()  default NAMESPACE;
		String   name();
		String[] contexts()   default {};
		boolean  acceptNull() default false;
	}
	// type of field can be String, Boolean, BigDecimal, boolean, int, long, float, double
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public static @interface Context {
		String   namespace()  default NAMESPACE;
		String   name();
	}
	// type of field can be String or List<String>
	
	private static class Info {
		public final QValue qName;
		public final Field  field;
		public final String fieldName;
		public final String fieldType;
		
		Info(QValue qName, Field field) {
			this.qName     = qName;
			this.field     = field;
			this.fieldName = field.getName();
			this.fieldType = field.getType().getName();
		}
		
		@Override
		public String toString() {
			return String.format("%s %s %s", qName, fieldName, fieldType);
		}
	}
	
	private static class ValueInfo extends Info {
		public final List<String> contextList;  // can be empty
		public final boolean  acceptNull;
		
		ValueInfo(Field field, Value value) {
			super(new QValue(value.namespace(), value.name()), field);

			this.contextList = Arrays.asList(value.contexts());
			this.acceptNull  = value.acceptNull();
		}
		
		@Override
		public String toString() {
			return String.format("{%s %s %s}", super.toString(), contextList, acceptNull);
		}
	}
	private static class ContextInfo extends Info {
		ContextInfo(Field field, Context context) {
			super(new QValue(context.namespace(), context.name()), field);
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", super.toString());
		}
	}
	
	private void forEach(Map<QValue, List<Info>> infoMap, XMLElement e) {
		if (InlineXBRL.canGetInstance(e)) {
			InlineXBRL ix = InlineXBRL.getInstance(e);
			if (infoMap.containsKey(ix.qName)) {
				List<Info> infoList = infoMap.get(ix.qName);
				
				logger.info("ix {}", ix.qName);
				for(Info info: infoList) {
					if (info instanceof ValueInfo) {
						ValueInfo valueInfo = (ValueInfo)info;
						
						logger.info("valueInfo {}", valueInfo);
					}
					if (info instanceof ContextInfo) {
						ContextInfo contextInfo = (ContextInfo)info;
						
						logger.info("contextInfo {}", contextInfo);
					}
				}
			}
		}
	}
	public void init(Stream<XMLElement> stream) {
		Map<QValue, List<Info>> infoMap = new TreeMap<>();
		
		// use reflection to initialize annotated variable in class
		for(Field field: this.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Value.class)) {
				Value     annotation = field.getDeclaredAnnotation(Value.class);
				ValueInfo info       = new ValueInfo(field, annotation);
				
				logger.info("VALUE   {}", info);
				
				QValue     key = info.qName;
				List<Info> value;
				if (infoMap.containsKey(key)) {
					value = infoMap.get(key);
				} else {
					value = new ArrayList<>();
				}
				value.add(info);

				infoMap.put(key, value);
			}
			if (field.isAnnotationPresent(Context.class)) {
				Context     annotation = field.getDeclaredAnnotation(Context.class);
				ContextInfo info       = new ContextInfo(field, annotation);
				
				logger.info("CONTEXT {}", info);

				QValue     key = info.qName;
				List<Info> value;
				if (infoMap.containsKey(key)) {
					value = infoMap.get(key);
				} else {
					value = new ArrayList<>();
				}
				value.add(info);

				infoMap.put(key, value);
			}
		}
		logger.info("infoMap {}", infoMap.size());
		stream.filter(InlineXBRL::canGetInstance).forEach(o -> forEach(infoMap, o));
		
	}
	
}
