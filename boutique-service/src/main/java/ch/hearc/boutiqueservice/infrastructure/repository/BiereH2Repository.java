package ch.hearc.boutiqueservice.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.hearc.boutiqueservice.application.api.web.ressources.BiereRessource;
import ch.hearc.boutiqueservice.domaine.model.Biere;
import ch.hearc.boutiqueservice.domaine.model.TypeBiere;
import ch.hearc.boutiqueservice.domaine.repository.BiereRepository;
import ch.hearc.boutiqueservice.infrastructure.jpa.ArticleSpringDataRepository;
import ch.hearc.boutiqueservice.infrastructure.jpa.BiereJpaRepository;
import ch.hearc.boutiqueservice.infrastructure.jpa.FabricantSpringDataRepository;
import ch.hearc.boutiqueservice.infrastructure.jpa.TypeBiereSpringDataRepository;
import ch.hearc.boutiqueservice.infrastructure.repository.entity.ArticleEntity;
import ch.hearc.boutiqueservice.infrastructure.repository.entity.BiereEntity;
import ch.hearc.boutiqueservice.infrastructure.repository.entity.FabricantEntity;
import ch.hearc.boutiqueservice.infrastructure.repository.entity.StockEntity;
import ch.hearc.boutiqueservice.infrastructure.repository.entity.TypeBiereEntity;

@Repository
public class BiereH2Repository implements BiereRepository {

	@Autowired
	private BiereJpaRepository biereJpaRepository;
	
	@Autowired
	private TypeBiereSpringDataRepository typeBiereRepository;
	
	@Autowired
	private FabricantSpringDataRepository fabricantSpringDataRepository;
	
	@Autowired
	private ArticleSpringDataRepository articleSpringDataRepository;
	
	
	


	public Biere creerBiere(Biere biere) {
		
		FabricantEntity fabricantEntity = fabricantSpringDataRepository.findById(biere.getArticle().getFabricant().getId()).get();
		TypeBiereEntity typeBiere = typeBiereRepository.findById(biere.getType().getId()).get();
	
		ArticleEntity articleEntity = articleSpringDataRepository.save(
				new ArticleEntity(biere.getArticle().getDescription(), biere.getArticle().getPrix(),fabricantEntity,biere.getArticle().getStock()));
		
		
		BiereEntity bEntity = new BiereEntity(articleEntity,typeBiere,biere.getNom(),biere.getArticle().getPrix());
		
		this.biereJpaRepository.save(bEntity);
		
		return bEntity.toBiere();
	}
	
	public List<Biere> listerBiere() {
		
		List<BiereEntity> bieres = new ArrayList<BiereEntity>();
		
		Iterable<BiereEntity> it = biereJpaRepository.findAll();
		
		it.forEach(b -> {
			System.out.println(b);
		});
		
		biereJpaRepository.findAll().forEach(bieres::add);
		
		
		
		return bieres.stream().map(biereEntity -> {
			return biereEntity.toBiere();
		}).collect(Collectors.toList());
		
		
	}

	@Override
	public List<TypeBiere> listerTypeBieres() {
		 
		List<TypeBiereEntity> typesBieres = new ArrayList<>();
		
		typeBiereRepository.findAll().forEach(typesBieres::add);
		
		return typesBieres.stream().map(entity -> entity.toTypeBiere()).collect(Collectors.toList());
		
		
	}

	@Override
	public TypeBiere getTypeBiereById(String idType) {
		 return typeBiereRepository.findById(Long.valueOf(idType)).get().toTypeBiere();
	}

	

}
