# HealthCare-


Ce projet consiste à développer une API REST pour la gestion d’un système médical dans le cadre de la transformation numérique d’une entreprise HealthCare+.

L’application permet de gérer efficacement :

les patients
les médecins
les rendez-vous
les dossiers médicaux

L’objectif est de proposer une architecture claire, maintenable et conforme aux bonnes pratiques du développement backend avec Spring Boot.



![diagrammeClass.png](Diagrammes/class/diagrammeClass.png)



![use case .png](Diagrammes/cas%20d%27etulisation/use%20case%20.png)






![ajouter.png](Diagrammes/sequence/ajouter.png)



![lister .png](Diagrammes/sequence/lister%20.png)


![modifier.png](Diagrammes/sequence/modifier.png)


![85e9cc06-8e03-4449-9202-25156275ca40.png](Diagrammes/85e9cc06-8e03-4449-9202-25156275ca40.png)

Technologies utilisées
Java 17 / 21
Spring Boot
Spring Data JPA / Hibernate
Flyway (gestion des migrations)
MySQL / H2 (tests)
MapStruct (mapping DTO ↔ Entity)
Lombok
Swagger (documentation API)
Maven
Docker



Architecture

Le projet suit une architecture MVC :

Controller → gestion des requêtes HTTP
Service → logique métier
Repository → accès aux données
DTO → transfert de données
Mapper → conversion Entity ↔ DTO (MapStruct) 



Lancement du projet
1. Cloner le projet


git clone <repo-url>


Lancer MySQL (Docker)

docker run -d --name healthcare-mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
-e MYSQL_DATABASE=healthcare \
-p 3306:3306 mysql:8.0


Lancer l’application   

mvn spring-boot:run 

Tester l’API
Swagger :

http://localhost:8080/swagger-ui.html    