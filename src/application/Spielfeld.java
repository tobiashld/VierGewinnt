package application;



public class Spielfeld {
	
	private static final int FELD_VOLL = 2;
	private static final int GEWONNEN = 1;
	private static final int NICHT_GEWONNEN = 0;
	private static final int FEHLER = -2;
	private static final int REIHE_VOLL = -1;
	private Feld[][] spielfeld = new Feld[6][7];
	
	public Spielfeld() {
		spielfeldReset();
	}
	public void setOldSpielfeld(Spielfeld currSpielfeld) {
		for(int i = 0;i < 6; i++) {
			for(int z = 0;z < 7;z++) {
				spielfeld[i][z] = new Feld(z,i,currSpielfeld.getFeldAt(z, i).getFeldinhalt());
			}
		}
	}
	
	
	
	public void spielfeldResetLetzterSteinReiheAt(int reihe) {
		for(int i = 0; i < 6; i++) {
			if(spielfeld[i][reihe].getFeldinhalt().equals(Feldinhalt.SPIELER1) ||
			   spielfeld[i][reihe].getFeldinhalt().equals(Feldinhalt.SPIELER2)) {
				spielfeld[i][reihe].setFeldinhalt(Feldinhalt.FELD_SETZBAR);
				break;
			}
		}
	}
	
	/*
	 * Das aktuelle Spielfeld wird an jeder Stelle auf 0 gesetzt
	 */
	public void spielfeldReset() {
		for(int i = 0;i < 5; i++) {
			for(int z = 0;z < 7;z++) {
				spielfeld[i][z] = new Feld(z,i,Feldinhalt.FREI);
			}
		}
		for(int i = 0;i < 7;i++) {
			spielfeld[5][i] = new Feld(i,5,Feldinhalt.FELD_SETZBAR);
		}
	}
	
	/*
	 * Diese Methode gibt den aktuellen Stand des Steins (x|y) zurück
	 * 0 = unbelegt;
	 * 1 = Spieler1;
	 * 2 = Spieler2;
	 */
	public Feld getSpielfeldAt(int y,int x) {
		return spielfeld[y][x];
	}
	
	
	private boolean feldVoll() {
		int zaehler = 0;
		for(int i = 0; i < 7; i++) {
			if(reiheVoll(i)) {
				zaehler++;
			}
		}
		return (zaehler >= 7)?true:false;
	}
	
	
	/*
	 * Diese Methode führt einen Spielzug aus und gibt einen Wert zurück
	 * -2 = Fehler;
	 * -1 = Reihe Voll;
	 *  0 = Nicht Gewonnen;
	 *  1 = Gewonnen;
	 */
	public int setzeSpieler(int reihe,Feldinhalt spieler) {
		try {
			for(int i = 5; i >= 0; i--) {
				if( spielfeld[i][reihe].feldinhalt.equals(Feldinhalt.FELD_SETZBAR) &&
					(spieler.equals(Feldinhalt.SPIELER1) ||
					spieler.equals(Feldinhalt.SPIELER2))) {
					
					spielfeld[i][reihe].setFeldinhalt(spieler);
					if(i != 0) {
						spielfeld[i-1][reihe].setFeldinhalt(Feldinhalt.FELD_SETZBAR);
					}
					return pruefeObGewonnen(i, reihe, spieler);
					
				}else if(i == 0) {
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
	private int pruefeObGewonnen(int y,int x, Feldinhalt spieler) {
		if(pruefeVertikal(y,x, spieler)) {
			return GEWONNEN;
		}
		if(pruefeHorizontal(y,x, spieler)) {
			return GEWONNEN;
		}
		if(pruefeDiagonal(y,x, spieler)) {
			return GEWONNEN;
		}
		if(feldVoll()) {
			return FELD_VOLL;
		}
		return NICHT_GEWONNEN;
	}
	
	
	
	public boolean reiheVoll(int reihe) {
		if(this.getFeldAt(reihe, 0).getFeldinhalt().equals(Feldinhalt.SPIELER1) ||
		   this.getFeldAt(reihe, 0).getFeldinhalt().equals(Feldinhalt.SPIELER2)	) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	/*
	 * Diese Methode gibt true zurück, wenn in der Vertikalen der angegebene Spieler 4 aufeinander folgende Steine platziert hat.
	 * true  = 4 Steine einer Farbe in einer Reihe;
	 * false = nicht;
	 */
	private boolean pruefeVertikal(int y, int x, Feldinhalt spieler) {
		int steineEinerFarbe = 0;
		for(int i = 0; i <= 5; i++) {
			if(spielfeld[i][x].getFeldinhalt().equals(spieler)) {
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
	private boolean pruefeHorizontal(int y, int x, Feldinhalt spieler) {
		int steineEinerFarbe = 0;
		for(int i = 0; i <= 6; i++) {
			if(spielfeld[y][i].getFeldinhalt().equals(spieler)) {
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
	private boolean pruefeDiagonal(int y, int x, Feldinhalt spieler) {
		
		int steineEinerFarbe = 1;
		int tempX = x,tempY = y;
		/*
		 * Es wird erstmal richtung links oben gezaehlt, wieviel Steine des Spielers vorhanden sind.
		 */
		while(steineEinerFarbe < 5 && tempX > 0 && tempY > 0) {
			tempX--;
			tempY--;
			if(spielfeld[tempY][tempX].getFeldinhalt().equals(spieler)) {
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
			if(spielfeld[tempY][tempX].getFeldinhalt().equals(spieler)) {
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
			if(spielfeld[tempY][tempX].getFeldinhalt().equals(spieler)) {
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
			if(spielfeld[tempY][tempX].getFeldinhalt().equals(spieler)) {
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
	
	public Feld[][] getSpielfeld(){
		return spielfeld;
	}
	
	public Feld getFeldAt(int x, int y) {
		return spielfeld[y][x];
	}
	
	public int getSpielerInt(Feldinhalt spieler) {
		switch(spieler) {
			case SPIELER1:return 1;
			case SPIELER2:return 2;
			default:return 0;
		}
	}
	
	
}
