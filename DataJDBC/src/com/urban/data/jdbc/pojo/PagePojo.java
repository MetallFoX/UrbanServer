package com.urban.data.jdbc.pojo;

import com.urban.data.Page;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Page")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PagePojo implements Serializable, Page {
	public PagePojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18BA03273")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18BA03273", strategy="native")	
	private int id;
	
	@Column(name="type", nullable=true, length=10)	
	private Integer type;
	
	@ManyToMany(mappedBy="page", targetEntity=OrganizationPojo.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set organization = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setType(int value) {
		setType(new Integer(value));
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setOrganization(Set value) {
		this.organization = value;
	}
	
	public Set getOrganizations() {
		return organization;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
