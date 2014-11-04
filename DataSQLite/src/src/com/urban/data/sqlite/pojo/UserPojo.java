package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Person;
import com.urban.data.User;

import java.util.Set;

@DatabaseTable(tableName="User")
public class UserPojo implements User {
	
	public UserPojo() {
		
	}
	
	@DatabaseField(generatedId = true)	
	private int id;
	
	@DatabaseField	
	private String login;
	
	@DatabaseField	
	private String password;
	
	@DatabaseField	
	private java.util.Date regDate;
	
	@DatabaseField	
	private String regId;
	
	
	@DatabaseField	
	private Integer isBlocked;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "person")
	private Person person;
	
	@DatabaseField	
	private int IMEI;
	
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
	
	public java.util.Date getRegDate() {
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
		this.person = value;
	}
	
	public Person getPerson() {
		return person;
	}

	@Override
	public Set<User> getSubscribes() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
