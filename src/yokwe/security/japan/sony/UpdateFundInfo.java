package yokwe.security.japan.sony;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.LoggerFactory;

import yokwe.util.FileUtil;
import yokwe.util.ScrapeUtil;

public class UpdateFundInfo {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateFundInfo.class);

	private static String URL = "https://apl.morningstar.co.jp/webasp/sonybk/detail/%s.html";
	public static String getURL(String isinCode) {
		return String.format(URL, isinCode);
	}
	
	// 現在値
	// var msFundCode = '2013121001';
	public static class MSFundCode {
		public static final Pattern PAT = Pattern.compile(
			"var msFundCode = '(?<msFundCode>.+?)';"
		);
		public static MSFundCode getInstance(String page) {
			return ScrapeUtil.get(MSFundCode.class, PAT, page);
		}

		public final String msFundCode;
		
		public MSFundCode(String msFundCode) {
			this.msFundCode = msFundCode;
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", msFundCode);
		}
	}
	
	// ファンドの特色
//	<section class="dd_box mt10"><h2>ファンドの特色</h2>
//	<hr class="hr1">
//	<p>日本を除く世界主要先進国の株式に投資することにより､MSCIコクサイ･インデックス(配当込み､円換算ベース)に連動する投資成果をめざす｡独自の計量モデル等を活用し､ポートフォリオを構築する｡購入時および換金時の手数料は無料､信託財産留保額なし｡原則として､対円での為替ヘッジは行わない｡ファミリーファンド方式で運用｡11月決算｡</p></section>
	public static class Description {
		public static final Pattern PAT = Pattern.compile(
			"<section class=\"dd_box mt10\"><h2>ファンドの特色</h2>\\s+" +
			"<hr class=\"hr1\">\\s+" +
			"<p>(?<value>.+)</p>"
		);
		public static Description getInstance(String page) {
			return ScrapeUtil.get(Description.class, PAT, page);
		}

		public final String value;
		
		public Description(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 設定日
//	<dt>設定日</dt>
//	<dd>2013年12月10日</dd>
	public static class InceptionDate {
		public static final Pattern PAT = Pattern.compile(
			"<dt>設定日</dt>\\s+" +
			"<dd>(?<value>.+)</dd>"
		);
		public static InceptionDate getInstance(String page) {
			return ScrapeUtil.get(InceptionDate.class, PAT, page);
		}

		public final String value;
		
		public InceptionDate(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 償還日
//	<dt>償還日</dt>
//	<dd>無期限</dd>
	public static class RedemptionDate {
		public static final Pattern PAT = Pattern.compile(
			"<dt>償還日</dt>\\s+" +
			"<dd>(?<value>.+)</dd>"
		);
		public static RedemptionDate getInstance(String page) {
			return ScrapeUtil.get(RedemptionDate.class, PAT, page);
		}

		public final String value;
		
		public RedemptionDate(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 決算日
//	<dt>決算日</dt>
//	<dd>11月20日</dd>
	public static class ClosingDate {
		public static final Pattern PAT = Pattern.compile(
			"<dt>決算日</dt>\\s+" +
			"<dd>(?<value>[^<]+)</dd>"
		);
		public static ClosingDate getInstance(String page) {
			return ScrapeUtil.get(ClosingDate.class, PAT, page);
		}

		public final String value;
		
		public ClosingDate(String value) {
			this.value = value.replace(" ", "").replace("\r", "").replace("\n", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 購入単位
//	<dt>購入単位</dt>
//	<dd>通常購入：1万円以上1円単位<br>積立：1千円以上1円単位</dd>
	public static class PurchaseUnit {
		public static final Pattern PAT = Pattern.compile(
			"<dt>購入単位</dt>\\s+" +
			"<dd>通常購入：(?<value>[^<]+)<"
		);
		public static PurchaseUnit getInstance(String page) {
			return ScrapeUtil.get(PurchaseUnit.class, PAT, page);
		}

		public final String value;
		
		public PurchaseUnit(String value) {
			this.value = value.replace(" ", "").replace("\r", "").replace("\n", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 購入約定日
//	<dt>購入約定日</dt>
//	<dd>購入申込受付日の翌営業日</dd>
	public static class PurchaseDate {
		public static final Pattern PAT = Pattern.compile(
			"<dt>購入約定日</dt>\\s+" +
			"<dd>(?<value>[^<]+)</dd>"
		);
		public static PurchaseDate getInstance(String page) {
			return ScrapeUtil.get(PurchaseDate.class, PAT, page);
		}

		public final String value;
		
		public PurchaseDate(String value) {
			this.value = value.replace(" ", "").replace("\r", "").replace("\n", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 購入価格
//	<dt>購入価格</dt>
//	<dd>購入約定日の基準価額</dd>
	public static class PurchasePrice {
		public static final Pattern PAT = Pattern.compile(
			"<dt>購入価格</dt>\\s+" +
			"<dd>(?<value>[^<]+)</dd>"
		);
		public static PurchasePrice getInstance(String page) {
			return ScrapeUtil.get(PurchasePrice.class, PAT, page);
		}

		public final String value;
		
		public PurchasePrice(String value) {
			this.value = value.replace(" ", "").replace("\r", "").replace("\n", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 解約単位
//	<dt>解約単位</dt>
//	<dd>1円以上1円単位</dd>
	public static class CancelUnit {
		public static final Pattern PAT = Pattern.compile(
			"<dt>解約単位</dt>\\s+" +
			"<dd>(?<value>[^<]+)</dd>"
		);
		public static CancelUnit getInstance(String page) {
			return ScrapeUtil.get(CancelUnit.class, PAT, page);
		}

		public final String value;
		
		public CancelUnit(String value) {
			this.value = value.replace(" ", "").replace("\r", "").replace("\n", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}
	
	// 解約価格
//	<dt>解約価格</dt>
//	<dd>解約申込受付日の翌営業日の基準価額</dd>
	public static class CancellPrice {
		public static final Pattern PAT = Pattern.compile(
			"<dt>解約価格</dt>\\s+" +
			"<dd>(?<value>[^<]+)</dd>"
		);
		public static CancellPrice getInstance(String page) {
			return ScrapeUtil.get(CancellPrice.class, PAT, page);
		}

		public final String value;
		
		public CancellPrice(String value) {
			this.value = value.replace(" ", "").replace("\r", "").replace("\n", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 解約代金支払日
//	<dt>解約代金支払日</dt>
//	<dd>解約申込受付日から6営業日目</dd>
	public static class CancelPaymentDate {
		public static final Pattern PAT = Pattern.compile(
			"<dt>解約代金支払日</dt>\\s+" +
			"<dd>(?<value>[^<]+)</dd>"
		);
		public static CancelPaymentDate getInstance(String page) {
			return ScrapeUtil.get(CancelPaymentDate.class, PAT, page);
		}

		public final String value;
		
		public CancelPaymentDate(String value) {
			this.value = value.replace(" ", "").replace("\r", "").replace("\n", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 購入・解約の申込締切
//	<dt>購入・解約の申込締切</dt>
//	<dd>15:00</dd>
	public static class Deadline {
		public static final Pattern PAT = Pattern.compile(
			"<dt>購入・解約の申込締切</dt>\\s+" +
			"<dd>(?<value>[^<]+)</dd>"
		);
		public static Deadline getInstance(String page) {
			return ScrapeUtil.get(Deadline.class, PAT, page);
		}

		public final String value;
		
		public Deadline(String value) {
			this.value = value.replace(" ", "").replace("\r", "").replace("\n", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 販売手数料（税込）
//	<dt>販売手数料（税込）</dt>
//	<dd>
//	<div class="bg_f2f0d9">50口未満 なし</div>
//	<div>50口以上500口未満 なし</div>
//	<div class="bg_f2f0d9">500口以上 なし</div>
//	</dd>
	public static class SalesFee {
		public static final Pattern PAT = Pattern.compile(
			"<dt>販売手数料（税込）</dt>\\s+" + 
			"<dd>\\s+" +
			"<div.*?>(?<a>.+)</div>\\s+" +
			"<div.*?>(?<b>.+)</div>\\s+" +
			"<div.*?>(?<c>.+)</div>\\s+" +
			"</dd>"
		);
		public static SalesFee getInstance(String page) {
			return ScrapeUtil.get(SalesFee.class, PAT, page);
		}

		public final String a;
		public final String b;
		public final String c;
		
		public SalesFee(String a, String b, String c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return String.format("{%s %s %s}", a, b, c);
		}
	}

	// 信託報酬（税込）
//	<dt>信託報酬（税込）</dt>
//	<dd>0.1023%
//	                                </dd>
	public static class TrustFee {
		public static final Pattern PAT = Pattern.compile(
			"<dt>(管理|信託)報酬（税込）</dt>\\s+" +
			"<dd>(?<value>[^<]+)</dd>"
		);
		public static TrustFee getInstance(String page) {
			return ScrapeUtil.get(TrustFee.class, PAT, page);
		}

		public final String value;
		
		public TrustFee(String value) {
			this.value = value.replace(" ", "").replace("\r", "").replace("\n", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 実質信託報酬（税込）
//	<dt>実質信託報酬（税込）</dt>
//	<dd>0.1023%</dd>
	public static class RealTrustFee {
		public static final Pattern PAT = Pattern.compile(
			"<dt>実質(管理|信託)報酬（税込）</dt>\\s+" +
			"<dd>(?<value>[^<]+)</dd>"
		);
		public static RealTrustFee getInstance(String page) {
			return ScrapeUtil.get(RealTrustFee.class, PAT, page);
		}

		public final String value;
		
		public RealTrustFee(String value) {
			this.value = value.replace(" ", "").replace("\r", "").replace("\n", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

	// 信託財産留保額
//	<dt>信託財産留保額</dt>
//	<dd>
//												-
//											</dd>
	public static class CancelFee {
		public static final Pattern PAT = Pattern.compile(
			"<dt>信託財産留保額</dt>\\s+" +
			"<dd>(?<value>[^<]+)</dd>"
		);
		public static CancelFee getInstance(String page) {
			return ScrapeUtil.get(CancelFee.class, PAT, page);
		}

		public final String value;
		
		public CancelFee(String value) {
			this.value = value.replace(" ", "").replace("\t", "").replace("\r", "").replace("\n", "").replace("-", "");
		}
		
		@Override
		public String toString() {
			return String.format("{%s}", value);
		}
	}

//	<dl class="kihon3 mt5 clearfix bg_fdf9f5">
//	<dt>2019年11月20日</dt>
//	<dd>0円</dd>
//	</dl>
	public static class DivHistory {
		public static final Pattern PAT = Pattern.compile(
			"<dl class=\"kihon(3|4).*?\">\\s+" +
			"<dt>(?<date>.+?)</dt>\\s+" +
			"<dd>(?<value>.+?)</dd>\\s+" +
			"</dl>"
		);
		public static List<DivHistory> getInstance(String page) {
			return ScrapeUtil.getList(DivHistory.class, PAT, page);
		}
		
		public final String date;
		public final String value;
		
		public DivHistory(String date, String value) {
			this.date  = date;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return String.format("{%s %s}", date, value);
		}
	}

	
	private static FundInfo getInstance(String isinCode, String page) {
		MSFundCode        msFundCode        = MSFundCode.getInstance(page);
		Description       description       = Description.getInstance(page);
		InceptionDate     inceptionDate     = InceptionDate.getInstance(page);
		RedemptionDate    redemptionDate    = RedemptionDate.getInstance(page);
		ClosingDate       closingDate       = ClosingDate.getInstance(page);
		PurchaseUnit      purchaseUnit      = PurchaseUnit.getInstance(page);
		PurchaseDate      purchaseDate      = PurchaseDate.getInstance(page);
		PurchasePrice     purchasePrice     = PurchasePrice.getInstance(page);
		CancelUnit        cancelUnit        = CancelUnit.getInstance(page);
		CancellPrice      cancelPrice       = CancellPrice.getInstance(page);
		CancelPaymentDate cancelPaymentDate = CancelPaymentDate.getInstance(page);
		Deadline          deadline          = Deadline.getInstance(page);
		SalesFee          salesFee          = SalesFee.getInstance(page);
		TrustFee          trustFee          = TrustFee.getInstance(page);
		RealTrustFee      realTrustFee      = RealTrustFee.getInstance(page);
		CancelFee         cancelFee         = CancelFee.getInstance(page);
//		List<DivHistory>  divHistoryList    = DivHistory.getInstance(page);
		
		FundInfo ret = new FundInfo();
		
		ret.isinCode          = isinCode;
		ret.msFundCode        = (msFundCode == null) ? "" : msFundCode.msFundCode;
		ret.description       = description.value;
		ret.inceptionDate     = inceptionDate.value;
		ret.redemptionDate    = redemptionDate.value;
		ret.closingDate       = closingDate.value;
		ret.purchaseUnit      = purchaseUnit.value;
		ret.purchaseDate      = purchaseDate.value;
		ret.purchasePrice     = purchasePrice.value;
		ret.cancelUnit        = cancelUnit.value;
		ret.cancelPrice       = cancelPrice.value;
		ret.cancelPaymentDate = cancelPaymentDate.value;
		ret.deadline          = deadline.value;
		ret.cancelFee         = (cancelFee == null) ? "" : cancelFee.value;
		ret.salesFeeA         = (salesFee == null) ? "" : salesFee.a;
		ret.salesFeeB         = (salesFee == null) ? "" : salesFee.b;
		ret.salesFeeC         = (salesFee == null) ? "" : salesFee.c;
		ret.trustFee          = trustFee.value;
		ret.realTrustFee      = realTrustFee.value;
//		ret.divHistory        = divHistoryList.toString();

		return ret;
	}
	
	public static void main(String[] args) {
		logger.info("START");
		
		List<FundInfo> list = new ArrayList<>();
		
		for(FundData e: FundData.getList()) {
			String isinCode = e.isinCode;
			String path = String.format("tmp/download/sony/%s", isinCode);
//			String url = getURL(isinCode);
			
//			HttpUtil.Result result = HttpUtil.getInstance().download(url);
//			String string = result.result;
//			FileUtil.write().file(path, string);
			String string = FileUtil.read().file(path);
			
//			if (!string.contains("var msFundCode =")) continue;
			
			logger.info("isinCode {}", isinCode);
			FundInfo fundInfo = getInstance(e.isinCode, string);
			logger.info("  {}", fundInfo);
			list.add(fundInfo);
		}
		
		logger.info("save {} {}", list.size(), FundInfo.PATH_FILE);
		FundInfo.save(list);
		
		logger.info("STOP");
	}

}
