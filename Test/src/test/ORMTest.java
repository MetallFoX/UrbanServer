package test;

import com.urban.data.Organization;
import com.urban.data.Position;
import com.urban.data.dao.DAO;
import src.com.urban.data.sqlite.SQLiteDAO;

public class ORMTest {
	
	
	public static void main(String[] args) {
		
		DAO.setDAO(new SQLiteDAO("jdbc:sqlite:F:\\Projects\\Urban observer\\src\\Prototype\\assets\\urban.db"));
		//DAO.setDAO(new JDBCDAO(""));
		
		Position position = DAO.get(Position.class, 0);

		Organization organization = position.getOrganization();
		
		System.out.println(organization.getId());
		System.out.println(organization.getName());
		System.out.println(organization.getDescription());
	}
}
