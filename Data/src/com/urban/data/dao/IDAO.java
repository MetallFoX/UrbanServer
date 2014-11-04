package com.urban.data.dao;

import java.util.Collection;
import java.util.List;

/**
 * Интерфейс для всех объектов, реализующих доступ к данным.
 * @author victor
 *
 */
public interface IDAO {
	
	public <T> void save(T objToSave);

	public <T> Collection<T> getAll(Class<T> type);

	public <T> T get(Class<T> type, long id);
	
	public <T> List<T> getByCriterion(Class<T> type, UrbanCriterion criterion);
	
	public <T> T getUnicByCriterion(Class<T> type, UrbanCriterion criterion);
	
	public UrbanCriterion createCriteria();
	
	public <T> Class<T> getPojo(Class<T> intf);
}