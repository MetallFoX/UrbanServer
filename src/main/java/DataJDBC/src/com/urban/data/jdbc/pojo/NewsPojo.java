package com.urban.data.jdbc.pojo;

import com.urban.data.News;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="News")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class NewsPojo implements Serializable, News {
	public NewsPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C19100327F")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C19100327F", strategy="native")	
	private int id;
	
	@Column(name="`date`", nullable=true)	
	private java.util.Date date;
	
	@Column(name="text", nullable=true, length=255)	
	private String text;
	
	@ManyToOne(targetEntity=NewsCategoryPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="category", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private NewsCategoryPojo category;
	
	@Column(name="photo", nullable=true, length=10)	
	private Integer photo;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDate(java.util.Date value) {
		this.date = value;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public void setText(String value) {
		this.text = value;
	}
	
	public String getText() {
		return text;
	}
	
	public void setPhoto(int value) {
		setPhoto(new Integer(value));
	}
	
	public void setPhoto(Integer value) {
		this.photo = value;
	}
	
	public Integer getPhoto() {
		return photo;
	}
	
	public void setCategory(NewsCategoryPojo value) {
		this.category = value;
	}
	
	public NewsCategoryPojo getCategory() {
		return category;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
