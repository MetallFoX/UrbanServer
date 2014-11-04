package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Stuff;
import com.urban.data.StuffCategory;

import java.util.HashSet;
import java.util.Set;

@DatabaseTable(tableName="StuffCategory")
public class StuffCategoryPojo implements StuffCategory {
	
	public StuffCategoryPojo() {
	
	}
	
	@DatabaseField(generatedId = true)	
	private int id;
	
	@DatabaseField	
	private String name;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "parent")	
	private StuffCategoryPojo parent;
	
	@DatabaseField	
	private String description;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "parent")	
	private Set<StuffCategory> stuffCategory = new HashSet<StuffCategory>();
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "category")	
	private Set<Stuff> stuff = new HashSet<Stuff>();
	
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
	
	public void setParent(StuffCategoryPojo value) {
		this.parent = value;
	}
	
	public StuffCategoryPojo getParent() {
		return parent;
	}
	
	public void setStuffCategory(Set<StuffCategory> value) {
		this.stuffCategory = value;
	}
	
	public Set<StuffCategory> getStuffCategory() {
		return stuffCategory;
	}
	
	
	public void setStuff(Set<Stuff> value) {
		this.stuff = value;
	}
	
	public Set<Stuff> getStuff() {
		return stuff;
	}
		
	public String toString() {
		return String.valueOf(getId());
	}
	
}
