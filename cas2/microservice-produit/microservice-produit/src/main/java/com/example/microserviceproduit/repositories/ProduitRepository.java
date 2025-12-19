package com.example.microserviceproduit.repositories;



import com.example.microserviceproduit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
