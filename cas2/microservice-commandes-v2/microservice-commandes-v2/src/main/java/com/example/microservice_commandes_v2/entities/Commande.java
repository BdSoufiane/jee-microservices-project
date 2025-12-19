package com.example.microservice_commandes_v2.entities;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer quantite;
    private LocalDate date;
    private Double montant;

    // ✅ nouveau champ v2
    private Long idProduit;

    public Commande() {}

    // getters/setters...
}
