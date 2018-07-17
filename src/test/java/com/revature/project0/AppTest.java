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
    /**
     * Rigourous Test :-)
     * 
     */
	@Test
    public void testgetSampleAccount()
    {
        
        Account SamClem = new Account("MarkTwain", "Samuel", "Clemens", "TomSawyer");
        Account onlineAcc = AccountDao.getAccount(SamClem.getUserId());
        assertTrue(onlineAcc.equals(SamClem));
    }
	
	@Test
	public void testConnection() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
		} catch (Exception ex) {
			assertTrue(false); // if any exception is caught, test fails
		} 
		System.out.print("connected");
		assertTrue(true);
	}
	
	@Test 
	public void testPerfectPlay() {
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
		Account acc = new Account("Batman", "Bruce", "Wayne", "IamTheBatMan");
		Serial<Account> serdes = new Serial<>();
		System.out.println("Expected Print: ");
		System.out.println(acc.toString());
		serdes.SerDesObject(acc);
		
		System.out.println("NOTE: password should be null when deserilizing since it is transient.");
		
		assertTrue(true);
	}
	
}
