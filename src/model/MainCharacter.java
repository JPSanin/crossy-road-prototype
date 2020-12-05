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
		switch(key) {
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
		System.out.println("Right");
	}

	private void moveLeft() {
		System.out.println("Left");
	}
	private void moveUp() {
		System.out.println("Up");

	}
	private void moveDown() {
		System.out.println("Down");

	}


}
