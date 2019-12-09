package com.eldarian.userbanklist.dao;

import com.eldarian.userbanklist.DBConnection;
import com.eldarian.userbanklist.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final Connection connection = DBConnection.createConnection();
    private final String SQL_GET_USER_BY_ID = "SELECT * FROM user WHERE userId=?";
    private final String SQL_GET_ALL_USERS = "SELECT * FROM user";

    @Override
    public User getUserById(int id) {
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    setUserFromResultSet(user, resultSet);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new LinkedList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_USERS);
                ResultSet resultSet = preparedStatement.executeQuery();) {
            while (resultSet.next()) {
                User user = new User();
                setUserFromResultSet(user, resultSet);
                users.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private void setUserFromResultSet(User user, ResultSet resultSet) throws SQLException {
        user.setUserId(resultSet.getInt("userid"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
    }


}
