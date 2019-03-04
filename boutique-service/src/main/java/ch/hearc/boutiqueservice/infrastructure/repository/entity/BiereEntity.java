package ch.hearc.boutiqueservice.infrastructure.repository.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import ch.hearc.boutiqueservice.domaine.model.Article;
import ch.hearc.boutiqueservice.domaine.model.Biere;
import ch.hearc.boutiqueservice.domaine.model.Fabricant;
import ch.hearc.boutiqueservice.domaine.model.TypeBiere;

@Entity
@Table(name = "biere")
@PrimaryKeyJoinColumn(name = "id")
public class BiereEntity extends ArticleEntity{

	@Column(name = "nom")
	private String nom;
	
	@Column(name = "contenance_l")
	private BigDecimal contenanceLitre;
	
	public BiereEntity(Article article,Biere biere) {
		super(null,null,null,null,null);
		this.nom = "";
		//return null;
		//biereEntity.
	}

	public String getNom() {
		return nom;
	}

	public BigDecimal getContenanceLitre() {
		return contenanceLitre;
	}

	public Biere toBiere() {
		return Biere.creerBiere("", new TypeBiere(""));
	}
}
