package Tablice;

import java.sql.SQLOutput;
import java.util.SplittableRandom;

public class Ko³o {

    private double promien;
    private int id;
    private static int nextId;

    //Konstruktor ogólny
    public Ko³o() {
        this(1.0);
    }

    //Konstruktor z jednym parametrem
    public Ko³o(double r) {
        this(r, "coœ");
    }

    //Konstruktor z dwoma parametrami
    public Ko³o(double r, String j) {
        id = nextId;
        nextId++;
        this.promien = r;
        if (j.equals("km")) {
            promien = promien * 1000;
        }
    }

    //Utworzone konstruktory: bez parametru i z jednym parametrem równie¿ posiadaj¹ liczenie ID



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

    //metody statyczne nie potrzebuj¹ obiektów do dzia³ania, dzia³aj¹ jeszcze zanim zostanie utworzony nowy obiekt. Przyk³adem metody statycznej jest metoda Math.
    public static void main(String[] args) {
        //tworzê tablicê o klasie "Ko³o[]" i nazwie "maleKoleczka" i przypisujê jej nowy obiekt tablicowy klasy Ko³o, który zawiera 3 elementy "Ko³o[3]"
        Ko³o[] maleKoleczka = new Ko³o[3];

        maleKoleczka[0] = new Ko³o();
        maleKoleczka[1] = new Ko³o(5);
        maleKoleczka[2] = new Ko³o(2.6, "km");

        for (Ko³o x : maleKoleczka) {
            System.out.println("Id ko³a wynosi " + x.getId());
            System.out.println("Promieñ ko³a wynosi " + x.getPromien());
            System.out.println("Obwód ko³a wynosi " + x.obliczObwod());
            System.out.println("Pole ko³a wynosi " + x.obliczPole());
            System.out.println();
        }
    }


    static {
        nextId = 1;
    }
}
