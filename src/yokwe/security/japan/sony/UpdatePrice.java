package yokwe.security.japan.sony;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXB;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.sony.price.MorningstarXML;
import yokwe.util.FileUtil;
import yokwe.util.StringUtil;

public class UpdatePrice {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdatePrice.class);

	public static void main(String[] arsg) {
		logger.info("START");

		byte[] byetArray = FileUtil.rawRead().file("tmp/2013121001.xml");
		logger.info("byetArray {}!", byetArray.length);
		
		MorningstarXML morningstarXML = JAXB.unmarshal(new ByteArrayInputStream(byetArray), MorningstarXML.class);
		logger.info("morningstarXML {}", StringUtil.toString(morningstarXML));

		logger.info("STOP");
	}

}
