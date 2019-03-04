package ch.hearc.boutiqueservice.domaine.model;

import java.math.BigDecimal;

public abstract class Article {

	private BigDecimal prix;
	private String noArticle;
	private Boolean actif;
	private Fabricant fabricant;
	
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
	
}
