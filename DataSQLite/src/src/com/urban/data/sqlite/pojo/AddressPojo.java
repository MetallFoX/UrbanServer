package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Address;
import com.urban.data.Place;

@DatabaseTable(tableName="Address")
public class AddressPojo implements Address {
	
	public AddressPojo() {
	
	}
	
    @DatabaseField(generatedId = true)
    private Integer id;
    
    @DatabaseField(canBeNull = false)
    private String street;
    
    @DatabaseField(canBeNull = false)
    private Integer house;

    @DatabaseField(canBeNull = true)
    private String letter;
    
    @DatabaseField(canBeNull = true)
    private Integer floor;
    
    @DatabaseField(canBeNull = true)
    private Integer flat;

    @DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel = 2, columnName = "place")
    private PlacePojo place;

	@Override
	public int getId() {
		return id;
	}
    
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouse() {
		return house;
	}

	public void setHouse(Integer house) {
		this.house = house;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getFlat() {
		return flat;
	}

	public void setOffice(Integer flat) {
		this.flat = flat;
	}

	@Override
	public Place getPlace() {
		return place;
	}
}
