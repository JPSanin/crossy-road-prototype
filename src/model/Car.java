package model;

import processing.core.PApplet;

public class Car extends Element implements Runnable{

	
	public Car(int posX, int posY, int dir, int vel, PApplet app) {
		super(posX, posY, dir, vel, 50, 75, app);
		
	}

	@Override
	public void run() {
		move();
	}

	@Override
	public void draw() {
		getApp().fill(200,0,0);
		getApp().stroke(0);
		getApp().rect(getPosX(), getPosY(), getWidth(),getHeight());
		
	}


	private void move() {
		if(getDir()==-1) {
			if(getPosX()<-getWidth()) {
				setPosX(800);
			}
		}
		
		if(getDir()==1) {
			if(getPosX()>800) {
				setPosX(-getWidth());
			}
		}
		setPosX(getPosX()+(getVel()*getDir()));
		
	}

}
