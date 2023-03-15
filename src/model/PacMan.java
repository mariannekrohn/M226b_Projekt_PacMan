package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Funktionen der Pac-Man-Figur die vom Spieler
 * gesteuert wird.
 * 
 * @author Schule
 *
 */
public class PacMan extends Character {

	private int score;
	private int lives;

	public PacMan(PApplet window, int xPos, int yPos, int length, int height, String name, int color) {
		super(window, xPos, yPos, length, height, name, color);
		this.score = 0;
		this.lives = 3;
	}

	@Override
	public void moveUp() {
		setyPos(getyPos() - 10);
		System.out.println("x: " + getxPos() + ", y: " + getyPos());
	}

	/**
	 * Lässt den Spieler die Pac-Man-Figur mithilfe der Pfeil- Tasten steuern
	 */
	@Override
	public void moveDown() {
		setyPos(getyPos() + 10);
		System.out.println("x: " + getxPos() + ", y: " + getyPos());
	}

	@Override
	public void moveRight() {
		setxPos(getxPos() + 10);
		System.out.println("x: " + getxPos() + ", y: " + getyPos());
	}

	@Override
	public void moveLeft() {
		setxPos(getxPos() - 10);
		System.out.println("x: " + getxPos() + ", y: " + getyPos());
	}

	/**
	 * Addiert die Werte der eingesammelten Gegenstände zum Punktestand des Spielers
	 */
	public void collectItems() {

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
