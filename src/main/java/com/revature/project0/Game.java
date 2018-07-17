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
	
	/**
	 * main game loop
	 * @throws Exception
	 */
	public void start() throws Exception {
		System.out.println("\nWelcome to a maze game. Navigate it using commands.\nType \"help\" for the commands.");
		while(!exit) {
			exit = runGame();
		}
	}
	
	
	/**
	 * Runs the main game. It has a loop the controls whether or not the player has finished or not 
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * Effectively ends the game by changing the endOfGame boolean to true
	 */
	public void endGame() {
		endOfGame = true;
	}
	
	/**
	 * process the second word of a go command, depends on the type of rooms
	 * NOTE: current implementation only uses 4D rooms, so this seems like an unnecessary function, however if different types of
	 * rooms were eventually added, this would handle which process to execute
	 * @param in
	 */
	public void processGo(String in) {
		processGo4D(in);
	}
	
	/**
	 * provides information about the room the player is currently in
	 */
	public void printCurrRoomInfo() {
		System.out.println("\nRoom: " + currRoom.getName());
		System.out.println(currRoom.getDescription());
		if(currRoom.isDeadEnd()) {
			System.out.println("It's a dead end, go back.");
		}
		
	}
	
	/**
	 * retrieves and prints all accounts from the ACCOUNTS table
	 */
	public void getAllAccounts() {
    	List<Account> accounts = AccountDao.getAllAccounts();
    	
    	for(int i = 0; i < accounts.size(); i++) {
    		System.out.println(accounts.get(i).toString());
    	}
	}
	
	/**
	 * processes second word of a go command in the context of a 4D room
	 * @param in
	 * @return
	 */
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
	
	/**
	 * Implement later
	 * @param in
	 */
	public void processGo3D(String in) {
		
	}
	
	/**
	 * implement later 
	 * @param in
	 */
	public void processGo2D(String in) {
		
	}
	
	/**
	 * implement later
	 * @param in
	 */
	public void processGo1D(String in) {
		
	}
	
	/**
	 * verifies if it is the end of the game. It is effectively a getter function for endOfGame boolean variable
	 * @return
	 */
	public static boolean isEndOfGame() {
		return endOfGame;
	}
	
	
}
