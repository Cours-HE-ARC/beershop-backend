package ch.hearc.boutiqueservice.infrastructure.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ch.hearc.boutiqueservice.domaine.model.Stock;

@Entity
@Table(name = "stock_article")
public class StockEntity {

	@Id
	private Long id;
	
	@Column(name = "stock")
	private int stock;
	
	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	private ArticleEntity article;
	
	public StockEntity(ArticleEntity articleEntity, int stock) {
		this.article = articleEntity;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}
	
	public Stock toStock() {
		return Stock.creerStock(article.toArticle(), stock);
	}

	public int getStock() {
		return stock;
	}

	public ArticleEntity getArticle() {
		return article;
	}
	
}
