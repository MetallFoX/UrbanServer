package src.com.urban.data.sqlite;

import com.j256.ormlite.stmt.Where;
import com.urban.data.dao.UrbanCriterion;

import java.sql.SQLException;
import java.util.Collection;

public class SQLiteUrbanCriterion<T> implements UrbanCriterion {

	Where<T, String> where;
	
	public SQLiteUrbanCriterion() {

	}
	
	private SQLiteUrbanCriterion(Where<T, String> where) {
		this.where = where;
	}
	
	@Override
	public UrbanCriterion and(UrbanCriterion l, UrbanCriterion r) {
		return new SQLiteUrbanCriterion<T>(where.and(
				((SQLiteUrbanCriterion<T>)l).getWhere(),
				((SQLiteUrbanCriterion<T>)r).getWhere()));
	}

	@Override
	public UrbanCriterion or(UrbanCriterion l, UrbanCriterion r) {
		return new SQLiteUrbanCriterion<T>(where.or(
				((SQLiteUrbanCriterion<T>)l).getWhere(),
				((SQLiteUrbanCriterion<T>)r).getWhere()));
	}
	
	@Override
	public UrbanCriterion not(UrbanCriterion c) {
		return new SQLiteUrbanCriterion<T>(where.not(
				(((SQLiteUrbanCriterion<T>)c).getWhere())));
	}

	@Override
	public UrbanCriterion eq(String column, Object value) {
		try {
			return new SQLiteUrbanCriterion<T>(where.eq(column, value));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public UrbanCriterion in(String column, Collection values) {
		return null;//new SQLiteUrbanCriterion(where.in(column, values));
	}

	@Override
	public UrbanCriterion ne(String column, Object value) {
		return null;//return new SQLiteUrbanCriterion(Restrictions.ne(column, value));
	}

	@Override
	public UrbanCriterion lt(String column, Object value) {
		return null;//return new SQLiteUrbanCriterion(Restrictions.lt(column, value));
	}

	@Override
	public UrbanCriterion gt(String column, Object value) {
		return null;//return new SQLiteUrbanCriterion(Restrictions.gt(column, value));
	}
	
	@Override
	public UrbanCriterion isNull(String column) {
		
		try {
			return new SQLiteUrbanCriterion<T>(where.isNull(column));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public Where<T, String> getWhere() {
		return where;
	}

}
