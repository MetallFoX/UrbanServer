package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.ApplicationProperties;

@DatabaseTable(tableName="ApplicationProperties")
public class ApplicationPropertiesPojo implements ApplicationProperties {
	
	public ApplicationPropertiesPojo() {

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
