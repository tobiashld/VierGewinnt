package application;

public class SpielzugAnalyse {
	private static int tempReihe;
	/*
	 * Gibt die Reihe zurück für den besten Spielzug
	 */
	public static int getMittlererSpielzug(int[][] currSpielfeld) {
		if(moeglicherGewinn(currSpielfeld)) {
			
		}else if(moeglicheVerteidigung(currSpielfeld)){
			
		}else{
			do{
				tempReihe = (int) (Math.random()*7);
			}while(SpielzugAnalyse.reiheVoll(currSpielfeld, tempReihe));
		}
		return tempReihe;
	}

	public static int getJarvis(int[][] currSpielfeld) {
		
		return 0;
	}
	
	
	private static boolean moeglicherGewinn(int[][] currSpielfeld) {
		boolean tempErg = false;
		
		return tempErg;
	}
	
	private static boolean moeglicheVerteidigung(int[][] currSpielfeld) {
		boolean tempErg = false;
		
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
		}
		return false;
	}
	
	
	private static boolean pruefeHorizontal(int[][] currSpielfeld, int spieler, int anzahlSteine) {
		int tempSteine = 0;
		int lehreReihe = -2;
		for(int z = 5; z >= 0; z--) {
			for(int i = 0; i < 7; i++) {
				if(currSpielfeld[z][i] == spieler) {
					tempSteine++;
				}else if(currSpielfeld[z][i] == 0) {
					if(z == 5 || currSpielfeld[z-1][i] != 0) {
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
		}
		return false;
	}
	
	
	private static boolean pruefeDiagonal(int[][] currSpielfeld, int spieler, int anzahlSteine) {
		
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
	
}
