package org.example.steps;

import org.example.entities.ApiResponse;
import org.example.entities.User;
import org.example.service.UserService;

import java.util.List;

public final class UserServiceSteps {
    private static final UserService USER_SERVICE = UserService.getInstance();

    private UserServiceSteps() {
    }

    public static User getUserByName(String name) {
        return USER_SERVICE.getUserByName(name).as(User.class);
    }

    public static ApiResponse login(String userName, String password) {
        return USER_SERVICE.login(userName, password).as(ApiResponse.class);
    }

    public static ApiResponse logout() {
        return USER_SERVICE.logout().as(ApiResponse.class);
    }

    public static ApiResponse createUsersWithList(List<User> users) {
        return USER_SERVICE.createUsersWithList(users).as(ApiResponse.class);
    }

    public static ApiResponse createUser(User user) {
        return USER_SERVICE.createUser(user).as(ApiResponse.class);
    }

    public static ApiResponse updateUser(User user) {
        return USER_SERVICE.updateUser(user).as(ApiResponse.class);
    }

    public static void deleteUserByName(String name) {
        USER_SERVICE.deleteUserByName(name);
    }
}
