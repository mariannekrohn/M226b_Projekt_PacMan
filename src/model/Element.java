package model;

import processing.core.PApplet;

public abstract class Element extends PApplet{
	
	private int xPos;
	private int yPos;
	private int length;
	private int height;
	private PApplet window;
	
	
	public Element(PApplet window, int xPos, int yPos, int length, int height) {
		this.window = window;
		this.xPos = xPos;
		this.yPos = yPos;
		this.length = length;
		this.height = height;
	}


	public int getxPos() {
		return xPos;
	}


	public void setxPos(int xPos) {
		this.xPos = xPos;
	}


	public int getyPos() {
		return yPos;
	}


	public void setyPos(int yPos) {
		this.yPos = yPos;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public PApplet getWindow() {
		return window;
	}


	public void setWindow(PApplet window) {
		this.window = window;
	}
}
