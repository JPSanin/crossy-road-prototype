package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private MainCharacter mc;
	private ArrayList<Car> cars;
	private ArrayList<Player> players;
	
	ArrayList<Car> lane1;
	ArrayList<Car> lane2;
	ArrayList<Car> lane3;
	ArrayList<Car> lane4;
	ArrayList<Car> lane5;
	ArrayList<Car> lane6;
	
	private PApplet app;
	
	private static Logic onlyInstance;
	
	private Logic(PApplet app) {
		cars= new ArrayList<>();
		players=new ArrayList<>();
		lane1= new ArrayList<>();
		lane2= new ArrayList<>();
		lane3= new ArrayList<>();
		lane4= new ArrayList<>();
		lane5= new ArrayList<>();
		lane6= new ArrayList<>();
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
		Car c= new Car(posX,posY,dir,vel,app);
		switch(posY) {
		case 50:
			lane1.add(c);
			cars.add(c);
			break;
		case 150:
			lane2.add(c);
			cars.add(c);
			break;
		case 250:
			lane3.add(c);
			cars.add(c);
			break;
		case 350:
			lane4.add(c);
			cars.add(c);
			break;
		case 450:
			lane5.add(c);
			cars.add(c);
			break;
		case 550:
			lane6.add(c);
			cars.add(c);
			break;
		}

		
	}
	
	private void addMainCharacter(int posX, int posY) {
		mc= new MainCharacter(posX, posY, 0, 50, app);
	}
	
	//Generate Cars
	public void carGenerator() {
		int max=5;
		
		
		while(cars.size()<30) {
			int randomLane= (int) app.random(1,7);
			int randomX=(int) app.random(1,700);
			int vel= (int) app.random(1,5);
			switch(randomLane) {
			case 1:
				if(lane1.size()<max) {
					addSingleCar(randomX, 50, -1, vel);
				}
				break;
			case 2:
				if(lane2.size()<max) {
					addSingleCar(randomX, 150, 1, vel);
				}
				break;
			case 3:
				if(lane3.size()<max) {
					addSingleCar(randomX, 250, -1, vel);
				}
				break;
			case 4:
				if(lane4.size()<max) {
					addSingleCar(randomX, 350, -1, vel);
				}
				break;
			case 5:
				if(lane5.size()<max) {
					addSingleCar(randomX, 450, 1, vel);
				}
				break;
			case 6:
				if(lane6.size()<max) {
					addSingleCar(randomX, 550, -1, vel);
				}
				break;
			}
			
		}
		
		
	}
	
	public void drawElements() {
		
		for(int i=0;i<cars.size(); i++) {
			cars.get(i).draw();
			
			Thread t1= new Thread(cars.get(i));
			t1.start();
		
		}
		
		mc.draw();
	}
	

}
