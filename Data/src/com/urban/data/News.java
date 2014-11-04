package com.urban.data;

import java.util.Date;

public interface News {

	public int getId();
	
	public Date getDate();
	
	public String getText();
	
	public Integer getPhoto();
	
	public NewsCategory getCategory();
	
}
