package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Funktionen der Pac-Man-Figur die vom Spieler
 * gesteuert wird.
 * 
 * @author Marianne Krohn
 *
 */
public class PacMan2 implements Move {
	private int xPos;
	private int yPos;
	private int length;
	private PApplet window;
	
	private int color;
	private int score;



	public PacMan2(PApplet window, int xPos, int yPos) {
		this.window = window;
		this.xPos = xPos;
		this.yPos = yPos;
		this.length = 16;
		this.color =  0xFFFFFF00;
		this.score = 0;
	}
	
	public void drawCharacter() {
		window.fill(color);

		window.ellipse(xPos, yPos, length, length);

}

	/**
	 * Ermöglicht die Aufwärtsbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveUp() {
		if (yPos > 0 + 12) {
			yPos -= 6;
		}
	}

	/**
	 * Ermöglicht die Abwärtsbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveDown() {
		if (yPos < 480 - 12) {
			yPos += 6;
			xPos += 0;
		}
	}

	/**
	 * Ermöglicht die Rechtsbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveRight() {
		if (xPos < 672 - 12)
			xPos += 6;
	}

	/**
	 * Ermöglicht die Linksbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveLeft() {
		if (xPos > 0 + 12) {
			xPos -= 6;
		}
	}
	
	public int getXPos() {
		return xPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}


}
