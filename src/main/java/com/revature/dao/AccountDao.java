package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;

public class AccountDao {
	
	/**
	 * retrieves all of the accounts from the ACCOUNT table
	 */
	public static List<Account> getAllAccounts() {
		System.out.println("connecting...");
		PreparedStatement ps = null;
		Account a = null;
		List<Account> accounts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
		    
			String sql = "SELECT * FROM Accounts";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("userID");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String password = rs.getString("passwrd");
				
				a = new Account(id, firstname, lastname, password);
				accounts.add(a);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return accounts;
	}
	
	/**
	 * retrieves an account from the ACCOUNTS table based on the user ID
	 * @param userID
	 * @return
	 */
	public static Account getAccount(String userID) {
		PreparedStatement ps = null;
		Account a = null;
		ResultSet rs = null;
		System.out.println("connecting...");
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ACCOUNTS WHERE userID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userID);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("userID");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String password = rs.getString("passwrd");
				
				a = new Account(id, firstname, lastname, password);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return a;
	}
	
	/**
	 * submits a new account to the ACCOUNTS table
	 */
	public static boolean addAccount(String userId, String firstname, String lastname, String password) {
		CallableStatement cs = null;
		boolean success = false;
		System.out.println("connecting...");
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO ACCOUNTS (userID, firstname, lastname, passwrd) VALUES (?, ?, ?, ?)";
			cs = conn.prepareCall(sql);
			cs.setString(1, userId);
			cs.setString(2, firstname);
			cs.setString(3, lastname);
			cs.setString(4, password);
			
			Boolean result = cs.execute();
			if (!result) {
				System.out.println("Successful account submission.");
				success = true;
			} else {
				System.out.println("Failed");
				success = false;
			}
			
			cs.close();
		} catch(SQLIntegrityConstraintViolationException ex) {
			System.out.println("That username already exists.");
			success = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			success = false;
		}
		
		return success;
	}
}
