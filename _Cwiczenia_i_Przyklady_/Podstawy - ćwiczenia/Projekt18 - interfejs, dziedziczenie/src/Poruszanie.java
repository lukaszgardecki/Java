//interface jest już sam z siebie abstrakcyjny, interface jest czysto abstrakcyjny, ponieważ może posiadać metody tylko abstrakcyjnego, tzn nie możemy wpisać ciała metody więc po nawiasach okrągłych dajemy średnik; nie musimy pisać słowa abstract ponieważ ono się dopisuje samo ale jest niewidoczne.
// W interfejsie możemy przechowywać zmienne ale z założenia one są STATYCZNE i FINALNE (NIE MUSIMY TEGO PISAĆ NA POCZĄTKU ZMIENNEJ!!!).
// Do zmiennych musimy przypisać wartość!!
//można powiedzieć, że interfejsy są odmianami klas. interfejsy różnią się od klas i są trochę "ograniczone" w swoim działaniu


public interface Poruszanie {
    String nazwaInterfejsu = "Poruszanie";
    void jedzDoPrzodu();
    void skrecaj();
}
