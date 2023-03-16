package controller;

import model.PacMan;
import model.PacMan2;
import processing.core.PApplet;
import view.MazeElement;

/**
 * Verwaltet die Spielkontrolle
 * 
 * @author Marianne Krohn
 *
 */
public class GameController extends PApplet {

	private MazeElement[][] grid;
	private int col;
	private int row;

	PacMan player;
//	PacMan2 player;
	PApplet window;

	private int[][] maze = { 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
			{ 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0 },
			{ 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
			{ 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
			};

	public static void main(String[] args) {
		PApplet.main("controller.GameController");
	}

	// Processing-Methoden
//	public void setup() {
//		player = new PacMan(this, 200, 300, 25, 25, "Pac Man", 0xFFFFFF00);
//
//	}
	
	public void setup() {
//		player = new PacMan2(this);
		player = new PacMan(this, 200, 300, 25, 25, "Pac Man", 0xFFFFFF00);

	}

	public void settings() {
		row = 20;
		col = 28;
		grid = new MazeElement[row][col];

		size(700, 500);
		initializeGrid();

	}

	public void draw() {
		background(0);
//		displayMaze();
		player.drawCharacter();
	}

	/**
	 * Teilt das Spielfeld in ein Raser von 28x25 Feldern auf.
	 */
	public void initializeGrid() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				grid[i][j] = new MazeElement(this, i * 25, j * 25);
			}
		}
	}

	/**
	 * Gibt den Labryinth-Elementen Farbe und Form.
	 */
	public void displayMaze() {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (maze[i][j] == 1) {
					grid[i][j].display();
				}

			}

		}
		noLoop();
	}

//	public void initializeStartScreen() {
//		
//		
//	}

	
	/**
	 * Stellt sicher, dass Figuren sich nur innerhalb des Labyrinths bewegen können
	 * und Gegenstände nur innerhalb des Labyrinths platziert werden können.
	 */
	public void avoidMazeCollition() {
	}

	public void keyPressed() {
		if(key == CODED)
			switch (keyCode) {
			case UP:
				player.moveUp();
				break;
			case DOWN:
				player.moveDown();
				break;
			case RIGHT:
				player.moveRight();
				break;
			case LEFT:
				player.moveLeft();
				break;

			}
	}

}
