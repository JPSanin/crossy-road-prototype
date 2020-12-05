package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.LoseException;
import processing.core.PApplet;

public class Logic {
	
	private MainCharacter mc;
	private ArrayList<Car> cars;
	private ArrayList<Player> players;
	
	private ArrayList<Car> lane1;
	private ArrayList<Car> lane2;
	private ArrayList<Car> lane3;
	private ArrayList<Car> lane4;
	private ArrayList<Car> lane5;
	private ArrayList<Car> lane6;
	
	private DurationComparator dc;
	
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
		dc=new DurationComparator();
		
	
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

	public void moveCharacter(char key) {
		mc.move(key);
	}
	
	public void checkLose() throws LoseException{
		
		switch(mc.getPosY()) {
		
		case 50:
			for (int i=0; i<lane1.size(); i++) {
				int x1=mc.getPosX();
				int y1=mc.getPosY();
				int x2=lane1.get(i).getPosX()+lane1.get(i).getWidth()/2;
				int y2=lane1.get(i).getPosY()+lane1.get(i).getHeight()/2;
				if (PApplet.dist(x1,y1 ,x2 , y2)<mc.getWidth()/2+lane1.get(i).getWidth()/2) {
					throw new LoseException();
				}
			}
		
			break;
		case 150:
			for (int i=0; i<lane2.size(); i++) {
				int x1=mc.getPosX();
				int y1=mc.getPosY();
				int x2=lane2.get(i).getPosX()+lane2.get(i).getWidth()/2;
				int y2=lane2.get(i).getPosY()+lane2.get(i).getHeight()/2;
				if (PApplet.dist(x1,y1 ,x2 , y2)<mc.getWidth()/2+lane2.get(i).getWidth()/2) {
					throw new LoseException();
				}
			}
			break;
		case 250:
			for (int i=0; i<lane3.size(); i++) {
				int x1=mc.getPosX();
				int y1=mc.getPosY();
				int x2=lane3.get(i).getPosX()+lane3.get(i).getWidth()/2;
				int y2=lane3.get(i).getPosY()+lane3.get(i).getHeight()/2;
				if (PApplet.dist(x1,y1 ,x2 , y2)<mc.getWidth()/2+lane3.get(i).getWidth()/2) {
					throw new LoseException();
				}
			}
			break;
		case 350:
			for (int i=0; i<lane4.size(); i++) {
				int x1=mc.getPosX();
				int y1=mc.getPosY();
				int x2=lane4.get(i).getPosX()+lane4.get(i).getWidth()/2;
				int y2=lane4.get(i).getPosY()+lane4.get(i).getHeight()/2;
				if (PApplet.dist(x1,y1 ,x2 , y2)<mc.getWidth()/2+lane4.get(i).getWidth()/2) {
					throw new LoseException();
				}
			}
			break;
		case 450:
			for (int i=0; i<lane5.size(); i++) {
				int x1=mc.getPosX();
				int y1=mc.getPosY();
				int x2=lane5.get(i).getPosX()+lane5.get(i).getWidth()/2;
				int y2=lane5.get(i).getPosY()+lane5.get(i).getHeight()/2;
				if (PApplet.dist(x1,y1 ,x2 , y2)<mc.getWidth()/2+lane5.get(i).getWidth()/2) {
					throw new LoseException();
				}
			}
			break;
		case 550:
			for (int i=0; i<lane6.size(); i++) {
				int x1=mc.getPosX();
				int y1=mc.getPosY();
				int x2=lane6.get(i).getPosX()+lane6.get(i).getWidth()/2;
				int y2=lane6.get(i).getPosY()+lane6.get(i).getHeight()/2;
				if (PApplet.dist(x1,y1 ,x2 , y2)<mc.getWidth()/2+lane6.get(i).getWidth()/2) {
					throw new LoseException();
				}
			}
			break;
		}
		
		
		
	}
	
	public boolean checkWin() {
		if(mc.getPosY()>=600) {
			return true;
		}else {
			return false;
		}
	}

	public void addPlayer(LocalDateTime dateTime, int gameTime) {
		Player p= new Player(dateTime,gameTime, app);
		players.add(p);
		
	}

	public void drawPlayers() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).draw(75+(i*25));
		}
		
	}
	
	public void sortScores(int sort) {
		switch (sort) {
		case 1:
			Collections.sort(players);
			break;
		case 2:
			Collections.sort(players,dc);
			break;
		
		}
		
	}

	public void reset() {
		mc.setPosX(400);
		mc.setPosY(0);
	}

	
	
	

}
