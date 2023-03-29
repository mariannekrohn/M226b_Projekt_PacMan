package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der Gegenstände.
 * @author Marianne Krohn
 *
 */
public abstract class Item extends Element implements Draw {
	
	private int height;
	private int width;
	private int value;
	private int color;
	
	/**
	 * Konstruktor
	 * @param type Art des Gegenstandes
	 * @param value Punkte-Wert des Gegenstandes
	 * @param color Farbe des Gegenstandes
	 */
	public Item(PApplet window, int xPos, int yPos, int height, int width, int value, int color) {
		super(window, xPos, yPos);
		this.height = height;
		this.width = width;
		this.value = value;
		this.color = color;
	}

	/**
	 * Zeichnet den Gegenstand
	 */
	public void draw() {
		getWindow().fill(color);
		getWindow().ellipse(xPos, yPos, height, height);
		
	}

	public int getValue() {
		return value;
	}
}
