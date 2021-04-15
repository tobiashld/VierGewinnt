package application;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class hauptmenueController {
	
	public void oneOnOne(ActionEvent event) throws IOException {
		Parent tableviewparent = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene tableviewscene = new Scene(tableviewparent,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableviewscene);
		window.show();
	}
	
	public void oneOnJarvis(ActionEvent event) throws IOException {
		Parent tableviewparent = FXMLLoader.load(getClass().getResource("MainComputer.fxml"));
		Scene tableviewscene = new Scene(tableviewparent,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableviewscene);
		window.show();
	}
}
