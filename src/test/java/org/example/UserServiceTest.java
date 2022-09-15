package org.example;

import org.example.entities.User;
import org.example.steps.UserServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Random;

public class UserServiceTest {

    @Test
    public void createUsersWithListTest() {
        // given, when
        User expectedUser = createUser();
        UserServiceSteps.createUsersWithList(Collections.singletonList(expectedUser));
        // then
        User createdUser = UserServiceSteps.getUserByName(expectedUser.getUsername());
        Assert.assertEquals(createdUser, expectedUser.setId(createdUser.getId()), "Expected user does not match created one");
    }

    @Test
    public void createUserTest() {
        // given, when
        User expectedUser = createUser();
        UserServiceSteps.createUser(expectedUser);
        // then
        User createdUser = UserServiceSteps.getUserByName(expectedUser.getUsername());
        Assert.assertEquals(createdUser, expectedUser.setId(createdUser.getId()), "Expected user does not match created one");
    }

    private User createUser() {
        Random random = new Random();
        return new User()
                .setUsername("nick_" + random.nextInt())
                .setPassword("password")
                .setFirstName("James")
                .setLastName("Bond")
                .setEmail("james.bond@gmail.com")
                .setPhone("11-22-33")
                .setUserStatus(0);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void deleteUserByNameTest() {
        // given
        User expectedUser = createUser();
        UserServiceSteps.createUser(expectedUser);
        // when
        UserServiceSteps.deleteUserByName(expectedUser.getUsername());
        // then (it should fail)
        UserServiceSteps.getUserByName(expectedUser.getUsername());
    }

    @Test
    public void updateUserTest() {
        // given
        User expectedUser = createUser();
        UserServiceSteps.createUser(expectedUser);
        User updatedUser = UserServiceSteps.getUserByName(expectedUser.getUsername()).setPhone("22-33-44");
        // when
        UserServiceSteps.updateUser(updatedUser);
        // then
        User actualUser = UserServiceSteps.getUserByName(updatedUser.getUsername());
        Assert.assertEquals(actualUser, updatedUser.setId(actualUser.getId()), "Expected user does not match updated one");
    }
}
