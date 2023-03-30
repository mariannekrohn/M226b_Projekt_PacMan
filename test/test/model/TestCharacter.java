package test.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.awt.Window;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import controller.MyApplet;
import model.Element;
import model.PacMan;

public class TestCharacter {
	
	PacMan p;
	MyApplet a;
	
	private int xPos;
	private int yPos;
	
	private int score;
	private int lives;
	private int step;
	
	@Before
	public void setup() {
		MyApplet a = Mockito.mock(MyApplet.class);
			when(a.getWindowHeight()).thenReturn(72);
			when(a.getWindowWidth()).thenReturn(72);
			
			xPos = 36;
			yPos = 36;
			score = 1;
			lives = 1;
			
			step = 24;
			
			p = new PacMan(a, xPos, yPos, score, lives);
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
		
		
		assertEquals("should stay at current position", 12, p.getYPos());
	}
	
	@Test
	public void testMoveDown() {
		p.moveDown();
		
		assertEquals(yPos + step, p.getYPos());
	}
	
	@Test
	public void testMoveDownLimit() {
		p.moveDown();
		p.moveDown();
		

		assertEquals(yPos + step, p.getYPos());
	}
	
	@Test
	public void testMoveRight() {		
		p.moveRight();
		
		assertEquals(xPos + step, p.getXPos());
	}
	
	@Test
	public void testMoveRightLimit() {		
		p.moveRight();
		p.moveRight();
		
		assertEquals(xPos + step, p.getXPos());
	}
	
	@Test
	public void testMoveLeft() {		
		p.moveLeft();
		
		assertEquals(xPos - step, p.getXPos());
	}
	
	@Test
	public void testMoveLeftLimit() {		
		p.moveLeft();
		p.moveLeft();
		
		assertEquals(xPos - step, p.getXPos());
	}

}
