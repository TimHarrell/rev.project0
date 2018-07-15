package com.revature.beans;

public abstract class Room { // abstract because children should be made, not this
	protected String name;
	protected String description;
	protected Room left;
	protected Room right;
	protected boolean last = false;
	Room() {
		name = "default room";
		description = "default descriptions";
	}
	
	Room(String name, String desc) {
		this.name = name;
		description = desc;
	}

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

	public Room getLeft() {
		return left;
	}

	public void setLeft(Room left) {
		this.left = left;
	}

	public Room getRight() {
		return right;
	}

	public void setRight(Room right) {
		this.right = right;
	}
	
	public void setAslast() {
		last = true;
	}
	
	public boolean isLast() {
		return last;
	}
	
	
}
