package com.urban.data;

import java.util.Set;

public interface Contact {

	public Integer getId();
	
	public String getContact();
	
	public Set<Organization> getOrganization();
	
	public ContactType getContactType();
	
}
