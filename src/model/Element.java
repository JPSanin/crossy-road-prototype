package model;

import processing.core.PApplet;

public abstract class Element {

	private int posX;
	private int posY;
	private int dir;
	private int vel;
	
	private PApplet app;

	public Element(int posX, int posY, int dir, int vel, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.dir = dir;
		this.vel = vel;
		this.app = app;
	}
	
	public abstract void draw();
	
	public abstract void move();

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getDir() {
		return dir;
	}

	public int getVel() {
		return vel;
	}

	public PApplet getApp() {
		return app;
	}
	
		
}
