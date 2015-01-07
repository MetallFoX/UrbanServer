package com.urban.data.jdbc.pojo;

import com.urban.data.ApplicationProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Application_Properties")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class ApplicationPropertiesPojo implements Serializable, ApplicationProperties {
	public ApplicationPropertiesPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C19000327D")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C19000327D", strategy="native")	
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
