package com.astro.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Ship extends GraphicsObj {

	public Ship() {}
	
	@Override
	public GraphicsType getGraphicsType() {
		return GraphicsType.SHIP;
	}

	@Override
	public BufferedImage getImage() {
		BufferedImage bi = new BufferedImage(80, 40, BufferedImage.TYPE_INT_RGB);
		
		int[] xPoints = new int[] { bi.getWidth() / 2, bi.getWidth(), 0 };
		int[] yPoints = new int[] { 0, bi.getHeight(), bi.getHeight() };
		
		Graphics2D g2d = bi.createGraphics();
		g2d.setColor(Color.YELLOW);
		g2d.fillPolygon(xPoints, yPoints, 3);
		return bi;
	}

}
