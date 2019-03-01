package ch.hearc.boutiqueservice.domaine;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import ch.hearc.boutiqueservice.domaine.model.Biere;
import ch.hearc.boutiqueservice.domaine.model.Fabricant;
import ch.hearc.boutiqueservice.domaine.model.Stock;
import ch.hearc.boutiqueservice.domaine.model.TypeBiere;

public class StockTest {

	@Test
	public void givenBiereAndStockAndPrix_whenInsanciateStock_thenStockOk() {
		
		Biere biere = Biere.creerBiere("BiereTest", TypeBiere.AMBREE, Fabricant.FELDSCHLOSCHEN);
		BigDecimal prix = new BigDecimal("2.95");
		
		Stock stock = Stock.stockPourBiere(biere, 2, prix);
		
		assertTrue(stock != null);
		assertTrue(stock.getBiere() != null);
		assertTrue(stock.getPrix() != null);
		assertTrue(stock.getStock() == 2);
	}
	
	@Test
	public void givenStockIn0_whenGetIsEnStock_thenReturnFalse() {
		
		Biere biere = Biere.creerBiere("BiereTest", TypeBiere.AMBREE, Fabricant.FELDSCHLOSCHEN);
		BigDecimal prix = new BigDecimal("2.95");
		
		Stock stock = Stock.stockPourBiere(biere, 0, prix);
		
		assertFalse(stock.enStock());
		
	}
	
	

}
