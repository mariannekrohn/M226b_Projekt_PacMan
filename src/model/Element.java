package model;

import controller.MyApplet;

/**
 * Verwaltet die Eigenschaften und Funktionalitäten die sich alle Character
 * und Gegenstände teilen
 * @author Marianne Krohn
 *
 */
public abstract class Element {
	
	protected int xPos;
	protected int yPos;
	public MyApplet window;
	
	/**
	 * Konstruktor
	 * @param window
	 * @param xPos x-Position des Elements
	 * @param yPos y-Position des Elements
	 */
	public Element(MyApplet window, int xPos, int yPos) {
		this.window = window;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	/**
	 * Berechnet den Abstand zwischen zwei Elementen
	 * @return distance Distanz als pdouble
	 */
	public static double calculateDistance(Element e1, Element e2) {
		double distance = 0;
		float a = Math.abs(e1.getXPos() - e2.getXPos());
		float b = Math.abs(e1.getYPos() - e2.getYPos());

		distance = Math.sqrt(a * a + b * b);
		return distance;
	}
	

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}

}
