package model;

import controller.MyApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der Früchte
 * @author Marianne Krohn
 *
 */
public class Fruit extends Item{
	
	/**
	 * Konstruktor
	 * @param type Art des Gegenstandes
	 * @param value Wert des Gegenstandes
	 * @param fruit Art der Frucht
	 */

	public Fruit(MyApplet window, int xPos, int yPos) {
		super(window, xPos, yPos, 14, 14, 200, 0xFF009000);
	}
}
