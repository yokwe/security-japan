package yokwe.security.japan.linkbase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class LabelLink {
	@XmlElement(name = "loc")
	public final List<Loc>      locList      = new ArrayList<>();
	@XmlElement(name = "label")
	public final List<Label>    labelList    = new ArrayList<>();
	@XmlElement(name = "labelArc")
	public final List<LabelArc> labelArcList = new ArrayList<>();
	
	@XmlTransient
	public final Map<String, Loc>      locMap      = new TreeMap<>();
	
	@XmlTransient
	public final Map<String, Label>    labelMap    = new TreeMap<>();
	
	@XmlTransient
	public final Map<String, LabelArc> labelArcMap = new TreeMap<>();
	
	@Override
	public String toString() {
		return String.format("{loc %d / %d  label %d / %d  labelArc %d / %d}", locMap.size(), locList.size(), labelMap.size(), labelList.size(), labelArcMap.size(), labelArcList.size());
	}
	
	void afterUnmarshal(Unmarshaller u, Object parent) {
		locMap.clear();
		for(Loc e: locList) {
			locMap.put(e.label, e);
		}
		
		labelMap.clear();
		for(Label e: labelList) {
			labelMap.put(e.id, e);
		}
		
		labelArcMap.clear();
		for(LabelArc e: labelArcList) {
			labelArcMap.put(e.from, e);
		}
	}
}

//<linkbase xmlns="http://www.xbrl.org/2003/linkbase" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xbrli="http://www.xbrl.org/2003/instance">
//<labelLink xlink:type="extended" xlink:role="http://www.xbrl.org/2003/role/link">
//  <loc xlink:type="locator" xlink:href="tse-ed-t-2014-01-12.xsd#tse-ed-t_AmountChangeGrossOperatingRevenues" xlink:label="AmountChangeGrossOperatingRevenues"/>
//  <label xlink:type="resource" xlink:label="label_AmountChangeGrossOperatingRevenues" xlink:role="http://www.xbrl.org/2003/role/label" xml:lang="ja" id="label_AmountChangeGrossOperatingRevenues">増減額</label>
//  <labelArc xlink:type="arc" xlink:arcrole="http://www.xbrl.org/2003/arcrole/concept-label" xlink:from="AmountChangeGrossOperatingRevenues" xlink:to="label_AmountChangeGrossOperatingRevenues"/>
