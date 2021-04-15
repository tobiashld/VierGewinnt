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
	
	public void spielfeldReset() {
		for(int i = 0;i < 6; i++) {
			for(int z = 0;z < 7;z++) {
				spielfeld[i][z] = 0;
			}
		}
	}
	public int getSpielfeldAt(int y,int x) {
		return spielfeld[y][x];
	}
	
	public int setzeSpieler(int reihe,int spieler) {
		for(int i = 5; i >= 0; i--) {
			if( spielfeld[i][reihe] == 0) {
				spielfeld[i][reihe] = spieler;
				return pruefeObGewonnen(i, reihe, spieler);
			}else if(i == 0 && spielfeld[i][reihe] != 0) {
				return REIHE_VOLL;
			}
		}
		return FEHLER;
	}
	public static int pruefeObGewonnen(int y,int x, int spieler) {
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
	
	public static boolean pruefeVertikal(int y, int x, int spieler) {
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
	
	public static boolean pruefeHorizontal(int y, int x, int spieler) {
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
	
	public static boolean pruefeDiagonal(int y, int x, int spieler) {
		
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
}
