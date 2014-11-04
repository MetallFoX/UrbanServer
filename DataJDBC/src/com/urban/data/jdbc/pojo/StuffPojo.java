package com.urban.data.jdbc.pojo;

import com.urban.data.Stuff;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Stuff")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class StuffPojo implements Serializable, Stuff {
	public StuffPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18E503279")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18E503279", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity=StuffCategoryPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="category", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private StuffCategoryPojo category;
	
	@Column(name="name", nullable=false, length=10)	
	private int name;
	
	@Column(name="description", nullable=true, length=255)	
	private String description;
	
	@Column(name="cost", nullable=true, precision=19, scale=2)	
	private java.math.BigDecimal cost;
	
	@Column(name="photo", nullable=true, length=10)	
	private Integer photo;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(int value) {
		this.name = value;
	}
	
	public int getName() {
		return name;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setCost(java.math.BigDecimal value) {
		this.cost = value;
	}
	
	public java.math.BigDecimal getCost() {
		return cost;
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
	
	public void setCategory(StuffCategoryPojo value) {
		this.category = value;
	}
	
	public StuffCategoryPojo getCategory() {
		return category;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
