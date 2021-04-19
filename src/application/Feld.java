package application;

public class Feld {
	int indexX;
	int indexY;
	Feldinhalt feldinhalt;
	
	public Feld(int x, int y, Feldinhalt status) {
		this.indexX = x;
		this.indexY = y;
		this.feldinhalt = status;
	}
	
	public Feldinhalt getFeldinhalt() {
		return feldinhalt;
	}
	public void setFeldinhalt(Feldinhalt newFeldinhalt) {
		this.feldinhalt = newFeldinhalt;
	}
}
