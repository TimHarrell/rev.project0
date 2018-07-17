package com.revature.project0;

import com.revature.beans.*;
import com.revature.dao.AccountDao;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
//import junit.framework.Test;
import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    
	@Test
	public void testgetAllAccounts() {
		Game.getAllAccounts();
	}
	
	@Test
    public void testgetSampleAccount()
    {
        System.out.println("testing sample account acquisition");
        Account SamClem = new Account("MarkTwain", "Samuel", "Clemens", "TomSawyer");
        Account onlineAcc = AccountDao.getAccount(SamClem.getUserId());
        assertTrue(onlineAcc.equals(SamClem));
    }
	
	@Test
	public void testConnection() {
		System.out.println("testing connection");
		try (Connection conn = ConnectionUtil.getConnection()) {
			
		} catch (Exception ex) {
			assertTrue(false); // if any exception is caught, test fails
		} 
		System.out.print("connected");
		assertTrue(true);
	}
	
	@Test 
	public void testPerfectPlay() {
		System.out.println("Testing perfect finish");
		Level newLevel = new Level("Greek");
		
		Room currRoom = newLevel.getStartRoom();
		
		currRoom = currRoom.getFoward();
		currRoom = currRoom.getRight();
		currRoom = currRoom.getFoward();
		currRoom = currRoom.getLeft();
		
		assertTrue(currRoom.isLast());
		
	}
	
	@Test
	public void testFlawedFinish() {
		System.out.println("Testing flawed finish...");
		Level newLevel = new Level("Greek");
		
		Room currRoom = newLevel.getStartRoom();
		
		currRoom = currRoom.getFoward();
		currRoom = currRoom.getRight();
		currRoom = currRoom.getFoward();
		currRoom = currRoom.getFoward();
		currRoom = currRoom.getBack();
		currRoom = currRoom.getLeft();
		
		assertTrue(currRoom.isLast());
		
	}
	
	@Test 
	public void testSerDes() {
		System.out.println("Testing serialization...");
		Account acc = new Account("Batman", "Bruce", "Wayne", "IamTheBatMan");
		Serial<Account> serdes = new Serial<>();
		System.out.println("Expected Print: ");
		System.out.println(acc.toString());
		serdes.SerDesObject(acc);
		
		System.out.println("NOTE: password should be null when deserilizing since it is transient.");
		
		assertTrue(true);
	}
	
	
	
}
