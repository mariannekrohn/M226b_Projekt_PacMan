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
	
	private int xPos;
	private int yPos;
	
	private int score;
	private int lives;
	private int step;

	@Before
	public void setup() {
		Element doc = Mockito.mock(Element.class);
			when(doc.getWindowHeight()).thenReturn(72);
			when(doc.getWindowWidth()).thenReturn(72);
		
		xPos = 36;
		yPos = 36;
		score = 1;
		lives = 1;
		
		step = 24;
		
		sut = new PacMan(doc, xPos, yPos, score, lives);
		
	}
	
	@Test
	public void testConstructor() {
		assertEquals(yPos, sut.getYPos());
		assertEquals(yPos, sut.getYPos());
		assertEquals(score, sut.getScore());
		assertEquals(lives, sut.getLives());
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
