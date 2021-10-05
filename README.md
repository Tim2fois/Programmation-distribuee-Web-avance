# Programmation-distribuee-Web-avance

Autors : Timothée REBEL - Arthur GACHOD


1. https://spring.io/quickstart
2. https://spring.io/guides/gs/rest-service

Avec l'essor de l'utilisation des applications gourmandes en ressources (streaming vidéo, banques, musique, e-commerce, etc.), les entreprises sont confrontées à des challenges liés à la performance de ces services, au coût de l'infrastructure technique et au coût du développement et de la maintenance.

L'architecture Microservices propose une solution en principe simple : découper une application en petits services, appelés Microservices, parfaitement autonomes qui exposent une API REST que les autres Microservices pourront consommer. 

![image](https://user-images.githubusercontent.com/77403806/135824266-635643b0-ede2-42fe-9362-aafefec2d107.png)

La figure ci-dessus représente un schéma simplifié d'une application basée sur l'architecture Microservices.
Dans notre cas, l'interface utilisateur va permettre d'entrer un nom, mot de passe, et le service d'authentification va vérifier le mot de passe, le token, ...etc
Un service gateway sera mis en place et permettra aux autres services de communiquer entre eux.

Chaque Microservice est parfaitement autonome : il a sa propre base de données, son propre serveur d'application (tomcat, jetty, etc.), ses propres librairies et ainsi de suite. La plupart du temps ces Microservices sont chacun dans un container Docker, ils sont donc totalement indépendants y compris vis-à-vis de la machine sur laquelle ils tournent.

API : 

API est l’abréviation de “Application Programming Interface”. C'est une interface de programmation, c'est-à-dire un ensemble de classes, de fonctions et de méthodes qui servent de façade à un logiciel. D'autres logiciels pourront donc accéder aux services de ce logiciel grâce à cette interface.

L’API permet de faciliter la communication entre 2 produits ou services, comme par exemple votre application et un service de géolocalisation. L’API permet à ces 2 entités d’échanger des données sans en connaître les détails de mise en œuvre.

REST : 

REST est un type d'architecture d'API qui signifie REpresentational State Transfer. Il a été inventé par l'Américain Roy Fielding dans les années 2000, période charnière dans la reconnaissance du potentiel des API web, afin de mettre en place des méthodes simples pour accéder à des services web.
Ce type d'API permet à des logiciels qui sont incompatibles, qui ne parlent pas le même langage, de communiquer facilement. REST peut être considéré comme un langage commun à ces différents logiciels. Par exemple, une API REST peut être réalisée dans le langage Java ou .NET.

Les types de requêtes HTTP 
GET : récupérer des données à partir d'une ressource
POST : envoyer des données à traiter à une ressource spécifique
PUT : mettre à jour une ressource spécifiée
DELETE : supprimer une ressource spécifiée


LES STARTERS : 

Les starters viennent compléter l'auto-configuration et font gagner énormément de temps, notamment lorsqu'on commence le développement d'un Microservice. Un starter va apporter à votre projet un ensemble de dépendances, communément utilisées pour un type de projet donné. Ceci va vous permettre de créer un "squelette" prêt à l'emploi très rapidement.

L'autre énorme avantage est la gestion des versions. Plus besoin de chercher quelles versions sont compatibles puis de les ajouter une à une dans le pom.xml ! Il vous suffit d'ajouter une simple dépendance au starter de votre choix. Cette dépendance va alors ajouter, à son tour, les éléments dont elle dépend, avec les bonnes versions.

Prenons l'exemple où vous souhaitez créer un Microservice. En temps normal, vous aurez besoin des dépendances suivantes :

Spring ;

Spring MVC ;

Jackson (pour json) ;

Tomcat ;

...

Avec Spring Boot, vous allez tout simplement avoir une seule dépendance dans votre pom.xml :
![image](https://user-images.githubusercontent.com/77403806/135825578-9ce0884a-4a11-4739-b2ba-7bea9d2b6cd2.png)

POSTMAN : 

Postman est un logiciel qui se focalise sur les tests des API. Il est devenu très populaire pour tester les Microservices, notamment grâce à sa simplicité et ses fonctionnalités très spécialisées.

Nous allons utiliser un logiciel appelé Postman qui permet d'envoyer toutes sortes de requêtes et les personnaliser très finement. Il permet également de gérer l'authentification, les scripts de tests, etc.

Spring sait grâce à ces annotations ce qu'il doit faire : 
@PostMapping : pour gérer des requêtes POST ou GET @GetMapping
@RequestBody : transforme un tableau Json en objet 
