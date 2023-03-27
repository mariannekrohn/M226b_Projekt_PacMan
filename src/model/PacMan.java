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
	 * Konstruktor Setzt Punktezahl und Leben des Spielers auf ihre Standardwerte
	 * und definiert die Bewegungsgrösse des Charakters
	 * 
	 * @param window
	 */
	public PacMan(PApplet window, int xPos, int yPos, int score, int lives) {
		super(window, xPos, yPos, 16, 16, "Pac Man", 0xFFFFFF00);
		this.score = score;
		this.lives = lives;
		this.step = 24;
	}

	/**
	 * Ermöglicht die Aufwärtsbewegung der PacMan-Figur bis der obere Spielfeldrand
	 * erreicht ist.
	 */
	@Override
	public void moveUp() {
		if (yPos > 12) {
			yPos -= step;
		}
	}

	/**
	 * Ermöglicht die Abwärtsbewegung der PacMan-Figur bis der untere Spielfeldrand
	 * erreicht ist.
	 */
	@Override
	public void moveDown() {
		if (yPos < getWindowHeight()) {
		//if (yPos < 468) {
			yPos += step;
		}
	}

	/**
	 * Ermöglicht die Linksbewegung der PacMan-Figur bis der linke Spielfeldrand
	 * erreicht ist.
	 */
	@Override
	public void moveLeft() {
		if (xPos > 12) {
			xPos -= step;
		}
	}

	/**
	 * Ermöglicht die Rechtsbewegung der PacMan-Figur bis der rechte Spielfeldrand
	 * erreicht ist.
	 */
	@Override
	public void moveRight() {
		if(xPos < getWindowWidth()) {
//		if (xPos < 660) {
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
