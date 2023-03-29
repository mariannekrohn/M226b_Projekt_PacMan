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

	/**
	 * Konstruktor Setzt Punktezahl und Leben des Spielers auf ihre Standardwerte
	 * und definiert die Bewegungsgrösse des Charakters
	 * 
	 * @param window
	 */
	public PacMan(PApplet window, int xPos, int yPos, int score, int lives) {
		super(window, xPos, yPos, 16, 16, "Pac Man", 0xFFFFFF00);
		this.score = score;
		this.lives = lives;
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
