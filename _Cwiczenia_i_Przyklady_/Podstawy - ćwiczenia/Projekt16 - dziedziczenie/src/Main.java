public class Main {
    public static void main(String[] args) {
        System.out.println("Audi:");
        Samochod audi = new Samochod("Audi",4,2);
        audi.marka = "Audi";
        audi.iloscKol = 4;
//        System.out.println(audi.iloscKol + " " + audi.marka);
//        audi.odpal();
//        audi.zamknijOtworz();
//        audi.zamknijOtworz();

        System.out.println("\nSubaru:");
        SamochodSportowy subaru = new SamochodSportowy("Subaru",4,4);
//        subaru.odpal();
//
//        Motocykl suzuki = new Motocykl();
//        System.out.println(suzuki.iloscKol);

    }
}
