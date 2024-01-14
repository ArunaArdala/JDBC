package com.telusko.jdbclearning_CreateStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValues {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//load and register the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Establish the connection
				String url="jdbc:mysql://localhost:3306/jdbclearning";
				String user = "root";
				String password = "root";
				Connection connect = DriverManager.getConnection(url,user,password);
				
				//creating the statement
				Statement statement = connect.createStatement();
				
				//execute query
				String sql = "INSERT INTO studentinfo(id,sname,sage,scity) VALUES(3,'Krishna',26,'hyd')";
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
				
				//close the connection
				statement.close();
				connect.close();
				
	}

}
