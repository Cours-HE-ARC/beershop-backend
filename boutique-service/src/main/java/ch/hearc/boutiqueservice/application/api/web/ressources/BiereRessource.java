package ch.hearc.boutiqueservice.application.api.web.ressources;

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
	
}
