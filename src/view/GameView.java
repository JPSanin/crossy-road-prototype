package view;

import controller.Controller;
import processing.core.PApplet;

public class GameView {
	
	
	private int streetStartY;
	private int streetHeight;
	private int streetWidth;
	private int spacing;
	private Controller controller;
	
	private PApplet app;

	public GameView(PApplet app) {
		this.app = app;

		streetStartY=50;
		streetHeight=50;
		streetWidth=800;
		spacing=50;
		
		controller= new Controller(app);
		
		
	}
	
	
	public void drawScreen() {
		app.fill(125);
		app.noStroke();
		for(int i=0; i<6; i++) {
			app.rect(0, streetStartY+(i*streetHeight)+(i*spacing), streetWidth, streetHeight);
		}
		controller.drawElements();
	}


	public void initializeElements(String[] input) {
		controller.initializeElements(input);
		controller.generateCars();		
	}


	public void moveCharacter(char key) {
		controller.moveCharacter(key);
		
	}
	
	

}
