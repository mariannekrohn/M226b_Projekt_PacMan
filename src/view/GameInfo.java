package view;

import model.Element;
import processing.core.PApplet;

public class GameInfo extends Element {
	
	private int gridSize;
	
	/**
	 * Verwaltet die Eigenschafen und Fähigkeiten der informationsbasierten 
	 * game state screens
	 * @param window
	 * @param xPos
	 * @param yPos
	 */
	public GameInfo(PApplet window, int xPos, int yPos) {
		super(window, xPos, yPos);
		this.gridSize = 24;
	}

	/**
	 * Zeichnet den Startbildschirm des Spiels
	 */
	public void drawStartScreen() {
		getWindow().fill(0, 0, 0, 150);
		getWindow().rect(0, 0, getYPos() * gridSize, (getXPos() + 2) * gridSize);
		

		getWindow().textAlign(getWindow().CENTER);
		getWindow().textSize(20);
		getWindow().fill(190);
		getWindow().text("Navigate With Your Arrow Keys", getWindowWidth() / 2 , 175);

		getWindow().textSize(50);
		getWindow().fill(0xFFD99722);
		getWindow().text("Press Space", getWindowWidth() / 2, 275);
		getWindow(). text("to Start", getWindowWidth() / 2, 325);
	}
	
	/**
	 * Zeichnet den Endbildschirm des Spiels, wenn der Spieler gewonnen hat
	 */
	public void drawSuccess() {
		getWindow().textAlign(getWindow().CENTER);
		getWindow().textSize(50);
		getWindow().fill(0xFFD99722);
		getWindow().text("YOU WIN!", getWindowWidth() / 2, 275);

	}

	/**
	 * Zeichnet den Endbildschirm des Spiels, wenn der Spieler verloren hat
	 */
	public void drawFail() {
		getWindow().textAlign(getWindow().CENTER);
		getWindow().textSize(50);
		getWindow().fill(0, 51, 102);
		getWindow().text("YOU LOOSE!", getWindowWidth() / 2, 275);

	}

}
