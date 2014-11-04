package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Advertising;
import com.urban.data.Category;
import com.urban.data.Position;

import java.util.*;

@DatabaseTable(tableName="Category")
public class CategoryPojo implements Category {
	
	public CategoryPojo() {

	}

    @DatabaseField(generatedId = true)
    private int id;

	@DatabaseField(canBeNull = false)
    private String name;

	@DatabaseField(foreign = true, columnName = "parent")
    private CategoryPojo parent;

	@DatabaseField(canBeNull = false)
    private int order;
	
    @ForeignCollectionField(eager = true)
    private ForeignCollection<CategoryPositionLinkPojo> toPositionsLinks;
    
    @ForeignCollectionField(eager = true)
    private ForeignCollection<CategoryAdvertisingLinkPojo> toAdvertLinks;
    
	ForeignCollection<CategoryPositionLinkPojo> getPositionLinks() {
		return toPositionsLinks;
	}

    private java.util.Set<PositionPojo> position = new java.util.HashSet<PositionPojo>();

    @Override
    public int getId() {
        return id;
    }
   
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see com.urban.entity.za.Category#getParent()
     */
    @Override
    public CategoryPojo getParent() {
        return parent;
    }

    /* (non-Javadoc)
     * @see com.urban.entity.za.Category#getOrder()
     */
    @Override
    public int getOrder() {
        return order;
    }

    /* (non-Javadoc)
     * @see com.urban.entity.za.Category#setPosition(java.util.Set)
     */
    /*@Override
    public void addPosition(Position value) {
        position.add(value);
    }*/

    @Override
    public Set getPositions() {
        SortedSet<Position> posSet = new TreeSet<Position>(new Comparator<Position>(){
        	public int compare(Position pos1, Position pos2){
        		if (pos1 == pos2)
        			return 0;
        		if (pos1 == null)
        			return 1;
        		if (pos2 == null)
        			return -1;
        		return 0;//pos1.getId().compareTo(pos2.getId());
        	};
        });
        
        for (CategoryPositionLinkPojo posLink: toPositionsLinks){
        	posSet.add(posLink.getPosition());
        }
    	return posSet;
    }
    
    public Set<Advertising> getAdvertisings() {
        /*SortedSet<Advertising> posSet = new TreeSet<Advertising>(new Comparator<Advertising>(){
        	public int compare(Advertising pos1, Advertising pos2){
        		if (pos1 == pos2)
        			return 0;
        		if (pos1 == null)
        			return 1;
        		if (pos2 == null)
        			return -1;
        		return pos1.getId().compareTo(pos2.getId());
        	};
        });*/
    	//TODO: think about special order here. Do we need it?
    	Set<Advertising> elems = new HashSet<Advertising>();
        for (CategoryAdvertisingLinkPojo link: toAdvertLinks){
        	elems.add(link.getAdvertising());
        }
    	return elems;
    }


    public String toString() {
        return String.valueOf(getId());
    }

}
