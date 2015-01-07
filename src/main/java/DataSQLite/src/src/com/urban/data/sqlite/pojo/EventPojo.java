package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Event;
import com.urban.data.Organization;
import com.urban.data.Place;

import java.util.HashSet;
import java.util.Set;

@DatabaseTable(tableName="Event")
public class EventPojo implements Event {
	
	public EventPojo() {
	
	}
	
    @DatabaseField(generatedId = true)
    private Integer id;
    
    @DatabaseField(canBeNull = true)
    private String text;
    
    @DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, columnName = "image")
    private ImagePojo image;
    
    @ForeignCollectionField(eager = true)
    private ForeignCollection<EventPlaceLinkPojo> toPlaces;


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ImagePojo getImage() {
		return image;
	}

	public void setImage(ImagePojo image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	@Override
	public Set getPlace() {
		Set<Place> places = new HashSet<Place>();
		
		for (EventPlaceLinkPojo link : toPlaces) {
			places.add(link.getPlace());
		}
		return places;
	}

	@Override
	public Set<Organization> getOrganizations() {
		// TODO Auto-generated method stub
		return null;
	}

}
