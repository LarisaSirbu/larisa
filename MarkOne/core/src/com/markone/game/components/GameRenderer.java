package com.markone.game.components;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class GameRenderer implements Disposable {

	private OrthographicCamera camera;
	private GameController controller;
	private PolygonSpriteBatch slicesSpriteBatch;
	
	public GameRenderer(GameController controller) {
		this.controller=controller;
		init();
	}
	
	public void init(){
		 slicesSpriteBatch= new PolygonSpriteBatch();
		 camera = new OrthographicCamera(); 
		 camera.position.set(0,0,0);
		 camera.update();
	}
	
	public void render(){
		renderScene();
	}
	
	public void resize(int width,int height){
		camera.viewportWidth=width;
		camera.viewportWidth=height;
		camera.update();
	}
	
	@Override
	public void dispose() {
		
	}
	
	private void renderScene(){
				
//		slicesSpriteBatch.setProjectionMatrix(camera.combined);
		slicesSpriteBatch.begin();
		for(PolygonSprite spliceSprite:controller.getCipherSprites()){
			spliceSprite.draw(slicesSpriteBatch);
		}
		
		for(PolygonSprite spliceSprite:controller.getKeySprites()){
			spliceSprite.draw(slicesSpriteBatch);
		}
		slicesSpriteBatch.end();
		
	}

}
