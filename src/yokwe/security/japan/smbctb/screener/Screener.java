package yokwe.security.japan.smbctb.screener;

import javax.xml.bind.annotation.XmlElement;

import yokwe.util.StringUtil;

public class Screener {
	public static final String URL = "https://lt.morningstar.com/api/rest.svc/smbctbfund/security/screener?page=1&pageSize=1000&outputType=xml&languageId=ja-JP&securityDataPoints=isin%7CcustomInstitutionSecurityId%7CcustomFundName";
	
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
