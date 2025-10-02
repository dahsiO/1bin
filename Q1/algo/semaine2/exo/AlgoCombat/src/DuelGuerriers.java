public class DuelGuerriers {

	public static void main(String[] args) {

		int pointsDeVieCogneDur = lancerDe();
		System.out.println("CogneDur a " + pointsDeVieCogneDur + " points de vie");
		int pointsDeVieFrappeFort = lancerDe();
		System.out.println("FrappeFort a " + pointsDeVieFrappeFort + " points de vie");

		int degatFrappeFort = lancerDe();
		int degatCogneDur = lancerDe();
		// A COMPLETER
		//cognedur met la premiere droite





			// CogneDur attaque
			System.out.println("CogneDur attaque et met " + degatFrappeFort + " de degats à FrappeFort");
			pointsDeVieFrappeFort -= degatFrappeFort;

			if (pointsDeVieFrappeFort <= 0) {
				System.out.println("FrappeFort est mort !");
				System.out.println("CogneDur a gagné !");

			} else {



			// FrappeFort attaque
			System.out.println("FrappeFort attaque et met " + degatCogneDur + " de degats à CogneDur");
			pointsDeVieCogneDur -= degatCogneDur;

			if (pointsDeVieCogneDur <= 0) {
				System.out.println("CogneDur est mort !");
				System.out.println("FrappeFort a gagné !");

			}
	}

			System.out.println("Il reste " + pointsDeVieCogneDur + " PV à CogneDur et "
					+ pointsDeVieFrappeFort + " PV à FrappeFort.");
		}


	public static int lancerDe() {
		return (int) ((Math.random() * 6) + 1);
	}
}