package com.urban.data.jdbc.pojo;

import com.urban.data.NewsCategory;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="News_Category")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class NewsCategoryPojo implements Serializable, NewsCategory {
	public NewsCategoryPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18C903275")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18C903275", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@OneToMany(mappedBy="category", targetEntity=NewsPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set news = new java.util.HashSet();
	
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
	
	public void setNews(java.util.Set value) {
		this.news = value;
	}
	
	public java.util.Set getNews() {
		return news;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
