package com.eldarian.userbanklist.dao;

import com.eldarian.userbanklist.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(int id);
    List<User> getAllUsers();
}
