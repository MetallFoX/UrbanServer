package com.urban.data;

import java.util.Set;

public interface Voting {

	public int getId();
	
	public String getSubject();
	
	public Integer getIsMultiselect();
	
	public Set<Answer> getVotingItems();
	
}
