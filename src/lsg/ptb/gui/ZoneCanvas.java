package lsg.ptb.gui;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import lsg.ptb.model.Zone;

	/**
	 * Class creates canvas for zone
	 * @author Mhlongo L
	 * @Link Canvas class
	 *
	 */
public class ZoneCanvas extends Canvas{
	
	//Creating ArrayList for items
	ArrayList<Zone> items;
	
	//Creating Visitor instance
	RenderGraphicsVisitor visitor;
	
	/**
	 * Constructs ZoneCanvas to initialize instance members
	 */
	public ZoneCanvas(){
		
		super(800,780);
		
		items = new ArrayList<>();
		visitor = new RenderGraphicsVisitor();
	}
	/**
	 * sets items and repaint canvas if it wasn't in zonepane
	 * @param items, instance of ArrayList consisting of zone
	 */
	public void setItems(ArrayList<Zone> items){
		this.items = items;
		repaintCanvas();
	}
	
	/**
	 * Method to repaint canvas as called in a setitems method
	 */
	public void repaintCanvas(){
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.clearRect(0,0,this.getWidth(),this.getHeight());
		
		visitor.setGraphicsContext(gc);
		
		for(Zone z: items){
			z.accept(visitor);
		}
	}
}
