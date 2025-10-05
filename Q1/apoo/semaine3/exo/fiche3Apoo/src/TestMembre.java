public class TestMembre {
    public static void main(String[] args) {

        // creation du Membre 1
        Membre membre1 = new Membre("emil", "lecomte","045666666666");
        // verifier si membre 1 renvoie bien false si null
        System.out.println(membre1.Parrain(null));
        // verifie si membre1 renvoie bien false si il est lui meme parrain
        System.out.println(membre1.Parrain(membre1));
        //affiche membre1
        System.out.println(membre1);

        System.out.println("----------------Membre 2---------------");
        Membre membre2 = new Membre("Isabel", "Cambron","0499999999");
        System.out.println(membre1.Parrain(membre2));
        System.out.println(membre1);
        System.out.println("----------------Membre 3---------------");
        Membre membre3 = new Membre("raphael","Baroni","04556677");
        System.out.println(membre1.Parrain(membre3));
        System.out.println(membre1);
    }
}
