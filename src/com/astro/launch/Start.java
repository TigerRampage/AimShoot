package com.astro.launch;

import java.awt.EventQueue;

import com.astro.component.Window;

public class Start {

	private static Game gameInstance;
	public static Window windowInstance;
	private static String[] arguments;

	public static void main(String[] args) {
		arguments = args;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				gameInstance = new Game(arguments);
				windowInstance = new Window(gameInstance);
				gameInstance.start();
			}
		});
	}
}
