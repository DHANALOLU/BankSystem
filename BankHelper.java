package com.planon.banksystem;

import java.io.BufferedReader;
import java.io.IOException;

public class BankHelper {

	public void loginActions(Account loggeduserobj, BufferedReader br, SignUp signup)
			throws NumberFormatException, IOException

	{
		Validation valid = new Validation();
		int count = 1;
		while (count > 0) {
			System.out.println(" 1.Deposit 2.Withdraw 3.Transfer 4.Exit");
			int ch = Integer.parseInt(br.readLine());
			switch (ch) {
			case 1:
				System.out.println("-----Deposit Money -----");
				System.out.println("Username:" + loggeduserobj.getUsername());
				System.out.println("Account Number:" + loggeduserobj.getAccountno());
				System.out.println("Account type:" + loggeduserobj.getAcctype());
				System.out.println("Account Balance:" + loggeduserobj.getBal());

				System.out.println("Enter amount to be deposited:");
				int amountToDeposit = Integer.parseInt(br.readLine());
				AccountTypeFactory accTypeDeposit = new AccountTypeFactory();
				IAccountType accd = accTypeDeposit.createAccount(loggeduserobj.getAcctype());
				int depositinterest = (amountToDeposit / 100) * (accd.getDepositRate());

				amountToDeposit -= depositinterest;
				System.out.println(amountToDeposit + loggeduserobj.getBal());
				loggeduserobj.setBal(amountToDeposit + loggeduserobj.getBal());

				System.out.println("Deposited Succesfully");
				break;
			case 2:
				System.out.println("-----Withdrawl Money -----");
				System.out.println("Username:" + loggeduserobj.getUsername());
				System.out.println("Account Number:" + loggeduserobj.getAccountno());
				System.out.println("Account type:" + loggeduserobj.getAcctype());
				System.out.println("Account Balance:" + loggeduserobj.getBal());

				System.out.println("Enter amount to be withdrawl:");
				int amountToWithdraw = Integer.parseInt(br.readLine());
				if (amountToWithdraw > loggeduserobj.getBal()) {
					System.out.println("No Succifient money to Withdraw!!!!!");
				} else {
					AccountTypeFactory accTypeWithdraw = new AccountTypeFactory();
					IAccountType accw = accTypeWithdraw.createAccount(loggeduserobj.getAcctype());
					int withdrawinterest = (amountToWithdraw / 100) * (accw.getWithdrawlRate());

					amountToWithdraw += withdrawinterest;
					System.out.println(loggeduserobj.getBal() - amountToWithdraw);
					loggeduserobj.setBal(loggeduserobj.getBal() - amountToWithdraw);
					System.out.println("Withdrawl Succesful");
				}

				break;
			case 3:
				System.out.println("-----TRANSFER MONEY -----");
				System.out.println("***************************");
				System.out.println("YOUR ACCOUNT DETAILS: ");
				System.out.println("Username:" + loggeduserobj.getUsername());
				System.out.println("Account Number:" + loggeduserobj.getAccountno());
				System.out.println("Account type:" + loggeduserobj.getAcctype());
				System.out.println("Account Balance:" + loggeduserobj.getBal());
				System.out.println("***************************");
				System.out.println("Enter the UserName of the Account you want to send Money");
				String recusername = br.readLine();
				Account recaccountobj = valid.validateRecAccount(recusername, signup);
				if (recaccountobj == null) {
					System.out.println("The Account to whom you wantto transfer is Not Found");
				} else {
					System.out.println("Enter the Amount to be Transferred:");
					int amounttobetransfered = Integer.parseInt(br.readLine());
					if (amounttobetransfered > loggeduserobj.getBal()) {
						System.out.println("Sorry , You Dont have Sufficient Amount to Transfer!!!!");
					} else {
						recaccountobj.setBal(recaccountobj.getBal() + amounttobetransfered);
						AccountTypeFactory accTypeWithdraw = new AccountTypeFactory();
						IAccountType acct = accTypeWithdraw.createAccount(loggeduserobj.getAcctype());
						
						int sendertransferedamount = (amounttobetransfered)
								+ (((amounttobetransfered) / 100) * acct.getTansferRate());
						System.out.println("Your Balance After Transaction is :"+(loggeduserobj.getBal() - sendertransferedamount ));
						loggeduserobj.setBal(loggeduserobj.getBal() - sendertransferedamount);
						System.out.println("Money Is Transferred Succesfully ");
						
					}
				}
				break;
			case 4:
				count = -1;
				break;

			}

		}

	}

}
