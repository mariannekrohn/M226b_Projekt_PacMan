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
		
		p = new PacMan(applet, 200, 300, 25, 25, "Pac Man", 0xFFFFFF00);
	}

	@Test
	public void test() {
		
		
		
		
		fail("Not yet implemented");
	}

}
