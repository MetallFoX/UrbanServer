package com.urban.data.jdbc.pojo;

import com.urban.data.Address;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Address")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class AddressPojo implements Serializable, Address {
	public AddressPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18700326A")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18700326A", strategy="native")	
	private int id;
	
	@Column(name="street", nullable=false, length=255)	
	private String street;
	
	@Column(name="house", nullable=false, length=10)	
	private int house;
	
	@Column(name="letter", nullable=true, length=1)	
	private String letter;
	
	@Column(name="flat", nullable=true, length=10)	
	private Integer flat;
	
	@Column(name="floor", nullable=true, length=10)	
	private Integer floor;
	
	@ManyToOne(targetEntity=PlacePojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="place", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private PlacePojo place;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setStreet(String value) {
		this.street = value;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setHouse(int value) {
		this.house = value;
	}
	
	public int getHouse() {
		return house;
	}
	
	public void setLetter(String value) {
		this.letter = value;
	}
	
	public String getLetter() {
		return letter;
	}
	
	public void setFlat(int value) {
		setFlat(new Integer(value));
	}
	
	public void setFlat(Integer value) {
		this.flat = value;
	}
	
	public Integer getFlat() {
		return flat;
	}
	
	public void setFloor(int value) {
		setFloor(new Integer(value));
	}
	
	public void setFloor(Integer value) {
		this.floor = value;
	}
	
	public Integer getFloor() {
		return floor;
	}
	
	public void setPlace(PlacePojo value) {
		this.place = value;
	}
	
	public PlacePojo getPlace() {
		return place;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
