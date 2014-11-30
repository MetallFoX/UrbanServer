package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Address;
import com.urban.data.Event;
import com.urban.data.Organization;
import com.urban.data.Place;

import java.util.HashSet;
import java.util.Set;

@DatabaseTable(tableName="Place")
public class PlacePojo implements Place {
	
	public PlacePojo() {
	
	}
	
    @DatabaseField(generatedId = true)
    private Integer id;
    
    @DatabaseField(canBeNull = false)
    private double lat;
    
    @DatabaseField(canBeNull = false)
    private double alt;
    
    @DatabaseField(canBeNull = true)
    private String description;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<PlaceAddressLinkPojo> toAddressLinks;

	@Override
	public int getId() {
		return id;
	}
    
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getAlt() {
		return alt;
	}

	@Override
	public double getLat() {
		return lat;
	}
	
	@Override
	public Set<Address> getAddress() {
		Set<Address> places = new HashSet<Address>();
		
		for (PlaceAddressLinkPojo link : toAddressLinks){
			places.add(link.getAddress());
		};
		return places;
	}

	@Override
	public Set<Event> getEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Organization> getOrganizations() {
		// TODO Auto-generated method stub
		return null;
	}

}
