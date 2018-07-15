package com.revature.project0;

import com.revature.dao.MyDao;
public class App 
{
    public static void main( String[] args )
    {
    	//MyDao myDao = new MyDao();
    	Game newGame = new Game();
    	newGame.start();
        System.out.println("Thanks for playing!");
    }
}
