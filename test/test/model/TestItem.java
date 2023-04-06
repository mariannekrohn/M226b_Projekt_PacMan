package test.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import controller.MyApplet;
import model.Item;
import model.PacMan;
import model.Point;

public class TestItem {
	
	PacMan player;
	List<Item> points;
	Point p;
	Point q;
	int score;
	
	@Before
	public void setup() {
		int xPos = 12;
		int yPos = 36;
		int score = 5;
		int value = 13;
		
		MyApplet window = Mockito.mock(MyApplet.class);
		
		player = Mockito.mock(PacMan.class);
			when(player.getXPos()).thenReturn(xPos);
			when(player.getYPos()).thenReturn(yPos);
			
			player = new PacMan(window, xPos, yPos, 16, 16, score, 0);
		
		p = Mockito.mock(Point.class);
			when(p.getXPos()).thenReturn(xPos);
			when(p.getYPos()).thenReturn(yPos);
			when(p.getValue()).thenReturn(value);
			
		q = Mockito.mock(Point.class);
			when(q.getXPos()).thenReturn(xPos);
			when(q.getYPos()).thenReturn(yPos);
			when(q.getValue()).thenReturn(value);
			
		points = new ArrayList<>();
		points.add(p);
		points.add(q);
	}

	@Test
	public void testRemoveItem() {
		assertEquals("should return initial list size", 2, points.size());
		assertEquals("should return initital player score", 5, player.getScore());
		
		Item.removeItem(points, player);
		assertEquals("should remove one item from list", 1, points.size());
		assertEquals("should add value of removed point to player score", 18, player.getScore());
		
		
		Item.removeItem(points, player);
		assertEquals("should remove second item from list", 0, points.size());	
		assertEquals("shoudd add value of removed point to player score", 31, player.getScore());
	}
	
}
