package lsg.ptb.gui;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import lsg.ptb.model.Zone;

public class ZoneCanvas extends Canvas{
	
	ArrayList<Zone> items;
	
	RenderGraphicsVisitor visitor;
	
	public ZoneCanvas(){
		super(800,780);
		
		items = new ArrayList<>();
		visitor = new RenderGraphicsVisitor();
	}
	
	public void setItems(ArrayList<Zone> items){
		this.items = items;
		repaintCanvas();
	}
	
	public void repaintCanvas(){
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.clearRect(0,0,this.getWidth(),this.getHeight());
		
		visitor.setGraphicsContext(gc);
		
		for(Zone z: items){
			z.accept(visitor);
		}
	}
}
