package com.urban.data;

import java.util.Set;

public interface NewsCategory {

	public int getId();
	
	public String getName();
	
	public Set<News> getNews();
	
}
