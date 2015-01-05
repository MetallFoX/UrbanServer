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

import com.google.gson.*;
import com.urban.data.NotificationSubscribe;
import com.urban.data.Person;
import com.urban.data.dao.DAO;
import com.urban.data.dao.UrbanCriterion;
import com.urban.services.ServletHelper;
import com.urban.services.error.ResponseError;
import flexjson.JSONSerializer;
import src.com.urban.data.sqlite.pojo.NotificationSubscribePojo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Subscribe extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static final String PARAMETER_REG_ID = "regId";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String reqStr = ServletHelper.streamToStr(request.getInputStream());
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Person.class, new InterfaceAdapter<Person>())
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();


        NotificationSubscribePojo subscribe = gson.fromJson(reqStr, NotificationSubscribePojo.class);
        StringBuilder builder = new StringBuilder();
        if (subscribe != null) {

            UrbanCriterion criterion = DAO.createCriterion(NotificationSubscribe.class);
            criterion = criterion.and(
                    criterion.eq("user", subscribe.getUser().getId()),
                    criterion.eq("organization", subscribe.getOrganization().getId()));

            //Проверяем, есть ли подписка.
            NotificationSubscribe foundSubscribe = DAO.getUniqByCriterion(NotificationSubscribe.class, criterion);
            if (foundSubscribe != null) {
                builder.append(new JSONSerializer().exclude("*.class").deepSerialize(new ResponseError(-1, "You are already subscribed on this organization")));
            } else {
                try {
                    DAO.save(subscribe);
                    builder.append(new JSONSerializer().deepSerialize(subscribe));
                } catch (SQLException e) {
                    builder.append(new JSONSerializer().exclude("*.class").deepSerialize(new ResponseError(-2, "Sorry, problem with database.")));
                }
            }

        } else {
            builder.append(new JSONSerializer().exclude("*.class").deepSerialize(new ResponseError(-3, "Sorry! Nothing to subscribe!")));
        }

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


    private static class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
        private final DateFormat dateFormat;

        private DateTypeAdapter() {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
        }

        @Override public synchronized JsonElement serialize(Date date, Type type,
                                                            JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(dateFormat.format(date));
        }

        @Override public synchronized Date deserialize(JsonElement jsonElement, Type type,
                                                       JsonDeserializationContext jsonDeserializationContext) {
            try {
                return dateFormat.parse(jsonElement.getAsString());
            } catch (ParseException e) {
                throw new JsonParseException(e);
            }
        }
    }


}
