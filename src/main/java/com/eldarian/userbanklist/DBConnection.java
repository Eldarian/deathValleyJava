package com.eldarian.userbanklist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/userbanklist?serverTimezone=GMT&useSSL=false";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root1";

    public static Connection createConnection() {
        Connection connection = null;

        try
        {
            try {
                Class.forName(JDBC_DRIVER);
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Printing connection object" + connection);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}