package src.com.urban.data.sqlite.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.urban.data.Cart;

@DatabaseTable(tableName="Cart")
public class CartPojo implements Cart {
	
	public CartPojo() {
	
	}
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField	
	private Integer stuff;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setStuff(int value) {
		setStuff(new Integer(value));
	}
	
	public void setStuff(Integer value) {
		this.stuff = value;
	}
	
	public Integer getStuff() {
		return stuff;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
