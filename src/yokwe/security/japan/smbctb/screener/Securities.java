package yokwe.security.japan.smbctb.screener;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import yokwe.util.StringUtil;

public class Securities {
	@XmlElement(name = "TotalNumberOfSecurities") public int            totalNumberOfSecurities;
	@XmlElement(name = "NumberOfSecurities")      public int            numberOfSecurities;
	@XmlElement(name = "Security")                public List<Security> securityList;
	
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
//<customFundName>
//ブラックロック・グローバル・インベストメント　ブラックロック・グローバル・アロケーション・ポートフォリオ　豪ドル建て
//</customFundName>
//</Security>
