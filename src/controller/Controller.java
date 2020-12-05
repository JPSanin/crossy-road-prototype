package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {
	
	private Logic logic;

	public Controller(PApplet app) {
		logic=Logic.getInstance(app);
	}

	public void initializeElements(String[] input) {
		logic.initializeElements(input);
	}

	public void drawElements() {
		logic.drawElements();
		
	}

	public void generateCars() {
	logic.carGenerator();
		
	}

}
