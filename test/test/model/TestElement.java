package test.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.Element;
import model.PacMan;
import processing.core.PApplet;

public class TestElement {

	;
	Element elem2;

	private int xPos;
	private int yPos;
	
	private int score;
	private int lives;

	@Before
	public void setup() {
		
		xPos = 36;
		yPos = 36;
		score = 1;
		lives = 1;
		
		Element e = Mockito.mock(Element.class, Mockito.CALLS_REAL_METHODS);
		
		player = new PacMan(e, xPos, yPos, score, lives);
//		Element elem1 = Mockito.mock(Element.class, Mockito.CALLS_REAL_METHODS);
//		when(elem1.getXPos()).thenReturn(10);
//		when(elem1.getYPos()).thenReturn(10);
//
//		Element elem2 = Mockito.mock(Element.class, Mockito.CALLS_REAL_METHODS);
//		when(elem2.getXPos()).thenReturn(20);
//		when(elem2.getYPos()).thenReturn(20);

	}

//	@Test
//	public void testConstruktor() {
//		assertEquals(xPos, elem.getXPos());
//		assertEquals(xPos, elem.getYPos());
//
//	}

	@Test
	public void testCalculateDistance() {
		assertEquals(0, elem1.calculateDistance(elem1, elem2));
	}

}
