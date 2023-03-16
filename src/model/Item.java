package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der Gegenstände.
 * @author Marianne Krohn
 *
 */
public class Item extends Element {
	
	private String type;
	private int value;
	
	/**
	 * Konstruktor
	 * @param type Art des Gegenstandes
	 * @param value Punkte-Wert des Gegenstandes
	 */
	public Item(PApplet window, int xPos, int yPos, int length, int width, String type, int value) {
		super(window, xPos, yPos, length, width);
		this.type = type;
		this.value = value;
	}

	
	/**
	 * Entfernt einen eingesammelten Gegenstand vom Spielfeld.
	 */
	public void removeItem() {
		
	}
	

}
