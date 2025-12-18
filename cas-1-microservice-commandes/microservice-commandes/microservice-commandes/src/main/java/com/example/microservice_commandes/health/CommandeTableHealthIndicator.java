package com.example.microservice_commandes.health;



import com.example.microservice_commandes.repositories.CommandeRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandeTableHealthIndicator implements HealthIndicator {

    private final CommandeRepository repo;

    public CommandeTableHealthIndicator(CommandeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Health health() {
        long count;
        try {
            count = repo.count(); // ✅ check: table COMMANDE contient des lignes ?
        } catch (Exception e) {
            // Si DB down / table pas accessible -> DOWN
            return Health.down(e).build();
        }

        Map<String, Object> details = new HashMap<>();
        details.put("table", "COMMANDE");
        details.put("count", count);

        if (count > 0) {
            return Health.up().withDetails(details).build();
        } else {
            return Health.down().withDetails(details).build();
        }
    }
}

