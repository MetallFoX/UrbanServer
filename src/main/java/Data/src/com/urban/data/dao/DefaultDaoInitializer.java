package com.urban.data.dao;
/**
 * Use it for simple dao initialization
 * @author victor
 *
 */
public class DefaultDaoInitializer {
	
	public static void setDaoImpl(IDAO daoImpl){
		DAO.setDAO(daoImpl);
	}
}
