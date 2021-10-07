package com.planon.banksystem;

public class Savings implements IAccountType {

	public int getDepositRate() {
		return 4;

	}

	public int getWithdrawlRate() {
		return 4;
	}

	public int getTansferRate() {

		return 2;
	}

}
