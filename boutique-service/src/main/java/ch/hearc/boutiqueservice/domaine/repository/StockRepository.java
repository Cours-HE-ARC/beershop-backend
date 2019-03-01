package ch.hearc.boutiqueservice.domaine.repository;

import ch.hearc.boutiqueservice.domaine.model.Biere;
import ch.hearc.boutiqueservice.domaine.model.Stock;

public interface StockRepository {

	Stock retourneStockPour(Biere biere);
	
	
}
