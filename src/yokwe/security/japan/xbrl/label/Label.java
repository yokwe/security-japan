package yokwe.security.japan.xbrl.label;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;

// Documentation of XBRL Concepts MUST be contained in <label> element.
public class Label {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Label.class);

	@XmlEnum
	@XmlType(name="Label-Type")
	public enum Type {
		@XmlEnumValue("resource")
		RESOURCE,
	}

	@XmlEnum
	@XmlType(name="Label-Role")
	enum Role {
		@XmlEnumValue("http://www.xbrl.org/2003/role/verboseLabel")
		VERBOSE_LABEL,
		@XmlEnumValue("http://www.xbrl.tdnet.info/jp/tse/tdnet/role/Quarterly/verboseLabel")
		QUARTERLY_VERBOSE_LABEL,
		@XmlEnumValue("http://www.xbrl.tdnet.info/jp/tse/tdnet/role/Interim/verboseLabel")
		INTERIM_VERBOSE_LABEL,
		@XmlEnumValue("http://www.xbrl.tdnet.info/jp/tse/tdnet/role/NonConsolidated/label")
		NON_CONSOLIDATED_LABEL,
		@XmlEnumValue("http://www.xbrl.tdnet.info/jp/tse/tdnet/role/NonConsolidated/verboseLabel")
		NON_CONSOLIDATED_VERBOSELABEL,
		@XmlEnumValue("http://www.xbrl.tdnet.info/jp/tse/tdnet/role/Quarterly/label")
		QUARTERLYLABEL,
		@XmlEnumValue("http://www.xbrl.tdnet.info/jp/tse/tdnet/role/Interim/label")
		INTERLIM_LABEL,
	}
	
	@XmlEnum
	@XmlType(name="Label-Lang")
	enum Lang {
		@XmlEnumValue("en")
		EN,
		@XmlEnumValue("ja")
		JA,
	}
	
	// Role can be "http://www.xbrl.org/2003/role/label
	@XmlAttribute(name = "type", namespace="http://www.w3.org/1999/xlink", required = true)
	public Type type;
	
	// Role can be "http://www.xbrl.org/2003/role/label
	@XmlAttribute(name = "role", namespace="http://www.w3.org/1999/xlink", required = true)
//	public Role role;
	public String role;
	
	// All <label> resources MUST have an @xml:lang attribute identifying the language used for the content of the label.
	@XmlAttribute(name = "lang", namespace="http://www.w3.org/XML/1998/namespace", required = true)
	public Lang lang;
	
	// The @xlink:label attribute on a resource identifies the resource so that Arcs in the same Extended Link can reference it.
	@XmlAttribute(name = "label", namespace="http://www.w3.org/1999/xlink", required = true)
	public String label;
	
	
	@XmlValue
	public String value;
	
	@Override
	public String toString() {
		return String.format("{%s %s %s %s %s \"%s\"}", type, role, lang, label, lang, value);
	}
	
	void afterUnmarshal(Unmarshaller u, Object parent) {
		// Sanity check
		if (type == null) {
			logger.error("type is null {}", this);
			throw new UnexpectedException("type is null");
		}
		if (role == null) {
			logger.error("role is null {}", this);
			throw new UnexpectedException("role is null");
		}
		if (lang == null) {
			logger.error("lang is null {}", this);
			throw new UnexpectedException("lang is null");
		}
	}
}

//<linkbase xmlns="http://www.xbrl.org/2003/linkbase" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xbrli="http://www.xbrl.org/2003/instance">
//<labelLink xlink:type="extended" xlink:role="http://www.xbrl.org/2003/role/link">
//  <loc xlink:type="locator" xlink:href="tse-ed-t-2014-01-12.xsd#tse-ed-t_AmountChangeGrossOperatingRevenues" xlink:label="AmountChangeGrossOperatingRevenues"/>
//  <label xlink:type="resource" xlink:label="label_AmountChangeGrossOperatingRevenues" xlink:role="http://www.xbrl.org/2003/role/label" xml:lang="ja" id="label_AmountChangeGrossOperatingRevenues">増減額</label>
//  <labelArc xlink:type="arc" xlink:arcrole="http://www.xbrl.org/2003/arcrole/concept-label" xlink:from="AmountChangeGrossOperatingRevenues" xlink:to="label_AmountChangeGrossOperatingRevenues"/>
