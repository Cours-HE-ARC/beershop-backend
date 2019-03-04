package ch.hearc.boutiqueservice.application.api.web.ressources;

import ch.hearc.boutiqueservice.domaine.model.Biere;

public class BiereRessource {

	private String nom;
	private String fabricant;
	private String prix;
	private String type;
	private int stock;
	
	
	public String getNom() {
		return nom;
	}

	public String getFabricant() {
		return fabricant;
	}

	public String getPrix() {
		return prix;
	}

	public int getStock() {
		return stock;
	}

	public BiereRessource(String nom, String type, String fabricant, String prix, int stock) {
		super();
		this.nom = nom;
		this.fabricant = fabricant;
		this.prix = prix;
		this.stock = stock;
		this.type = type;
	}

	public static BiereRessource fromBiere(Biere b) {
		
		return new BiereRessource(
				b.getNom(), 
				b.getType().getNom(),
				b.getArticle().getFabricant().getNom(),
				b.getArticle().getPrix().toString(), 
				b.getArticle().getStock());
	}

	public String getType() {
		return type;
	}
	
}
