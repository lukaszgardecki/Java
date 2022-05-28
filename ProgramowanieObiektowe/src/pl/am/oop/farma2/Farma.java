package pl.am.oop.farma2;

import java.util.ArrayList;

//Agregacja, wyst�puje wtedy gdy dana klasa ma jak�� klas�. Farma ma kota. Farma ma psa.
public class Farma {
    private Kot kot;
    private Pies pies;
    private ArrayList<Zwierze> kury = new ArrayList<>();
    private ArrayList<Zwierze> krowy = new ArrayList<>();

    public Kot getKot() {
        return kot;
    }

    public void setKot(Kot kot) {
        this.kot = kot;
    }

    public Pies getPies() {
        return pies;
    }

    public void setPies(Pies pies) {
        this.pies = pies;
    }

    public ArrayList<Zwierze> getKury() {
        return kury;
    }

    public ArrayList<Zwierze> getKrowy() {
        return krowy;
    }

    public int getIloscKur() {
        return kury.size();
    }

    public int getIloscKrow() {
        return krowy.size();
    }


    //Dodawanie zwierzat. Metoda jedna og�lna:
//    public void dodajZwierze(Zwierze zwierze) {
//        if (zwierze instanceof Krowa) {
//            krowy.add(zwierze);
//        }
//        if (zwierze instanceof Kura) {
//            kury.add(zwierze);
//        }
//    }

    //Dodawanie zwierz�t. Zamiana metody powy�ej, kt�ra jest bardziej og�lna, na dwie mniejsze poni�ej:
    public void dodajZwierze(Kura kura) {
        kury.add(kura);
    }
    public void dodajZwierze(Krowa krowa) {
        krowy.add(krowa);
    }



    public static void wypiszZwierzeta(ArrayList<Zwierze> zwierzeta) {
        for (Zwierze zwierze : zwierzeta) {
            System.out.println(zwierze);
        }
    }
}
