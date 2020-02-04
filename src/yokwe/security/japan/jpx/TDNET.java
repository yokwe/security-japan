package yokwe.security.japan.jpx;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.StringUtil;

public class TDNET {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TDNET.class);

	// 適時開示システム タクソノミ設定規約書
	//   https://www.jpx.co.jp/equities/listing/xbrl/03.html
	
	// 期区分
	public enum Period {
		ANNUAL ("a", "通期"),   // 通期
		HALF   ("s", "中間期"), // 特定事業会社第２四半期／中間期
		QUATER ("q", "四半期"); // 四半期
		
		private static final Period[] VALUES = Period.values();
		public static Period getInstance(String value) {
			if (value == null || value.isEmpty()) return null;
			for(Period period: VALUES) {
				if (value.equals(period.value)) return period;
			}
			logger.error("Unknown value {}!", value);
			throw new UnexpectedException("Unknown value");
		}
		
		public final String value;
		public final String message;
		
		Period(String value, String message) {
			this.value   = value;
			this.message = message;
		}
		
		@Override
		public String toString() {
			return message;
		}
	}
	
	// 連結・非連結区分
	public enum Consolidate {
		CONSOLIDATE     ("c", "連結"), // 連結
		NOT_CONSOLIDATE ("n", "単体"); // 非連結
		
		private static final Consolidate[] VALUES = Consolidate.values();
		public static Consolidate getInstance(String value) {
			if (value == null || value.isEmpty()) return null;
			for(Consolidate consolidate: VALUES) {
				if (value.equals(consolidate.value)) return consolidate;
			}
			logger.error("Unknown value {}!", value);
			throw new UnexpectedException("Unknown value");
		}
		
		public final String value;
		public final String message;
				
		Consolidate(String value, String message) {
			this.value   = value;
			this.message = message;
		}
		
		@Override
		public String toString() {
			return message;
		}
	}

	// 報告区分
	public enum Category {
		EDJP   ("edjp", "決算短信（日本基準）"),              // 決算短信（日本基準）
		EDUS   ("edus", "決算短信（米国基準）"),              // 決算短信（米国基準）
		EDIF   ("edif", "決算短信（国際会計基準）"),           // 決算短信（国際会計基準）
		EDIT   ("edit", "決算短信（国際会計基準※IFRS）"),     // 決算短信（国際会計基準） ※IFRSタクソノミを利用する場合
		
		REJP   ("rejp", "REIT決算短信（日本基準）"),          // REIT決算短信（日本基準）
		EFJP   ("efjp", "ETF決算短信（日本基準）"),           // ETF決算短信（日本基準）

		RVDF   ("rvdf", "配当予想修正に関するお知らせ"),        // 配当予想修正に関するお知らせ
		RVFC   ("rvfc", "業績予想修正に関するお知らせ"),        // 業績予想修正に関するお知らせ
		RRDF   ("rrdf", "分配予想の修正に関するお知らせ"),      // 分配予想の修正に関するお知らせ
		RRFC   ("rrfc", "運用状況の予想の修正に関するお知らせ"); // 運用状況の予想の修正に関するお知らせ
		
		private static final Category[] VALUES = Category.values();
		public static Category getInstance(String value) {
			if (value == null || value.isEmpty()) return null;
			for(Category category: VALUES) {
				if (value.equals(category.value)) return category;
			}
			logger.error("Unknown value {}!", value);
			throw new UnexpectedException("Unknown value");
		}
		
		public final String value;
		public final String message;
				
		Category(String value, String message) {
			this.value   = value;
			this.message = message;
		}
		
		@Override
		public String toString() {
			return message;
		}
	}

	// 報告詳細区分
	public enum Detail {
		SUMMARY   ("sm", "サマリー"), // 決算短信サマリー情報
		FINANCIAL ("fr", "財務諸表"); // 決算短信財務諸表情報
		
		private static final Detail[] VALUES = Detail.values();
		public static Detail getInstance(String value) {
			if (value == null || value.isEmpty()) return null;
			for(Detail detail: VALUES) {
				if (value.equals(detail.value)) return detail;
			}
			logger.error("Unknown value {}!", value);
			throw new UnexpectedException("Unknown value");
		}
		
		public final String value;
		public final String message;
				
		Detail(String value, String message) {
			this.value   = value;
			this.message = message;
		}
		
		@Override
		public String toString() {
			return message;
		}
	}

	// 決算短信サマリー情報及び予想修正報告
	// インラインXBRLファイル名
    //   tse-{報告書}[{報告書詳細区分}]-{証券コード}-{開示番号}-ixbrl.htm
	// 報告書   :=  [{期区分}{連結・非連結区分}]{報告区分}
	// 開示番号　:=  {提出日 8 桁}{3 から開始する連番 1桁}{証券コード 5 桁}
	//   tse-qcedjpsm-71770-20170725371770-ixbrl.htm
	//   tse-rvfc-82270-20191222439755-ixbrl.htm
	public static class FinancialSummary implements Comparable<FinancialSummary> {
		private static final Pattern PAT = Pattern.compile("tse-(?<period>[asq]?)(?<consolidate>[cn]?)(?<category>[a-z]{4})(?<detail>(sm|fr)?)-(?<tdnetCode>[0-9]{5})-(?<id>[0-9]{14})-ixbrl.htm");
		
		private static final StringUtil.MatcherFunction<FinancialSummary> OP = (m -> new FinancialSummary(
				m.group("period"),
				m.group("consolidate"),
				m.group("category"),
				m.group("detail"),
				m.group("tdnetCode"),
				m.group("id")));
		public static FinancialSummary getInstance(String string) {
			List<FinancialSummary> list = StringUtil.find(string, PAT, OP).collect(Collectors.toList());
			if (list.size() == 0) return null;
			if (list.size() == 1) return list.get(0);
			logger.error("Unexpected value %s!", list);
			throw new UnexpectedException("Unexpected value");
		}

		public final Period      period;
		public final Consolidate consolidate;
		public final Category    category;
		public final Detail      detail;
		public final String      tdnetCode;
		public final String      id;
		public final String      string;
		
		public FinancialSummary(String period, String consolidate, String category, String detail, String tdnetCode, String id) {
			this.period      = Period.getInstance(period);
			this.consolidate = Consolidate.getInstance(consolidate);
			this.category    = Category.getInstance(category);
			this.detail      = Detail.getInstance(detail);
			this.tdnetCode   = tdnetCode;
			this.id          = id;
			
			{
				//   tse-qcedjpsm-71770-20170725371770-ixbrl.htm
				StringBuffer sb = new StringBuffer();
//				sb.append("tse-");
				if (this.period != null) {
					sb.append(this.period.value);
				}
				if (this.consolidate != null) {
					sb.append(this.consolidate.value);
				}
				sb.append(this.category.value);
				if (this.detail != null) {
					sb.append(this.detail.value);
				}
				sb.append("-");
				sb.append(this.tdnetCode);
				sb.append("-");
				sb.append(this.id);
//				sb.append("-ixbrl.htm");
				
				this.string = sb.toString();
			}
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null) return false;
			if (o instanceof FinancialSummary) {
				FinancialSummary that = (FinancialSummary)o;
				return this.string.equals(that.string);
			} else {
				return false;
			}
		}
		@Override
		public String toString() {
			return string;
		}

		@Override
		public int compareTo(FinancialSummary that) {
			int ret = this.tdnetCode.compareTo(that.tdnetCode);
			if (ret == 0) ret = this.id.compareTo(that.id);
			if (ret == 0) ret = this.category.value.compareTo(that.category.value);
			if (ret == 0) ret = this.string.compareTo(that.string);
			return ret;
		}
		
	}
	
	
	// 決算短信財務諸表情報
	// インラインXBRLファイル名
	//   {一意の7桁数値}-{財表識別区分}-tse-{報告書}[{報告書詳細区分}]-{証券コード}-{期末日}-{提出回数}-{提出日}-ixbrl.htm
	//   0500000-qcbs01-tse-qcedjpfr-71770-2017-06-30-01-2017-07-25-ixbrl.htm
	//   0600000-qcpl11-tse-qcedjpfr-71770-2017-06-30-01-2017-07-25-ixbrl.htm
	//   0700000-qcci11-tse-qcedjpfr-71770-2017-06-30-01-2017-07-25-ixbrl.htm
		
	// 提出日     :=  報告書の提出日（YYYY-MM-DD形式）
	// 期末日     :=  報告期間の期末日（YYYY-MM-DD形式）
	
	// 財表識別区分
	// a----- 通期
	// q----- 四半期第
	// s----- 中間期  特定２Ｑ
	// -c---- 連結
	// -n---- 非連結
	// -r---- REIT
	// -e---- ETF
	// --bs-- 貸借対照表
	// --pc-- 損益及び包括利益計算書
	// --ss-- 株主資本等変動計算書
	// --cf-- キャッシュ・フロー計算書
	// --ci-- 包括利益計算書
	// --pl-- 損益計算書
	// ----99 様式
	
	// 通期第１号様式　[日本基準]（連結）
	// acbs01  連結貸借対照表
	// acpc01  連結損益及び包括利益計算書
	// acss01  連結株主資本等変動計算書
	// accf01  連結キャッシュ・フロー計算書
	// anbs01  貸借対照表
	// anpl01  損益計算書
	// anss01  株主資本等変動計算書
	// ancf01  キャッシュ・フロー計算書
	
	// 通期第２号様式　[日本基準]（非連結）
	// anbs02  貸借対照表
	// anpl02  損益計算書
	// anss02  株主資本等変動計算書
	// ancf02  キャッシュ・フロー計算書
	
	// 通期第３号様式　[IFRS]（連結）　※1計算書方式の場合
	// acbs03  連結財政状態計算書
	// acpc03  連結包括利益計算書 ?? typo accci03
	// acss03  連結持分変動計算書
	// accf03  連結キャッシュ・フロー計算書
	// anbs03  貸借対照表
	// anpl03  損益計算書
	// anss03  株主資本等変動計算書
	// ancf03  キャッシュ・フロー計算書
	
	// 通期第３号様式　[IFRS]（連結）　※2計算書方式の場合
	// acbs03  連結財政状態計算書
	// acpl03  連結損益計算書
	// acci03  連結包括利益計算書
	// acss03  連結持分変動計算書
	// accf03  連結キャッシュ・フロー計算書
	// anbs03  貸借対照表
	// anpl03  損益計算書
	// anss03  株主資本等変動計算書
	// ancf03  キャッシュ・フロー計算書
	
	// 通期[IFRS]（非連結）＊2計算書方式
	// anbs53  財政状態計算書
	// anpl53  損益計算書
	// anci53  包括利益計算書
	// anss53  持分変動計算書
	// ancf53  キャッシュ・フロー計算書
	
	// 通期第４号様式　[米国基準]（連結）
	// anbs04  貸借対照表
	// anpl04  損益計算書
	// anss04  株主資本等変動計算書
	// ancf04  キャッシュ・フロー計算書
	
	// 四半期第１号様式　[日本基準]（連結）
	// qcbs01  四半期連結貸借対照表
	// qcpc11  四半期連結損益及び包括利益計算書（四半期連結累計期間）
	// qcpc21  四半期連結損益及び包括利益計算書（四半期連結会計期間）
	// qccf01  四半期連結キャッシュ・フロー計算書
	
	// 四半期第１号様式　[日本基準]（連結）
	// qcbs01  四半期連結貸借対照表
	// qcpl11  四半期連結損益計算書（四半期連結累計期間）
	// qcpl21  四半期連結損益計算書（四半期連結会計期間）
	// qcci11  四半期包括利益計算書（四半期連結累計期間）
	// qcci21  四半期包括利益計算書（四半期連結会計期間）
	// qccf01  四半期連結キャッシュ・フロー計算書
	
	// 四半期第２号様式　[日本基準]（非連結）
	// qnbs02  四半期貸借対照表
	// qnpl12  四半期損益計算書（四半期累計期間）
	// qnpl22  四半期損益計算書（四半期会計期間）
	// qncf02  四半期キャッシュ・フロー計算書
	
	// 四半期第３号様式　[IFRS]（連結） ※単一の要約計算書の場合
	// qcfs03  要約四半期連結財政状態計算書 任意 必須 qcfs03
	// qcci13  要約四半期連結包括利益計算書（四半期連結累計期間） 任意 必須 qcci13
	// qcci23  要約四半期連結包括利益計算書（四半期連結会計期間） 任意 任意 qcci23
	// qcss03  要約四半期連結持分変動計算書 任意 必須 qcss03
	// qccf03  要約四半期連結キャッシュ・フロー計算書 任意 必須 ※開示する場合は必須 qccf03
	
	// 四半期第３号様式　[IFRS]（連結）　※要約分離損益計算書及び要約包括利益計算書の場合
	// qcfs03  要約四半期連結財政状態計算書
	// qcpl13  要約四半期連結損益計算書（四半期連結累計期間）
	// qcpl23  要約四半期連結損益計算書（四半期連結会計期間）
	// qcci13  要約四半期連結包括利益計算書（四半期連結累計期間）
	// qcci23  要約四半期連結包括利益計算書（四半期連結会計期間）
	// qcss03  要約四半期連結持分変動計算書
	// qccf03  要約四半期連結キャッシュ・フロー計算書
	
	// 四半期[IFRS]（非連結） ＊1計算書方式
	// qnfs53  要約四半期財政状態計算書
	// qnci63  要約四半期包括利益計算書（四半期連結累計期間）
	// qnci73  要約四半期包括利益計算書（四半期連結会計期間）
	// qnss53  要約四半期持分変動計算書
	// qncf53  要約四半期キャッシュ・フロー計算書
	
	// 四半期[IFRS]（非連結） ＊2計算書方式
	// qnfs53  要約四半期財政状態計算書
	// qnpl63  要約四半期損益計算書（四半期連結累計期間）
	// qnpl73  要約四半期損益計算書（四半期連結会計期間）
	// qnci63  要約四半期包括利益計算書（四半期連結累計期間）
	// qnci73  要約四半期包括利益計算書（四半期連結会計期間）
	// qnss53  要約四半期持分変動計算書
	// qncf53  要約四半期キャッシュ・フロー計算書
	
	// 四半期第５号様式　[日本基準]（連結）（特定２Ｑ）　※1計算書方式の場合
	// scbs05  中間連結貸借対照表
	// scpc05  中間連結損益及び包括利益計算書
	// scss05  中間連結株主資本等変動計算書
	// sccf05  中間連結キャッシュ・フロー計算書
	// snbs05  中間貸借対照表
	// snpl05  中間損益計算書
	// snss05  中間株主資本等変動計算書
	// sncf05  中間キャッシュ・フロー計算書
	
	// 四半期第５号様式　[日本基準]（連結）（特定２Ｑ）　※2計算書方式の場合
	// scbs05  中間連結貸借対照表
	// scpl05  中間連結損益計算書
	// scci05  中間連結包括利益計算書
	// scss05  中間連結株主資本等変動計算書
	// sccf05  中間連結キャッシュ・フロー計算書
	// snbs05  中間貸借対照表
	// snpl05  中間損益計算書
	// snss05  中間株主資本等変動計算書
	// sncf05  中間キャッシュ・フロー計算書
	
	// 四半期第６号様式　[日本基準]（非連結）（特定２Ｑ）
	// snbs06  中間貸借対照表
	// snpl06  中間損益計算書
	// snss06  中間株主資本等変動計算書
	// sncf06  中間キャッシュ・フロー計算書
	
	// 四半期第７号様式　[IFRS]（連結）（特定２Ｑ）　※単一の要約計算書の場合
	// scfs07  要約中間連結財政状態計算書
	// scci07  要約中間連結包括利益計算書
	// scss07  要約中間連結持分変動計算書
	// sccf07  要約中間連結キャッシュ・フロー計算書
	// snbs07  中間貸借対照表
	// snpl07  中間損益計算書
	// snss07  中間株主資本等変動計算書
	// sncf07  中間キャッシュ・フロー計算書
	
	// 四半期第７号様式　[IFRS]（連結）（特定２Ｑ）　※要約分離損益計算書及び要約包括利益計算書の場合
	// scfs07  要約中間連結財政状態計算書
	// scpl07  要約中間連結損益計算書
	// scci07  要約中間連結包括利益計算書
	// scss07  要約中間連結持分変動計算書
	// sccf07  要約中間連結キャッシュ・フロー計算書
	// snbs07  中間貸借対照表
	// snpl07  中間損益計算書
	// snss07  中間株主資本等変動計算書
	// sncf07  中間キャッシュ・フロー計算書
	
	// REIT様式（通期）
	// arbs01  貸借対照表 必須 必須 arbs01
	// arpl01  損益計算書 必須 必須 arpl01
	// arss01  投資主資本等変動計算書 必須 必須 arss01
	// ards01  金銭の分配に係る計算書 必須 必須 ards01
	// arcf01  キャッシュ・フロー計算書 必須 必須 arcf01
	
	// REIT様式（中間期）
	// srbs01  中間貸借対照表
	// srpl01  中間損益計算書
	// srss01  中間投資主資本等変動計算書
	// srcf01  中間キャッシュ・フロー計算書
	
	// ETF様式（通期）
	// aebs01  貸借対照表
	// aepl01  損益及び剰余金計算書
	
	// ETF様式（中間期）
	// sebs01  中間貸借対照表
	// sepl01  中間損益及び剰余金計算書
}
