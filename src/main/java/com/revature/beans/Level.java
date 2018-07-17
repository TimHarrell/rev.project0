package com.revature.beans;

import java.util.HashMap;

public class Level<G> {
	private Room4D startRoom;
	private HashMap<String, Room> roomTypes = new HashMap<>(); // a hash map for storing all of the possible rooms
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
		Room4D room1 = new Room4D(names[0], descriptions[0]);
		Room4D room10 = new Room4D(names[3], descriptions[3]);
		Room4D room101 = new Room4D(names[2], descriptions[2]);
		Room4D room11 = new Room4D(names[3], descriptions[3]);
		Room4D room12 = new Room4D(names[4], descriptions[4]);
		Room4D room122 = new Room4D(names[0], descriptions[0]);
		Room4D room1221 = new Room4D(names[1], descriptions[1]);
		Room4D room1222 = new Room4D(names[3], descriptions[3]);
		Room4D room1223 = new Room4D(names[2], descriptions[2]);
		startRoom.setFoward(room1);
		room1.setFoward(room11);
		room1.setLeft(room10);
		room1.setRight(room12);
		
		room10.setRight(room101);
		
		room12.setFoward(room122);
		
		room122.setLeft(room1221);
		
		room122.setFoward(room1222);
		room122.setRight(room1223);
		room1221.setAslast();
		
		
		
	}
	// setting theme
	public void setThemeAsGreek() {
		
		names = RoomsTheme.getGreekNames();
		descriptions = RoomsTheme.getGreekDescs();
		
	}
	
	// populate hashmap with rooms of theme
	public void generateRoomsHashMap() {
		for(int i = 0; i < names.length; i++ ) {
			roomTypes.put(names[i], new  Room4D(names[i], descriptions[i]));
		}
	}
	
	public Room4D getStartRoom() {
		return startRoom;
	}
	
}
