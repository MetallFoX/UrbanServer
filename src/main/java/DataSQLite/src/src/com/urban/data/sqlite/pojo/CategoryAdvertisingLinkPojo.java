package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="Category_Advertising")
public class CategoryAdvertisingLinkPojo {
	
	public CategoryAdvertisingLinkPojo() {
	
	}

	@DatabaseField(canBeNull = false, foreign = true, columnName = "advertising", foreignAutoRefresh = true,  maxForeignAutoRefreshLevel = 1 )
    private AdvertisingPojo advertising;
	
	@DatabaseField(canBeNull = false, foreign = true, columnName = "category")
    private CategoryPojo category;
	
	public AdvertisingPojo getAdvertising(){
		return advertising;
	}

	public CategoryPojo getCategory(){
		return category;
	}
}
