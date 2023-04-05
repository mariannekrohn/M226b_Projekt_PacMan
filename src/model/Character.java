package model;

import controller.MyApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten welche alle Charaktere sich
 * teilen
 * 
 * @author Marianne Krohn
 *
 */
public abstract class Character extends Element {

	private int color;
	private int step;
	private int height;
	private int width;
	
	public Character(MyApplet window, int xPos, int yPos, int height, int width, String name, int color) {
		super(window, xPos, yPos);
		this.height = height;
		this.width = width;
		this.color = color;
		this.step = 24;
	}

	/**
	 * Ermöglicht die Aufwärtsbewegung eines Charakters bis der obere Spielfeldrand
	 * erreicht ist.
	 */
	public void moveUp() {
		if (yPos > 12) {
			yPos -= step;
		}
	}

	/**
	 * Ermöglicht die Abwärtsbewegung eines Charakters bis der untere Spielfeldrand
	 * erreicht ist.
	 */
	public void moveDown() {
		if (yPos < window.getWindowHeight() - 12) {
			yPos += step;
		}
	}

	/**
	 * Ermöglicht die Linksbewegung eines Charakters bis der linke Spielfeldrand
	 * erreicht ist.
	 */
	public void moveLeft() {
		if (xPos > 12) {
			xPos -= step;
		}
	}

	/**
	 * Ermöglicht die Rechtsbewegung eines Charakter bis der rechte Spielfeldrand
	 * erreicht ist.
	 */
	public void moveRight() {
		if (xPos < window.getWindowWidth() - 12) {
			xPos += step;
		}
	}
	
	public int getColor() {
		return color;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
