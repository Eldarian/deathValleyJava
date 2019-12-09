package com.eldarian.userbanklist.service;

import com.eldarian.userbanklist.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceImplTest {
    private ServiceImpl testService = new ServiceImpl();

    @Test
    public void getUserById() {
        User expectedUser = new User();
        expectedUser.setUserId(1);
        expectedUser.setName("Jack");
        expectedUser.setSurname("Wolf");
        assertEquals(expectedUser, testService.getUserById(1));
    }

    @Test
    public void getRichestUser() {
        String expectedRichestUser = "Bob Gale";
        assertEquals(expectedRichestUser, testService.getRichestUser());
    }

    @Test
    public void getAccountsSum()
    {
        int expectedAccountSum = 570;
        assertEquals(expectedAccountSum, testService.getAccountsSum());
    }
}