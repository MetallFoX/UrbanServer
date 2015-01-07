package com.urban.data;

import java.util.Set;

public interface StuffCategory {

	public int getId();
	
	public String getName();
	
	public String getDescription();
	
	public StuffCategory getParent();
	
	public Set<StuffCategory> getStuffCategory();
	
	public Set<Stuff> getStuff();
	
}
