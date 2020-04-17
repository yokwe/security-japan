package yokwe.security.japan.sony;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.JsonObject;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.sony.Fund.Region;
import yokwe.security.japan.sony.Fund.Target;
import yokwe.util.HttpUtil;
import yokwe.util.json.JSONBase;

public class UpdateFund {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateFund.class);

	public static class RawFundData extends JSONBase {
	    @JSONName("BunpaiKinriFM")       public String bunpaiKinriFM;      // 14.97%
	    @JSONName("BunpaiKinriRank")     public String bunpaiKinriRank;    // 6
	    @JSONName("CategoryMeisyo")      public String categoryMeisyo;     // 国際REIT型
	    @JSONName("FlgFromSSeimei")      public String flgFromSSeimei;     // 0
	    @JSONName("FlgHanbaiteisi")      public String flgHanbaiteisi;     // 0
	    @JSONName("FlgHRiskFund")        public String flgHRiskFund;       // 0
	    @JSONName("FlgSWOnly")           public String flgSWOnly;          // 0
	    @JSONName("FundAisyo")           public String fundAisyo;          // −
	    @JSONName("FundMei")             public String fundMei;            // ワールド・リート・オープン（毎月決算型）
	    @JSONName("FundRyaku")           public String fundRyaku;          // ワールド・リート・オープン（毎月決算型）
	    @JSONName("HanbaigakuFM")        public String hanbaigakuFM;       // 4,359,962円
	    @JSONName("HanbaigakuRanking")   public String hanbaigakuRanking;  // 127
	    @JSONName("HanbaiTesuryo")       public String hanbaiTesuryo;      // -
	    @JSONName("HanbaiTesuryoFM")     public String hanbaiTesuryoFM;    // なし
	    @JSONName("HyokaKijyunbi")       public String hyokaKijyunbi;      // 2020年03月
	    @JSONName("JyunsisanEn")         public String jyunsisanEn;        // 142588
	    @JSONName("JyunsisanEnFM")       public String jyunsisanEnFM;      // 142,588
	    @JSONName("JyunsisanRank")       public String jyunsisanRank;      // 15
	    @JSONName("KanaCode")            public String kanaCode;           // 081
	    @JSONName("KessanHindo")         public String kessanHindo;        // 12
	    @JSONName("KessanHindoFM")       public String kessanHindoFM;      // 毎月
	    @JSONName("KijyunKagaku")        public String kijyunKagaku;       // 1403
	    @JSONName("KijyunKagakuFM")      public String kijyunKagakuFM;     // 1,403円
	    @JSONName("MSCategoryCodeDai")   public String msCategoryCodeDai;  // 13
	    @JSONName("NISAHanbaigakuFM")    public String nisaHanbaigakuFM;   // 696,961円
	    @JSONName("NISAHanbaigakuRank")  public String nisaHanbaigakuRank; // 97
	    @JSONName("ReturnRank")          public String returnRank;         // 221
	    @JSONName("SBFundCode")          public String sbFundCode;         // 09111041
	    @JSONName("SintakHosyu")         public String sintakHosyu;        // 1.705
	    @JSONName("SintakHosyuFM")       public String sintakHosyuFM;      // 1.705%
	    @JSONName("SougouRating")        public String sougouRating;       // 2
	    @JSONName("SougouRatingFM")      public String sougouRatingFM;     // ★★
	    @JSONName("ToshiArea")           public String toshiArea;          // 01
	    @JSONName("ToshiTarget")         public String toshiTarget;        // 20
	    @JSONName("TotalReturn")         public String totalReturn;        // -33.36
	    @JSONName("TotalReturnFM")       public String totalReturnFM;      // -33.36%
	    @JSONName("TukaCode")            public String tukaCode;           // JPY
	    @JSONName("TumitateKensu")       public String tumitateKensu;      // 96
	    @JSONName("TumitateKensuRank")   public String tumitateKensuRank;  // 77
	    @JSONName("TumitatePlan")        public String tumitatePlan;       // 1
	    @JSONName("TumitatePlanFM")      public String tumitatePlanFM;     // ○
	    @JSONName("ZenjituhiFM")         public String zenjituhiFM;        // -47円

		public RawFundData() {
		    this.bunpaiKinriFM      = null;
		    this.bunpaiKinriRank    = null;
		    this.categoryMeisyo     = null;
		    this.flgFromSSeimei     = null;
		    this.flgHanbaiteisi     = null;
		    this.flgHRiskFund       = null;
		    this.flgSWOnly          = null;
		    this.fundAisyo          = null;
		    this.fundMei            = null;
		    this.fundRyaku          = null;
		    this.hanbaigakuFM       = null;
		    this.hanbaigakuRanking  = null;
		    this.hanbaiTesuryo      = null;
		    this.hanbaiTesuryoFM    = null;
		    this.hyokaKijyunbi      = null;
		    this.jyunsisanEn        = null;
		    this.jyunsisanEnFM      = null;
		    this.jyunsisanRank      = null;
		    this.kanaCode           = null;
		    this.kessanHindo        = null;
		    this.kessanHindoFM      = null;
		    this.kijyunKagaku       = null;
		    this.kijyunKagakuFM     = null;
		    this.msCategoryCodeDai  = null;
		    this.nisaHanbaigakuFM   = null;
		    this.nisaHanbaigakuRank = null;
		    this.returnRank         = null;
		    this.sbFundCode         = null;
		    this.sintakHosyu        = null;
		    this.sintakHosyuFM      = null;
		    this.sougouRating       = null;
		    this.sougouRatingFM     = null;
		    this.toshiArea          = null;
		    this.toshiTarget        = null;
		    this.totalReturn        = null;
		    this.totalReturnFM      = null;
		    this.tukaCode           = null;
		    this.tumitateKensu      = null;
		    this.tumitateKensuRank  = null;
		    this.tumitatePlan       = null;
		    this.tumitatePlanFM     = null;
		    this.zenjituhiFM        = null;
		}

		public RawFundData(JsonObject jsonObject) {
			super(jsonObject);
		}
	}
	
	public static class RawData extends JSONBase {
		public Map<String, RawFundData> map;
		
		public RawData() {
			map = null;
		}
		
		public RawData(JsonObject jsonObject) {
			super(jsonObject);
		}
	}
	
//	private static String toString(BigDecimal value) {
//		return value.compareTo(BigDecimal.ZERO) == 0 ? "0" : value.toPlainString();
//	}
	
	public static Fund getInstance(LocalDateTime dateTime, String isinCode, RawFundData raw) {
		Fund ret = new Fund();
        ret.dateTime           = dateTime;
        ret.isinCode           = isinCode;
        //
//        ret.divRatio           = raw.bunpaiKinriFM.equals("-") ? "" : toString(new BigDecimal(raw.bunpaiKinriFM.replace("%", "")).movePointLeft(2));
        ret.divRatio           = raw.bunpaiKinriFM.equals("-") ? "" : raw.bunpaiKinriFM;
//      ret.bunpaiKinriRank    = raw.bunpaiKinriRank;
        ret.category           = raw.categoryMeisyo;
//      ret.flgFromSSeimei     = raw.flgFromSSeimei;
//      ret.flgHanbaiteisi     = raw.flgHanbaiteisi;
//      ret.flgHRiskFund       = raw.flgHRiskFund;
//      ret.flgSWOnly          = raw.flgSWOnly;
//      ret.fundAisyo          = raw.fundAisyo;
        ret.fundName           = raw.fundMei;
//      ret.fundRyaku          = raw.fundRyaku;
//      ret.hanbaigakuFM       = raw.hanbaigakuFM;
//      ret.hanbaigakuRanking  = raw.hanbaigakuRanking;
//        ret.salesFee           = raw.hanbaiTesuryo.equals("-") ? "" : toString(new BigDecimal(raw.hanbaiTesuryo));
        ret.salesFee           = raw.hanbaiTesuryo.equals("-") ? "" : raw.hanbaiTesuryo;
//      ret.hanbaiTesuryoFM    = raw.hanbaiTesuryoFM;
//        ret.hyokaKijyunbi      = raw.hyokaKijyunbi.replace("年", "-").replace("月", "");
//        ret.marketCap          = raw.jyunsisanEn.equals("-") ? "" : toString(new BigDecimal(raw.jyunsisanEn).movePointRight(6));
        ret.marketCap          = raw.jyunsisanEn.equals("-") ? "" : raw.jyunsisanEn;
//      ret.jyunsisanEnFM      = raw.jyunsisanEnFM;
//      ret.jyunsisanRank      = raw.jyunsisanRank;
        ret.company            = Company.get(raw.kanaCode);
//        ret.divFreq            = raw.kessanHindo.equals("-") ? "" : toString(new BigDecimal(raw.kessanHindo));
        ret.divFreq            = raw.kessanHindo.equals("-") ? "" : raw.kessanHindo;
//      ret.kessanHindoFM      = raw.kessanHindoFM;
//        ret.price              = raw.kijyunKagaku.equals("-") ? "" : toString(new BigDecimal(raw.kijyunKagaku));
        ret.price              = raw.kijyunKagaku.equals("-") ? "" : raw.kijyunKagaku;
//      ret.kijyunKagakuFM     = raw.kijyunKagakuFM;
//      ret.msCategoryCodeDai  = raw.msCategoryCodeDai;
//      ret.nisaHanbaigakuFM   = raw.nisaHanbaigakuFM;
//      ret.nisaHanbaigakuRank = raw.nisaHanbaigakuRank;
//      ret.returnRank         = raw.returnRank;
//      ret.sbFundCode         = raw.sbFundCode;
//        ret.expenseRatio       = toString(new BigDecimal(raw.sintakHosyu).movePointLeft(2));
        ret.expenseRatio       = raw.sintakHosyu;
//      ret.sintakHosyuFM      = raw.sintakHosyuFM;
//      ret.sougouRating       = raw.sougouRating.equals("-") ? MISSING_DATA : Integer.parseInt(raw.sougouRating);
//      ret.sougouRatingFM     = raw.sougouRatingFM;
        ret.region             = Region.get(raw.toshiArea);
        ret.target             = Target.get(raw.toshiTarget);
//      ret.totalReturn        = raw.totalReturn.equals("-") ? MISSING_DATA : DoubleUtil.round(Double.parseDouble(raw.totalReturn) * 0.01, 4);
//      ret.totalReturnFM      = raw.totalReturnFM;
        ret.currency           = Currency.get(raw.tukaCode);
//      ret.tumitateKensu      = raw.tumitateKensu;
//      ret.tumitateKensuRank  = raw.tumitateKensuRank;
//      ret.tumitatePlan       = raw.tumitatePlan;
//      ret.tumitatePlanFM     = raw.tumitatePlanFM;
//      this.zenjituhiFM       = raw.zenjituhiFM.equals("-") ? "" : toString(new BigDecimal(raw.zenjituhiFM.replace(",", "").replace("円", "").replace("USD", "")));
        
        return ret;
	}

	private static final String URL = "https://moneykit.net/data/fund/SFBA1700F471.js";

	public static List<Fund> updateList() {
		HttpUtil.Result result = HttpUtil.getInstance().withCharset("MS932").download(URL);
		
		String string = result.result;
		
		LocalDateTime dateTime;
		{
			Pattern p = Pattern.compile("YrMonDate='(?<yyyy>2[0-9]{3})/(?<mm>[0-9]{2})/(?<dd>[0-9]{2}) (?<hhmmss>[0-9:]{8})';");
			Matcher m = p.matcher(string);
			if (m.find()) {
				String yyyy   = m.group("yyyy");
				String mm     = m.group("mm");
				String dd     = m.group("dd");
				String hhmmss = m.group("hhmmss");
				
				String dateTimeString = String.format("%s-%s-%s %s", yyyy, mm, dd, hhmmss);
				dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			} else {
				throw new UnexpectedException("no match PAT_YRMONDATE");
			}
		}

		String jsonString;
		{
			Pattern p = Pattern.compile(";FundData= (?<json>\\{.+\\});");
			Matcher m = p.matcher(string);
			if (m.find()) {
				jsonString = String.format("{\"map\": %s}", m.group("json").replace("[", "").replace("]", ""));
			} else {
				throw new UnexpectedException("no match PAT_FUNDDATA");
			}
		}
		RawData rawData = JSONBase.getInstance(RawData.class, jsonString);

		List<Fund> list = new ArrayList<>();
		for(Map.Entry<String, RawFundData> entry: rawData.map.entrySet()) {
			String      isinCode = entry.getKey();
			RawFundData raw      = entry.getValue();
			list.add(getInstance(dateTime, isinCode, raw));
		}
				
		return list;
	}

	public static void main(String[] arsg) {
		logger.info("START");

		{
			List<Fund> list = updateList();
			
			logger.info("save {} {}", list.size(), Fund.PATH_FILE);
			Fund.save(list);
		}
		
		{
			List<Fund> list = Fund.getList();
			logger.info("list {}", list.size());
		}
		
		logger.info("STOP");
	}

}
