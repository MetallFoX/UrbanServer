package com.urban.data;

import java.util.Set;

public interface Category {
	
	public int getId();
	
	public String getName();
	
	public Category getParent();
	
	public int getOrder();
	
	public Set<Advertising> getAdvertisings();
	
	public Set<Position> getPositions();
	
}
