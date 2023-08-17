package wzorce.wzorceZłożone;

public class SymulatorKaczek {
    public static void main(String[] args) {
        SymulatorKaczek symulator = new SymulatorKaczek();
        AbstrakcyjnaFabrykaKaczek kaczkaFabryka = new FabrykaKaczekZLicznikiem();
        symulator.uruchom(kaczkaFabryka);
    }

    private void uruchom(AbstrakcyjnaFabrykaKaczek kaczkaFabryka) {
        Kwacząca płaskonosKaczka = kaczkaFabryka.utwórzPłaskonosKaczka();
        Kwacząca wabikKaczka = kaczkaFabryka.utwórzWabikKaczka();
        Kwacząca gumowaKaczka = kaczkaFabryka.utwórzGumowaKaczka();
        Kwacząca gęśKaczka = kaczkaFabryka.utwórzGęśKaczka();

        System.out.println("\nSymulator Kaczek wykorzystujący wzorzec Fabryka Abstrakcyjna");

        Stado stadoKaczek = new Stado();
        stadoKaczek.dodaj(płaskonosKaczka);
        stadoKaczek.dodaj(wabikKaczka);
        stadoKaczek.dodaj(gumowaKaczka);
        stadoKaczek.dodaj(gęśKaczka);

        Stado stadoDzikichKaczek = new Stado();
        Kwacząca dzikakaczkaJeden = kaczkaFabryka.utwórzDzikaKaczka();
        Kwacząca dzikakaczkaDwa = kaczkaFabryka.utwórzDzikaKaczka();
        Kwacząca dzikakaczkaTrzy = kaczkaFabryka.utwórzDzikaKaczka();
        Kwacząca dzikakaczkaCztery = kaczkaFabryka.utwórzDzikaKaczka();
        stadoDzikichKaczek.dodaj(dzikakaczkaJeden);
        stadoDzikichKaczek.dodaj(dzikakaczkaDwa);
        stadoDzikichKaczek.dodaj(dzikakaczkaTrzy);
        stadoDzikichKaczek.dodaj(dzikakaczkaCztery);

        stadoKaczek.dodaj(stadoDzikichKaczek);

        Kwakolog kwakolog = new Kwakolog();
        stadoKaczek.zarejestrujObserwatora(kwakolog);

        System.out.println("\nSymulator kaczek: Symulacja całego stada");
        uruchom(stadoKaczek);

        System.out.println("Kaczki kwaknęły " + KwakLicznik.pobierzLiczbęKwaknięć() + " razy");
    }

    private void uruchom(Kwacząca kaczka) {
        kaczka.kwacz();
    }
}
