
# Premier environnement de travail

## Installation

Dans le dossier principal, lancer la commande

```bash
npm install
```

Il devrait résulter l'apparition d'un nouveau dossier "node_modules".

<!-- Pour installer typescript sur une machine, il faut tapper dans un terminal :

```bash
npm i -g typescript
```

Pour vérifier que celle-ci c'est bien passé, il suffit de tapper dans le terminal :

```bash
tsc -v
``` -->

## Génération du code Javascript

Pour générer du code Javascript il faut lancer la commande~:

```bash
npm run build
```

Il devrait résulter un nouveau dossier `exec` contenant les versions Javascript
des fichiers TypeScript présents dans votre dossier `src`.

## Éxecutez du code Javascript

Pour exécuter du code Javascript en dehors du navigateur, nous allons utiliser
l'environnement Node. Pour exectuer un fichier Javascript lancer la commande

```bash
node <nom_du_fichier>
```

Par exemple :

```bash
nonde exec/ex1.js
```
