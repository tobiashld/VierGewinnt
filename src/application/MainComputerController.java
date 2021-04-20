package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class MainComputerController extends MainController{
	
	private int difficulty;
	private SpielzugAnalyse spielzugAnalyse = new SpielzugAnalyse();
	
	@FXML
	public ChoiceBox<String> computerSchwierigkeit = new ChoiceBox<>();
	
	
	/*
	 * Diese Methode greift auf die Superklasse zu um den Spielzug des Spielers zu verarbeiten.
	 * Anschließend wird der Spielzug des Computers durchgeführt, wenn er der aktuelle Spieler ist
	 */
	@Override
	public void verarbeiteSpielzug(int reihe,ActionEvent event) throws IOException {
		super.verarbeiteSpielzug(reihe, event);
		if(aktSpieler.equals(Feldinhalt.SPIELER2)) {
			verarbeiteComputerSpielzug();
		}
	}
	@Override
	public void initialize() {
		super.initialize();
		computerSchwierigkeit.getItems().add("Einfach");
		computerSchwierigkeit.getItems().add("Mittel");
		computerSchwierigkeit.getItems().add("Jarvis");
		
		
	}
	
	
	/*
	 * Diese Methode ermittelt eine zufällige Spalte, in die der Stein des Computers gesetzt wird.
	 */
	private void verarbeiteComputerSpielzug() throws IOException {
		switch(difficulty) {
			case 0:
				verarbeiteSpielzug(einfacheSpielzugauswahl(),new ActionEvent());
				break;
			case 1: 
				verarbeiteSpielzug(mittlereSpielzugauswahl(),new ActionEvent());
				break;
			case 2:
				verarbeiteSpielzug(jarvis(), new ActionEvent());
				break;
		}
	}
	
	/*
	 * 
	 */
	private int einfacheSpielzugauswahl() {
		int tempReihe;
		do {
			tempReihe = (int) (Math.random()*7);
		}while(super.vierGewinntFeld.reiheVoll(tempReihe));
		return tempReihe;
	}
	
	private int mittlereSpielzugauswahl() {
		return spielzugAnalyse.getMittlererSpielzug(super.vierGewinntFeld);
	}
	
	private int jarvis() {
		return spielzugAnalyse.getJarvis(super.vierGewinntFeld);
	}
	
	/*
	 * Diese Methode startet das Spiel und setzt den Namen des Spielers und des Computers fest
	 * Die spielStartenVerarbeiten-Methode wird in der Superklasse aufgerufen
	 */
	@Override
	public void spielStarten() {
		if(!spielerEins.getText().equals("")) {
			spielerNamenArr[0] = spielerEins.getText();
		}else {
			spielerNamenArr[0] = "Spieler 1";
		}
		Object gewaehlteSchwierigkeit = computerSchwierigkeit.getValue();
		if (gewaehlteSchwierigkeit == null) {
			gewaehlteSchwierigkeit = "Einfach";
		}
		spielerNamenArr[1] = gewaehlteSchwierigkeit.toString();
		switch(gewaehlteSchwierigkeit.toString()) {
			case "Einfach":
				difficulty = 0;
				break;
			case "Mittel":
				difficulty = 1;
				break;
			case "Jarvis":
				difficulty = 2;
				break;
			default:
				difficulty = 0;
				super.fehlerVerarbeiten("Schwierigkeit wurde auf Einfach gestellt!");
				break;
		}
		computerSchwierigkeit.setVisible(false);
		super.spielStartenVerarbeiten();
		
	}
	
	/*
	 * Eine neue Szene wird anhand der MainComputer.fxml geladen
	 */
	@Override
	public void neuesSpiel(ActionEvent event) throws IOException {
		super.szeneWechseln("MainComputer.fxml", event);
	}
	
}
