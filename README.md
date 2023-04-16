# ProjetMSA

- télécharger le doc en .zip et extraire les documents dans un même fichier
- avant d'exécuter sur un même environnement de travail, séparer le fichier JSon du reste des documents

EXECUTION DU CODE :
- une fois le projet ouvert dans IntelliJ, un dossier apparaît en bas à gauche pour faire exécuter en même temps les microservice
- clique droit sur ce dernier dossier, puis cliquez sur "Exécuter"


RESULTATS ET ATTENDUS :
- les deux microservice "Emprunt" et "Livre" vont fonctionner, sans pour autant afficher quelque chose sur leur adress http respectives 
(http://localhost:9001 pour le microservice "livre" et http://localhost:9002 pour le microservice 'emprunt')
- Le microservice 'Lecteur' (alias 'client[MSA]') ne s'exécutera pas conveblament compte tenu qu'il manque certainement des modules ou des conflits 
dans les dépendances du pom.xml. 
- L'application associée au lecteur ne fonctionne pas non plus en la déployant sur Azure ou autre possibilité de la déployer.


MANQUE :
Il nous fut impossible de déployer le projet par un bug de Docker : installation, mise à jour, désinstallation, et réinstallation => impossible d'ouvrir Docker (cf. rapport),
ou des difficultés à l'installation de Kubernetes : demande de mise à jour de Ubuntu sur WSL, impossible de se connecter sans déconnection de la VM, etc... 
