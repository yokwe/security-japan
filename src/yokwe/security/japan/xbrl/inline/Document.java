package yokwe.security.japan.xbrl.inline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

import yokwe.util.XMLUtil.QValue;
import yokwe.util.XMLUtil.XMLElement;

public class Document {
	private static final List<InlineXBRL> EMPTY_LIST = Collections.unmodifiableList(new ArrayList<>());

	private final List<InlineXBRL>              all;
	private final Map<QValue, List<InlineXBRL>> map;
	
	private Document(List<InlineXBRL> all, Map<QValue, List<InlineXBRL>> map) {
		this.all = all;
		this.map = map;
	}

	private static void buildMap(List<InlineXBRL> all, Map<QValue, List<InlineXBRL>> map, InlineXBRL ix) {
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
	
	public static Document getInstance(Stream<XMLElement> stream) {
		List<InlineXBRL>              all = new ArrayList<>();
		Map<QValue, List<InlineXBRL>> map = new TreeMap<>();
		
		stream.filter(InlineXBRL::canGetInstance).forEach(o -> buildMap(all, map, InlineXBRL.getInstance(o)));
		
		// Make unmodifiable element of map
		Map<QValue, List<InlineXBRL>> map2 = new TreeMap<>();
		for(Map.Entry<QValue, List<InlineXBRL>> entry: map.entrySet()) {
			QValue key = entry.getKey();
			List<InlineXBRL> value = entry.getValue();
			map2.put(key, Collections.unmodifiableList(value));
		}

		return new Document(Collections.unmodifiableList(all), Collections.unmodifiableMap(map2));
	}

	public List<InlineXBRL> getList() {
		return all;
	}
	public Stream<InlineXBRL> getStream() {
		return getList().stream();
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
	
	private Set<String> contextSet = null;
	public Set<String> getContextSet() {
		if (contextSet == null) {
			Set<String> set = new TreeSet<>();
			getList().stream().forEach(o -> set.addAll(o.contextSet));
			contextSet = Collections.unmodifiableSet(set);
		}
		return contextSet;
	}
}