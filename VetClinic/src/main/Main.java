package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.DatabaseUtil;

public class Main extends Application {

	public static void main(String[] args) throws Exception {
		DatabaseUtil dbUtil = new DatabaseUtil();
		dbUtil.setUp();
		dbUtil.startTransaction();
		 dbUtil.closeEntityManager();
		 
		launch(args);
		

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/controllers/MainView.fxml"));
		Scene scene = new Scene(root,800,800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Veterinary Clinic App");
		primaryStage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
}
}
