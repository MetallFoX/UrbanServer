package com.urban.data.jdbc.pojo;

import com.urban.data.Category;
import com.urban.data.Position;

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
	private java.util.Set advertising = new java.util.HashSet();
	
	@ManyToMany(mappedBy="category", targetEntity=PositionPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set position = new java.util.HashSet();
	
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
	
	public void setAdvertisements(java.util.Set value) {
		this.advertising = value;
	}
	
	public java.util.Set getAdvertisements() {
		return advertising;
	}
	
	
	public void setPositions(java.util.Set value) {
		this.position = value;
	}
	
	public Set<Position> getPositions() {
		return position;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
