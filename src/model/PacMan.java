package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Funktionen der Pac-Man-Figur
 * die vom Spieler gesteuert wird.
 * @author Schule
 *
 */
public class PacMan extends Character {
	
	public PacMan(PApplet window) {
		super(window, 200, 300, 20, 20, "Pac Man", 0xFFFF0000);
		// TODO Auto-generated constructor stub
		this.score = 0;
		this.lives = 3;
	}


	private int score;
	private int lives;
	

	


	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	public void moveUp() {
		yPos -= 10;
	}
	
	public void moveDown() {
		yPos += 10;
	}
	
	public void moveRight() {
		xPos += 10;
	}
	
	public void moveLeft() {
		xPos += 10;
	}

	/**
	 * Addiert die Werte der eingesammelten Gegenstände zum
	 * Punktestand des Spielers
	 */
	public void collectItems() {
		
	}

	/**
	 * Lässt den Spieler die Pac-Man-Figur mithilfe der Pfeil-
	 * Tasten steuern
	 */


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
