package org.example.service;

import io.restassured.response.Response;
import org.example.service.uritemplate.UriTemplate;

public final class UserService extends CommonService {
    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
    }

    public static final UriTemplate USER_CREATE_WITH_LIST = new UriTemplate("user/createWithList");
    public static final UriTemplate USER = new UriTemplate("user");
    public static final UriTemplate USER_BY_NAME = new UriTemplate("user/%s");
    public static final UriTemplate USER_LOGIN = new UriTemplate("user/login?username=%s&password=%s");
    public static final UriTemplate USER_LOGOUT = new UriTemplate("user/logout");

    public Response getUserByName(String name) {
        return super.getRequest(USER_BY_NAME.getUri(name));
    }

    public Response createUsersWithList(Object body) {
        return super.postRequest(USER_CREATE_WITH_LIST.getUri(), body);
    }

    public Response createUser(Object body) {
        return super.postRequest(USER.getUri(), body);
    }

    public Response login(String userName, String password) {
        return super.getRequest(USER_LOGIN.getUri(userName, password));
    }

    public Response logout() {
        return super.getRequest(USER_LOGOUT.getUri());
    }

    public Response updateUser(Object body) {
        return super.putRequest(USER.getUri(), body);
    }

    public void deleteUserByName(String name) {
        super.deleteRequest(USER_BY_NAME.getUri(name));
    }
}
