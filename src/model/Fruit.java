package model;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der Früchte
 * @author Marianne Krohn
 *
 */
public class Fruit extends Item{

	private ArrayList fruit;
	
	/**
	 * Konstruktor
	 * @param type Art des Gegenstandes
	 * @param value Wert des Gegenstandes
	 * @param fruit Art der Frucht
	 */

	public Fruit(PApplet window, int xPos, int yPos) {
		super(window, xPos, yPos, 14, 14, 200, 0xFF009000);
	}



}
