package juin25;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class Complexe {

	private HashMap<Integer,ProducteurMusique> mapProducteursMusiquePresents;
	private Studio[] tableStudios;
	private ArrayDeque<Studio> fileStudiosLibres;

	/**
	 * construit un complexe de studios d'enregistrements contenant nombreStudios
	 * @param nombreStudios le nombre de studios
	 * @throws IllegalArgumentException si le nombre de studios est negatif ou nul
	 */
	public Complexe(int nombreStudios) {
		if(nombreStudios<=0)
			throw new IllegalArgumentException();
		mapProducteursMusiquePresents = new HashMap<>();
		tableStudios = new Studio[nombreStudios];
		fileStudiosLibres = new ArrayDeque<>();
		for (int i = 0; i < nombreStudios; i++) {
			Studio studio = new Studio(i);
			tableStudios[i]=studio;
			fileStudiosLibres.add(studio);
		}
	}


	/**
	 * renvoie le nombre de studios libres
	 * @return le nombre de studios libres
	 */
	public int nombreStudiosLibres(){
		//TODO
		return 	fileStudiosLibres.size();
	}


	/**
	 * renvoie le producteur de musique dont le numero est passe en parametre
	 * @param numeroProducteurMusique le numero du producteur de musique recherche
	 * @return le producteur de musique recherche ou null si aucun producteur present ne possede ce numero
	 *
	 */
	public ProducteurMusique getProducteurMusique(int numeroProducteurMusique){
		//TODO
		if (mapProducteursMusiquePresents.isEmpty() || !mapProducteursMusiquePresents.containsKey(numeroProducteurMusique)){
			return null;
		}
		return mapProducteursMusiquePresents.get(numeroProducteurMusique);
	}


	/**
	 * attribue un studio au producteur de musique passe en parametre
	 * Si l'attribution a pu se faire :
	 * le producteur de musique est enregistre comme present (si pas encore present)
	 * le studio lui est ajoute
	 * @param numeroProducteurMusique le numero du producteur de musique
	 * @param nomProducteurMusique le nom du producteur de musique
	 * @return le numero du studio attribue ou -1 s'il n'y en a plus de libre
	 */
	public int attribuerStudio(int numeroProducteurMusique, String nomProducteurMusique) {
		// TODO
		if (fileStudiosLibres.isEmpty()) {
			return -1;
		}
		if (!mapProducteursMusiquePresents.containsKey(nomProducteurMusique)) {
			//mapProducteursMusiquePresents.put(mapProducteursMusiquePresents.size(), )
		}
		return 0;
	}


	/**
	 * libere le studio dont le numero est passe en parametre
	 * Si, apres suppression, le producteur de musique n'a plus de studio, il doit etre retire des producteurs presents
	 * @param numeroStudio
	 * @return le producteur de musique qui occupait le studio avant liberation ou null si le studio n'etait pas occupe
	 * @throws IllegalArgumentException si aucun studio ne porte ce numero
	 */
	public ProducteurMusique libererStudio(int numeroStudio){
		//TODO
		return null;
	}

	//pour le debug
	//inutile
	@Override
	public String toString() {
		return "mapProducteursMusiquePresents : " + mapProducteursMusiquePresents +
				"\ntableStudios : " + Arrays.toString(tableStudios) +
				"\nfileStudiosLibres : " + fileStudiosLibres;
	}
}
