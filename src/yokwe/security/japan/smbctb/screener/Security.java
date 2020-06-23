package yokwe.security.japan.smbctb.screener;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import yokwe.util.StringUtil;

public class Security {
	//<Security id="F00000JQ91">
	//<isin>LU0525289848</isin>
	//<customInstitutionSecurityId>31090024</customInstitutionSecurityId>
	//<customFundName>ブラックロック・グローバル・インベストメント　ブラックロック・グローバル・アロケーション・ポートフォリオ　豪ドル建て</customFundName>
	//</Security>

	@XmlAttribute(name = "id")                          public String id;
	@XmlElement  (name = "isin")                        public String isin;
	@XmlElement  (name = "customInstitutionSecurityId") public String customInstitutionSecurityId;
	@XmlElement  (name = "customFundName")              public String customFundName;

	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
