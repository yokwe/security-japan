package yokwe.security.japan.xbrl.label;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "linkbase")
public class Linkbase {
	@XmlElement(name = "labelLink")
	public LabelLink labelLink;
	
	@Override
	public String toString() {
		return String.format("%s", labelLink);
	}
}

//<linkbase xmlns="http://www.xbrl.org/2003/linkbase" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xbrli="http://www.xbrl.org/2003/instance">
//  <labelLink xlink:type="extended" xlink:role="http://www.xbrl.org/2003/role/link">
//    <loc xlink:type="locator" xlink:href="tse-ed-t-2014-01-12.xsd#tse-ed-t_AmountChangeGrossOperatingRevenues" xlink:label="AmountChangeGrossOperatingRevenues"/>
//    <label xlink:type="resource" xlink:label="label_AmountChangeGrossOperatingRevenues" xlink:role="http://www.xbrl.org/2003/role/label" xml:lang="ja" id="label_AmountChangeGrossOperatingRevenues">増減額</label>
//    <labelArc xlink:type="arc" xlink:arcrole="http://www.xbrl.org/2003/arcrole/concept-label" xlink:from="AmountChangeGrossOperatingRevenues" xlink:to="label_AmountChangeGrossOperatingRevenues"/>
