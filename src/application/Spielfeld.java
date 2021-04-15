package application;

public class Spielfeld {
	
	private static final int GEWONNEN = 1;
	private static final int NICHT_GEWONNEN = 0;
	private static final int FEHLER = -2;
	private static final int REIHE_VOLL = -1;
	private static int[][] spielfeld = new int[6][7];
	
	public Spielfeld() {
		spielfeldReset();
	}
	
	/*
	 * Das aktuelle Spielfeld wird an jeder Stelle auf 0 gesetzt
	 */
	public void spielfeldReset() {
		for(int i = 0;i < 6; i++) {
			for(int z = 0;z < 7;z++) {
				spielfeld[i][z] = 0;
			}
		}
	}
	
	/*
	 * Diese Methode gibt den aktuellen Stand des Steins (x|y) zurück
	 * 0 = unbelegt;
	 * 1 = Spieler1;
	 * 2 = Spieler2;
	 */
	public int getSpielfeldAt(int y,int x) {
		return spielfeld[y][x];
	}
	
	/*
	 * Diese Methode führt einen Spielzug aus und gibt einen Wert zurück
	 * -2 = Fehler;
	 * -1 = Reihe Voll;
	 *  0 = Nicht Gewonnen;
	 *  1 = Gewonnen;
	 */
	public int setzeSpieler(int reihe,int spieler) {
		try {
			for(int i = 5; i >= 0; i--) {
				if( spielfeld[i][reihe] == 0 &&
					spieler > 0 && 
					spieler < 3 ) {
					
					spielfeld[i][reihe] = spieler;
					return pruefeObGewonnen(i, reihe, spieler);
					
				}else if(i == 0 && spielfeld[i][reihe] != 0) {
					return REIHE_VOLL;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return FEHLER;
		}
		return FEHLER;
	}
	
	/*
	 * Diese Methode prüft, ob der durchgeführte Spielzug zum Sieg geführt hat und gibt anschließend einen Wert zurück
	 * 0 = Nicht Gewonnen;
	 * 1 = Gewonnen;
	 */
	private static int pruefeObGewonnen(int y,int x, int spieler) {
		if(pruefeVertikal(y,x, spieler)) {
			return GEWONNEN;
		}
		if(pruefeHorizontal(y,x, spieler)) {
			return GEWONNEN;
		}
		if(pruefeDiagonal(y,x, spieler)) {
			return GEWONNEN;
		}
		return NICHT_GEWONNEN;
	}
	
	/*
	 * Diese Methode gibt true zurück, wenn in der Vertikalen der angegebene Spieler 4 aufeinander folgende Steine platziert hat.
	 * true  = 4 Steine einer Farbe in einer Reihe;
	 * false = nicht;
	 */
	private static boolean pruefeVertikal(int y, int x, int spieler) {
		int steineEinerFarbe = 0;
		for(int i = 0; i <= 5; i++) {
			if(spielfeld[i][x] == spieler) {
				steineEinerFarbe++;
				if(steineEinerFarbe >= 4) {
					return true;
				}
			}else{
				steineEinerFarbe = 0;
			}
		}
		return false;
		
	}
	
	/*
	 * Diese Methode gibt true zurück, wenn in der Horizontalen der angegebene Spieler 4 aufeinander folgende Steine platziert hat.
	 * true  = min. 4 Steine einer Farbe in einer Reihe;
	 * false = nicht;
	 */
	private static boolean pruefeHorizontal(int y, int x, int spieler) {
		int steineEinerFarbe = 0;
		for(int i = 0; i <= 6; i++) {
			if(spielfeld[y][i] == spieler) {
				steineEinerFarbe++;
				if(steineEinerFarbe >= 4) {
					return true;
				}
			}else{
				steineEinerFarbe = 0;
			}
		}
		return false;
		
	}
	
	/*
	 * Diese Methode gibt true zurück, wenn in einer Diagonalen der angegebene Spieler 4 aufeinander folgende Steine platziert hat.
	 * true  = min. 4 Steine einer Farbe in einer Reihe;
	 * false = nicht;
	 */
	private static boolean pruefeDiagonal(int y, int x, int spieler) {
		
		int steineEinerFarbe = 1;
		int tempX = x,tempY = y;
		/*
		 * Es wird erstmal richtung links oben gezaehlt, wieviel Steine des Spielers vorhanden sind.
		 */
		while(steineEinerFarbe < 5 && tempX > 0 && tempY > 0) {
			tempX--;
			tempY--;
			if(spielfeld[tempY][tempX] == spieler) {
				steineEinerFarbe++;
			}else{
				break;
			}
		}
		/*
		 * Es werden die auf den gesetzten Stein folgenden Steine gezählt.
		 */
		tempX = x;
		tempY = y;
		while(steineEinerFarbe < 5 && tempX < 6 && tempY < 5) {
			tempX++;
			tempY++;
			if(spielfeld[tempY][tempX] == spieler) {
				steineEinerFarbe++;
			}else{
				break;
			}
		}
		if(steineEinerFarbe >= 4) {
			return true;
		}
		
		
		/*
		 * Das gleiche Prozedere wird für die unten links nach oben rechts Diagonale durchgeführt.
		 * Hier wird erst nach rechts oben gezaehlt.
		 */
		
		steineEinerFarbe = 1;
		tempX = x;
		tempY = y;
		while(steineEinerFarbe < 5 && tempX < 6 && tempY > 0) {
			tempX++;
			tempY--;
			if(spielfeld[tempY][tempX] == spieler) {
				steineEinerFarbe++;
			}else{
				break;
			}
		}
		/*
		 * Hier wird nach links unten gezaehlt.
		 */
		tempX = x;
		tempY = y;
		while(steineEinerFarbe < 5 && tempX > 0 && tempY < 5) {
			tempX--;
			tempY++;
			if(spielfeld[tempY][tempX] == spieler) {
				steineEinerFarbe++;
			}else{
				break;
			}
		}
		if(steineEinerFarbe >= 4) {
			return true;
		}
		
		return false;
		
	}
	
	public int[][] getSpielfeld(){
		return spielfeld;
	}
}
