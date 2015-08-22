package com.markone.game.components;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.markone.game.objects.CipherSliceObject;
import com.markone.game.objects.GameMath;
import com.markone.game.objects.KeySliceObject;

public class GameController {

	private LinkedList<PolygonSprite> keySprites;
	private LinkedList<PolygonSprite> cipherSprites;
	private Texture sliceTexture;
	
	public GameController(){
		init();
	}
	
	private void init(){
		initializeSceneObjects();
	}
	
	private void initializeSceneObjects()
	{
		float cX= Gdx.graphics.getWidth()/2.0f;
		float cY = Gdx.graphics.getHeight()/2.0f; 
		
		float outerCircleRadius = Math.min(cX, cY)-10;
		float innerCircleRadius = outerCircleRadius*0.75f;
		
		List<CipherSliceObject> cipherSlices = new ArrayList<CipherSliceObject>();
		List<KeySliceObject> keySlices = new ArrayList<KeySliceObject>();
		
		
		cipherSlices = GameMath.generateCipherSlices(8, cX, cY,innerCircleRadius ,outerCircleRadius);
		keySlices = GameMath.generateKeySlices(8, cX, cY, innerCircleRadius-20);
		cipherSprites = new LinkedList<PolygonSprite>();
		keySprites = new LinkedList<PolygonSprite>();
		
		
		Random random= new Random();
		for(int i=0;i<cipherSlices.size();i++){
			Pixmap pix1 = new Pixmap(2, 2, Pixmap.Format.RGBA8888);
			pix1.setColor(Color.toIntBits(random.nextInt(255), random.nextInt(255), random.nextInt(255), 255));
			pix1.fill();
			sliceTexture = new Texture(pix1);
			
			PolygonRegion polyReg = new PolygonRegion(new TextureRegion(sliceTexture),
													  cipherSlices.get(i).getObjectPointsCoordinates(),
													  cipherSlices.get(i).getPointsTriangulation());
			PolygonSprite sliceSprite = new PolygonSprite(polyReg);
			sliceSprite.setOrigin(cX, cY);
			cipherSprites.add(sliceSprite);
			pix1.dispose();
		}
		
		for(int i=0;i<keySlices.size();i++){
			Pixmap pix1 = new Pixmap(2, 2, Pixmap.Format.RGBA8888);
			pix1.setColor(Color.toIntBits(random.nextInt(255), random.nextInt(255), random.nextInt(255), 255));
			pix1.fill();
			sliceTexture = new Texture(pix1);
			
			PolygonRegion polyReg = new PolygonRegion(new TextureRegion(sliceTexture),
													  keySlices.get(i).getObjectPointsCoordinates(),
													  keySlices.get(i).getPointsTriangulation());
			PolygonSprite sliceSprite = new PolygonSprite(polyReg);
			sliceSprite.setOrigin(cX, cY);
			keySprites.add(sliceSprite);
			pix1.dispose();
		}
	}
	
	public void update() {
	}

	public LinkedList<PolygonSprite> getCipherSprites() {
		return cipherSprites;
	}
	public LinkedList<PolygonSprite> getKeySprites() {
		return keySprites;
	}
	
}
