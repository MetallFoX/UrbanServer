package com.urban.data.jdbc.pojo;

import com.urban.data.Stuff;
import com.urban.data.StuffCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Stuff_Category")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class StuffCategoryPojo implements Serializable, StuffCategory {
	
	public StuffCategoryPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18EC0327A")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18EC0327A", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=false, length=255)	
	private String name;
	
	@ManyToOne(targetEntity=StuffCategoryPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="parent", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private StuffCategoryPojo parent;
	
	@Column(name="description", nullable=true, length=255)	
	private String description;
	
	@OneToMany(mappedBy="parent", targetEntity=StuffCategoryPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<StuffCategory> stuffCategory = new HashSet<StuffCategory>();
	
	@OneToMany(mappedBy="category", targetEntity=StuffPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Stuff> stuff = new HashSet<Stuff>();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
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
	
	public void setParent(StuffCategoryPojo value) {
		this.parent = value;
	}
	
	public StuffCategoryPojo getParent() {
		return parent;
	}
	
	public void setStuffCategory(Set<StuffCategory> value) {
		this.stuffCategory = value;
	}
	
	public Set<StuffCategory> getStuffCategory() {
		return stuffCategory;
	}
	
	
	public void setStuff(Set<Stuff> value) {
		this.stuff = value;
	}
	
	public Set<Stuff> getStuff() {
		return stuff;
	}
		
	public String toString() {
		return String.valueOf(getId());
	}
	
}
