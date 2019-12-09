package com.eldarian.userbanklist.service;

import com.eldarian.userbanklist.dao.AccountDao;
import com.eldarian.userbanklist.dao.AccountDaoImpl;
import com.eldarian.userbanklist.dao.UserDao;
import com.eldarian.userbanklist.dao.UserDaoImpl;
import com.eldarian.userbanklist.model.Account;
import com.eldarian.userbanklist.model.User;

import java.util.List;

public class ServiceImpl implements Service {
    private final UserDao userDao = new UserDaoImpl();
    private final AccountDao accountDao = new AccountDaoImpl();

    public User getUserById(int id) {
        System.out.println(userDao.getUserById(id));
        return userDao.getUserById(id);
    }

    public String getRichestUser() {
        List<User> users = userDao.getAllUsers();
        User richest = new User();
        int maxSum = 0;
        for (User user : users) {
            List<Account> userAccounts = accountDao.getAccountsByUser(user.getUserId());
            int usersSum = 0;
            for (Account account : userAccounts) {
                usersSum += account.getAccount();
            }
            if (usersSum > maxSum) {
                maxSum = usersSum;
                richest = user;
            }
        }
        return richest.getName() + " " + richest.getSurname();
    }

    @Override
    public int getAccountsSum() {
        List<Account> accounts = accountDao.getAllAccounts();
        int sum = 0;
        for (Account account : accounts) {
            sum += account.getAccount();
        }
        return sum;
    }
}
