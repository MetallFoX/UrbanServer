package com.urban.data.jdbc.pojo;

import com.urban.data.NotificationSubscribe;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Notification_Subscribe")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class NotificationSubscribePojo implements Serializable, NotificationSubscribe {
	
	public NotificationSubscribePojo() {
	}
	
	@ManyToOne(targetEntity=PositionPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="position", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private PositionPojo position;
	
	@ManyToOne(targetEntity=UserPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="user", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private UserPojo user;
	
	public void setPosition(PositionPojo value) {
		this.position = value;
	}
	
	public PositionPojo getPosition() {
		return position;
	}
	
	public void setUser(UserPojo value) {
		this.user = value;
	}
	
	public UserPojo getUser() {
		return user;
	}
	
}
