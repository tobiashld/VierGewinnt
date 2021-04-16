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

public class MainController {
	private static final int GEWONNEN = 1;
	private static final int NICHT_GEWONNEN = 0;
	private static final int REIHE_VOLL = -1;
	private static final int FEHLER = -2;
	
	Spielfeld vierGewinntFeld = new Spielfeld();
	HashMap<String,Button> buttonMap = new HashMap<>();
	int aktSpieler = 1;
	String[] spielerNamenArr = new String[2];
	int[] spielstandArr = new int[2];
	
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
	
	public Button spielStartenButton = new Button();
	public Button neuesSpielButton = new Button();
	public Button hauptmenueButton = new Button();
	public Button partieWeiterspielenButton = new Button();
	
	public GridPane gridpane = new GridPane();
	
	public TextField spielerEins = new TextField();
	public TextField spielerZwei = new TextField();
	
	public Label gewonnenLabel = new Label();
	public Label spielerEinsLabel = new Label();
	public Label spielerZweiLabel = new Label();
	public Label spielerEinsAnzeige = new Label();
	public Label spielerEinsAnzeigeLabel = new Label();
	public Label spielerZweiAnzeige = new Label();
	public Label spielerZweiAnzeigeLabel = new Label();

	
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
	
	/*
	 * Das Ergebnis eines Spielzugs wird verarbeitet und ausgewertet
	 * Anschließend werden die entsprechenden Methoden ausgeführt
	 */
	public void verarbeiteSpielzug(int reihe,ActionEvent event) throws IOException {
		int tempErg = vierGewinntFeld.setzeSpieler(reihe, aktSpieler);
		switch(tempErg) {
			case FEHLER:
				System.out.println("Fehler");
				fehlerVerarbeiten("Fehler!");
				break;
						
			case REIHE_VOLL:
				System.out.println("Reihe Voll");
				fehlerVerarbeiten("Reihe Voll!");
				break;
							
			case NICHT_GEWONNEN:
				faerbeButton(reihe);
				wechsleSpieler();
				break;
								
			case GEWONNEN:
				faerbeButton(reihe);
				System.out.println("gewonnen");
				displayGewonnenScreen(event);
				break;		
		}
	}
	
	/*
	 * Der im Parameter dieser Methode angegebene Fehler wird im Spielfeld angezeigt und bleibt dort für eine Sekunde
	 */
	protected void fehlerVerarbeiten(String fehler){
		FehlerAnzeigen fehleranzeige = new FehlerAnzeigen(gridpane,gewonnenLabel);
		gewonnenLabel.setText(fehler);
		fehleranzeige.start();
	}
	
	/*
	 * Alle Buttons werden Disabled und der Gewinner wird angezeigt
	 */
	private void displayGewonnenScreen(ActionEvent event) throws IOException {
		
		for(String s : buttonMap.keySet()) {
			Button temp_button = buttonMap.get(s);
			temp_button.setDisable(true);
		}
		spielstandArr[aktSpieler-1]++;
		
		if(aktSpieler == 1) {
			spielerEinsAnzeige.setText(Integer.toString(spielstandArr[aktSpieler-1]));
		}else if(aktSpieler == 2) {
			spielerZweiAnzeige.setText(Integer.toString(spielstandArr[aktSpieler-1]));
		}
		
		gewonnenScreenVerarbeitung(true, 0.5);
		gewonnenLabel.setText(spielerNamenArr[aktSpieler-1] + " hat gewonnen!");
		
		
	}
	
	
	
	/*
	 * Alle Buttons werden wieder Enabled und der Gewonnenscreen verschwindet
	 * Anschließend wird das Spielfeld resettet
	 */
	public void partieWeiterspielen() {
		
		for(String s : buttonMap.keySet()) {
			Button temp_button = buttonMap.get(s);
			temp_button.setStyle("-fx-background-radius:80px;");
			temp_button.setDisable(false);
		}
		
		gewonnenScreenVerarbeitung(false, 1);
		vierGewinntFeld.spielfeldReset();
	}
	
	/*
	 * Die Navigationsbuttons und das Gewonnenlabel werden aus- oder eingeblendet
	 * Die Deckkraft des Gridpanes wird dementsprechend angepasst
	 */
	private void gewonnenScreenVerarbeitung(boolean status, double gridOpacity) {
		neuesSpielButton.setVisible(status);
		gewonnenLabel.setVisible(status);
		partieWeiterspielenButton.setVisible(status);
		gridpane.setOpacity(gridOpacity);
	}
	
	/*
	 * Diese Methode wird ausgeführt, wenn der spielStartenButton ausgelöst wird
	 * Die Namen der Spieler werden gesetzt und spielStartenVerarbeiten wird ausgeführt
	 */
	public void spielStarten() {
		if(!spielerEins.getText().equals("") && !spielerZwei.getText().equals("")) {
			spielerNamenArr[0] = spielerEins.getText();
			spielerNamenArr[1] = spielerZwei.getText();
		}else {
			spielerNamenArr[0] = "Spieler 1";
			spielerNamenArr[1] = "Spieler 2";
		}
		spielStartenVerarbeiten();
	}
	
	/*
	 * Der Spielstand wird zurückgesetzt und die Oberfläche des Spiels wird für das Spiel angepasst
	 */
	protected void spielStartenVerarbeiten() {
		spielstandArr[0] = 0;
		spielstandArr[1] = 0;
		
		spielerEinsAnzeigeLabel.setText(spielerNamenArr[0]);
		spielerZweiAnzeigeLabel.setText(spielerNamenArr[1]);
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
	
	/*
	 * Szene wird zur Main.fxml gewechselt und somit eine neue Instanz dieser Klasse erzeugt
	 */
	public void neuesSpiel(ActionEvent event) throws IOException {
		szeneWechseln("Main.fxml",event);
	}
	
	/*
	 * Szene wird zur hauptmenue.fxml gewechselt und somit eine neue Instanz des hauptmenueControllers erzeugt
	 */
	public void zurueckHauptmenue(ActionEvent event) throws IOException {
		szeneWechseln("hauptmenue.fxml",event);
	}
	
	/*
	 * Szene wird zu der im Parameter angegebenen Szene gewechselt
	 */
	protected void szeneWechseln(String fxml, ActionEvent event) throws IOException {
		Parent newParent = FXMLLoader.load(getClass().getResource(fxml));
		Scene newScene = new Scene(newParent,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(newScene);
		window.show();
	}
	
	/*
	 * Aktueller Spieler wird gewechselt
	 */
	private void wechsleSpieler() {
		if(aktSpieler == 1) {
			aktSpieler = 2;
		}else if(aktSpieler == 2) {
			aktSpieler = 1;
		}
	}
	
	/*
	 * Der unterste freie Button der gewählten Reihe wird entsprechend des aktuellen Spielers gefärbt
	 */
	private void faerbeButton(int reihe) {
		int letzterStein = 0;
		for(int i = 0; i <= 5; i++) {
			if(vierGewinntFeld.getSpielfeldAt(i, reihe) != 0) {
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
