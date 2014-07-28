package com.astro.level;

import com.astro.util.ActiveUtils;

public class LevelHandler {

	public static final int LEVEL_TOTAL = 51;
	
	private static int currentLevel = 0;
	
	public static int getCurrentLevel() {
		return currentLevel;
	}
	
	public static void setLevel(int l) {
		currentLevel = l;
		ActiveUtils.getActiveMaster().activeLevel = LevelList.retrieveLevel(l);
	}
	
	public static void setNextLevel() {
		if (++currentLevel > LEVEL_TOTAL) {
			currentLevel = 0;
		}
		else {
			currentLevel += 1;
		}
	}
	
}
