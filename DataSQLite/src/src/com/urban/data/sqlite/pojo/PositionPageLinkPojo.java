package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="Position_Page")
public class PositionPageLinkPojo {
	
	@DatabaseField(canBeNull = false, foreign = true, columnName = "position")
    private PositionPojo position;
	
	@DatabaseField(canBeNull = false, foreign = true, columnName = "page", foreignAutoRefresh = true)
    private PagePojo page;

	public PositionPojo getPosition() {
		return position;
	}

	public void setPosition(PositionPojo position) {
		this.position = position;
	}

	public PagePojo getPage() {
		return page;
	}

	public void setPage(PagePojo page) {
		this.page = page;
	}
}
