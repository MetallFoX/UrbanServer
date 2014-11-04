package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.UserProperties;

@DatabaseTable(tableName="UserProperties")
public class UserPropertiesPojo implements UserProperties {
	
	public UserPropertiesPojo() {
		
	}
	
	@DatabaseField(generatedId = true)	
	private int id;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
