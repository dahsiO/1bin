import java.util.Arrays;

public class TestParking {

	public static void main(String[] args) {	
		System.out.println("*************************************");
		System.out.println("Programme Test pour la classe Parking");
		System.out.println("*************************************");

        System.out.println();
        System.out.println("Les tests suivent un scenario : ");
        System.out.println();

        Parking e = new Parking();
		System.out.println("Test 1 : ajout des voitures 1AAA000(pA), 1BBB000(pB), 1AAA999(pA), 1CCC000(pC)");
		System.out.println("Ajout 1AAA000(pA)");
		if(!e.ajouterVoiture("1AAA000", new Proprietaire("pA"))){
			System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1AAA000");
            System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println(e);
		if(!e.toString().equals("{1AAA000=pA}")){
			System.out.println("Attention le contenu du map n'est pas le contenu attendu");
			System.out.println("Attendu : {1AAA000=pA}");
            System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println("Ajout 1BBB000");
		if(!e.ajouterVoiture("1BBB000",new Proprietaire("pB"))){
            System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1BBB000");
            System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println(e);
		if(!e.toString().equals("{1AAA000=pA, 1BBB000=pB}")){
			System.out.println("Attention le contenu du map n'est pas le contenu attendu");
			System.out.println("Attendu : {1AAA000=pA, 1BBB000=pB}");
            System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}

		System.out.println("Ajout 1AAA999");
		if(!e.ajouterVoiture("1AAA999",new Proprietaire("pA"))){
            System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1AAA999");
            System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println(e);
		if(!e.toString().equals("{1AAA999=pA, 1AAA000=pA, 1BBB000=pB}")){
			System.out.println("Attention le contenu du map n'est pas le contenu attendu");
			System.out.println("Attendu : {1AAA999=pA), 1AAA000=pA, 1BBB000=pB}");
            System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}

		System.out.println("Ajout 1CCC000");
		if(!e.ajouterVoiture("1CCC000",new Proprietaire("pC"))){
            System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1CCC000");
            System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println(e);
		if(!e.toString().equals("{1AAA999=pA, 1CCC000=pC, 1AAA000=pA, 1BBB000=pB}")){
			System.out.println("Attention le contenu du map n'est pas le contenu attendu");
			System.out.println("Attendu : {1AAA999=pA, 1CCC000=pC, 1AAA000=pA, 1BBB000=pB}");
            System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println("Test 1 ok");
		System.out.println();


		System.out.println("Test 2 : ajout de la voitures 1AAA000(pA) deja presente");
		System.out.println(e);
		System.out.println("Ajout 1AAA000(pA)");
		if(e.ajouterVoiture("1AAA000", new Proprietaire("pA"))){
			System.out.println("Attention votre methode annonce avoir ajoute la voiture 1AAA000");
            System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println(e);
		if(!e.toString().equals("{1AAA999=pA, 1CCC000=pC, 1AAA000=pA, 1BBB000=pB}")){
			System.out.println("Attention le contenu du map n'est pas le contenu attendu");
			System.out.println("Attendu : {1AAA999=pA, 1CCC000=pC, 1AAA000=pA, 1BBB000=pB}");
            System.out.println("Revoyez votre methode ajouterVoiture()");
			return;
		}
		System.out.println("Test 2 ok");
		System.out.println();


		System.out.println("Test 3 : verification de l'autorisation des voitures 1AAA000, 1BBB000, 1AAA999, 1CCC000");
		System.out.println(e);
		System.out.println("Verification 1AAA000");
		if(! e.voitureAutorisee("1AAA000")){
			System.out.println("Attention, votre methode annonce que la voiture 1AAA000 est non autorisee !");
            System.out.println("Revoyez votre methode voitureAutorisee()");
			return;
		}
		System.out.println("Verification 1BBB000");
		if(! e.voitureAutorisee("1BBB000")){
			System.out.println("Attention, votre methode annonce que la voiture 1BBB000 est non autorisee !");
            System.out.println("Revoyez votre methode voitureAutorisee()");
			return;
		}
		System.out.println("Verification 1CCC000");
		if(! e.voitureAutorisee("1CCC000")){
			System.out.println("Attention, votre methode annonce que la voiture 1CCC000 est non autorisee !");
            System.out.println("Revoyez votre methode voitureAutorisee()");
			return;
		}
		System.out.println("Verification 1AAA999");
		if(! e.voitureAutorisee("1AAA999")){
			System.out.println("Attention, votre methode annonce que la voiture 1AAA999 est non autorisee !");
            System.out.println("Revoyez votre methode voitureAutorisee()");
			return;
		}

		System.out.println("Test 3 ok");
		System.out.println();


		System.out.println("Test 4 : verification de la non autorisation de la voiture 1DDD000");
		System.out.println(e);
		System.out.println("Verification 1DDD000");
		if(e.voitureAutorisee("1DDD000")){
			System.out.println("Attention, voiture 1DDD000 est non autorisee !");
            System.out.println("Revoyez votre methode voitureAutorisee()");
			return;
		}
		System.out.println("Test 4 ok");
		System.out.println();

		System.out.println("Test 5 : proprietaires des voitures 1AAA000, 1BBB000, 1AAA999, 1CCC000");
		System.out.println(e);
		Proprietaire proprio;
		System.out.println("Proprietaire 1AAA000 : pA");
		proprio = e.donnerProprietaire("1AAA000");
		if(proprio == null){
			System.out.println("Attention, votre methode a renvoye null");
            System.out.println("Revoyez votre methode donnerProprietaire()");
			return;
		}
		if(!proprio.getNom().equals("pA")){
			System.out.println("Attention, votre methode annonce le proprietaire "+proprio);
            System.out.println("Revoyez votre methode donnerProprietaire()");
			return;
		}

		System.out.println("Proprietaire 1BBB000 : pB");
		proprio = e.donnerProprietaire("1BBB000");
		if(proprio == null){
			System.out.println("Attention, votre methode a renvoye null");
            System.out.println("Revoyez votre methode donnerProprietaire()");
			return;
		}
		if(!proprio.getNom().equals("pB")){
			System.out.println("Attention, votre methode annonce le proprietaire "+proprio);
            System.out.println("Revoyez votre methode donnerProprietaire()");
			return;
		}

		System.out.println("Proprietaire 1AAA999 : pA");
		proprio = e.donnerProprietaire("1AAA999");
		if(proprio == null){
			System.out.println("Attention, votre methode a renvoye null");
            System.out.println("Revoyez votre methode donnerProprietaire()");
			return;
		}
		if(!proprio.getNom().equals("pA")){
			System.out.println("Attention, votre methode annonce le proprietaire "+proprio);
            System.out.println("Revoyez votre methode donnerProprietaire()");
			return;
		}

		System.out.println("Proprietaire 1CCC000 : pC");
		proprio = e.donnerProprietaire("1CCC000");
		if(proprio == null){
			System.out.println("Attention, votre methode a renvoye null");
            System.out.println("Revoyez votre methode donnerProprietaire()");
			return;
		}
		if(!proprio.getNom().equals("pC")){
			System.out.println("Attention, votre methode annonce le proprietaire "+proprio);
            System.out.println("Revoyez votre methode donnerProprietaire()");
			return;
		}
		System.out.println("Test 5 ok");
		System.out.println();


		System.out.println("Test 6 : proprietaires de la voiture 1XXX000 inexistante");
		System.out.println(e);
		System.out.println("Proprietaire 1XXX000 : null");
		proprio = e.donnerProprietaire("1XXX000");
		if(proprio != null){
			System.out.println("Attention, votre methode a renvoye null");
            System.out.println("Revoyez votre methode donnerProprietaire()");
            return;
		}
		System.out.println("Test 6 ok");
		System.out.println();


		System.out.println("Test 7 : table triee avec les plaques autorisees");
		System.out.println(e);
		System.out.println("Table attendue : [1AAA000, 1AAA999, 1BBB000, 1CCC000]");
		String[]tableRecue = e.tableTrieePlaques();
		if(tableRecue==null){
			System.out.println("Attention la table est null");
            System.out.println("Revoyez votre methode tableTrieePlaques()");
            return;
		}
		if(Arrays.toString(tableRecue).equals("[1AAA999, 1CCC000, 1AAA000, 1BBB000]")){
			System.out.println("Table recue    : "+Arrays.toString(tableRecue));
			System.out.println("Attention la table est non triee");
            System.out.println("Revoyez votre methode tableTrieePlaques()");

            return;
		}
		if(!Arrays.toString(tableRecue).equals("[1AAA000, 1AAA999, 1BBB000, 1CCC000]")){
			System.out.println("Table recue    : "+Arrays.toString(tableRecue));
			System.out.println("Attention le contenu de la table est ko");
            System.out.println("Revoyez votre methode tableTrieePlaques()");
            return;
		}
		System.out.println("Test 7 ok");
		System.out.println();

		System.out.println("Test 8 : suppression de la voiture 1CCC000");
		System.out.println(e);
		if(!e.retirerVoiture("1CCC000")){
			System.out.println("la voiture est presente dans le map, mais votre methode annonce ne pas l'avoir retiree");
            System.out.println("Revoyez votre methode retirerVoiture()");
            return;
		}
		System.out.println(e);
		if(!e.toString().equals("{1AAA999=pA, 1AAA000=pA, 1BBB000=pB}")){
			System.out.println("Attention le contenu du map n'est pas le contenu attendu");
			System.out.println("Attendu : {1AAA999=pA, 1AAA000=pA, 1BBB000=pB}");
            System.out.println("Revoyez votre methode retirerVoiture()");
            return;
		}

		if(e.voitureAutorisee("1CCC000")){
			System.out.println("Attention, apres suppression, la voiture 1CCC000 est toujours autorisee !");
            System.out.println("Revoyez votre methode retirerVoiture() et/ou voitureAutorisee()");

            return;
		}
		System.out.println("Test 8 ok");
		System.out.println();

		System.out.println("Test 9 : suppression de la voiture 1CCC000 qui vient d'etre supprimee");
		System.out.println(e);
		if(e.retirerVoiture("1CCC000")){
			System.out.println("la voiture n'etait plus presente, mais votre methode l'annonce l'avoir retiree");
            System.out.println("Revoyez votre methode retirerVoiture()");
            return;
		}
		System.out.println(e);
		if(!e.toString().equals("{1AAA999=pA, 1AAA000=pA, 1BBB000=pB}")){
			System.out.println("Attention le contenu du map n'est pas le contenu attendu");
			System.out.println("Attendu : {1AAA999=pA, 1AAA000=pA, 1BBB000=pB}");
            System.out.println("Revoyez votre methode retirerVoiture()");
            return;
		}
		System.out.println("Test 9 ok");
		System.out.println();


		System.out.println("Fin des tests");

	}


}
