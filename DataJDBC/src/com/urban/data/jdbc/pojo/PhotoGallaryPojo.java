package com.urban.data.jdbc.pojo;

import com.urban.data.PhotoGallary;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="PhotoGallary")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PhotoGallaryPojo implements Serializable, PhotoGallary {
	public PhotoGallaryPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18AA03271")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18AA03271", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="description", nullable=true, length=255)	
	private String description;
	
	@OneToMany(mappedBy="gallery", targetEntity=PhotoPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set photo = new java.util.HashSet();
	
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
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPhoto(java.util.Set value) {
		this.photo = value;
	}
	
	public java.util.Set getPhoto() {
		return photo;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
