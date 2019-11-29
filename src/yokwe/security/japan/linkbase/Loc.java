package yokwe.security.japan.linkbase;

import javax.xml.bind.annotation.XmlAttribute;

// Locators are child elements of an Extended Link that point to resources external to the extended link itself.
public class Loc {
	// The @xlink:type attribute MUST occur on all Locators and MUST have the fixed content "locator".
	@XmlAttribute(name = "type", namespace="http://www.w3.org/1999/xlink", required = true)
	String type;  // type must be "locator"
	
	// A Locator MUST have an @xlink:href attribute. The @xlink:href attribute MUST be a URI.
	// The URI MUST point to an XML document or to one or more XML fragments within an XML document.
	@XmlAttribute(name = "href", namespace="http://www.w3.org/1999/xlink", required = true)
	String href;
	
	// The @xlink:label attribute on a Locator identifies the locator so that Arcs in the same Extended Link can reference it.
	@XmlAttribute(name = "label", namespace="http://www.w3.org/1999/xlink", required = true)
	String label;
	
	@Override
	public String toString() {
		return String.format("{%s %s}", href, label);
	}
}

//<linkbase xmlns="http://www.xbrl.org/2003/linkbase" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xbrli="http://www.xbrl.org/2003/instance">
//<labelLink xlink:type="extended" xlink:role="http://www.xbrl.org/2003/role/link">
//<loc xlink:type="locator" xlink:href="tse-ed-t-2014-01-12.xsd#tse-ed-t_AmountChangeGrossOperatingRevenues" xlink:label="AmountChangeGrossOperatingRevenues"/>
//<label xlink:type="resource" xlink:label="label_AmountChangeGrossOperatingRevenues" xlink:role="http://www.xbrl.org/2003/role/label" xml:lang="ja" id="label_AmountChangeGrossOperatingRevenues">増減額</label>
//<labelArc xlink:type="arc" xlink:arcrole="http://www.xbrl.org/2003/arcrole/concept-label" xlink:from="AmountChangeGrossOperatingRevenues" xlink:to="label_AmountChangeGrossOperatingRevenues"/>
