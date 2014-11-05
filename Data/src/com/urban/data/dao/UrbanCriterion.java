package com.urban.data.dao;

import java.util.Collection;


public interface UrbanCriterion<T> {
	
	public UrbanCriterion and(UrbanCriterion l, UrbanCriterion r);
	public UrbanCriterion or(UrbanCriterion l, UrbanCriterion r);
	public UrbanCriterion not(UrbanCriterion c);
	public UrbanCriterion eq(String column, Object value);
	public UrbanCriterion in(String column, Collection values);
	public UrbanCriterion ne(String column, Object value);
	public UrbanCriterion lt(String column, Object value);
	public UrbanCriterion gt(String column, Object value);
	public UrbanCriterion isNull(String column);

}
