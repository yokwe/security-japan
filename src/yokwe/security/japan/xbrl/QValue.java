package yokwe.security.japan.xbrl;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.XMLUtil.XMLAttribute;
import yokwe.util.XMLUtil.XMLElement;

public class QValue implements Comparable<QValue> {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(QValue.class);

	final String uri;
	final String value;
	
	QValue(String uri, String value) {
		this.uri  = uri;
		this.value = value;
	}
	QValue(XMLElement xmlElement) {
		this.uri  = xmlElement.uri;
		this.value = xmlElement.localName;
	}
	QValue(XMLElement xmlElement, String qValue) {
		String[] names = qValue.split(":");
		if (names.length == 2) {
			String prefix    = names[0];
			this.value = names[1];
			if (xmlElement.prefixMap.containsKey(prefix)) {
				this.uri = xmlElement.prefixMap.get(prefix);
			} else {
				logger.error("Unexpected prefix {}", qValue);
				throw new UnexpectedException("Unexpected qName");
			}
		} else {
			logger.error("Unexpected name {}", qValue);
			throw new UnexpectedException("Unexpected qName");
		}
	}
	QValue(XMLAttribute xmlAttribute) {
		this.uri  = xmlAttribute.uri;
		this.value = xmlAttribute.localName;
	}
	
	public String getKey() {
		return String.format("%s-%s", uri, value);
	}
	
	@Override
	public String toString() {
		return String.format("{%s %s}", uri, value);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else {
			if (o instanceof QValue) {
				QValue that = (QValue)o;
				return this.uri.equals(that.value) && this.value.equals(that.value);
			} else {
				return false;
			}
		}
	}
	@Override
	public int compareTo(QValue that) {
		int ret = this.uri.compareTo(that.uri);
		if (ret == 0) ret = this.value.compareTo(that.value);
		return ret;
	}
}