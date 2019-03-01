package ch.hearc.boutiqueservice.domaine.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Stock {
	
	private Biere biere;
	private int stock;
	private BigDecimal prix;
	
	public static Stock stockPourBiere(Biere biere, int stock, BigDecimal prix) {
		valideParametres(biere, stock, prix);
		
		return new Stock(biere,stock,prix);
	}

	public Biere getBiere() {
		return biere;
	}

	public int getStock() {
		return stock;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public Stock(Biere biere, int stock, BigDecimal prix) {
		super();
		this.biere = biere;
		this.stock = stock;
		this.prix = prix;
	}

	public boolean enStock() {
		return stock > 0;
	}
	
	private static void valideParametres(Biere biere, int enStock, BigDecimal prix) {
		Objects.requireNonNull(biere);
		Objects.requireNonNull(prix);
		
	}
}
