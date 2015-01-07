package com.urban.data.jdbc.pojo;

import com.urban.data.OrganizationPhone;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Organization_Phone")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class OrganizationPhonePojo implements Serializable, OrganizationPhone {
	public OrganizationPhonePojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C189B0326F")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C189B0326F", strategy="native")	
	private int id;
	
	@Column(name="phone", nullable=false, length=10)	
	private int phone;
	
	@Column(name="description", nullable=true, length=255)	
	private String description;
	
	@Column(name="`order`", nullable=true, length=10)	
	private Integer order;
	
	@ManyToOne(targetEntity=OrganizationPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="organization", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private OrganizationPojo organization;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}

	public void setPhone(int value) {
		this.phone = value;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setOrder(int value) {
		setOrder(new Integer(value));
	}
	
	public void setOrder(Integer value) {
		this.order = value;
	}
	
	public Integer getOrder() {
		return order;
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
