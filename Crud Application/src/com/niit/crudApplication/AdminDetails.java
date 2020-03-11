package com.niit.crudApplication;

public class AdminDetails {

	private String name;
	private String password;
	private String type;

	AdminDetails(String name, String password, String type) {
		super();
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public AdminDetails() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
