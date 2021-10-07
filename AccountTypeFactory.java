package com.planon.banksystem;

public class AccountTypeFactory {

	public IAccountType createAccount(String acctype) {
		if (acctype == null) {
			return null;
		} else if (acctype.equals("Savings")) {
			return new Savings();
		} else if (acctype.equals("Current")) {
			return new Current();
		}
		return null;
	}
}