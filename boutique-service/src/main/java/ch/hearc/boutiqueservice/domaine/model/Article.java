package ch.hearc.boutiqueservice.domaine.model;

import java.math.BigDecimal;
import java.util.UUID;

public  class Article {

	private BigDecimal prix;
	private String noArticle;
	private Boolean actif;
	private Fabricant fabricant;
	private String description;
	private int stock;
	
	
	public Article(String description,BigDecimal prix, Fabricant fabricant, int stock) {
		this.prix = prix;
		this.noArticle = UUID.randomUUID().toString();
		this.actif = Boolean.TRUE;
		this.fabricant = fabricant;
		this.description = description;
		this.stock = stock;
	}
	
	public String getDescription() {
		return description;
	}

	public Fabricant getFabricant() {
		return fabricant;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public String getNoArticle() {
		return noArticle;
	}

	public Boolean getActif() {
		return actif;
	}
	
	public void defineFabricant(Fabricant fabricant) {
		this.fabricant = fabricant;
	}
	
	public int getStock() {
		return stock;
	}

	
}
