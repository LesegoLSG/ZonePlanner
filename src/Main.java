import lsg.ptb.gui.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author Mhlongo L
 * @Link Application class
 *
 */
public class Main extends Application{
	/**
	 * 
	 * @param args, the command line arguments- unused
	 */
	public static void main(String[] args) {
		
		Application.launch(args);
	}
	
	/**
	 * @param primaryStage, to set a pane
	 */
	public void start(Stage primaryStage) throws Exception{
		PlannerPane root = new PlannerPane();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Zone Planner Application");
		primaryStage.show();
	}

}
