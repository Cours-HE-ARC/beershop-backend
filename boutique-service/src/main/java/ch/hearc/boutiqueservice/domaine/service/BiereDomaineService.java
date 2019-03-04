package ch.hearc.boutiqueservice.domaine.service;

import org.springframework.beans.factory.annotation.Autowired;

import ch.hearc.boutiqueservice.domaine.commande.CreerBiereCommande;
import ch.hearc.boutiqueservice.domaine.model.Article;
import ch.hearc.boutiqueservice.domaine.model.Biere;
import ch.hearc.boutiqueservice.domaine.model.Fabricant;
import ch.hearc.boutiqueservice.domaine.model.Stock;
import ch.hearc.boutiqueservice.domaine.model.TypeBiere;
import ch.hearc.boutiqueservice.domaine.repository.BiereRepository;
import ch.hearc.boutiqueservice.domaine.repository.FabricantRepository;
import ch.hearc.boutiqueservice.domaine.repository.StockRepository;
import ch.hearc.boutiqueservice.infrastructure.jpa.ArticleSpringDataRepository;
import ch.hearc.boutiqueservice.infrastructure.repository.entity.ArticleEntity;
import ch.hearc.boutiqueservice.infrastructure.repository.entity.StockEntity;

public class BiereDomaineService {

	private final BiereRepository biereRepository;
	private final FabricantRepository fabricantRepository;
	private final StockRepository stockRepository;
	
	public BiereDomaineService(BiereRepository biereRepository, FabricantRepository fabricantRepository,StockRepository stockRepository) {
		this.biereRepository = biereRepository;
		this.fabricantRepository = fabricantRepository;
		this.stockRepository = stockRepository;
	}
	
	public Biere creerBiere (CreerBiereCommande creerBiereCommande) {
		
		Fabricant fabricant = fabricantRepository.getFabricantById(creerBiereCommande.getIdFabricant());
		
		TypeBiere typeBiere = biereRepository.getTypeBiereById(creerBiereCommande.getIdType());
		
		Biere biere = Biere.creerBiere(creerBiereCommande.getNom(), 
				creerBiereCommande.getPrix(), 
				creerBiereCommande.getContenanceLitre(), 
				typeBiere, 
				fabricant,
				creerBiereCommande.getStockInitial());
		
		biereRepository.creerBiere(biere);
		
		
		Stock stock = Stock.creerStock(biere.getArticle(), creerBiereCommande.getStockInitial());
		stockRepository.creerStock(stock);
		
		return biere;
		
	}
}
