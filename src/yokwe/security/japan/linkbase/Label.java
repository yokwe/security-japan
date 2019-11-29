package yokwe.security.japan.linkbase;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

// Documentation of XBRL Concepts MUST be contained in <label> element.
public class Label {
	// The @xlink:label attribute on a resource identifies the resource so that Arcs in the same Extended Link can reference it.
	@XmlAttribute(name = "label", namespace="http://www.w3.org/1999/xlink", required = true)
	public String label;
	
	// All <label> resources MUST have an @xml:lang attribute identifying the language used for the content of the label.
	@XmlAttribute(name = "lang", namespace="http://www.w3.org/XML/1998/namespace", required = true)
	public String lang;
	
//	// Role can be "http://www.xbrl.org/2003/role/label
//	@XmlAttribute(name = "role", required = true)
//	public String role;
	
	@XmlValue
	public String value;
	
	@Override
	public String toString() {
		return String.format("{%s %s %s}", label, lang, value);
	}
}

//<linkbase xmlns="http://www.xbrl.org/2003/linkbase" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xbrli="http://www.xbrl.org/2003/instance">
//<labelLink xlink:type="extended" xlink:role="http://www.xbrl.org/2003/role/link">
//  <loc xlink:type="locator" xlink:href="tse-ed-t-2014-01-12.xsd#tse-ed-t_AmountChangeGrossOperatingRevenues" xlink:label="AmountChangeGrossOperatingRevenues"/>
//  <label xlink:type="resource" xlink:label="label_AmountChangeGrossOperatingRevenues" xlink:role="http://www.xbrl.org/2003/role/label" xml:lang="ja" id="label_AmountChangeGrossOperatingRevenues">増減額</label>
//  <labelArc xlink:type="arc" xlink:arcrole="http://www.xbrl.org/2003/arcrole/concept-label" xlink:from="AmountChangeGrossOperatingRevenues" xlink:to="label_AmountChangeGrossOperatingRevenues"/>
