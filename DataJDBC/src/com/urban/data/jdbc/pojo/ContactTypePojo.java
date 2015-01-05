package com.urban.data.jdbc.pojo;

import com.urban.data.ContactType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="ContactType")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class ContactTypePojo implements Serializable, ContactType {
	public ContactTypePojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C193903285")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C193903285", strategy="native")	
	private Integer id;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@OneToMany(mappedBy="contactType", targetEntity=ContactPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set contact = new java.util.HashSet();
	
	private void setId(int value) {
		setId(new Integer(value));
	}
	
	private void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setContact(Set value) {
		this.contact = value;
	}
	
	public Set getContact() {
		return contact;
	}

    @Override
    public Type getType() {
        return Type.getTypeById(getId());
    }


    public String toString() {
		return String.valueOf(getId());
	}
	
}
