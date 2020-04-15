package com.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * class for the ball in the game
 * 
 * @author Zayed
 *
 */
public class Ball {

	public static final int SIZE = 16;

	private int x, y; // position of top left corner of square
	private int xVel, yVel; // either 1 or -1
	private int speed = 5; // speed of the ball

	/**
	 * constructor
	 */
	public Ball() {
		reset();
	}

	/**
	 * setup initial position and velocity
	 */
	private void reset() {
		// initial position
		x = Game.WIDTH / 2 - SIZE / 2;
		y = Game.HEIGHT / 2 - SIZE / 2;

		// initial velocity
		xVel = Game.sign(Math.random() * 2.0 - 1);
		yVel = Game.sign(Math.random() * 2.0 - 1);
	}

	/**
	 * Draw ball (a square)
	 * 
	 * @param g: Graphics object used to draw everything
	 */
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, SIZE, SIZE);
	}

	/**
	 * update position AND collision tests
	 * 
	 * @param lp: left paddle
	 * @param rp: right paddle
	 */
	public void update(Paddle lp, Paddle rp) {

		// update position
		x += xVel * speed;
		y += yVel * speed;

		// collisions

		// with ceiling and floor
		if (y + SIZE >= Game.HEIGHT || y <= 0)
			changeYDir();

		// with walls

		if (x + SIZE >= Game.WIDTH) { // right wall
			lp.addPoint();
			reset();
		}
		if (x <= 0) { // left wall
			rp.addPoint();
			reset();
		}
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * switch x direction IF ball going right, go left otherwise, go right
	 */
	public void changeXDir() {
		xVel *= -1;
	}

	/**
	 * switch y direction IF ball going up, go down otherwise, go up
	 */
	public void changeYDir() {
		yVel *= -1;
	}

}
