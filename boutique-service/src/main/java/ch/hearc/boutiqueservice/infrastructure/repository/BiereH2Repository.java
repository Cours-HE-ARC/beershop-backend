package ch.hearc.boutiqueservice.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.hearc.boutiqueservice.application.api.web.ressources.BiereRessource;
import ch.hearc.boutiqueservice.domaine.model.Biere;
import ch.hearc.boutiqueservice.domaine.repository.BiereRepository;
import ch.hearc.boutiqueservice.infrastructure.jpa.BiereJpaRepository;
import ch.hearc.boutiqueservice.infrastructure.repository.entity.BiereEntity;

@Repository
public class BiereH2Repository implements BiereRepository {

	private BiereJpaRepository biereJpaRepository;
	
	
	
	


	public Biere creerBiere(Biere biere) {
		
		BiereEntity bEntity = new BiereEntity(null, biere);
		
		this.biereJpaRepository.save(bEntity);
		
		return bEntity.toBiere();
	}
	
	public List<Biere> listerBiere() {
		
		List<BiereEntity> bieres = new ArrayList<BiereEntity>();
		
		biereJpaRepository.findAll().forEach(bieres::add);
		
		return bieres.stream().map(biereEntity -> {
			return biereEntity.toBiere();
		}).collect(Collectors.toList());
		
		
	}

}
