package ch.hearc.boutiqueservice.application.service;

import java.util.List;

import ch.hearc.boutiqueservice.application.api.web.ressources.BiereRessource;
import ch.hearc.boutiqueservice.domaine.commande.CreerBiereCommande;
import ch.hearc.boutiqueservice.domaine.model.Biere;

public interface BiereService {

	List<Biere> getAllBieres();
	
	Biere creerBiere(CreerBiereCommande creerBiereCommande);

}
