package view;

import controller.MyApplet;
import model.Element;
import processing.core.PConstants;

public class GameInfo extends Element {
	
	private int gridSize;
	
	/**
	 * Verwaltet die Eigenschafen und Fähigkeiten der informationsbasierten 
	 * game state screens
	 * @param window
	 * @param xPos
	 * @param yPos
	 */
	public GameInfo(MyApplet window, int xPos, int yPos) {
		super(window, xPos, yPos);
		this.gridSize = 24;
	}

	/**
	 * Zeichnet den Startbildschirm des Spiels
	 */
	public void drawStartScreen() {
		window.fill(0, 0, 0, 150);
		window.rect(0, 0, getYPos() * gridSize, (getXPos() + 2) * gridSize);
		

		window.textAlign(PConstants.CENTER);
		window.textSize(20);
		window.fill(190);
		window.text("Navigate With Your Arrow Keys", window.width / 2 , 175);

		window.textSize(50);
		window.fill(0xFFD99722);
		window.text("Press Space", window.width / 2, 275);
		window. text("to Start", window.width / 2, 325);
	}
	
	/**
	 * Zeichnet den Endbildschirm des Spiels, wenn der Spieler gewonnen hat
	 */
	public void drawSuccess() {
		window.textAlign(PConstants.CENTER);
		window.textSize(60);
		window.fill(0xFFD99722);
		window.text("YOU WIN!", window.width / 2, 225);
		
		window.textAlign(PConstants.CENTER);
		window.textSize(20);
		window.fill(190);
		window.text("Press SPACE to Beat Your Highscore.", window.width / 2 , 335);

	}

	/**
	 * Zeichnet den Endbildschirm des Spiels, wenn der Spieler verloren hat
	 */
	public void drawFail() {
		window.textAlign(PConstants.CENTER);
		window.textSize(60);
		window.fill(0, 51, 102);
		window.text("YOU LOOSE!", window.width / 2, 225);
		
		window.textAlign(PConstants.CENTER);
		window.textSize(20);
		window.fill(190);
		window.text("Press SPACE to Try Again.", window.width / 2 , 335);

	}

}
