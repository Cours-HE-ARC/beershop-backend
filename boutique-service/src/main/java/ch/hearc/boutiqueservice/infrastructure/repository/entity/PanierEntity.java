package ch.hearc.boutiqueservice.infrastructure.repository.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.hearc.boutiqueservice.domaine.model.Article;

@Entity
@Table(name = "panier")
public class PanierEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	private List<Article> articles;
	
	public PanierEntity(List<Article> articles) {
		this.articles = articles;
	}
	
	
}
