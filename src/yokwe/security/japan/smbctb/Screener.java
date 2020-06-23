package yokwe.security.japan.smbctb;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import yokwe.util.StringUtil;

public class Screener {
	public static final String URL = "https://lt.morningstar.com/api/rest.svc/smbctbfund/security/screener?page=1&pageSize=1000&outputType=xml&languageId=ja-JP&securityDataPoints=isin%7CcustomInstitutionSecurityId%7CcustomFundName";
	
	public static class Security {
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

	public static class Securities {
		@XmlElement(name = "TotalNumberOfSecurities") public int            totalNumberOfSecurities;
		@XmlElement(name = "NumberOfSecurities")      public int            numberOfSecurities;
		@XmlElement(name = "Security")                public List<Security> securityList;
		
		@Override
		public String toString() {
			return StringUtil.toString(this);
		}
	}

	@XmlElement(name = "Securities") public Securities securites;
	
	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}

//<Screener>
//<Securities pageNumber="1" pageSize="1000">
//<TotalNumberOfSecurities>167</TotalNumberOfSecurities>
//<NumberOfSecurities>167</NumberOfSecurities>
//<Security id="F00000JQ91">
//<SecId>F00000JQ91</SecId>
//<isin>LU0525289848</isin>
//</Security>
