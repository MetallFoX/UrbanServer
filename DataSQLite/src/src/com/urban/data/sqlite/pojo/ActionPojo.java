package src.com.urban.data.sqlite.pojo;

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
	
	@DatabaseField
	private Date startDate;
	
	@DatabaseField
	private Date endDate;
	
	@DatabaseField
	private String subject;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel = 2, columnName = "position")	
	private PositionPojo position;
	
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
	
	public void setPosition(PositionPojo value) {
		this.position = value;
	}
	
	public PositionPojo getPosition() {
		return position;
	}
	
}
