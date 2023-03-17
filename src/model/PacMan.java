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


	@Override
	public void moveUp() {
		yPos -= 10;
	}

	/**
	 * Lässt den Spieler die Pac-Man-Figur mithilfe der Pfeil- Tasten steuern
	 */
	@Override
	public void moveDown() {
		yPos += 10;
		}

	@Override
	public void moveRight() {
		xPos += 10;
		}

	@Override
	public void moveLeft() {
		xPos -= 10;
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
