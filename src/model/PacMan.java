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


	public PacMan(PApplet window, int xPos, int yPos, int length, int height, String name, int color) {
		super(window, xPos, yPos, length, height, name, color);
		this.score = 0;
		this.lives = 3;
	}

	@Override
	public void moveUp() {
		yPos -= 10;
		System.out.println("x: " + xPos + ", y: " + yPos);
	}

	/**
	 * Lässt den Spieler die Pac-Man-Figur mithilfe der Pfeil- Tasten steuern
	 */
	@Override
	public void moveDown() {
		yPos += 10;
		System.out.println("x: " + xPos + ", y: " + yPos);
		}

	@Override
	public void moveRight() {
		xPos += 10;
		System.out.println("x: " + xPos + ", y: " + yPos);
		}

	@Override
	public void moveLeft() {
		xPos -= 10;
		System.out.println("x: " + xPos + ", y: " + yPos);
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