package com.planon.banksystem;

public class Current implements IAccountType {

	public int getDepositRate() {
		return 5;

	}

	public int getWithdrawlRate() {
		return 5;
	}
	

	
	public int getTansferRate() {
		
		return 3;
	}

}
