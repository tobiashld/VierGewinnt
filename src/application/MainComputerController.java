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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainComputerController {
	Spielfeld spielfeld1 = new Spielfeld();
	HashMap<String,Button> buttonMap = new HashMap<>();
	int aktSpieler = 1;
	String[] spielerName = new String[2];
	int[] spielstand = new int[2];
	
	@FXML
	public Button ersterButton00 = new Button();
	public Button ersterButton01 = new Button();
	public Button ersterButton02 = new Button();
	public Button ersterButton03 = new Button();
	public Button ersterButton04 = new Button();
	public Button ersterButton05 = new Button();
	public Button ersterButton06 = new Button();
	public Button ersterButton10 = new Button();
	public Button ersterButton11 = new Button();
	public Button ersterButton12 = new Button();
	public Button ersterButton13 = new Button();
	public Button ersterButton14 = new Button();
	public Button ersterButton15 = new Button();
	public Button ersterButton16 = new Button();
	public Button ersterButton20 = new Button();
	public Button ersterButton21 = new Button();
	public Button ersterButton22 = new Button();
	public Button ersterButton23 = new Button();
	public Button ersterButton24 = new Button();
	public Button ersterButton25 = new Button();
	public Button ersterButton26 = new Button();
	public Button ersterButton30 = new Button();
	public Button ersterButton31 = new Button();
	public Button ersterButton32 = new Button();
	public Button ersterButton33 = new Button();
	public Button ersterButton34 = new Button();
	public Button ersterButton35 = new Button();
	public Button ersterButton36 = new Button();
	public Button ersterButton40 = new Button();
	public Button ersterButton41 = new Button();
	public Button ersterButton42 = new Button();
	public Button ersterButton43 = new Button();
	public Button ersterButton44 = new Button();
	public Button ersterButton45 = new Button();
	public Button ersterButton46 = new Button();
	public Button ersterButton50 = new Button();
	public Button ersterButton51 = new Button();
	public Button ersterButton52 = new Button();
	public Button ersterButton53 = new Button();
	public Button ersterButton54 = new Button();
	public Button ersterButton55 = new Button();
	public Button ersterButton56 = new Button();
	
	
	public Label gewonnenLabel = new Label();
	public GridPane gridpane = new GridPane();
	public Button neuesSpielButton = new Button();
	public Button hauptmenueButton = new Button();
	public TextField spielerEins = new TextField();
	public TextField spielerZwei = new TextField();
	public Label spielerEinsLabel = new Label();
	public Label spielerZweiLabel = new Label();
	public Button spielStartenButton = new Button();
	public Label spielerEinsAnzeige = new Label();
	public Label spielerEinsAnzeigeLabel = new Label();
	public Label spielerZweiAnzeige = new Label();
	public Label spielerZweiAnzeigeLabel = new Label();
	public Button partieWeiterspielenButton = new Button();
	
	
	@FXML
	public void initialize() {
		mapInitialisieren();
	}
	
	public void mapInitialisieren() {

		buttonMap.put("ersterButton00",ersterButton00);
		buttonMap.put("ersterButton01",ersterButton01);
		buttonMap.put("ersterButton02",ersterButton02);
		buttonMap.put("ersterButton03",ersterButton03);
		buttonMap.put("ersterButton04",ersterButton04);
		buttonMap.put("ersterButton05",ersterButton05);
		buttonMap.put("ersterButton06",ersterButton06);
		buttonMap.put("ersterButton10",ersterButton10);
		buttonMap.put("ersterButton11",ersterButton11);
		buttonMap.put("ersterButton12",ersterButton12);
		buttonMap.put("ersterButton13",ersterButton13);
		buttonMap.put("ersterButton14",ersterButton14);
		buttonMap.put("ersterButton15",ersterButton15);
		buttonMap.put("ersterButton16",ersterButton16);
		buttonMap.put("ersterButton20",ersterButton20);
		buttonMap.put("ersterButton21",ersterButton21);
		buttonMap.put("ersterButton22",ersterButton22);
		buttonMap.put("ersterButton23",ersterButton23);
		buttonMap.put("ersterButton24",ersterButton24);
		buttonMap.put("ersterButton25",ersterButton25);
		buttonMap.put("ersterButton26",ersterButton26);
		buttonMap.put("ersterButton30",ersterButton30);
		buttonMap.put("ersterButton31",ersterButton31);
		buttonMap.put("ersterButton32",ersterButton32);
		buttonMap.put("ersterButton33",ersterButton33);
		buttonMap.put("ersterButton34",ersterButton34);
		buttonMap.put("ersterButton35",ersterButton35);
		buttonMap.put("ersterButton36",ersterButton36);
		buttonMap.put("ersterButton40",ersterButton40);
		buttonMap.put("ersterButton41",ersterButton41);
		buttonMap.put("ersterButton42",ersterButton42);
		buttonMap.put("ersterButton43",ersterButton43);
		buttonMap.put("ersterButton44",ersterButton44);
		buttonMap.put("ersterButton45",ersterButton45);
		buttonMap.put("ersterButton46",ersterButton46);
		buttonMap.put("ersterButton50",ersterButton50);
		buttonMap.put("ersterButton51",ersterButton51);
		buttonMap.put("ersterButton52",ersterButton52);
		buttonMap.put("ersterButton53",ersterButton53);
		buttonMap.put("ersterButton54",ersterButton54);
		buttonMap.put("ersterButton55",ersterButton55);
		buttonMap.put("ersterButton56",ersterButton56);
	}
	
	
	@FXML 
	public void ersteReiheAusgewaehlt(ActionEvent event) throws IOException{
		verarbeiteSpielzug(0,event);
	}
	@FXML 
	public void zweiteReiheAusgewaehlt(ActionEvent event) throws IOException{
		verarbeiteSpielzug(1,event);
		
	}
	@FXML 
	public void dritteReiheAusgewaehlt(ActionEvent event) throws IOException{
		verarbeiteSpielzug(2,event);
		
	}
	@FXML 
	public void vierteReiheAusgewaehlt(ActionEvent event) throws IOException{
		verarbeiteSpielzug(3,event);
		
	}
	@FXML 
	public void fuenfteReiheAusgewaehlt(ActionEvent event) throws IOException{
		verarbeiteSpielzug(4,event);
		
	}
	@FXML 
	public void sechsteReiheAusgewaehlt(ActionEvent event) throws IOException{
		verarbeiteSpielzug(5,event);
		
	}
	@FXML 
	public void siebteReiheAusgewaehlt(ActionEvent event) throws IOException{
		verarbeiteSpielzug(6, event);
	}
	
	
	private void verarbeiteSpielzug(int reihe,ActionEvent event) throws IOException {
		int tempErg = spielfeld1.setzeSpieler(reihe, aktSpieler);
		switch(tempErg) {
			case -2:System.out.println("Fehler");
					break;
			case -1:System.out.println("Reihe Voll");
					break;
			case 0 :faerbeButton(reihe);
					wechsleSpieler();
					break;
			case 1 :faerbeButton(reihe);
					System.out.println("gewonnen");
					displayGewonnenScreen(event);
					break;		
		}
		if(aktSpieler == 2) {
			verarbeiteComputerSpielzug();
		}
	}
	
	private void verarbeiteComputerSpielzug() throws IOException {
		int zufallsreihe = (int) (Math.random()*7);
		verarbeiteSpielzug(zufallsreihe, new ActionEvent());
	}
	
	
	private void displayGewonnenScreen(ActionEvent event) throws IOException {
		for(String s : buttonMap.keySet()) {
			Button temp_button = buttonMap.get(s);
			temp_button.setDisable(true);
		}
		gridpane.setOpacity(0.5);
		if(!gewonnenLabel.isVisible()) {
			gewonnenLabel.setText(spielerName[aktSpieler-1] + " hat gewonnen!");
			spielstand[aktSpieler-1]++;
			if(aktSpieler == 1) {
				spielerEinsAnzeige.setText(Integer.toString(spielstand[aktSpieler-1]));
			}else if(aktSpieler == 2) {
				spielerZweiAnzeige.setText(Integer.toString(spielstand[aktSpieler-1]));
			}
			neuesSpielButton.setVisible(true);
			//gridpane.setVisible(false);
			gewonnenLabel.setVisible(true);
			partieWeiterspielenButton.setVisible(true);
		}
	}
	
	public void partieWeiterspielen() {
		for(String s : buttonMap.keySet()) {
			Button temp_button = buttonMap.get(s);
			temp_button.setStyle("-fx-background-radius:80px;");
			temp_button.setDisable(false);
		}
		gridpane.setVisible(true);
		gridpane.setOpacity(1);
		neuesSpielButton.setVisible(false);
		gewonnenLabel.setVisible(false);
		partieWeiterspielenButton.setVisible(false);
		spielfeld1.spielfeldReset();
	}
	
	public void spielStarten() {
		if(!spielerEins.getText().equals("")) {
			spielerName[0] = spielerEins.getText();
		}else {
			spielerName[0] = "Spieler 1";
		}
		spielerName[1] = "Jarvis";
		
		spielstand[0] = 0;
		spielstand[1] = 0;
		
		spielerEinsAnzeigeLabel.setText(spielerName[0]);
		spielerZweiAnzeigeLabel.setText(spielerName[1]);
		spielerEinsAnzeigeLabel.setVisible(true);
		spielerEinsAnzeige.setVisible(true);
		spielerZweiAnzeigeLabel.setVisible(true);
		spielerZweiAnzeige.setVisible(true);
		
		spielerEins.setVisible(false);
		spielerZwei.setVisible(false);
		spielStartenButton.setVisible(false);
		spielerEinsLabel.setVisible(false);
		spielerZweiLabel.setVisible(false);
		gridpane.setVisible(true);
		
	}
	
	public void neuesSpiel(ActionEvent event) throws IOException {
		Parent tableviewparent = FXMLLoader.load(getClass().getResource("MainComputer.fxml"));
		Scene tableviewscene = new Scene(tableviewparent,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableviewscene);
		window.show();
	}
	
	public void zurueckHauptmenue(ActionEvent event) throws IOException {
		Parent tableviewparent = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
		Scene tableviewscene = new Scene(tableviewparent,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableviewscene);
		window.show();
	}
	private void wechsleSpieler() {
		if(aktSpieler == 1) {
			aktSpieler = 2;
		}else if(aktSpieler == 2) {
			aktSpieler = 1;
		}else {
			System.out.println("error");
		}
	}
	private void faerbeButton(int reihe) {
		int letzterStein = 0;
		for(int i = 0; i <= 5; i++) {
			if(spielfeld1.getSpielfeldAt(i, reihe) != 0) {
				letzterStein = i;
				break;
			}
			
		}
		String search = "ersterButton".concat(Integer.toString(letzterStein)+Integer.toString(reihe));		
		Button zug = buttonMap.get(search);
		if(aktSpieler == 1) {
			zug.setStyle("-fx-background-color:red;-fx-background-radius:80px;");
			zug.setDisable(true);
			
		}else if(aktSpieler == 2) {
			zug.setStyle("-fx-background-color:yellow;-fx-background-radius:80px;");
			zug.setDisable(true);
		}
	}
	
	
}
