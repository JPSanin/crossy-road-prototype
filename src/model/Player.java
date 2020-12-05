package model;

import java.time.LocalDateTime;

import processing.core.PApplet;

public class Player implements Comparable<Player>{
	
	private LocalDateTime gameDateTime;
	private int gameDuration;
	
	private PApplet app;

	public Player(LocalDateTime gameDateTime, int gameDuration, PApplet app) {
		super();
		this.gameDateTime = gameDateTime;
		this.gameDuration = gameDuration;
		this.app = app;
	}
	
	public void draw() {}

	@Override
	public int compareTo(Player arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public LocalDateTime getGameDateTime() {
		return gameDateTime;
	}

	public void setGameDateTime(LocalDateTime gameDateTime) {
		this.gameDateTime = gameDateTime;
	}

	public int getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(int gameDuration) {
		this.gameDuration = gameDuration;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}




	
	
	

}
