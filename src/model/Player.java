package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import processing.core.PApplet;

public class Player implements Comparable<Player>{
	
	private LocalDateTime gameDateTime;
	private int gameDuration;
	private String gameDateTimeString;
	
	private PApplet app;

	public Player(LocalDateTime gameDateTime, int gameDuration, PApplet app) {
		super();
		this.gameDateTime = gameDateTime;
		this.gameDuration = gameDuration;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		gameDateTimeString= gameDateTime.format(formatter);
		this.app = app;
	}
	
	public void draw(int posY) {
		app.fill(255);
		app.textSize(16);
		app.text(gameDateTimeString, 250, posY);
		app.text(gameDuration+ " seconds", 550, posY);
		
	}

	@Override
	public int compareTo(Player p1) {
		return gameDateTime.compareTo(p1.getGameDateTime());
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

	public String getGameDateTimeString() {
		return gameDateTimeString;
	}

	public void setGameDateTimeString(String gameDateTimeString) {
		this.gameDateTimeString = gameDateTimeString;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}




	
	
	

}
