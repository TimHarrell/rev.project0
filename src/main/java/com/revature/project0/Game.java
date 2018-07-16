package com.revature.project0;

import java.util.List;
import com.revature.beans.*;
import com.revature.commands.*;
import com.revature.dao.AccountDao;

public class Game implements Runnable {
	private Parser parser;
	private Room4D currRoom;
	private static boolean endOfGame = false;
	private Level myLevel;
	private Boolean exit = false;
	
	Game() {
		parser = new Parser();
		myLevel = new Level("Greek");
		currRoom = myLevel.getStartRoom();
	}
	
	public void run() {
		try {
			start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() throws Exception {
		System.out.println("Welcome to a maze game. Navigate it using commands.\nType \"help\" for the commands.");
		while(!exit) {
			exit = runGame();
		}
	}
	
	
	
	public boolean runGame() throws Exception {
		boolean getCommand = true;
		if(currRoom.isLast()) {
			endOfGame = true;
		}
		if(endOfGame) {
			System.out.print("You made it to the end.");
			return true;
		}
		while(getCommand) {
			printCurrRoomInfo();
			Command command = parser.getCommand();
			if(CommandWords.isCommand(command.getCommandWord())) {
				if(command.getCommandWord().equals("go")) {
					processGo(command.getSecondWord());
					return false;
				} 
				else if(command.getCommandWord().equals("help")) {
					CommandWords.showAll();
					return false;
				}
				else if(command.getCommandWord().equals("quit")) {
					return true;
				}
				
			}
			else {
				System.out.println("invalid command");
			}
		}
		
		throw new Exception("while loop exited unintentionally");
	}
	
	public void endGame() {
		endOfGame = true;
	}
	
	public void processGo(String in) {
		processGo4D(in);
	}
	
	public void printCurrRoomInfo() {
		System.out.println("\nRoom: " + currRoom.getName());
		System.out.println(currRoom.getDescription());
		
	}
	
	public void getAllAccounts() {
    	List<Account> accounts = AccountDao.getAllAccounts();
    	
    	for(int i = 0; i < accounts.size(); i++) {
    		System.out.println(accounts.get(i).toString());
    	}
	}
	
	public Boolean processGo4D(String in) {
		if(in.equals("left")) {
			if(currRoom.getLeft() == null) {
				
				System.out.println("That's a fake door, try again");
				return false;
			}
			currRoom = (Room4D) currRoom.getLeft();
			return true;
		}
		else 
		if( in.equals("right")) {
			if(currRoom.getRight() == null) {
				
				System.out.println("That's a fake door, try again");
				return false;
			}
			currRoom = (Room4D) currRoom.getRight();
			return true;
		}
		else 
		if(in.equals("foward")) {
			if(currRoom.getFoward() == null) {
				
				System.out.println("That's a fake door, try again");
				return false;
			}
			currRoom = (Room4D) currRoom.getFoward();
			return true;
		}
		else 
		if( in.equals("back")) {
			if(currRoom.getBack() == null) {
				System.out.println("That's a fake door, try again");
				return false;
			}
			currRoom = (Room4D) currRoom.getBack();
			return true;
		}
		else {
			try {
				throw new Exception();
			}
			catch(Exception e) {
				System.out.println("invalid go location");
				return false;
			}
		}
	};
	
	public void processGo3D(String in) {
		
	}
	
	public void processGo2D(String in) {
		
	}
	
	public void processGo1D(String in) {
		
	}
	
	public static boolean isEndOfGame() {
		return endOfGame;
	}
	
	
}
