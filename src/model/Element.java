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
	protected int length;
	protected int width;
	private PApplet window;
	
	/**
	 * Konstruktor
	 * @param window
	 * @param xPos x-Position des Elements
	 * @param yPos y-Position des Elements
	 * @param length Breite des Elements
	 * @param height Höhe des Elements
	 */
	public Element(PApplet window, int xPos, int yPos, int length, int width) {
		this.window = window;
		this.xPos = xPos;
		this.yPos = yPos;
		this.length = length;
		this.width = width;
	}

	/**
	 * Getter für PApplet
	 * @return window als PApplet
	 */
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
