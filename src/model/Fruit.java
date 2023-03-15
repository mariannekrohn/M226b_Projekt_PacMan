package model;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der Früchte
 * @author Marianne Krohn
 *
 */
public class Fruit extends Item implements Action{
	
	private ArrayList fruit;
	
	/**
	 * Konstruktor
	 * @param type Art des Gegenstandes
	 * @param value Wert des Gegenstandes
	 * @param fruit Art der Frucht
	 */
	public Fruit(PApplet window, int xPos, int yPos, int length, int height, String type, int value, ArrayList fruit) {
		super(window, xPos, yPos, length, height, type, value);
		this.fruit = fruit;
	}






	/**
	 * Blendet die Früchte ein und aus und platziert sie dabei zufällig auf dem Spielfeld
	 */
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
