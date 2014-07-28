package com.astro.level;

import java.util.ArrayList;

import com.astro.graphics.Ship;
import com.astro.launch.Start;

public class LevelList {
	
	private static ArrayList<Level> levelList = new ArrayList<Level>();
	private static boolean levelsAdded = false;
	
	public static Level retrieveLevel(int l) {
		
		if (!levelsAdded) {
			addLevels();
			levelsAdded = true;
		}
		
		if (l <= LevelHandler.LEVEL_TOTAL && l > 0 && levelList.get(l - 1) != null) {
			return levelList.get(l - 1);
		}
		return null;
	}

	private static void addLevels() {
		levelList.add(new LevelOne());
	}

}
