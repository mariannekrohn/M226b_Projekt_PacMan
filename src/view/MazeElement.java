package view;

import controller.MyApplet;
import model.Draw;
import model.Element;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der einzelnen Felder bzw. Labyrinth-Elemente
 * @author Marianne Krohn
 */
public class MazeElement extends Element implements Draw {
	
	private int gridSize;
	/**
	 * Konstruktor
	 * @param window PApplet
	 * @param xPos x-Koordinaten des Feldes
	 * @param yPos y-Koordinaten des Feldes
	 */
	public MazeElement(MyApplet window, int xPos, int yPos) {
		super(window, xPos, yPos);
		this.gridSize = 24;
	}

	/**
	 * Füllt die einzelnen Felder auf dem Spielfeld aus
	 */
	@Override
	public void draw() {
		window.fill(0, 51, 102);
		window.rect(xPos, yPos, gridSize, gridSize);
	}
	
}
