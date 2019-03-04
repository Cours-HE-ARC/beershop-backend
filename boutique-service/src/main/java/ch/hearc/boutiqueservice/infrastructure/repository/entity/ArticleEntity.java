package ch.hearc.boutiqueservice.infrastructure.repository.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import ch.hearc.boutiqueservice.domaine.model.Article;
import ch.hearc.boutiqueservice.domaine.model.Fabricant;

@Entity
@Table(name = "article")
public class ArticleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero")
	private String noArticle;
	
	@Column(name = "actif")
	private Boolean actif;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "prix")
	private BigDecimal prix;
	
	@Column(name = "stock")
	private int stock;
	
	public int getStock() {
		return stock;
	}

	@ManyToOne
    @JoinColumn(name="fabricant_id", nullable=false)
    private FabricantEntity fabricant;

	public ArticleEntity(Long id) {
		this.id = id;
	}
	
	ArticleEntity() {}

	public ArticleEntity(String description, BigDecimal prix, FabricantEntity fabricant, int stock) {
		super();
		this.noArticle = UUID.randomUUID().toString();
		this.actif = Boolean.TRUE;
		this.description = description;
		this.prix = prix;
		this.fabricant = fabricant;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public String getNoArticle() {
		return noArticle;
	}

	public Boolean getActif() {
		return actif;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public FabricantEntity getFabricant() {
		return fabricant;
	}
	
	
	public Article toArticle() {
		return new Article(this.description,this.prix,this.fabricant.toFabricant(),this.stock);
	}
	
}
