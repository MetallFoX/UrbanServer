/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.urban.services.notification.impl;

import com.google.gson.Gson;
import com.urban.data.NotificationSubscribe;
import com.urban.data.User;
import com.urban.data.dao.DAO;
import com.urban.data.dao.UrbanCriterion;
import com.urban.data.jdbc.pojo.NotificationSubscribePojo;
import com.urban.data.jdbc.pojo.UserPojo;
import com.urban.services.ServletHelper;
import com.urban.services.error.ResponseError;
import flexjson.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Subscribe extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static final String PARAMETER_REG_ID = "regId";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String reqStr = ServletHelper.streamToStr(request.getInputStream());
        //Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new InterfaceAdapter<Person>()).create();
        Gson gson = null;

        User user = gson.fromJson(reqStr, UserPojo.class);

        StringBuilder builder = new StringBuilder();

        if (user != null) {

            UrbanCriterion criterion = DAO.createCriterion(NotificationSubscribe.class);
            criterion = criterion.and(
                    criterion.eq("user", user.getId()),
                    criterion.eq("organization", user.getId()));

            //Проверяем, есть ли подписка.
            NotificationSubscribe foundSubscribe = DAO.getUniqByCriterion(NotificationSubscribe.class, criterion);
            if (foundSubscribe != null) {

            } else {
                NotificationSubscribePojo subscribe = new NotificationSubscribePojo();
                subscribe.setUser((UserPojo)user);
                subscribe.setOrganization(null);
                try {
                    DAO.save(subscribe);
                    builder.append(new JSONSerializer().deepSerialize(subscribe));
                } catch (SQLException e) {
                    builder.append(new JSONSerializer().exclude("*.class").deepSerialize(new ResponseError(-1, "Sorry, problem with database.")));
                }
            }

        } else {
            builder.append(new JSONSerializer().exclude("*.class").deepSerialize(new ResponseError(-2, "Sorry!")));
        }

    }

}
