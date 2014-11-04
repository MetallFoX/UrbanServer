package com.urban.data.jdbc.pojo;

import com.urban.data.Image;

import javax.persistence.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Image")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class ImagePojo implements Serializable, Image {
	public ImagePojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C192A03283")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C192A03283", strategy="native")	
	private Integer id;
	
	@Column(name="binaryContent", nullable=true, length=1000)	
	private byte[] binaryContent;
	
	@OneToMany(mappedBy="image", targetEntity=AdvertisingPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set advertising = new java.util.HashSet();
	
	@OneToMany(mappedBy="logo", targetEntity=OrganizationPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set organization = new java.util.HashSet();
	
	@OneToMany(mappedBy="image", targetEntity=EventPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set event = new java.util.HashSet();
	
	private void setId(int value) {
		setId(new Integer(value));
	}
	
	private void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getORMID() {
		return getId();
	}
	
	public void setBinaryContent(byte[] value) {
		this.binaryContent = value;
	}
	
	public byte[] getBinaryContent() {
		return binaryContent;
	}
	
	public void setAdvertising(java.util.Set value) {
		this.advertising = value;
	}
	
	public java.util.Set getAdvertising() {
		return advertising;
	}
	
	
	public void setOrganization(java.util.Set value) {
		this.organization = value;
	}
	
	public java.util.Set getOrganization() {
		return organization;
	}
	
	
	public void setEvent(java.util.Set value) {
		this.event = value;
	}
	
	public java.util.Set getEvent() {
		return event;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}

	@Override
	public InputStream getAsStream() {
		return new ByteArrayInputStream(binaryContent);
	}
	
}
