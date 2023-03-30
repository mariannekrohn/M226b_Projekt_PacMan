package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Element;
import model.PacMan;
import processing.core.PApplet;

import org.mockito.Mockito;

import controller.MyApplet;

import static org.mockito.Mockito.*;

public class TestPacMan {
	
	PacMan sut;
	
	private int xPos;
	private int yPos;
	
	private int score;
	private int lives;

	@Before
	public void setup() {
		
		MyApplet window = Mockito.mock(MyApplet.class);
		
		xPos = 36;
		yPos = 36;
		score = 1;
		lives = 1;

		
		sut = new PacMan(window, xPos, yPos, score, lives);
		
	}
	
	@Test
	public void testConstructor() {
		assertEquals(yPos, sut.getYPos());
		assertEquals(yPos, sut.getYPos());
		assertEquals(score, sut.getScore());
		assertEquals(lives, sut.getLives());
	}
	
	// Getter und Setter auch testen



}
