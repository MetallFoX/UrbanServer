package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Stuff;

@DatabaseTable(tableName="Stuff")
public class StuffPojo implements Stuff {
	
	public StuffPojo() {
	
	}
	
	@DatabaseField(generatedId = true)	
	private int id;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "category")	
	private StuffCategoryPojo category;
	
	@DatabaseField	
	private int name;
	
	@DatabaseField	
	private String description;
	
	@DatabaseField	
	private java.math.BigDecimal cost;
	
	@DatabaseField	
	private Integer photo;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(int value) {
		this.name = value;
	}
	
	public int getName() {
		return name;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setCost(java.math.BigDecimal value) {
		this.cost = value;
	}
	
	public java.math.BigDecimal getCost() {
		return cost;
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
	
	public void setCategory(StuffCategoryPojo value) {
		this.category = value;
	}
	
	public StuffCategoryPojo getCategory() {
		return category;
	}
	
}
