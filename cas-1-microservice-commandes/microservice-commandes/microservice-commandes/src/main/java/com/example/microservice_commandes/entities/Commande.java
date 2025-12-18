package com.example.microservice_commandes.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer quantite;
    private LocalDate date;
    private Double montant;

    // Constructeur personnalisé si nécessaire
    public Commande(String description, Integer quantite, LocalDate date, Double montant) {
        this.description = description;
        this.quantite = quantite;
        this.date = date;
        this.montant = montant;
    }
}

