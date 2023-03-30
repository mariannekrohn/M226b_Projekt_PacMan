package model;

import java.util.List;

import controller.MyApplet;

/**
 * Verwaltet die Eigenschaften und Fähigkeiten der Gegenstände.
 * @author Marianne Krohn
 *
 */
public abstract class Item extends Element implements Draw {
	
	private int height;
	private int value;
	private int color;
	
	/**
	 * Konstruktor
	 * @param type Art des Gegenstandes
	 * @param value Punkte-Wert des Gegenstandes
	 * @param color Farbe des Gegenstandes
	 */
	public Item(MyApplet window, int xPos, int yPos, int height, int width, int value, int color) {
		super(window, xPos, yPos);
		this.height = height;
		this.value = value;
		this.color = color;
	}

	/**
	 * Zeichnet den Gegenstand
	 */
	@Override
	public void draw() {
		window.fill(color);
		window.ellipse(xPos, yPos, height, height);
	}

	/**
	 * Berechnet die Distanz zwischen Item und PacMan, entfernt das Objekt aus der
	 * entsprechenden ArrayList und addiert ihre Wert zum Punktestand des Spielers
	 *
	 * @param list List von Items über die iteriert wird
	 * @param player PacMan-Figur
	 */
	public static void removeItem(List<Item> list, PacMan player) {
		for (int i = 0; i < list.size(); i++) {
			Item item = list.get(i);
			double distance = Element.calculateDistance(player, item);
			if (distance < 10) {
				list.remove(i);
				player.setScore(player.getScore() + item.getValue());
				return;
			}
		
		}

	}
	
	public int getValue() {
		return value;
	}
}
