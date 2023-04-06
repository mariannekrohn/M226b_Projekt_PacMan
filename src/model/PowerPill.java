package model;

import controller.MyApplet; 

/**
 * Verwaltet die Eigenschaften der PowerPills
 * @author Schule
 */
public class PowerPill extends Item {

	/**
	 * Konstruktor
	 * @param window MyApplet
	 * @param xPos x-Koordinaten der PowerPill
	 * @param yPos y-Koordinaten der PowerPill
	 */
	public PowerPill(MyApplet window, int xPos, int yPos) {
		super(window, xPos, yPos, 12, 12, 50, 0xFFD99722);
	}
}
