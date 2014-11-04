package com.urban.data;

import java.util.Set;

public interface Page {

	public int getId();
	
	public Integer getType();
	
	public Set<Position> getPosition();
	
}
