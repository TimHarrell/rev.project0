package com.revature.beans;

public abstract class Room { // abstract because children should be made, not this
	protected String name;
	protected String description;
	protected Room foward;
	protected Room back;
	protected boolean last = false;
	Room() {
		name = "default room";
		description = "default descriptions";
	}
	
	Room(String name, String desc) {
		this.name = name;
		description = desc;
	}

	public abstract boolean isDeadEnd();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFoward(Room room) {
		foward = room;
		foward.setBack(this);
	}

	public Room getFoward() {
		return foward;
	}
	
	public void setAslast() {
		last = true;
	}
	
	public boolean isLast() {
		return last;
	}

	public Room getBack() {
		return back;
	}

	public void setBack(Room back) {
		this.back = back;
	}
	
	/* these getters always return null, they are just here to 
	 * improve functional compatibility with the command words
	*/
	public Room getLeft() {
		return null;
	}
	
	public Room getRight() {
		return null;
	}
	
	
	
	
	
	
	
	
}
