package com.urban.data.jdbc.pojo;

import com.urban.data.Answer;
import com.urban.data.Voting;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Voting")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class VotingPojo implements Serializable, Voting {
	public VotingPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80164145436C18DE03278")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80164145436C18DE03278", strategy="native")	
	private int id;
	
	@Column(name="subject", nullable=false, length=255)	
	private String subject;
	
	@Column(name="isMultiselect", nullable=true, length=10)	
	private Integer isMultiselect;
	
	@OneToMany(mappedBy="voting", targetEntity=AnswerPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Answer> answer = new HashSet<Answer>();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setSubject(String value) {
		this.subject = value;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setIsMultiselect(int value) {
		setIsMultiselect(new Integer(value));
	}
	
	public void setIsMultiselect(Integer value) {
		this.isMultiselect = value;
	}
	
	public Integer getIsMultiselect() {
		return isMultiselect;
	}
	
	public void setVotingItems(Set<Answer> value) {
		this.answer = value;
	}
	
	public Set<Answer> getVotingItems() {
		return answer;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
