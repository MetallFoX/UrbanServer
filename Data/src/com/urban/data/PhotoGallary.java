package com.urban.data;

import java.util.Set;

public interface PhotoGallary {

	public int getId();
	
	public String getName();
	
	public String getDescription();
	
	public Set<Photo> getPhoto();
	
}
