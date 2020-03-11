package com.niit.crudApplication;

import java.util.Scanner;

public class User {
	public void calluser() {
		
		UserOperation ud = new UserOperation();
		Scanner s = new Scanner(System.in);
		int choice=0;
		System.out.println(
				"Welcome to Online HHS Movie Booking System \n Select your choice\n 1:Registered User\n 2: New User");
		choice=s.nextInt();
		if(choice==1)
		{
			boolean login=ud.loginUser();
			if(login)
			{
				ud.rUserOperation();
			}
			else 
				System.out.println("Wrong ID and password");
			
		}
		else if(choice==2)
		{
			ud.addUsers();
		}

	}
}
