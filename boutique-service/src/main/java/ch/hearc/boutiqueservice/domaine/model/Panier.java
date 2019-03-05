package ch.hearc.boutiqueservice.domaine.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Panier {

	private Map<String, Article> articles;
	private PanierStatus status;
	
	public static Panier creerPanier() {
		Panier panier = new Panier();
		panier.articles = new HashMap<>();
		panier.status = PanierStatus.INITIE;
		return panier;
	}
	
	public boolean ajouterArticle(Article article) {
		
		if(status != PanierStatus.VALIDE) {
			
			articles.put(article.getNoArticle(), article);
			
			if(status == PanierStatus.INITIE) {
				status = PanierStatus.PENDING;
			}
			
			return true;
		}
		
		return false;
	}
	
	public boolean enleverArticle(Article article) {
		
		if(status != PanierStatus.VALIDE) {
			
			if(articles.containsKey(article.getNoArticle())) {
				articles.remove(article);
				return true;
			}
		}
		
		return false;
	}
}
