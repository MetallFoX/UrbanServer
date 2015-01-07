package com.urban.data.jdbc;

import com.urban.data.dao.UrbanCriterion;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;

public class JDBCUrbanCriterion<T> implements UrbanCriterion {

	Criterion criterion;// = new  criterion;
    Class<T> type;
	
	public JDBCUrbanCriterion(Class<T> type) {
        this.type = type;
	}
	
	private JDBCUrbanCriterion(Criterion criterion) {
		this.criterion = criterion;
	}
	
	@Override
	public UrbanCriterion and(UrbanCriterion l, UrbanCriterion r) {
		return new JDBCUrbanCriterion(Restrictions.and(
				((JDBCUrbanCriterion)l).getCriterion(),
				((JDBCUrbanCriterion)r).getCriterion()));
	}

	@Override
	public UrbanCriterion or(UrbanCriterion l, UrbanCriterion r) {
		return new JDBCUrbanCriterion(Restrictions.or(
				((JDBCUrbanCriterion)l).getCriterion(),
				((JDBCUrbanCriterion)r).getCriterion()));
	}
	
	@Override
	public UrbanCriterion not(UrbanCriterion c) {
		return new JDBCUrbanCriterion(
				Restrictions.not(((JDBCUrbanCriterion)c).getCriterion()));
	}

	@Override
	public UrbanCriterion eq(String column, Object value) {
		return new JDBCUrbanCriterion(Restrictions.eq(column, value));
	}
	
	@Override
	public UrbanCriterion in(String column, Collection values) {
		return new JDBCUrbanCriterion(Restrictions.in(column, values));
	}

	@Override
	public UrbanCriterion ne(String column, Object value) {
		return new JDBCUrbanCriterion(Restrictions.ne(column, value));
	}

	@Override
	public UrbanCriterion lt(String column, Object value) {
		return new JDBCUrbanCriterion(Restrictions.lt(column, value));
	}

	@Override
	public UrbanCriterion gt(String column, Object value) {
		return new JDBCUrbanCriterion(Restrictions.gt(column, value));
	}
	
	@Override
	public UrbanCriterion isNull(String column) {
		return new JDBCUrbanCriterion(Restrictions.isNull(column));
	}
	

	public Criterion getCriterion() {
		return criterion;
	}

}
