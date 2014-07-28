package com.astro.graphics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.astro.level.Level;
import com.astro.util.ActiveUtils;

public class Master {

	private Graphics2D g2d = null;
	private int width = 0;
	private int height = 0;
	private int ticks = 0;
	private int lastGoodTick = 0;
	public Level activeLevel = null;
	private boolean levelCreated = false;
	private float alphaText = 1.0F;
	
	public boolean setupComplete = false;	
	
	public Master() {
		ActiveUtils.setActiveMaster(this);
	}
	
	public void setData(Graphics g, int width, int height, int ticks) {
		this.g2d = (Graphics2D)g;
		this.width = width;
		this.height = height;
		this.ticks = ticks;
	}
	
	public Graphics2D updateMasterGraphics() {
		
		if (!setupComplete) {
			this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			this.setupComplete = true;
		}
		this.updateStars();
		this.paintLevel();
		return g2d;
	}
	
	public void paintBackground() {
		this.g2d.setColor(Color.BLACK);
		this.g2d.fillRect(0, 0, this.width, this.height);
	}
	
	public void updateStars() {
		if (this.ticks % 100 == 0 && this.ticks != this.lastGoodTick) {
			this.lastGoodTick = this.ticks;
			this.paintBackground();
			Random r = new Random();
			int limit = 50;
			this.g2d.setColor(Color.WHITE);
			for (int i = 0; i < limit; i++) {
				int x = r.nextInt(this.width);
				int y = r.nextInt(this.height);
				this.g2d.fillRect(x, y, 3, 3);
			}
		}
	}
	
	public void paintLevel() {
		if (this.ticks < 150) {
			return;
		}

		if (this.activeLevel != null) {
			if (!this.levelCreated) {
				this.activeLevel.createLevel();
				this.levelCreated = true;
			}
			
			if (this.ticks >= 550 && this.ticks < 660) {
				this.g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaText));
				this.alphaText -= 0.01F;
				if (this.alphaText < 0F) {
					this.alphaText = 0F;
				}
			}
			
			if (this.ticks < 660) {
				this.g2d.setColor(Color.WHITE);
				this.g2d.setFont(new Font("Arial", Font.BOLD, 48));
				this.g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				this.g2d.drawString("Level #" + Integer.toString(this.activeLevel.getLevelNumber()) + ": " + this.activeLevel.getName(), 40, 80);
				this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			}
			
			for (GraphicsObj go : this.activeLevel.getGraphics()) {
				go.setPosition(this.width / 2 - go.getWidth(), this.height - go.getHeight());
				Point p = go.getPosition();
				BufferedImage bi = go.getImage();
				this.g2d.drawImage(bi, (int)p.getX(), (int)p.getY(), bi.getWidth(), bi.getHeight(), null);
			}
		}
	}
}
