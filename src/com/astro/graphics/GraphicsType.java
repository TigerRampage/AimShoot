package com.astro.graphics;

public enum GraphicsType {
	
	SHIP(1),
	LARGE_TARGET(2),
	REG_TARGET(3),
	SMALL_TARGET(4),
	BARRIER_BLOCK(5),
	BARRIER_TARGET(6),
	BULLET(7);
	
	private int ID = 0;
	
	GraphicsType(int id) {
		this.ID = id;
	}
	
	public int getID() {
		return this.ID;
	}
}
