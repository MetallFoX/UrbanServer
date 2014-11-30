package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.*;

import java.util.HashSet;
import java.util.Set;

@DatabaseTable(tableName="Organization")
public class OrganizationPojo implements Organization {
	
	public OrganizationPojo() {
	
	}

    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField(foreign = true, columnName = "logo", foreignAutoRefresh = true)
    private ImagePojo logo;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField
    private String description;
    
    @ForeignCollectionField(eager = true)
    private ForeignCollection<OrganizationContactLinkPojo> toContactLinks;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<OrganizationPlaceLinkPojo> toPlaces;
    
    @ForeignCollectionField(eager = true)
    private ForeignCollection<OrganizationEventLinkPojo> toEvents;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<ActionPojo> actions;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<NotificationSubscribePojo> toSubscribeLinks;

    private void setId(int value) {
        this.id = value;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setLogo(int value) {
        setLogo(new Integer(value));
    }

    @Override
    public ImagePojo getLogo() {
        return logo;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String toString() {
        return String.valueOf(getId());
    }

	@Override
	public Set<Contact> getContacts() {
		Set<Contact> contacts = new HashSet<Contact>();
		
		for (OrganizationContactLinkPojo link : toContactLinks){
			contacts.add(link.getContact());
		};
		return contacts;
	}

	@Override
	public Set<Place> getPlaces() {
		Set<Place> places = new HashSet<Place>();
		
		for (OrganizationPlaceLinkPojo link : toPlaces){
			places.add(link.getPlace());
		};
		return places;
	}
	
	
	@Override
	public Set<Event> getEvents() {
		Set<Event> events = new HashSet<Event>();
		
		for (OrganizationEventLinkPojo link : toEvents){
			events.add(link.getEvent());
		};
		return events;
	}

    @Override
    public Set<Category> getCategory() {
        return null;//return new HashSet<Category>(categories);
    }

    @Override
    public Set<Action> getActions() {
        return new HashSet<Action>(actions);
    }

    @Override
    public Set<Advertising> getAdvertising() {
        // TODO Auto-generated method stub
        return null;
    }

    public Set<Page> getPage() {
        return null;//return new HashSet<Page>(pages);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Organization) {
            return id.equals((((Organization) obj).getId()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


}
