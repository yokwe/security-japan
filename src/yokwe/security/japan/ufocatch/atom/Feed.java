package yokwe.security.japan.ufocatch.atom;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.LoggerFactory;

import yokwe.UnexpectedException;

@XmlRootElement(name = "feed")
public class Feed {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Feed.class);

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
	
	@XmlTransient
	public Map<Link.Relation, Link>   linkMap;

	void afterUnmarshal(Unmarshaller u, Object parent) {
		// Sanity check
		if (linkList == null) {
			logger.error("linkList is null %s", this);
			throw new UnexpectedException("linkList is null");
		}
		linkMap = linkList.stream().collect(Collectors.toMap(o -> ((Link)o).rel, o -> (Link)o));
	}

}