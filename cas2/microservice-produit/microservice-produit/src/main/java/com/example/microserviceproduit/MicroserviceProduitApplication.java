package com.example.microserviceproduit;

import com.example.microserviceproduit.entities.Produit;
import com.example.microserviceproduit.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroserviceProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProduitApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProduitRepository repo) {
		return args -> {
			repo.save(new Produit("Clavier", 150.0));
			repo.save(new Produit("Souris", 80.0));
		};
	}

}
