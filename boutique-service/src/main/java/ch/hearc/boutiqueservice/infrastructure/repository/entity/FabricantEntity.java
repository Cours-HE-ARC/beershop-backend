package ch.hearc.boutiqueservice.infrastructure.repository.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fabricant")
public class FabricantEntity {

	@Id
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@OneToMany(mappedBy="fabricant_id")
    private Set<ArticleEntity> articles;
	
}
