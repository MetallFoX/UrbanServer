package com.urban.services;

import com.google.gson.Gson;
import com.urban.data.User;
import com.urban.data.dao.DAO;
import com.urban.data.dao.UrbanCriterion;
import com.urban.data.jdbc.pojo.UserPojo;
import com.urban.services.error.ResponseError;
import flexjson.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SignInServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("application/json;charset=utf-8");
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			builder.append(line);
		}

		Gson gson = new Gson();
		User user = gson.fromJson(builder.toString(), UserPojo.class);

		builder = new StringBuilder();
		
		if (user != null) {
			UrbanCriterion criterion = DAO.createCriterion(User.class);
			criterion = criterion.and(
					criterion.eq("login", user.getLogin()),
					criterion.eq("password", user.getPassword()));

            //Ищем пользователя среди зарегистрированных.
			User foundUser = DAO.getUniqByCriterion(User.class, criterion);
			if (foundUser == null) {
                builder.append(new JSONSerializer().exclude("*.class").deepSerialize(new ResponseError(-1, "No registered user with the same login and password.")));
			} else {
                //FIXME: Some nulls within serialized string instead correct values.
                builder.append(new JSONSerializer().deepSerialize(user));
			}
		}
		
		PrintWriter pw = response.getWriter();
		pw.println(builder.toString());
	
    }
	
}