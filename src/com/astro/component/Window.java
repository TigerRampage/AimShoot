package com.astro.component;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.astro.launch.Game;

public class Window {
	public Window(Game canvas) {
		JFrame frm = new JFrame("Astro Barrier");
		frm.getContentPane().setLayout(new BorderLayout());
		canvas.setBounds(frm.getContentPane().getBounds());
		frm.getContentPane().add(canvas, BorderLayout.CENTER);
		frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frm.setResizable(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
