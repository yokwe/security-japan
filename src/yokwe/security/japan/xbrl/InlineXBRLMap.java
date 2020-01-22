package yokwe.security.japan.xbrl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.XMLUtil.QValue;
import yokwe.util.XMLUtil.XMLElement;

public class InlineXBRLMap {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(InlineXBRLMap.class);

	private static class Key implements Comparable <Key>{
		final QValue      qName;
		final Set<String> contextSet;
		
		final String contextString;
		
		Key(InlineXBRL e) {
			this.qName      = e.qName;
			this.contextSet = e.contextSet;
			
			this.contextString = contextSet.toString();
		}

		@Override
		public int compareTo(Key that) {
			int ret = this.qName.compareTo(that.qName);
			if (ret == 0) ret = this.contextString.compareTo(that.contextString);
			return ret;
		}
		@Override
		public boolean equals(Object o) {
			if (o == null) {
				return false;
			} else {
				if (o instanceof Key) {
					Key that = (Key)o;
					return this.compareTo(that) == 0;
				} else {
					return false;
				}
			}
		}
		@Override
		public String toString() {
			return String.format("{%s %s}", qName.toString(), contextString);
		}
	}
	private final Map<Key,    InlineXBRL>      keyMap;
	private final Map<QValue, List<InlineXBRL>> qNameMap;

	private InlineXBRLMap() {
		this.keyMap   = new TreeMap<>();
		this.qNameMap = new TreeMap<>();
	}
	private void addElement(InlineXBRL e) {
		{
			Key key = new Key(e);
			if (keyMap.containsKey(key)) {
				logger.error("Duplicakte key {}", key);
				logger.error("old {}", keyMap.get(key));
				logger.error("new {}", e);
				throw new UnexpectedException("Duplicakte key");
			} else {
				keyMap.put(key, e);
			}
		}
		
		{
			QValue qName = e.qName;
			List<InlineXBRL> list;
			if (qNameMap.containsKey(qName)) {
				list = qNameMap.get(qName);
			} else {
				list = new ArrayList<>();
			}
			list.add(e);
		}
	}
	public static InlineXBRLMap getInstance(Stream<XMLElement> stream) {
		InlineXBRLMap ret = new InlineXBRLMap();
		
		stream.filter(o -> InlineXBRL.canGetInstance(o)).forEach(o -> ret.addElement(InlineXBRL.getInstance(o)));
		
		return ret;
	}
	
	public List<InlineXBRL> getList(QValue qName) {
		if (qNameMap.containsKey(qName)) {
			return qNameMap.get(qName);
		} else {
			return null;
		}
	}
	public InlineXBRL get(QValue qName) {
		List<InlineXBRL> list = getList(qName);
		if (list != null) {
			if (list.size() == 1) {
				return list.get(0);
			} else {
				logger.error("Unexpected multiple entries {} {}", qName, list.size());
				for(int i = 0; i < list.size(); i++) {
					logger.error("  {} {}", i, list.get(i));
				}
				throw new UnexpectedException("Unexpected multiple entries");
			}
		} else {
			return null;
		}
	}
	public boolean contains(QValue qName) {
		List<InlineXBRL> list = getList(qName);
		return list.size() == 1;
	}
	
	public List<InlineXBRL> getList(QValue qName, String context) {
		List<InlineXBRL> ret = new ArrayList<>();
		List<InlineXBRL> list = getList(qName);
		for(InlineXBRL ix: list) {
			if (ix.contextSet.contains(context)) ret.add(ix);
		}
		return ret;
	}
	public InlineXBRL get(QValue qName, String context) {
		List<InlineXBRL> list = getList(qName, context);
		if (list.size() == 1) {
			return list.get(0);
		} else {
			logger.error("Unexpected multiple entries {} {}", qName, list.size());
			for(int i = 0; i < list.size(); i++) {
				logger.error("  {} {}", i, list.get(i));
			}
			throw new UnexpectedException("Unexpected multiple entries");
		}
	}

	
	public InlineXBRL get(QValue qName, InlineXBRL.Kind kind) {
		InlineXBRL ret = get(qName);
		if (ret != null) {
			if (ret.kind == kind) {
				return ret;
			} else {
				logger.error("Unexpected kind  expect {}  actual {}", kind, ret.kind);
				logger.error("value {}", ret);
				throw new UnexpectedException("Unexpected kind");
			}
		} else {
			return null;
		}
	}
	
	public InlineXBRL getString(QValue qName) {
		return get(qName, InlineXBRL.Kind.STRING);
	}
	public InlineXBRL getBoolean(QValue qName) {
		return get(qName, InlineXBRL.Kind.BOOLEAN);
	}
	public InlineXBRL getNumber(QValue qName) {
		return get(qName, InlineXBRL.Kind.NUMBER);
	}
	
	public InlineXBRL get(QValue qName, InlineXBRL.Kind kind, String context) {
		InlineXBRL ret = get(qName, context);
		if (ret != null) {
			if (ret.kind == kind) {
				return ret;
			} else {
				logger.error("Unexpected kind  expect {}  actual {}", kind, ret.kind);
				logger.error("value {}", ret);
				throw new UnexpectedException("Unexpected kind");
			}
		} else {
			return null;
		}
	}
	

	
	public Set<String> getContextSet(QValue qName) {
		InlineXBRL ix = get(qName);
		if (ix == null) return null;
		return ix.contextSet;
	}
	
	public String getStringValue(QValue qName) {
		InlineXBRL ix = get(qName, InlineXBRL.Kind.STRING);
		if (ix.isNull) return null;
		
		InlineXBRL.StringValue stringValue = (InlineXBRL.StringValue)ix;
		return stringValue.stringValue;
	}
	public Boolean getBooleanValue(QValue qName) {
		InlineXBRL ix = get(qName, InlineXBRL.Kind.BOOLEAN);
		if (ix.isNull) return null;
		
		InlineXBRL.BooleanValue booleanValue = (InlineXBRL.BooleanValue)ix;
		return booleanValue.booleanValue;
	}
	public BigDecimal getNumberValue(QValue qName) {
		InlineXBRL ix = get(qName, InlineXBRL.Kind.NUMBER);
		if (ix.isNull) return null;
		
		InlineXBRL.NumberValue numberValue = (InlineXBRL.NumberValue)ix;
		return numberValue.numberValue;
	}

	public String getStringValue(QValue qName, String context) {
		InlineXBRL ix = get(qName, InlineXBRL.Kind.STRING, context);
		if (ix.isNull) return null;
		
		InlineXBRL.StringValue stringValue = (InlineXBRL.StringValue)ix;
		return stringValue.stringValue;
	}
	public Boolean getBooleanValue(QValue qName, String context) {
		InlineXBRL ix = get(qName, InlineXBRL.Kind.STRING, context);
		if (ix.isNull) return null;
		
		InlineXBRL.BooleanValue booleanValue = (InlineXBRL.BooleanValue)ix;
		return booleanValue.booleanValue;
	}
	public BigDecimal getNumberValue(QValue qName, String context) {
		InlineXBRL ix = get(qName, InlineXBRL.Kind.NUMBER, context);
		if (ix.isNull) return null;
		
		InlineXBRL.NumberValue numberValue = (InlineXBRL.NumberValue)ix;
		return numberValue.numberValue;
	}
}
