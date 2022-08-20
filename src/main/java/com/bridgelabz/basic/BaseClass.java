package com.bridgelabz.basic;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {

    public static Connection connection;

    @BeforeTest
    public static Connection setUp() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/uploadcsv";
        String username = "root";
        String password = "tiger";

        Class.forName("com.mysql.cj.jdbc.Driver");

        return connection = DriverManager.getConnection(url, username, password);
    }

    @AfterTest
    protected void tearDown() throws SQLException{
        if (connection != null){
            try{
                System.out.println("Closing Database Connection.....");
                connection.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
