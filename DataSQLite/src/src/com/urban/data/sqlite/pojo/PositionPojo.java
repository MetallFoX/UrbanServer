package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.*;

import java.util.HashSet;
import java.util.Set;

@DatabaseTable(tableName="Position")
public class PositionPojo implements Position {
	
	public PositionPojo() {
	
	}

    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField
    private String name;

    @DatabaseField(foreign = true, columnName = "organization", foreignAutoRefresh = true)
    private OrganizationPojo organization;

    /*@ForeignCollectionField(eager = true)
    private ForeignCollection<CategoryPositionLinkPojo> toCategoriesLinks;
    
    @ForeignCollectionField(eager = true)
    private ForeignCollection<PositionPageLinkPojo> toPagesLinks;*/

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

    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addCategory(Category value) {
        //this.categories.add(value);
    }

    public void setOrganization(Organization value) {
    	//FIXME: move this cast
        this.organization = (OrganizationPojo)value;
    }

    @Override
    public Organization getOrganization() {
        return organization;
    }

    public void setPage(java.util.Set value) {
        //this.page = value;
    }

    public Set<Page> getPage() {
        return null;//return new HashSet<Page>(pages);
    }


    public String toString() {
        return String.valueOf(getId());
    }

	@Override
	public Set<Category> getCategory() {
		return null;//return new HashSet<Category>(categories);
	}

	@Override
	public Set<Action> getAction() {
		return new HashSet<Action>(actions);
	}

	@Override
	public Set<Advertising> getAdvertising() {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            return id.equals((((Position) obj).getId()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
