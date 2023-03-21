package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten welche alle Charaktere 
 * sich teilen
 * @author Marianne Krohn
 *
 */
public class Character extends Element implements Draw{
	
	private String name;
	private int color;
	
	/**
	 * Konstruktor
	 * @param window PApplet
	 * @param xPos x-Position des Charakters
	 * @param yPos y-Position des Charakters
	 * @param length Länge des Charakaters
	 * @param width Breite des Charakters
	 * @param name Name des Charakters
	 * @param color Farbe des Charakters
	 */
	public Character(PApplet window, int xPos, int yPos, int length, int width, String name, int color) {
		super(window, xPos, yPos, length, width);
		this.name = name;
		this.color = color;
	}

	@Override
	public void draw() {
			getWindow().fill(color);
			getWindow().ellipseMode(CENTER);
			getWindow().ellipse(xPos, yPos, length, length);

	}

	/**
	 * Getter für den Namen des Charakters
	 * @return Name als String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter für den Namen des Charakters
	 * @param name als String
	 */
	public void setName(String name) {
		this.name = name;
	}

}
