package wzorce.kreacyjne.fabryka.fabrykaabstrakcyjna;

public class ZadanieFabrykaAbstrakcyjna {
    public static void main(String[] args) {

        FabrykaZestawu fabrykaPsa = new ZestawDlaPsa();
        przetestujZestaw(fabrykaPsa);

        System.out.println("---");

        FabrykaZestawu fabrykaKota = new ZestawDlaKota();
        przetestujZestaw(fabrykaKota);
    }

    static void przetestujZestaw(FabrykaZestawu fabryka) {
        Zwierze zwierze = fabryka.utworzZwierze();
        Jedzenie jedzenie = fabryka.utworzJedzenie();

        zwierze.dajGlos();
        jedzenie.zjedz();
    }
}

// 1. Dwie różne rodziny produktów
interface Zwierze { void dajGlos(); }
interface Jedzenie { void zjedz(); }

// Produkty dla psa
class Pies implements Zwierze { public void dajGlos() { System.out.println("Hau!"); } }
class Kosc implements Jedzenie { public void zjedz() { System.out.println("Chrupię kość"); } }

// Produkty dla kota
class Kot implements Zwierze { public void dajGlos() { System.out.println("Miau!"); } }
class Ryba implements Jedzenie { public void zjedz() { System.out.println("Jem rybę"); } }

// 2. FABRYKA ABSTRAKCYJNA — ma więcej niż jedną metodę tworzącą!
interface FabrykaZestawu {
    Zwierze utworzZwierze();
    Jedzenie utworzJedzenie();
}

// 3. Konkretne fabryki tworzą spójne zestawy (rodziny obiektów)
class ZestawDlaPsa implements FabrykaZestawu {
    public Zwierze utworzZwierze() { return new Pies(); }
    public Jedzenie utworzJedzenie() { return new Kosc(); }
}

class ZestawDlaKota implements FabrykaZestawu {
    public Zwierze utworzZwierze() { return new Kot(); }
    public Jedzenie utworzJedzenie() { return new Ryba(); }
}
