package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Advertising;
import com.urban.data.Category;
import com.urban.data.Image;

import java.util.Set;

@DatabaseTable(tableName="Advertising")
public class AdvertisingPojo implements Advertising {
	
	public AdvertisingPojo() {

	}

    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "position")
    private PositionPojo position;

    @DatabaseField
    private int priority;

    @DatabaseField
    private String text;

    @DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, columnName = "image")
    private ImagePojo image;

    public Image getImage() {
		return image;
	}

	@Override
    public int getId() {
        return id;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getText() {
        return text;
    }

	@Override
	public PositionPojo getPosition() {
		return position;
	}

	@Override
	public Set<Category> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
