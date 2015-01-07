package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.ActionPage;

@DatabaseTable(tableName="ActionPage")
public class ActionPagePojo implements ActionPage {
	
	public ActionPagePojo() {
		
	}
	
	@DatabaseField(generatedId = true)	
	private Integer id;
	
	private void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return id;
	}
	
}
