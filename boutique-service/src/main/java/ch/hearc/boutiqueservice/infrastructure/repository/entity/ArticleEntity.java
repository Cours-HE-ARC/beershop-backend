package ch.hearc.boutiqueservice.infrastructure.repository.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.hearc.boutiqueservice.domaine.model.Fabricant;

@Entity
@Table(name = "article")
public abstract class ArticleEntity {

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
	
	@ManyToOne
    @JoinColumn(name="fabricant_id", nullable=false)
    private Fabricant fabricant;

	public ArticleEntity(String noArticle, Boolean actif, String description, BigDecimal prix, Fabricant fabricant) {
		super();
		this.noArticle = noArticle;
		this.actif = actif;
		this.description = description;
		this.prix = prix;
		this.fabricant = fabricant;
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

	public Fabricant getFabricant() {
		return fabricant;
	}
	
	
	
	
}
