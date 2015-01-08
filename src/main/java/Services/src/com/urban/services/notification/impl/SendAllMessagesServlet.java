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

import com.urban.data.Action;
import com.urban.data.User;
import com.urban.data.dao.DAO;
import com.urban.services.notification.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Servlet that adds a new message to all registered devices.
 * <p/>
 * This servlet is used just by the browser (i.e., not device).
 */
@SuppressWarnings("serial")
public class SendAllMessagesServlet extends BaseServlet {

    private static final int MULTICAST_SIZE = 1000;

    private Sender sender;

    private static final Executor threadPool = Executors.newFixedThreadPool(5);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        sender = newSender(config);
    }

    /**
     * Creates the {@link Sender} based on the servlet settings.
     */
    protected Sender newSender(ServletConfig config) {
        String key = (String) config.getServletContext().getAttribute(ApiKeyInitializer.ATTRIBUTE_ACCESS_KEY);
        return new Sender(key);
    }

    private List<String> getSubscribedDevices(Action action) {
        List<String> devices = new ArrayList<String>();
        Set<User> users = action.getOrganization().getSubscribers();
        for (User user : users) {
            devices.add(user.getRegId());
        }
        return devices;
    }

    /**
     * Processes the request to add a new message.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        StringBuilder builder = new StringBuilder();
        for (Action action : getActions()) {
            Message message = getActionMessage(action);
            List<String> devices = getSubscribedDevices(action);
            if (devices.isEmpty()) {
                builder.append("<br>");
                builder.append("No subscribers for sending message: " + action.getSubject());
            } else {
                int total = devices.size();
                List<String> partialDevices = new ArrayList<String>(total);
                int counter = 0;
                int tasks = 0;
                for (String device : devices) {
                    counter++;
                    partialDevices.add(device);
                    int partialSize = partialDevices.size();
                    if (partialSize == MULTICAST_SIZE || counter == total) {
                        asyncSend(message, partialDevices);
                        partialDevices.clear();
                        tasks++;
                    }
                }
                builder.append("<br>");
                builder.append("Asynchronously sending " + tasks + " multicast messages to " + total + " devices: " + action.getSubject());
            }
        }
        if (builder.toString().isEmpty()) {
            builder.append("<br>");
            builder.append("No messages sent");
        }
        builder.insert(0, "Result:");
        req.setAttribute(HomeServlet.ATTRIBUTE_STATUS, builder.toString());
        getServletContext().getRequestDispatcher("/home").forward(req, resp);
    }

    private MulticastResult sendMessageToDevices(Message message, List<String> devices) throws IOException {
        return sender.send(message, devices, 5);

    }

    private void asyncSend(final Message message, final List<String> devices) {
        threadPool.execute(new Runnable() {
            public void run() {
                MulticastResult multicastResult = null;
                try {
                    multicastResult = sendMessageToDevices(message, devices);
                    List<Result> results = multicastResult.getResults();
                    // analyze the results
                    processResults(results, devices);
                } catch (IOException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }
        });
    }

    private void processResults(List<Result> results, List<String> devices) {
        for (int i = 0; i < devices.size(); i++) {
            String regId = devices.get(i);
            Result result = results.get(i);
            String messageId = result.getMessageId();
            if (messageId != null) {
                logger.fine("Succesfully sent message to device: " + regId + "; messageId = " + messageId);
                String canonicalRegId = result.getCanonicalRegistrationId();
                if (canonicalRegId != null) {
                    // same device has more than on registration id: update it
                    logger.info("canonicalRegId " + canonicalRegId);
                    Datastore.updateRegistration(regId, canonicalRegId);
                }
            } else {
                String error = result.getErrorCodeName();
                if (error.equals(Constants.ERROR_NOT_REGISTERED)) {
                    // application has been removed from device - unregister it
                    logger.info("Unregistered device: " + regId);
                    Datastore.unregister(regId);
                } else {
                    logger.severe("Error sending message to " + regId + ": " + error);
                }
            }
        }
    }


    private static Collection<Action> getActions() {
        Collection<Action> actions = DAO.getAll(Action.class);
        return actions;
    }

    private Message getActionMessage(Action action) {
        return new Message.Builder()
                .addData("id", "" + action.getId())
                .addData("start_date", THREAD_LOCAL_DATE_FORMAT.get().format(action.getStartDate()))
                .addData("end_date",
                        action.getEndDate() != null
                            ? THREAD_LOCAL_DATE_FORMAT.get().format(action.getEndDate())
                            : null)
                .addData("subject", action.getSubject())
                .addData("organization_id", "" + action.getOrganization().getId())
                .build();
    }

    private static final ThreadLocal<DateFormat> THREAD_LOCAL_DATE_FORMAT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("dd-MM-yyyy");
        }
    };

}
