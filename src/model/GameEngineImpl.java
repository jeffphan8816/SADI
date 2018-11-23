package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import model.interfaces.DicePair;

public class GameEngineImpl implements GameEngine {


	private List<Player> players = new ArrayList<Player>();  //store the player who can place bet
	private ArrayList<GameEngineCallback> gameEngineCallbacks = new ArrayList<GameEngineCallback>(); 
	
	//this function to check if player would have already bet or not
	@Override
	public boolean placeBet(Player player, int bet) {
		
		if (player.placeBet(bet) == true) 
			return true;
		return false;
	}

	
	//method to start rolling the dices til delay increment greater than final delay
	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {
		int time = initialDelay;
		
		for (Iterator<GameEngineCallback> gecallbackList = gameEngineCallbacks.iterator();gecallbackList.hasNext();) {
			GameEngineCallback tmpGECB = gecallbackList.next();
		diceLoop(player,time,delayIncrement,finalDelay, this,tmpGECB); // run the recursion til finalDelay to get the final dices's value
		DicePair dicePair1 = new DicePairImpl(diceRandom(),diceRandom(),NUM_FACES);//meanwhile the diceRandom still runs with the loop
		//after rolling, take the final result to setRollResult
		player.setRollResult(dicePair1);
		//and then callback to the gameEngine
		tmpGECB.result(player,dicePair1,this);
			 ((GameEngineCallbackImpl) tmpGECB).displayResult(player, this);
		}
	}
	
	private void diceLoop(Player player, int curtime, int delay,int finaltime, GameEngine gameEngine, GameEngineCallback gameEngineCallback) {
		if(curtime < finaltime) { //it'll stop 
            DicePair dicePair1 = new DicePairImpl(diceRandom(),diceRandom(),NUM_FACES); //generate new values for dices every loop
			gameEngineCallback.intermediateResult(player, dicePair1, gameEngine);// and then callback to show the intermediateResult
			diceLoop(player,curtime+delay,delay,finaltime, gameEngine,gameEngineCallback);
		}
	}
	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		int time = initialDelay;
		for (Iterator<GameEngineCallback> gecallbackList = gameEngineCallbacks.iterator();gecallbackList.hasNext();) {
			GameEngineCallback tmpGECB = gecallbackList.next();
			diceLoopHouse(time,delayIncrement,finalDelay,this,tmpGECB); // this recursion runs quite similar to the rollPlayer
			DicePair dicePair1 = new DicePairImpl(diceRandom(),diceRandom(),NUM_FACES);
			tmpGECB.houseResult(dicePair1, this);
			
			//Compare players' dice values to the House's dice value and calculate the win/lose points 
			for (Iterator<Player> i = players.iterator();i.hasNext();) {
				Player player = i.next();
				int currpoint = player.getPoints();
				if(getTotal(player.getRollResult()) > getTotal(dicePair1)) {
					player.setPoints(currpoint += player.getBet()*2);
				}
				else if (getTotal(player.getRollResult()) == getTotal(dicePair1)) {
					player.setPoints(currpoint += player.getBet());
				}
				//after all, show the result of all players in that game engine
				((GameEngineCallbackImpl) tmpGECB).displayResult(player, this);		
			}
		}
	}
	// the brief method to get the sum of 2 dices' values
	public int getTotal(DicePair player) {
		return player.getDice1() + player.getDice2();
	}

	@Override
	public void addPlayer(Player player) {
		players.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		for ( Player player:players) {
			if (player.getPlayerId() == id) return player;
		}
		return null;
	}

	
	@Override
	public boolean removePlayer(Player player) {
		if(players.remove(player)) return true;
		else return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		gameEngineCallbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		if (gameEngineCallbacks.remove(gameEngineCallback)) return true;
		else return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return Collections.unmodifiableCollection(players);
	}
	//random the dice
	private int diceRandom() {
		 return (int)(Math.random()*NUM_FACES+1);
	}
	
	//the recursion for rollPlayer
	
	//the recursion for rollHouse
	private void diceLoopHouse(int curtime, int delay,int finaltime, GameEngine gameEngine, GameEngineCallback gameEngineCallback) {
		if(curtime < finaltime) {//it's quite similar to the diceloop method of Player
            DicePair dicePair1 = new DicePairImpl(diceRandom(),diceRandom(),NUM_FACES);
			gameEngineCallback.intermediateHouseResult( dicePair1, gameEngine);
			diceLoopHouse(curtime+delay,delay,finaltime, gameEngine,gameEngineCallback);
		}
	}
}
