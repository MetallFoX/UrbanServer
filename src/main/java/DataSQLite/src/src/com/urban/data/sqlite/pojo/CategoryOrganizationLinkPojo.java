package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * ������ ��� ��������� � �������
 * @author victor
 *
 */
@DatabaseTable(tableName="Category_Organization")
public class CategoryOrganizationLinkPojo {
	
	public CategoryOrganizationLinkPojo() {
	
	}

    /**
     * This id is generated by the database and set on the object when it is passed to the create method. An id is
     * needed in case we need to update or delete this object in the future.
     */
    @DatabaseField(generatedId = true)
    int id;
	
	@DatabaseField(canBeNull = false, foreign = true, columnName = "organization", foreignAutoRefresh = true,  maxForeignAutoRefreshLevel = 1 )
    private OrganizationPojo organization;
	
	@DatabaseField(canBeNull = false, foreign = true, columnName = "category")
    private CategoryPojo category;
	
	public CategoryPojo getCategory() {
		return category;
	}

	public void setCategory(CategoryPojo category) {
		this.category = category;
	}

	public OrganizationPojo getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationPojo organization) {
		this.organization = organization;
	}
}