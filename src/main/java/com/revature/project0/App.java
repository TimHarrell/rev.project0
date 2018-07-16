package com.revature.project0;

import com.revature.beans.*;
public class App 
{
    public static void main( String[] args )
    {
    	TimeCounter counter = new TimeCounter();
    	
    	
    	Account newAcc = new Account();
    	newAcc.accountManagement();
    	Game newGame = new Game();
    	
    	
    	newGame.run();
    	
        System.out.println("Thanks for playing!");
        
        newGame.getAllAccounts();
    }
}
