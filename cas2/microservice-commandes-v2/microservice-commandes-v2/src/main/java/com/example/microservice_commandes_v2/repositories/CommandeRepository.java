package com.example.microservice_commandes_v2.repositories;

import com.example.microservice_commandes_v2.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> { }

