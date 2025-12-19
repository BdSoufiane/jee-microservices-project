package com.example.microserviceproduit.entities;



import jakarta.persistence.*;

@Entity
public class Produit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Double prix;

    public Produit() {}

    public Produit(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public Double getPrix() { return prix; }

    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrix(Double prix) { this.prix = prix; }
}
