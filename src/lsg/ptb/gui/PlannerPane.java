package lsg.ptb.gui;

import java.io.File;

import java.util.ArrayList;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import lsg.ptb.file.ZoneFileHandler;
import lsg.ptb.model.Zone;

public class PlannerPane extends StackPane {
	
	private ZoneCanvas canvas = null;//ZoneCanvas class to be created
	MenuBar bar;
	
	public PlannerPane(){
		//canvas = new ZoneCanvas();
		
		bar = new MenuBar();
		Menu menu = new Menu("File");
		bar.getMenus().add(menu);
		
		MenuItem item = new MenuItem("Open");
		menu.getItems().add(item);
		
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
		//canvas.widthProperty().bind(this.widthProperty());
		//canvas.heightProperty().bind(this.heightProperty());
	}
	
	public void setItems(ArrayList<Zone> items){
		canvas.setItems(items);
		canvas.repaintCanvas();
	}
	
	

}
