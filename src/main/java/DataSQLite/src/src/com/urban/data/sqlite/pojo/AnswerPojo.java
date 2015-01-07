package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Answer;
import com.urban.data.Image;

@DatabaseTable(tableName="Answer")
public class AnswerPojo implements Answer {
	
	public AnswerPojo() {
	
	}
	
	@DatabaseField(generatedId = true)	
	private int id;
	
	@DatabaseField	
	private String text;
	
	@DatabaseField	
	private int count;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "voting")
	private VotingPojo voting;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "image")
	private ImagePojo image;
	
	private void setId(int value) {
		this.id = value;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	public void setText(String value) {
		this.text = value;
	}
	
	@Override
	public String getText() {
		return text;
	}
	
	public void setCount(int value) {
		setCount(new Integer(value));
	}
	
	public void setCount(Integer value) {
		this.count = value;
	}
	
	@Override
	public int getCount() {
		return count;
	}
	
	public void setVoting(VotingPojo value) {
		this.voting = value;
	}
	
	@Override
	public VotingPojo getVoting() {
		return voting;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}

	@Override
	public Image getImage() {
		return image;
	}
	
}
