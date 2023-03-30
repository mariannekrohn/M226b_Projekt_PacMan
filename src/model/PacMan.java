package model;

import controller.MyApplet;
import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Funktionen der Pac-Man-Figur die vom Spieler
 * gesteuert wird.
 * 
 * @author Marianne Krohn
 *
 */
public class PacMan extends Character implements Draw {

	private int score;
	private int lives;

	/**
	 * Konstruktor Setzt Punktezahl und Leben des Spielers auf ihre Standardwerte
	 * und definiert die Bewegungsgrösse des Charakters
	 * 
	 * @param window
	 */
	public PacMan(MyApplet window, int xPos, int yPos, int score, int lives) {
		super(window, xPos, yPos, 16, 16, "Pac Man", 0xFFFFFF00);
		this.score = score;
		this.lives = lives;
	}
	
//	@Override
//	public void draw() {
//		getWindow().fill(0xFFFFFF00);
//		getWindow().arc(xPos, yPos, height, height, 0, PI+QUARTER_PI, PIE);
////		getWindow().ellipse(xPos, yPos, height, height);
//
//	}
	
	/**
	 * Zeigt den Punktestand und die Leben des Spielers an
	 */
	public void displayStatus() {
		window.textAlign(window.LEFT);
		window.textSize(20);
		window.fill(150);
		window.text("Score: " + getScore(), 20, 504);

		window.textSize(20);
		window.fill(150);
		window.text("Lives: " + getLives(), 150, 504);
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
