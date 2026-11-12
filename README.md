# MediPlan-Microservices

## Gestion de rendez-vous médicaux

## Objectif

Développer une application simplifiée de gestion des rendez-vous médicaux permettant aux patients de consulter les médecins disponibles, de réserver, consulter et annuler un rendez-vous.

L'objectif principal est de mettre en œuvre une architecture microservices avec Docker et Kubernetes.

## Architecture prévue

| Microservice | Rôle | Statut |
|---|---|---|
| `appointment-service` | Création, consultation et annulation des rendez-vous | Prévu |
| `doctor-service` | Gestion des médecins, spécialités et disponibilités | Prévu |
| `patient-service` | Gestion des patients | Prévu |
| `notification-service` | Simulation des notifications de rendez-vous | Optionnel |

Les microservices communiqueront à travers des API REST.

La communication gRPC pourra être ajoutée en bonus.

## Technologies utilisées

- Java 21 / Spring Boot : développement des microservices REST
- Gradle : compilation et gestion des dépendances
- Docker: conteneurisation de chaque microservice
- Docker Hub : publication des images Docker
- Kubernetes / Minikube** : déploiement des microservices
- Ingress : API Gateway et routage des requêtes
- PostgreSQL : persistance des données
- GitHub : gestion du code source et collaboration

Options : gRPC, interface React, déploiement cloud.

## Structure du dépôt

```text
MediPlan-Microservices/
│
├── appointment-service/
│   ├── src/
│   ├── build.gradle
│   └── Dockerfile
│
├── doctor-service/
│   ├── src/
│   ├── build.gradle
│   └── Dockerfile
│
├── patient-service/
│   ├── src/
│   ├── build.gradle
│   └── Dockerfile
│
├── notification-service/
│   ├── src/
│   ├── build.gradle
│   └── Dockerfile
│
├── kubernetes/
│   ├── deployments/
│   ├── services/
│   └── ingress/
│
└── README.md
```

Chaque microservice possède son propre code source, son fichier de configuration Gradle et son Dockerfile.

Le dossier `kubernetes` regroupe les fichiers YAML nécessaires au déploiement des applications.

## Feuille de route

- [ ] Développement du premier microservice REST (`appointment-service`)
- [ ] Création du Dockerfile et de l'image Docker
- [ ] Publication de l'image sur Docker Hub
- [ ] Déploiement du premier microservice avec Kubernetes
- [ ] Création d'un Service Kubernetes
- [ ] Configuration de l'API Gateway avec Ingress
- [ ] Développement et déploiement des autres microservices
- [ ] Communication REST entre les microservices
- [ ] Intégration de PostgreSQL
- [ ] Sécurisation du cluster Kubernetes (RBAC et autres mécanismes)
- [ ] Tests et validation de l'architecture

## Auteurs

- Mamadou Korka Diallo
- Ndeye Coumba Thiam
