package com.revature.beans;

import java.util.HashMap;

public class Level {
	private Room4D startRoom;
	private HashMap<String, Room4D> roomTypes = new HashMap<>(); // a hash map for storing all of the possible rooms
	private String[] names;
	private String[] descriptions;
	
	public Level(String type) {
		if(type.equals("Greek")) {
			generateLabrynth();
		}
		// add other types here
	}
	
	
		// make a specific level
	public void generateLabrynth() {
		startRoom = new Room4D("Start Room", "Welcome to the labrynth. Move foward to start.");
		setThemeAsGreek();
		generateRoomsHashMap();
		Room4D room11 = new Room4D(names[0], descriptions[0]);
		startRoom.setFoward(room11);
		Room4D room112 = new Room4D(names[1], descriptions[1]);
		room112.setAslast();
		room11.setRight(room112);
		
		
		
	}
	// setting theme
	public void setThemeAsGreek() {
		
		names = RoomsTheme.getGreekNames();
		descriptions = RoomsTheme.getGreekDescs();
		
	}
	
	// populate hashmap with rooms of theme
	public void generateRoomsHashMap() {
		for(int i = 0; i < names.length; i++ ) {
			roomTypes.put(names[i], new Room4D(names[i], descriptions[i]));
		}
	}
	
	public Room4D getStartRoom() {
		return startRoom;
	}
	
}
