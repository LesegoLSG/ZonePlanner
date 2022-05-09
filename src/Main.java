import lsg.ptb.gui.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception{
		PlannerPane root = new PlannerPane();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Zone Planner Application");
		primaryStage.show();
	}

}
