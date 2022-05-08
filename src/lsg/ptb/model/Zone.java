package lsg.ptb.model;

import javafx.geometry.Point2D;

public abstract class Zone implements IRenderable {
	
	private final Point2D location;
	private final EZoneType type;
	
	public Zone(int x, int y, EZoneType type){
		this.location = new Point2D(x,y);
		this.type = type;
	}
	
	public EZoneType getType(){
		return type;
	}
	
	public Point2D getLocation(){
		return location;
	}
}
