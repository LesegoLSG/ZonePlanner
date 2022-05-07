package lsg.ptb.gui;

import java.io.File;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

public class PlannerPane extends StackPane {
	
	//private ZoneCanvas canvas = null;//ZoneCanvas class to be created
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
				//setItems(ZoneFileHandler.readZones(file));
			}
		});
		
		FlowPane pane = new FlowPane();
		pane.getChildren().addAll(bar);
		
		this.getChildren().clear();
		this.getChildren().add(pane);
	}
	
	

}
