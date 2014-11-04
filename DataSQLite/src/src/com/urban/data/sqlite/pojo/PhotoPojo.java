package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Photo;

import java.io.Serializable;

@DatabaseTable(tableName="Photo")
public class PhotoPojo implements Serializable, Photo {
	
	public PhotoPojo() {
		
	}
	
	@DatabaseField(generatedId = true)	
	private int id;
	
	@DatabaseField	
	private String description;
	
	@DatabaseField	
	private String url;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, columnName = "gallery")
	private PhotoGallaryPojo gallery;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setGallery(PhotoGallaryPojo value) {
		this.gallery = value;
	}
	
	public PhotoGallaryPojo getGallery() {
		return gallery;
	}
	
}
