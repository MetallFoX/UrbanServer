package com.urban.data.jdbc.pojo;

import com.urban.data.Position;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Position")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PositionPojo implements Serializable, Position {
	public PositionPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18B103272")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18B103272", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=false, length=255)	
	private String name;
	
	@ManyToOne(targetEntity=OrganizationPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="organization", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private OrganizationPojo organization;
	
	@ManyToMany(targetEntity=CategoryPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Category_Position", joinColumns={ @JoinColumn(name="position") }, inverseJoinColumns={ @JoinColumn(name="category") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set category = new java.util.HashSet();
	
	@ManyToMany(targetEntity=PagePojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Position_Page", joinColumns={ @JoinColumn(name="Position") }, inverseJoinColumns={ @JoinColumn(name="page") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set page = new java.util.HashSet();
	
	@OneToMany(mappedBy="position", targetEntity=ActionPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set action = new java.util.HashSet();
	
	@OneToMany(mappedBy="position", targetEntity=AdvertisingPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set advertising = new java.util.HashSet();
	
	
	/*
	@ManyToMany(mappedBy="position", targetEntity=UserPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set subscribers = new java.util.HashSet();
	*/
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCategory(java.util.Set value) {
		this.category = value;
	}
	
	public Set getCategory() {
		return category;
	}
	
	
	public void setOrganization(OrganizationPojo value) {
		this.organization = value;
	}
	
	public OrganizationPojo getOrganization() {
		return organization;
	}
	
	public void setPage(java.util.Set value) {
		this.page = value;
	}
	
	public Set getPage() {
		return page;
	}
	
	
	public void setAction(java.util.Set value) {
		this.action = value;
	}
	
	public Set getActions() {
		return action;
	}
	
	public void setAdvertising(java.util.Set value) {
		this.advertising = value;
	}
	
	public java.util.Set getAdvertising() {
		return advertising;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
