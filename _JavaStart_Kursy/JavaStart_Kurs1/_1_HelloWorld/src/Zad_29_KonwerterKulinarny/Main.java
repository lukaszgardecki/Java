package Zad_29_KonwerterKulinarny;

class Main {
    public static void main(String[] args) {

        System.out.println(glassTOml(1.75));
        System.out.println(bigSpoonTOml(12));
        System.out.println(smallSpoonTOml(0.5));
    }

    static double glassTOml(double glasses) {
        return glasses * 250;
    }

    static double bigSpoonTOml(double spoons) {
        return spoons * 15;
    }

    static double smallSpoonTOml(double spoons) {
        return spoons * 5;
    }
}
