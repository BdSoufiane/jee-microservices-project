package com.example.microserviceproduit.web;


import com.example.microserviceproduit.entities.Produit;
import com.example.microserviceproduit.repositories.ProduitRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitRepository repo;

    public ProduitController(ProduitRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Produit> all() {
        return repo.findAll();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Produit> one(@PathVariable Long id) {
//        return repo.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping("/produits/{id}")
    public Produit one(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(4000); // <-- simulation timeout (4s)
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));
    }


    @PostMapping
    public Produit create(@RequestBody Produit p) {
        return repo.save(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> update(@PathVariable Long id, @RequestBody Produit p) {
        return repo.findById(id).map(existing -> {
            existing.setNom(p.getNom());
            existing.setPrix(p.getPrix());
            return ResponseEntity.ok(repo.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

