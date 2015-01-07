package com.urban.data.jdbc.pojo;

import com.urban.data.Advertising;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Advertising")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class AdvertisingPojo implements Serializable, Advertising {
	public AdvertisingPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18F30327B")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18F30327B", strategy="native")	
	private int id;
	
	@Column(name="priority", nullable=false, length=10)	
	private int priority;
	
	@Column(name="text", nullable=true, length=255)	
	private String text;
	
	@ManyToOne(targetEntity=ImagePojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="image", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private ImagePojo image;
	
	@ManyToOne(targetEntity=OrganizationPojo.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="organization", referencedColumnName="id") })
	@Basic(fetch=FetchType.LAZY)	
	private OrganizationPojo organization;
	
	@ManyToMany(mappedBy="advertising", targetEntity=CategoryPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set category = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setPriority(int value) {
		this.priority = value;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setText(String value) {
		this.text = value;
	}
	
	public String getText() {
		return text;
	}
	
	public void setCategory(Set value) {
		this.category = value;
	}
	
	public Set getCategories() {
		return category;
	}
	
	
	public void setImage(ImagePojo value) {
		this.image = value;
	}
	
	public ImagePojo getImage() {
		return image;
	}
	
	public void setOrganization(OrganizationPojo value) {
		this.organization = value;
	}
	
	public OrganizationPojo getOrganization() {
		return organization;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
