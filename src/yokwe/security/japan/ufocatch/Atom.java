package yokwe.security.japan.ufocatch;

import java.io.File;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.JAXB;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.jpx.Category;
import yokwe.security.japan.jpx.FinancialSummary;
import yokwe.security.japan.ufocatch.atom.Feed;
import yokwe.util.FileUtil;
import yokwe.util.HttpUtil;

public class Atom {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Atom.class);

	public static final String DIR_BASE = "tmp/ufocatch";
	
	public static String getPath(String filename) {
		FinancialSummary financialSumary = FinancialSummary.getInstance(filename);
		if (financialSumary == null) {
			logger.error("Unexpected filename {}", filename);
			throw new UnexpectedException("Unexpected filename");
		}
		return String.format("%s/%s/%s", DIR_BASE, financialSumary.tdnetCode, filename);
	}
	
	private static List<File> fileList = null;
	public static List<File> getFileList() {
		if (fileList == null) {
			fileList = new ArrayList<>(getFileMap().values());
		}
		
		return fileList;
	}
	public static List<File> getFileList(Category category) {
		List<File> ret = new ArrayList<>();
		for(Map.Entry<FinancialSummary, File> entry: getFileMap().entrySet()) {
			FinancialSummary financialSummary = entry.getKey();
			File             file             = entry.getValue();
			if (financialSummary.category == category) {
				ret.add(file);
			}
		}
		return ret;
	}

	private static Map<FinancialSummary, File> fileMap = null;
	public static Map<FinancialSummary, File> getFileMap() {
		if (fileMap == null) {
			fileMap = new TreeMap<>();
			File dir = new File(DIR_BASE);
			for(File file: FileUtil.listFile(dir)) {
				FinancialSummary key = FinancialSummary.getInstance(file.getName());
				if (key == null) continue;
				
				if (fileMap.containsKey(key)) {
					logger.error("Duplicate key {}", key);
					logger.error("  new {}", file.getName());
					logger.error("  old {}", fileMap.get(key).getName());
					throw new UnexpectedException("Duplicate key");
				} else {
					fileMap.put(key, file);
				}
			}
		}
		
		return fileMap;
	}
	private static String getFilename(String href) {
		try {
			URL url = new URL(href);
			Path path = Paths.get(url.getPath());
			return path.getFileName().toString();
		} catch (MalformedURLException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
	}
	public static boolean downloadExists(String href) {
		String filename = getFilename(href);
		String path     = getPath(filename);
		File   file     = new File(path);
		return file.exists();
	}
	public static String download(String href) {
		String filename = getFilename(href);
		String path     = getPath(filename);
		File   file     = new File(path);
		if (file.exists()) {
			return FileUtil.read().file(file);
		} else {
			HttpUtil.Result result = HttpUtil.getInstance().download(href);
			if (result.result != null) {
				FileUtil.write().file(file, result.result);
			}
			return result.result;
		}
	}
	
	public static final String URL_BASE   = "https://resource.ufocatch.com/atom";
	
	public static enum Kind {
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
			logger.error("Unextected string {}!", string);
			throw new UnexpectedException("Unextected string");
		}
		public final String url;
		Kind(String url) {
			this.url = url;
		}
	}

	public static String query(Kind kind) {
		// GET /atom/{種別}
		String url = String.format("%s/%s", URL_BASE, kind.url);
		HttpUtil.Result result = HttpUtil.getInstance().download(url);
		return result.result;
	}
	public static Feed getFeed(Kind kind) {
		// GET /atom/{種別}
		String url = String.format("%s/%s", URL_BASE, kind.url);
		return getFeed(url);
	}
	public static Feed getFeed(String url) {
		HttpUtil.Result result = HttpUtil.getInstance().download(url);
		Feed ret = JAXB.unmarshal(new StringReader(result.result), Feed.class);
		return ret;
	}
}
