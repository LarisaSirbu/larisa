package com.markone.game.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.markone.game.components.GameController;
import com.markone.game.components.GameRenderer;

public class GameRound implements Screen {

	private GameController controller;
	private GameRenderer renderer;
	
	@Override
	public void show() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		controller = new GameController();
		renderer = new GameRenderer(controller);
	}

	@Override
	public void render(float delta) {
		controller.update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		renderer.resize(width, height);
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		renderer.dispose();
	}

	@Override
	public void dispose() {
		renderer.dispose();
	}

}
