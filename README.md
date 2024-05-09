# poulailler

Ce projet consiste en une simulation d'une ferme, développée en Java. Il comprend plusieurs classes définissant des types de volailles (Poulet et Canard) ainsi qu'une classe Ferme pour gérer ces volailles.

**Classes principales :**

1. **Volaille :** Cette classe abstraite définit les attributs communs des volailles (identifiant, poids, âge) et des méthodes telles que `estPretPourAbattage()` et `prix()`, qui sont redéfinies dans les classes filles.

2. **Poulet :** Une sous-classe de Volaille qui représente les poulets. Elle hérite des attributs de Volaille et définit ses propres méthodes pour le calcul du prix et la vérification de sa disponibilité pour l'abattage.

3. **Canard :** Une sous-classe de Volaille qui représente les canards. Comme Poulet, elle hérite de Volaille et définit des méthodes spécifiques pour le calcul du prix et la vérification de sa disponibilité pour l'abattage.

4. **Ferme :** Cette classe gère un ensemble de volailles. Elle permet d'ajouter de nouvelles volailles, de trier celles prêtes pour l'abattage, et d'évaluer le prix total des volailles à abattre.

**Fonctionnalités principales :**

- **Ajout de Volaille :** La méthode `ajouterVolaille()` permet d'ajouter de nouvelles volailles à la ferme.

- **Tri des Volailles :** La méthode `AnimauxEnvoyerALabatoir()` trie les volailles prêtes pour l'abattage.

- **Évaluation du Prix :** La méthode `evalPrix()` calcule le prix total des volailles à abattre.

- **Simulation :** Le fichier de test (`Test.java`) démontre l'utilisation des différentes fonctionnalités en créant des instances de Poulet et de Canard, en les manipulant (modification des poids, des prix, etc.), et en les ajoutant à une ferme pour évaluation.

**Utilité :**

Ce projet sert de simulation pour une ferme virtuelle. Il démontre comment organiser et gérer des volailles dans un contexte agricole, en fournissant des fonctionnalités pour gérer les animaux prêts à être abattus et pour estimer le prix total basé sur certains critères. Ce type de système peut être utilisé dans le cadre de simulations agricoles, d'applications de gestion d'élevage, ou pour illustrer des concepts de programmation orientée objet en Java.
