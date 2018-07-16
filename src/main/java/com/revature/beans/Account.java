package com.revature.beans;

import java.util.Scanner;

public class Account {
	String firstName;
	String lastName;
	String userId;
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
	public void accountManagement() {
		Scanner in = new Scanner(System.in);
		String input;
		boolean stay = true;
		while(stay) {
			
			System.out.println("Are you a new user? (Y/N)");
			System.out.println(">");

			input = in.nextLine();
			
			if(input.equals("Y")) {
				makeAccount();
				stay = false;
			}
			else if(input.equals("N")) {
				hasAccount();
				stay = false;
			}
			else {
				System.out.println("invalid, try again.");
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
	public void hasAccount() {
		
	}
	
	public void makeAccount() {
		
	}
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
