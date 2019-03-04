package ch.hearc.boutiqueservice.application.api.web.ressources;

import ch.hearc.boutiqueservice.domaine.model.Biere;

public class BiereRessource {

	private String nom;
	private String fabricant;
	private String prix;
	private int stock;
	
	public BiereRessource(String nom, String fabricant, String prix, int stock) {
		super();
		this.nom = nom;
		this.fabricant = fabricant;
		this.prix = prix;
		this.stock = stock;
	}

	public static BiereRessource fromBiere(Biere b) {
		
		return new BiereRessource(b.getNom(), b.getFabricant().getNom(), b.getPrix().toString(), 1);
	}
	
}
