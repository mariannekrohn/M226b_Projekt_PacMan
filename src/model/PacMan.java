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
	 * Konstruktor
	 * Setzt Punktezahl und Leben des Spielers auf ihre Standardwerte und definiert
	 * die Bewegungsgrösse des Charakters
	 * @param window
	 */
	public PacMan(PApplet window, int xPos, int yPos) {
		super(window, xPos, yPos, 16, 16, "Pac Man", 0xFFFFFF00);
		this.score = -5; // max. 1655
		this.lives = 3;
		this.step = 6;
	}

	/**
	 * Ermöglicht die Aufwärtsbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveUp() {
		if (yPos > 0 + 12) {
			yPos -= step;
		}
	}

	/**
	 * Ermöglicht die Abwärtsbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveDown() {
		if (yPos < getWindowHeight() - 12) {
			yPos += step;
		}
	}

	/**
	 * Ermöglicht die Linksbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveLeft() {
		if (xPos > 0 + 12) {
			xPos -= step;
		}
	}
	
	/**
	 * Ermöglicht die Rechtsbewegung der PacMan-Figur innerhalb der Spielfeldgrösse.
	 */
	@Override
	public void moveRight() {
		if (xPos < getWindowWidth() - 12) {
			xPos += step;
		}
	}



	/**
	 * Getter für den Punktestand des Spielers
	 * @return Punktestand als int
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Setter für den Punktestand des Spielers
	 * @param score als int
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Getter für die Leben des Spielers
	 * @return Leben als int
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * Setter für die Leben des Spielers
	 * @param lives als int
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}

}
