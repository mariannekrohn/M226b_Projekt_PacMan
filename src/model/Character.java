package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten welche alle Charaktere sich
 * teilen
 * 
 * @author Marianne Krohn
 *
 */
public class Character extends Element implements Draw {

	private String name;
	private int color;
	private int step;
	private int height;
	private int width;

	/**
	 * Konstruktor
	 * 
	 * @param window PApplet
	 * @param xPos   x-Position des Charakters
	 * @param yPos   y-Position des Charakters
	 * @param length Länge des Charakaters
	 * @param width  Breite des Charakters
	 * @param name   Name des Charakters
	 * @param color  Farbe des Charakters
	 */
	public Character(PApplet window, int xPos, int yPos, int height, int width, String name, int color) {
		super(window, xPos, yPos);
		this.name = name;
		this.height = height;
		this.width = width;
		this.color = color;
		this.step = 24;
	}

	@Override
	public void draw() {
		getWindow().fill(color);
		getWindow().ellipseMode(CENTER);
		getWindow().ellipse(xPos, yPos, height, height);

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
	 * Ermöglicht die Abwärtsbewegung eines Charakter bis der untere Spielfeldrand
	 * erreicht ist.
	 */
	public void moveDown() {
		if (yPos < getWindowHeight()) {
			// if (yPos < 468) {
			yPos += step;
		}
	}

	/**
	 * Ermöglicht die Linksbewegung eines Charakterss bis der linke Spielfeldrand
	 * erreicht ist.
	 */
	public void moveLeft() {
		if (xPos > 12) {
			xPos -= step;
		}
	}

	/**
	 * Ermöglicht die Rechtsbewegung seines Charakter bis der rechte Spielfeldrand
	 * erreicht ist.
	 */
	public void moveRight() {
		if (xPos < getWindowWidth()) {
//		if (xPos < 660) {
			xPos += step;
		}
	}

	/**
	 * Getter für den Namen des Charakters
	 * 
	 * @return Name als String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter für den Namen des Charakters
	 * 
	 * @param name als String
	 */
	public void setName(String name) {
		this.name = name;
	}

}
