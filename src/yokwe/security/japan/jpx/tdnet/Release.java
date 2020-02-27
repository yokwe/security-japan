package yokwe.security.japan.jpx.tdnet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.util.HttpUtil;
import yokwe.util.StringUtil;

public class Release {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(Release.class);

	public static final String URL_MAIN = "https://www.release.tdnet.info/inbs/I_main_00.html";
	
	private static final HttpUtil httpUtil = HttpUtil.getInstance();

	public static class Entry {
		public String time;
		public String code;   // FIXME not stockCode
		public String name;
		public String pdf;
		public String title;
		public String xbrl;
		public String place;
		public String history;
		
		public Entry(String time, String code, String name, String pdf, String title, String xbrl, String place, String history) {
			this.time    = time;
			this.code    = code;
			this.name    = name;
			this.pdf     = pdf;
			this.title   = title;
			this.xbrl    = xbrl;
			this.place   = place;
			this.history = history;
		}
		@Override
		public String toString() {
			return String.format("{%s %s %s %s %s %s %s %s}", time, code, name, pdf, title, xbrl, place, history);
		}
	}
	
	public static String[] getGroup(Pattern pat, String string) {
		Matcher m = pat.matcher(string);
		if (m.find()) {
			int count = m.groupCount();
			String[] ret = new String[count];
			for(int i = 0; i < count; i++) {
				ret[i] = m.group(i + 1);
			}
			return ret;
		} else {
			return null;
		}
	}
	public static String getGroupOne(Pattern pat, String string) {
		String[] result = getGroup(pat, string);
		if (result == null) {
			return null;
		} else {
			if (result.length == 1) {
				return result[0];
			} else {
				logger.error("result.length != 1");
				logger.error("  result {}", Arrays.asList(result));
				throw new UnexpectedException("result.length != 1");
			}
		}
	}
	
	public static class Page {
		public static final String URL_BASE = "https://www.release.tdnet.info/inbs";
		public static String getURL(LocalDate date, int page) {
			String dateString = String.format("%4d%02d%02d", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
			return String.format("%s/I_list_%03d_%s.html", URL_BASE, page, dateString);
		}
		public static byte[] downloadDataFile(String filename) {
			String url = String.format("%s/%s", URL_BASE, filename);
			HttpUtil.Result result = HttpUtil.getInstance().withRawData(true).download(url);
			return result.rawData;
		}
		
		// <div id="kaiji-date-1">2020年01月27日</div>
		private static final Pattern KAIJI_DATE_PAT = Pattern.compile("<div id=\"kaiji-date-1\">(.+?)</div>");

		// 2020年02月27日
		private static final Pattern DATE_PAT = Pattern.compile("(20[0-9][0-9])年([01][0-9])月([0-3][0-9])日");
		private static StringUtil.MatcherFunction<LocalDate> DATE_OP = (m -> LocalDate.parse(String.format("%s-%s-%s", m.group(1), m.group(2), m.group(3))));
		
		// <div id="kaiji-text-1">に開示された情報はありません。</div>
		private static final Pattern KAIJI_TEXT_PAT = Pattern.compile("<div id=\"kaiji-text-1\">(.+?)</div>");
		private static final String KAIJI_TEXT_NO_DATA = "に開示された情報はありません。";
		
		// <div class="pager-R" onClick="pager('I_list_002_20200127.html')"><span>次へ</span><img src="./gif/icn_next.png" alt="次へ"></img></div>
		// <div class="pager-R" onClick="pager('')"><span>次へ</span><img src="./gif/icn_next.png" alt="次へ"></img></div>
		private static final Pattern NEXT_PAT = Pattern.compile("<div class=\"pager-R\" onClick=\"pager\\('(.*?)'\\)\">");
		
		private static final Pattern ENTRY_PAT = Pattern.compile(
				"<tr.*?>\\s+" +
				"<td class=\"(?:even|odd)new-L kjTime\".+?>(.+?)</td>\\s+" +
				"<td class=\"(?:even|odd)new-M kjCode\".+?>(.+?)</td>\\s+" +
				"<td class=\"(?:even|odd)new-M kjName\".+?>(.+?)\\s*</td>\\s+" +
				"<td class=\"(?:even|odd)new-M kjTitle\".+?><a href=\"(.+?)\" .+?>(.+?)</a>(?:<BR>.+?)?</td>\\s+" +
				"<td class=\"(?:even|odd)new-M kjXbrl\".+?>(?:<div class=\"xbrl-mask\">.+href=\"(.+?)\".+?)? </td>\\s+" +
				"<td class=\"(?:even|odd)new-M kjPlace\".+?>(.+?)\\s*</td>\\s+" +
				"<td class=\"(?:even|odd)new-R kjHistroy\".+?>(.*?)(?:[　]+?)?</td>\\s+" +
				"</tr>"
				);
		private static StringUtil.MatcherFunction<Entry> ENTRY_OP = (m -> new Entry(m.group(1), m.group(2), m.group(3), m.group(4), m.group(5), m.group(6), m.group(7), m.group(8)));

		public LocalDate   date;
		public List<Entry> entryList;
		
		private Page(LocalDate date) {
			this.date      = date;
			this.entryList = new ArrayList<>();
		}
		@Override
		public String toString() {
			return String.format("{%s %3d}", date, entryList.size());
		}
		
		public static Page getInstance(LocalDate date) {
			Page ret = new Page(date);
			
			for(int page = 1;; page++) {
				String url = getURL(date, page);
				logger.info("url {}", url);
				HttpUtil.Result result = httpUtil.download(url);
				String string = result.result;
				if (string == null) break;
				
				{
					String kaijiDate = getGroupOne(KAIJI_DATE_PAT, string);
//					logger.info("kaijiDate {}", kaijiDate);
					
					List<LocalDate> list = StringUtil.find(kaijiDate, DATE_PAT, DATE_OP).collect(Collectors.toList());
					if (!date.equals(list.get(0))) {
						logger.error("date mismatch");
						logger.error("  date {}", date);
						logger.error("  list {}", list.get(0));
						throw new UnexpectedException("date mismatch");
					}
				}
				
				{
					String kaijiText = getGroupOne(KAIJI_TEXT_PAT, string);
//					logger.info("kaijiText {}", kaijiText);
					if (kaijiText.equals(KAIJI_TEXT_NO_DATA)) break;
				}
				
				{
					List<Entry> list = StringUtil.find(string, ENTRY_PAT, ENTRY_OP).collect(Collectors.toList());
					logger.info("list {}", list.size());
					ret.entryList.addAll(list);
				}
				
				{
					String next = getGroupOne(NEXT_PAT, string);
					if (next.isEmpty()) break;
				}
			}
			return ret;
		}
	}
	
	public static void main(String[] args) {
		logger.info("START");
		
		{
			Page page = Page.getInstance(LocalDate.parse("2020-02-25"));
			logger.info("page {}", page);
			for(Entry e: page.entryList) {
				logger.info("  {} {} {} {}  {}", e.time, e.code, e.pdf, e.xbrl, e.title);
			}
		}
		
		logger.info("STOP");
	}
}
