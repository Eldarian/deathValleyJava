package com.eldarian.userbanklist.dao;

import com.eldarian.userbanklist.DBConnection;
import com.eldarian.userbanklist.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private Connection connection = DBConnection.createConnection();
    private final String SQL_GET_ALL_ACCOUNTS = "SELECT * FROM account";
    private final String SQL_GET_ACCOUNTS_BY_USER_ID = "SELECT * FROM account WHERE userid=?";

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new LinkedList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_ACCOUNTS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            setAccountListFromResultSet(accounts, resultSet);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public List<Account> getAccountsByUser(int userId) {
        List<Account> accounts = new LinkedList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ACCOUNTS_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                setAccountListFromResultSet(accounts, resultSet);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    private void setAccountListFromResultSet(List<Account> accounts, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Account account = new Account();
            account.setAccountId(resultSet.getInt("accountid"));
            account.setAccount(resultSet.getInt("account"));
            account.setUserId(resultSet.getInt("userid"));
            accounts.add(account);
        }
    }
}
