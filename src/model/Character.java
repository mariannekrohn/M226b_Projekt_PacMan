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
	
	public Character(PApplet window, int xPos, int yPos, int length, int height, String name, int color) {
		super(window, xPos, yPos, length, height);
		this.name = name;
		this.color = color;
		
	}
	
	public void drawCharacter() {
		getWindow().fill(color);
		getWindow().circle(getyPos(), getyPos(), getLength());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
