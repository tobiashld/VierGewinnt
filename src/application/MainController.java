package application;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
	Spielfeld spielfeld1 = new Spielfeld();
	HashMap<String,Button> buttonMap = new HashMap<>();
	int aktSpieler = 1;
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
	
	public MainController() {
//		System.out.println(ersterButton00.getId());
		buttonMap.put(ersterButton00.getId(),ersterButton00);
//		buttonMap.put(ersterButton01,ersterButton01.getId().toString());
//		buttonMap.put(ersterButton02,ersterButton02.getId().toString());
//		buttonMap.put(ersterButton03,ersterButton03.getId().toString());
//		buttonMap.put(ersterButton04,ersterButton04.getId().toString());
//		buttonMap.put(ersterButton05,ersterButton05.getId().toString());
//		buttonMap.put(ersterButton06,ersterButton06.getId().toString());
//		buttonMap.put(ersterButton10,ersterButton10.getId().toString());
//		buttonMap.put(ersterButton11,ersterButton11.getId().toString());
//		buttonMap.put(ersterButton12,ersterButton12.getId().toString());
//		buttonMap.put(ersterButton13,ersterButton13.getId().toString());
//		buttonMap.put(ersterButton14,ersterButton14.getId().toString());
//		buttonMap.put(ersterButton15,ersterButton15.getId().toString());
//		buttonMap.put(ersterButton16,ersterButton16.getId().toString());
//		buttonMap.put(ersterButton20,ersterButton20.getId().toString());
//		buttonMap.put(ersterButton21,ersterButton21.getId().toString());
//		buttonMap.put(ersterButton22,ersterButton22.getId().toString());
//		buttonMap.put(ersterButton23,ersterButton23.getId().toString());
//		buttonMap.put(ersterButton24,ersterButton24.getId().toString());
//		buttonMap.put(ersterButton25,ersterButton25.getId().toString());
//		buttonMap.put(ersterButton26,ersterButton26.getId().toString());
//		buttonMap.put(ersterButton30,ersterButton30.getId().toString());
//		buttonMap.put(ersterButton31,ersterButton31.getId().toString());
//		buttonMap.put(ersterButton32,ersterButton32.getId().toString());
//		buttonMap.put(ersterButton33,ersterButton33.getId().toString());
//		buttonMap.put(ersterButton34,ersterButton34.getId().toString());
//		buttonMap.put(ersterButton35,ersterButton35.getId().toString());
//		buttonMap.put(ersterButton36,ersterButton36.getId().toString());
//		buttonMap.put(ersterButton40,ersterButton40.getId().toString());
//		buttonMap.put(ersterButton41,ersterButton41.getId().toString());
//		buttonMap.put(ersterButton42,ersterButton42.getId().toString());
//		buttonMap.put(ersterButton43,ersterButton43.getId().toString());
//		buttonMap.put(ersterButton44,ersterButton44.getId().toString());
//		buttonMap.put(ersterButton45,ersterButton45.getId().toString());
//		buttonMap.put(ersterButton46,ersterButton46.getId().toString());
		buttonMap.put(ersterButton50.getId(),ersterButton50);
//		buttonMap.put(ersterButton51,ersterButton51.getId().toString());
//		buttonMap.put(ersterButton52,ersterButton52.getId().toString());
//		buttonMap.put(ersterButton53,ersterButton53.getId().toString());
//		buttonMap.put(ersterButton54,ersterButton54.getId().toString());
//		buttonMap.put(ersterButton55,ersterButton55.getId().toString());
//		buttonMap.put(ersterButton56,ersterButton56.getId().toString());
//		
	
	}
	
	
	@FXML 
	public void ersteReiheAusgewaehlt(ActionEvent event) throws IOException{
		int tempErg = spielfeld1.setzeSpieler(0, aktSpieler);
		switch(tempErg) {
			case -2:System.out.println("Fehler");
					break;
			case -1:System.out.println("Reihe Voll");
					break;
			case 0 :faerbeButton(0);
					wechsleSpieler();
					
		}
	}
	@FXML 
	public void zweiteReiheAusgewaehlt(ActionEvent event) throws IOException{
		
		
	}
	@FXML 
	public void dritteReiheAusgewaehlt(ActionEvent event) throws IOException{
		
		
	}
	@FXML 
	public void vierteReiheAusgewaehlt(ActionEvent event) throws IOException{
		
		
	}
	@FXML 
	public void fuenfteReiheAusgewaehlt(ActionEvent event) throws IOException{
		
		
	}
	@FXML 
	public void sechsteReiheAusgewaehlt(ActionEvent event) throws IOException{
		
		
	}
	@FXML 
	public void siebteReiheAusgewaehlt(ActionEvent event) throws IOException{
		
		
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
		for(int i = 5; i >= 0; i--) {
			if(spielfeld1.getSpielfeldAt(i, reihe) != 0) {
				letzterStein = i;
				break;
			}
			
		}
		System.out.println(ersterButton50.getId().toString());
		//System.out.println(buttonArray[5][0].getStyle().toString());
		buttonMap.get("ersterButton"+letzterStein+reihe).setStyle("-fx-background-color:red");
	}
	
}
