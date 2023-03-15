package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten welche alle Charaktere 
 * sich teilen
 * @author Marianne Krohn
 *
 */
public abstract class Character extends Dimensions implements Action {
	
	private String name;
	private int color;
	
	public Character(PApplet window, int xPos, int yPos, int length, int height, String name, int color) {
		super(window, xPos, yPos, length, height);
		this.name = name;
		this.color = color;
		
	}
	
	public void drawCharacter() {
		window.fill(color);
		window.circle(yPos, yPos, length);
	}

}
