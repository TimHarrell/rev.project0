package com.revature.beans;

import java.util.Scanner;

import com.revature.dao.AccountDao;

public class Account {
	private String firstName;
	private String lastName;
	private String userId;
	private transient String password;
	
	public Account() {
		super();
	}
	public Account(String userId, String firstName, String lastName, String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	/**
	 * prompts user asking if they already have an account and handles option accordingly
	 */
	public void accountManagement() {
		Scanner in = new Scanner(System.in);
		String input;
		boolean stay = true;
		while(stay) {
			
			System.out.println("Are you a new user? (Y/N)");
			System.out.print(">");

			input = in.nextLine();
			if(input.equals("Y")) {
				stay = addAccount();
			}
			else if(input.equals("N")) {
				stay = !hasAccount();
			}
				
		}
		
		//in.close(); // crashes input later on
	}
	
	// overloading equals method
	
	public boolean equals(Account a) {
		if(!this.userId.equals(a.getUserId())) return false;
		if(!this.firstName.equals(a.getFirstName())) return false;
		if(!this.lastName.equals(a.getLastName())) return false;
		if(!this.password.equals(a.getPassword())) return false;
		return true;
	}
	
	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append(userId + " " + firstName + " " + lastName + " " + password);
		return out.toString();
	}
	
	/**
	 * grabs inputted information from user and verifies if the password matches
	 */
	public boolean hasAccount() {
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		System.out.print("Enter your username\n>");
		username = scanner.nextLine();
		System.out.print("Enter your password\n>");
		password = scanner.nextLine();
		
		return verifyAccount(username, password);
	}
	
	/**
	 * add an account to the ACCOUNTS table, assuming the inputted user name does not already exist
	 */
	public boolean addAccount() {
		String[] accountInfo;

		accountInfo = getAccountInfo();
		
		return !AccountDao.addAccount(accountInfo[0], accountInfo[1], accountInfo[2], accountInfo[3]);
	}
	
	/**
	 * if the corresponding account has the same password as the user password input, return true, otherwise return false
	 */
	public boolean verifyAccount(String username, String password) {
		Account account = AccountDao.getAccount(username);
		if(account != null && account.getPassword().equals(password)) {
			System.out.println("Valid credentials\n");
			return true;
		}
		
		System.out.println("Invalid credentials\n");
		return false;
		
	}
	
	/**
	 * prompt user for new account information
	 */
	public String[] getAccountInfo() {
		// 0 = username;
		// 1 = firstname;
		// 2 = lastname;
		// 3 = password;
		String[] accountInfo = new String[4];

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter new user name\n>");
		accountInfo[0] = input.nextLine();
		
		System.out.print("Enter new firstname\n>");
		accountInfo[1] = input.nextLine();
		
		System.out.print("Enter new lastname\n>");
		accountInfo[2] = input.nextLine();
		
		System.out.print("Enter new password\n>");
		accountInfo[3] = input.nextLine();
		
		return accountInfo;
	}
	
	//SETTERS AND GETTERS
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
