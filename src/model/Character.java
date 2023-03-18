package model;

import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten welche alle Charaktere 
 * sich teilen
 * @author Marianne Krohn
 *
 */
public abstract class Character extends Element implements Action {
	

	private String name;
	private int color;
	
	public Character(PApplet window, int xPos, int yPos, int length, int width, String name, int color) {
		super(window, xPos, yPos, length, width);
		this.name = name;
		this.color = color;
	}

	
	public void chooseCharacterColor() {
		getWindow().fill(color);
	}
	
	public void drawCharacterShape() {
		getWindow().ellipse(xPos, yPos, length, length);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
