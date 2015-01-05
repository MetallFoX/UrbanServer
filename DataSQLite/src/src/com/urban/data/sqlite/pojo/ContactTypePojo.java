package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.ContactType;

@DatabaseTable(tableName="ContactType")
public class ContactTypePojo implements ContactType {
	
	public ContactTypePojo() {
	
	}
	
	@DatabaseField(generatedId = true)
	private Integer id;
	
	@DatabaseField
	private String name;
	
	private void setId(int value) {
		setId(new Integer(value));
	}
	
	private void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}

    @Override
    public Type getType() {
        return Type.getTypeById(getId());
    }

}
