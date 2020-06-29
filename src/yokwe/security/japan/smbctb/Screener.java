/*******************************************************************************
 * Copyright (c) 2020, Yasuhiro Hasegawa
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice,
 *      this list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *   3. The name of the author may not be used to endorse or promote products derived
 *      from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 *******************************************************************************/
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

