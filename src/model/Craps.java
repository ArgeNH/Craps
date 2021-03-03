package model;

import java.util.Comparator;

public class Craps {
	
	private byte diceOne;
	private byte diceTwo;
	private int token;
	
	public Craps(byte diceOne, byte diceTwo, int token) {
		this.diceOne = diceOne;
		this.diceTwo = diceTwo;
		this.token = token;
	}

	public byte getDiceOne() {
		return diceOne;
	}

	public void setDiceOne(byte diceOne) {
		this.diceOne = diceOne;
	}

	public byte getDiceTwo() {
		return diceTwo;
	}

	public void setDiceTwo(byte diceTwo) {
		this.diceTwo = diceTwo;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

}
