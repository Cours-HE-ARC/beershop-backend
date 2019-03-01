package ch.hearc.boutiqueservice.application.api.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("boutique")
public class BoutiqueController {

	@GetMapping("/health")
	public ResponseEntity<String> checkAppHealth(){
		return ResponseEntity.ok("app started");
	}
}
