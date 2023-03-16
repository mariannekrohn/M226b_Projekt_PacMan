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
	
	@Before
	public void setup() {
		PApplet applet = Mockito.mock(PApplet.class);
		//when(applet.height)..applet.
		
		p = new PacMan(applet);
	}

	@Test
	public void testMoveUp() {
		assertEquals(300, p.getYPos());
		
		p.moveUp();
		
		assertEquals(290, p.getYPos());
	}
	
	@Test
	public void testMoveDown() {
		assertEquals(300, p.getYPos());
		
		p.moveDown();
		
		assertEquals(310, p.getYPos());
	}
	
	@Test
	public void testMoveRight() {
		assertEquals(200, p.getXPos());
		
		p.moveRight();
		
		assertEquals(210, p.getXPos());
	}
	
	@Test
	public void testMoveLeft() {
		assertEquals(200, p.getXPos());
		
		p.moveRight();
		
		assertEquals(210, p.getXPos());
	}

}
