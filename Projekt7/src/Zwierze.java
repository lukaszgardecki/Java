public class Zwierze {
    String imie;
    String glos = "Grrrrrr";

    public void dajGlos(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println(glos);
            System.out.println("");
        }
        System.out.println();
    }

    public void przedstawSie() {
        System.out.println("Nazywam sie " + imie);
    }
}
