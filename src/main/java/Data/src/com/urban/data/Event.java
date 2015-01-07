package com.urban.data;

import java.util.Set;

public interface Event {

	public int getId();
	
	public String getText();
	
	public Image getImage();
	
	public Set<Organization> getOrganizations();
	
	public Set<Place> getPlace();
	
}
