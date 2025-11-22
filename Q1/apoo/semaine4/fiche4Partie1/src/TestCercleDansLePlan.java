public class TestCercleDansLePlan {
    public static void main(String[] args) {
        Point centre = new Point(4, 2);
        // 1
        CercleDansLePlan c1 = new CercleDansLePlan(4, centre);
        // 2
        System.out.println(c1);

        CercleDansLePlan c2 = new CercleDansLePlan(centre);
        // 3
        System.out.println(c2);
        CercleDansLePlan c3 = new CercleDansLePlan();
        System.out.println(c3);


        c2.getCentre().setX(8);
        System.out.println("Après modification du centre de c2 :");
        System.out.println(c1);
        System.out.println(c2);

    }
}
