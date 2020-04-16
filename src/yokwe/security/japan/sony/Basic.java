package yokwe.security.japan.sony;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXB;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.sony.basic.Root;
import yokwe.util.FileUtil;
import yokwe.util.StringUtil;

public class Basic {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Basic.class);

	public static void main(String[] args) {
		logger.info("START");
		
		byte[] byetArray = FileUtil.rawRead().file("tmp/basic_2013121001.xml");
		logger.info("byetArray {}!", byetArray.length);
		
		Root root = JAXB.unmarshal(new ByteArrayInputStream(byetArray), Root.class);
		logger.info("root {}", StringUtil.toString(root));
		
		logger.info("STOP");
	}
}
