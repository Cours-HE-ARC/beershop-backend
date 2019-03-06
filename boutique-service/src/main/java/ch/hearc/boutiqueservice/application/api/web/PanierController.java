package ch.hearc.boutiqueservice.application.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.hearc.boutiqueservice.application.api.web.ressources.AjouterArticlePanierReponseResource;
import ch.hearc.boutiqueservice.application.api.web.ressources.CreerBiereReponseResource;
import ch.hearc.boutiqueservice.application.api.web.ressources.CreerPanierReponseResource;
import ch.hearc.boutiqueservice.application.api.web.ressources.PanierRessource;
import ch.hearc.boutiqueservice.application.service.BoutiqueService;
import ch.hearc.boutiqueservice.application.service.PanierService;
import ch.hearc.boutiqueservice.domaine.commande.AjouterArticlePanierCommande;
import ch.hearc.boutiqueservice.domaine.commande.CreerBiereCommande;
import ch.hearc.boutiqueservice.domaine.commande.CreerPanierCommande;

@RestController
@RequestMapping("boutique")
public class PanierController {
	
	private PanierService panierService;
	

	@Autowired
	public PanierController(PanierService panierService) {
		this.panierService = panierService;
	}

	@GetMapping("/panier/{panierNo}")
	public PanierRessource getPanierByPanierNo(@PathVariable("panierNo") String panierNo) {
		return PanierRessource.fromPanier(
				panierService.getPanierByNoPanier(panierNo));
	}

	@PostMapping("/panier")
	public CreerPanierReponseResource createPanier(@RequestBody CreerPanierCommande creerPanierCommande ){
		
		System.out.println(creerPanierCommande);
		
		return CreerPanierReponseResource.fromPanier(panierService.creerPanier(creerPanierCommande));
	}
	
	@PutMapping("/panier/{noPanier}")
	public AjouterArticlePanierReponseResource createPanier(
			@PathVariable("noPanier") String noPanier, 
			@RequestBody AjouterArticlePanierCommande ajouterArticlePanierCommande ){
		
		System.out.println(ajouterArticlePanierCommande);
		
		return AjouterArticlePanierReponseResource.fromPanier(panierService.ajouterArticlePanier(noPanier, ajouterArticlePanierCommande));
	}
}
