package model;

import model.interfaces.DicePair;

public class DicePairImpl implements DicePair {

	private int dice1Value;
	private int dice2Value;
	private int numfaces;
	public DicePairImpl(int dice1, int dice2, int numfaces) {
		dice1Value = dice1;
		dice2Value = dice2;
		this.numfaces = numfaces;
	}
	
	public int getTotal() {
		return  dice1Value + dice2Value;
	}

	@Override
	public int getDice1() {
		return dice1Value;
	}

	@Override
	public int getDice2() {
		
		return dice2Value;
	}

	@Override
	public int getNumFaces() {
		return numfaces;
	}
	@Override
	public String toString() {
		return "Dice 1: " + Integer.toString(getDice1()) + " Dice 2: " + Integer.toString(getDice2()) + " .. Total: " + Integer.toString(getTotal());
	}
}
