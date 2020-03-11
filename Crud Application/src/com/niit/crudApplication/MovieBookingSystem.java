package com.niit.crudApplication;

import java.util.Scanner;

public class MovieBookingSystem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Admin ad = new Admin();
		User u = new User();
		int choice;
		char ch = 'y';
		while (ch == 'y') {
			System.out.println("Welcome to movie Center \nSelect Your Choice\n 1:->Customer\n2:->Admin");
			 choice =input.nextInt(); 
			switch (choice) {
			case 1:
				u.calluser();
				break;
			case 2:
				ad.callAdmin();
				break;

			default:
				System.out.println("Wrong choice ");
				System.out.println("Do you want to continue Press y for that ");
				ch = input.next().charAt(0);

			}
			input.close();

		}
	}
}
