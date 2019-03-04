package ch.hearc.boutiqueservice.application.api.web.ressources;

import ch.hearc.boutiqueservice.domaine.model.Biere;

public class CreerBiereReponseResource {

	private String noArticle;

	public CreerBiereReponseResource(String noArticle2) {
		// TODO Auto-generated constructor stub
	}

	public String getNoArticle() {
		return noArticle;
	}

	public static CreerBiereReponseResource fromBiere(Biere biere) {
		
		CreerBiereReponseResource creerBiereReponseResource = new CreerBiereReponseResource(biere.getNoArticle());
		
		return creerBiereReponseResource;
	}
	
	
}
