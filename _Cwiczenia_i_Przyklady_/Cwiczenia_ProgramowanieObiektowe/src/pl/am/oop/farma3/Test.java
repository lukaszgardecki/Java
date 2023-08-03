package pl.am.oop.farma3;

public class Test {
    public static void main(String[] args) {
        Farma farma = new Farma();

        farma.setPies(new Pies("³atek", 15));
        farma.setKot(new Kot("mruk", 3));

        farma.dodajZwierze(new Kura(1.9));
        farma.dodajZwierze(new Kura(2.1));
        farma.dodajZwierze(new Kura(1.8));
        farma.dodajZwierze(new Kura(2.5));
        farma.dodajZwierze(new Kura(2));
        farma.dodajZwierze(new Krowa(150));
        farma.dodajZwierze(new Krowa(150));

        System.out.println(farma);
        farma.sprzedajKury();
        System.out.println(farma);

    }
}
