package src.com.urban.data.sqlite.pojo;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.NewsCategory;

import java.io.Serializable;
import java.util.Set;

@DatabaseTable(tableName="NewsCategory")
public class NewsCategoryPojo implements Serializable, NewsCategory {
	
	public NewsCategoryPojo() {
	
	}

	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField
	private String name;
	
	@DatabaseField(foreign = true, foreignAutoRefresh=true, maxForeignAutoRefreshLevel= 2, canBeNull = true, columnName = "category")
	private Set news = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNews(Set value) {
		this.news = value;
	}
	
	public Set getNews() {
		return news;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
