package lsg.ptb.model;

import javafx.geometry.Point2D;

/**
 * 
 * @author Mhlongo L
 *
 */
public abstract class Zone implements IRenderable {
	
	private final Point2D location;
	private final EZoneType type;
	
	/**
	 * 
	 * @param x, coordinate or position of the Zone
	 * @param y, coordinate or position of the Zone
	 * @param type, Anomaly type of the Zone
	 */
	public Zone(int x, int y, EZoneType type){
		this.location = new Point2D(x,y);
		this.type = type;
	}
	/**
	 * @return the type
	 */
	public EZoneType getType(){
		return type;
	}
	/**
	 * @return the location
	 */
	public Point2D getLocation(){
		return location;
	}
}
