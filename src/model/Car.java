package model;

import processing.core.PApplet;

public class Car extends Element implements Runnable{

	
	public Car(int posX, int posY, int dir, int vel, PApplet app) {
		super(posX, posY, dir, vel, 50, 100, app);
		
	}

	@Override
	public void run() {
		
		
	}

	@Override
	public void draw() {
		getApp().fill(200,0,0);
		getApp().rect(getPosX(), getPosY(), getWidth(),getHeight());
		
	}


	public void move() {
		
		
	}

}
