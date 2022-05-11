package lsg.ptb.gui;

import java.io.File;


import java.util.ArrayList;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import lsg.ptb.file.ZoneFileHandler;
import lsg.ptb.model.Zone;

/**
 * Creates a Pane
 * @author Mhlongo L
 *	@Link StackPane class
 */

public class PlannerPane extends StackPane {
	
	private ZoneCanvas canvas = null;
	MenuBar bar;
	/**
	 * Constructs a pane
	 */
	public PlannerPane(){
		canvas = new ZoneCanvas();
		//Creates a manubar with menu and menuitem
		bar = new MenuBar();
		Menu menu = new Menu("File");
		bar.getMenus().add(menu);
		
		MenuItem item = new MenuItem("Open");
		menu.getItems().add(item);
		
		/*
		 * Eventhandler to create a file chooser pointing to data folder
		 * read from file and setitems
		 */
		item.setOnAction(e ->{
			FileChooser fc = new FileChooser();
			fc.setInitialDirectory(new File("./data"));
			File file = fc.showOpenDialog(null);
			
			if(file != null){
				setItems(ZoneFileHandler.readZones(file));
			}
		});
		
		FlowPane pane = new FlowPane();
		pane.getChildren().addAll(bar);
		
		this.getChildren().clear();
		this.getChildren().add(pane);
		//Binds canvas size to be the same as this PlannerPane's size
		canvas.widthProperty().bind(this.widthProperty());
		canvas.heightProperty().bind(this.heightProperty());
	}
	/**
	 * Sets items
	 * @param items, items in an arraylist consisting of zones
	 */
	public void setItems(ArrayList<Zone> items){
		canvas.setItems(items);
		canvas.repaintCanvas();
	}
	
	

}
