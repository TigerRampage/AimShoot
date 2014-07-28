package com.astro.level;

import com.astro.graphics.Ship;
import com.astro.launch.Start;
import com.astro.util.ActiveUtils;

public class LevelOne extends Level {
	
	private Ship s = null;
	
	public LevelOne() {
		super();
	}
	
	@Override
	public void createLevel() {
		this.setName("ONE");
		this.setLevelNumber(1);
		s = new Ship();
		this.addGraphic(s);
	}

}
