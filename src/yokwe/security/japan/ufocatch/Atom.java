package yokwe.security.japan.ufocatch;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;
import yokwe.security.japan.ufocatch.atom.Link;
import yokwe.util.FileUtil;
import yokwe.util.HttpUtil;

public class Atom {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Atom.class);

	public static final String DIR_BASE = "tmp/ufocatch";
	
	public static String getPath(String name) {
		return String.format("%s/%s", DIR_BASE, name);
	}
	public static List<File> getExistingFileList() {
		File dir = new File(DIR_BASE);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		List<File> ret = new ArrayList<>();
		for(File file: dir.listFiles()) {
			String name = file.getName();
			if (name.endsWith("-ixbrl.htm")) {
				ret.add(file);
			}
		}
		Collections.sort(ret);
		return ret;
	}
	public static Map<String, File> getExistingFileMap() {
		File dir = new File(DIR_BASE);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		Map<String, File> ret = new TreeMap<>();
		for(File file: getExistingFileList()) {
			String name = file.getName();
			ret.put(name, file);
		}
		
		return ret;
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
		
		public final String url;
		Kind(String url) {
			this.url = url;
		}
	}

	// DividendPerShare
	public static String query(Kind kind, String query) {
		// GET /atom/{種別}/query/{クエリワード}
		try {
			String url = String.format("%s/%s/query/%s", URL_BASE, kind.url, URLEncoder.encode(query, "UTF-8"));
			HttpUtil.Result result = HttpUtil.getInstance().download(url);
			return result.result;
		} catch (UnsupportedEncodingException e) {
			String exceptionName = e.getClass().getSimpleName();
			logger.error("{} {}", exceptionName, e);
			throw new UnexpectedException(exceptionName, e);
		}
	}
	
	private static Link.Relation getLinkMapKey(Link link) {
		return link.rel;
	}
	public static Map<Link.Relation, Link> getLinkMap(List<Link> list) {
		return list.stream().collect(Collectors.toMap(Atom::getLinkMapKey, o -> (Link)o));
	}
}
