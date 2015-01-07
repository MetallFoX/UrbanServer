package com.urban.data;

import java.util.Set;

public interface Place {

	public int getId();
	
	public String getDescription();
	
	public double getLat();
	
	public double getAlt();
	
	public Set<Event> getEvent();
	
	public Set<Organization> getOrganizations();
	
	public Set<Address> getAddress();
	
}
