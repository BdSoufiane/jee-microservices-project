# JEE Microservices Project – Spring Boot / Spring Cloud

Projet réalisé dans le cadre du module **JEE** : mise en œuvre d’une architecture **microservices** avec **Spring Boot** et **Spring Cloud** à travers deux études de cas.

---

## 👥 Équipe de développement
- **Soufiane Baddah**  
- Groupe / Filière : *(à compléter)*  
- Année : **2025–2026**

---

## 📌 Objectifs pédagogiques
- Développer des microservices REST avec **Spring Boot**
- Utiliser **Spring Data JPA** (CRUD *sans SQL explicite*)
- Centraliser la configuration avec **Spring Cloud Config**
- Superviser avec **Spring Boot Actuator**
- Découvrir **Eureka Discovery**, **API Gateway**, **Load Balancing**
- Mettre en place **Timeout + Fallback** avec **Resilience4j**
- Documenter les APIs via **OpenAPI / Swagger**

---

## 🧩 Contenu du dépôt
Le dépôt contient deux dossiers principaux :

### ✅ Étude de cas 1 — Microservice Commandes + Config Server
📁 `cas-1-microservice-commandes/`  
Fonctionnalités principales :
- CRUD **COMMANDE** (0 SQL avec Spring Data JPA)
- H2 Database + console
- **Spring Cloud Config Server** + configuration externe (GitHub)
- Propriété dynamique : `mes-config-ms.commandes-last` (N derniers jours) + refresh à chaud
- **Actuator** + Health check personnalisé (UP si table COMMANDE non vide)

➡️ Détails + exécution : voir `cas-1-microservice-commandes/README.md`

---

### ✅ Étude de cas 2 — Architecture Microservices complète
📁 `cas-2-microservices/`  
Composants :
- `eureka-server` : Discovery Server
- `api-gateway` : Point d’entrée unique (Spring Cloud Gateway)
- `microservice-produit` : CRUD produit
- `microservice-commandes-v2` : CRUD commande v2 (avec `idProduit`)
- Communication inter-services + **Load Balancing**
- Résilience : **Resilience4j** (timeout + fallback)
- Documentation : **Swagger UI / OpenAPI**

➡️ Détails + exécution : voir `cas-2-microservices/README.md`

---

## 🛠️ Technologies
- Java 17
- Maven
- Spring Boot
- Spring Data JPA
- H2 Database
- Spring Boot Actuator
- Spring Cloud Config (Cas 1)
- Eureka Discovery Server (Cas 2)
- Spring Cloud Gateway (Cas 2)
- Resilience4j (Cas 2)
- OpenAPI / Swagger (springdoc)

---

## ▶️ Exécution rapide

### Cas 1 (Config Server + Commandes)
1. Lancer **config-server**
2. Lancer **microservice-commandes**
3. Tester via Postman / navigateur
4. Vérifier Actuator (`/actuator/health`) et refresh (`/actuator/refresh`)

📌 Guide complet : `cas-1-microservice-commandes/README.md`

---

### Cas 2 (Eureka + Gateway + Produit + Commandes V2)
Ordre recommandé :
1. **Eureka Server**
2. **microservice-produit**
3. **microservice-commandes-v2**
4. **api-gateway**
5. (Option) 2ème instance produit pour démontrer le load balancing

📌 Guide complet : `cas-2-microservices/README.md`

---

## ✅ Démonstration (livrable)
La démonstration peut être réalisée en suivant les tests listés dans les README de chaque cas :
- Enregistrement des services dans **Eureka**
- Routage via **API Gateway**
- CRUD des microservices
- Test Load Balancing (2 instances produit)
- Test Timeout + Fallback (Resilience4j)
- Swagger UI

---

## 📸 Screenshots (livrable)
Les captures d’écran sont disponibles ici :
- Cas 1 : `cas-1-microservice-commandes/screen/partie1/`
- Cas 2 : `cas-2-microservices/screen/partie2` 

---

## 📎 Remarques
- Les ports peuvent être modifiés dans `application.properties` si besoin.
- Pour éviter les conflits de ports, ne pas lancer Cas 1 et Cas 2 simultanément sur les mêmes ports.

---

## 📄 Licence
Projet académique – usage pédagogique.
