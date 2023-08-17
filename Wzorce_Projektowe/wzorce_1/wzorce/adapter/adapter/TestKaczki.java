package wzorce.adapter.adapter;

public class TestKaczki {
    public static void main(String[] args) {
        DzikaKaczka kaczka = new DzikaKaczka();

        DzikiIndyk indyk = new DzikiIndyk();
        Kaczka indykAdapter = new IndykAadpter(indyk);

        System.out.println("--- Indyk powiada tak... ---");
        indyk.gulgocz();
        indyk.lataj();

        System.out.println("--- Kaczka powiada tak... ---");
        testujKaczkę(kaczka);

        System.out.println("--- IndykAdapter powiada tak... ---");
        testujKaczkę(indykAdapter);
    }

    static void testujKaczkę(Kaczka kaczka) {
        kaczka.kwacz();
        kaczka.lataj();
    }
}
