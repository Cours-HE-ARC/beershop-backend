package ch.hearc.boutiqueservice.application.api.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.hearc.boutiqueservice.application.api.web.ressources.BiereRessource;
import ch.hearc.boutiqueservice.application.api.web.ressources.CreerBiereReponseResource;
import ch.hearc.boutiqueservice.application.api.web.ressources.TypeBiereRessource;
import ch.hearc.boutiqueservice.application.service.BiereService;
import ch.hearc.boutiqueservice.domaine.commande.CreerBiereCommande;

@RestController
@RequestMapping("biere")
public class BiereController {
	
	private final BiereService biereService;
	
	@Autowired
	public BiereController(final BiereService biereService) {
		this.biereService = biereService;
	}
	
	@GetMapping
	public List<BiereRessource> getAllBieres(){
		
		return biereService.getAllBieres().stream().map(biere -> {
			return BiereRessource.fromBiere(biere);
		}).collect(Collectors.toList());
	}
	
	@GetMapping("type")
	public List<TypeBiereRessource> getAllTypeBieres(){
		
		return biereService.getAllTypeBieres().stream().map(tbiere -> {
			return TypeBiereRessource.fromTypeBiere(tbiere);
		}).collect(Collectors.toList());
		
	}
	
	
	@PostMapping
	public CreerBiereReponseResource createBiere(@RequestBody CreerBiereCommande creerBiereCommande ){
		
		System.out.println(creerBiereCommande);
		
		return CreerBiereReponseResource.fromBiere(biereService.creerBiere(creerBiereCommande));
	}
	
}
