package com.urban.data.jdbc.pojo;

import com.urban.data.Organization;
import com.urban.data.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Organization")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class OrganizationPojo implements Serializable, Organization {
	public OrganizationPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18830326C")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18830326C", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="description", nullable=true, length=255)	
	private String description;
	
	@ManyToOne(targetEntity=ImagePojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="logo", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private ImagePojo logo;
	
	@ManyToMany(targetEntity=EventPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Event_Organization", joinColumns={ @JoinColumn(name="organization") }, inverseJoinColumns={ @JoinColumn(name="event") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set event = new java.util.HashSet();
	
	@ManyToMany(targetEntity=ContactPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Organization_Contact", joinColumns={ @JoinColumn(name="Organization") }, inverseJoinColumns={ @JoinColumn(name="Contact") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set contact = new java.util.HashSet();
	
	@ManyToMany(mappedBy="organization", targetEntity=PlacePojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set place = new java.util.HashSet();

	@OneToMany(mappedBy="organization", targetEntity=OrganizationPojo.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set organization = new java.util.HashSet();

    @ManyToMany(targetEntity=PagePojo.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="Organization_Page", joinColumns={ @JoinColumn(name="Organization") }, inverseJoinColumns={ @JoinColumn(name="page") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private Set page = new java.util.HashSet();

    @OneToMany(mappedBy="organization", targetEntity=ActionPojo.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private Set action = new java.util.HashSet();

    @OneToMany(mappedBy="organization", targetEntity=AdvertisingPojo.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private Set advertising = new java.util.HashSet();



	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
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
	
	public void setEvents(Set value) {
		this.event = value;
	}
	
	public Set getEvents() {
		return event;
	}
	
	
	public void setLogo(ImagePojo value) {
		this.logo = value;
	}
	
	public ImagePojo getLogo() {
		return logo;
	}
	
	public void setContacts(Set value) {
		this.contact = value;
	}
	
	public Set getContacts() {
		return contact;
	}
	
	
	public void setPlaces(Set value) {
		this.place = value;
	}
	
	public Set getPlaces() {
		return place;
	}
	
    public void setPage(Set value) {
        this.page = value;
    }

    public Set getPage() {
        return page;
    }

    public void setCategory(Set value) {
        //this.category = value;
    }

    public Set getCategory() {
        //return category;
        return null;
    }

    public void setActions(Set value) {
        this.action = value;
    }

    public Set getActions() {
        return action;
    }

    public void setAdvertising(Set value) {
        this.advertising = value;
    }

    public Set getAdvertising() {
        return advertising;
    }

    @Override
    public Set<User> getSubscribers() {
        return null;
    }


    public String toString() {
		return String.valueOf(getId());
	}
	
}
