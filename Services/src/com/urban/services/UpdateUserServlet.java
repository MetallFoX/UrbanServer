package com.urban.services;

import com.google.gson.*;
import com.urban.data.Person;
import com.urban.data.User;
import com.urban.data.dao.DAO;
import com.urban.data.dao.UrbanCriterion;
import com.urban.data.jdbc.JDBCDAO;
import com.urban.data.jdbc.pojo.PersonPojo;
import com.urban.data.jdbc.pojo.UserPojo;
import com.urban.services.error.ResponseError;
import flexjson.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;

public class UpdateUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO.setDAO(new JDBCDAO(""));
		
    	String reqStr = ServletHelper.streamToStr(request.getInputStream());
    	Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new InterfaceAdapter<Person>()).create();
    	
    	User outerUser = gson.fromJson(reqStr, UserPojo.class);

		StringBuilder builder = new StringBuilder();
		
		if (outerUser != null) {
			UrbanCriterion criterion = DAO.createCriterion();
			criterion = criterion.and(
					criterion.eq("login", outerUser.getLogin()),
					criterion.eq("password", outerUser.getPassword()));

            //Ищем пользовател¤ среди зарегистрированных.
			User foundUser = DAO.getUniqByCriterion(User.class, criterion);
			if (foundUser != null) {
				try {
					UserPojo userPojo = ((UserPojo)foundUser);
					userPojo.setPassword(outerUser.getPassword());
					PersonPojo personPojo = (PersonPojo)userPojo.getPerson();
					
					Person outerPerson = outerUser.getPerson();
					
					if (personPojo != null && outerPerson != null) {
						personPojo.setFirstName(outerPerson.getFirstName());
						personPojo.setSecondName(outerPerson.getSecondName());
						personPojo.setSurname(outerPerson.getSurname());
						personPojo.setBirthday(outerPerson.getBirthday());
						personPojo.setAge(outerPerson.getAge());
						personPojo.setPhone(outerPerson.getPhone());
						personPojo.setPhoto(outerPerson.getPhoto());
					}
					userPojo.setRegId(outerUser.getRegId());
					DAO.save(outerUser);
					builder.append(new JSONSerializer().deepSerialize(outerUser));
				} catch (SQLException e) {
					builder.append(new JSONSerializer().exclude("*.class").deepSerialize(new ResponseError(-2, "Sorry, your settings were not updated.")));
				}
			} else {
				builder.append(new JSONSerializer().exclude("*.class").deepSerialize(new ResponseError(-3, "The same user is already exists.")));
			}
		}
		
    	response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println(builder.toString());
	
    }
	
	class InterfaceAdapter<T> implements JsonDeserializer<T> {

		public T deserialize(JsonElement elem, Type interfaceType, JsonDeserializationContext context) throws JsonParseException {
			String intfName = interfaceType.toString(); 
			intfName = intfName.substring(intfName.lastIndexOf(".") + 1, intfName.length());
	        final Type actualType = typeForName("com.urban.data.jdbc.pojo." + intfName + "Pojo"); 
	        return context.deserialize(elem, actualType);
	    }

	    private Type typeForName(final String type) {
	        try {
	            return Class.forName(type);
	        } catch (ClassNotFoundException e) {
	            throw new JsonParseException(e);
	        }
	    }


	}
	
}