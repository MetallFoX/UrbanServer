package com.urban.data.jdbc.pojo;

import com.urban.data.Photo;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Photo")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PhotoPojo implements Serializable, Photo {
	public PhotoPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18A203270")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18A203270", strategy="native")	
	private int id;
	
	@Column(name="description", nullable=true, length=255)	
	private String description;
	
	@Column(name="url", nullable=false, length=255)	
	private String url;
	
	@ManyToOne(targetEntity=PhotoGalleryPojo.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="gallery", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private PhotoGalleryPojo gallery;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setGallery(PhotoGalleryPojo value) {
		this.gallery = value;
	}
	
	public PhotoGalleryPojo getGallery() {
		return gallery;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
