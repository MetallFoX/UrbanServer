package com.urban.data.jdbc.pojo;

import com.urban.data.Event;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Event")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class EventPojo implements Serializable, Event {
	public EventPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C188B0326D")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C188B0326D", strategy="native")	
	private int id;
	
	@Column(name="text", nullable=true, length=255)	
	private String text;
	
	@ManyToOne(targetEntity=ImagePojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="image", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private ImagePojo image;
	
	@ManyToMany(mappedBy="event", targetEntity=OrganizationPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set organization = new java.util.HashSet();
	
	@ManyToMany(mappedBy="event", targetEntity=PlacePojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set place = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setText(String value) {
		this.text = value;
	}
	
	public String getText() {
		return text;
	}
	
	public void setImage(ImagePojo value) {
		this.image = value;
	}
	
	public ImagePojo getImage() {
		return image;
	}
	
	public void setOrganization(java.util.Set value) {
		this.organization = value;
	}
	
	public java.util.Set getOrganization() {
		return organization;
	}
	
	
	public void setPlace(java.util.Set value) {
		this.place = value;
	}
	
	public java.util.Set getPlace() {
		return place;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
