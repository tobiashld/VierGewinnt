package application;

public class SpielzugAnalyse {
	private static int tempReihe;
	
	
	/*
	 * Gibt die Reihe zurück für den besten Spielzug des Schwierigkeitsgrads Mittel
	 */
	public static int getMittlererSpielzug(Spielfeld currSpielfeld) {
		if(moeglicheAktion(currSpielfeld,Feldinhalt.SPIELER2,3) ||
		   moeglicheAktion(currSpielfeld,Feldinhalt.SPIELER1,3)) {
			
			if(reiheVoll(currSpielfeld,tempReihe)) {
				do{
					tempReihe = (int) (Math.random()*7);
				}while(SpielzugAnalyse.reiheVoll(currSpielfeld, tempReihe));
			}
			return tempReihe;
		}else{
			do{
				tempReihe = (int) (Math.random()*7);
			}while(SpielzugAnalyse.reiheVoll(currSpielfeld, tempReihe));
		}
		return tempReihe;
	}
	
	
	/*
	 * Gibt die Reihe zurück für den besten Spielzug des Schwierigkeitsgrads Jarvis (Schwer)
	 */
	public static int getJarvis(Spielfeld currSpielfeld) {
		if(moeglicheAktion(currSpielfeld,Feldinhalt.SPIELER2,3) ||
		   moeglicheAktion(currSpielfeld,Feldinhalt.SPIELER1,3) ||
		   moeglicheAktion(currSpielfeld,Feldinhalt.SPIELER2,2) ||
		   moeglicheAktion(currSpielfeld,Feldinhalt.SPIELER1,2) ||
		   moeglicheAktion(currSpielfeld,Feldinhalt.SPIELER2,1) ||
		   moeglicheAktion(currSpielfeld,Feldinhalt.SPIELER1,1) 
				) {
			if(reiheVoll(currSpielfeld,tempReihe)) {
				do{
					tempReihe = (int) (Math.random()*7);
				}while(SpielzugAnalyse.reiheVoll(currSpielfeld, tempReihe));
			}
			return tempReihe;
			
		}else {
			return 3;
		}
		
	}
	
	
	private static boolean moeglicheAktion(Spielfeld currSpielfeld,Feldinhalt spieler, int anzahlSteine) {
		boolean tempErg = false;
		if(pruefeVertikal(currSpielfeld,spieler,anzahlSteine) ||
		   pruefeHorizontal(currSpielfeld,spieler,anzahlSteine) ||
		   pruefeDiagonal(currSpielfeld,spieler,anzahlSteine)) {
			tempErg = true;
		}
		
		return tempErg;
	}
	
	
	private static boolean pruefeVertikal(Spielfeld currSpielfeld, Feldinhalt spieler, int anzahlSteine) {
		int tempSteine = 0;
		for(int i = 0; i < 7; i++) {
			for(int z = 0; z < 6; z++) {
				if(vergleichFeldMitParameter(currSpielfeld,i,z,spieler)) {
					tempSteine++;
					if(pruefeObGewollteAnzahlErreicht(tempSteine, anzahlSteine)) {
						tempReihe = i;
						return true;
					}
				}else if(vergleichFeldMitParameter(currSpielfeld,i,z,gegenspieler(spieler)))  {
					break;
				}
			}
			tempSteine = 0;
		}
		return false;
	}
	
	
	private static boolean pruefeHorizontal(Spielfeld currSpielfeld, Feldinhalt spieler, int anzahlSteine) {
		int tempSteine = 0;
		int lehreReihe = -2;
		for(int z = 5; z >= 0; z--) {
			for(int i = 0; i < 7; i++) {
				
				if(vergleichFeldMitParameter(currSpielfeld,i,z,spieler)) {
					tempSteine++;
				}else if(vergleichFeldMitParameter(currSpielfeld,i,z,Feldinhalt.FELD_SETZBAR)) {
					if(pruefeObGewollteAnzahlErreicht(tempSteine, anzahlSteine)) {
						tempReihe = i;
						return true;
					}else if(lehreReihe + 1 == i){
						lehreReihe = i;
						tempSteine = 0;
					}else {
						lehreReihe = i;
					}
				}else if(vergleichFeldMitParameter(currSpielfeld,i,z,gegenspieler(spieler))) {
					if(pruefeObGewollteAnzahlErreicht(tempSteine, anzahlSteine) && i - tempSteine - 1 == lehreReihe) {
						tempReihe = lehreReihe;
						return true;
					}else if(pruefeObLeeresFeldZwischenErfuelltenSteinen(tempSteine, anzahlSteine, lehreReihe)){
						lehreReihe = -2;
						tempSteine = 0;
					}else {
						tempSteine = 0;
					}
				}else if(vergleichFeldMitParameter(currSpielfeld,i,z,Feldinhalt.FREI)) {
					lehreReihe = -2;
					tempSteine = 0;
				}
				if(pruefeObLeeresFeldZwischenErfuelltenSteinen(tempSteine,anzahlSteine,lehreReihe)) {
					tempReihe = lehreReihe;
					return true;
				}
			}
			
			lehreReihe = -2;
			tempSteine = 0;
		}
		return false;
	}
	
	private static boolean pruefeObLeeresFeldZwischenErfuelltenSteinen(int tempSteine, int anzahlSteine, int lehreReihe) {
		if(pruefeObGewollteAnzahlErreicht(tempSteine, anzahlSteine) && lehreReihe != -2) {
			return true;
		}
		return false;
	}
	/*
	 * Alle möglichen Gewinndiagonalen werden geprüft auf einen aktuellen Gewinner
	 * 
	 */
	private static boolean pruefeDiagonal(Spielfeld currSpielfeld, Feldinhalt spieler, int anzahlSteine) {
		for(int i = 0; i < 3; i++) {
			if(pruefeDiagonaleLogik(currSpielfeld,spieler,anzahlSteine,"rechts",i,0) || 
			   pruefeDiagonaleLogik(currSpielfeld,spieler,anzahlSteine,"rechts",0,i) && i != 0 ||
			   pruefeDiagonaleLogik(currSpielfeld,spieler,anzahlSteine,"links",i,6) && i != 0) {
				return true;
			}
		}
		if(pruefeDiagonaleLogik(currSpielfeld,spieler,anzahlSteine,"rechts",0,3)) {
			return true;
		}
				
		for(int i = 6; i > 2; i--) {
			if(pruefeDiagonaleLogik(currSpielfeld,spieler,anzahlSteine,"links",0,i)) {
				return true;
			}
		}		
		
		return false;
	}
	
	private static boolean pruefeDiagonaleLogik(Spielfeld currSpielfeld, Feldinhalt spieler, int anzahlSteine, String richtung,int y, int x) {
		int tempSteine = 0;
		int lehreReihe = -2;
		int richtungX = 0;
		switch(richtung) {
			case "rechts":
				richtungX = 1;
				break;
			case "links":
				richtungX = -1;
				break;
		}
		for(int i = y; i < 6; i++) {
			int newX = x + (i - y) * richtungX;
			try {
				if(pruefeObLeeresFeldZwischenErfuelltenSteinen(tempSteine, anzahlSteine, lehreReihe)) {
					tempReihe = lehreReihe;
					return true;
				}
				
				if(vergleichFeldMitParameter(currSpielfeld,newX,i,spieler)) {
					tempSteine++;
				}else if(vergleichFeldMitParameter(currSpielfeld,newX,i,gegenspieler(spieler))) {
					if(pruefeObGewollteAnzahlErreicht(tempSteine, anzahlSteine) && 
						newX - ((tempSteine + 1) * richtungX) == lehreReihe && 
						lehreReihe != -2) {
						tempReihe = lehreReihe;
						return true;
					}else {
						tempSteine = 0;
					}
				}else if(vergleichFeldMitParameter(currSpielfeld,newX,i,Feldinhalt.FELD_SETZBAR)) {
					if(lehreReihe - richtungX == (newX)) {
						lehreReihe = newX;
						tempSteine = 0;
					}else if(pruefeObLeeresFeldZwischenErfuelltenSteinen(tempSteine, anzahlSteine, lehreReihe)) {
						tempReihe = lehreReihe;
						return true;
					}else {
						lehreReihe = newX;
					}
				}
				if(pruefeObLeeresFeldZwischenErfuelltenSteinen(tempSteine, anzahlSteine, lehreReihe)) {
					tempReihe = lehreReihe;
					return true;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
	
		}
		
		return false;
	}
	
	private static boolean pruefeObGewollteAnzahlErreicht(int tempSteine, int anzahlSteine) {
		return (tempSteine >= anzahlSteine)?true:false;
	}
	
	private static boolean vergleichFeldMitParameter(Spielfeld currSpielfeld,int x, int y, Feldinhalt parameter) {
		return currSpielfeld.getFeldAt(x, y).getFeldinhalt().equals(parameter);
	}
	
	private static Feldinhalt gegenspieler(Feldinhalt spieler) {
		switch(spieler) {
			case SPIELER1:return Feldinhalt.SPIELER2;
			case SPIELER2:return Feldinhalt.SPIELER1;
		}
		return Feldinhalt.ERROR;
	}
	
	public static boolean reiheVoll(Spielfeld currSpielfeld,int reihe) {
		if(currSpielfeld.getFeldAt(reihe, 0).getFeldinhalt().equals(Feldinhalt.SPIELER1) ||
		   currSpielfeld.getFeldAt(reihe, 0).getFeldinhalt().equals(Feldinhalt.SPIELER2)	) {
			return true;
		}else {
			return false;
		}
		
	}
	
	

	
	
}
