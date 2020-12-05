package model;

import processing.core.PApplet;

public abstract class Element {

	private int posX;
	private int posY;
	private int dir;
	private int vel;
	private int height;
	private int width;
	
	private PApplet app;

	
	
	public Element(int posX, int posY, int dir, int vel, int height, int width, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.dir = dir;
		this.vel = vel;
		this.height = height;
		this.width = width;
		this.app = app;
	}

	public abstract void draw();
	

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	
	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getDir() {
		return dir;
	}

	public int getVel() {
		return vel;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public PApplet getApp() {
		return app;
	}
	
		
}
