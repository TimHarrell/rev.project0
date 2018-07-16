package com.revature.project0;

import com.revature.dao.*;
import java.lang.*;
import java.util.List;

import com.revature.beans.*;
public class App 
{
    public static void main( String[] args )
    {
    	TimeCounter counter = new TimeCounter();
    	
    	
    	AccountDao accountDao  = new AccountDao();
    	List<Account> accounts = accountDao.getAllAccounts();
    	
    	for(int i = 0; i < accounts.size(); i++) {
    		System.out.println(accounts.get(i).toString());
    	}
    	
    	Account newAcc = new Account();
    	newAcc.accountManagement();
    	Game newGame = new Game();
    	
    	
    	newGame.run();
    	
        System.out.println("Thanks for playing!");
    }
}
