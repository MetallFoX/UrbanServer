package com.urban.data.jdbc.pojo;

import com.urban.data.InfoPage;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Info_Page")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class InfoPagePojo implements Serializable, InfoPage {
	public InfoPagePojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C191E03281")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C191E03281", strategy="native")	
	private Integer id;
	
	private void setId(int value) {
		setId(new Integer(value));
	}
	
	private void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
