package view;

import model.Dimensions;
import processing.core.PApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der einzelnen Felder bzw. Labyrinth-Elementen
 * @author Schule
 *
 */
public class MazeElement extends Dimensions {

	/**
	 * Konstruktor
	 * @param window PApplet
	 * @param xPos x-Position des Feldes
	 * @param yPos y-Position des Feldes
	 */
	public MazeElement(PApplet window, int xPos, int yPos) {
		super(window, xPos, yPos, 25, 25);
		
	}


	
	/**
	 * Füllt die einzelnen Felder auf dem Spielfeld aus.
	 */
	public void display() {
		window.fill(255, 0, 0);
		window.rect(yPos, xPos, length, height);
	}
	

}
