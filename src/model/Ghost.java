package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der Geister
 * @author Marianne Krohn
 *
 */
public class Ghost extends Character implements Move {
	
	private int step;

	/**
	 * Konstruktor
	 * @param window PApplet
	 * @param xPos x-Position des Geistes
	 * @param yPos y-Position des Geistes
	 * @param name Name des Geistes
	 * @param color Farbe des Geistes
	 */
	public Ghost(PApplet window, int xPos, int yPos, String name, int color) {
		super(window, xPos, yPos, 16, 16, name, color);
		this.step = 24;
	}

	/**
	 * Bewegt die Geister in zufälligen Mustern und lässt sie Pac-Man
	 * verfolgen, sobald er in ihre Nähe kommt.
	 */
	@Override
	public void moveUp() {
		if (yPos > 12) {
			yPos -= step;
		}
	}

	@Override
	public void moveDown() {
		if (yPos < 468) {
			yPos += step;
		}
		
	}
	
	@Override
	public void moveLeft() {
		if (xPos > 12) {
			xPos -= step;
		}
		
	}

	@Override
	public void moveRight() {
		if (xPos < 660) {
			xPos += step;
		}
		
	}





}
