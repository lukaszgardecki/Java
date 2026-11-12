package wzorce.behawioralne.obserwator.Zadanie4.nadawcy;

import wzorce.behawioralne.obserwator.Zadanie4.obserwatorzy.Obserwator;

public interface Podmiot {
    void dodajObserwatora(Obserwator obserwator);
    void usunObserwatora(Obserwator obserwator);
    void powiadomObserwatorow(String zdarzenie);
}
