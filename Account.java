package com.planon.banksystem;

public class Account {
	String username;
	String password;
	String city;
	long accountno;
	int bal;
	String panno;
	String acctype;

	public Account(String username, String password, String acctype, String city, long accountno, int bal,
			String panno) {
		this.username = username;
		this.password = password;
		this.city = city;
		this.accountno = accountno;
		this.bal = bal;
		this.panno = panno;
		this.acctype = acctype;
	}

	public String getUsername() {
		return username;
	}

	public void setBal(int changedbal) {
		this.bal = changedbal;
	}

	public String getPassword() {
		return password;
	}

	public String getCity() {
		return city;
	}

	public String getAcctype() {
		return acctype;
	}

	public long getAccountno() {
		return accountno;
	}

	public int getBal() {
		return bal;
	}

	public String getPanno() {
		return panno;
	}

}
