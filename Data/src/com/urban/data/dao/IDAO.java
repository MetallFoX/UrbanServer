package com.urban.data.dao;

import java.util.Collection;
import java.util.List;

/**
 * ��������� ��� ���� ��������, ����������� ������ � ������.
 * @author victor
 *
 */
public interface IDAO {
	
	public <T> void save(T objToSave);

	public <T> Collection<T> getAll(Class<T> type);

	public <T> T get(Class<T> type, long id);
	
	public <T> List<T> getByCriterion(Class<T> type, UrbanCriterion criterion);
	
	public <T> T getUniqByCriterion(Class<T> type, UrbanCriterion criterion);
	
	public <T> UrbanCriterion createCriteria(Class<T> type);
	
	public <T> Class<T> getPojo(Class<T> intf);

    public <T> void deleteAll(Class<T> type);
}