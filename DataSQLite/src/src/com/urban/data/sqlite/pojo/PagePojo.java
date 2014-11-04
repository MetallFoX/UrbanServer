package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Page;

@DatabaseTable(tableName="Page")
public class PagePojo implements Page {
	
	public PagePojo() {
	
	}

	@DatabaseField(generatedId = true)	
	private int id;
	
	@DatabaseField	
	private Integer type;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "page")
	private java.util.Set position = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setType(int value) {
		setType(new Integer(value));
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setPosition(java.util.Set value) {
		this.position = value;
	}
	
	public java.util.Set getPosition() {
		return position;
	}
	
}
