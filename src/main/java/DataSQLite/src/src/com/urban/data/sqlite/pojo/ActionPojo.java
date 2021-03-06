package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Action;

import java.util.Date;

@DatabaseTable(tableName="Action")
public class ActionPojo implements Action {
	
	public ActionPojo() {

	}

	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(dataType = DataType.DATE_STRING, format = "yyyy-MM-dd")
	private Date startDate;
	
	@DatabaseField(dataType = DataType.DATE_STRING, format = "yyyy-MM-dd")
	private Date endDate;
	
	@DatabaseField
	private String subject;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel = 2, columnName = "organization")
	private OrganizationPojo organization;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setStartDate(Date value) {
		this.startDate = value;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setEndDate(Date value) {
		this.endDate = value;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setSubject(String value) {
		this.subject = value;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setOrganization(OrganizationPojo value) {
		this.organization = value;
	}
	
	public OrganizationPojo getOrganization() {
		return organization;
	}
	
}
