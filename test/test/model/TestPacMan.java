package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Element;
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
		Element doc = Mockito.mock(Element.class);
			when(doc.getWindowHeight()).thenReturn(72);
			when(doc.getWindowWidth()).thenReturn(72);
		
		xPos = 36;
		yPos = 36;
		step = 24;
		
		sut = new PacMan(doc, xPos, yPos, 1, 1);
		
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
	public void testMoveUpLimit() {
		testMoveUp();
		sut.moveUp();
		
		assertEquals("should reset to 12", 12, sut.getYPos());
	}
	
	@Test
	public void testMoveDown() {
		
		sut.moveDown();
		System.out.println(sut.getYPos());
		assertEquals(yPos + step, sut.getYPos());
	}
	
	public void testMoveDownLimit() {
		sut.moveDown();
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
