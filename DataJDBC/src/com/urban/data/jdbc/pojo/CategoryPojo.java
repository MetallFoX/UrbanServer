package com.urban.data.jdbc.pojo;

import com.urban.data.Category;
import com.urban.data.Organization;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Category")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class CategoryPojo implements Serializable, Category {
	public CategoryPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18C103274")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18C103274", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="parent", nullable=true, length=10)	
	private CategoryPojo parent;
	
	@Column(name="`order`", nullable=false, length=10)	
	private int order;
	
	@ManyToMany(targetEntity=AdvertisingPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Category_Advertising", joinColumns={ @JoinColumn(name="categoryId") }, inverseJoinColumns={ @JoinColumn(name="advertisingId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set advertising = new java.util.HashSet();
	
	@ManyToMany(mappedBy="category", targetEntity=OrganizationPojo.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set organization = new java.util.HashSet();
	
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
	
	public void setParent(int value) {
		setParent(Integer.valueOf(value));
	}
	
	public void setParent(CategoryPojo value) {
		this.parent = value;
	}
	
	public CategoryPojo getParent() {
		return parent;
	}
	
	public void setOrder(int value) {
		this.order = value;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setAdvertisements(Set value) {
		this.advertising = value;
	}
	
	public Set getAdvertisements() {
		return advertising;
	}
	
	
	public void setOrganizations(Set value) {
		this.organization = value;
	}
	
	public Set<Organization> getOrganizations() {
		return organization;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
