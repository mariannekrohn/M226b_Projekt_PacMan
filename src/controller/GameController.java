package controller;

import java.util.ArrayList;

import model.Element;
import model.Fruit;
import model.Character;
import model.Ghost;
import model.PacMan;
import model.Point;
import model.PowerPill;
import processing.core.PApplet;
import view.MazeElement;

/**
 * Verwaltet die Spielkontrolle
 * 
 * @author Marianne Krohn
 */
public class GameController extends PApplet {

	PApplet window;
	private MazeElement[][] grid;
	private int x;
	private int y;
	private int gridSize;

	int step;
	int characterSize;
	int counter;

	PacMan player;
	ArrayList<Ghost> ghosts;

	ArrayList<Point> points;
	ArrayList<PowerPill> powerPills;
	ArrayList<Fruit> fruit;

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

	enum State {
		START, PLAY, RESET, END_WIN, END_LOOSE
	};

	State gameState = State.START;

	public static void main(String[] args) {
		PApplet.main("controller.GameController");
	}

	public void setup() {
	}

	public void settings() {
		y = maze.length;
		x = maze[0].length;
		gridSize = 24;
		grid = new MazeElement[y][x];
		size(y * gridSize, (x + 2) * gridSize);

		step = 24;
		counter = 0;

		initializeGrid();
		initializeGame();

	}

	public void draw() {
		background(0);

		switch (gameState) {
		case START:
			displayMaze();
			drawStartScreen();
			break;
		case PLAY:
			displayMaze();
			drawGame();
			break;
		case RESET:
			displayMaze();
			drawReset();
			break;
		case END_WIN:
			drawSuccess();
			break;
		case END_LOOSE:
			drawFail();
		}

	}

	/**
	 * Initialisiert alle Figuren und Gegenstände
	 */
	public void initializeGame() {
		window = new PApplet();

		player = new PacMan(this, 12, 468, -5, 3);
		ghosts = new ArrayList<>();

		points = new ArrayList<>();
		powerPills = new ArrayList<>();
		fruit = new ArrayList<>();

		initializeGhosts();
		initializePointItems();
		initializePowerPills();
		initializeFruit();
	}

	/**
	 * Zeichnet das Spielfeld mit Labyrinth und allen Figuren und Gegenständen
	 */
	public void drawGame() {
		collectItem();
		removeLife();

		for (Point p : points) {
			p.draw();
		}

		for (PowerPill p : powerPills) {
			p.draw();
		}

		for (Fruit f : fruit) {
			f.draw();
			int random = (int) (25 + Math.random() * 500);
			if (counter == random) {
				fruit = new ArrayList<>();
			}
		}

		player.draw();

		for (Ghost g : ghosts) {
			g.draw();
			moveGhost(g);
		}

		textAlign(LEFT);
		textSize(20);
		fill(150);
		text("Score: " + player.getScore(), 20, 504);

		textSize(20);
		fill(150);
		text("Lives: " + player.getLives(), 150, 504);
	}

	/**
	 * Zeichnet den Startbildschirm des Spiels
	 */
	public void drawStartScreen() {
		fill(0, 0, 0, 150);
		rect(0, 0, y * gridSize, (x + 2) * gridSize);

		textAlign(CENTER);
		textSize(20);
		fill(190);
		text("Navigate With Your Arrow Keys", ((y * gridSize) / 2), 175);

		textSize(50);
		fill(0xFFD99722);
		text("Press Space", ((y * gridSize) / 2), 275);
		text("to Start", ((y * gridSize) / 2), 325);
	}

	/**
	 * Setzt alle Spielfiguren auf ihren Ausgangspunkt zurück, nachdem Pac-Man auf
	 * einen Geist gestossen ist und reduziert das Leben des Spielers um 1
	 */
	public void drawReset() {
		player = new PacMan(this, 12, 468, player.getScore(), player.getLives() - 1);

		player.draw();

		ghosts = new ArrayList<>();
		initializeGhosts();

		for (Ghost g : ghosts) {
			g.draw();
			moveGhost(g);
		}

		for (Point p : points) {
			p.draw();
		}

		for (PowerPill p : powerPills) {
			p.draw();
		}
		
		delay(500);
		gameState = State.PLAY;

	}

	public void drawSuccess() {
		textAlign(CENTER);
		textSize(50);
		fill(0xFFD99722);
		text("YOU WIN!", ((y * gridSize) / 2), 275);

	}

	public void drawFail() {
		textAlign(CENTER);
		textSize(50);
		fill(0, 51, 102);
		text("YOU LOOSE!", ((y * gridSize) / 2), 275);

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
	 * Initialisiert die Geister
	 */
	private void initializeGhosts() {
		ghosts.add(new Ghost(this, 156, 132, "Blinky", 0xFFFF0000));
		ghosts.add(new Ghost(this, 516, 132, "Pinky", 0xFFE44B8D));
		ghosts.add(new Ghost(this, 372, 252, "Inky", 0xFF00FFFF));
		ghosts.add(new Ghost(this, 300, 252, "Clyde", 0xFFFFA500));
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
	 * Positioniert die PowerPills
	 */
	private void initializePowerPills() {
		int[][] pos = { { 2, 2 }, { 25, 2 }, { 10, 6 }, { 17, 6 } };

		for (int[] p : pos) {
			PowerPill pP = new PowerPill(this, 12 + p[0] * gridSize, 12 + p[1] * gridSize);
			powerPills.add(pP);
		}
	}

	/**
	 * Positioniert die Früchte
	 */
	private void initializeFruit() {
		int random = (int) (0 + (Math.random() * 3));
		System.out.println(random);

		int[][] pos = { { 3, 10 }, { 14, 18 }, { 20, 13 }, { 25, 0 } };

		Fruit fr = new Fruit(this, 12 + pos[random][0] * gridSize, 12 + pos[random][1] * gridSize);
		fruit.add(fr);
	}

	/**
	 * Entfernt Gegenstände die Pac-Man einsammelt und addiert ihren Wert zum
	 * Punktestand des Spielers
	 */
	private void collectItem() {

		if (points.size() == 0) {
			gameState = State.END_WIN;
			return;
		}

		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			double distance = calculateDistance(player, p);
			if (distance < 10) {
				points.remove(i);
				player.setScore(player.getScore() + p.getValue());
			}
		}

		for (int i = 0; i < powerPills.size(); i++) {
			PowerPill p = powerPills.get(i);
			double distance = calculateDistance(player, p);
			if (distance < 10) {
				powerPills.remove(i);
				player.setScore(player.getScore() + p.getValue());
			}
		}

		for (int i = 0; i < fruit.size(); i++) {
			Fruit f = fruit.get(i);
			double distance = calculateDistance(player, f);
			if (distance < 10) {
				fruit.remove(i);
				player.setScore(player.getScore() + f.getValue());
			}
		}
	}

	/**
	 * Zieht bei Kollision mit Geistern ein Leben ab
	 */
	private void removeLife() {
		if (player.getLives() == 0) {
			gameState = State.END_LOOSE;
		}

		for (Ghost g : ghosts) {
			double distance = calculateDistance(player, g);

			if (distance == 0) {
				gameState = State.RESET;
				break;
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

	/**
	 * Bewegt die Geister in zufälliger Geschwindigkeit so auf dem Spielfeld, dass
	 * sie Pac-Man verfolgen
	 */
	private void moveGhost(Ghost g) {
		int random = (int) (10 + (Math.random() * 50));

		if (counter % random == 0) {

			if (allowMovementUp(g) == true && player.getYPos() < g.getYPos()) {
				g.setYPos(g.getYPos() - step);
			} else if (allowMovementDown(g) == true && player.getYPos() > g.getYPos()) {
				g.setYPos(g.getYPos() + step);
			} else if (allowMovementLeft(g) == true && player.getXPos() < g.getXPos()) {
				g.setXPos(g.getXPos() - step);
			} else if (allowMovementRight(g) == true && player.getXPos() > g.getXPos()) {
				g.setXPos(g.getXPos() + step);
			}
		}
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
		return c.getYPos() - gridSize >= 12
				&& maze[convertPosToIndex(c.getXPos())][convertPosToIndex(c.getYPos() - gridSize)] == 0;
	}

	/**
	 * Erlaubt Bewegung nach unten, wenn das unten angrenzende Feld nicht ausgefüllt
	 * ist.
	 * 
	 * @return boolean
	 */
	private boolean allowMovementDown(Character c) {
		return c.getYPos() + gridSize <= 468
				&& maze[convertPosToIndex(c.getXPos())][convertPosToIndex(c.getYPos() + gridSize)] == 0;
	}

	/**
	 * Erlaubt Bewegung nach links, wenn das unten angrenzende Feld nicht ausgefüllt
	 * ist.
	 * 
	 * @return boolean
	 */
	private boolean allowMovementLeft(Character c) {
		return c.getXPos() - gridSize >= 12
				&& maze[convertPosToIndex(c.getXPos() - gridSize)][convertPosToIndex(c.getYPos())] == 0;

	}

	/**
	 * Erlaubt Bewegung nach rechts, wenn das unten angrenzende Feld nicht
	 * ausgefüllt ist.
	 * 
	 * @return boolean
	 */
	private boolean allowMovementRight(Character c) {
		return c.getXPos() + gridSize <= 660
				&& maze[convertPosToIndex(c.getXPos() + gridSize)][convertPosToIndex(c.getYPos())] == 0;

	}

	/**
	 * Ermöglicht die Steuerung der Pac-Man-Figur mit den Pfeiltasten und stellt
	 * sicher dass die Figur sich nur innerhalb des Labyrinths und innerhalb des
	 * Spielfelds bewegen kann.
	 */
	public void keyPressed() {
		counter++;

		if (gameState == State.PLAY) {
			switch (keyCode) {
			case UP:
				if (allowMovementUp(player) == true) {
					player.moveUp();
				}
				break;
			case DOWN:
				if (allowMovementDown(player) == true) {
					player.moveDown();
				}
				break;
			case RIGHT:
				if (allowMovementRight(player) == true) {
					player.moveRight();
				}
				break;
			case LEFT:
				if (allowMovementLeft(player) == true) {
					player.moveLeft();
				}
				break;
			}
		} else if (key == ' ') {
			if (gameState == State.START) {
				gameState = State.PLAY;
			} else if (gameState == State.END_WIN || gameState == State.END_LOOSE) {
				gameState = State.START;
			}
		}

	}

}