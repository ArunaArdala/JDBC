package com.telusko.jdbclearning_CreateStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HandlingExceptions {

	public static void main(String[] args) {
		
		Connection connect = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish the connection
			String url="jdbc:mysql://localhost:3306/jdbclearning";
			String user = "root";
			String password = "root";
			 connect = DriverManager.getConnection(url,user,password);
			
			//creating the statement
			 statement = connect.createStatement();
			
			//execute query
			String sql = "UPDATE studentinfo SET sage = 25 where sname = 'Krishna'";
			int rowAffected = statement.executeUpdate(sql);
			
			//Process the query
			if(rowAffected == 0)
			{
				System.out.println("Operation fail");
			}
			else
			{
				System.out.println("Operation Sucessfull");
			}
			
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
