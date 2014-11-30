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
	
	@ManyToOne(targetEntity=OrganizationPojo.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="organization", referencedColumnName="id") })
	@Basic(fetch=FetchType.LAZY)	
	private OrganizationPojo organization;
	
	@ManyToOne(targetEntity=UserPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="user", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private UserPojo user;
	
	public void setOrganization(OrganizationPojo value) {
		this.organization = value;
	}
	
	public OrganizationPojo getOrganization() {
		return organization;
	}
	
	public void setUser(UserPojo value) {
		this.user = value;
	}
	
	public UserPojo getUser() {
		return user;
	}
	
}
