package com.telusko.jdbclearning_CreateStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteOperation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the connection
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "root";
		Connection connect = DriverManager.getConnection(url,user,password);
		
		//creating the statement
		Statement statement = connect.createStatement();
		
		String sql = "SELECT * FROM studentinfo";
		boolean status = statement.execute(sql);
		
		if(status)
		{
		   ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next())
			{
//				int id = rs.getInt(1);
				System.out.print((rs.getInt(1))+" "); //rs.getInt("id")
				System.out.print(rs.getString(2)+" "); //rs.getString("sname")
				System.out.print(rs.getInt(3)+" "); //rs.getInt("sage") can you either of paramas
				System.out.println(rs.getString(4));
			}
			
		}
		else
		{
			int rowAffected = statement.getUpdateCount();
			if(rowAffected == 0)
			{
				System.out.println("Operation fail");
			}
			else
			{
				System.out.println("Operation Sucessfull");
			}
		}
		
		
		
		
	}

}
