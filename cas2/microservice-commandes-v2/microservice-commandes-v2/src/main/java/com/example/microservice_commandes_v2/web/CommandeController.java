package com.example.microservice_commandes_v2.web;

import com.example.microservice_commandes_v2.dto.ProduitDto;
import com.example.microservice_commandes_v2.entities.Commande;
import com.example.microservice_commandes_v2.repositories.CommandeRepository;
import com.example.microservice_commandes_v2.service.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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





    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/{idProduit}/produit")
    public CompletableFuture<ProduitDto> produit(@PathVariable Long idProduit) {
        return commandeService.getProduit(idProduit);
    }


}
