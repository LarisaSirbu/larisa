package com.markone.game.objects;

import com.badlogic.gdx.math.Vector2;

public class KeySliceObject {

	private Vector2 outerLeftPoint;
	private Vector2 outerRightPoint;
	private Vector2 centerPoint;
	
	public KeySliceObject(Vector2 ol, Vector2 or, Vector2 center){
		this.outerLeftPoint=ol;
		this.outerRightPoint=or;
		this.centerPoint=center;
	}
	
	
	public float[] getObjectPointsCoordinates(){
		return new float[]{
						   outerLeftPoint.x,
						   outerLeftPoint.y,
						   centerPoint.x,
						   centerPoint.y,
						   outerRightPoint.x,
						   outerRightPoint.y
						   };
	}

	public short[] getPointsTriangulation(){
		//create the polygon using two triangles
		return new short[]{0,1,2};
	}
	
	public void setOutterLeftPoint(Vector2 outterLeftPoint) {
		this.outerLeftPoint = outterLeftPoint;
	}
	public void setOutterRightPoint(Vector2 outterRightPoint) {
		this.outerRightPoint = outterRightPoint;
	}
	public void setCenterPoint(Vector2 centerPoint) {
		this.centerPoint = centerPoint;
	}
	
	
	
}
