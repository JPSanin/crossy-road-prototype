package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PConstants;

public class ScoreView {
	private int time;
	private Controller controller;
	private PApplet app;
	public ScoreView(PApplet app) {
		this.app = app;
		controller = new Controller(app);
		time=0;
	}
	
	
	public void drawScreen() {
		time= (int) app.millis()/1000;
		app.background(0);
		app.fill(255);
		
		app.textAlign(PConstants.CENTER);
		app.fill(255);
		app.textSize(32);
	
		app.text("Date and Time", 250, 40);
		app.text("Game Duration", 550, 40);
		app.textSize(16);
		app.text("Press P to play again", 400, 600);
		controller.drawPlayers();
	}
	
	public int changeScreen(char key) {
		
		int screen=3;
		char keyC= Character.toLowerCase(key);
		if(keyC=='p') {
			controller.reset();
			screen=1;
		}
		return screen;
	}
	
	public int getTime() {
		return time;
	}
	
	
}
