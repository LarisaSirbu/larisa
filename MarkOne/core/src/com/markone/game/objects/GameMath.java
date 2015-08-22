package com.markone.game.objects;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public final class GameMath {

	private GameMath(){
	}

	//determine equidistant points on outter and inner circle
	public static List<CipherSliceObject> generateCipherSlices(int numberOfSlices, float cX,float cY, float sr, float br){
		
		List<CipherSliceObject> slices = new ArrayList<CipherSliceObject>();
		
		double step= 360/numberOfSlices;
		for(double angle1=0, angle2=step;angle1<=360; angle1+=step, angle2+=step){
			Vector2 or = determineCoordinatesOnCircle(cX,cY,br,angle1);
			Vector2 ol = determineCoordinatesOnCircle(cX,cY,br,angle2);
			Vector2 ir = determineCoordinatesOnCircle(cX,cY,sr,angle1);
			Vector2 il = determineCoordinatesOnCircle(cX,cY,sr,angle2);
			CipherSliceObject slice= new CipherSliceObject(ol, or, il, ir);
			slices.add(slice);
		}
		
		return slices;
	}
	
	public static List<KeySliceObject> generateKeySlices(int numberOfSlices, float cX,float cY, float r){
		
		List<KeySliceObject> slices = new ArrayList<KeySliceObject>();
		
		double step= 360/numberOfSlices;
		for(double angle1=0, angle2=step;angle1<=360; angle1+=step, angle2+=step){
			Vector2 or = determineCoordinatesOnCircle(cX,cY,r,angle1);
			Vector2 ol = determineCoordinatesOnCircle(cX,cY,r,angle2);
			Vector2 center = new Vector2(cX,cY);
			KeySliceObject slice= new KeySliceObject(ol, or, center);
			slices.add(slice);
		}
		
		return slices;
	}
	
	private static Vector2 determineCoordinatesOnCircle(float cx, float cy, float ray, double angle){
		Vector2 vertice = new Vector2();
		vertice.x=(float) (cx+ray*Math.sin(Math.toRadians(angle)));
		vertice.y=(float) (cy+ray*Math.cos(Math.toRadians(angle)));
		return vertice;
	}
	
}
