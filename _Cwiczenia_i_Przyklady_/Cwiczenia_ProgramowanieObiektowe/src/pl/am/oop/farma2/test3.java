package pl.am.oop.farma2;

public class test3 {
    public static void main(String[] args) {
        Farma farma = new Farma();

        farma.setPies(new Pies("³atek", 15));
        farma.setKot(new Kot("mruk", 3));

        farma.dodajZwierze(new Kura(1));
        farma.dodajZwierze(new Kura(1));
        farma.dodajZwierze(new Kura(1));
        farma.dodajZwierze(new Kura(1));
        farma.dodajZwierze(new Kura(1));
        farma.dodajZwierze(new Krowa(150));
        farma.dodajZwierze(new Krowa(150));
        farma.dodajZwierze(new Krowa(150));
        farma.dodajZwierze(new Krowa(150));
        farma.dodajZwierze(new Krowa(150));
        farma.dodajZwierze(new Krowa(150));
        farma.dodajZwierze(new Krowa(150));

        System.out.println("Mam " + farma.getIloscKrow() + " krów, oraz " + farma.getIloscKur() + " kur");


        System.out.println("Kury: ");
        Farma.wypiszZwierzeta(farma.getKury());

        System.out.println("Krowy: ");
        Farma.wypiszZwierzeta(farma.getKrowy());
    }
}
