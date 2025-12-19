package com.example.microservice_commandes_v2.service;

import com.example.microservice_commandes_v2.dto.ProduitDto;
import com.example.microservice_commandes_v2.repositories.CommandeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class CommandeService {

    private final CommandeRepository repo;
    private final RestTemplate restTemplate;

    public CommandeService(CommandeRepository repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "produit", fallbackMethod = "produitFallback")
    @TimeLimiter(name = "produit", fallbackMethod = "produitFallback")
    public CompletableFuture<ProduitDto> getProduit(Long idProduit) {
        return CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject(
                        "http://MICROSERVICE-PRODUIT/produits/" + idProduit,
                        ProduitDto.class
                )
        );
    }

    // Fallback (signature obligatoire : mêmes params + Throwable)
    private CompletableFuture<ProduitDto> produitFallback(Long idProduit, Throwable ex) {
        return CompletableFuture.completedFuture(
                new ProduitDto(idProduit, "DEFAULT-PRODUIT", 0.0)
        );
    }
}

