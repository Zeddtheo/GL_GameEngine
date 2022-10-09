# Projet 

Modèle basique de projet gradle pour interface graphique avec `swing`.

Les commandes gradle les plus utiles :

- `gradle test` pour lancer les tests,
- `gradle run` pour lancer le programme,
- `gradle jar` pour construire un `jar` dans `build/libs`.
- `gradle checkStyleMain` pour vérifier le style du code principal avec l'outil [checkstyle](https://checkstyle.sourceforge.io/) (rapports dans `build/reports/checkstyle/`).
- `gradle checkStyleMain` pour vérifier le style du code de test avec l'outil [checkstyle](https://checkstyle.sourceforge.io/) (rapports dans `build/reports/checkstyle/`).
- `gradle jacocoTestReport` pour lancer la couverture de  code via l'outil [Jacoco](https://www.eclemma.org/jacoco/) (rapports dans `build/reports/jacoco/`). 

Le fichier `build.gradle` contient la configuration du projet avec notamment la classe contenant la méthode `main` à exécuter.

## Copyrights

Image provenant de [Larry Ewing](lewing@isc.tamu.edu) and The GIMP