package test.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.Element;
import model.Ghost;
import model.PacMan;


public class TestElement {

	PacMan p;
	Ghost g;
	
	@Before
	public void setup() {
		
		p = Mockito.mock(PacMan.class);
			when(p.getXPos()).thenReturn(40);
			when(p.getYPos()).thenReturn(40);
		
	
		g = Mockito.mock(Ghost.class);
			when(p.getXPos()).thenReturn(20);
			when(p.getYPos()).thenReturn(20);
	}

	@Test
	public void testCalculateDistance() {
		assertEquals(28.28, Element.calculateDistance(p, g), 10);
	}

}
