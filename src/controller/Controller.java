package controller;

import java.time.LocalDateTime;

import exceptions.LoseException;
import model.Logic;
import processing.core.PApplet;

public class Controller {

	private Logic logic;

	public Controller(PApplet app) {
		logic=Logic.getInstance(app);
	}

	public void initializeElements(String[] input) {
		logic.initializeElements(input);
	}

	public void drawElements() {
		logic.drawElements();

	}

	public void generateCars() {
		logic.carGenerator();

	}

	public void moveCharacter(char key) {
		logic.moveCharacter(key);

	}

	public boolean checkWin() {
		return logic.checkWin();
	}

	public void checkLose() throws LoseException {
		logic.checkLose();
		
	}

	public void addPlayer(LocalDateTime dateTime, int gameTime) {
		logic.addPlayer(dateTime,gameTime);
		
	}

	public void drawPlayers() {
		logic.drawPlayers();
		
	}

	public void reset() {
		logic.reset();
		
	}

}
