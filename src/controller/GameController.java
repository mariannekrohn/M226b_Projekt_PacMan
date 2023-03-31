package controller;

import java.util.ArrayList;
import java.util.List;

import model.Element;
import model.Fruit;
import model.Character;
import model.Ghost;
import model.Item;
import model.PacMan;
import model.Point;
import model.PowerPill;
import processing.core.PApplet;
import view.GameInfo;
import view.Maze;

/**
 * Verwaltet die Eigenschaften und Fähigkeitne der Spielkontrolle
 * 
 * @author Marianne Krohn
 */
public class GameController extends MyApplet {

	private int[][] mazePattern;
	private Maze m;
	
	private int x;
	private int y;
	private int gridSize;

	private int step;
	private int counter;
	private GameInfo info;

	private PacMan player;
	private ArrayList<Ghost> ghosts;

	private List<Item> points;
	private List<Item> powerPills;
	private List<Item> fruit;

	
	
	enum State {
		START, PLAY, RESET, END_WIN, END_LOOSE
	};

	State gameState = State.START;

	
	
	public static void main(String[] args) {
		PApplet.main("controller.GameController");
	}



	public void settings() {
		m = new Maze(this, 0, 0);
		mazePattern = m.getMaze();
		
		y = mazePattern.length;
		x = mazePattern[0].length;
		
		gridSize = 24;
		size(y * gridSize, (x + 2) * gridSize);

		step = 24;
		counter = 0;

		m.initializeGrid();
		initializeGame();
	}

	public void draw() {
		background(0);

		switch (gameState) {
		case START:
			m.displayMaze();
			info.drawStartScreen();
			break;
		case PLAY:
			m.displayMaze();
			drawGame();
			break;
		case RESET:
			m.displayMaze();
			drawReset();
			break;
		case END_WIN:
			info.drawSuccess();
			break;
		case END_LOOSE:
			info.drawFail();
		}

	}

	/**
	 * Initialisiert alle Figuren und Gegenstände
	 */
	public void initializeGame() {
		info = new GameInfo(this, y * gridSize, (x + 2) * gridSize);

		player = new PacMan(this, 12, 468, 16, 16, -5, 3);
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
		collectItems();
		removeLife();

		Item.drawItems(points);
		Item.drawItems(powerPills);
		Item.drawItems(fruit);
		int random = (int) (25 + Math.random() * 500);
		if (counter == random) {
			fruit = new ArrayList<>();
		}

		player.draw();	
		
		drawGhosts();
		moveGhosts();

		player.displayStatus();

	}

	/**
	 * Setzt alle Spielfiguren auf ihren Ausgangspunkt zurück, nachdem Pac-Man auf
	 * einen Geist gestossen ist und reduziert das Leben des Spielers um 1
	 */
	public void drawReset() {
		player = new PacMan(this, 12, 468, 16, 16, player.getScore(), player.getLives() - 1);
		player.draw();

		ghosts = new ArrayList<>();
		initializeGhosts();
		drawGhosts();
		
		delay(500);
		gameState = State.PLAY;
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
	 * Positioniert Punkt-Objekte in jedem leeren Feld und initalisiert die points ArrayList
	 */
	private void initializePointItems() {

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (mazePattern[i][j] == 0) {
					Point p = new Point(this, 12 + i * gridSize, 12 + j * gridSize);
					points.add(p);
				}
			}
		}
	}

	/**
	 * Positioniert die PowerPills und initialisiert die powerPills ArrayList
	 */
	private void initializePowerPills() {
		int[][] pos = { { 2, 2 }, { 25, 2 }, { 10, 6 }, { 17, 6 } };

		for (int[] p : pos) {
			PowerPill pP = new PowerPill(this, 12 + p[0] * gridSize, 12 + p[1] * gridSize);
			powerPills.add(pP);
		}
	}

	/**
	 * Positioniert die Früchte und initialisiert die fruits ArrayList
	 */
	private void initializeFruit() {
		int random = (int) (0 + (Math.random() * 3));

		int[][] pos = { { 3, 10 }, { 14, 18 }, { 20, 13 }, { 25, 0 } };

		Fruit fr = new Fruit(this, 12 + pos[random][0] * gridSize, 12 + pos[random][1] * gridSize);
		fruit.add(fr);
	}
	
	
	/**
	 * Iteriert über die ghost ArrayList und zeichnet die enthaltenen
	 * Charaktere
	 */
	public void drawGhosts() {
		for (Ghost e: ghosts) {
			e.draw();
		}
	}

	/**
	 * Entfernt Gegenstände die Pac-Man einsammelt und addiert ihren Wert zum
	 * Punktestand des Spielers
	 */
	private void collectItems() {
		if (points.size() == 0) {
			gameState = State.END_WIN;
			return;
		}
		
		Item.removeItem(points, player);
		Item.removeItem(powerPills, player);
		Item.removeItem(fruit, player);
	}

	/**
	 * Zieht bei Kollision von PacMan mit Geistern ein Leben ab
	 */
	private void removeLife() {
		if (player.getLives() == 0) {
			gameState = State.END_LOOSE;
		}

		for (Ghost g : ghosts) {
			double distance = Element.calculateDistance(player, g);

			if (distance == 0) {
				gameState = State.RESET;
				break;
			}
		}
	}


	/**
	 * Bewegt die Geister in zufälliger Geschwindigkeit so auf dem Spielfeld, dass
	 * sie Pac-Man verfolgen
	 */
	private void moveGhosts() {
		
		for(Ghost g: ghosts) {
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
				&& mazePattern[convertPosToIndex(c.getXPos())][convertPosToIndex(c.getYPos() - gridSize)] == 0;
	}

	/**
	 * Erlaubt Bewegung nach unten, wenn das unten angrenzende Feld nicht ausgefüllt
	 * ist.
	 * 
	 * @return boolean
	 */
	private boolean allowMovementDown(Character c) {
		return c.getYPos() + gridSize <= 468
				&& mazePattern[convertPosToIndex(c.getXPos())][convertPosToIndex(c.getYPos() + gridSize)] == 0;
	}

	/**
	 * Erlaubt Bewegung nach links, wenn das unten angrenzende Feld nicht ausgefüllt
	 * ist.
	 * 
	 * @return boolean
	 */
	private boolean allowMovementLeft(Character c) {
		return c.getXPos() - gridSize >= 12
				&& mazePattern[convertPosToIndex(c.getXPos() - gridSize)][convertPosToIndex(c.getYPos())] == 0;

	}

	/**
	 * Erlaubt Bewegung nach rechts, wenn das unten angrenzende Feld nicht
	 * ausgefüllt ist.
	 * 
	 * @return boolean
	 */
	private boolean allowMovementRight(Character c) {
		return c.getXPos() + gridSize <= 660
				&& mazePattern[convertPosToIndex(c.getXPos() + gridSize)][convertPosToIndex(c.getYPos())] == 0;

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
			if (gameState == State.START || gameState == State.END_WIN || gameState == State.END_LOOSE) {
				gameState = State.PLAY;
				initializeGame();
			}
		}

	}

}