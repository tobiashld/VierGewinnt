package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.Feldinhalt;
import application.Spielfeld;
import application.SpielzugAnalyse;

class SpielzugAnalyseTest extends SpielzugAnalyse{

	@Test
	void pruefeEntscheidungVertikal() {
		Spielfeld testSpielfeld = new Spielfeld();
		testSpielfeld.setzeSpieler(0, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(0, Feldinhalt.SPIELER1);

		assertEquals(0, getJarvis(testSpielfeld));
		
	}
	
	@Test
	void pruefeEntscheidungHorizontal() {
		Spielfeld testSpielfeld = new Spielfeld();
		testSpielfeld.setzeSpieler(0, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER1);

		assertEquals(2, getJarvis(testSpielfeld));
		assertEquals(2, getMittlererSpielzug(testSpielfeld));
	}
	
	@Test
	void pruefeEntscheidungDiagonal() {
		Spielfeld testSpielfeld = new Spielfeld();
		testSpielfeld.setzeSpieler(0, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER2);
		
		
		

		assertEquals(2, getJarvis(testSpielfeld));
		assertEquals(2, getMittlererSpielzug(testSpielfeld));
		
		testSpielfeld.spielfeldReset();
		
		testSpielfeld.setzeSpieler(0, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER1);
		
		assertEquals(3, getJarvis(testSpielfeld));
		assertEquals(3, getMittlererSpielzug(testSpielfeld));
		
		
		
	}
	
	@Test
	void diagonalAlgorithmus() {
		Spielfeld testSpielfeld = new Spielfeld();
		testSpielfeld.setzeSpieler(0, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(0, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(0, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(0, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(0, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(1, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(2, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(3, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(4, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(4, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(4, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(4, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(4, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(4, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(5, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(5, Feldinhalt.SPIELER2);
		testSpielfeld.setzeSpieler(5, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(6, Feldinhalt.SPIELER1);
		testSpielfeld.setzeSpieler(6, Feldinhalt.SPIELER1);
		
		assertEquals(5, getJarvis(testSpielfeld));
	}

}
