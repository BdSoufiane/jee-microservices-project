package com.example.microservice_commandes.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mes-config-ms")
public class MesConfigMsProperties {
    /**
     * Nombre de jours "N" à utiliser pour filtrer les commandes récentes
     */
    private int commandesLast = 10;

    public int getCommandesLast() { return commandesLast; }
    public void setCommandesLast(int commandesLast) { this.commandesLast = commandesLast; }
}

