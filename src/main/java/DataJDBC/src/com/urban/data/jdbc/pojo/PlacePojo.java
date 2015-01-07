package com.urban.data.jdbc.pojo;

import com.urban.data.Place;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Place")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PlacePojo implements Serializable, Place {
	public PlacePojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C187A0326B")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C187A0326B", strategy="native")	
	private int id;
	
	@Column(name="description", nullable=true, length=255)	
	private String description;
	
	@Column(name="lat", nullable=false, length=10)	
	private double lat;
	
	@Column(name="alt", nullable=false, length=10)	
	private double alt;
	
	@ManyToMany(targetEntity=EventPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Event_Place", joinColumns={ @JoinColumn(name="Place") }, inverseJoinColumns={ @JoinColumn(name="Event") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set event = new java.util.HashSet();
	
	@ManyToMany(targetEntity=OrganizationPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Organization_Place", joinColumns={ @JoinColumn(name="Place") }, inverseJoinColumns={ @JoinColumn(name="Organization") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set organization = new java.util.HashSet();
	
	@OneToMany(mappedBy="place", targetEntity=AddressPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set address = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setLat(int value) {
		this.lat = value;
	}
	
	public double getLat() {
		return lat;
	}
	
	public void setAlt(int value) {
		this.alt = value;
	}
	
	public double getAlt() {
		return alt;
	}
	
	public void setEvent(Set value) {
		this.event = value;
	}
	
	public Set getEvent() {
		return event;
	}
	
	
	public void setOrganization(Set value) {
		this.organization = value;
	}
	
	public Set getOrganizations() {
		return organization;
	}
	
	
	public void setAddress(Set value) {
		this.address = value;
	}
	
	public Set getAddress() {
		return address;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
