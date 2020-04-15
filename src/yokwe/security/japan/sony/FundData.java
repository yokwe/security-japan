package yokwe.security.japan.sony;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.JsonObject;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.CSVUtil;
import yokwe.util.HttpUtil;
import yokwe.util.json.JSONBase;

public class FundData extends JSONBase implements Comparable<FundData> {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FundData.class);

	@IgnoreField
	public String dateTime;

	@IgnoreField
	public String isinCode;

//	    "KanaCode" : "081",
	@JSONName("KanaCode")
	public String kanaCode;
	
//	    "SougouRatingFM" : "★★★★★",
	@JSONName("SougouRatingFM")
	public String sougouRatingFM;

//	    "JyunsisanEn" : "20842",
	@JSONName("JyunsisanEn")
	public String jyunsisanEn;

//	    "CategoryMeisyo" : "国際債券",
	@JSONName("CategoryMeisyo")
	public String categoryMeisyo;
	
//	    "FlgSWOnly" : "0",
	@JSONName("FlgSWOnly")
	public String flgSWOnly;

//	    "HanbaigakuFM" : "6,930,833円",
	@JSONName("HanbaigakuFM")
	public String hanbaigakuFM;

//	    "SougouRating" : "5",
	@JSONName("SougouRating")
	public String sougouRating;

//	    "KijyunKagakuFM" : "6,390円",
	@JSONName("KijyunKagakuFM")
	public String kijyunKagakuFM;

//	    "NISAHanbaigakuFM" : "941,833円",
	@JSONName("NISAHanbaigakuFM")
	public String nisaHanbaigakuFM;

//	    "FlgHanbaiteisi" : "0",
	@JSONName("FlgHanbaiteisi")
	public String flgHanbaiteisi;

//	    "ToshiTarget" : "10",
	@JSONName("ToshiTarget")
	public String toshiTarget;

//	    "TumitateKensu" : "90",
	@JSONName("TumitateKensu")
	public String tumitateKensu;

//	    "FundMei" : "エマージング・ソブリン・オープン（毎月決算型）",
	@JSONName("FundMei")
	public String fundMei;

//	    "BunpaiKinriRank" : "24",
	@JSONName("BunpaiKinriRank")
	public String bunpaiKinriRank;

//	    "TotalReturn" : "-9.1",
	@JSONName("TotalReturn")
	public String totalReturn;

//	    "TumitateKensuRank" : "84",
	@JSONName("TumitateKensuRank")
	public String tumitateKensuRank;

//	    "HanbaiTesuryo" : "-",
	@JSONName("HanbaiTesuryo")
	public String hanbaiTesuryo;

//	    "ZenjituhiFM" : "-14円",
	@JSONName("ZenjituhiFM")
	public String zenjituhiFM;

//	    "HyokaKijyunbi" : "2020年03月",
	@JSONName("HyokaKijyunbi")
	public String hyokaKijyunbi;

//	    "TotalReturnFM" : "-9.10%",
	@JSONName("TotalReturnFM")
	public String totalReturnFM;

//	    "JyunsisanEnFM" : "20,842",
	@JSONName("JyunsisanEnFM")
	public String jyunsisanEnFM;

//	    "HanbaigakuRanking" : "101",
	@JSONName("HanbaigakuRanking")
	public String hanbaigakuRanking;

//	    "FlgHRiskFund" : "0",
	@JSONName("FlgHRiskFund")
	public String flgHRiskFund;

//	    "TumitatePlan" : "1",
	@JSONName("TumitatePlan")
	public String tumitatePlan;

//	    "FundRyaku" : "エマージング・ソブリン・オープン（毎月決算型）",
	@JSONName("FundRyaku")
	public String fundRyaku;

//	    "MSCategoryCodeDai" : "12",
	@JSONName("MSCategoryCodeDai")
	public String msCategoryCodeDai;

//	    "KijyunKagaku" : "6390",
	@JSONName("KijyunKagaku")
	public String kijyunKagaku;

//	    "FundAisyo" : "−",
	@JSONName("FundAisyo")
	public String fundAisyo;

//	    "KessanHindo" : "12",
	@JSONName("KessanHindo")
	public String kessanHindo;

//	    "TumitatePlanFM" : "○",
	@JSONName("TumitatePlanFM")
	public String tumitatePlanFM;

//	    "FlgFromSSeimei" : "0",
	@JSONName("FlgFromSSeimei")
	public String flgFromSSeimei;

//	    "ToshiArea" : "60",
	@JSONName("ToshiArea")
	public String toshiArea;

//	    "JyunsisanRank" : "67",
	@JSONName("JyunsisanRank")
	public String jyunsisanRank;

//	    "SintakHosyu" : "1.727",
	@JSONName("SintakHosyu")
	public String sintakHosyu;

//	    "ReturnRank" : "103",
	@JSONName("ReturnRank")
	public String returnRank;

//	    "HanbaiTesuryoFM" : "なし",
	@JSONName("HanbaiTesuryoFM")
	public String hanbaiTesuryoFM;

//	    "TukaCode" : "JPY",
	@JSONName("TukaCode")
	public String tukaCode;

//	    "SintakHosyuFM" : "1.727%",
	@JSONName("SintakHosyuFM")
	public String sintakHosyuFM;

//	    "BunpaiKinriFM" : "7.75%",
	@JSONName("BunpaiKinriFM")
	public String bunpaiKinriFM;

//	    "SBFundCode" : "04110241",
	@JSONName("SBFundCode")
	public String sbFundCode;

//	    "KessanHindoFM" : "毎月",
	@JSONName("KessanHindoFM")
	public String kessanHindoFM;

//	    "NISAHanbaigakuRank" : "85"
	@JSONName("NISAHanbaigakuRank")
	public String nisaHanbaigakuRank;
	
	public FundData() {
		kanaCode           = null;
		sougouRatingFM     = null;
		jyunsisanEn        = null;
		categoryMeisyo     = null;
		flgSWOnly          = null;
		hanbaigakuFM       = null;
		sougouRating       = null;
		kijyunKagakuFM     = null;
		nisaHanbaigakuFM   = null;
		flgHanbaiteisi     = null;
		toshiTarget        = null;
		tumitateKensu      = null;
		fundMei            = null;
		bunpaiKinriRank    = null;
		totalReturn        = null;
		tumitateKensuRank  = null;
		hanbaiTesuryo      = null;
		zenjituhiFM        = null;
		hyokaKijyunbi      = null;
		totalReturnFM      = null;
		jyunsisanEnFM      = null;
		hanbaigakuRanking  = null;
		flgHRiskFund       = null;
		tumitatePlan       = null;
		fundRyaku          = null;
		msCategoryCodeDai  = null;
		kijyunKagaku       = null;
		fundAisyo          = null;
		kessanHindo        = null;
		tumitatePlanFM     = null;
		flgFromSSeimei     = null;
		toshiArea          = null;
		jyunsisanRank      = null;
		sintakHosyu        = null;
		returnRank         = null;
		hanbaiTesuryoFM    = null;
		tukaCode           = null;
		sintakHosyuFM      = null;
		bunpaiKinriFM      = null;
		sbFundCode         = null;
		kessanHindoFM      = null;
		nisaHanbaigakuRank = null;
	}
	
	public FundData(JsonObject jsonObject) {
		super(jsonObject);
	}
	
	
	public static class RawData extends JSONBase {
		public Map<String, FundData> map;
		
		public RawData() {
			map = null;
		}
		
		public RawData(JsonObject jsonObject) {
			super(jsonObject);
		}
	}
	
	public static final String PATH_FILE = "tmp/data/sony/fund-data.csv";
	public static final String URL = "https://moneykit.net/data/fund/SFBA1700F471.js";
	public static Pattern PAT_YRMONDATE = Pattern.compile("YrMonDate='(?<yyyy>2[0-9]{3})/(?<mm>[0-9]{2})/(?<dd>[0-9]{2}) (?<hhmmss>[0-9:]{8})';");
	public static Pattern PAT_FUNDDATA  = Pattern.compile(";FundData= (?<json>\\{.+\\});");

	private static List<FundData> list = null;
	public static List<FundData> getList() {
		if (list == null) {
			list = CSVUtil.read(FundData.class).file(PATH_FILE);
			if (list == null) {
				list = new ArrayList<>();
			}
		}
		return list;
	}

	public static void save(Collection<FundData> collection) {
		save(new ArrayList<>(collection));
	}
	public static void save(List<FundData> list) {
		// Sort before save
		Collections.sort(list);
		CSVUtil.write(FundData.class).file(PATH_FILE, list);
	}

	public static void update() {
		HttpUtil.Result result = HttpUtil.getInstance().withCharset("MS932").download(URL);
		
		String string = result.result;
		
		String dateTime;
		{
			Matcher m = PAT_YRMONDATE.matcher(string);
			if (m.find()) {
				String yyyy   = m.group("yyyy");
				String mm     = m.group("mm");
				String dd     = m.group("dd");
				String hhmmss = m.group("hhmmss");
				
				dateTime = String.format("%s-%s-%s %s", yyyy, mm, dd, hhmmss);
			} else {
				throw new UnexpectedException("no match PAT_YRMONDATE");
			}
		}

		String jsonString;
		{
			Matcher m = PAT_FUNDDATA.matcher(string);
			if (m.find()) {
				jsonString = String.format("{\"map\": %s}", m.group("json").replace("[", "").replace("]", ""));
			} else {
				throw new UnexpectedException("no match PAT_FUNDDATA");
			}
		}
		RawData rawData = JSONBase.getInstance(RawData.class, jsonString);

		List<FundData> list = new ArrayList<>();
		for(Map.Entry<String, FundData> entry: rawData.map.entrySet()) {
			String isinCode = entry.getKey();
			FundData fundData = entry.getValue();
			fundData.dateTime = dateTime;
			fundData.isinCode = isinCode;
			list.add(fundData);
		}
		
		logger.info("save {} {}", list.size(), PATH_FILE);
		save(list);
	}
	public static void main(String[] arsg) {
		logger.info("START");

		update();
		
		{
			List<FundData> list = getList();
			logger.info("list {}", list.size());
		}
		
		logger.info("STOP");
	}

	@Override
	public int compareTo(FundData that) {
		int ret = this.dateTime.compareTo(that.dateTime);
		if (ret == 0) ret = this.isinCode.compareTo(that.isinCode);
		return ret;
	}
}
