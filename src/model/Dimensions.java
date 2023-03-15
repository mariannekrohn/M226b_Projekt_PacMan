package model;

import processing.core.PApplet;

public abstract class Dimensions extends PApplet{
	
	protected int xPos;
	protected int yPos;
	protected int length;
	protected int height;
	protected PApplet window;
	
	
	public Dimensions(PApplet window, int xPos, int yPos, int length, int height) {
		this.window = window;
		this.xPos = xPos;
		this.yPos = yPos;
		this.length = 25;
		this.height = 25;
	}
}
