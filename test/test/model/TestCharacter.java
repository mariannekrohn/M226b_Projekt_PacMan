package test.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import controller.MyApplet;
import model.PacMan;

public class TestCharacter {
	
	PacMan p;
	MyApplet window;
	
	private int xPos;
	private int yPos;
	
	private int score;
	private int lives;
	private int step;
	
	@Before
	public void setup() {
		MyApplet window = Mockito.mock(MyApplet.class);
			when(window.getWindowHeight()).thenReturn(72);
			when(window.getWindowWidth()).thenReturn(72);
			
			xPos = 36;
			yPos = 36;
			score = 1;
			lives = 1;
			
			step = 24;
			
			p = new PacMan(window, xPos, yPos, 16, 16, score, lives);
	}

	@Test
	public void testMoveUp() {
		p.moveUp();
		
		assertEquals("should move up", yPos - step, p.getYPos());
	}
	
	@Test
	public void testMoveUpLimit() {
		p.moveUp();
		p.moveUp();
		
		assertEquals("should move up once and then stay at position", 12, p.getYPos());
	}
	
	@Test
	public void testMoveDown() {
		p.moveDown();
		
		assertEquals("should move down", yPos + step, p.getYPos());
	}
	
	@Test
	public void testMoveDownLimit() {
		p.moveDown();
		p.moveDown();

		assertEquals("should move down once and then stay at position", yPos + step, p.getYPos());
	}
	
	@Test
	public void testMoveRight() {		
		p.moveRight();
		
		assertEquals("should move right", xPos + step, p.getXPos());
	}
	
	@Test
	public void testMoveRightLimit() {		
		p.moveRight();
		p.moveRight();
		
		assertEquals("should move right once and then stay at position", xPos + step, p.getXPos());
	}
	
	@Test
	public void testMoveLeft() {		
		p.moveLeft();
		
		assertEquals("should move left", xPos - step, p.getXPos());
	}
	
	@Test
	public void testMoveLeftLimit() {		
		p.moveLeft();
		p.moveLeft();
		
		assertEquals("should move left once and then stay at position", xPos - step, p.getXPos());
	}

}
