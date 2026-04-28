
public class JeuGuerrier {
	
	public static void main(String[] args) {
		EquipeGuerriers equipe = new EquipeGuerriers(3, 10);
		int pointsDeVieDuMal = 30;
		
		// A COMPLETER
        System.out.println("Vous devez programmer le jeu !");

		while (pointsDeVieDuMal > 0 && equipe.nombreGuerriersEnVie() > 0) {

			System.out.println("L'equipe compte " + equipe.nombreGuerriersEnVie() + " guerriers en vie");

//		System.out.println("L'equipe compte guerriers en vie");
//		System.out.println("Suite au combat entre la creature du mal et le guerrier num");
//		System.out.println("Le guerrier vient de perdre points de vie");
//		System.out.println("La creature du mal vient de perdre points de vie");
//		System.out.println("Il lui reste points de vie");
//		System.out.println("Le guerrier est mort");
//		System.out.println("La creature du mal est morte");
//		System.out.println("Tous les guerriers sont morts");
			int deGuerrier = lancerDe();
			int deMal = lancerDe();
			Guerrier guerrier = equipe.jouer(deMal);

			System.out.println("Suite au combat entre la creature du mal et le guerrier num " + guerrier.getNumero());
			System.out.println("Le guerrier vient de perdre " + deMal + " points de vie");
			System.out.println("La creature du mal vient de perdre " + deGuerrier + " points de vie");

			pointsDeVieDuMal -= deGuerrier;

			if (pointsDeVieDuMal <= 0) {
				System.out.println("La creature du mal est morte");
			} else {
				System.out.println("Il lui reste " + pointsDeVieDuMal + " points de vie");
			}

			if (guerrier.getPointsDeVie() <= 0) {
				System.out.println("Le guerrier est mort");
			}
		}

		if (equipe.nombreGuerriersEnVie() == 0 && pointsDeVieDuMal > 0) {
			System.out.println("Tous les guerriers sont morts");
		}
	}
	public static int lancerDe (){
		double nombreReel;
		nombreReel = Math.random();
		return (int) (nombreReel * 6) + 1;
	}
	
}
