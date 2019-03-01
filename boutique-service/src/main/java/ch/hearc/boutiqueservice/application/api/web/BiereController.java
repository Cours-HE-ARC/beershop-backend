package ch.hearc.boutiqueservice.application.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.hearc.boutiqueservice.application.api.web.ressources.BiereRessource;
import ch.hearc.boutiqueservice.application.service.BiereService;

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
		
		
		return biereService.getAllBieres();
	}
	
}
