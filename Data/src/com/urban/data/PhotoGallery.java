package com.urban.data;

import java.util.Set;

public interface PhotoGallery {

	public int getId();
	
	public String getName();
	
	public String getDescription();
	
	public Set<Photo> getPhoto();
	
}
