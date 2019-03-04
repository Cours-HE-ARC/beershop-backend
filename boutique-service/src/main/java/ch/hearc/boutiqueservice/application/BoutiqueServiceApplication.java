package ch.hearc.boutiqueservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("ch.hearc.boutiqueservice")
@EnableJpaRepositories("ch.hearc.boutiqueservice.infrasructure.jpa")
public class BoutiqueServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BoutiqueServiceApplication.class, args);
	}

}
