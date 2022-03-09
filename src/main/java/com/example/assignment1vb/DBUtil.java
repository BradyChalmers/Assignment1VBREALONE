package com.example.assignment1vb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

public class DBUtil {

    //define database variables
    private String jdbcURL = "jdbc:mysql://localhost:3306/canadacensusdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    //define sql statement for login
    private static final String SELECT_USER_VALIDATION = "select iduser from user where userName =? and password = ?;";

    public DBUtil() {}

    //create connection to database
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    //database stuff
    public static DBUtil instances;

    public static DBUtil getInstances() {
        return (instances == null)? instances = new DBUtil() : instances;
    }

    //login method, takes variables given on login screen and runs the sql to check database for existance for user
    public boolean selectUser(String userNameInput, String passwordInput) {
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_VALIDATION)) {
            preparedStatement.setString(1, userNameInput);
            preparedStatement.setString(2, passwordInput);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    if (rs.getInt(1) == 1) {
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }
}