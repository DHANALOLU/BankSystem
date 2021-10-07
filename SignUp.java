package com.planon.banksystem;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SignUp {

	private List<Account> userDatabase = new ArrayList<>();

	public void createAccount(BufferedReader br) throws IOException {

		Validation validate = new Validation();

		System.out.println("Enter User Name:");
		String username = br.readLine();
		String validatedusername = validate.validateUsername(username, userDatabase);
		if (validatedusername == null) {
			return;
		}

		System.out.println(
				"Enter Password(length 8-12 , Atleast one upper,lower,digit and special character(!,@,#,$,%,^,&):");
		String password = br.readLine();
		String validatedpassword = validate.validatePassword(password);
		if (validatedpassword == null)
			return;

		System.out.println("Enter Account type: (Savings or Current)");
		String acctype = br.readLine();
		String validatedacctype = validate.validateAccType(acctype);

		System.out.println("Enter City:");
		String city = br.readLine();
		String validatedcity = validate.validateValue(city);

		System.out
				.println("Enter amount to be credited (Minimum 500 Rupees to be deposited whilw opening your account)");
		int bal = Integer.parseInt(br.readLine());
		int validatedbal = validate.validateBalance(bal);

		System.out.println("Enter Pan no(Length 10 (Format: HUJYT0987F)");
		String panno = br.readLine();
		String validatepanno = validate.validatePanno(panno);
		String validatedpanno = validate.validatedPanno(validatepanno, userDatabase);
		if (validatedpanno == null) {
			return;
		}

		System.out.println("Your account is created Succesfully ");
		Random rand = new Random();
		long accno = 1 + rand.nextInt(9);
		for (int i = 0; i < 15; i++) {
			accno *= 10L;
			accno += rand.nextInt(10);
		}
		System.out.println("Your account No is:" + accno);
		Account account = new Account(validatedusername, validatedpassword, validatedacctype, validatedcity, accno,
				validatedbal, validatedpanno);

		userDatabase.add(account);

	}

	public List<Account> getUserDataBase() {
		return userDatabase;
	}

}