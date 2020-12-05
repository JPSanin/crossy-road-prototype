package view;


import processing.core.PApplet;


public class Main extends PApplet {

	private int screen;
	private GameView gv;

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
	

	}

	public void draw() {
		background(0,71,49);
		switch (screen) {
		case 1:
			gv.drawScreen();
			break;

		}
		
		
		text(mouseX+", "+mouseY, mouseX, mouseY);
		
	}
}