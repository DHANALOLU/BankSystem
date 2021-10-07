package com.planon.banksystem;

import java.io.*;

import java.util.*;
import java.util.regex.Pattern;

public class Validation {

	Scanner sc = new Scanner(System.in);

	public String validateValue(String value) throws IOException {
		boolean unameisempty = value.isEmpty();
		while (unameisempty) {
			System.err.println(" Mandatory Please Enter the value:");
			value = sc.nextLine();
			unameisempty = value.isEmpty();
		}

		return value;

	}

	public int validateValue(int value) throws IOException {

		while (value == 0) {
			System.err.println("UserName is Mandatory Please Enter Username:");
			value = sc.nextInt();

		}

		return value;

	}

	public String validateUsername(String username, List<Account> userDataBase) throws IOException {
		String value = validateValue(username);
		for (Account accdetails : userDataBase) {
			if (accdetails.getUsername().equals(value)) {
				System.out.println("A user with same User Name Alraedy exists");
				return null;
			}
		}
		return value;

	}

	public String validateAccType(String acctype) throws IOException {
		String value = validateValue(acctype);
		while (!(value.equals("Savings") || value.equals("Current"))) {
			System.out.println("Enter either Savings or Current .Only 2 Account Types are available");
			value = sc.nextLine();
		}

		return value;

	}

	public String validatePassword(String password) throws IOException {
		String value = validateValue(password);
		String REG = "^(?=.*\\d)(?=\\S+$)(?=.*[@#$%^&+=!])(?=.*[a-z])(?=.*[A-Z]).{8,12}$";
		Pattern PATTERN = Pattern.compile(REG);
		while (!(PATTERN.matcher(value).matches())) {
			System.out.print("Pattern of Password is Not Matching .Enter a new one again");
			value = sc.nextLine();
		}
		System.out.println("Re-Enter Password:");
		String reenterpassword = sc.nextLine();
		while (!value.equals(reenterpassword)) {
			System.out.println("Please check the password Re-entered and Re enter the password");
			reenterpassword = sc.nextLine();
		}

		if (value.equals(reenterpassword)) {
			return value;
		}
		return null;

	}

	public int validateBalance(int bal) throws IOException {
		int value = validateValue(bal);
		while (value < 500) {
			System.out.println("You need to deposit alteast rupees 500 at the time of account creation ");
			value = sc.nextInt();
		}
		return value;

	}

	public String validatePanno(String panno) throws IOException {
		String value = validateValue(panno);
		while (value.trim().length() < 10 || !value.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}") || value.trim().length() > 10) {
			System.out.println("Please Enter the correct pan number (It should contain 10 places)(Format:AHGTY7890U) ");
			value = sc.nextLine();
		}

		return value;

	}

	public String validatedPanno(String panno, List<Account> userDataBase) {
		for (Account accdetails : userDataBase) {
			if (accdetails.getPanno().equals(panno)) {
				System.out.println("A user with same Pan no  Alraedy exists");
				return null;
			}
		}
		return panno;
	}

	public Account validateRecAccount(String recusername, SignUp signup) {
		for (Account accdetails : signup.getUserDataBase()) {
			if (accdetails.getUsername().equals(recusername)) {
				System.out.println("Account to which amount to be Transfer is Found!!!");

				return accdetails;
			}
		}
		return null;
	}
}
