package com.iut.as.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestCompteSansDecouvert {

	private Compte compte;

	private static final String NUM_COMPTE_TEST = "FR12 112345";
	private static final double MONTANT_INITIAL = 100d;

	@Before
	public void setUp() {
		// Avoir une méthode d'initialisation plus claire ..
		compte = new CompteSansDecouvert(NUM_COMPTE_TEST, MONTANT_INITIAL);
	}

	@Test
	public void testCrediter() {
		// Je vais créditer mon compte de 100e :
		assertTrue(compte.crediter(100d));
		// Mon solde doit être égal à mon solde initial + 100e.
		assertEquals(200d, compte.getSolde(), 1);
	}

	@Test
	public void testDebiterAvecSoldeSuffisant() {
		// Je vais débiter mon compte de 100e:
		assertTrue(compte.debiter(100d));
		// Mon solde doit être égal à mon solde initial + 100e.
		assertEquals(0, compte.getSolde(), 1);
	}
	
	@Test
	public void testDebiterAvecSoldeInsuffisant() {
		// Je vais débiter mon compte de 150e:
		assertFalse(compte.debiter(150d));
		// Mon solde doit être égal à mon solde initial + 100e.
		assertEquals(MONTANT_INITIAL, compte.getSolde(), 1);
	}
}