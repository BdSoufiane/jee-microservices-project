package com.example.microservice_commandes_v2.dto;

public class ProduitDto {
    public Long id;
    public String nom;
    public Double prix;

    public ProduitDto() {}
    public ProduitDto(Long id, String nom, Double prix) {
        this.id = id; this.nom = nom; this.prix = prix;
    }
}

