package com.urban.data.jdbc.pojo;

import com.urban.data.Contact;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Contact")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class ContactPojo implements Serializable, Contact {
	public ContactPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C193203284")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C193203284", strategy="native")	
	private Integer id;
	
	@ManyToOne(targetEntity=ContactTypePojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ContactType", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private ContactTypePojo contactType;
	
	@Column(name="contact", nullable=true, length=255)	
	private String contact;
	
	@ManyToMany(mappedBy="contact", targetEntity=OrganizationPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set organization = new java.util.HashSet();
	
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
	
	public void setContact(String value) {
		this.contact = value;
	}
	
	public String getContact() {
		return contact;
	}
	
	public void setOrganization(java.util.Set value) {
		this.organization = value;
	}
	
	public java.util.Set getOrganization() {
		return organization;
	}
	
	
	public void setContactType(ContactTypePojo value) {
		this.contactType = value;
	}
	
	public ContactTypePojo getContactType() {
		return contactType;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
