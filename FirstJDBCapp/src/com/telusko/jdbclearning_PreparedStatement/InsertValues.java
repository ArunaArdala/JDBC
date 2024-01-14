package com.telusko.jdbclearning_PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertValues {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the connection
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "root";
		Connection connect = DriverManager.getConnection(url,user,password);
		
		String query = "INSERT INTO studentinfo(id,sname,sage,scity) VALUES(?,?,?,?)";
		PreparedStatement prpstmt = connect.prepareStatement(query);
		
		System.out.println("Please enter the following details to be stoored int DB");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		Integer id = sc.nextInt();
		
		System.out.println("Enter name");
		String name = sc.next();
		
		System.out.println("Enter age");
		Integer age = sc.nextInt();
		
		System.out.println("Enter city");
		String city = sc.next();
		
		prpstmt.setInt(1, id);
		prpstmt.setString(2, name);
		prpstmt.setInt(3, age);
		prpstmt.setString(4, city);
		
		int rowAffected = prpstmt.executeUpdate();
		if(rowAffected == 0)
		{
			System.out.println("Operation fail");
		}
		else
		{
			System.out.println("Operation Sucessfull");
		}
		
		prpstmt.close();
		connect.close();
		sc.close();
		
	}

}
