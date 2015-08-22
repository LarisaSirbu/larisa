package com.markone.game;

import com.badlogic.gdx.Game;
import com.markone.game.screens.GameRound;

public class ChromoClickerGame extends Game {

	
	@Override
	public void create () {
		setScreen(new GameRound());
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override    
	public void dispose() {  
		super.dispose();
	}
	
	 @Override    
	 public void resize(int width, int height) {
		 super.resize(width, height);
	 }
	 
	 @Override
	 public void pause() { 
	    super.pause();
	 }
	
	 @Override    
	 public void resume() { 
		 super.resume();
	 } 

}
