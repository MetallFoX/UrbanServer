package com.urban.data;

import java.io.InputStream;
import java.util.Set;

public interface Image {

	public Integer getId();
	
	public byte[] getBinaryContent();
	
	public Set<Advertising> getAdvertising();
	
	public Set<Organization> getOrganization();
	
	public Set<Event> getEvent();
	
	public InputStream getAsStream();
	
}
