package src.com.urban.data.sqlite.pojo;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.News;

@DatabaseTable(tableName="News")
public class NewsPojo implements News {
	
	public NewsPojo() {
	}
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField	
	private java.util.Date date;
	
	@DatabaseField	
	private String text;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "category")
	private NewsCategoryPojo category;
	
	@DatabaseField	
	private Integer photo;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDate(java.util.Date value) {
		this.date = value;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public void setText(String value) {
		this.text = value;
	}
	
	public String getText() {
		return text;
	}
	
	public void setPhoto(int value) {
		setPhoto(new Integer(value));
	}
	
	public void setPhoto(Integer value) {
		this.photo = value;
	}
	
	public Integer getPhoto() {
		return photo;
	}
	
	public void setCategory(NewsCategoryPojo value) {
		this.category = value;
	}
	
	public NewsCategoryPojo getCategory() {
		return category;
	}
	
}
