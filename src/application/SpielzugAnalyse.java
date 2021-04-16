package application;

public class SpielzugAnalyse {
	private static int tempReihe;
	/*
	 * Gibt die Reihe zurück für den besten Spielzug
	 */
	public static int getMittlererSpielzug(int[][] currSpielfeld) {
		if(moeglicheAktion(currSpielfeld,2,3) ||
		   moeglicheAktion(currSpielfeld,1,3)) {
			
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

	public static int getJarvis(int[][] currSpielfeld) {
		if(moeglicheAktion(currSpielfeld,2,3) ||
		   moeglicheAktion(currSpielfeld,1,3) ||
		   moeglicheAktion(currSpielfeld,2,2) ||
		   moeglicheAktion(currSpielfeld,1,2) ||
		   moeglicheAktion(currSpielfeld,2,1) ||
		   moeglicheAktion(currSpielfeld,1,1) 
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
	
	
	private static boolean moeglicheAktion(int[][] currSpielfeld,int spieler, int anzahlSteine) {
		boolean tempErg = false;
		if(pruefeVertikal(currSpielfeld,spieler,anzahlSteine) ||
		   pruefeHorizontal(currSpielfeld,spieler,anzahlSteine) ||
		   pruefeDiagonal(currSpielfeld,spieler,anzahlSteine)) {
			tempErg = true;
		}
			
			
		
		return tempErg;
	}
	
	
	private static boolean pruefeVertikal(int[][] currSpielfeld, int spieler, int anzahlSteine) {
		int tempSteine = 0;
		for(int i = 0; i < 7; i++) {
			for(int z = 0; z < 6; z++) {
				if(currSpielfeld[z][i] == spieler) {
					tempSteine++;
					if(tempSteine >= anzahlSteine) {
						tempReihe = i;
						return true;
					}
				}else if(currSpielfeld[z][i] == gegenspieler(spieler)) {
					break;
				}
			}
			tempSteine = 0;
		}
		return false;
	}
	
	
	private static boolean pruefeHorizontal(int[][] currSpielfeld, int spieler, int anzahlSteine) {
		int tempSteine = 0;
		int lehreReihe = -2;
		for(int z = 5; z >= 0; z--) {
			for(int i = 0; i < 7; i++) {
				if(tempSteine >= anzahlSteine && lehreReihe != -2) {
					tempReihe = lehreReihe;
					return true;
				}
				if(currSpielfeld[z][i] == spieler) {
					tempSteine++;
				}else if(currSpielfeld[z][i] == 0) {
					if(z == 5 || currSpielfeld[z + 1][i] != 0) {
						if(tempSteine >= anzahlSteine) {
							tempReihe = i;
							return true;
						}else if(lehreReihe + 1 == i){
							lehreReihe = i;
							tempSteine = 0;
						}else {
							lehreReihe = i;
						}
					}
				}else if(currSpielfeld[z][i] == gegenspieler(spieler)) {
					if(tempSteine >= anzahlSteine && i - tempSteine - 1 == lehreReihe) {
						tempReihe = lehreReihe;
						return true;
					}else {
					tempSteine = 0;
					}
				}
			}
			lehreReihe = -2;
			tempSteine = 0;
		}
		return false;
	}
	
	
	private static boolean pruefeDiagonal(int[][] currSpielfeld, int spieler, int anzahlSteine) {
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
	
	private static boolean pruefeDiagonaleLogik(int[][] currSpielfeld, int spieler, int anzahlSteine, String richtung,int y, int x) {
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
			try {
				if(tempSteine >= anzahlSteine && lehreReihe != -2) {
					tempReihe = lehreReihe;
					return true;
				}
				int newX = x + (i - y) * richtungX;
				if(currSpielfeld[i][newX] == spieler) {
					tempSteine++;
				}else if(currSpielfeld[i][newX] == gegenspieler(spieler)) {
					if(tempSteine >= anzahlSteine && 
						newX - ((tempSteine + 1) * richtungX) == lehreReihe && 
						lehreReihe != -2) {
						tempReihe = lehreReihe;
						return true;
					}else {
						tempSteine = 0;
					}
				}else if(currSpielfeld[i][newX] == 0) {
					if(i == 5 || currSpielfeld[i + 1][newX] != 0) {
						if(lehreReihe - richtungX == (newX)) {
							lehreReihe = newX;
							tempSteine = 0;
						}else if(tempSteine >= anzahlSteine && lehreReihe != -2) {
							tempReihe = lehreReihe;
							return true;
						}else {
							lehreReihe = newX;
						}
					}
				}else{
					break;
				}
				if(tempSteine >= anzahlSteine && lehreReihe != -2) {
					tempReihe = lehreReihe;
					return true;
				}
			}catch(ArrayIndexOutOfBoundsException event) {
				break;
			}
		}
		
		return false;
	}
	
	
	private static int gegenspieler(int spieler) {
		if(spieler == 1) {
			return 2;
		}else if(spieler == 2) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static boolean reiheVoll(int[][] currSpielfeld,int reihe) {
		if(currSpielfeld[0][reihe] != 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public static class Spielfeld {
		
		Feld[][] spielFeld = new Feld[6][7];
	}
	
	public static class Feld {
		int indexX;
		int indexY;
		
		Feldinhalt feldinhalt;
	}
	
	public static enum Feldinhalt {
		ROT,
		GELB,
		FREI,
		NICHT_SETZBAR
	}
}
