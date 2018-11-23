package model;


import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see model.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
	private Logger logger = Logger.getLogger("assignment1");
	
	
	public GameEngineCallbackImpl()
	{
		logger.setLevel(Level.FINE);
		
	}
	//show the dice values while they're still rolling
	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine)
	{
		
		logger.log(Level.FINE, String.format("%s: ROLLING %s", player.getPlayerName(), dicePair.toString()));
		
	}
	// show the final result
	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine)
	{
		// final results logged at Level.INFO
		logger.log(Level.INFO,String.format("%s: *RESULT* %s", player.getPlayerName(), result.toString()));
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		logger.log(Level.FINE, String.format("House: ROLLING %s", dicePair.toString()));

	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		logger.log(Level.INFO,String.format("House: *RESULT* %s", result.toString()));
		
	}
	
	// it's final result of the game which shows total points of players after winning or losing
	public void displayResult(Player player,GameEngine gameEngine) {
		logger.log(Level.INFO,String.format("%s", player.toString()));
	}


}
