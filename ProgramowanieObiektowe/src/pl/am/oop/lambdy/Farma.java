package pl.am.oop.lambdy;

import java.util.ArrayList;

//Agregacja, wystêpuje wtedy gdy dana klasa ma jak¹œ klasê. Farma ma kota. Farma ma psa.
public class Farma {
    private Kot kot;
    private Pies pies;
    private ArrayList<Zwierze> kury = new ArrayList<>();
    private ArrayList<Zwierze> krowy = new ArrayList<>();
    private double pieniadze;
    private static double kuraZaKilogram = 10;

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

    public double getPieniadze() {
        return pieniadze;
    }

    //Dodawanie zwierzat. Metoda jedna ogólna:
//    public void dodajZwierze(Zwierze zwierze) {
//        if (zwierze instanceof Krowa) {
//            krowy.add(zwierze);
//        }
//        if (zwierze instanceof Kura) {
//            kury.add(zwierze);
//        }
//    }

    //Dodawanie zwierz¹t. Zamiana metody powy¿ej, która jest bardziej ogólna, na dwie mniejsze poni¿ej:
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

    public static String getZwierzetaInfo(ArrayList<Zwierze> zwierzeta) {
        StringBuilder info = new StringBuilder();
        for (Zwierze zwierze : zwierzeta) {
            info.append(zwierze.toString()).append("\n");
        }
        return info.toString();
    }

    public void sprzedajKury() {
        ArrayList<Zwierze> maleKury = new ArrayList<>();
        double masaSuma = 0;
        for (Zwierze kura : kury) {
            if (kura.getMasa() > 2.0) {
                masaSuma += kura.getMasa();
            } else {
                maleKury.add(kura);
            }
        }

        pieniadze += masaSuma * kuraZaKilogram;
        kury = maleKury;
    }

    @Override
    public String toString() {
        String info = "Iloœæ pieniêdzy: " + pieniadze + "\n ";
        info += getIloscKur() + " kur: \n";
        info += getZwierzetaInfo(getKury()) + "\n";

        info += getIloscKrow() + " krów: \n";
        info += getZwierzetaInfo(getKrowy());

        return info;
    }
}
