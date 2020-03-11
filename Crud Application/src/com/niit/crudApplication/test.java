package com.niit.crudApplication;

import static com.niit.MovieBooking.Connection.ConnectionJDBC.getConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;




public class test {
	public static void main(String[] args) {
		try {
			String qry="UPDATE  Movie SET Active = 1 WHERE movie_id=10 ";
			PreparedStatement s=getConnection().prepareStatement(qry);
			int i = s.executeUpdate();
			if(i > 0)
			{
				System.out.println("done");
			}
			else
				System.out.println("Not done");
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
} 