package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Advertising;
import com.urban.data.Category;
import com.urban.data.Position;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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
        		return pos2.getId() - pos1.getId();
        	};
        });
        if (toPositionsLinks == null) return null;
        for (CategoryPositionLinkPojo posLink: toPositionsLinks){
        	posSet.add(posLink.getPosition());
        }
    	return posSet;
    }
    
    public Set<Advertising> getAdvertisements() {
        SortedSet<Advertising> advertisements = new TreeSet<Advertising>(new Comparator<Advertising>(){
        	public int compare(Advertising pos1, Advertising pos2){
        		if (pos1 == pos2)
        			return 0;
        		if (pos1 == null)
        			return 1;
        		if (pos2 == null)
        			return -1;
                //Сортировка по убыванию приоритета.
                //TODO: Добавить unique constraint на пару category + priority или добавить ещё критерий сравнения?
        		return pos2.getPriority() - pos1.getPriority();
        	};
        });
        if (toAdvertLinks == null) return null;
        for (CategoryAdvertisingLinkPojo link: toAdvertLinks){
            advertisements.add(link.getAdvertising());
        }
    	return advertisements;
    }


    public String toString() {
        return String.valueOf(getId());
    }

}
