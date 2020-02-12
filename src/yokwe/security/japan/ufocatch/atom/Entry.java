package yokwe.security.japan.ufocatch.atom;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Entry {
	public String title;
	public String id;
	public String updated;
	
	@XmlElement(name = "link")
	public List<Link> linkList;
	
	@Override
	public String toString() {
		return String.format("{entry %s %s %s %s}", title, id, updated, linkList);
	}
}