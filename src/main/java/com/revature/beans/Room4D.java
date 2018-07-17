package com.revature.beans;

public class Room4D extends Room{ // Room with 4 direction to move
	protected Room left;
	protected Room right;
	protected Room foward;
	protected Room back;
	
	Room4D() {
		super();
	}
	
	Room4D(String name, String desc) {
		super(name, desc);
	}
	
	Room4D(String name, String desc, Room Left, Room Right, Room Fowards, Room Back) {
		this.name = name;
		description = desc;
		left = Left;
		right = Right;
		foward = Fowards;
		back = Back;
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
		left.setBack(this);
	}
	public Room getRight() {
		return right;
	}
	public void setRight(Room right) {
		this.right = right;
		right.setBack(this);
	}
	public Room getFoward() {
		return foward;
	}
	public void setFoward(Room foward) {
		this.foward = foward;
		foward.setBack(this);
	}
	public Room getBack() {
		return back;
	}
	public void setBack(Room back) {
		this.back = back;
	}
	public boolean isDeadEnd() {
		if(left == null && right == null && foward == null) return true;
		
		return false;
	}
}
