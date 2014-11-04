package com.urban.data.jdbc.pojo;

import com.urban.data.ActionPage;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Action_Page")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class ActionPagePojo implements Serializable, ActionPage {
	public ActionPagePojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C192403282")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C192403282", strategy="native")	
	private Integer id;
	
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
