package com.main;

import javax.swing.JFrame;

public class Window {

	/**
	 * Create the frame.
	 * 
	 * @param title: desired title of the game
	 * @param game:  the game
	 */
	public Window(String title, Game game) {
		JFrame frame = new JFrame(title);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game); //Game inherits from Canvas so it's a component Object and can be added on a JFrame
		frame.pack();
		frame.setLocationRelativeTo(null); //ghetto way of centering the window
		frame.setVisible(true);
	}

}
