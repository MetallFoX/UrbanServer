package com.urban.data.jdbc.pojo;

import com.urban.data.UserProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="User_Properties")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class UserPropertiesPojo implements Serializable, UserProperties {
	public UserPropertiesPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18FA0327C")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18FA0327C", strategy="native")	
	private int id;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
