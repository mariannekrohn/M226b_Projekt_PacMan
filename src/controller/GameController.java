package controller;

import java.util.ArrayList;

import model.Item;
import model.PacMan;
import model.Point;
import processing.core.PApplet;
import view.MazeElement;

/**
 * Verwaltet die Spielkontrolle
 * @author Marianne Krohn
 *
 */
public class GameController extends PApplet {

	private MazeElement[][] grid;
	private int x;
	private int y;
	private int gridSize;

	float comparisonColor;

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

	}

	public void settings() {
		y = maze.length;
		x = maze[0].length;
		gridSize = 24;
		grid = new MazeElement[y][x];

		size(y * gridSize, x * gridSize);
		initializeGrid();
		initializeGame();

	}

	public void draw() {
		background(0);
		displayMaze();
		drawGame();
	}

	/**
	 * Initialisiert alle Figuren und Gegenstände
	 */
	public void initializeGame() {
		player = new PacMan(this);
		points = new ArrayList<>();

		initializePointItems();
	}

	/**
	 * Zeichnet Spielfeld mit Labyrinth und allen Figuren und Gegenständen
	 */
	public void drawGame() {

		collectItems();

		for (Point p : points) {
			p.drawItem();
		}

		player.chooseCharacterColor();
		comparisonColor = red(get(player.getXPos(), player.getYPos()));
		player.drawCharacterShape();
	}

	/**
	 * Teilt das Spielfeld in ein Raster von 20x28 Feldern auf.
	 */
	private void initializeGrid() {
		
		for (int i = 0; i < y; i++) {
			// alle 28 Spalten in der x-Richtung
			for (int j = 0; j < x; j++) {
				grid[i][j] = new MazeElement(this, i * gridSize, j * gridSize);
			}
		}
	}

	/**
	 * Gibt den Labryinth -Elementen Farbe und Form.
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
	 * Positioniert Punkt-Objekte in jedem leeren Feld und initalisiert das
	 * Punkte-Array
	 */
	private void initializePointItems() {
		
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (maze[i][j] == 0) {
					Point p = new Point(this, 12 + i * gridSize, 12 + j * gridSize);
					points.add(p);
				}
			}
		}

	}

	/**
	 * Entfernt Gegenstände die Pac Man einsammelt und addiert ihren Wert zum
	 * Punktestand des Spielers
	 */
	private void collectItems() {

		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			double distance = calculateDistance(player, p);
			if (distance < 10) {
				points.remove(i);
				player.setScore(player.getScore() + 5);
			}
		}
	}

	/**
	 * Berechnet den Abstand zwischen dem Player und den sammelbaren Objekten
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
	 * Ermöglicht die Steuerung der Pac-Man-Figur mit den Pfeiltasten und stellt
	 * sicher dass die Figur sich nur innerhalb des Labyrinths bewegen kann
	 */
	public void keyPressed() {

		// if(xPos - 1 == 255) only allow up, down, right
		// if(P + (PlayerSize + 1) == 255) only up, down, right
		// if(yPos - 1 == 255) only allow down, left, right
		// if(yPos + (Playersize +1) == 255 only allow up, left, right

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
