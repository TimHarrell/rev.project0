package com.revature.beans;

public class Room2D extends Room {
	
	
	Room2D() {
		super();
	}
	
	Room2D(String name, String desc) {
		super(name, desc);
	}
	
	Room2D(String name, String desc, Room Fowards, Room Back) {
		this.name = name;
		description = desc;
		foward = Fowards;
		back = Back;
	}
	
	public boolean isDeadEnd() {
		if(foward == null) return true;
		
		return false;
	}
	
	public void setFoward(Room room) {
		super.setFoward(room);
	}
	
	public Room getFoward() {
		return super.getFoward();
	}
	public void setBack(Room room) {
		super.setBack(room);
	}
	
	public Room getBack() {
		return super.getBack();
	}
	
	public Room getLeft() {
		return null;
	}
	
	public Room getRight() {
		return null;
	}
	
}
