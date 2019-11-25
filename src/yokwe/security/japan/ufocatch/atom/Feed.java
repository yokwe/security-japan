package yokwe.security.japan.ufocatch.atom;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "feed")
public class Feed {
	public String title;
	
	@XmlElement(name = "link")
	public List<Link>   linkList;
	
	public String updated;
	public String id;
	
	@XmlElement(name = "entry")
	public List<Entry> entryList;
	
	@Override
	public String toString() {
		return String.format("{feed %s %s %s %s %s}", title, linkList, updated, id, entryList);
	}
}