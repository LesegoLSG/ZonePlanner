package lsg.ptb.gui;

import lsg.ptb.model.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RenderGraphicsVisitor implements IRenderVisitor{
	
	private GraphicsContext graphics;
	public static final int DEFAULT_SIZE = 100;
	
	public GraphicsContext getGraphicsContext(){
		return graphics;
	}
	
	public void setGraphicsContext(GraphicsContext graphics){
		this.graphics = graphics;
	}
	
	public void render(PlannedZone planned){
		double x = planned.getLocation().getX();
		double y = planned.getLocation().getY();
		
		graphics.setFill(Color.BLACK);
		
		graphics.fillRect(x, y, DEFAULT_SIZE, DEFAULT_SIZE);
		
		graphics.setFill(Color.WHITE);
		graphics.fillText(planned.getQuality(), x+25, y+25);
	}
	
	public void render(ActiveZone active){
		double x = active.getLocation().getX();
		double y = active.getLocation().getY();
		
		graphics.setFill(active.getType().getZoneColour());
		graphics.fillOval(x, y, active.getSize(), active.getSize());
	
		graphics.setFill(Color.WHITE);
		graphics.fillText(active.getType().toString(), x+25, y+25);
		graphics.fillText(active.getExport(), x+32, x+35);
	}
}
