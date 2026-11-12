package wzorce.behawioralne.obserwator.Zadanie2.nadawcy;

import wzorce.behawioralne.obserwator.Zadanie2.obserwatorzy.Obserwator;

public interface Podmiot {
    void dodajObserwatora(Obserwator obserwator);
    void usunObserwatora(Obserwator obserwator);
    void powiadomObserwatorow(String tytul);
}
