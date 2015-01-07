package com.urban.data.jdbc.pojo;

import com.urban.data.Action;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Action")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class ActionPojo implements Serializable, Action {
	
	public ActionPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C191703280")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C191703280", strategy="native")	
	private int id;
	
	@Column(name="startDate", nullable=true)	
	private java.util.Date startDate;
	
	@Column(name="endDate", nullable=true)	
	private java.util.Date endDate;
	
	@Column(name="subject", nullable=false, length=255)	
	private String subject;
	
	@ManyToOne(targetEntity=OrganizationPojo.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="organization", referencedColumnName="id") })
	@Basic(fetch=FetchType.LAZY)	
	private OrganizationPojo organization;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setStartDate(java.util.Date value) {
		this.startDate = value;
	}
	
	public java.util.Date getStartDate() {
		return startDate;
	}
	
	public void setEndDate(java.util.Date value) {
		this.endDate = value;
	}
	
	public java.util.Date getEndDate() {
		return endDate;
	}
	
	public void setSubject(String value) {
		this.subject = value;
	}
	
	public String getSubject() {
		return subject;
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
