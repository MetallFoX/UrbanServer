package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * ������ ��� ��������� � �������
 * @author victor
 *
 */
@DatabaseTable(tableName="Category_Position")
public class CategoryPositionLinkPojo {
	
	public CategoryPositionLinkPojo() {
	
	}
	
	@DatabaseField(canBeNull = false, foreign = true, columnName = "position", foreignAutoRefresh = true,  maxForeignAutoRefreshLevel = 1 )
    private PositionPojo position;
	
	@DatabaseField(canBeNull = false, foreign = true, columnName = "category")
    private CategoryPojo category;
	
	public CategoryPojo getCategory() {
		return category;
	}

	public void setCategory(CategoryPojo category) {
		this.category = category;
	}

	public PositionPojo getPosition() {
		return position;
	}

	public void setPosition(PositionPojo position) {
		this.position = position;
	}
}
