package com.niit.crudApplication;

import java.util.Scanner;

public class Admin {

	Movies mv=new Movies();
	OperationsAdmin oAd = new OperationsAdmin();
	Scanner s = new Scanner(System.in);
	int choiceMenue;
	void callAdmin() {
		
		boolean chk = oAd.loginAdmin();
		System.out.println(chk);
		if (chk) {
			System.out.println("Welcome admin");
			System.out.println("1:Add movies\n2:Show movies\n3:Delete Movies\n4:Show Booking Details Collections");
			choiceMenue = s.nextInt();
			switch (choiceMenue) {
			case 1:
				mv.addMovies();
				break;
			case 2:
				mv.showMovies();
				break;
			case 3:
				mv.deleteMovies();
				break;

			case 4:
				showCollection();
				break;
			}
		} else
			System.out.println("Wrong id And password");

	}

	void showCollection() {
		System.out.println("IN working");
	}

}