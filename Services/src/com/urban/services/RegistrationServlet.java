package com.urban.services;

import com.google.gson.*;
import com.urban.data.Person;
import com.urban.data.User;
import com.urban.data.dao.DAO;
import com.urban.data.dao.UrbanCriterion;
import com.urban.data.jdbc.JDBCDAO;
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
import java.util.Date;

public class RegistrationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO.setDAO(new JDBCDAO(""));
		
    	String reqStr = ServletHelper.streamToStr(request.getInputStream());
    	Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new InterfaceAdapter<Person>()).create();
    	
    	User user = gson.fromJson(reqStr, UserPojo.class);

		StringBuilder builder = new StringBuilder();
		
		if (user != null) {
			UrbanCriterion criterion = DAO.createCriterion();
			criterion = criterion.and(
					criterion.eq("login", user.getLogin()),
					criterion.eq("password", user.getPassword()));

            //Ищем пользовател¤ среди зарегистрированных.
			User foundUser = DAO.getUniqByCriterion(User.class, criterion);
			if (foundUser == null) {
				try {
					((UserPojo)user).setRegDate(new Date());
					DAO.save(user);
					builder.append(new JSONSerializer().deepSerialize(user));
				} catch (SQLException e) {
					builder.append(new JSONSerializer().exclude("*.class").deepSerialize(new ResponseError(-2, "Sorry, you were not registered.")));
				}
			} else {
				builder.append(new JSONSerializer().exclude("*.class").deepSerialize(new ResponseError(-3, "No user found.")));
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