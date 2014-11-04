package com.urban.data;

import java.util.Date;

public interface Person {

	public int getId();
	
	public String getFirstName();
	
	public void setFirstName(String firstName);
	
	public String getSecondName();
	
	public void setSecondName(String secondName);
	
	public String getSurname();
	
	public void setSurname(String surname);
	
	public Integer getPhoto();
	
	public Integer getAge();
	
	public void setAge(int age);
	
	public String getPhone();
	
	public void setPhone(String phone);
	
	public Date getBirthday();

	public void setBirthday(Date birthday);
	
	//public User getUser();
	
}
