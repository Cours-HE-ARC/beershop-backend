package ch.hearc.boutiqueservice.domaine;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import ch.hearc.boutiqueservice.domaine.exception.StockInsuffisantException;
import ch.hearc.boutiqueservice.domaine.model.Biere;
import ch.hearc.boutiqueservice.domaine.model.Fabricant;
import ch.hearc.boutiqueservice.domaine.model.Stock;
import ch.hearc.boutiqueservice.domaine.model.TypeBiere;

public class StockTest {

	@Test
	public void givenBiereAndStockAndPrix_whenInsanciateStock_thenStockOk() {
		
		Biere biere = Biere.creerBiere("BiereTest", new TypeBiere("Ambree"), new Fabricant("FELDSCHLOSCHEN"));
		BigDecimal prix = new BigDecimal("2.95");
		
		Stock stock = Stock.stockPourBiere(biere, 2, prix);
		
		assertTrue(stock != null);
		assertTrue(stock.getBiere() != null);
		assertTrue(stock.getPrix() != null);
		assertTrue(stock.getStock() == 2);
	}
	
	@Test
	public void givenStockIn0_whenGetIsEnStock_thenReturnFalse() {
		
		Biere biere = Biere.creerBiere("BiereTest", new TypeBiere("Ambree"), new Fabricant("FELDSCHLOSCHEN"));
		BigDecimal prix = new BigDecimal("2.95");
		
		Stock stock = Stock.stockPourBiere(biere, 0, prix);
		
		assertFalse(stock.enStock());
		
	}
	
	@Test
	public void givenStockIn10_whenGetIsEnStock_thenReturnTrue() {
		
		Biere biere = Biere.creerBiere("BiereTest", new TypeBiere("Ambree"), new Fabricant("FELDSCHLOSCHEN"));
		BigDecimal prix = new BigDecimal("2.95");
		
		Stock stock = Stock.stockPourBiere(biere, 10, prix);
		
		assertTrue(stock.enStock());
		
	}
	
	@Test
	public void givenStockIn10_whenDestock8_thenStockRestantEquals2() {
		
		Biere biere = Biere.creerBiere("BiereTest", new TypeBiere("Ambree"), new Fabricant("FELDSCHLOSCHEN"));
		BigDecimal prix = new BigDecimal("2.95");
		
		Stock stock = Stock.stockPourBiere(biere, 10, prix);
		
		stock.destocke(8);
		
		assertTrue(stock.enStock());
		assertTrue(stock.getStock() == 2);
		
	}
	
	@Test(expected = StockInsuffisantException.class)
	public void givenStockIn10_whenDestock18_thenStockInsuffisantExceptionExceptionIsThrown() {
		
		Biere biere = Biere.creerBiere("BiereTest", new TypeBiere("Ambree"), new Fabricant("FELDSCHLOSCHEN"));
		BigDecimal prix = new BigDecimal("2.95");
		
		Stock stock = Stock.stockPourBiere(biere, 10, prix);
		
		stock.destocke(18);
		
		fail();
		
	}
	
	
	
	

}
