package com.markone.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class CipherSliceObject {

	private Vector2 outerLeftPoint;
	private Vector2 outerRightPoint;
	private Vector2 innerLeftPoint;
	private Vector2 innerRightPoint;
	
	private Color sliceColor;
	
	public CipherSliceObject(Vector2 ol, Vector2 or, Vector2 il, Vector2 ir){
		this.outerLeftPoint=ol;
		this.outerRightPoint=or;
		this.innerLeftPoint=il;
		this.innerRightPoint=ir;
	}
	
	public CipherSliceObject(){
	}
	
	public float[] getObjectPointsCoordinates(){
		return new float[]{outerLeftPoint.x,
						   outerLeftPoint.y,
						   outerRightPoint.x,
						   outerRightPoint.y,
						   innerRightPoint.x,
						   innerRightPoint.y,
						   innerLeftPoint.x,
						   innerLeftPoint.y};
	}

	public short[] getPointsTriangulation(){
		//create the polygon using two triangles
		return new short[]{2,1,0,2,0,3};
	}

	public void setOutterLeftPoint(Vector2 outterLeftPoint) {
		this.outerLeftPoint = outterLeftPoint;
	}

	public void setOutterRightPoint(Vector2 outterRightPoint) {
		this.outerRightPoint = outterRightPoint;
	}

	public void setInnerLeftPoint(Vector2 innerLeftPoint) {
		this.innerLeftPoint = innerLeftPoint;
	}

	public void setInnerRightPoint(Vector2 innerRightPoint) {
		this.innerRightPoint = innerRightPoint;
	}

	public void setSliceColor(Color sliceColor) {
		this.sliceColor = sliceColor;
	}
	
	
	
}
