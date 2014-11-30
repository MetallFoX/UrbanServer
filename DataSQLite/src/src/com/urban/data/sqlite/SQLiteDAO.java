package src.com.urban.data.sqlite;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.urban.data.*;
import com.urban.data.dao.IDAO;
import com.urban.data.dao.UrbanCriterion;
import src.com.urban.data.sqlite.pojo.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLiteDAO implements IDAO {

	private ConnectionSource connectionSource;

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
		classes.put(Page.class, PagePojo.class);
		classes.put(Person.class, PersonPojo.class);
		classes.put(Photo.class, PhotoPojo.class);
		classes.put(PhotoGallery.class, PhotoGalleryPojo.class);
		classes.put(Place.class, PlacePojo.class);
		classes.put(Stuff.class, StuffPojo.class);
		classes.put(StuffCategory.class, StuffCategoryPojo.class);
		classes.put(User.class, UserPojo.class);
		classes.put(UserProperties.class, UserPropertiesPojo.class);
		classes.put(Voting.class, VotingPojo.class);
		classes.put(Answer.class, AnswerPojo.class);
	}
	
	
	public SQLiteDAO(String jdbcConnectionStr) {
		// create a connection source to our database
		try {
			connectionSource = new JdbcConnectionSource(jdbcConnectionStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.prototype.dao.IDAO#save(T)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> void save(T objToSave) {
		Dao<T, String> dao;
		try {
			dao = (Dao<T, String>) getDao(objToSave.getClass());
			dao.createOrUpdate(objToSave);
		} catch (SQLException e) {
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
		Dao<T, String> dao;
		try {
			dao = getDao(type);
			return dao.queryForAll();
		} catch (SQLException e) {
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

		try {
			Dao<T, String> dao = getDao(type);
			return dao.queryForId(Long.toString(id));
		} catch (SQLException e) {
			// TODO implement exception handling
			e.printStackTrace();
		}
		return null;
	}

	private <T> Dao<T, String> getDao(Class<T> type) throws SQLException {
		// DaoManager.registerDao(connectionSource, null);

		Dao<T, String> dao = DaoManager.lookupDao(connectionSource, type);
		if (dao == null) {
			dao = DaoManager.createDao(connectionSource, type);
		}
        //FIXME: change this?
        ((BaseDaoImpl)dao).initialize();
		return dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getByCriterion(Class<T> type, UrbanCriterion criterion) {
		try {
			Dao<T, String> dao = getDao(type);
			Where<T, String> where = ((SQLiteUrbanCriterion<T>) criterion).getWhere();
			QueryBuilder<T, String> qBuilder = dao.queryBuilder();
			qBuilder.setWhere(where);
			return qBuilder.query();
		} catch (SQLException e) {
			// TODO implement exception handling
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getUniqByCriterion(Class<T> type, UrbanCriterion criterion) {
		try {
			Dao<T, String> dao = getDao(type);
			Where<T, String> where = ((SQLiteUrbanCriterion<T>) criterion).getWhere();
			QueryBuilder<T, String> qBuilder = dao.queryBuilder();
			qBuilder.setWhere(where);

			return qBuilder.queryForFirst();// !!!!!!!!!!!!!
		} catch (SQLException e) {
			// TODO implement exception handling
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> UrbanCriterion createCriteria(Class<T> type) {
        try {
            Dao<T, String> dao = getDao(type);
            return new SQLiteUrbanCriterion(type, dao);
        } catch (SQLException e) {
            // TODO implement exception handling
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public <T> Class<T> getPojo(Class<T> intf) {
		return classes.get(intf);
	}

    @Override
    public <T> void deleteAll(Class<T> type) {
        try {
            Dao<T, String> dao = getDao(type);
            DeleteBuilder<T, String> dBuilder = dao.deleteBuilder();
            dBuilder.delete();
        } catch (SQLException e) {
            // TODO implement exception handling
            e.printStackTrace();
        }
    }


}
