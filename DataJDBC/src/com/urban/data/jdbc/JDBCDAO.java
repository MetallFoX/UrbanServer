package com.urban.data.jdbc;

import com.urban.data.*;
import com.urban.data.dao.IDAO;
import com.urban.data.dao.UrbanCriterion;
import com.urban.data.jdbc.pojo.*;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCDAO implements IDAO {

	//private ConnectionSource connectionSource;
	
	
	private static Map<Class, Class> classes = new HashMap<Class, Class>();
	static {
		classes.put(Action.class, ActionPojo.class);
		classes.put(ActionPage.class, ActionPagePojo.class);
		classes.put(Address.class, AddressPojo.class);
		classes.put(Advertising.class, AdvertisingPojo.class);
		classes.put(ApplicationProperties.class, ApplicationPropertiesPojo.class);
		classes.put(Cart.class, CartPojo.class);
		classes.put(Category.class, CategoryPojo.class);
		classes.put(Contact.class, ContactPojo.class);
		classes.put(ContactType.class, ContactTypePojo.class);
		classes.put(Event.class, EventPojo.class);
		classes.put(Image.class, ImagePojo.class);
		classes.put(InfoPage.class, InfoPagePojo.class);
		classes.put(News.class, NewsPojo.class);
		classes.put(NewsCategory.class, NewsCategoryPojo.class);
		classes.put(Organization.class, OrganizationPojo.class);
		classes.put(OrganizationPhone.class, OrganizationPhonePojo.class);
		classes.put(Page.class, PagePojo.class);
		classes.put(Person.class, PersonPojo.class);
		classes.put(Photo.class, PhotoPojo.class);
		classes.put(PhotoGallary.class, PhotoGallaryPojo.class);
		classes.put(Place.class, PlacePojo.class);
		classes.put(Position.class, PositionPojo.class);
		classes.put(Stuff.class, StuffPojo.class);
		classes.put(StuffCategory.class, StuffCategoryPojo.class);
		classes.put(User.class, UserPojo.class);
		classes.put(UserProperties.class, UserPropertiesPojo.class);
		classes.put(Voting.class, VotingPojo.class);
		classes.put(Answer.class, AnswerPojo.class);
	}

	public JDBCDAO(String jdbcConnectionStr) {
		// create a connection source to our database
		try {
			//connectionSource = new JdbcConnectionSource(jdbcConnectionStr);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	private Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	@Override
	public <T> void save(T objToSave) {
		
        Session session = getSession();
        Transaction trn = session.beginTransaction();
		try {
			session.saveOrUpdate(objToSave);
	        //session.save(objToSave);
	        trn.commit();
   		} catch (HibernateException e) {
			trn.rollback();
			// TODO implement exception handling
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.prototype.dao.IDAO#getAll(java.lang.Class)
	 */
	@Override
	public <T> Collection<T> getAll(Class<T> type) {
		
		Session session = getSession();
		try {
	        //return (T)session.createCriteria(type).list();;
			return null;
   		} catch (HibernateException e) {
			// TODO implement exception handling
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.prototype.dao.IDAO#get(java.lang.Class, long)
	 */
	@Override
	public <T> T get(Class<T> type, long id) {

        Session session = getSession();
		try {
			Transaction trn = session.beginTransaction();
			T object = (T)session.get(type, (int)id);
			trn.commit();
	        return object;
   		} catch (HibernateException e) {
			// TODO implement exception handling
			e.printStackTrace();
		} finally {
			//session.close();
		}
		return null;
	}
	
	
	/*public <T> T getByAK(Class<T> type, CriterionRestrictionDescriptor restriction) {
		Session session = getSession();
		Criteria crit = session.createCriteria(type);
		crit.add(restriction.getCriterion());
		return (T)crit.uniqueResult();
	}*/
	

	@Override
	public <T> List<T> getByCriterion(Class<T> type, UrbanCriterion criterion) {
		try {
			Session session = getSession();
			Transaction trn = session.beginTransaction();
			Criteria crit = session.createCriteria(type);
			crit.add(((JDBCUrbanCriterion)criterion).getCriterion());
			List<T> listValue = (List<T>)crit.list();
			trn.commit();
			return listValue;
		} catch (HibernateException e) {
			
		}
		
		return null;
	}
	
	@Override
	public <T> T getUniqByCriterion(Class<T> type, UrbanCriterion criterion) {
        Transaction trn = null;
		try {
			Session session = getSession();
			trn = session.beginTransaction();
			Criteria crit = session.createCriteria(type);
			crit.add(((JDBCUrbanCriterion)criterion).getCriterion());
			T value = (T)crit.uniqueResult();
			trn.commit();
			return value;
		} catch (HibernateException e) {
            if (trn != null) {
                trn.rollback();
            }
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public <T> UrbanCriterion createCriteria(Class<T> type) {
		return new JDBCUrbanCriterion(type);
	}
	
	@Override
	public <T> Class<T> getPojo(Class<T> intf) {
		return classes.get(intf);
	}

    @Override
    public <T> void deleteAll(Class<T> type) {
        Session session = getSession();
        Criteria crit = session.createCriteria(type);
        Transaction trn = null;
        ScrollableResults sc = crit.scroll();
        try {
            trn = session.beginTransaction();
            while (sc.next()) {
                session.delete(sc.get(0));
            }
            trn.commit();
        } catch (HibernateException e) {
            if (trn != null) {
                trn.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }


    public static class HibernateUtil {
		
		private static final SessionFactory sessionFactory;
		
		static {
			try {
				// Create the SessionFactory from standard (hibernate.cfg.xml)
				// config file.
				sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			} catch (Throwable ex) {
				// Log the exception.
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		
		public static Session getSession() {
			Session hibernateSession = sessionFactory.getCurrentSession();
			return hibernateSession;
		}
	}
}
