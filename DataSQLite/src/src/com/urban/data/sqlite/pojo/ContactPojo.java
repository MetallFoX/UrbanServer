package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Contact;
import com.urban.data.Organization;

import java.util.Set;

@DatabaseTable(tableName="Contact")
public class ContactPojo implements Contact {
	
	public ContactPojo() {
	
	}

    @DatabaseField(generatedId = true)
    private Integer id;
    
    @DatabaseField(canBeNull = false)
    private String contact;
    
    @DatabaseField(canBeNull = false, columnName="ContactType")
    private Long type;

	@Override
	public Integer getId() {
		return id;
	}
	
    @Override
	public String getContact() {
		return contact;
	}

	@Override
	public Set<Organization> getOrganization() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactTypePojo getContactType() {
		return null;//ContactTypePojo.getTypeById(type);
	}

}
