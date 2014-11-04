package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.InfoPage;

@DatabaseTable(tableName="InfoPage")
public class InfoPagePojo implements InfoPage {
	
	public InfoPagePojo() {
	
	}
	
	@DatabaseField(generatedId = true)
	private Integer id;
	
	private void setId(int value) {
		setId(new Integer(value));
	}
	
	private void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return id;
	}
	
}
