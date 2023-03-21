package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.PacMan;
import processing.core.PApplet;

import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class TestPacMan {
	
	PacMan p;
	
	int xPos;
	int yPos;
	int step;

	@Before
	public void setup() {
		PApplet applet = Mockito.mock(PApplet.class);
		//when(applet.height)..applet.
		
		p = new PacMan(applet);
		xPos = 324;
		yPos = 444;
		step = 6;
	}

	@Test
	public void testMoveUp() {
		assertEquals(yPos, p.getYPos());
		
		p.moveUp();
		
		assertEquals(yPos - step, p.getYPos());
	}
	
	@Test
	public void testMoveDown() {
		assertEquals(yPos, p.getYPos());
		
		p.moveDown();
		
		assertEquals(yPos + step, p.getYPos());
	}
	
	@Test
	public void testMoveRight() {
		assertEquals(xPos, p.getXPos());
		
		p.moveRight();
		
		assertEquals(xPos + step, p.getXPos());
	}
	
	@Test
	public void testMoveLeft() {
		assertEquals(xPos, p.getXPos());
		
		p.moveLeft();
		
		assertEquals(xPos - step, p.getXPos());
	}

}
