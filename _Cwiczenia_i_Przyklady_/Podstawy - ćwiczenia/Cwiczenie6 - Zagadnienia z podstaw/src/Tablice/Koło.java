package Tablice;

import java.sql.SQLOutput;
import java.util.SplittableRandom;

public class Ko�o {

    private double promien;
    private int id;
    private static int nextId;

    //Konstruktor og�lny
    public Ko�o() {
        this(1.0);
    }

    //Konstruktor z jednym parametrem
    public Ko�o(double r) {
        this(r, "co�");
    }

    //Konstruktor z dwoma parametrami
    public Ko�o(double r, String j) {
        id = nextId;
        nextId++;
        this.promien = r;
        if (j.equals("km")) {
            promien = promien * 1000;
        }
    }

    //Utworzone konstruktory: bez parametru i z jednym parametrem r�wnie� posiadaj� liczenie ID



    public void setPromien(double r) {
        this.promien = r;
    }

    public double getPromien() {
        return promien;
    }

    public int getId() {
        return id;
    }

    public double obliczObwod() {
        double obwod = 2 * Math.PI * promien;
        return obwod;
    }

    public double obliczPole() {
        double pole = Math.PI * promien * promien;
        return pole;
    }

    //metody statyczne nie potrzebuj� obiekt�w do dzia�ania, dzia�aj� jeszcze zanim zostanie utworzony nowy obiekt. Przyk�adem metody statycznej jest metoda Math.
    public static void main(String[] args) {
        //tworz� tablic� o klasie "Ko�o[]" i nazwie "maleKoleczka" i przypisuj� jej nowy obiekt tablicowy klasy Ko�o, kt�ry zawiera 3 elementy "Ko�o[3]"
        Ko�o[] maleKoleczka = new Ko�o[3];

        maleKoleczka[0] = new Ko�o();
        maleKoleczka[1] = new Ko�o(5);
        maleKoleczka[2] = new Ko�o(2.6, "km");

        for (Ko�o x : maleKoleczka) {
            System.out.println("Id ko�a wynosi " + x.getId());
            System.out.println("Promie� ko�a wynosi " + x.getPromien());
            System.out.println("Obw�d ko�a wynosi " + x.obliczObwod());
            System.out.println("Pole ko�a wynosi " + x.obliczPole());
            System.out.println();
        }
    }


    static {
        nextId = 1;
    }
}
