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

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.smbctb.Screener.Rows;
import yokwe.util.CSVUtil;
import yokwe.util.http.HttpUtil;
import yokwe.util.json.JSON;

public class UpdateSMBCTBFund {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateSMBCTBFund.class);
	
	
	public static final String URL_SCREENER_BASE = "https://lt.morningstar.com/api/rest.svc/smbctbfund/security/screener";
	public static final String URL_SCREENER;
	static {
		try {
			URL_SCREENER = new URIBuilder(URL_SCREENER_BASE).
					addParameter("page",               "1").
					addParameter("pageSize",           "1000").
					addParameter("outputType",         "json").
					addParameter("languageId",         "ja-JP").
					addParameter("securityDataPoints", "secId|isin|customInstitutionSecurityId|customFundName|currencyId").
					build().toASCIIString();
		} catch (URISyntaxException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
	}

	public static final String FILE_PATH = "tmp/data/smbc/fund.csv";

	public static void main(String[] args) {
		logger.info("START");

		logger.info("url {}", URL_SCREENER);
		
		HttpUtil.Result result = HttpUtil.getInstance().download(URL_SCREENER);
		logger.info("result {} {} {} {}", result.code, result.reasonPhrase, result.version, result.rawData.length);

		Screener screener = JSON.unmarshal(Screener.class, result.result);

		logger.info("screener {}", screener);
		logger.info("rows     {}", screener.rows.length);

		List<Rows> list = new ArrayList<>();
		for (var e : screener.rows) {
			list.add(e);
		}
		logger.info("save {} {}", list.size(), FILE_PATH);
		CSVUtil.write(Rows.class).file(FILE_PATH, list);

		logger.info("STOP");
	}

}
