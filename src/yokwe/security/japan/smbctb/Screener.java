package yokwe.security.japan.smbctb;

import yokwe.util.StringUtil;
import yokwe.util.json.JSON.Name;

public final class Screener {
	public enum CurrencyId {
		AUD("CU$$$$$AUD"),
		EUR("CU$$$$$EUR"),
		JPY("CU$$$$$JPY"),
		USD("CU$$$$$USD");
		
		public final String value;
		
		CurrencyId(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
	
    public static final class Rows {
        public @Name("secId")                       String     secId;
        public @Name("isin")                        String     isin;
        public @Name("currencyId")                  CurrencyId currencyId;
        public @Name("customInstitutionSecurityId") String     customSecurityId;
        public @Name("customFundName")              String     customFundName;

        @Override
        public String toString() {
            return StringUtil.toString(this);
        }
    }

    public @Name("total")    int    total;
    public @Name("page")     int    page;
    public @Name("pageSize") int    pageSize;
    public @Name("rows")     Rows[] rows;

    @Override
    public String toString() {
        return StringUtil.toString(this);
    }
}

