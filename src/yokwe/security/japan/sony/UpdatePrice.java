package yokwe.security.japan.sony;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;

import org.slf4j.LoggerFactory;

import yokwe.security.japan.sony.price.Day;
import yokwe.security.japan.sony.price.Month;
import yokwe.security.japan.sony.price.MorningstarXML;
import yokwe.security.japan.sony.price.Year;
import yokwe.util.FileUtil;
import yokwe.util.HttpUtil;

public class UpdatePrice {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdatePrice.class);

	//https://apl.morningstar.co.jp/xml/chart/funddata/2013121001.xml
	
	private static String URL_BASE_FUNDDATA = "https://apl.morningstar.co.jp/xml/chart/funddata";
	public static String getURL(String msFundCode) {
		return String.format("%s/%s.xml", URL_BASE_FUNDDATA, msFundCode);
	}
	
	public static final String PATH_DIR_DATA = "tmp/download/sony/page";
	public static final String FORMAT_PATH   = String.format("%s/%%s.xml", PATH_DIR_DATA);
	public static String getPath(String isinCode) {
		return String.format(FORMAT_PATH, isinCode);
	}


	public static void main(String[] arsg) {
		logger.info("START");

		for(FundInfo e: FundInfo.getList()) {
			String msFundCode = e.msFundCode;
			if (msFundCode.isEmpty()) continue;
			
			logger.info("{} {}", e.isinCode, msFundCode);
			
			byte[] byteArray;
			{
				String path = getPath(msFundCode);
				File file = new File(path);
				if (file.exists()) {
					byteArray = FileUtil.rawRead().file(file);
				} else {
					String url = getURL(msFundCode);
					logger.info("  download {}", url);
					HttpUtil.Result result = HttpUtil.getInstance().withRawData(true).download(url);
					byteArray = result.rawData;
					FileUtil.rawWrite().file(file, byteArray);
				}
			}
			
			List<Price> priceList = new ArrayList<>();
			{
				MorningstarXML morningstarXML = JAXB.unmarshal(new ByteArrayInputStream(byteArray), MorningstarXML.class);
//				logger.info("morningstarXML {}", StringUtil.toString(morningstarXML));
				for(Year year: morningstarXML.fund.yearList) {
					for(Month month: year.monthList) {
						for(Day day: month.dayList) {
							if (day.price.isEmpty())  continue;
							if (day.volume.isEmpty()) continue;

							// 	public Price(LocalDate date, String isinCode, BigDecimal price, long volume) {
							LocalDate  date = LocalDate.parse(String.format("%s-%s-%s", day.year, day.month, day.value));
							BigDecimal value = new BigDecimal(day.price);
							long       volume = Long.parseLong(day.volume);
							Price price = new Price(date, e.isinCode, e.currency, value, volume);
							priceList.add(price);
						}
					}
				}
			}
			logger.info("  save {} {}", priceList.size(), Price.getPath(e.isinCode));
			Price.save(priceList);
		}

		logger.info("STOP");
	}

}
