package com.astro.launch;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.astro.graphics.Master;
import com.astro.level.LevelHandler;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 5769260572987666750L;

	private String[] arguments = null;
	
	private Thread loopThread = null;
	
	private boolean isRunning = false;
	
	public int tickCount = 0;
	
	public static Master master = new Master();
	
	public Game(String[] args) {
		this.registerArguments(args);
//		while (this.getWidth() == 0 || this.getHeight() == 0) {
//			this.setBounds(new Rectangle(this.getMaximumSize()));
//		}
	}
	
	private void registerArguments(String[] args) {
		this.arguments = args;
		for (@SuppressWarnings("unused") String s : this.arguments) {
			//TODO: reg args
		}
	}
	
	public synchronized void start() {
		if (isRunning) {
			return;
		}
		
		this.isRunning = true;
		this.loopThread = new Thread(this);
		this.loopThread.start();
	}
	
	public synchronized void stop() {
		if (!isRunning) {
			return;
		}
		
		this.isRunning = false;
	}

	public void beginGameLoop() {
		long beginTime = System.nanoTime();
		double tick = 60.0D;
		double ns = 1000000000 / tick;
		double delta = 0.0D;
		long timer = System.currentTimeMillis();
		int ticks = 0;
		int frames = 0;
		
		while (this.isRunning) {
			long currentTime = System.nanoTime();
			delta += (currentTime - beginTime) / ns;
			beginTime = currentTime;
			
			while (delta >= 1) {
				ticks++;
				this.tick();
				delta--;
			}
			
			frames++;
			this.render();
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("Ticks: " + ticks + " Frames: " + frames);
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	public void tick() {
		tickCount++;
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		
		LevelHandler.setLevel(1);
		Graphics g = bs.getDrawGraphics();
		
		master.setData(g, this.getWidth(), this.getHeight(), this.tickCount);
		g = master.updateMasterGraphics();
		g.dispose();
		bs.show();
	}
	
	@Override
	public void run() {
		this.beginGameLoop();
	}
}
