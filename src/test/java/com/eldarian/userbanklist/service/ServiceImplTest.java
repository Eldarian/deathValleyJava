package com.eldarian.userbanklist.service;

import com.eldarian.userbanklist.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceImplTest {
    ServiceImpl testService = new ServiceImpl();

    @Test
    public void getUserById() {
        User testUser = new User();
        testUser.setUserId(1);
        testUser.setName("Jack");
        testUser.setSurname("Wolf");
        assertEquals(testUser, testService.getUserById(1));
    }

    @Test
    public void getRichestUser() {
    }

    @Test
    public void getAccountsSum() {
    }
}