package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.PacMan;

import org.mockito.Mockito;

import controller.MyApplet;


public class TestPacMan {
	
	PacMan p;
	
	private int xPos;
	private int yPos;
	
	private int height;
	private int width;
	
	private int score;
	private int lives;

	@Before
	public void setup() {
		MyApplet window = Mockito.mock(MyApplet.class);
		
		xPos = 36;
		yPos = 40;
		height = 16;
		width = 16;
		score = 56;
		lives = 3;

		p = new PacMan(window, xPos, yPos, height, width, score, lives);
		
	}
	
	@Test
	public void testConstructor() {
		assertEquals(xPos, p.getXPos());
		assertEquals(yPos, p.getYPos());
		
		assertEquals(height, p.getHeight());
		assertEquals(width, p.getWidth());
		
		assertEquals(score, p.getScore());
		assertEquals(lives, p.getLives());
	}
	
	@Test
	public void testGetXPos() {
		assertEquals("should return original xPos(36)", xPos, p.getXPos());
	}
	
	@Test
	public void testSetXPos() {
		p.setXPos(50);
		
		assertEquals("should get newly set xPos (50)", 50, p.getXPos());
	}
	
	@Test
	public void testGetYPos() {
		assertEquals("should return original yPos(40)", yPos, p.getYPos());
	}
	
	@Test
	public void testSetYPos() {
		p.setXPos(55);
		
		assertEquals("should get newly set yPos (55)", 55, p.getXPos());
	}
	
	@Test
	public void testGetHeight() {
		assertEquals("should return original height(16)", height, p.getHeight());
	}
	
	@Test
	public void testGetWidth() {
		assertEquals("should return original width(16)", width, p.getWidth());
	}
	
	@Test
	public void testGetScore() {
		assertEquals("should get original score (56)", score, p.getScore());
	}
	
	@Test
	public void testSetScore() {
		p.setScore(70);
		
		assertEquals("should get newly set score (70)", 70,  p.getScore());
	}
	
	@Test
	public void testGetLives() {
		assertEquals("should get original number of lives(3)", lives, p.getLives());
	}

	@Test
	public void testSetLives() {
		p.setLives(1);
		
		assertEquals("should get newly set number of lives (1)", 1, p.getLives());
	}

}
