package com.jdb.entities;

public class LoginView {

	String uname;
	String password;

	public LoginView() {
		super();
	}

	public LoginView(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginView [uname=" + uname + ", password=" + password + "]";
	}

}