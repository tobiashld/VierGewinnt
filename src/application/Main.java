package application;
	
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	/*
	 * Diese Methode wird beim Starten des Programms ausgeführt und öffnet das Hauptmenue mithilfe der hauptmenue.fxml
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			File fxmlFile = new File("src/application/hauptmenue.fxml");
			URL fxmlUrl = fxmlFile.toURI().toURL();
			loader.setLocation(fxmlUrl);
			AnchorPane root = loader.<AnchorPane>load();
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Vier Gewinnt");
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
