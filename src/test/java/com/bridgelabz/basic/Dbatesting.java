package com.bridgelabz.basic;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Dbatesting extends BaseClass {
    @Test
    public void dbTest_ExecuteSelectData() throws SQLException, ClassNotFoundException {
        connection = this.setUp();
        System.out.println("Connection established");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("select * from uploadcsv");

        while(resultset.next()){
            String state = resultset.getString(1);
            int population =  resultset.getInt(2);
            int area =  resultset.getInt(3);
            int density =  resultset.getInt(4);
            String stateCode=  resultset.getString(5);
            System.out.println(state + " " + population + " " + area + " " + density + " " + stateCode);
        }
        System.out.println("Getting all upload data table");
    }

    @Test
    public void dbTest_InsertData() throws SQLException, ClassNotFoundException {
        connection = this.setUp();
        PreparedStatement preparedStatement = connection.prepareStatement("Insert into Indian values(?,?,?,?,?)");
        preparedStatement.setString(1, "Maharashtra");
        preparedStatement.setInt(2,100000);
        preparedStatement.setInt(3,4000);
        preparedStatement.setInt(4,300);
        preparedStatement.setString(5,"MH");
        System.out.println("Successfully inserted");

    }
    @Test
    public void dbTest_UpdateData() throws SQLException, ClassNotFoundException {
        connection = this.setUp();
        PreparedStatement preparedStatement = connection.prepareStatement("update Indian set Area=(?) where StateCode=(?)");
        preparedStatement.setString(2, "MH");
        preparedStatement.setInt(1,600);
        preparedStatement.executeUpdate();
        System.out.println("Updated successfully !!");
    }

    @Test
    public void dbTest_DeleteData() throws SQLException, ClassNotFoundException {
        connection = this.setUp();
        System.out.println("Connection established");
        PreparedStatement preparedStatement = connection.prepareStatement("delete from indian where StateCode=(?)");
        preparedStatement.setString(1, "MH");
        System.out.println("Getting all deleted data successfully");
    }
}


