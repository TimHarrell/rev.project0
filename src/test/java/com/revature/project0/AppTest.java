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
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
		} catch (Exception ex) {
			assertTrue(false); // if any exception is caught, test fails
		} 
		System.out.print("connected");
		assertTrue(true);
	}
	
}
