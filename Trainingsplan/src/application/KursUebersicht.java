package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KursUebersicht extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("KursUebersicht.fxml"));
			Scene scene = new Scene(root);
			primaryStage.sizeToScene();
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);

	}

}
