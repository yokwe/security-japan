package yokwe.security.japan.ufocatch;

import yokwe.UnexpectedException;

public enum Kind {
	EDINET ("edinet"),  // EDINET情報配信サービス
	EDINETX("edinetx"), // EDINET情報配信サービス(XBRL情報があるもの)
	TDNET  ("tdnet"),   // 適時開示情報配信サービス
	TDNETX ("tdnetx"),  // 適時開示情報配信サービス(XBRL情報があるもの)
	CG     ("cg");      // コーポレート・ガバナンス情報配信サービス
	
	private static final Kind[] values = Kind.values();
	public static Kind getInstance(String string) {
		for(Kind kind: values) {
			if (kind.url.equals(string)) {
				return kind;
			}
		}
		Atom.logger.error("Unextected string {}!", string);
		throw new UnexpectedException("Unextected string");
	}
	public final String url;
	Kind(String url) {
		this.url = url;
	}
}