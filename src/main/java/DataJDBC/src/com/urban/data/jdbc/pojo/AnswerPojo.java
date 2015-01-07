package com.urban.data.jdbc.pojo;

import com.urban.data.Answer;
import com.urban.data.Image;
import com.urban.data.Voting;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Answer")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class AnswerPojo implements Serializable, Answer {

	public AnswerPojo() {
	}
	
	@Column(name="id", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A801E3147E5B753CF01D99")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A801E3147E5B753CF01D99", strategy="native")	
	private int id;
	
	@Column(name="text", nullable=false, length=255)	
	private String text;
	
	@OneToOne(targetEntity=ImagePojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="image") })	
	@Basic(fetch=FetchType.LAZY)	
	private ImagePojo image;
	
	@Column(name="count", nullable=false, length=10)	
	private int count = 0;
	
	@ManyToOne(targetEntity=VotingPojo.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="voting", referencedColumnName="id") })	
	@Basic(fetch=FetchType.LAZY)	
	private VotingPojo voting;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setText(String value) {
		this.text = value;
	}
	
	public String getText() {
		return text;
	}
	
	public void setCount(int value) {
		this.count = value;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setVoting(VotingPojo value) {
		this.voting = value;
	}
	
	public Voting getVoting() {
		return voting;
	}
	
	public void setImage(ImagePojo value) {
		this.image = value;
	}
	
	public Image getImage() {
		return image;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}