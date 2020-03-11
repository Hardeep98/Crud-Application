package com.niit.crudApplication;

import static com.niit.MovieBooking.Connection.ConnectionJDBC.getConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Movies {
	Scanner input = new Scanner(System.in);

	void showMovies() {
		System.out.println("S.no\tNAME\t\tDescription\tRealese Date\tStarcast \tTiming");
		try {

			String qry = "SELECT * FROM Movie where Active = 1";
			Statement smt = getConnection().createStatement();
			ResultSet rst = smt.executeQuery(qry);
			while (rst.next()) {

				System.out.println(rst.getInt(1) + "\t" + rst.getString(2) + "\t" + rst.getString(3) + "\t"
						+ rst.getString(4) + "\t" + rst.getString(7) + "\t" + rst.getString(9));
			}

			getConnection().close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void addMovies() {
		String mName;
		String mDesc;
		String mReleseDate;
		String mEndDate;
		String mStarcast;
		String mTiming;
		String mType;
		System.out.println("Enter Movie Name\n");
		mName = input.next();
		System.out.println("Enter Description about Movie ");
		mDesc = input.next();
		System.out.println("Enter Realse Date\n");
		mReleseDate = input.next();
		System.out.println("Enter End Date");
		mEndDate = input.next();

		System.out.println("Enter StarCast Name");
		mStarcast = input.next();
		System.out.println("Enter Timing of Movie ");
		mTiming = input.next();
		System.out.println("Enter Type of movie");
		mType = input.next();
		try {

			String qry = "INSERT INTO MOVIE(Name,Description,release_date,End_Date,Admin_id,Star_cast,MOVIE_TYPE,TIMING,Active) VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pStmt = getConnection().prepareStatement(qry);
			pStmt.setString(1, mName);
			pStmt.setString(2, mDesc);
			pStmt.setString(3, mReleseDate);
			pStmt.setString(4, mEndDate);
			pStmt.setString(5, "123456");
			pStmt.setString(6, mStarcast);
			pStmt.setString(7, mType);
			pStmt.setString(8, mTiming);
			pStmt.setInt(9, 1);
			int i = pStmt.executeUpdate();
			if (i > 0) {
				System.out.println("done");
				showMovies();
			} else
				System.out.println("Not Done");
			getConnection().close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	void deleteMovies() {
		showMovies();
		System.out.println("Enter ID which movie you want to delete");
		int ch = input.nextInt();
		try {

			String qry = "UPDATE  Movie SET Active = 0 WHERE movie_id=? ";

			PreparedStatement pStmt = getConnection().prepareStatement(qry);
			pStmt.setInt(1, ch);
			int i = pStmt.executeUpdate();
			if (i > 0) {
				System.out.println("done");
				showMovies();
			} else
				System.out.println("Not Done");

			getConnection().close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	void searchMovie(String Name) {
		String qry = "Select name,Description,Release_date,Star_cast,movie_type from movie where Name like'%" + Name
				+ "%'";
		System.out.println("Name \t|Description\t|Realse Date\t|Starcast\t|Type");
		try {
			Statement s= getConnection().createStatement();
			ResultSet rs=s.executeQuery(qry);
			while(rs.next())
				System.out.println(rs.getString(1)+"\t|"+rs.getString(2)+"\t|"+rs.getString(3)+"\t|"+rs.getString(4)+"\t|"+rs.getString(5));
			
		}catch (Exception e) {
				System.out.println(e);
		}
	}

}
