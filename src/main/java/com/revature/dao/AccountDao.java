package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;

public class AccountDao {
	public List<Account> getAllAccounts() {
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
	
	public Account getAccount(String userID) {
		PreparedStatement ps = null;
		Account a = null;
		ResultSet rs = null;
		
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
	
	public void feedBear(int bid, int bhid, int hamt) {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL SP_FEED_BEAR(?, ?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, bid);
			cs.setInt(2, bhid);
			cs.setInt(3, hamt);
			
			Boolean result = cs.execute();
			if (!result) {
				System.out.println("Fed Bear");
			} else {
				System.out.println("Failed");
			}
			
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
