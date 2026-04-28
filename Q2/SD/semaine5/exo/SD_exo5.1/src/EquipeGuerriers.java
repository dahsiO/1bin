import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class EquipeGuerriers {

	private ArrayList<Guerrier> vecteurGuerriers;
	private LinkedList<Guerrier> listeGuerriersEnJeu;
	private int pointsDeVieDeDepart;

	/**
	 * construit l'equipe 
	 * @param nombreGuerriers nombre de guerriers en vie au debut du jeu
	 * @param pointsDeVieDeDepart nombre de points de vie attribue a chaque guerrier au debut du jeu
	 * @throws IllegalArgumentException il faut au moins 1 guerrier vivant pour combattre la creature du mal
	 */
	public EquipeGuerriers(int nombreGuerriers, int pointsDeVieDeDepart){

		// TODO
		if (nombreGuerriers <= 0) {
			throw new IllegalArgumentException("il faut au minimum 1G en vie");
		}
		this.pointsDeVieDeDepart = pointsDeVieDeDepart;
		this.vecteurGuerriers = new ArrayList<>();
		this.listeGuerriersEnJeu = new LinkedList<>();
		for (int i = 0; i < nombreGuerriers; i++) {
			Guerrier g = new Guerrier(i,pointsDeVieDeDepart);
			vecteurGuerriers.add(g);
			listeGuerriersEnJeu.add(g);
		}

	
	} 
			//la tech de recursiviter ici
	/**
	 * renvoie le nombre de guerriers encore en vie
	 * @return le nombre de guerriers encore en vie
	 */
	public int nombreGuerriersEnVie(){

		return nombreGuerriersEnVie(0);
		// TODO
	}
	private int nombreGuerriersEnVie(int index){
		if (index == vecteurGuerriers.size()) { // finie de parcourir tous le vecteur
			return 0;
		}
		int estEnVie = vecteurGuerriers.get(index).getPointsDeVie() > 0 ? 1 : 0;
		return estEnVie + nombreGuerriersEnVie(index + 1);
	}
	
	/**
	 * selectionne un guerrier, lui diminue son nombre de points de vie et le remet en jeu s'il n'est pas mort
	 * @param pointsDeViePerdus le nombre perdu par le guerrier au combat
	 * @return le guerrier qui a combattu
	 * @throws NoSuchElementException si tous les guerriers sont morts
	 * @throws IllegalArgumentException le nombre de points de vie perdus est un nombre <= 0
	 */
	public Guerrier jouer(int pointsDeViePerdus){
		if (pointsDeViePerdus <= 0) {
			throw new IllegalArgumentException("point de vie perdu dois etre positif");
		}
		if (listeGuerriersEnJeu.isEmpty()) {
			throw new NoSuchElementException("tous les guerrier sont morts");
		}
		// le premiere guerrier a combattre sort de la liste combattre
		Guerrier g = listeGuerriersEnJeu.removeFirst();
		// il subit des attaque
		g.setPointsDeVie(g.getPointsDeVie() - pointsDeViePerdus);
		// si il parvient a survire a ces blessure
		if (g.getPointsDeVie() > 0) {
			// il rintegre la liste des combatant toujours en vie en fin de liste
			listeGuerriersEnJeu.addLast(g);
		}
		return g;
		// TODO

	}
	
	/**
	 * renvoie le guerrier dont le numero est passe en parametre, meme s'il est mort
	 * @param numero le numero du guerrier demande
	 * @return le guerrier qui a comme numero le numero passe en parametre
	 * @throws IllegalArgumentException le numero n'a pas ete attribue
	 */
	public Guerrier getGuerrier(int numero){

		return getGuerrier(numero , 0);
		// TODO

	}
	private Guerrier getGuerrier(int numero , int index){
		if (index == vecteurGuerriers.size()) {
			throw new IllegalArgumentException("numero non attribuer : "+ numero);
		}
		if (vecteurGuerriers.get(index).getNumero() == numero) {
			return vecteurGuerriers.get(index);
		}
		return getGuerrier(numero,index+1);
	}
	
	
	/**
	 * ajoute un nouveau guerrier dans l'equipe
	 * ce guerrier recoit un numero non attribue et le nombre de points de vie de depart
	 * ce guerrier va prendre place au combat en se placant apres le guerrier vivant qui porte le numero juste plus petit que lui
	 * Par exemple : g4 est mort et ordre des combats : g3 g1 g2 , le nouveau guerrier va se placer entre g3 et g1
	 * @return le numero du guerrier ajoute
	 */
	public int ajouterNouveauGuerrier(){
		
		return 0;
		// TODO
		// Ex A3
		// Ecrivez d'abord la classe JeuGuerriers avant d'ecrire cette methode
	
	}
	
	// Attention : seul interet de ce toString() : les tests!!!
	// A NE PAS MODIFIER
	public String toString(){
		return "vecteur :\n"+vecteurGuerriers.toString()+"\nliste :\n"+listeGuerriersEnJeu.toString();
	}

	// Attention : seul interet de ce constructeur : les tests!!!
	// A NE PAS MODIFIER
	public EquipeGuerriers(ArrayList<Guerrier> vecteurGuerriers,
						   LinkedList<Guerrier> listeGuerriersEnJeu, int pointsDeVieDeDepart) {
		super();
		this.vecteurGuerriers = vecteurGuerriers;
		this.listeGuerriersEnJeu = listeGuerriersEnJeu;
		this.pointsDeVieDeDepart = pointsDeVieDeDepart;
	}
	
	
}
