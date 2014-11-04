package com.urban.data.dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class DAO {

   public static void setDAO(IDAO dao) {
       curDao = dao;
   }

   private static IDAO curDao;

   public static void save(Object objToSave) throws SQLException {
       curDao.save(objToSave);
   }

   public static <T> Collection<T> getAll(Class<T> type) {
	  Class pojo = curDao.getPojo(type);
      return pojo != null ?
           curDao.getAll(pojo) : curDao.getAll(type);
   }

   public static <T> T get(Class<T> type, long id) {
	   Class pojo = curDao.getPojo(type);
       return (T) (pojo != null ?
               curDao.get(pojo, id) : curDao.get(type, id));
   }
   
   public static <T> List<T> getByCriterion(Class<T> type, UrbanCriterion criterion) {
	   Class pojo = curDao.getPojo(type);
       return  (List<T>) (pojo != null ?
               curDao.getByCriterion(pojo, criterion) : curDao.getByCriterion(type, criterion));
   }
   
   public static <T> T getUniqByCriterion(Class<T> type, UrbanCriterion criterion) {
	   Class pojo = curDao.getPojo(type);
       return  (T) (pojo != null ?
               curDao.getUnicByCriterion(pojo, criterion) : curDao.getUnicByCriterion(type, criterion));
   }
   
   public static UrbanCriterion createCriterion() {
       return curDao.createCriteria();
   }

}
