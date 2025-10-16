public class TestCercleDansLePlan {
    public static void main(String[] args) {
        Point p = new Point(4, 2);
        CercleDansLePlan c1 = new CercleDansLePlan(4, p);
        CercleDansLePlan c2 = new CercleDansLePlan(p);

        System.out.println(c1);
        System.out.println(c2);

        c2.getCentre().setX(8);
        System.out.println("Après modification du centre de c2 :");
        System.out.println(c1);
        System.out.println(c2);
    }
}
