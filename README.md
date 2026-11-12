# MediPlan-Microservices

# Gestion de rendez-vous médicaux

Projet réalisé en binôme dans le cadre du cours sur les microservices (Docker / Kubernetes).

## Objectif

Application de prise de rendez-vous médicaux : un patient peut consulter les médecins disponibles, réserver, consulter et annuler un rendez-vous.

Le projet est découpé en microservices indépendants, conteneurisés avec Docker et déployés avec Kubernetes.

## Architecture prévue

| Microservice | Rôle | Statut |
|---|---|---|
| `appointment-service` | Création, consultation et annulation des rendez-vous | Prévu |
| `doctor-service` | Gestion des médecins, de leurs spécialités et de leurs disponibilités | Prévu |
| `patient-service` | Gestion des patients | Prévu |
| `notification-service` | Rappels de rendez-vous (optionnel) | Optionnel |

Communication entre services : REST, avec gRPC en option (par exemple entre `appointment-service` et `doctor-service` pour vérifier la disponibilité d'un créneau).

## Technologies

- Microservices : langage Java
- Docker pour la conteneurisation, Docker Hub pour la publication des images
- Kubernetes (Minikube en local) : Deployment, Service, Ingress
- Options envisagées : gRPC, front-end (React / Vue / Angular), déploiement dans un cloud

## Feuille de route

- [ ] Premier microservice en local (`appointment-service`)
- [ ] Dockerfile et publication de l'image sur Docker Hub
- [ ] Deployment et Service Kubernetes
- [ ] Deuxième microservice (`doctor-service`)
- [ ] Gateway en local (Ingress ou service mesh)
- [ ] Options : gRPC, front-end, cloud

## Structure du dépôt

```
.
├── README.md
├── appointment-service/
└── k8s/
```

## Auteurs

- Mamadou Korka Diallo
- Ndeye Coumba Thiam 
