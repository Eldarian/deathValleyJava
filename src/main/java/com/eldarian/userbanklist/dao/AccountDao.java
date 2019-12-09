package com.eldarian.userbanklist.dao;

import com.eldarian.userbanklist.model.Account;

import java.util.List;

public interface AccountDao {
    List<Account> getAllAccounts();
    List<Account> getAccountsByUser(int userId);
}
