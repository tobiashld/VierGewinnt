package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class FehlerAnzeigen extends Thread{
	@FXML
	GridPane gridpane;
	Label fehlerlabel;
	
	public FehlerAnzeigen(GridPane gridpane, Label fehlerlabel) {
		this.gridpane = gridpane;
		this.fehlerlabel = fehlerlabel;
	}
	
	@Override
	public void run() {
		gridpane.setOpacity(0.5);
		fehlerlabel.setVisible(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gridpane.setOpacity(1);
		fehlerlabel.setVisible(false);
	}
}
