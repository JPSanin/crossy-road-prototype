package model;

import processing.core.PApplet;

public class MainCharacter extends Element{

	public MainCharacter(int posX, int posY, int dir, int vel, PApplet app) {
		super(posX, posY, dir, vel,50,50, app);
	}

	@Override
	public void draw() {
		getApp().fill(24,94,145);
		getApp().ellipse(getPosX(),getPosY()+getHeight()/2, getHeight(), getWidth());
	}

	
	public void move(char key) {
		char keyC= Character.toLowerCase(key);
		switch(keyC) {
		case 'a':
			moveLeft();
			break;
		case 'd':
			moveRight();
			break;
		case 'w':
			moveUp();
			break;
		case 's':
			moveDown();
			break;
		}
	}
	
	
	private void moveRight() {
		if(getPosX()+getWidth()/2<750) {
			setPosX(getPosX()+(getVel()));
		}
		
	}

	private void moveLeft() {
		if(getPosX()>50) {
			setPosX(getPosX()-(getVel()));
		}
	}
	private void moveUp() {
		if(getPosY()>0) {
			setPosY(getPosY()-(getVel()));
		}

	}
	private void moveDown() {
		if(getPosY()<600) {
			setPosY(getPosY()+(getVel()));
		}


	}


}
