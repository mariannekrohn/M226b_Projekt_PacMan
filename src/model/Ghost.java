package model;

import controller.MyApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der Geister
 * @author Marianne Krohn
 *
 */
public class Ghost extends Character {

	/**
	 * Konstruktor
	 * @param window PApplet
	 * @param xPos x-Position des Geistes
	 * @param yPos y-Position des Geistes
	 * @param name Name des Geistes
	 * @param color Farbe des Geistes
	 */
	public Ghost(MyApplet window, int xPos, int yPos, String name, int color) {
		super(window, xPos, yPos, 16, 16, name, color);
	}

}
