package view;


import processing.core.PApplet;


public class Main extends PApplet {

	private int screen;
	private GameView gv;
	private ResultView rv;
	private ScoreView sv;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(800,650);

	}

	public void setup() {

		screen=1;
		gv= new GameView(this);
		String[] input= loadStrings("data/info.txt");
		try {
			gv.initializeElements(input);
		}catch(NullPointerException npe) {
			npe.printStackTrace();
			System.out.println("The file was not found please check if it is in the data directory");
		}
		rv= new ResultView(this);
		sv= new ScoreView(this);


	}

	public void draw() {
		background(0,71,49);
		switch (screen) {
		case 1:
			gv.drawScreen();
			if(gv.isWin()) {
				rv.setResult(true);
				screen=2;
			}
			
			if(gv.isLose()) {
				rv.setResult(false);
				screen=2;
			}
			
			break;
		case 2:
			rv.drawScreen();
			break;
		case 3:
			sv.drawScreen();
			break;

		}


		text(mouseX+", "+mouseY, mouseX, mouseY);

	}
	
	public void keyPressed() {
		switch (screen) {
		case 1:
			gv.moveCharacter(key);
			break;
		case 2:
			screen=rv.changeScreen(key);
			break;
		case 3:
			int temp=0;
			temp=sv.changeScreen(key);
			if(temp==1) {
				gv.setLose(false);
				gv.setWin(false);
				gv.setScrapTime(sv.getTime());
				screen=1;
			}
			break;

		}
	}

	
	public void mousePressed() {
		switch (screen) {
		
		case 3:
			sv.sortScores();
			break;

		}
	}
	


}