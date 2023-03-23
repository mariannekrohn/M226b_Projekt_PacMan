package controller;

import java.util.ArrayList;

import model.Element;
import model.Character;
import model.Ghost;
import model.Item;
import model.PacMan;
import model.Point;
import processing.core.PApplet;
import view.MazeElement;

/**
 * Verwaltet die Spielkontrolle
 * 
 * @author Marianne Krohn
 */
public class GameController extends PApplet {

	private MazeElement[][] grid;
	private int x;
	private int y;
	private int gridSize;

	int step;
	int characterSize;
	int distance;

	PacMan player;
	Ghost ghost;
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
			{ 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
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
		size(y * gridSize, (x + 2) * gridSize);

		step = 24;
		distance = gridSize / 2 + 1;

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
		player = new PacMan(this, 12, 468);
		ghost = new Ghost(this, 12, 12, "Pinky", 0xFFE44B8D);
		points = new ArrayList<>();
		window = new PApplet();

		initializePointItems();
	}

	/**
	 * Zeichnet das Spielfeld mit Labyrinth und allen Figuren und Gegenständen
	 */
	public void drawGame() {

		collectItems();

		for (Point p : points) {
			p.draw();
		}
		player.draw();
		ghost.draw();

//		moveGhosts();

		textSize(20);
		fill(150);
		text("Score: " + player.getScore(), 20, 504);
	}

	/**
	 * Teilt das Spielfeld in ein Raster von 21x28 Feldern auf.
	 */
	private void initializeGrid() {
		for (int i = 0; i < y; i++) {
			for (int j = 1; j < x; j++) {
				grid[i][j] = new MazeElement(this, i * gridSize, j * gridSize);
			}
		}
	}

	/**
	 * Gibt den Labryinth-Elementen Farbe und Form.
	 */
	private void displayMaze() {

		for (int i = 0; i < y; i++) {
			for (int j = 1; j < x; j++) {
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
	 * Entfernt Gegenstände die Pac-Man einsammelt und addiert ihren Wert zum
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
	 * Berechnet den Abstand zwischen zwei Objekten
	 * 
	 * @return distance Distanz als double
	 */
	private double calculateDistance(Element e1, Element e2) {
		double distance = 0;
		float a = abs(e1.getXPos() - e2.getXPos());
		float b = abs(e1.getYPos() - e2.getYPos());

		distance = Math.sqrt(a * a + b * b);
		return distance;
	}
	
	private int convertPosToIndex(int pos) {
		return (pos - 12) / gridSize;
	}


	/**
	 * Erlaubt Bewegung nach oben, wenn das oben angrenzende Feld nicht ausgefüllt
	 * ist.
	 * 
	 * @return boolean
	 */
	private boolean allowMovementUp(Character c) {
		return maze[convertPosToIndex(c.getXPos())][convertPosToIndex(c.getYPos() - gridSize)] == 0;
	}

	/**
	 * Erlaubt Bewegung nach unten, wenn das unten angrenzende Feld nicht ausgefüllt
	 * ist.
	 * 
	 * @return boolean
	 */
	private boolean allowMovementDown(Character c) {
		return maze[convertPosToIndex(c.getXPos())][convertPosToIndex(c.getYPos() + gridSize)] == 0;
	}

	/**
	 * Erlaubt Bewegung nach links, wenn das unten angrenzende Feld nicht ausgefüllt
	 * ist.
	 * 
	 * @return boolean
	 */
	private boolean allowMovementLeft(Character c) {
		return maze[convertPosToIndex(c.getXPos() - gridSize)][convertPosToIndex(c.getYPos())] == 0;

	}

	/**
	 * Erlaubt Bewegung nach rechts, wenn das unten angrenzende Feld nicht ausgefüllt
	 * ist.
	 * 
	 * @return boolean
	 */
	private boolean allowMovementRight(Character c) {
		return maze[convertPosToIndex(c.getXPos() + gridSize)][convertPosToIndex(c.getYPos())] == 0;

	}

	/**
	 * Ermöglicht die Steuerung der Pac-Man-Figur mit den Pfeiltasten und stellt
	 * sicher dass die Figur sich nur innerhalb des Labyrinths und innerhalb des
	 * Spielfelds bewegen kann.
	 */
	public void keyPressed() {
			switch (keyCode) {
			case UP:
				if (player.getYPos() > 12 && allowMovementUp(player) == true) {
					player.moveUp();
					break;
				} else {
					player.setYPos(player.getYPos() - step);
				}
			case DOWN:
				if (player.getYPos() < player.getWindowHeight() - 60 && allowMovementDown(player) == true) {
					player.moveDown();
					break;
//				} else {
////					player.setYPos(player.getYPos() + step);
//					System.out.println(player.getXPos() + ", " + player.getYPos());
				}
			case RIGHT:
				 if (player.getXPos() < player.getWindowWidth() -12 && allowMovementRight(player) == true) {
				player.moveRight();
				break;

				} else {
					player.setXPos(player.getXPos() + step);
				}
			case LEFT:
				 if (player.getXPos() > 0 + 12 && allowMovementLeft(player) == true) {
				player.moveLeft();
				break;
				}

			}
	}

}
