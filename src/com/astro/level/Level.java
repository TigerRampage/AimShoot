package com.astro.level;

import java.util.ArrayList;

import com.astro.graphics.GraphicsObj;

public abstract class Level {
	private ArrayList<GraphicsObj> levelGraphics = new ArrayList<GraphicsObj>();
	private String levelName = null;
	private int levelNumber = 0;
	
	protected Level() {
		this("N/A", 0);
	}
	
	protected Level(String name, int level) {
		this.setName(name);
		this.setLevelNumber(level);
	}
	
	protected void setName(String s) {
		this.levelName = s;
	}
	
	public String getName() {
		return this.levelName;
	}
	
	protected void setLevelNumber(int l) {
		this.levelNumber = l;
	}
	
	public int getLevelNumber() {
		return this.levelNumber;
	}
	
	protected void addGraphic(GraphicsObj go) {
		
		if (this.levelGraphics.contains(go)) {
			return;
		}
		
		this.levelGraphics.add(go);
	}
	
	protected void removeGraphic(GraphicsObj go) {
		if (this.levelGraphics.contains(go)) {
			this.levelGraphics.remove(go);
		}
	}
	
	public ArrayList<GraphicsObj> getGraphics() {
		return this.levelGraphics; 
	}
	
	public abstract void createLevel();
	
	@Override
	public String toString() {
		String s = "Level Name: " + this.getName() + "... #" + Integer.toString(this.getLevelNumber());
		return s;
	}
	
}
