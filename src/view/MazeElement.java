package view;

import model.Element;
import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der einzelnen Felder bzw. Labyrinth-Elementen
 * @author Schule
 *
 */
public class MazeElement extends Element {
	
	int gridSize = 24;

	/**
	 * Konstruktor
	 * @param window PApplet
	 * @param xPos x-Position des Feldes
	 * @param yPos y-Position des Feldes
	 */
	public MazeElement(PApplet window, int xPos, int yPos) {
		super(window, xPos, yPos, 24, 24);
		
	}


	
	/**
	 * Füllt die einzelnen Felder auf dem Spielfeld aus.
	 */
	public void display() {
		getWindow().stroke(1);
		getWindow().fill(255, 0, 0);
		getWindow().rect(xPos, yPos, gridSize, gridSize);
	}
}
