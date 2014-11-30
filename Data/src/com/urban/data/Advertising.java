package com.urban.data;

import java.util.Set;

public interface Advertising {

	public int getId();
	
	public int getPriority();
	
	public String getText();
	
	public Set<Category> getCategories();
	
	public Image getImage();

	public Organization getOrganization();
	
}
