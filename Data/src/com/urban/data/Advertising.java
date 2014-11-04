package com.urban.data;

import java.util.Set;

public interface Advertising {

	public int getId();
	
	public int getPriority();
	
	public String getText();
	
	public Set<Category> getCategory();
	
	public Image getImage();

	public Position getPosition();
	
}
