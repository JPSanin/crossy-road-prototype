package view;

import java.time.LocalDateTime;

import controller.Controller;
import exceptions.LoseException;
import processing.core.PApplet;
import processing.core.PConstants;

public class GameView {
	
	
	private int streetStartY;
	private int streetHeight;
	private int streetWidth;
	private int spacing;
	private boolean win;
	private boolean lose;
	private int gameTime;
	private int scrapTime;
	private Controller controller;
	
	private PApplet app;

	public GameView(PApplet app) {
		this.app = app;

		streetStartY=50;
		streetHeight=50;
		streetWidth=800;
		spacing=50;
		win=false;
		lose=false;
		controller= new Controller(app);
		gameTime=0;
		scrapTime=0;
		
		
	}
	
	
	public void drawScreen() {
		
		gameTime= (int) app.millis()/1000-scrapTime;
		app.fill(125);
		app.noStroke();
		for(int i=0; i<6; i++) {
			app.rect(0, streetStartY+(i*streetHeight)+(i*spacing), streetWidth, streetHeight);
		}
		controller.drawElements();
		app.fill(255);
		app.textAlign(PConstants.LEFT);
		app.textSize(12);
		app.text("Game Time: "+gameTime+ " seconds",20,15);
		if(controller.checkWin()) {
			win=true;
			LocalDateTime dateTime= LocalDateTime.now();
			controller.addPlayer(dateTime,gameTime);
		}else {
			win=false;
		}
		
		try {
			controller.checkLose();
		} catch (LoseException e) {
			lose=true;
		}
	}


	public void initializeElements(String[] input) {
		controller.initializeElements(input);
		controller.generateCars();		
	}


	public void moveCharacter(char key) {
		controller.moveCharacter(key);
		
	}
	

	
	
	public void setScrapTime(int scrapTime) {
		this.scrapTime = scrapTime;
	}


	public boolean isWin() {
		return win;
	}


	public boolean isLose() {
		return lose;
	}
	
	public void setWin(boolean win) {
		this.win = win;
	}


	public void setLose(boolean lose) {
		this.lose = lose;
	}


}
