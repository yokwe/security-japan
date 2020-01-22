package yokwe.security.japan.xbrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.slf4j.LoggerFactory;

import yokwe.util.XMLUtil.QValue;
import yokwe.util.XMLUtil.XMLElement;

public class InlineXBRLMap {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(InlineXBRLMap.class);

	private static final List<InlineXBRL> EMPTY_LIST = Collections.unmodifiableList(new ArrayList<>());
	
	private final List<InlineXBRL>              all;
	private final Map<QValue, List<InlineXBRL>> map;

	private InlineXBRLMap(List<InlineXBRL> all, Map<QValue, List<InlineXBRL>> map) {
		this.all = all;
		this.map = map;
	}
	private static void buildListMap(List<InlineXBRL> all, Map<QValue, List<InlineXBRL>> map, InlineXBRL ix) {
		all.add(ix);
		
		QValue qName = ix.qName;
		
		List<InlineXBRL> list;
		if (map.containsKey(qName)) {
			list = map.get(qName);
		} else {
			list = new ArrayList<>();
			map.put(qName, list);
		}
		list.add(ix);
	}
	public static InlineXBRLMap getInstance(Stream<XMLElement> stream) {
		List<InlineXBRL>              all = new ArrayList<>();
		Map<QValue, List<InlineXBRL>> map = new TreeMap<>();
		
		stream.filter(InlineXBRL::canGetInstance).forEach(o -> buildListMap(all, map, InlineXBRL.getInstance(o)));
		
		// Make unmodifiable list
		Map<QValue, List<InlineXBRL>> map2 = new TreeMap<>();
		for(Map.Entry<QValue, List<InlineXBRL>> entry: map.entrySet()) {
			QValue key = entry.getKey();
			List<InlineXBRL> value = entry.getValue();
			map2.put(key, Collections.unmodifiableList(value));
		}
		
		return new InlineXBRLMap(Collections.unmodifiableList(all), Collections.unmodifiableMap(map2));
	}
	
	public List<InlineXBRL> getList() {
		return all;
	}
	public Stream<InlineXBRL> getStream() {
		List<InlineXBRL> list = getList();
		return list.stream();
	}
	
	public List<InlineXBRL> getList(QValue qName) {
		if (map.containsKey(qName)) {
			return map.get(qName);
		} else {
			return EMPTY_LIST;
		}
	}
	public Stream<InlineXBRL> getStream(QValue qName) {
		List<InlineXBRL> list = getList(qName);
		return list.stream();
	}

	private static class ContextFilter implements Predicate<InlineXBRL>  {
		private final List<String> contextList;
		private ContextFilter(String... contextNames) {
			this.contextList = Arrays.asList(contextNames);
		}
		
		@Override
		public boolean test(InlineXBRL ix) {
			return ix.contextSet.containsAll(contextList);
		}
	}
	
	public static Predicate<InlineXBRL> contextFilter(String... contextNames) {
		return new ContextFilter(contextNames);
	}
	
	public static boolean booleanFilter(InlineXBRL ix) {
		return ix.kind == InlineXBRL.Kind.BOOLEAN;
	}
	public static boolean numberFilter(InlineXBRL ix) {
		return ix.kind == InlineXBRL.Kind.NUMBER;
	}
	public static boolean stringFilter(InlineXBRL ix) {
		return ix.kind == InlineXBRL.Kind.STRING;
	}
	public static boolean notNullFilter(InlineXBRL ix) {
		return !ix.isNull;
	}
}
