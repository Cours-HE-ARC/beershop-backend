package ch.hearc.boutiqueservice.domaine.model;

public class Stock {

	private Article article;
	private int stock;
	
	

	private Stock(Article article, int stock) {
		super();
		this.article = article;
		this.stock = stock;
	}



	public Article getArticle() {
		return article;
	}



	public int getStock() {
		return stock;
	}



	public static Stock creerStock(Article article, int stock) {
		return new Stock(article, stock);
	}
}
