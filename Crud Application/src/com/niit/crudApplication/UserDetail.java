package com.niit.crudApplication;

public class UserDetail {
	
	private String uname;
	private String uEmail;
	private String uPhoneNumber;
	private String uDOB;
	private String uPassword;

	private String uCity;
	private String uInterst;
	
	public UserDetail(String uname, String uEmail, String uPhoneNumber, String uDOB, String uPassword,
			 String uCity, String uInterst) {
		super();
		this.uname = uname;
		this.uEmail = uEmail;
		this.uPhoneNumber = uPhoneNumber;
		this.uDOB = uDOB;
		this.uPassword = uPassword;
		this.uCity = uCity;
		this.uInterst = uInterst;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPhoneNumber() {
		return uPhoneNumber;
	}

	public void setuPhoneNumber(String uPhoneNumber) {
		this.uPhoneNumber = uPhoneNumber;
	}

	public String getuDOB() {
		return uDOB;
	}

	public void setuDOB(String uDOB) {
		this.uDOB = uDOB;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	
	public String getuCity() {
		return uCity;
	}

	public void setuCity(String uCity) {
		this.uCity = uCity;
	}

	public String getuInterst() {
		return uInterst;
	}

	public void setuInterst(String uInterst) {
		this.uInterst = uInterst;
	}
	
	
	

}
