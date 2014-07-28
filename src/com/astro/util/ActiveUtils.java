package com.astro.util;

import com.astro.graphics.Master;
import com.astro.launch.Start;

public class ActiveUtils {
	private static Master activeMaster = null;
	
	public static void setActiveMaster(Master m) {
		if (m != null) {
			activeMaster = m;
		}
	}
	
	public static Master getActiveMaster() {
		return activeMaster;
	}
}
