package com.niit.MovieBooking.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.252.196:3306/Movie_booking", "root", "root");
			return con;
		} catch (Exception e) {
			System.out.println(e);

		}
		return null;
	}
}
