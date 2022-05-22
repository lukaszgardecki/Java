public class Main {
    public static void main(String[] args) {
        Samochod audi = new Samochod();
        audi.marka = "Audi";
        audi.iloscKol = 4;
        System.out.println(audi.iloscKol + " " + audi.marka);
        audi.odpal();

        audi.zamknijOtworz();
        audi.zamknijOtworz();

        SamochodSportowy subaru = new SamochodSportowy();
        subaru.odpal();

        Motocykl suzuki = new Motocykl();
        System.out.println(suzuki.iloscKol);

    }
}
