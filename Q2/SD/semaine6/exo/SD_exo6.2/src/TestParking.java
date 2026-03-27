import java.util.Arrays;

public class TestParking {

	public static void main(String[] args) {

		System.out.println("*************************************");
		System.out.println("Programme Test pour la classe Parking");
		System.out.println("*************************************");
		System.out.println();
		System.out.println("Les tests suivent un scenario : ");
		System.out.println();

		Parking parking = new Parking();
		Voiture p1AAA000 = new Voiture("1AAA000","pA");
		Voiture p1BBB000 = new Voiture("1BBB000","pB");
		Voiture p1CCC000 = new Voiture("1CCC000","pC");
		Voiture p1AAA999 = new Voiture("1AAA999","pA");

		try {
			System.out.println("Voici les voitures autorisees : ");
			System.out.println(parking);
		}catch (Exception e){
			System.out.println("Attention, l'ensemble n'a pas ete cree");
			System.out.println("Revoyez votre constructeur");
			return;
		}

		System.out.println();
		System.out.println("Test 1 : ajout des voitures 1AAA000, 1BBB000, 1AAA999, 1CCC000");
		System.out.println("Ajout 1AAA000");
		if(!parking.ajouterVoiture(p1AAA000)){
			System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1AAA000");
			System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		if(!parking.toString().equals("[1AAA000(pA)]")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA000(pA)]");
			System.out.println("Recu : "+parking);
			System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println("Ajout 1BBB000");
		if(!parking.ajouterVoiture(p1BBB000)){
			System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1BBB000");
			System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		if(!parking.toString().contains("1AAA000(pA)") ||
		   !parking.toString().contains("1BBB000(pB)") ){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA000(pA), 1BBB000(pB)]");
			System.out.println("Recu : "+parking);
			System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println("Ajout 1AAA999");
		if(!parking.ajouterVoiture(p1AAA999)){
			System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1AAA999");
			System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		if(!parking.toString().contains("1AAA999(pA)") ||
		   !parking.toString().contains("1AAA000(pA)") ||
		   !parking.toString().contains("1BBB000(pB)")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA999(pA), 1AAA000(pA), 1BBB000(pB)]");
			System.out.println("Recu : "+parking);
			System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println("Ajout 1CCC000");
		if(!parking.ajouterVoiture(p1CCC000)){
			System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1CCC000");
			System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		if(!parking.toString().contains("1AAA999(pA)") ||
  		   !parking.toString().contains("1AAA000(pA)") ||
		   !parking.toString().contains("1BBB000(pB)") ||
		   !parking.toString().contains("1CCC000(pC)")) {
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA999(pA), 1CCC000(pC), 1AAA000(pA), 1BBB000(pB)]");
			System.out.println("Recu : "+parking);
			System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println("Test 1 ok");
		System.out.println();

		System.out.println("Voici les voitures autorisees : ");
		System.out.println(parking);
		System.out.println();
		System.out.println("Test 2 : ajout de la voiture 1AAA000 (qui y est deja!)");
		if(parking.ajouterVoiture(new Voiture("1AAA000",""))){
			System.out.println("Attention votre methode annonce avoir ajoute la voiture 1AAA000");
			System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println("Test 2 ok");
		System.out.println();

		System.out.println("Voici les voitures autorisees : ");
		System.out.println(parking);
		System.out.println("Test 3 : verification de l'autorisation des voitures 1AAA000, 1BBB000, 1AAA999, 1CCC000");
		System.out.println("Verification 1AAA000");
		if(! parking.voitureAutorisee(new Voiture("1AAA000",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1AAA000 est non autorisee !");
			System.out.println("Revoyez votre methode voitureAutorisee()");
			return;
		}
		System.out.println("Verification 1BBB000");
		if(! parking.voitureAutorisee(new Voiture("1BBB000",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1BBB000 est non autorisee !");
			System.out.println("Revoyez votre methode voitureAutorisee()");
			return;
		}
		System.out.println("Verification 1CCC000");
		if(! parking.voitureAutorisee(new Voiture("1CCC000",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1CCC000 est non autorisee !");
			System.out.println("Revoyez votre methode voitureAutorisee()");
			return;
		}
		System.out.println("Verification 1AAA999");
		if(! parking.voitureAutorisee(new Voiture("1AAA999",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1AAA999 est non autorisee !");
			System.out.println("Revoyez votre methode voitureAutorisee()");
			return;
		}
		System.out.println("Test 3 ok");
		System.out.println();

		System.out.println("Voici les voitures autorisees : ");
		System.out.println(parking);
		System.out.println("Test 4 : verification de la non autorisation de la voiture 1DDD000");
		System.out.println(parking.toString());
		System.out.println("Verification 1DDD000");
		if(parking.voitureAutorisee(new Voiture("1DDD000",""))){
			System.out.println("Attention, voiture 1DDD000 est non autorisee !");
			System.out.println("Revoyez votre methode voitureAutorisee()");
			return;
		}
		System.out.println("Test 4 ok");
		System.out.println();

		System.out.println("Voici les voitures autorisees : ");
		System.out.println(parking);
		System.out.println("Test 5 : table triee avec les plaques autorisees");
		System.out.println("Table attendue : [1AAA000, 1AAA999, 1BBB000, 1CCC000]");
		String[]tableRecue = parking.tableTrieePlaques();
		if(tableRecue==null){
			System.out.println("Attention la table est null");
			System.out.println("Revoyez votre methode tableTrieePlaques()");
			return;
		}
		if(!Arrays.toString(tableRecue).contains("[1AAA000, 1AAA999, 1BBB000, 1CCC000]")){
			System.out.println("Table recue    : "+Arrays.toString(tableRecue));
			System.out.println("Attention le contenu de la table est ko");
			System.out.println("Revoyez votre methode tableTrieePlaques()");
			return;
		}
		System.out.println("Test 5 ok");
		System.out.println();

		System.out.println("Voici les voitures autorisees : ");
		System.out.println(parking);
		System.out.println("Test 6 : suppression de la voiture 1BBB000");
		if(!parking.retirerVoiture(new Voiture("1BBB000",""))){
			System.out.println("la voiture etait presente dans l'ensembleVoitures, mais votre methode annonce ne pas l'avoir retiree");
			System.out.println("Revoyez votre methode retirerVoiture()");
			return;
		}
		if(!parking.toString().contains("1AAA999(pA)") ||
		   !parking.toString().contains("1CCC000(pC)") ||
		   !parking.toString().contains("1AAA000(pA)")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA999(pA), 1CCC000(pC), 1AAA000(pA)]");
			System.out.println("Recu : "+parking);
			System.out.println("Revoyez votre methode retirerVoiture()");
			return;
		}

		if(parking.voitureAutorisee(new Voiture("1BBB000",""))){
			System.out.println("Attention, apres suppression, la voiture 1BBB000 est toujours autorisee !");
			System.out.println("Revoyez votre methode retirerVoiture()");
			return;
		}
		System.out.println("Test 6 ok");
		System.out.println();

		System.out.println("Voici les voitures autorisees : ");
		System.out.println(parking);
		System.out.println("Test 7 : table triee avec les plaques autorisees");
		System.out.println("Table attendue : [1AAA000, 1AAA999, 1CCC000]");
		tableRecue = parking.tableTrieePlaques();
		if(tableRecue==null){
			System.out.println("Attention la table est null");
			System.out.println("Revoyez votre methode tableTrieePlaques()");
			return;
		}
		if(!Arrays.toString(tableRecue).equals("[1AAA000, 1AAA999, 1CCC000]")){
			System.out.println("Table recue    : "+Arrays.toString(tableRecue));
			System.out.println("Attention le contenu de la table est ko");
			System.out.println("Revoyez votre methode tableTrieePlaques()");
			return;
		}
		System.out.println("Test 7 ok");
		System.out.println();

		System.out.println("Voici les voitures autorisees : ");
		System.out.println(parking);
		System.out.println("Test 8 : retrait des voitures 1AAA000, 1AAA999, 1CCC000");
		System.out.println("Retrait 1AAAOO0");
		if(!parking.retirerVoiture(new Voiture("1AAA000",""))){
			System.out.println("la voiture etait presente dans l'ensembleVoitures, mais votre methode annonce ne pas l'avoir retiree");
			System.out.println("Revoyez votre methode retirerVoiture()");
			return;
		}
		if(!parking.toString().contains("1AAA999(pA)") ||
		   !parking.toString().contains("1CCC000(pC)")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1AAA999(pA), 1CCC000(pC)]");
			System.out.println("Recu : "+parking);
			System.out.println("Revoyez votre methode retirerVoiture()");
			return;
		}

		System.out.println("Retrait 1AAA999");
		if(!parking.retirerVoiture(new Voiture("1AAA999",""))){
			System.out.println("la voiture etait presente dans l'ensembleVoitures, mais votre methode annonce ne pas l'avoir retiree");
			System.out.println("Revoyez votre methode retirerVoiture()");
			return;
		}
		if(!parking.toString().equals("[1CCC000(pC)]")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : [1CCC000(pC)]");
			System.out.println("Recu : "+parking);
			System.out.println("Revoyez votre methode retirerVoiture()");
			return;
		}

		System.out.println("Retrait 1CCC000");
		if(!parking.retirerVoiture(new Voiture("1CCC000",""))){
			System.out.println("la voiture etait presente dans l'ensembleVoitures, mais votre methode annonce ne pas l'avoir retiree");
			System.out.println("Revoyez votre methode retirerVoiture()");
			return;
		}
		if(!parking.toString().equals("[]")){
			System.out.println("Attention le contenu de l'ensemble n'est pas le contenu attendu");
			System.out.println("Attendu : []");
			System.out.println("Recu : "+parking);
			System.out.println("Revoyez votre methode retirerVoiture()");
			return;
		}
		System.out.println("Test 8 ok");
		System.out.println();

		System.out.println("Voici les voitures autorisees : ");
		System.out.println(parking);
		System.out.println("Test 9 : table triee avec les plaques autorisees");
		System.out.println("Table attendue : []");
		tableRecue = parking.tableTrieePlaques();
		if(tableRecue==null){
			System.out.println("Attention la table est null");
			System.out.println("Revoyez votre methode tableTrieePlaques()");
			return;
		}
		if(!Arrays.toString(tableRecue).equals("[]")){
			System.out.println("Table recue    : "+Arrays.toString(tableRecue));
			System.out.println("Attention le contenu de la table est ko");
			System.out.println("Revoyez votre methode tableTrieePlaques()");
			return;
		}
		System.out.println("Test 9 ok");
		System.out.println();

		System.out.println("Tous les tests du scenario ont reussi !");

	}

}