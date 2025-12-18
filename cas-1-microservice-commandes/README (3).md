# Étude de cas 1 – Microservice Commandes

## 1. Présentation
Cette étude de cas consiste à développer un microservice de gestion des commandes
en utilisant Spring Boot et Spring Cloud, sans écrire de requêtes SQL manuelles.

---

## 2. Équipe de développement
- Nom Prénom
- Filière / Groupe
- Email (optionnel)

---

## 3. Architecture
L’architecture du cas 1 est composée de :
- Un microservice `microservice-commandes`
- Un serveur de configuration centralisée `config-server`
- Une base de données H2
- Spring Boot Actuator pour la supervision

---

## 4. Fonctionnalités réalisées

### 4.1 CRUD Commande (0 SQL)
Gestion complète de l’entité COMMANDE :
- id
- description
- quantite
- date
- montant

Les opérations CRUD sont réalisées via Spring Data JPA sans requêtes SQL.

---

### 4.2 Configuration centralisée
- Configuration externalisée dans un dépôt GitHub
- Spring Cloud Config Server
- Spring Cloud Config Client

---

### 4.3 Propriété dynamique
- Propriété `mes-config-ms.commandes-last`
- Endpoint pour afficher les commandes des N derniers jours
- Rafraîchissement à chaud via `/actuator/refresh`

---

### 4.4 Supervision
- Endpoint `/actuator/health`
- HealthIndicator personnalisé :
  - UP si la table COMMANDE contient au moins une commande
  - DOWN sinon

---

## 5. Lancement des projets

### 5.1 Lancer le Config Server
```bash
cd config-server
mvn spring-boot:run


5.2 Lancer le Microservice Commandes
cd microservice-commandes
mvn spring-boot:run

6. Accès aux services

Microservice Commandes : http://localhost:8081

H2 Console : http://localhost:8081/h2-console

Health Check : http://localhost:8081/actuator/health