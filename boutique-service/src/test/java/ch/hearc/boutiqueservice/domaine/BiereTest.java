package ch.hearc.boutiqueservice.domaine;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import ch.hearc.boutiqueservice.domaine.model.Biere;
import ch.hearc.boutiqueservice.domaine.model.Fabricant;
import ch.hearc.boutiqueservice.domaine.model.TypeBiere;

@Ignore
public class BiereTest {

	
	@Test
	public void givenNameAndTypeAndFabricant_whenInstanciateBiere_thenInstanceOk() {
		Biere biere = Biere.creerBiere("Cardinal 1664", new TypeBiere("Bllonde"),new Fabricant("Cardinal") );
		
		assertTrue(biere != null);
		assertTrue(biere.getNom() != null);
		assertTrue(biere.getType() != null);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void givenNameAndTypeNull_whenInstanciateBiere_thenNullPointerExceptionIsThrown() {
		Biere biere = Biere.creerBiere("Cardinal 1664", null, new Fabricant("BFM"));
		
		fail();	
	}
	
	@Test(expected=NullPointerException.class)
	public void givenNameNullAndType_whenInstanciateBiere_thenNullPointerExceptionIsThrown() {
		Biere biere = Biere.creerBiere(null, new TypeBiere("Ambree"),new Fabricant("BFM"));
		
		fail();	
	}
	
	@Test(expected=NullPointerException.class)
	public void givenNameNullAndTypeNull_whenInstanciateBiere_thenNullPointerExceptionIsThrown() {
		Biere biere = Biere.creerBiere(null, null,new Fabricant("BFM"));
		
		fail();	
	}
	
	@Test(expected=NullPointerException.class)
	public void givenNameAndTypeAndFabricantNull_whenInstanciateBiere_thenNullPointerExceptionIsThrown() {
		Biere biere = Biere.creerBiere("testBiere", new TypeBiere("Ambree"),null);
		
		fail();	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void givenNameWith3CharAndType_whenInstanciateBiere_thenIllegalArcgumentExceptionIsThrown() {
		Biere biere = Biere.creerBiere("123", new TypeBiere("Ambree"),new Fabricant("BFM"));
		
		fail();	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void givenNameAndTypeAndFabricant_whenInstanciateBiere_thenIdentifiantIsGenereated() {
		Biere biere = Biere.creerBiere("123", new TypeBiere("Ambree"),new Fabricant("BFM"));
		
		assertTrue(biere.getIdentifiant()!= null);
		assertTrue(biere.getIdentifiant().length() == 36);
		
	}
	
	
}
