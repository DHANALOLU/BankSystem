package com.planon.banksystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BankManagementSystem {
	public static void main(String args[]) throws IOException {
		try (InputStreamReader r = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(r)) {

			SignUp signup = new SignUp();
			SignIn signin = new SignIn();
			BankHelper bankhelper = new BankHelper();
			System.out.println("WELCOME TO BANK OF INDIA");
			System.out.println("Pick your choice");
			int choice;

			do {

				System.out.println("1.Sign up  2.Sign in 3.List Accounts 4.Exit");
				choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:
					System.out.println("-----Enter Your Details-----");
					signup.createAccount(br);
					break;

				case 2:
					System.out.println("-----Login with Your Username and Password-----");

					System.out.println("Enter Username:");
					String reguname = br.readLine();
					System.out.println("Enter password:");
					String regpassword = br.readLine();
					Account loggeduserobj = signin.validateAccount(reguname, regpassword, signup);
					if (!(loggeduserobj == null)) {
						bankhelper.loginActions(loggeduserobj, br, signup);
					} else {
						System.out.println("No Account Found with the given UserName and Password!!!!! ");
					}

					break;

				case 3:
					System.out.println("------------------------------Account details--------------------------");
					List<Account> userDataBase = signup.getUserDataBase();
					System.out.println("UserName" + "     " + "City" + "    " + "AccountNumber" + "   " + "Pan No"
							+ "     " + "Balance" + "    " + "Account Type");
					System.out.println("---------------------------------------------------------------------------");
					for (Account acc : userDataBase) {
						System.out.println(acc.getUsername() + "      " + acc.getCity() + "      " + acc.getAccountno()
								+ "     " + acc.getPanno() + "    " + acc.getBal() + "    " + acc.getAcctype());
					}
					break;
				case 4:
					System.out.println("---------Thank You For Visiting!!!!-----------");
					break;
				}
			} while (choice != 4);
		} finally {

		}

	}
}