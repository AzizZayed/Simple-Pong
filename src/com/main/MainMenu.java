package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * the main menu at the start of the game
 * 
 * @author Zayed
 *
 */
public class MainMenu extends MouseAdapter {

	public boolean active; // true if main menu is displaying

	// Play button
	private Rectangle playBtn; // Play Button
	private String playTxt = "Play";
	private boolean pHighlight = false; // true if the mouse hovered over the Play button

	// Quit button
	private Rectangle quitBtn; // Quit Button
	private String quitTxt = "Quit";
	private boolean qHighlight = false; // true if the mouse hovered over the Quit button

	private Font font;

	/**
	 * constructor
	 * 
	 * @param game - the Game object
	 */
	public MainMenu(Game game) {

		active = true;
		game.start();

		// position and dimensions of each button
		int x, y, w, h;

		w = 300;
		h = 150;

		y = Game.HEIGHT / 2 - h / 2;

		x = Game.WIDTH / 4 - w / 2;
		playBtn = new Rectangle(x, y, w, h);

		x = Game.WIDTH * 3 / 4 - w / 2;
		quitBtn = new Rectangle(x, y, w, h);

		font = new Font("Roboto", Font.PLAIN, 100);
	}

	/**
	 * Draw buttons (rectangles) and text in the Main Menu
	 * 
	 * @param g - Graphics object used to draw everything
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setFont(font);

		// draw buttons
		g.setColor(Color.black);
		if (pHighlight)
			g.setColor(Color.white);
		g2d.fill(playBtn);

		g.setColor(Color.black);
		if (qHighlight)
			g.setColor(Color.white);
		g2d.fill(quitBtn);

		// draw button borders
		g.setColor(Color.white);
		g2d.draw(playBtn);
		g2d.draw(quitBtn);

		// draw text in buttons

		int strWidth, strHeight;

		// Play Button text
		strWidth = g.getFontMetrics(font).stringWidth(playTxt);
		strHeight = g.getFontMetrics(font).getHeight();

		g.setColor(Color.green);
		g.drawString(playTxt, (int) (playBtn.getX() + playBtn.getWidth() / 2 - strWidth / 2),
				(int) (playBtn.getY() + playBtn.getHeight() / 2 + strHeight / 4));

		// Quit Button text
		strWidth = g.getFontMetrics(font).stringWidth(quitTxt);
		strHeight = g.getFontMetrics(font).getHeight();

		g.setColor(Color.red);
		g.drawString(quitTxt, (int) (quitBtn.getX() + quitBtn.getWidth() / 2 - strWidth / 2),
				(int) (quitBtn.getY() + quitBtn.getHeight() / 2 + strHeight / 4));

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		Point p = e.getPoint();

		if (playBtn.contains(p))
			active = false;
		else if (quitBtn.contains(p))
			System.exit(0);

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		Point p = e.getPoint();

		// determine if mouse is hovering inside one of the buttons
		pHighlight = playBtn.contains(p);
		qHighlight = quitBtn.contains(p);

	}

}
