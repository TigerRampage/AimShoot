package com.astro.graphics;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * Abstract class inherited by active graphics objects. Allows these objects to store data such as IDs, images, and other necessary components.
 *
 */
public abstract class GraphicsObj {
	
	private Point currentPosition = new Point(0, 0);
	
	public abstract GraphicsType getGraphicsType();
	
	public abstract BufferedImage getImage();
	
	public int getWidth() {
		return this.getImage().getWidth();
	}
	
	public int getHeight() {
		return this.getImage().getHeight();
	}
	
	public Point getPosition() {
		return this.currentPosition;
	}
	
	public void setPosition(int x, int y) {
		this.currentPosition = new Point(x, y);
	}
}