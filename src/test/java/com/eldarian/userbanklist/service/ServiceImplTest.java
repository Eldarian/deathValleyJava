package com.eldarian.userbanklist.service;

import com.eldarian.userbanklist.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceImplTest {
    private ServiceImpl testService = new ServiceImpl();

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
        assertEquals("Bob Gale", testService.getRichestUser());
    }

    @Test
    public void getAccountsSum() {
        assertEquals(570, testService.getAccountsSum());
    }
}