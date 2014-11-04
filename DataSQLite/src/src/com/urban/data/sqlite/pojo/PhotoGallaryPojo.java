package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.PhotoGallary;

@DatabaseTable(tableName="PhotoGallary")
public class PhotoGallaryPojo implements PhotoGallary {
	
	public PhotoGallaryPojo() {
	
	}
	
    @DatabaseField(generatedId = true)	
	private int id;
	
    @DatabaseField	
	private String name;
	
    @DatabaseField	
	private String description;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "gallery")
	private java.util.Set photo = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPhoto(java.util.Set value) {
		this.photo = value;
	}
	
	public java.util.Set getPhoto() {
		return photo;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
