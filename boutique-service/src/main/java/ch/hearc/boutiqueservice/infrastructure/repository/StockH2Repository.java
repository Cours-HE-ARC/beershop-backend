package ch.hearc.boutiqueservice.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.hearc.boutiqueservice.domaine.model.Article;
import ch.hearc.boutiqueservice.domaine.model.Stock;
import ch.hearc.boutiqueservice.domaine.repository.StockRepository;
import ch.hearc.boutiqueservice.infrastructure.jpa.ArticleSpringDataRepository;
import ch.hearc.boutiqueservice.infrastructure.jpa.StockSpringDataRepository;
import ch.hearc.boutiqueservice.infrastructure.repository.entity.ArticleEntity;
import ch.hearc.boutiqueservice.infrastructure.repository.entity.StockEntity;

@Repository
public class StockH2Repository implements StockRepository{

	@Autowired
	private StockSpringDataRepository stockSpringDataRepository;
	
	@Autowired
	private ArticleSpringDataRepository articleSpringDataRepository;
	
	@Override
	public Stock creerStock(Stock stock) {
		
		ArticleEntity article = articleSpringDataRepository.findByNoArticle(stock.getArticle().getNoArticle()).get();
		
		StockEntity entity = stockSpringDataRepository.save(
				new StockEntity(article, stock.getArticle().getStock()));
		
		return entity.toStock();
		
	}
}
