package com.revature.project0;


import com.revature.beans.*;
public class App 
{
    public static void main( String[] args )
    {
    	//MyDao myDao = new MyDao();
    	Account newAcc = new Account();
    	newAcc.accountManagement();
    	Game newGame = new Game();
    	
    	newGame.start();
        System.out.println("Thanks for playing!");
    }
}
