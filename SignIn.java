package com.planon.banksystem;

import java.io.IOException;

public class SignIn {

	public Account validateAccount(String uname, String password, SignUp signup) throws IOException {

		for (Account accdetails : signup.getUserDataBase()) {
			if ((accdetails.getUsername().equals(uname)) && (accdetails.getPassword().equals(password))) {
				System.out.println("Logged In Successfully...!!!");

				return accdetails;
			}

		}
		return null;
	}
}