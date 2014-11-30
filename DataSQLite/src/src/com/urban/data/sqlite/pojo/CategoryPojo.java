package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Advertising;
import com.urban.data.Category;
import com.urban.data.Organization;

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
    private ForeignCollection<CategoryOrganizationLinkPojo> toOrganizationsLinks;
    
    @ForeignCollectionField(eager = true)
    private ForeignCollection<CategoryAdvertisingLinkPojo> toAdvertLinks;
    
	ForeignCollection<CategoryOrganizationLinkPojo> getOrganizationLinks() {
		return toOrganizationsLinks;
	}

    private Set<OrganizationPojo> organization = new java.util.HashSet<OrganizationPojo>();

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
     * @see com.urban.entity.za.Category#setOrganization(Set)
     */
    /*@Override
    public void addOrganization(Organization value) {
        organization.add(value);
    }*/

    @Override
    public Set getOrganizations() {
        SortedSet<Organization> posSet = new TreeSet<Organization>(new Comparator<Organization>(){
        	public int compare(Organization org1, Organization org2){
        		if (org1 == org2)
        			return 0;
        		if (org1 == null)
        			return 1;
        		if (org2 == null)
        			return -1;
        		return org2.getId() - org1.getId();
        	};
        });
        if (toOrganizationsLinks == null) return null;
        for (CategoryOrganizationLinkPojo orgLinks: toOrganizationsLinks){
        	posSet.add(orgLinks.getOrganization());
        }
    	return posSet;
    }
    
    public Set<Advertising> getAdvertisements() {
        SortedSet<Advertising> advertisements = new TreeSet<Advertising>(new Comparator<Advertising>(){
        	public int compare(Advertising org1, Advertising org2){
        		if (org1 == org2)
        			return 0;
        		if (org1 == null)
        			return 1;
        		if (org2 == null)
        			return -1;
                //Сортировка по убыванию приоритета.
                //TODO: Добавить unique constraint на пару category + priority или добавить ещё критерий сравнения?
        		return org2.getPriority() - org1.getPriority();
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
