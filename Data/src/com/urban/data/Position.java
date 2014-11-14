package com.urban.data;

import java.util.Set;

public interface Position {

	public int getId();
	
	public String getName();
	
	public Set<Category> getCategory();
	
	public Organization getOrganization();
	
	public Set<Page> getPage();
	
	public Set<Action> getActions();
	
	public Set<Advertising> getAdvertising();
	
}
