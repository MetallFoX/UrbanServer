package src.com.urban.data.sqlite;


public class UrbanPersistentManager /*extends PersistentManager*/ {
	/*private static final String PROJECT_NAME = "Urban";
	private static PersistentManager _instance = null;
	private static SessionType _sessionType = SessionType.THREAD_BASE;
	private static int _timeToAlive = 60000;
	private static JDBCConnectionSetting _connectionSetting = null;
	private static Properties _extraProperties = null;
	
	private UrbanPersistentManager() throws PersistentException {
		super(_connectionSetting, _sessionType, _timeToAlive, new String[] {}, _extraProperties);
		setFlushMode(FlushMode.AUTO);
	}
	
	@Override
	public Configuration createConfiguration() {
		/*AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(AddressPojo.class);
		configuration.addAnnotatedClass(PlacePojo.class);
		configuration.addAnnotatedClass(OrganizationPojo.class);
		configuration.addAnnotatedClass(EventPojo.class);
		configuration.addAnnotatedClass(CartPojo.class);
		configuration.addAnnotatedClass(OrganizationPhonePojo.class);
		configuration.addAnnotatedClass(PhotoPojo.class);
		configuration.addAnnotatedClass(PhotoGallaryPojo.class);
		configuration.addAnnotatedClass(PositionPojo.class);
		configuration.addAnnotatedClass(PagePojo.class);
		configuration.addAnnotatedClass(CategoryPojo.class);
		configuration.addAnnotatedClass(NewsCategoryPojo.class);
		configuration.addAnnotatedClass(PersonPojo.class);
		configuration.addAnnotatedClass(VotingItemPojo.class);
		configuration.addAnnotatedClass(VotingPojo.class);
		configuration.addAnnotatedClass(StuffPojo.class);
		configuration.addAnnotatedClass(StuffCategoryPojo.class);
		configuration.addAnnotatedClass(AdvertisingPojo.class);
		configuration.addAnnotatedClass(UserPropertiesPojo.class);
		configuration.addAnnotatedClass(ApplicationPropertiesPojo.class);
		configuration.addAnnotatedClass(UserPojo.class);
		configuration.addAnnotatedClass(NewsPojo.class);
		configuration.addAnnotatedClass(ActionPojo.class);
		configuration.addAnnotatedClass(InfoPagePojo.class);
		configuration.addAnnotatedClass(ActionPagePojo.class);
		configuration.addAnnotatedClass(ImagePojo.class);
		configuration.addAnnotatedClass(ContactPojo.class);
		configuration.addAnnotatedClass(ContactTypePojo.class);
		configuration.buildMappings();
		return configuration;
		return null;
	}
	
	public String getProjectName() {
		return PROJECT_NAME;
	}
	
	public static synchronized final PersistentManager instance() throws PersistentException {
		if (_instance == null) {
			_instance = new UrbanPersistentManager();
		}
		
		return _instance;
	}
	
	public void disposePersistentManager() throws PersistentException {
		_instance = null;
		super.disposePersistentManager();
	}
	
	public static void setSessionType(SessionType sessionType) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set session type after create PersistentManager instance");
		}
		else {
			_sessionType = sessionType;
		}
		
	}
	
	public static void setAppBaseSessionTimeToAlive(int timeInMs) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set session time to alive after create PersistentManager instance");
		}
		else {
			_timeToAlive = timeInMs;
		}
		
	}
	
	public static void setJDBCConnectionSetting(JDBCConnectionSetting aConnectionSetting) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set connection setting after create PersistentManager instance");
		}
		else {
			_connectionSetting = aConnectionSetting;
		}
		
	}
	
	public static void setHibernateProperties(Properties aProperties) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set hibernate properties after create PersistentManager instance");
		}
		else {
			_extraProperties = aProperties;
		}
		
	}
	
	public static void saveJDBCConnectionSetting() {
		PersistentManager.saveJDBCConnectionSetting(PROJECT_NAME, _connectionSetting);
	}
	*/
}
