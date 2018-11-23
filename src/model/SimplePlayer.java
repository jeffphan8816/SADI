package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String playerName;
	private String playerID;
	private int playerPoints = 0;
	private DicePair curDicePair;
	private int bet=0;
	public SimplePlayer(String a, String b, int c) {
		playerID = a;
		playerName = b;
		playerPoints = c;
	}

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;

	}

	@Override
	public int getPoints() {
		return playerPoints;
	}

	@Override
	public void setPoints(int points) {
		playerPoints = points;
	}

	@Override
	public String getPlayerId() {
		return playerID;
	}

	@Override
	public boolean placeBet(int bet) {
		if (playerPoints >= bet) {
			this.bet = bet;
			playerPoints -= bet;
			return true;
		}
		else return false;
	}

	@Override
	public int getBet() {
		return this.bet;
	}

	@Override
	public DicePair getRollResult() {
	 return curDicePair;
	}
	

	@Override
	public void setRollResult(DicePair rollResult) {
		curDicePair = rollResult;
	}	
	@Override
	public String toString() {
		return "Player: id=" + getPlayerId() + ", name=" + getPlayerName() + ", points=" + getPoints();
	}
}
