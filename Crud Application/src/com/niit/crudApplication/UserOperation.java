package com.niit.crudApplication;

import static com.niit.MovieBooking.Connection.ConnectionJDBC.getConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class UserOperation {
	Movies mv = new Movies();
	static int id = 0;
	String qry = "";
	Scanner input = new Scanner(System.in);
	static String name;
	String password;

	boolean loginUser() {

		try {
			System.out.println("Enter Username :");
			name = input.next();
			System.out.println("Enter Password :");
			password = input.next();

			qry = "SELECT customer_id,name,password FROM customer WHERE name= ? AND password= ?";
			PreparedStatement pstm = getConnection().prepareStatement(qry);
			pstm.setString(1, name);
			pstm.setString(2, password);
			ResultSet resultSet = pstm.executeQuery();
			resultSet.next();
			id = resultSet.getInt(1);
			if ((resultSet.getString(2).toLowerCase()).equals(name.toLowerCase())
					&& resultSet.getString(3).equals(password)) {
				return true;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	void rUserOperation() {
		if (id != 0) {

			System.out.println("\nWelcome User " + name);
			System.out.println(
					"Select Yout Choice\n1:->\tBook movie\n2:->\tWatch Booked movies\n3:->\tSerch Movie \n 4:-> \t Edit your profile \n5:->\tView Your Detail");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				mv.showMovies();
				bookMovie();
				break;
			case 2:
				showBookedMovies();
				break;
			case 3:
				System.out.println("Enter movie name");
				String name = input.next();
				mv.searchMovie(name);
				break;

			case 4:
				updateUserDetail();
				showUserDeatil();

				break;
			case 5:
				showUserDeatil();
				break;

			default:
				break;

			}

		} else
			System.out.println("Sorry First Register");
		
	}

	void bookMovie() {

		int numberOfSeats;
		int payment = 200;
		int movieID;
		System.out.println("Enter movie ID");
		movieID = input.nextInt();
		System.out.println("Number of seats for movie");
		numberOfSeats = input.nextInt();
		try {
			String qry = "INSERT INTO booking(Total_Seats,movie_id,customer_id,payment_status,Total_payment,booking_datetime,Transaction_id) "
					+ "VALUES(?,?,?,?,?,now(),?)";
			PreparedStatement pst = getConnection().prepareStatement(qry);
			pst.setInt(1, numberOfSeats);
			pst.setInt(2, movieID);
			pst.setInt(3, id);
			pst.setInt(4, 1);
			pst.setInt(5, (payment * numberOfSeats));
			pst.setString(6, String.valueOf(randomReciptGenerator()));
			// int result = pst.executeUpdate();
			int result = 1;
			if (result > 0) {
				System.out.println("-----Movie Booking --System \n Movie Name \n\t" + getMovieName(id) + "\n For Seats"
						+ numberOfSeats + "\nTotal Ammount:" + (payment * numberOfSeats));
			} else
				System.out.println("Not DONE");

		} catch (Exception e) {
			System.out.println(e);
		}
		continueBlock();
	}

//Show USer Detail
	void showUserDeatil() {
		System.out.println("Name\t|Email ID\t|Phone Number\t|Date of Birth\t|City\t|Interest");
		qry = "Select name,email_id,phone_No,DOB,City,Interst from customer where customer_id=" + id;
		try {
			Statement s = getConnection().createStatement();

			ResultSet rs = s.executeQuery(qry);
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t|" + rs.getString(2) + "\t|" + rs.getString(3) + "\t|"
						+ rs.getString(4) + "\t|" + rs.getString(5) + "\t|" + rs.getString(6));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

//Update User Detail
	void updateUserDetail() {
		showUserDeatil();
		qry = "UPDATE Customer SET Name= ? , Email_id=?,phone_no=?,DOB=?,City=?,Interst=?";
		System.out.println("\n All fields are Necessary \nEnter name");
		String name = input.next();
		System.out.println("Enter Email ID");
		String email = input.next();
		System.out.println("Enter Phone Number");
		String phone = input.next();
		System.out.println("Date of Birth");
		String dob = input.next();
		System.out.println("Enter City");
		String city = input.next();
		System.out.println("Enter inturst");
		String intrst = input.next();

		try {
			PreparedStatement update = getConnection().prepareStatement(qry);
			update.setString(1, name);
			update.setString(2, email);
			update.setString(3, phone);
			update.setString(4, dob);
			update.setString(5, city);
			update.setString(6, intrst);
			int i = update.executeUpdate();
			if (i > 0) {
				System.out.println("Done");

			} else
				System.out.println("Not done");

		} catch (Exception e) {
			System.out.println(e);
		}
		continueBlock();
	}

//booked movie
	void showBookedMovies() {
		System.out.println("Name \tMovie Name\tTiming\tBooking ID\tTotal Payment");
		qry = "SELECT NAME,Movie_name,Timing,Booking_id,Total_payment From show_details WHERE customer_id = " + id;
		try {
			Statement s = getConnection().createStatement();

			ResultSet rs = s.executeQuery(qry);
			if (rs.next() == true) {
				while (rs.next())
					System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
							+ rs.getString(4) + "\t" + rs.getString(5));
			} else
				System.out.println("No data Here");
		} catch (Exception e) {
			System.out.println("Error" + e);

		}
		continueBlock();

	}

	int randomReciptGenerator() {
		int r = 15000;
		return (r + (int) (Math.random() * (9199)));
	}

	String getMovieName(int id) {
		qry = "SELECT NAME From movie WHERE Movie_id = ?";
		try {
			PreparedStatement s = getConnection().prepareStatement(qry);
			s.setInt(1, id);
			ResultSet rs = s.executeQuery(qry);
			;
			if (rs.next() != false) {
				return rs.getString(1);
			} else
				System.out.println(rs.getString(1));
		} catch (Exception e) {
			System.out.println("Error" + e);
			return "false";
		}
		return "Error Occure";
		

	}

	void addUsers() {
		UserDetail ud;
		String uname, uEmail, uPhoneNumber, uDOB, uPassword, uCPassword, uCity, uInterst;
		System.out.println("Lets Know About you to make you in :-)\n");
		System.out.println("Enter your name");
		uname = input.next();
		System.out.println("Enter Your Email");
		uEmail = input.next();
		System.out.println("Enter your phone number");
		uPhoneNumber = input.next();
		System.out.println("Enter your Date of Birth");
		uDOB = input.next();
		System.out.println("Enter Password");
		uPassword = input.next();
		System.out.println("Confirm Password");
		uCPassword = input.next();
		System.out.println("Enter City");
		uCity = input.next();
		System.out.println("Which type of movie you like ");
		uInterst = input.next();
		if (uPassword.equals(uCPassword)) {
			ud = new UserDetail(uname, uEmail, uPhoneNumber, uDOB, uPassword, uCity, uInterst);
			String sql = "INSERT INTO CUSTOMER(name,Email_id,phone_no,DOB,Password,city,Interst) Values(?,?,?,?,?,?,?)";
			try {
				PreparedStatement pr = getConnection().prepareStatement(sql);
				pr.setString(1, ud.getUname());
				pr.setString(2, ud.getuEmail());
				pr.setString(3, ud.getuPhoneNumber());
				pr.setString(4, ud.getuDOB());
				pr.setString(5, ud.getuPassword());
				pr.setString(6, ud.getuCity());
				pr.setString(7, ud.getuInterst());
				int result = pr.executeUpdate();
				if (result > 0)
					System.out.println("Done");
				else
					System.out.println("not done logical Error");
			} catch (Exception e) {
				System.out.println(e);
			}
		} else
			System.out.println("PASsword SHouild BE same ");
	}

//Continue block
	void continueBlock() {
		char choice = 'y';

		do {
			System.out.println("Do you want to continue press y for yes and n for no");
			choice = input.next().charAt(0);

			if (choice == 'y') {
				rUserOperation();
			} else if (choice == 'n') {
				break;

			} else
				System.out.println("Plz select Valid choice");
		} while (choice == 'y');
	}
}
