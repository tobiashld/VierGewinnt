package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class hauptmenueController {
	
	/*
	 * Methode für den 1v1 Button
	 * Ruft ein neues Fenster auf und nimmt die Main.fxml als Grundlage
	 */
	public void oneOnOne(ActionEvent event) throws IOException {
		Parent new_parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene new_scene = new Scene(new_parent,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(new_scene);
		window.show();
	}
	
	/*
	 * Methode für den 1vComputer Button
	 * Ruft ein neues Fenster auf und nimmt die MainComputer.fxml als Grundlage
	 */
	public void oneOnJarvis(ActionEvent event) throws IOException {
		Parent new_parent = FXMLLoader.load(getClass().getResource("MainComputer.fxml"));
		Scene new_scene = new Scene(new_parent,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(new_scene);
		window.show();
	}
}
