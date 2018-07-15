package com.revature.beans;

import java.util.Scanner;

public class Account {
	String firstName;
	String lastName;
	String playerId;
	private transient String password;
	
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
		
		in.close();
		
	}
	
	public void hasAccount() {
		
	}
	
	public void makeAccount() {
		
	}
	
}
