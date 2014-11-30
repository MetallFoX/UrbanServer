package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.PhotoGallery;

import java.util.Set;

@DatabaseTable(tableName="PhotoGallery")
public class PhotoGalleryPojo implements PhotoGallery {
	
	public PhotoGalleryPojo() {
	
	}
	
    @DatabaseField(generatedId = true)	
	private int id;
	
    @DatabaseField	
	private String name;
	
    @DatabaseField	
	private String description;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "gallery")
	private Set photo = new java.util.HashSet();
	
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
	
	public void setPhoto(Set value) {
		this.photo = value;
	}
	
	public Set getPhoto() {
		return photo;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
