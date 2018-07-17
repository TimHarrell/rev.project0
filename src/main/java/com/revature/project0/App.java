package com.revature.project0;

import com.revature.beans.*;
public class App 
{
    public static void main( String[] args )
    {
    	
    	Game newGame = new Game();
    	 
    	
    	Account newAcc = new Account();
    	newAcc.accountManagement();
    	
    	
    	
    	
    	newGame.start();
    	
    	
        System.out.println("Thanks for playing!");
        
       //Game.getAllAccounts();
        
        
        Serial<Account> serder = new Serial<>();
        serder.SerDesObject(newAcc);
    }
}
