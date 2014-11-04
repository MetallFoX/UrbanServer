package com.urban.data.jdbc.pojo;

import com.urban.data.Person;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PersonPojo implements Serializable, Person {
	public PersonPojo() {
	}
	
	
	@Id	
	@GeneratedValue	
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="first_name", nullable=false, length=255)	
	private String firstName;
	
	@Column(name="second_name", nullable=true, length=255)	
	private String secondName;
	
	@Column(name="surname", nullable=true, length=255)	
	private String surname;
	
	@Column(name="photo", nullable=true, length=10)	
	private Integer photo;
	
	@Column(name="age", nullable=true, length=10)	
	private Integer age;
	
	@Column(name="phone", nullable=true, length=255)	
	private String phone;
	
	@Column(name="birthday", nullable=true)	
	private java.util.Date birthday;
	
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
