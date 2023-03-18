package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Funktionen der Pac-Man-Figur die vom Spieler
 * gesteuert wird.
 * 
 * @author Marianne Krohn
 *
 */
public class PacMan extends Character {

	private int score;
	private int lives;

	public PacMan(PApplet window) {
		super(window, 400, 300, 20, 20, "Pac Man", 0xFFFFFF00);
		this.score = 0;
		this.lives = 3;
	}

	/**
	 * Ermöglicht die Aufwärtsbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveUp() {
		if (yPos > 0 + 12) {
			yPos -= 10;
		}
	}

	/**
	 * Ermöglicht die Abwärtsbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveDown() {
		if (yPos < 480 - 12) {
			yPos += 10;
		}
	}

	/**
	 * Ermöglicht die Rechtsbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveRight() {
		if (xPos < 672 - 12)
			xPos += 10;
	}

	/**
	 * Ermöglicht die Linksbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveLeft() {
		if (xPos > 0 + 12) {
			xPos -= 10;
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

}
