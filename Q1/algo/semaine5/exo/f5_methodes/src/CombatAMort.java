public class CombatAMort {

    public static void main(String[] args) {
        System.out.println("Bienvenue au combat entre CogneDur et FrappeFort");
        int pointsDeVieCogneDur = 25;
        int pointsDeVieFrappeFort = 25;
        while(pointsDeVieCogneDur>0 && pointsDeVieFrappeFort>0){
            int de = unEntierAuHasardEntre(1,6);
            System.out.println("CogneDur inflige "+de+" points de degats a FrappeFort.");
            pointsDeVieFrappeFort = pointsDeVieFrappeFort-de;
            if(pointsDeVieFrappeFort <= 0){
                System.out.println("Il reste 0 point de vie a FrappeFort.");
                System.out.println("FrappeFort est mort. Paix a son ame, il est mort en brave");
            }else{
                System.out.println("Il reste "+pointsDeVieFrappeFort+ " points de vie a FrappeFort.");

                de = unEntierAuHasardEntre(1,6);
                System.out.println("FrappeFort inflige "+de+" points de degats a CogneDur.");
                pointsDeVieCogneDur = pointsDeVieCogneDur-de;
                if(pointsDeVieCogneDur<=0){
                    System.out.println("Il reste 0 point de vie a CogneDur.");
                    System.out.println("CogneDur est mort. Paix a son ame, il est mort en brave");
                }
                else{
                    System.out.println("Il reste "+pointsDeVieCogneDur+ " points de vie a CogneDur.");
                }
            }
        }
    }

    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
