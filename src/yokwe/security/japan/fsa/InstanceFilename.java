package yokwe.security.japan.fsa;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.StringUtil;

public class InstanceFilename implements Comparable<InstanceFilename> {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(InstanceFilename.class);

	// jp{府令略号}{様式番号}-{報告書略号}-{報告書連番(3 桁)}_{EDINET コード又はファンドコード}-{追番(3 桁)}_{報告対象期間期末日|報告義務発生日}_{報告書提出回数(2 桁)}_{報告書提出日}.xbrl 
	// jp crp 040300     -q3r        -001             _E01442                      -000        _2020-01-31                   _01                 _2020-03-06.xbrl
	// jpcrp040300-q3r-001_E01442-000_2020-01-31_01_2020-03-06.xbrl
	
	private static final Pattern PAT = Pattern.compile("jp(?<ordinance>[a-z]+)(?<form>[0-9]{6})-(?<report>.+?)-(?<reportNo>[0-9]{3})_(?<code>[EG][0-9]{5})-(?<extraNo>[0-9]{3})_(?<date>20[0-9]{2}-[01][0-9]-[0-3][0-9])_(?<submitNo>[0-9]{2})_(?<submitDate>20[0-9]{2}-[01][0-9]-[0-3][0-9]).xbrl");

	private static final StringUtil.MatcherFunction<InstanceFilename> OP = (m -> new InstanceFilename(
			m.group("ordinance"),
			m.group("form"),
			m.group("report"),
			m.group("reportNo"),
			m.group("code"),
			m.group("extraNo"),
			m.group("date"),
			m.group("submitNo"),
			m.group("submitDate")));

	public static enum Ordinance {
		CRP("crp"), // 企業内容等の開示に関する内閣府令
		CTL("ctl"), // 財務計算に関する書類その他の情報の適正性を確保するための体制に関する内閣府令
		SPS("sps"), // 特定有価証券の内容等の開示に関する内閣府令
		TOO("too"), // 発行者以外の者による株券等の公開買付けの開示に関する内閣府令
		TOI("toi"), // 発行者による上場株券等の公開買付けの開示に関する内閣府令
		LVH("lvh"), // 株券等の大量保有の状況の開示に関する内閣府令
		AUD("aud"), // 財務諸表等の監査証明に関する内閣府令
		PFS("pfs"), // 日本基準財務諸表のうち本表に係る部分
		IGP("igp"); // IFRS 財務諸表
		
		public final String value;
		Ordinance(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
		
		private static final Ordinance[] VALUES = Ordinance.values();
		public static Ordinance getInstance(String value) {
			if (value == null || value.isEmpty()) return null;
			for(Ordinance oridinance: VALUES) {
				if (value.equals(oridinance.value)) return oridinance;
			}
			logger.error("Unknown value {}!", value);
			throw new UnexpectedException("Unknown value");
		}
	}

	public static enum Report {
		SRS("srs"), // 有価証券届出書
		ASR("asr"), // 有価証券報告書
		DRS("drs"), // 有価証券報告書【みなし有価証券届出書】
		QSR("qsr"), // 四半期報告書
		SSR("ssr"), // 中間期報告書
		ESR("esr"), // 臨時報告書
		RST("rst"), // 発行登録書
		REP("rep"), // 発行登録追補書類
		SBR("sbr"), // 自己株券買付状況報告書
		TON("ton"), // 公開買付届出書
		PST("pst"), // 意見表明報告書
		WTO("wto"), // 公開買付撤回届出書
		TOR("tor"), // 公開買付報告書
		TOA("toa"), // 対質問回答報告書
		LVH("lvh"), // 大量保有報告書
		ICR("icr"), // 内部統制報告書
		
		Q1R("q1r"), // 第１四半期報告書
		Q2R("q2r"), // 第２四半期報告書
		Q3R("q3r"), // 第３四半期報告書
		Q4R("q4r"), // 第４四半期報告書
		Q5R("q5r"); // 第５四半期報告書
		
		public final String value;
		Report(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
		
		private static final Report[] VALUES = Report.values();
		public static Report getInstance(String value) {
			if (value == null || value.isEmpty()) return null;
			for(Report report: VALUES) {
				if (value.equals(report.value)) return report;
			}
			logger.error("Unknown value {}!", value);
			throw new UnexpectedException("Unknown value");
		}
	}
	
	public final Ordinance ordinance;
	public final String    form;
	public final Report    report;
	public final String    reportNo;
	public final String    code;
	public final String    extraNo;
	public final String    date;
	public final String    submitNo;
	public final String    submitDate;
	public final String    string;
	
	public InstanceFilename(String ordinance, String form, String report, String reportNo, String code, String extraNo, String date, String submitNo, String submitDate) {
		this.ordinance = Ordinance.getInstance(ordinance);
		this.form = form;
		this.report = Report.getInstance(report);
		this.reportNo = reportNo;
		this.code = code;
		this.extraNo = extraNo;
		this.date = date;
		this.submitNo = submitNo;
		this.submitDate = submitDate;
		
		this.string = String.format("jp%s%s-%s-%s_%s-%s_%s_%s_%s.xbrl", ordinance, form, report, reportNo, code, extraNo, date, submitNo, submitDate);
	}
	
	public static InstanceFilename getInstance(String string) {
		List<InstanceFilename> list = StringUtil.find(string, PAT, OP).collect(Collectors.toList());
		if (list.size() == 0) return null;
		if (list.size() == 1) return list.get(0);
		logger.error("Unexpected value %s!", list);
		throw new UnexpectedException("Unexpected value");
	}
	
	@Override
	public String toString() {
		return string;
	}
	@Override
	public int compareTo(InstanceFilename that) {
		// jpcrp040300-q3r-001_E01442-000_2020-01-31_01_2020-03-06.xbrl
		int ret = this.code.compareTo(that.code);
		if (ret == 0) ret = this.submitDate.compareTo(that.submitDate);
		if (ret == 0) ret = this.submitNo.compareTo(submitNo);
		if (ret == 0) ret = this.extraNo.compareTo(extraNo);
		return ret;
	}
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o instanceof InstanceFilename) {
			InstanceFilename that = (InstanceFilename)o;
			return this.string.equals(that.string);
		} else {
			return false;
		}
	}
}
