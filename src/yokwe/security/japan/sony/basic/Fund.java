package yokwe.security.japan.sony.basic;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import yokwe.util.StringUtil;

public class Fund {
//	  <Fund
//	  	MS_FUND_CODE="2013121001"
//	  	FUND_NAME="ニッセイ 外国株式インデックスファンド"
//	  	FUND_NAME_OFFICIAL="＜購入･換金手数料なし＞ニッセイ 外国株式インデックスファンド"
//	  	FUND_NICKNAME=""
//	  	FUND_NAME_KANA=""
//	  	FUND_NAME_OFFICIAL_KANA="コウニュウカンキンテスウリョウナシニッセイガイコクカブシキインデックスファンド"
//	  	COMPANY_NAME="ニッセイアセットマネジメント"
//	  	ISIN="JP90C0009VE0">

	@XmlAttribute(name="MS_FUND_CODE")            public String mdFundCode;
	@XmlAttribute(name="FUND_NAME")               public String fundName;
	@XmlAttribute(name="FUND_NAME_OFFICIAL")      public String fundNameOfficial;
	@XmlAttribute(name="FUND_NICKNAME")           public String fundNickname;
	@XmlAttribute(name="FUND_NAME_KANA")          public String fundNameKana;
	@XmlAttribute(name="FUND_NAME_OFFICIAL_KANA") public String fundNameOfficialKana;
	@XmlAttribute(name="COMPANY_NAME")            public String companyName;
	@XmlAttribute(name="ISIN")                    public String isin;
	
	@XmlElement(name = "Price") public Price price;
	@XmlElement(name = "Base")  public Base  base;
	
	@Override
	public String toString() {
		return StringUtil.toString(this);
	}
}
