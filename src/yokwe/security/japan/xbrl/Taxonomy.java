package yokwe.security.japan.xbrl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.XMLUtil;

public class Taxonomy {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Taxonomy.class);

	// 決算短信タクソノミ
	public static final String URL_TAXNOMY_ED = "https://www.jpx.co.jp/equities/listing/xbrl/tvdivq00000088ai-att/61_taxonomy.zip";
	
	// Directory location = 61_taxonomy/tse-ed-2014-01-12/taxonomy/jp/tse/tdnet/ed/t/2014-01-12/tse-ed-t-2014-01-12.xsd
	public static final String PATH_DIR_TSE_ED_T = "tmp/61_taxonomy/tse-ed-2014-01-12/taxonomy/jp/tse/tdnet/ed/t/2014-01-12/";
	
	
	// xmlns:tse-ed-t="http://www.xbrl.tdnet.info/taxonomy/jp/tse/tdnet/ed/t/2014-01-12"
	
//	61_taxonomy/tse-ed-2014-01-12/taxonomy/jp/tse/tdnet/ed/t/2014-01-12/tse-ed-t-2014-01-12-lab.xml
//	61_taxonomy/tse-re-2014-01-12/taxonomy/jp/tse/tdnet/re/t/2014-01-12/tse-re-t-2014-01-12-lab.xml
//	61_taxonomy/tse-at-2014-01-12/taxonomy/jp/tse/tdnet/at/t/2014-01-12/tse-at-t-2014-01-12-lab.xml
	
//	<linkbase xmlns="http://www.xbrl.org/2003/linkbase" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xbrli="http://www.xbrl.org/2003/instance">
//	  <roleRef roleURI="http://www.xbrl.tdnet.info/jp/tse/tdnet/role/Interim/label" xlink:type="simple" xlink:href="../../o/rt/2014-01-12/tse-ed-rt-2014-01-12.xsd#Role_InterimLabel"/>
//	  <roleRef roleURI="http://www.xbrl.tdnet.info/jp/tse/tdnet/role/Interim/verboseLabel" xlink:type="simple" xlink:href="../../o/rt/2014-01-12/tse-ed-rt-2014-01-12.xsd#Role_InterimVerboseLabel"/>
//	  <roleRef roleURI="http://www.xbrl.tdnet.info/jp/tse/tdnet/role/Quarterly/label" xlink:type="simple" xlink:href="../../o/rt/2014-01-12/tse-ed-rt-2014-01-12.xsd#Role_QuarterlyLabel"/>
//	  <roleRef roleURI="http://www.xbrl.tdnet.info/jp/tse/tdnet/role/Quarterly/verboseLabel" xlink:type="simple" xlink:href="../../o/rt/2014-01-12/tse-ed-rt-2014-01-12.xsd#Role_QuarterlyVerboseLabel"/>
//	  <labelLink xlink:type="extended" xlink:role="http://www.xbrl.org/2003/role/link">
//    <loc xlink:type="locator" xlink:href="tse-ed-t-2014-01-12.xsd#tse-ed-t_DividendPerShare" xlink:label="DividendPerShare"/>
//    <label xlink:type="resource" xlink:label="label_DividendPerShare" xlink:role="http://www.xbrl.org/2003/role/label" xml:lang="ja" id="label_DividendPerShare">1株当たり配当金</label>
//    <labelArc xlink:type="arc" xlink:arcrole="http://www.xbrl.org/2003/arcrole/concept-label" xlink:from="DividendPerShare" xlink:to="label_DividendPerShare"/>

	
//	<schema targetNamespace="http://www.xbrl.tdnet.info/taxonomy/jp/tse/tdnet/ed/t/2014-01-12" attributeFormDefault="unqualified" elementFormDefault="qualified" xmlns="http://www.w3.org/2001/XMLSchema" xmlns:tse-ed-t="http://www.xbrl.tdnet.info/taxonomy/jp/tse/tdnet/ed/t/2014-01-12" xmlns:link="http://www.xbrl.org/2003/linkbase" xmlns:num="http://www.xbrl.org/dtr/type/numeric" xmlns:nonnum="http://www.xbrl.org/dtr/type/non-numeric" xmlns:xbrldt="http://xbrl.org/2005/xbrldt" xmlns:deprecated="http://www.xbrl.org/2009/role/deprecated" xmlns:xl="http://www.xbrl.org/2003/XLink" xmlns:xbrli="http://www.xbrl.org/2003/instance" xmlns:tse-ed-types="http://www.xbrl.tdnet.info/taxonomy/jp/tse/tdnet/ed/o/types/2014-01-12" xmlns:xlink="http://www.w3.org/1999/xlink">
	public static class Schema {
		public static final Map<String, Schema> all = new TreeMap<>();
		public static void scanDirectory(String pathDir) {
			File dir = new File(pathDir);
			logger.info("dir {}", dir);
			
			
			for(File file: dir.listFiles(o -> o.getName().contains("-lab"))) {
				logger.info("labelFile {}", file);
				
				Map<String, String> locMap = new TreeMap<>(); // key = link:href  value = xlink:label
				Map<String, String> arcMap = new TreeMap<>(); // key = link:from  value = link:to
				Map<String, String> labelMap = new TreeMap<>(); // key = link:label  value = value
//			    <loc xlink:type="locator" xlink:href="tse-ed-t-2014-01-12.xsd#tse-ed-t_DividendPerShare" xlink:label="DividendPerShare"/>
				XMLUtil.buildStream(file).filter(o -> o.localName.equals("loc")).forEach(o -> locMap.put(o.getAttributeValue("xlink:href"), o.getAttributeValue("xlink:label")));
//			    <label xlink:type="resource" xlink:label="label_DividendPerShare" xlink:role="http://www.xbrl.org/2003/role/label" xml:lang="ja" id="label_DividendPerShare">1株当たり配当金</label>
				XMLUtil.buildStream(file).filter(o -> o.localName.equals("label")).forEach(o -> labelMap.put(o.getAttributeValue("xlink:label"), o.content));
//			    <labelArc xlink:type="arc" xlink:arcrole="http://www.xbrl.org/2003/arcrole/concept-label" xlink:from="DividendPerShare" xlink:to="label_DividendPerShare"/>
				XMLUtil.buildStream(file).filter(o -> o.localName.equals("labelArc")).forEach(o -> arcMap.put(o.getAttributeValue("xlink:from"), o.getAttributeValue("xlink:to")));
				
				logger.info("locMap {}", locMap);
				logger.info("arcMap {}", arcMap);
				logger.info("labelMap {}", labelMap);
			}
			
			for(File xsdFile: dir.listFiles(o -> o.getName().endsWith(".xsd"))) {
				logger.info("xsdFile {}", xsdFile);
				
				Schema schema = getInstance(xsdFile);
				all.put(schema.targetNamespace, schema);
				
				logger.info("schema {} {}", schema.base, schema.targetNamespace);
				for(Element element: schema.elementList) {
					logger.info("  {}", element);
				}
			}
		}
		
		public static Schema getInstance(File file) {
			String base = file.getName();
			List<XMLUtil.XMLElement> schemaList  = XMLUtil.buildStream(file).filter(o -> o.localName.equals("schema")).collect(Collectors.toList());
			List<XMLUtil.XMLElement> elementList = XMLUtil.buildStream(file).filter(o -> o.localName.equals("element")).collect(Collectors.toList());
			
			String targetNamespace;
			if (schemaList.size() == 1) {
				XMLUtil.XMLElement xmlElement = schemaList.get(0);
				targetNamespace = xmlElement.getAttributeValue("targetNamespace");
			} else {
				logger.error("Unexpected schemaList {}", schemaList);
				throw new UnexpectedException("Unexpected schemaList");
			}
			
			List<Element> list = new ArrayList<>();
			for(XMLUtil.XMLElement xmlElement: elementList) {
				String name       = xmlElement.getAttributeValue("name");
				String id         = xmlElement.getAttributeValue("id");
				String type       = xmlElement.getAttributeValue("type");
				
				Element element = new Element(name, id, type);
				list.add(element);
			}
			
			return new Schema(base, targetNamespace, list);
		}
		
		public static class Element {
			public final String name;       // DividendPerShare
			public final String id;         // tse-ed-t_DividendPerShare
			public final String type;       // num:perShareItemType
			
			public Element(String name, String id, String type) {
				this.name       = name;
				this.id         = id;
				this.type       = type;
			}
			
			@Override
			public String toString() {
				return String.format("{%s %s %s}", name, id, type);
			}
		}

		public final String        base;
		public final String        targetNamespace;
		public final List<Element> elementList;
		
		public Schema(String base, String targetNamespace, List<Element> elementList) {
			this.base            = base;
			this.targetNamespace = targetNamespace;
			this.elementList     = elementList;
		}
		
		@Override
		public String toString() {
			return String.format("{%s %s %s}", base, targetNamespace, elementList);
		}
	}
	
//	  <element name="DividendPerShare" id="tse-ed-t_DividendPerShare" type="num:perShareItemType" substitutionGroup="xbrli:item" abstract="false" nillable="true" xbrli:periodType="duration"/>
	public static class Label {
		public String name;
		
		public String href;     // tse-ed-t-2014-01-12.xsd#tse-ed-t_DividendPerShare
		public String label;    // DividendPerShare
		public String labelJP;  // 1株当たり配当金
		
		
	}
	
	
	
	// CG報告書タクソノミ
	public static final String URL_TAXNOMY_CG = "https://www.jpx.co.jp/equities/listing/xbrl/tvdivq00000088ai-att/tse-cg-2015-04-01.zip";
	
//	File tse-cg-2015-04-01/jp/br/tdnet/t/cg/2007-06-30/tse-t-cg-2007-06-30-label.xml

//	<linkbase xmlns="http://www.xbrl.org/2003/linkbase" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xbrli="http://www.xbrl.org/2003/instance">
//	  <labelLink xlink:type="extended" xlink:role="http://www.xbrl.org/2003/role/link">
//    <loc xlink:type="locator" xlink:href="tse-t-cg-2007-06-30.xsd#tse-t-cg_SecuritiesCode" xlink:label="SecuritiesCode" xlink:title="SecuritiesCode"/>
//    <label xlink:type="resource" xlink:label="label_SecuritiesCode" xlink:role="http://www.xbrl.org/2003/role/label" xlink:title="label_SecuritiesCode" xml:lang="ja" id="label_SecuritiesCode">証券コード</label>
//    <labelArc xlink:type="arc" xlink:arcrole="http://www.xbrl.org/2003/arcrole/concept-label" xlink:from="SecuritiesCode" xlink:to="label_SecuritiesCode" xlink:title="label: SecuritiesCode to label_SecuritiesCode"/>
//    <label xlink:type="resource" xlink:label="label_SecuritiesCode_2" xlink:role="http://www.xbrl.org/2003/role/verboseLabel" xlink:title="label_SecuritiesCode" xml:lang="ja" id="label_SecuritiesCode_2">証券コード</label>
//    <labelArc xlink:type="arc" xlink:arcrole="http://www.xbrl.org/2003/arcrole/concept-label" xlink:from="SecuritiesCode" xlink:to="label_SecuritiesCode_2" xlink:title="label: SecuritiesCode to label_SecuritiesCode"/>


}
