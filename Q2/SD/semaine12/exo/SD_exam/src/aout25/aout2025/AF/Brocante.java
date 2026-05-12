package aout25.aout2025.AF;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Brocante {

    private int phase;
    private Emplacement[] tableEmplacements;
    private HashMap<String, HashSet<Integer>> mapRiverains;
    private ArrayDeque<Emplacement> fileEmplacementsLibres; //pour les attributions en phase 2



	/**
	 * initialise une brocante avec nombre emplacements
	 * @param nombreEmplacements le nombre d'emplacements
	 * @param ensembleRiverains l'ensemble des riverains
	 * @throws IllegalArgumentException si le nombre d'emplacements est negatif ou nul ou si l'ensemble des riverains est null
	 */
	public Brocante(int nombreEmplacements, HashSet<String> ensembleRiverains) {

		if (nombreEmplacements <= 0 || ensembleRiverains == null) {
			throw new IllegalArgumentException();
		}

		this.phase=1;

		tableEmplacements = new Emplacement[nombreEmplacements];
		for (int i = 0; i < nombreEmplacements; i++) {
			tableEmplacements[i] = new Emplacement(i);
		}

		mapRiverains = new HashMap<>();
		for (String nomRiverain : ensembleRiverains) {
			mapRiverains.put(nomRiverain,new HashSet<>());
		}

		fileEmplacementsLibres = new ArrayDeque<>(); //file remplie lors du changement de phase

	}

	public int getPhase() {
		return phase;
	}

	/**
	 * reserve l'emplacement qui porte le numero passe en parametre au demandeur passe en parametre
	 * La reservation reussit si
	 *     l'emplacement est libre
	 *     le demandeur est bien un riverain
	 *     le riverain n'a pas encore 3 emplacements
	 * @param demandeur le nom de la personne qui demande un emplacement
	 * @param numeroEmplacement le numero de l'emplacement souhaite
	 * @return true si la reservation a reussi, false sinon
	 * @throws IllegalArgumentException si le demandeur est null ou si numero de l'emplacement n'existe pas
	 * @throws IllegalStateException si on n'est pas en phase 1
	 */
	public boolean reserverPhase1(String demandeur, int numeroEmplacement) {
		//TODO
		if (demandeur == null || numeroEmplacement < 1 || numeroEmplacement >= tableEmplacements.length) {
			throw new IllegalArgumentException();
		}
		if (phase != 1) {
			throw new IllegalStateException();
		}
		// L'emplacement doit être libre
		if (tableEmplacements[numeroEmplacement].getNomRiverain() != null) {
			return false;
		}
		// Le demandeur doit être un riverain connu
		if (!mapRiverains.containsKey(demandeur)) {
			return false;
		}
		// Le riverain ne doit pas avoir déjà 3 emplacements
		if (mapRiverains.get(demandeur).size() >= 3) {
			return false;
		}

		// Tout est bon : on réserve
		tableEmplacements[numeroEmplacement].setNomRiverain(demandeur);
		mapRiverains.get(demandeur).add(numeroEmplacement);
		return true;
	}
	/**
	 * a comme effet de passer de la phase 1 a la phase 2
	 * si deja en phase 2, rien ne doit etre fait
	 */
	public void changerPhase() {
		//TODO
		//Pensez a remplir la file!!!
		if (phase == 2) {
			return;
		}
		phase = 2;
		for (int i = 0; i < tableEmplacements.length; i++) {
			if (tableEmplacements[i].getNomRiverain() == null) {
				fileEmplacementsLibres.addLast(tableEmplacements[i]);
			}
		}
	}

	/**
	 * attribue automatiquement un emplacement libre au demandeur passe en parametre
	 * la reservation reussit si
	 *     le demandeur est bien un riverain
	 *     il y a encore des emplacements de libre
	 * @param demandeur le nom de la personne qui demande un emplacement
	 * @return le numero de l'emplacement attribue ou -1 si la reservation a echoue
	 * @throws IllegalArgumentException si le demandeur est null
	 * @throws IllegalStateException si on n'est pas en phase 2
	 */
	public int reserverPhase2(String demandeur) {
		//TODO
		if (demandeur == null) throw new IllegalArgumentException();
		if (phase != 2) throw new IllegalStateException();

		if (!mapRiverains.containsKey(demandeur)) return -1; // pas un riverain
		if (fileEmplacementsLibres.isEmpty()) return -1; // plus de place

		Emplacement emp = fileEmplacementsLibres.poll();
		emp.setNomRiverain(demandeur);
		mapRiverains.get(demandeur).add(emp.getNumeroEmplacement());
		return emp.getNumeroEmplacement();
	}

	//Pour le debug
	public String donnerTableEmplacements() {
		if(tableEmplacements==null)
			return "table est a null";
		return "tableEmplacements : \n"+Arrays.toString(tableEmplacements);
	}

	//Pour le debug
	public String donnerMapRiverains() {
		if(mapRiverains ==null)
			return "mapRiverains est a null";
		return "mapRiverains : \n"+ mapRiverains.toString();
	}

	//Pour le debug
	public String donnerFileEmplacementsLibres() {
		if(fileEmplacementsLibres==null)
			return "fileEmplacementsLibres est a null";
		return "fileEmplacementsLibres : \n"+fileEmplacementsLibres.toString();
	}

}
