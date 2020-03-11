package com.niit.crudApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static com.niit.MovieBooking.Connection.ConnectionJDBC.getConnection;

public class OperationsAdmin {
	Scanner s = new Scanner(System.in);
	private String name, password;
	AdminDetails ad;
	static int id = 0;
	Movies mov = new Movies();

	OperationsAdmin() {
		ad = new AdminDetails("hardeep", "1234", "MAIN");

	}

	boolean loginAdmin() {

		System.out.println("Enter Admin Username :");
		name = s.next();
		System.out.println("Enter Password :");
		password = s.next();

		if ((name.toLowerCase().equals(ad.getName()) && password.equals(ad.getPassword()))) {
			System.out.println("Welcome Admin");
			return true;
		} else
			return false;

	}
	
}