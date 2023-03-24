package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften der Punkte-Elemente die von 
 * Pac-Man eingesammelt werden
 * 
 * @author Marianne Krohn 
 *
 */
public class Point extends Item {

	/**
	 * Konstruktor
	 * @param window PApplet
	 * @param xPos x-Position des Punkt-Elements
	 * @param yPos y-Position des Punkt-Elements
	 */
	public Point(PApplet window, int xPos, int yPos) {
		super(window, xPos, yPos, 5, 5, 5, 0xFFD99722);
		
	}
}
