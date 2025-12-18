package com.example.microservice_commandes.web;



import com.example.microservice_commandes.entities.Commande;
import com.example.microservice_commandes.repositories.CommandeRepository;
import com.example.microservice_commandes.services.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeRepository repo;
    private final CommandeService commandeService;

    public CommandeController(CommandeRepository repo, CommandeService commandeService) {
        this.repo = repo;
        this.commandeService = commandeService;
    }

    @GetMapping
    public List<Commande> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> one(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Commande create(@RequestBody Commande c) {
        // option: c.setId(null) pour forcer création
        return repo.save(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> update(@PathVariable Long id, @RequestBody Commande c) {
        return repo.findById(id).map(existing -> {
            existing.setDescription(c.getDescription());
            existing.setQuantite(c.getQuantite());
            existing.setDate(c.getDate());
            existing.setMontant(c.getMontant());
            return ResponseEntity.ok(repo.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/recentes")
    public List<Commande> recentes() {
        return commandeService.commandesDesDerniersJours();
    }

    @GetMapping("/recentes/n")
    public int nCourant() {
        return commandeService.getN();
    }

}
