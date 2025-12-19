# Étude de cas 2 – Architecture Microservices

## Team
- Nom Prénom / Groupe

## Services & Ports
- Eureka Server : http://localhost:8761
- API Gateway : http://localhost:8889
- Produit : http://localhost:8082 (et 8083 pour load balancing)
- Commandes v2 : http://localhost:8081

## Démarrage (ordre)
1) eureka-server
2) microservice-produit
3) microservice-commandes-v2
4) api-gateway
5) (option) 2e instance produit sur 8083

## URLs de test
- Eureka : http://localhost:8761
- Produits via Gateway : http://localhost:8889/produits
- Swagger Produit : http://localhost:8082/swagger-ui/index.html
- Swagger Commandes : http://localhost:8081/swagger-ui/index.html
- Fallback Resilience4j : http://localhost:8081/commandes/1/produit
- CircuitBreaker : http://localhost:8081/actuator/circuitbreakers/produit

## Screenshots
Voir `screenshots/`
