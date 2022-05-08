package lsg.ptb.model;

import javafx.scene.paint.Color;

public enum EZoneType {
	INDUSTRIAL(Color.ORANGE),
	COMMERCIAL(Color.CYAN),
	FARMING(Color.GREEN), 
	RESIDENTIAL(Color.MAGENTA);
	
	private final javafx.scene.paint.Color zoneColour;
	
	private EZoneType(javafx.scene.paint.Color colour){
		zoneColour = colour;
	}
	
	public javafx.scene.paint.Color getZoneColour(){
		return zoneColour;
	}
}
