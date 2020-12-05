package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private MainCharacter mc;
	private ArrayList<Car> cars;
	private ArrayList<Player> players;
	private PApplet app;
	
	private static Logic onlyInstance;
	
	private Logic(PApplet app) {
		cars= new ArrayList<>();
		players=new ArrayList<>();
		this.app=app;
	}
	
	public static Logic getInstance(PApplet app) {
		if(onlyInstance == null) {
			onlyInstance = new Logic(app);
		}
		return onlyInstance;
	}

	public void initializeElements(String[] input) {
		for (int i = 0; i < input.length; i++) {
			String[] atributes=input[i].split(",");
			
			String objectType= atributes[0].trim();
			int dirVel= Integer.parseInt(atributes[1].trim());
			int posX= Integer.parseInt(atributes[2].trim());
			int posY= Integer.parseInt(atributes[3].trim());
			
			if(objectType.equals("carro")) {
				int dir=0;
				if(dirVel<0) {
					dir=-1;
				}else {
					dir=1;
				}
				int vel= Math.abs(dirVel);
				addSingleCar(posX, posY, dir, vel);
				
			}
			
			
			if(objectType.equals("personaje")) {
				addMainCharacter(posX,posY);
			}
			
			
		}
		
	}
	
	private void addSingleCar(int posX, int posY, int dir, int vel) {
		System.out.println("Sisas");
		Car c= new Car(posX,posY,dir,vel,app);
		cars.add(c);
		
	}
	
	private void addMainCharacter(int posX, int posY) {
		mc= new MainCharacter(posX, posY, 0, 50, app);
	}
	
	public void drawElements() {
		
		for(int i=0;i<cars.size(); i++) {
			cars.get(i).draw();
		}
		
		mc.draw();
	}
	

}
