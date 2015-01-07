package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="Organization_Page")
public class OrganizationPageLinkPojo {
	
	@DatabaseField(canBeNull = false, foreign = true, columnName = "organization")
    private OrganizationPojo organization;
	
	@DatabaseField(canBeNull = false, foreign = true, columnName = "page", foreignAutoRefresh = true)
    private PagePojo page;

	public OrganizationPojo getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationPojo organization) {
		this.organization = organization;
	}

	public PagePojo getPage() {
		return page;
	}

	public void setPage(PagePojo page) {
		this.page = page;
	}
}
