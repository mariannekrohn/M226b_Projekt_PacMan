package view;

import model.Element;
import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der einzelnen Felder bzw. Labyrinth-Elemente
 * 
 * @author Marianne Krohn
 */
public class MazeElement extends Element {
	
	private int gridSize;

	/**
	 * Konstruktor
	 * @param window PApplet
	 * @param xPos x-Position des Feldes
	 * @param yPos y-Position des Feldes
	 */
	public MazeElement(PApplet window, int xPos, int yPos) {
		super(window, xPos, yPos, 24, 24);
		this.gridSize = 24;
	}

	/**
	 * Füllt die einzelnen Felder auf dem Spielfeld aus
	 */
	public void display() {
		getWindow().fill(0, 51, 102);
		getWindow().rect(xPos, yPos, gridSize, gridSize);
	}
	

}
