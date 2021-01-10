# faircorp-fanny-besson

## Exécuter ce projet sur son ordinateur

Télécharger ou cloner ce projet github.
Pour l'exécuter depuis la ligne de commande, faites la commande:
`./gradlew --continous bootStrap`

Une fois la commande exécutée (elle doit arriver à 80% de l'execution), vous pouvez utiliser l'application dans votre navigateur.

* `http://localhost:8080/`

    Pour afficher la page d'accueil de l'application
    
* `http://localhost:8080/NOM`

    Pour afficher une page saluant `NOM`

* `http://localhost:8080/console`

    Pour afficher l'architecture de la base de donnée utilisée (Windows, Rooms, Heaters)
    
* `http://localhost:8080/swagger-ui/index.html`

    Pour afficher l'interface de l'API et ses différents services:
    
    * `/api​/hello​/{name}` (GET) salue l'utilisateur
    
    * `/api/windows` (GET) liste les fenêtres
    * `/api/windows` (POST) crée une fenêtre
    * `/api/windows/{window_id}` (GET) renvoie la fenêtre 
    * `/api/windows/{window_id}` (DELETE) supprime la fenêtre
    * `/api/windows/{window_id}/switch` modifie le Status de la fenêtre (OPEN en CLOSED ou inversement)
    
    * `/api/heaters` (GET) liste les radiateurs
    * `/api/heaters` (POST) crée un radiateur
    * `/api/heaters/{heater_id}` (GET) renvoie le radiateur
    * `/api/heaters/{heater_id}` (DELETE) supprime le radiateur
    
    * `/api/rooms` (GET) lister
    * `/api/rooms` (POST) crée une salle
    * `/api/rooms/{room_id}` (GET) renvoie la salle
    * `/api/rooms/{room_id}` (DELETE) supprime la salle et ses fenêtres et ses radiateurs
    * `/api/rooms/{room_id}/switchWindow` switch le status des fenêtres de la salle (OPEN en CLOSED ou inversement)
    * `/api/rooms/{room_id}/switchHeaters` switch le status des radiateurs de la salle (ON en OFF ou inversement)
   
## Exécuter ce projet directement sur son navigateur

Grâce à clevercloud, cette application a été déployée en ligne à cette <a href="http://fannybesson.cleverapps.io/" target="_blank">adresse</a>.

* `http://fannybesson.cleverapps.io/` 

    Pour afficher la page d'accueil de l'application
    
* `http://fannybesson.cleverapps.io/NOM` 
    
    Pour afficher une page saluant `NOM`
    
* `http://fannybesson.cleverapps.io/swagger-ui/index.html` 

    Pour afficher l'API. 

    
    





