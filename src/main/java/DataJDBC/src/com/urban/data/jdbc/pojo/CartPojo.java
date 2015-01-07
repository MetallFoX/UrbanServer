package com.urban.data.jdbc.pojo;

import com.urban.data.Cart;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Cart")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class CartPojo implements Serializable, Cart {
	public CartPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18940326E")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18940326E", strategy="native")	
	private int id;
	
	@Column(name="stuff", nullable=true, length=10)	
	private Integer stuff;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setStuff(int value) {
		setStuff(new Integer(value));
	}
	
	public void setStuff(Integer value) {
		this.stuff = value;
	}
	
	public Integer getStuff() {
		return stuff;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
