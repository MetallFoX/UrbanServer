package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.ContactType;

import java.util.HashSet;
import java.util.Set;

@DatabaseTable(tableName="ContactType")
public class ContactTypePojo implements ContactType {
	
	public ContactTypePojo() {
	
	}
	
	@DatabaseField(generatedId = true)
	private Integer id;
	
	@DatabaseField
	private String name;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, columnName = "contactType")
	private Set contact = new HashSet();
	
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
	
	public void setContact(Set value) {
		this.contact = value;
	}
	
	public Set getContact() {
		return contact;
	}
		
}
