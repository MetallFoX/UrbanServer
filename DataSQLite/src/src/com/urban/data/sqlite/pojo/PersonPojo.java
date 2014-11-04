package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Person;

@DatabaseTable(tableName="Person")
public class PersonPojo implements Person {
	
	public PersonPojo() {
		
	}
	
	@DatabaseField(generatedId = true)	
	private int id;
	
	@DatabaseField	
	private String firstName;
	
	@DatabaseField	
	private String secondName;
	
	@DatabaseField	
	private String surname;
	
	@DatabaseField	
	private Integer photo;
	
	@DatabaseField	
	private Integer age;
	
	@DatabaseField	
	private String phone;
	
	@DatabaseField	
	private java.util.Date birthday;
	
	/*
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, columnName = "person")
	private UserPojo user;
	*/
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setFirstName(String value) {
		this.firstName = value;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setSecondName(String value) {
		this.secondName = value;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public void setSurname(String value) {
		this.surname = value;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setPhoto(int value) {
		setPhoto(new Integer(value));
	}
	
	public void setPhoto(Integer value) {
		this.photo = value;
	}
	
	public Integer getPhoto() {
		return photo;
	}
	
	public void setAge(int value) {
		setAge(new Integer(value));
	}
	
	public void setAge(Integer value) {
		this.age = value;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setBirthday(java.util.Date value) {
		this.birthday = value;
	}
	
	public java.util.Date getBirthday() {
		return birthday;
	}
	
	/*public void setUser(UserPojo value) {
		this.user = value;
	}
	
	public UserPojo getUser() {
		return user;
	}*/

}
