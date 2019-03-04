package ch.hearc.boutiqueservice.domaine.repository;

import java.util.List;

import ch.hearc.boutiqueservice.application.api.web.ressources.BiereRessource;
import ch.hearc.boutiqueservice.domaine.model.Biere;

public interface BiereRepository {

	List<Biere> listerBiere();

	Biere creerBiere(Biere biere);
	
}
