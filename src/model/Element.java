package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Funktionalitäten die sich alle Character
 * und Gegenstände teilen
 * @author Marianne Krohn
 *
 */
public abstract class Element extends PApplet{
	
	protected int xPos;
	protected int yPos;
	private PApplet window;
	
	/**
	 * Konstruktor
	 * @param window
	 * @param xPos x-Position des Elements
	 * @param yPos y-Position des Elements
	 */
	public Element(PApplet window, int xPos, int yPos) {
		this.window = window;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	/**
	 * Berechnet den Abstand zwischen zwei Elementen
	 * @return distance Distanz als double
	 */
	public static double calculateDistance(Element e1, Element e2) {
		double distance = 0;
		float a = abs(e1.getXPos() - e2.getXPos());
		float b = abs(e1.getYPos() - e2.getYPos());

		distance = Math.sqrt(a * a + b * b);
		return distance;
	}


	public PApplet getWindow() {
		return window;
	}
	
	public int getWindowHeight() {
		return window.height;
	}
	
	public int getWindowWidth() {
		return window.width;
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
