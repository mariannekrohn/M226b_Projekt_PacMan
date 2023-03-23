package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.PacMan;
import processing.core.PApplet;

import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class TestPacMan {
	
	PacMan sut;
	
	int xPos;
	int yPos;
	int step;

	@Before
	public void setup() {
		// Mocken der Klasse
		PApplet doc = Mockito.mock(PApplet.class);
		//zu Überprüfender Wert einer Methode
//			when(applet.height).thenReturn(10);
		
		xPos = 200;
		yPos = 400;
		step = 6;
		
		sut = new PacMan(doc, xPos, yPos);
		
	}
	
	@Test
	public void testConstructor() {
		assertEquals(yPos, sut.getYPos());
		assertEquals(yPos, sut.getYPos());
		assertEquals(xPos, sut.getXPos());
		assertEquals(xPos, sut.getXPos());
	}

	@Test
	public void testMoveUp() {
		sut.moveUp();
		
		assertEquals(yPos - step, sut.getYPos());
	}
	
	@Test
	public void testMoveDown() {
		sut.moveDown();
		
		assertEquals(yPos + step, sut.getYPos());
	}
	
	@Test
	public void testMoveRight() {		
		sut.moveRight();
		
		assertEquals(xPos + step, sut.getXPos());
	}
	
	@Test
	public void testMoveLeft() {		
		sut.moveLeft();
		
		assertEquals(xPos - step, sut.getXPos());
	}

}
