package com.urban.data.jdbc.pojo;

import com.urban.data.Person;
import com.urban.data.User;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="`User`")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class UserPojo implements Serializable, User {
	
	public UserPojo() {
		
	}
	
	@Id	
	@GeneratedValue	
	@Column(name="id", nullable=false)	
	private int id;
	
	@Column(name="login", nullable=false, unique=true, length=255)	
	private String login;
	
	@Column(name="password", nullable=false, length=255)	
	private String password;
	
	@Column(name="regDate", nullable=false)	
	private java.util.Date regDate;
	
	@Column(name="regId", nullable=true)	
	private String regId;
	
	@Column(name="isBlocked", nullable=true, length=10)	
	private Integer isBlocked;
	
	@OneToOne(targetEntity=PersonPojo.class, cascade = CascadeType.ALL)	
	@JoinColumns({ @JoinColumn(name="person") })	
	private Person person;
	
	@Column(name="IMEI", nullable=false, length=20)	
	private int IMEI;
	
	@ManyToMany(targetEntity=PositionPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Notification_Subscribe", joinColumns={ @JoinColumn(name="user") }, inverseJoinColumns={ @JoinColumn(name="position") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set subscribes = new java.util.HashSet();
	
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
	public void setSubscribes(java.util.Set value) {
		this.subscribes = value;
	}
	
	public java.util.Set getSubscribes() {
		return subscribes;
	}

	
}
