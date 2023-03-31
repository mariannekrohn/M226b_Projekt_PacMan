package model;

import controller.MyApplet;

/**
 * Verwaltet die Eigenschaften der PowerPills
 * @author Schule
 *
 */
public class PowerPill extends Item {

	/**
	 * Konstruktor
	 * @param window
	 * @param xPos
	 * @param yPos
	 * @param length
	 * @param width
	 * @param type
	 * @param value
	 * @param color
	 */
	public PowerPill(MyApplet window, int xPos, int yPos) {
		super(window, xPos, yPos, 12, 12, 50, 0xFFD99722);
	}





}
