package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Funktionen der Pac-Man-Figur die vom Spieler
 * gesteuert wird.
 * 
 * @author Marianne Krohn
 *
 */
public class PacMan extends Character implements Move {

	private int score;
	private int lives;
	private int step;

	/**
	 * Konstrukto Setzt Punktezahl und Leben des Spielers auf ihre Standardwerte und
	 * definiert die Bewegungsgrösse des Charakters
	 * 
	 * @param window
	 */
	public PacMan(PApplet window, int xPos, int yPos) {
		super(window, xPos, yPos, 16, 16, "Pac Man", 0xFFFFFF00);
		this.score = -5; // max. 1655
		this.lives = 3;
		this.step = 24;
	}

	/**
	 * Bewegt die PacMan-Figur aufwärts.
	 */
	@Override
	public void moveUp() {
		if (yPos > 12) {
			yPos -= step;
		}
	}

	/**
	 * Bewegt die PacMan-Figur abwärts.
	 */
	@Override
	public void moveDown() {
		if (yPos < 468) {
			yPos += step;
		}
	}

	/**
	 * Bewegt die PacMan-Figur nach links.
	 */
	@Override
	public void moveLeft() {
		if (xPos > 12) {
			xPos -= step;
		}
	}

	/**
	 * Bewegt die PacMan-Figur nach rechts.
	 */
	@Override
	public void moveRight() {
		if (xPos < 660) {
			xPos += step;
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
