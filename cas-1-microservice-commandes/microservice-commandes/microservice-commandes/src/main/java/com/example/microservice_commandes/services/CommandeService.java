package com.example.microservice_commandes.services;



import com.example.microservice_commandes.config.MesConfigMsProperties;
import com.example.microservice_commandes.entities.Commande;
import com.example.microservice_commandes.repositories.CommandeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository repo;
    private final MesConfigMsProperties props;

    public CommandeService(CommandeRepository repo, MesConfigMsProperties props) {
        this.repo = repo;
        this.props = props;
    }

    public List<Commande> commandesDesDerniersJours() {
        int n = props.getCommandesLast();     // <-- lit mes-config-ms.commandes-last
        LocalDate minDate = LocalDate.now().minusDays(n);
        return repo.findByDateAfter(minDate);
    }

    public int getN() {
        return props.getCommandesLast();
    }
}

