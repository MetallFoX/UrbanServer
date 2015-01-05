package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Organization;
import com.urban.data.Person;
import com.urban.data.User;

import java.util.*;

@DatabaseTable(tableName="User")
public class UserPojo implements User {
	
	public UserPojo() {
		
	}
	
	@DatabaseField(generatedId = true, allowGeneratedIdInsert = true)
	private int id;
	
	@DatabaseField	
	private String login;
	
	@DatabaseField	
	private String password;

	@DatabaseField(dataType = DataType.DATE_STRING, format = "yyyy-MM-dd")
	private Date regDate;
	
	@DatabaseField	
	private String regId;
	
	
	@DatabaseField	
	private Integer isBlocked;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "person")
	private PersonPojo person;
	
	@DatabaseField	
	private int IMEI;

    @ForeignCollectionField(eager = true, maxEagerForeignCollectionLevel = 2)
    private ForeignCollection<NotificationSubscribePojo> toSubscribeLinks;

    ForeignCollection<NotificationSubscribePojo> getSubscribeLinks() {
        return toSubscribeLinks;
    }
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setLogin(String value) {
		this.login = value;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setRegDate(java.util.Date value) {
		this.regDate = value;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegId(String value) {
		this.regId = value;
	}
	
	public String getRegId() {
		return regId;
	}
	
	public void setIsBlocked(int value) {
		setIsBlocked(new Integer(value));
	}
	
	public void setIsBlocked(Integer value) {
		this.isBlocked = value;
	}
	
	public Integer getIsBlocked() {
		return isBlocked;
	}
	
	public void setIMEI(int value) {
		this.IMEI = value;
	}
	
	public int getIMEI() {
		return IMEI;
	}
	
	public void setPerson(Person value) {
		this.person = (PersonPojo)value;
	}
	
	public Person getPerson() {
		return person;
	}

	@Override
	public Set<Organization> getSubscribes() {
        SortedSet<Organization> orgSet = new TreeSet<Organization>(new Comparator<Organization>(){
            public int compare(Organization org1, Organization org2){
                if (org1 == org2)
                    return 0;
                if (org1 == null)
                    return 1;
                if (org2 == null)
                    return -1;
                return org2.getId() - org1.getId();
            };
        });

        for (NotificationSubscribePojo subscribeLink : toSubscribeLinks){
            orgSet.add(subscribeLink.getOrganization());
        }
        return orgSet;
	}

    @Override
    public void setSubscribes(Set<Organization> organizations) {
        toSubscribeLinks.clear();
        for (Organization org : organizations) {
            NotificationSubscribePojo subscribe = new NotificationSubscribePojo();
            subscribe.setUser(this);
            subscribe.setOrganization((OrganizationPojo) org);
            toSubscribeLinks.add(subscribe);
        }
    }

}
