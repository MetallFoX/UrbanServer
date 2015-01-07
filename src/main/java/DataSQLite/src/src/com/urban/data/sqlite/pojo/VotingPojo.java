package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Answer;
import com.urban.data.Voting;

import java.util.HashSet;
import java.util.Set;

@DatabaseTable(tableName="Voting")
public class VotingPojo implements Voting {
	
	public VotingPojo() {
		
	}
	
	@DatabaseField(generatedId = true)	
	private int id;
	
	@DatabaseField
	private String subject;
	
	@DatabaseField	
	private Integer isMultiselect;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel = 2, columnName = "voting")
	private Set<Answer> votingItem = new HashSet<Answer>();
	
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
		this.votingItem = value;
	}
	
	public Set<Answer> getVotingItems() {
		return votingItem;
	}
	
}
