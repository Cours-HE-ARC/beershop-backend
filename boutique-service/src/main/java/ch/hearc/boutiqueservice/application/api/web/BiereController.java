package ch.hearc.boutiqueservice.application.api.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.hearc.boutiqueservice.application.api.web.ressources.BiereRessource;

@RestController
@RequestMapping("biere")
public class BiereController {
	
	@GetMapping
	public List<BiereRessource> getAllBiere(){
		return null;
	}
	
}
