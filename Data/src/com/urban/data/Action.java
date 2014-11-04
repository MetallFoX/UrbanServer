package com.urban.data;

import java.util.Date;

public interface Action {
	
	public int getId();
	
	public Date getStartDate();
	
	public Date getEndDate();
	
	public String getSubject();
	
	public Position getPosition();
	
}
