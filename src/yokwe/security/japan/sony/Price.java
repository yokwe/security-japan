package yokwe.security.japan.sony;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import yokwe.util.CSVUtil;

public class Price implements Comparable<Price> {
	public static final String PATH_DIR_DATA = "tmp/data/sony/price";
	public static String getPath(String stockCode) {
		return String.format("%s/%s.csv", PATH_DIR_DATA, stockCode);
	}

	public static void save(Collection<Price> collection) {
		save(new ArrayList<>(collection));
	}
	public static void save(List<Price> list) {
		if (list.isEmpty()) return;
		Price price = list.get(0);
		String isinCode = price.isinCode;
		String path = getPath(isinCode);
		
		// Sort before save
		Collections.sort(list);
		CSVUtil.write(Price.class).file(path, list);
	}

	public static List<Price> getList(String isinCode) {
		String path = getPath(isinCode);
		List<Price> ret = CSVUtil.read(Price.class).file(path);
		return ret == null ? new ArrayList<>() : ret;
	}

	
	public LocalDate  date;
	public String     isinCode;
	public Currency   currency;
	public BigDecimal price;
	public long       volume;
	
	public Price(LocalDate date, String isinCode, Currency currency, BigDecimal price, long volume) {
		this.date     = date;
		this.isinCode = isinCode;
		this.currency = currency;
		this.price    = price;
		this.volume   = volume;
	}
	public Price() {
		this(null, null, null, null, 0);
	}

	@Override
	public int compareTo(Price that) {
		int ret = this.date.compareTo(that.date);
		if (ret == 0) ret = this.isinCode.compareTo(that.isinCode);
		return ret;
	}
}
