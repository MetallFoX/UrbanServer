package com.urban.data;

import java.util.Date;
import java.util.Set;


public interface User {

	public int getId();
	
	public String getLogin();
	
	public void setLogin(String login);
	
	public String getPassword();
	
	public void setPassword(String password);
	
	public Date getRegDate();
	
	public String getRegId();
	
	public Integer getIsBlocked();
	
	public int getIMEI();
	
	public Person getPerson();
	
	public void setPerson(Person person);
	
	public Set<Organization> getSubscribes();

    public void setSubscribes(Set<Organization> organizations);
	
}
