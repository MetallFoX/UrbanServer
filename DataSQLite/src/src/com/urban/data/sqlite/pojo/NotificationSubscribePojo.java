package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.NotificationSubscribe;

@DatabaseTable(tableName="Notification_Subscribe")
public class NotificationSubscribePojo implements NotificationSubscribe {
	
	public NotificationSubscribePojo() {

	}
	
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
