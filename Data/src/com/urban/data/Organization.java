package com.urban.data;

import java.util.Set;

public interface Organization {

	public int getId();
	
	public String getName();
	
	public String getDescription();
	
	public Set<Event> getEvents();
	
	public Image getLogo();
	
	public Set<Contact> getContacts();
	
	public Set<Place> getPlaces();
	
	public Set<Position> getPositions();
	
}
