package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.NotificationSubscribe;

@DatabaseTable(tableName="Notification_Subscribe")
public class NotificationSubscribePojo implements NotificationSubscribe {
	
	public NotificationSubscribePojo() {

	}

    /**
     * This id is generated by the database and set on the object when it is passed to the create method. An id is
     * needed in case we need to update or delete this object in the future.
     */
    @DatabaseField(generatedId = true)
    int id;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel = 2, columnName = "position")	
	private PositionPojo position;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel = 2, columnName = "user")	
	private UserPojo user;
	
	public void setPosition(PositionPojo value) {
		this.position = value;
	}
	
	public PositionPojo getPosition() {
		return position;
	}
	
	public void setUser(UserPojo value) {
		this.user = value;
	}
	
	public UserPojo getUser() {
		return user;
	}
	
}
