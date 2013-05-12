/*
 * $Id: MailreaderSupport.java 582626 2007-10-07 13:26:12Z mrdon $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.mmdrama.core.web;

import java.util.Map;


import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

/**
 * <p> Base Action for MailreaderSupport application. </p>
 * <p/>
 * <p> Note that this class does NOT implement model driven because of the way
 * the pre-existing model is designed. The MailReader DAO includes immutable
 * fields that can only be set on construction, and some objects do not have a
 * default construction. One approach would be to mirror all the DAO
 * properties on the Actions. As an alternative, this implementations uses the
 * DAO properties where possible, and uses local Action properties only as
 * needed. To create new objects, a blank temporary object is constructed, and
 * the page uses a mix of local Action properties and DAO properties. When the
 * new object is to be saved, the local Action properties are used to create
 * the object using the DAO factory methods, the input values are copied from
 * the temporary object, and the new object is saved. It's kludge, but it
 * avoids creating unnecessary local properties. Pick your poison.</p>
 */
public class CommonActionSupport extends ActionSupport
        implements SessionAware, ApplicationAware {

    /**
     * Return CANCEL so apropriate result can be selected.
     * @return "cancel" so apropriate result can be selected.
     */



    // ---- ApplicationAware ----

    /**
     * <p>Field to store application context or its proxy.</p>
     * <p/>
     * <p>The application context lasts for the life of the application. A
     * reference to the database is stored in the application context at
     * startup.</p>
     */
    private Map application;

    /**
     * <p>Store a new application context.</p>
     *
     * @param value A Map representing application state
     */
    public void setApplication(Map value) {
        application = value;
    }

    /**
     * <p>Provide application context.</p>
     */
    public Map getApplication() {
        return application;
    }

    // ---- SessionAware ----

    /**
     * <p>Field to store session context, or its proxy.</p>
     */
    private Map session;

    /**
     * <p>Store a new session context.</p>
     *
     * @param value A Map representing session state
     */
    public void setSession(Map value) {
        session = value;
    }

    /**
     * <p>Provide session context.</p>
     *
     * @return session context
     */
    public Map getSession() {
        return session;
    }

    // ---- Task property (utilized by UI) ----

    /**
     * <p>Field to store workflow task.</p>
     * <p/>
     * <p>The Task is used to track the state of the CRUD workflows. It can be
     * set to Constant.CREATE, Constant.EDIT, or Constant.DELETE as
     * needed.</p>
     */
    private String task = null;


    /**
     * <p>Provide worklow task.</p>
     *
     * @return Returns the task.
     */
    public String getTask() {
        return task;
    }

    /**
     * <p>Store new workflow task.</p>
     *
     * @param value The task to set.
     */
    public void setTask(String value) {
        task =  value;
    }

    // ---- Token property (utilized by UI) ----

    /**
     * <p>Field to store double-submit guard.</p>
     */
    private String token = null;


    /**
     * <p>Provide Token.</p>
     *
     * @return Returns the token.
     */
    public String getToken() {
        return token;
    }

    /**
     * <p>Store new Token.</p>
     *
     * @param value The token to set.
     */
    public void setToken(String value) {
        token =  value;
    }


    // ---- Host property ----

    /**
     * <p>Field to store Subscription host.</p>
     * <p/>
     * <p> The host is an immutable property of the Subscrtion DAP object, so
     * we need to store it locally until we are ready to create the
     * Subscription. </p>
     */
    private String host;

    /**
     * <p>Provide tSubscription host.</p>
     *
     * @return host property
     */
    public String getHost() {
        return host;
    }

    /**
     * <p>Store new Subscription host.</p>
     *
     * @param value
     */
    public void setHost(String value) {
        host = value;
    }

    // ---- Password property ----

    /**
     * <p>Field to store User password property.</p>
     * <p/>
     * <p>The User DAO object password proerty is immutable, so we store it
     * locally until we are ready to create the object.</p>
     */
    private String password = null;


    /**
     * <p>Provide User password</p>
     *
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>Store new User Password</p>
     *
     * @param value The password to set.
     */
    public void setPassword(String value) {
        password = value;
    }

    // ---- Password2 property (confirmation) ----

    /**
     * <p>Field to store the User password confirmation.</p>
     * <p/>
     * <p>When a User object is created, we ask the client to enter the
     * password twice, to help ensure the password is being typed
     * correctly.</p>
     */
    private String password2 = null;


    /**
     * <p>Provide the User password confirmation.</p>
     *
     * @return Returns the confirmationpassword.
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * <p>Store a new User password confirmation.</p>
     *
     * @param value The confirmation password to set.
     */
    public void setPassword2(String value) {
        password2 = value;
    }

    // ---- Username property ----

    /**
     * <p>Field to store User username.</p>
     * <p/>
     * <p>The User DAO object password proerty is immutable, so we store it
     * locally until we are ready to create the object.</p>
     */
    private String username = null;


    /**
     * <p>Provide User username.</p>
     *
     * @return Returns the User username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * <p>Store new User username</p>
     *
     * @param value The username to set.
     */
    public void setUsername(String value) {
        username = value;
    }

    // ---- Database property ----

    /**
     * <p>Provide reference to UserDatabase, or null if the database is not
     * available. </p>
     *
     * @return a reference to the UserDatabase or null if the database is not
     *         available
     */


}
