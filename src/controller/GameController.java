package controller;

import java.util.ArrayList;

import model.Element;
import model.Item;
import model.PacMan;
import model.Point;
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
	private int x;
	private int y;
	private int gridSize;

	PacMan player;
	PApplet window;

	ArrayList<Point> points;

	private int[][] maze = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0 },
			{ 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 },
			{ 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public static void main(String[] args) {
		PApplet.main("controller.GameController");
	}

	// Processing-Methoden
	public void setup() {
		player = new PacMan(this);
		points = new ArrayList<>();

	}

	public void settings() {
		y = maze.length;
		x = maze[0].length;
		gridSize = 24;
		grid = new MazeElement[y][x];

		size(y * gridSize, x * gridSize);
		initializeGrid();

	}

	public void draw() {
		background(0);
		initializeGame();
	}

	/**
	 * Zeichnet Spielfeld mit Labyrinth und allen Figuren und Gegenständen
	 */
	public void initializeGame() {
		displayMaze();
		player.drawCharacter();

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (maze[i][j] == 0) {
					Point p = new Point(this, 12 + i * gridSize, 12 + j * gridSize);
					points.add(p);
				}
			}
		}

		for (Point p : points) {
			p.drawItem();
		}
	}

	/**
	 * Teilt das Spielfeld in ein Raster von 20x28 Feldern auf.
	 */
	public void initializeGrid() {
		for (int i = 0; i < y; i++) {
			// alle 28 Spalten in der x-Richtung
			for (int j = 0; j < x; j++) {
				grid[i][j] = new MazeElement(this, i * gridSize, j * gridSize);
			}
		}

	}

	/**
	 * Gibt den Labryinth-Elementen Farbe und Form.
	 */
	private void displayMaze() {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (maze[i][j] == 1) {
					grid[i][j].display();
				}
			}
		}
	}

	/**
	 * Berechnet den Abstand zwischen einzelnen Elementen
	 * 
	 * @return distance Distanz als double
	 */
	private double calculateDistance(PacMan player, Item i) {
		double distance = 0;
		float a = abs(player.getXPos() - i.getXPos());
		float b = abs(player.getYPos() - i.getYPos());

		distance = Math.sqrt(a * a + b * b);
		return distance;
	}

	/**
	 * Entfernt Gegenstände die Pac Man einsammelt und addiert ihren Wert zum
	 * Punktestand des Spielers
	 */
//	public void collectItems() {
//		for(Point p : points) {
//			calculateDistance(player, p) {
//				if (distance <= 10) {
//					p.remove();
//				}
//			}
//			
//		}
//		
//	}

	/**
	 * Stellt sicher, dass Figuren sich nur innerhalb des Labyrinths bewegen können
	 * und Gegenstände nur innerhalb des Labyrinths platziert werden können.
	 */
	public void avoidMazeCollition() {
	}

	/**
	 * Ermöglicht die Steuerung der Pac-Man-Figur mit den Pfeiltasten
	 */
	public void keyPressed() {
		if (key == CODED)
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
