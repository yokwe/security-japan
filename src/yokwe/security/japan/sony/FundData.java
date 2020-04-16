package yokwe.security.japan.sony;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.json.JsonObject;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.CSVUtil;
import yokwe.util.EnumUtil;
import yokwe.util.json.JSONBase;

public class FundData extends JSONBase implements Comparable<FundData> {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FundData.class);

	public static final String PATH_FILE = "tmp/data/sony/sony-fund-data.csv";

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

	public static enum Region {
		WORLD        ("01", "世界全体"),
		JAPAN        ("10", "日本"),
		NORTH_AMERICA("20", "北米"),
		EUROPE       ("30", "欧州"),
		ASIA         ("40", "アジア"),
		OCEANIA      ("50", "オセアニア"),
		OTHER        ("60", "その他");
		
		public final String code;
		public final String name;
		Region(String code, String name) {
			this.code = code;
			this.name = name;
		}
		@Override
		public String toString() {
			return name;
		}
		
		public static Region get(String code) {
			for(Region e: Region.values()) {
				if (e.code.equals(code)) return e;
			}
			logger.error("Unexpected code {}!", code);
			throw new UnexpectedException("Unexpected value");
		}
	}
	
	public static enum Target {
		STOCK   ("01", "株式"),
		BOND    ("10", "債券"),
		REIT    ("20", "REIT"),
		BALANCE ("30", "バランス"),
		COMODITY("40", "コモディティ・資源");
		
		public final String code;
		public final String name;
		Target(String code, String name) {
			this.code = code;
			this.name = name;
		}
		@Override
		public String toString() {
			return name;
		}
		
		public static Target get(String code) {
			for(Target e: Target.values()) {
				if (e.code.equals(code)) return e;
			}
			logger.error("Unexpected code {}!", code);
			throw new UnexpectedException("Unexpected value");
		}
	}
	
	public static enum Company {
		ASAHILIFE("002", "朝日ライフ"),
		ASEMANE  ("004", "アセマネOne"),
		AMUNDI   ("006", "アムンディ"),
		EAST     ("009", "イーストS"),
		INVESCO  ("011", "インベスコ"),
		HSBC     ("012", "HSBC"),
		NN       ("014", "NN"),
		COMMONS  ("024", "コモンズ"),
		SCHRODER ("027", "シュローダー"),
		JPM      ("033", "JPモルガン"),
		JANAS    ("034", "ジャナス・キャピタル"),
		SOMPO    ("039", "SOMPO"),
		DAIWA    ("041", "大和"),
		TD       ("046", "T&D"),
		DEUTSCH  ("049", "ドイチェ"),
		NIKKOU   ("050", "日興"),
		NIKKOUAM ("051", "日興AMヨーロッパ"),
		NISSEI   ("052", "ニッセイ"),
		NOMURA   ("055", "野村"),
		BNP      ("061", "BNPパリバ"),
		PICTE    ("063", "ピクテ"),
		FIVESTAR ("065", "ファイブスター"),
		FEDILITY ("067", "フィデリティ"),
		BLACKROCK("070", "ブラックロック"),
		MANULIFE ("077", "マニュライフ"),
		SMDS     ("079", "三井住友DS"),
		SMTAM    ("080", "三井住友TAM"),
		UFJ      ("081", "三菱UFJ国際"),
		UBS      ("087", "UBS"),
		RAKUTEN  ("089", "楽天"),
		RHEOS    ("093", "レオス"),
		LM       ("094", "L・メイソン");
		
		public final String code;
		public final String name;
		Company(String code, String name) {
			this.code = code;
			this.name = name;
		}
		@Override
		public String toString() {
			return name;
		}
		
		public static Company get(String code) {
			for(Company e: Company.values()) {
				if (e.code.equals(code)) return e;
			}
			logger.error("Unexpected code {}!", code);
			throw new UnexpectedException("Unexpected value");
		}
	}
	
	public static enum Currency {
		AUD,
		CAD,
		JPY,
		NZD,
		USD;
		public static Currency get(String value) {
			return EnumUtil.getInstance(Currency.class, value);
		}
	}
	
	public LocalDateTime dateTime;    // 2020-04-14 23:00:33
	public String        isinCode;    // IE0030804631
	//
	public String  divRatio;      // 14.97%
	public String  category;      // 国際REIT型
	public String  fundName;      // ワールド・リート・オープン（毎月決算型）
	public String  salesFee;      // -
    public String  hyokaKijyunbi; // 2020年03月
    public String  marketCap;     // 142588
    public Company company;       // 081
    public String  divFreq;       // 12
    public String  price;         // 1403
    public String  expenseRatio;  // 1.705
    public Region  region;        // 01
    public Target  target;        // 20
    public Currency currency;     // JPY

	public FundData() {
		this.dateTime      = null;
		this.isinCode      = null;
		//
	    this.divRatio      = null;
	    this.category      = null;
	    this.fundName      = null;
	    this.hyokaKijyunbi = null;
	    this.marketCap     = null;
	    this.company       = null;
	    this.divFreq       = null;
	    this.price         = null;
	    this.expenseRatio  = null;
	    this.region        = null;
	    this.target        = null;
	    this.currency      = null;
	}
	
	public FundData(JsonObject jsonObject) {
		super(jsonObject);
	}
	
	@Override
	public int compareTo(FundData that) {
		int ret = this.dateTime.compareTo(that.dateTime);
		if (ret == 0) ret = this.isinCode.compareTo(that.isinCode);
		return ret;
	}
}
