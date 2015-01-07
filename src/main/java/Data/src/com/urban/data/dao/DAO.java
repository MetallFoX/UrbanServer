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
       return  (List<T>) curDao.getByCriterion(pojo != null ? pojo : type, criterion);
   }
   
   public static <T> T getUniqByCriterion(Class<T> type, UrbanCriterion criterion) {
	   Class pojo = curDao.getPojo(type);
       return  (T) curDao.getUniqByCriterion(pojo != null ? pojo : type, criterion);
   }
   
   public static <T> UrbanCriterion createCriterion(Class<T> type) {
       Class pojo = curDao.getPojo(type);
       return curDao.createCriteria(pojo != null ? pojo : type);
   }

    public static <T> void deleteAll(Class<T> type) {
        Class pojo = curDao.getPojo(type);
        curDao.deleteAll(pojo != null ? pojo : type);
    }

}
