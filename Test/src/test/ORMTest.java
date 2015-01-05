package test;

import com.urban.data.*;
import com.urban.data.dao.DAO;
import src.com.urban.data.sqlite.SQLiteDAO;

import java.sql.SQLException;
import java.util.Set;

public class ORMTest {
	
	
	public static void main(String[] args) {
		
		DAO.setDAO(new SQLiteDAO("jdbc:sqlite:F:\\Projects\\Observer\\app\\src\\main\\assets\\urban.db"));
		//DAO.setDAO(new JDBCDAO(""));

        try {
            //testSubscribing();
            testAddresses();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void testUser() throws SQLException {
        User user = DAO.get(User.class, 0);
        Set<Organization> subscribes = user.getSubscribes();
        Organization organization = DAO.get(Organization.class, 2);
        subscribes.add(organization);
        DAO.save(user);
        System.out.println("User subscribed on Organization");

        subscribes.remove(organization);
        DAO.save(user);
        System.out.println("User unsubscribed from Organization");
    }

    private static void testSubscribing() throws SQLException {
        User user = DAO.get(User.class, 0);
        if (user != null ) {
            Set<Organization> subscribes = user.getSubscribes();
            Organization organization = DAO.get(Organization.class, 2);
            subscribes.add(organization);
            user.setSubscribes(subscribes);
            DAO.save(user);
            System.out.println("User subscribed on Organization");

            //subscribes.remove(organization);
            DAO.save(user);
            System.out.println("User unsubscribed from Organization");
        } else {
            System.out.println("No user found for subscription");
        }
    }

    private void testCategory() {

    }

    private void testActions() {
        Organization organization = DAO.get(Organization.class, 0);
        Set<Action> actions = organization.getActions();
        System.out.println("Size of actions: " + actions.size());
    }

    private void testAdvertisements() {
        Category category = DAO.get(Category.class, 0);
        Set<Advertising> advertisements = category.getAdvertisements();

        System.out.println("Size: " + advertisements.size());
    }

    private static void testAddresses() {
        Organization organization = DAO.get(Organization.class, 0);
        Set<Place> places = organization.getPlaces();
        System.out.println("Size of actions: " + places.size());

        for (Place place : places) {
            for (Address address : place.getAddress()) {
                System.out.println("Address is " + address.getStreet() + " " + address.getHouse() + address.getLetter() + "кв. " + address.getFlat());
            }

        }
    }

}