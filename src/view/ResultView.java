package view;

import processing.core.PApplet;
import processing.core.PConstants;

public class ResultView {

	private boolean result;
	private String message;
	
	private PApplet app;

	public ResultView(PApplet app) {
		this.app = app;
		result=false;
	
	}
	
	public void drawScreen() {
		app.background(0);
		app.fill(255);
		
		app.textAlign(PConstants.CENTER);
		app.fill(255);
		app.textSize(32);
		if(result) {
			message= "You Win";
		}else {
			message= "You Lose";
		}
		app.text(message, 400, 300);
		app.textSize(16);
		if(result) {
			app.text("Date and Game duration saved", 400, 325);
			
		}else {
			app.text("Date and Game duration not saved", 400, 325);
		}
		app.text("Press C to continue", 400, 350);
	}
	
	public int changeScreen(char key) {
		
		int screen=2;
		char keyC= Character.toLowerCase(key);
		if(keyC=='c') {
			screen=3;
		}
		return screen;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	
}

