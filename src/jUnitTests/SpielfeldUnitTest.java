/**
 * 
 */
package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.Spielfeld;

/**
 * @author Tobias
 *
 */
class SpielfeldUnitTest {

	@Test
	void testGetSpielfeldAt() {
		Spielfeld spielfeldTest = new Spielfeld();
		for(int i = 0;i < 7;i++) {
			for(int z = 0; z < 6;z++) {
				assertEquals(0, spielfeldTest.getSpielfeldAt(z, i));
			}
		}	
	}
	
	@Test
	void testSetzeSpieler() {
		Spielfeld spielfeldTest = new Spielfeld();
		spielfeldTest.setzeSpieler(0, 1);
		assertEquals(1, spielfeldTest.getSpielfeldAt(5,0));
	}
	
	@Test
	void test() {
		Spielfeld spielfeldTest = new Spielfeld();
		/*
		 * Das setzen eines Steins wird überprüft
		 */
		spielfeldTest.setzeSpieler(0, 1);
		assertEquals(1, spielfeldTest.getSpielfeldAt(5,0));
		
		/*
		 * Reihe Voll wird überprüft
		 */
		assertEquals(0,spielfeldTest.setzeSpieler(0, 1));
		assertEquals(0,spielfeldTest.setzeSpieler(0, 1));
		assertEquals(0,spielfeldTest.setzeSpieler(0, 2));
		assertEquals(0,spielfeldTest.setzeSpieler(0, 1));
		assertEquals(0,spielfeldTest.setzeSpieler(0, 1));
		assertEquals(-1,spielfeldTest.setzeSpieler(0, 1));
		
		/*
		 * Prüfen ob gewonnen wird
		 */
		assertEquals(0,spielfeldTest.setzeSpieler(1, 1));
		assertEquals(0,spielfeldTest.setzeSpieler(1, 1));
		assertEquals(0,spielfeldTest.setzeSpieler(1, 1));
		assertEquals(1,spielfeldTest.setzeSpieler(1, 1));
		
		/*
		 * Prüfen ob Fehler geworfen wird
		 */
		assertEquals(-2,spielfeldTest.setzeSpieler(8, 1));
		assertEquals(-2,spielfeldTest.setzeSpieler(5, 3));
		
	}

}
